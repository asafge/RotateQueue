RotateQueue
===========

A java data structure implementing a queue with a bound size.

Usage
-----
New queue from serialized String: ```RotateQueue<String> q = new RotateQueue<String>(1000, "abc, def, ghi,");```

Add new elements: ```q.addElement("jkl");```

Search elements: ```q.searchElement("jkl"); --> true```

Serialize to String: ```q.ToString() --> "abc, def, ghi, jkl,"```
