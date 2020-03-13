package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean St(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Su(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.dNC() || framedata.dND() || framedata.dNE()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dNC() + " RSV2: " + framedata.dND() + " RSV3: " + framedata.dNE());
        }
    }

    @Override // org.java_websocket.b.b
    public String dNw() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dNx() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dNy() {
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
