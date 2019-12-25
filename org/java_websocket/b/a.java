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
    public boolean Rm(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public boolean Rn(String str) {
        return true;
    }

    @Override // org.java_websocket.b.b
    public void e(Framedata framedata) throws InvalidDataException {
        if (framedata.dFJ() || framedata.dFK() || framedata.dFL()) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.dFJ() + " RSV2: " + framedata.dFK() + " RSV3: " + framedata.dFL());
        }
    }

    @Override // org.java_websocket.b.b
    public String dFD() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public String dFE() {
        return "";
    }

    @Override // org.java_websocket.b.b
    public b dFF() {
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
