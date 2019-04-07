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
    public boolean FU(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean FV(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.cDh() || framedata.cDi() || framedata.cDj()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.cDh() + " RSV2: " + framedata.cDi() + " RSV3: " + framedata.cDj());
        }
    }

    @Override // org.java_websocket.b.b
    public String cDa() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String cDb() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b cDc() {
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
