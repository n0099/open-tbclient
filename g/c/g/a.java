package g.c.g;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public class a implements b {
    @Override // g.c.g.b
    public b a() {
        return new a();
    }

    @Override // g.c.g.b
    public boolean b(String str) {
        return true;
    }

    @Override // g.c.g.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // g.c.g.b
    public String d() {
        return "";
    }

    @Override // g.c.g.b
    public boolean e(String str) {
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass();
    }

    @Override // g.c.g.b
    public void f(Framedata framedata) {
    }

    @Override // g.c.g.b
    public void g(Framedata framedata) throws InvalidDataException {
        if (framedata.a() || framedata.b() || framedata.d()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.a() + " RSV2: " + framedata.b() + " RSV3: " + framedata.d());
        }
    }

    @Override // g.c.g.b
    public String h() {
        return "";
    }

    public int hashCode() {
        return a.class.hashCode();
    }

    @Override // g.c.g.b
    public void reset() {
    }

    @Override // g.c.g.b
    public String toString() {
        return a.class.getSimpleName();
    }
}
