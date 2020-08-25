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
    public boolean Wu(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Wv(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.ejs() || framedata.ejt() || framedata.eju()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.ejs() + " RSV2: " + framedata.ejt() + " RSV3: " + framedata.eju());
        }
    }

    @Override // org.java_websocket.b.b
    public String ejm() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String ejn() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b ejo() {
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
