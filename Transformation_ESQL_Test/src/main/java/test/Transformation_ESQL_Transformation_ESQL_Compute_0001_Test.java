package test;

import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Transformation_ESQL_Transformation_ESQL_Compute_0001_Test {

	/*
	 * Transformation_ESQL_Transformation_ESQL_Compute_0001_Test
	 * Test generated by IBM App Connect Enterprise Toolkit 12.0.8.0 on May 26, 2023 12:23:39 PM
	 */

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}

	@Test
	public void Transformation_ESQL_Transformation_ESQL_Compute_TestCase_001() throws TestException {

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("Transformation_ESQL")
				.messageFlow("Transformation_ESQL").node("Compute");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/Transformation_ESQL_Compute_0001_2cfa24fb-ae96-4ffb-aa1b-6ea318e0b004_input_data.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		// Compare Output Message 1 at output terminal out

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/Transformation_ESQL_Compute_0001_999f355a-3d79-420b-b8ef-f27075a84c12_output_data.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}

	@Test
	public void Transformation_ESQL_Transformation_ESQL_Compute_TestCase_002() throws TestException {

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("Transformation_ESQL")
				.messageFlow("Transformation_ESQL").node("Compute");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/emptyBody.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		// Compare Output Message 1 at output terminal out

		TestMessageAssembly actualMessageAssembly = null;
		// Get the TestMessageAssembly object for the actual propagated message
		actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);
		assertEquals("400", actualMessageAssembly.localEnvironmentPath("Destination.HTTP.ReplyStatusCode").getValueAsString());
	}
}
