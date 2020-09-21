package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes17.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean WW(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean WX(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eny() || framedata.enz() || framedata.enA()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eny() + " RSV2: " + framedata.enz() + " RSV3: " + framedata.enA());
        }
    }

    @Override // org.java_websocket.b.b
    public String ens() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String ent() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b enu() {
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
