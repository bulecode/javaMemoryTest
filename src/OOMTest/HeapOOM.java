package OOMTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证java堆内存OOM错误
 * vm 参数:  -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * Author: buleCode
 * Date: 2016/11/16
 */
public class HeapOOM {

    static class OOMObj {
    }

    public static void main(String[] args) {
        List<OOMObj> oomObjs = new ArrayList<>();

        while (true) {
            oomObjs.add(new OOMObj());
        }
    }

    //运行结果:
/*
    java.lang.OutOfMemoryError: Java heap space
    Dumping heap to java_pid6340.hprof ...
    Heap dump file created [13431136 bytes in 0.033 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at OOMTest.HeapOOM.main(HeapOOM.java:22)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
*/


}
