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
        if (framedata.dXn() || framedata.dXo() || framedata.dXp()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dXn() + " RSV2: " + framedata.dXo() + " RSV3: " + framedata.dXp());
        }
    }

    @Override // org.java_websocket.b.b
    public String dXh() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dXi() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dXj() {
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
