
import React, { useEffect, useState } from "react";
import "./App.css";

function App() {

  const [sellers, setSellers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {

    fetch("http://sample-ecom.ap-south-1.elasticbeanstalk.com/seller/allSeller")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch sellers");
        }

        return response.json();
      })
      .then((data) => {
        setSellers(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error(error);
        setError("Unable to load sellers");
        setLoading(false);
      });

  }, []);

  if (loading) {
    return <h2>Loading sellers...</h2>;
  }

  if (error) {
    return <h2>{error}</h2>;
  }

  return (
    <div className="container">

      <h1>All Sellers</h1>

      {sellers.length === 0 ? (
        <p>No sellers found.</p>
      ) : (

        <div className="seller-container">

          {sellers.map((seller) => (

            <div className="seller-card" key={seller.id}>

              <h2>{seller.store_name}</h2>

              <p>
                <strong>Seller Name:</strong> {seller.name}
              </p>

              <p>
                <strong>Email:</strong> {seller.email}
              </p>

              <p>
                <strong>Contact:</strong> {seller.contact}
              </p>

              <p>
                <strong>Address:</strong> {seller.address}
              </p>

            </div>

          ))}

        </div>
      )}

    </div>
  );
}

export default App;
