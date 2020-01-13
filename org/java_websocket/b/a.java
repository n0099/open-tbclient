package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean Sh(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Si(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.dMk() || framedata.dMl() || framedata.dMm()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dMk() + " RSV2: " + framedata.dMl() + " RSV3: " + framedata.dMm());
        }
    }

    @Override // org.java_websocket.b.b
    public String dMe() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dMf() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dMg() {
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
