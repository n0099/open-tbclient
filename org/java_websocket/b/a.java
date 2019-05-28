package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean Hm(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Hn(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.cKP() || framedata.cKQ() || framedata.cKR()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.cKP() + " RSV2: " + framedata.cKQ() + " RSV3: " + framedata.cKR());
        }
    }

    @Override // org.java_websocket.b.b
    public String cKI() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String cKJ() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b cKK() {
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
