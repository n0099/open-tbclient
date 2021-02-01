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
    public boolean aco(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean acp(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eMk() || framedata.eMl() || framedata.eMm()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eMk() + " RSV2: " + framedata.eMl() + " RSV3: " + framedata.eMm());
        }
    }

    @Override // org.java_websocket.b.b
    public String eMe() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eMf() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eMg() {
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
