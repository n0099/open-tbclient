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
    public boolean Iq(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Ir(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.cOC() || framedata.cOD() || framedata.cOE()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.cOC() + " RSV2: " + framedata.cOD() + " RSV3: " + framedata.cOE());
        }
    }

    @Override // org.java_websocket.b.b
    public String cOv() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String cOw() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b cOx() {
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
