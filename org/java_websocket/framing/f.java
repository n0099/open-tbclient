package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode jTU;
    private ByteBuffer jTV = org.java_websocket.e.b.cDp();
    private boolean jTT = true;
    private boolean jTW = false;
    private boolean jTX = false;
    private boolean jTY = false;
    private boolean jTZ = false;

    public abstract void cDd() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.jTU = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDh() {
        return this.jTX;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDi() {
        return this.jTY;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDj() {
        return this.jTZ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDg() {
        return this.jTT;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cDk() {
        return this.jTU;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cDf() {
        return this.jTV;
    }

    public String toString() {
        return "Framedata{ optcode:" + cDk() + ", fin:" + cDg() + ", rsv1:" + cDh() + ", rsv2:" + cDi() + ", rsv3:" + cDj() + ", payloadlength:[pos:" + this.jTV.position() + ", len:" + this.jTV.remaining() + "], payload:" + (this.jTV.remaining() > 1000 ? "(too big to display)" : new String(this.jTV.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.jTV = byteBuffer;
    }

    public void rG(boolean z) {
        this.jTT = z;
    }

    public void rH(boolean z) {
        this.jTX = z;
    }

    public void rI(boolean z) {
        this.jTY = z;
    }

    public void rJ(boolean z) {
        this.jTZ = z;
    }

    public void rK(boolean z) {
        this.jTW = z;
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
        if (this.jTT == fVar.jTT && this.jTW == fVar.jTW && this.jTX == fVar.jTX && this.jTY == fVar.jTY && this.jTZ == fVar.jTZ && this.jTU == fVar.jTU) {
            if (this.jTV != null) {
                z = this.jTV.equals(fVar.jTV);
            } else if (fVar.jTV != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.jTY ? 1 : 0) + (((this.jTX ? 1 : 0) + (((this.jTW ? 1 : 0) + (((this.jTV != null ? this.jTV.hashCode() : 0) + ((((this.jTT ? 1 : 0) * 31) + this.jTU.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.jTZ ? 1 : 0);
    }
}
