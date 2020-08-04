package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean Tq(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Tr(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.dXo() || framedata.dXp() || framedata.dXq()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dXo() + " RSV2: " + framedata.dXp() + " RSV3: " + framedata.dXq());
        }
    }

    @Override // org.java_websocket.b.b
    public String dXi() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dXj() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dXk() {
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
