$(document).ready( function () {
    $('#myTable').DataTable();
    $('#individualAnimal').DataTable({
        pageLength : 5,
        lengthMenu: [[5, 10, 25, -1], [5, 10, 25,50]]
    });
} );