# hungarian

This project contains an implementation of the Hungarian algorithm, modified from http://konstantinosnedas.com/dev/soft/munkres.htm, as well as simple Clojure bindings.

## Usage

The Java class may be used in a standalone manner, by calling its static methods.  Remove the `package` statement if you remove the file from the original folder structure.  The two primary methods are `hgAlgorithmAssignments` and `hgAlgorithm`.  They both accept the same arguments (a matrix of weights, and a String specifying whether to minimize or maximize the total assignment weight).  The input matrix may be rectangular, but the number of assignments made will be the minimum of the matrix width and height.

`hgAlgorithmAssignments` returns a 2D array with all of the assignments.  Each entry in the array has the assignment row index in column 0 and the assignment column index in column 1.  Example assignment array (from a 4x3 matrix): `{{0,0}, {1,2}, {3,1}`.

`hgAlgorithm` returns the sum of the assigned weights instead of the assignment array by compositing `hgAlgorithmAssignments` and `getAssignmentSum`.

There is a main method in HungarianAlgorithm.java that has a few test cases.

## License

The original author released the code at http://konstantinosnedas.com/dev/soft/munkres.htm with the notice:

"You may freely redistribute this source code, as long as the comments in the headers of the source files—with the exception of sections in brackets— remain unaltered.  This code is provided on an "AS-IS" basis, without any warranties, and you use it entirely at your own risk."

This modified and extended version is released under the same terms.
