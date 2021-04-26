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
    public void c(Framedata framedata) {
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
    public void f(Framedata framedata) throws InvalidDataException {
    }

    @Override // g.c.g.b
    public String g() {
        return "";
    }

    @Override // g.c.g.b
    public void h(Framedata framedata) throws InvalidDataException {
        if (framedata.b() || framedata.c() || framedata.e()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.b() + " RSV2: " + framedata.c() + " RSV3: " + framedata.e());
        }
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
