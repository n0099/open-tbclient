package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean acu(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean acv(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eNK() || framedata.eNL() || framedata.eNM()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eNK() + " RSV2: " + framedata.eNL() + " RSV3: " + framedata.eNM());
        }
    }

    @Override // org.java_websocket.b.b
    public String eNE() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eNF() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eNG() {
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
