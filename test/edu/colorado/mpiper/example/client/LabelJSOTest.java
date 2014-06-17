package edu.colorado.mpiper.example.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

import edu.colorado.mpiper.example.client.LabelJSO;

/**
 * Tests for {@link LabelJSO}. JUnit integration is provided by extending
 * {@link GWTTestCase}.
 * 
 * @see http://www.gwtproject.org/doc/latest/DevGuideTesting.html
 * @see http://www.gwtproject.org/doc/latest/tutorial/JUnit.html
 * @author Mark Piper (mark.piper@colorado.edu)
 */
public class LabelJSOTest extends GWTTestCase {

  private LabelJSO jso;
  private String owner;
  private String tag;
  private int id;
  private boolean selected;
  
  /**
   * The module that sources this class. Must be present.
   */
  @Override
  public String getModuleName() {
     return "edu.colorado.mpiper.example.GWTWebAppJUnit";
  }

  /**
   * A JSNI method that defines a fixture for the tests. Returns a
   * {@link LabelJSO} object for testing.
   * <p>
   * Note that "selected" member isn't present.
   * 
   * @param owner
   * @param tag
   * @param id
   * @return
   */
  private native LabelJSO testLabelJSO(String owner, String tag, int id) /*-{
		return {
		  "owner": owner,
		  "tag": tag,
		  "id": id
		  };
  }-*/;  
  
  @Before
  @Override
  protected void gwtSetUp() throws Exception {
    owner = "foo@bar.com";
    tag = "Test";
    id = 42;
    selected = true; // initially unused
    jso = testLabelJSO(owner, tag, id);
  }

  @After
  @Override
  protected void gwtTearDown() throws Exception {
  }

  /*
   * Test getting owner.
   */
  @Test
  public void testGetOwner() {
    assertEquals(owner, jso.getOwner());
  }

  /*
   * Test getting tag/label.
   */
  @Test
  public void testGetLabel() {
    assertEquals(tag, jso.getLabel());
  }

  /*
   * Test setting tag/label.
   */
  @Test
  public void testSetLabel() {
    String newLabel = "hoopy frood";
    jso.setLabel(newLabel);
    assertEquals(newLabel, jso.getLabel());
  }

  /*
   * Test getting id.
   */
  @Test
  public void testGetId() {
    assertEquals(id, jso.getId());
  }

  /*
   * Test setting id.
   */
  @Test
  public void testSetId() {
    int newId = 17;
    jso.setId(newId);
    assertEquals(newId, jso.getId());
  }

  /*
   * Test for an unset "selected" member -- the return from LabelJSO#isSelected
   * should be false. This is the default state, since "selected" isn't included
   * in a LabelJSO from the server; it's added later in the UI code.
   */
  @Test
  public void testGetSelectedUninitialized() {
    assertFalse(jso.isSelected());
  }

  /*
   * Test getting/setting "selected" member.
   */
  @Test
  public void testSetSelected() {
    jso.isSelected(selected);
    assertTrue(jso.isSelected());
  }
}
