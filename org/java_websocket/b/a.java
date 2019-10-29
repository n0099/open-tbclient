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
    public boolean Hg(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Hh(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.cNQ() || framedata.cNR() || framedata.cNS()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.cNQ() + " RSV2: " + framedata.cNR() + " RSV3: " + framedata.cNS());
        }
    }

    @Override // org.java_websocket.b.b
    public String cNJ() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String cNK() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b cNL() {
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
