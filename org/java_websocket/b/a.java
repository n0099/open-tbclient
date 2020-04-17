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
    public boolean PI(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean PJ(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.dHc() || framedata.dHd() || framedata.dHe()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dHc() + " RSV2: " + framedata.dHd() + " RSV3: " + framedata.dHe());
        }
    }

    @Override // org.java_websocket.b.b
    public String dGW() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dGX() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dGY() {
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
