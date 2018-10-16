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
    public boolean za(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean zb(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.caZ() || framedata.cba() || framedata.cbb()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.caZ() + " RSV2: " + framedata.cba() + " RSV3: " + framedata.cbb());
        }
    }

    @Override // org.java_websocket.b.b
    public String caS() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String caT() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b caU() {
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
