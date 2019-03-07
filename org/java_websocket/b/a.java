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
    public boolean Ge(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Gf(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.cDf() || framedata.cDg() || framedata.cDh()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.cDf() + " RSV2: " + framedata.cDg() + " RSV3: " + framedata.cDh());
        }
    }

    @Override // org.java_websocket.b.b
    public String cCY() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String cCZ() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b cDa() {
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
