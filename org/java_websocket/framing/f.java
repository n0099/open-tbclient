package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode jTV;
    private ByteBuffer jTW = org.java_websocket.e.b.cDp();
    private boolean jTU = true;
    private boolean jTX = false;
    private boolean jTY = false;
    private boolean jTZ = false;
    private boolean jUa = false;

    public abstract void cDd() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.jTV = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDh() {
        return this.jTY;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDi() {
        return this.jTZ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDj() {
        return this.jUa;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDg() {
        return this.jTU;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cDk() {
        return this.jTV;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cDf() {
        return this.jTW;
    }

    public String toString() {
        return "Framedata{ optcode:" + cDk() + ", fin:" + cDg() + ", rsv1:" + cDh() + ", rsv2:" + cDi() + ", rsv3:" + cDj() + ", payloadlength:[pos:" + this.jTW.position() + ", len:" + this.jTW.remaining() + "], payload:" + (this.jTW.remaining() > 1000 ? "(too big to display)" : new String(this.jTW.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.jTW = byteBuffer;
    }

    public void rG(boolean z) {
        this.jTU = z;
    }

    public void rH(boolean z) {
        this.jTY = z;
    }

    public void rI(boolean z) {
        this.jTZ = z;
    }

    public void rJ(boolean z) {
        this.jUa = z;
    }

    public void rK(boolean z) {
        this.jTX = z;
    }

    public static f b(Framedata.Opcode opcode) {
        if (opcode == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (opcode) {
            case PING:
                return new g();
            case PONG:
                return new h();
            case TEXT:
                return new i();
            case BINARY:
                return new a();
            case CLOSING:
                return new b();
            case CONTINUOUS:
                return new c();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.jTU == fVar.jTU && this.jTX == fVar.jTX && this.jTY == fVar.jTY && this.jTZ == fVar.jTZ && this.jUa == fVar.jUa && this.jTV == fVar.jTV) {
            if (this.jTW != null) {
                z = this.jTW.equals(fVar.jTW);
            } else if (fVar.jTW != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.jTZ ? 1 : 0) + (((this.jTY ? 1 : 0) + (((this.jTX ? 1 : 0) + (((this.jTW != null ? this.jTW.hashCode() : 0) + ((((this.jTU ? 1 : 0) * 31) + this.jTV.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.jUa ? 1 : 0);
    }
}
