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
    public boolean abm(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean abn(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eJU() || framedata.eJV() || framedata.eJW()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eJU() + " RSV2: " + framedata.eJV() + " RSV3: " + framedata.eJW());
        }
    }

    @Override // org.java_websocket.b.b
    public String eJO() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eJP() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eJQ() {
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
