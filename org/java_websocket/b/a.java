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
    public boolean aaz(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean aaA(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eEX() || framedata.eEY() || framedata.eEZ()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eEX() + " RSV2: " + framedata.eEY() + " RSV3: " + framedata.eEZ());
        }
    }

    @Override // org.java_websocket.b.b
    public String eER() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eES() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eET() {
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
