package g.b.g;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    b a();

    boolean b(String str);

    void c(Framedata framedata);

    String d();

    boolean e(String str);

    void f(Framedata framedata) throws InvalidDataException;

    String g();

    void h(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
