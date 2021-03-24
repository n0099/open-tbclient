package g.c.g;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public interface b {
    b a();

    boolean b(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String d();

    boolean e(String str);

    void f(Framedata framedata);

    void g(Framedata framedata) throws InvalidDataException;

    String h();

    void reset();

    String toString();
}
