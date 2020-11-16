package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes18.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean ZM(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean ZN(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eEY() || framedata.eEZ() || framedata.eFa()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eEY() + " RSV2: " + framedata.eEZ() + " RSV3: " + framedata.eFa());
        }
    }

    @Override // org.java_websocket.b.b
    public String eES() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eET() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eEU() {
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
