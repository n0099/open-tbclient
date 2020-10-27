package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public class a implements b {
    @Override // org.java_websocket.b.b
    public void c(Framedata framedata) throws InvalidDataException {
    }

    @Override // org.java_websocket.b.b
    public void d(Framedata framedata) {
    }

    @Override // org.java_websocket.b.b
    public boolean Zx(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Zy(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.eBi() || framedata.eBj() || framedata.eBk()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.eBi() + " RSV2: " + framedata.eBj() + " RSV3: " + framedata.eBk());
        }
    }

    @Override // org.java_websocket.b.b
    public String eBc() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String eBd() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b eBe() {
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
