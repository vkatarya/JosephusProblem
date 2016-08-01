package com.josephus
import org.specs2.mutable._
import com.josephus.Josephus._

/**
  * Created by Vivek on 7/30/16.
  */
class Josephus_Test extends Specification {
  "Base Case Test #1" >> {
    "Checking for Base values" >> {
      josephusRecur(1, 1) must_== Some(1)
    }
  }

  "Base Case Test #2" >> {
    "Checking for Base values" >> {
      josephusRecur(10, 1) must_== Some(10)
    }
  }

  "Negative Test #1" >> {
    "Checking for Negative values" >> {
      josephusRecur(10, -1) must_== None
    }
  }

  "Negative Test #2" >> {
    "Checking for Negative values" >> {
      josephusRecur(-10, 1) must_== None
    }
  }

  "Standard Test #1" >> {
    "Checking for standard input" >> {
      josephusRecur(71, 17) must_== Some(64)
    }
  }

  "Standard Test #2" >> {
    "Checking for standard input" >> {
      josephusRecur(71, 93) must_== Some(21)
    }
  }

  "Standard Test #3" >> {
    "Checking for standard input" >> {
      josephusRecur(17, 17) must_== Some(12)
    }
  }

  "Standard Test #4" >> {
    "Checking for standard input" >> {
      josephusRecur(3, 2) must_== Some(3)
    }
  }

  "Standard Test #4" >> {
    "Checking for standard input" >> {
      josephusRecur(5, 9) must_== Some(2)
    }
  }

  "Iterative test #0" >> {
    "Using Iterative version" >> {
      josephusIter(10, 3) must_== Some(4)
    }
  }

  "Iterative test #1" >> {
    "Checking for large values" >> {
      josephusIter(711395, 93) must_== Some(552770)
    }
  }

  "Iterative test #2" >> {
    "Using Iterative version for large n and k = 2" >> {
      josephusIter(139542, 2) must_== Some(16941)
    }
  }

  "Iterative test #3" >> {
    "Using Iterative version for large n and k" >> {
      josephusIter(75139542, 31) must_== Some(28492811)
    }
  }
}
