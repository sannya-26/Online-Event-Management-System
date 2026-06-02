<!DOCTYPE html>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <div class="card p-4">

        <h2>
            Book Tickets
        </h2>

        <input
                id="quantity"
                type="number"
                class="form-control mb-3"
                placeholder="Quantity">

        <button
                onclick="bookTicket()"
                class="btn btn-success">

            Confirm Booking

        </button>

    </div>

</div>

<script src="/js/booking.js"></script>

</body>
</html>