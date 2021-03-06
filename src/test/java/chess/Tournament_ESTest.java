/*
 * This file was automatically generated by EvoSuite
 * Fri Apr 27 14:57:47 GMT 2018
 */

package chess;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import chess.Game;
import chess.Player;
import chess.Round;
import chess.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Tournament_ESTest extends Tournament_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Player[] playerArray0 = new Player[9];
      Player player0 = new Player("0oCuzC#s7Rj)", "WI'Zv!0LC\n[LY Wl}", 871.0F);
      playerArray0[0] = player0;
      Player player1 = new Player("WI'Zv!0LC\n[LY Wl}", "0oCuzC#s7Rj) WI'Zv!0LC\n[LY Wl}", (-2313.8F));
      playerArray0[1] = player1;
      player0.score = 0.5;
      // Undeclared exception!
      try { 
        Tournament.insertionsortOnScore(playerArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("", "", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      Round round0 = new Round();
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.computeNewRatings();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("]:", "NPI${HFQ3", 0.0F);
      linkedList0.addLast(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      Game game0 = new Game(player0, player0, 0.0);
      tournament0.addResult(game0);
      assertEquals(1.0, player0.score, 0.01);
      assertEquals(1, player0.losses);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "chess.Game", 0.0F);
      linkedList0.offer(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      tournament0.computeNewRatings();
      tournament0.printTournamentReportToCsvFile((String) null);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("", "", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      tournament0.computeNewRatings();
      tournament0.printTournamentReport();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("", "", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      double[][] doubleArray0 = tournament0.getResultMatrix();
      assertEquals(1, doubleArray0.length);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("\" ", (String) null, (-2261.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      Player[] playerArray0 = tournament0.getPlayersStanding();
      assertEquals(1, playerArray0.length);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile(".\\null.csv");
      FileSystemHandling.shouldThrowIOException(evoSuiteFile0);
      Tournament tournament0 = new Tournament(linkedList0);
      try { 
        tournament0.printTournamentReportToCsvFile((String) null);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         //
         // Simulated IOException
         //
         verifyException("org.evosuite.runtime.vfs.VirtualFileSystem", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile(".\\c{AO.%ZgcM[~");
      FileSystemHandling.appendStringToFile(evoSuiteFile0, "");
      try { 
        tournament0.printTournamentReportToCsvFile("c{AO.%ZgcM[~/_n<8g");
        fail("Expecting exception: FileNotFoundException");
      
      } catch(FileNotFoundException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.evosuite.runtime.mock.java.io.MockFileOutputStream", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      linkedList0.add((Player) null);
      linkedList0.addFirst((Player) null);
      Tournament tournament0 = new Tournament(linkedList0);
      // Undeclared exception!
      try { 
        tournament0.computePlayerStanding();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      Player player0 = new Player("chess.Round", "chess.Round", 0);
      linkedList0.add(0, player0);
      // Undeclared exception!
      try { 
        tournament0.computePlayerStanding();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 0
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      linkedList0.add((Player) null);
      // Undeclared exception!
      try { 
        tournament0.computeNewRatings();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      Game game0 = new Game((Player) null, (Player) null, (-723.04719192988));
      // Undeclared exception!
      try { 
        tournament0.addResult(game0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Tournament tournament0 = null;
      try {
        tournament0 = new Tournament((List<Player>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Player[] playerArray0 = new Player[1];
      Tournament.insertionsortOnScore(playerArray0);
      assertEquals(1, playerArray0.length);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      tournament0.computePlayerStanding();
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      tournament0.computePlayerStanding();
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Player player0 = new Player("*g4<,2`QN40e1D(bT", "*g4<,2`QN40e1D(bT", (-170.2635F));
      Player[] playerArray0 = new Player[6];
      Player player1 = new Player("*g4<,2`QN40e1D(bT", "*g4<,2`QN40e1D(bT", 0);
      playerArray0[0] = player1;
      player0.score = 1435.7552399243907;
      playerArray0[1] = player1;
      playerArray0[2] = player0;
      // Undeclared exception!
      try { 
        Tournament.insertionsortOnScore(playerArray0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      // Undeclared exception!
      try { 
        tournament0.printTournamentReportToCsvFile("kVm(r~Sc(0)t5");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      // Undeclared exception!
      try { 
        tournament0.printTournamentReport();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("", "", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      Round round0 = new Round();
      Game game0 = new Game(player0, player0, 14.8470903478);
      round0.addGame(game0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.computeNewRatings();
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      linkedList0.add(player0);
      Tournament tournament0 = new Tournament(linkedList0);
      Round round0 = new Round();
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.addRound(round0);
      tournament0.computeNewRatings();
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      Tournament tournament0 = new Tournament(linkedList0);
      Round round0 = new Round();
      Game game0 = new Game(player0, player0, 0.82);
      round0.addGame(game0);
      tournament0.addRound(round0);
      // Undeclared exception!
      try { 
        tournament0.computeNewRatings();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Player player0 = new Player("|cp2NtZJi}V14Eu)Ukg", "|cp2NtZJi}V14Eu)Ukg", (-4623.1694F));
      Tournament tournament0 = new Tournament(linkedList0);
      Game game0 = new Game(player0, player0, 0.82);
      game0.result = (double) 0;
      // Undeclared exception!
      try { 
        tournament0.addResult(game0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      Player player0 = new Player("", "", 1.0F);
      Game game0 = new Game(player0, player0, 1.0);
      // Undeclared exception!
      try { 
        tournament0.addResult(game0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         verifyException("chess.Tournament", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      Player[] playerArray0 = tournament0.getPlayersStanding();
      assertEquals(0, playerArray0.length);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      LinkedList<Player> linkedList0 = new LinkedList<Player>();
      Tournament tournament0 = new Tournament(linkedList0);
      // Undeclared exception!
      try { 
        tournament0.getResultMatrix();
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 0
         //
         verifyException("chess.Tournament", e);
      }
  }
}
