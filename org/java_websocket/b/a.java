package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean XK(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean XL(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.erk() || framedata.erl() || framedata.erm()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.erk() + " RSV2: " + framedata.erl() + " RSV3: " + framedata.erm());
        }
    }

    @Override // org.java_websocket.b.b
    public String ere() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String erf() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b erg() {
        return new a();
    }

    @Override // org.java_websocket.b.b
    public void reset() {
    }

    @Override // org.java_websocket.b.b
    public String toString() {
        return getClass().getSimpleName();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }
}
