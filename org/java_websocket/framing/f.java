package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nMz;
    private ByteBuffer nMA = org.java_websocket.e.b.dNH();
    private boolean nMy = true;
    private boolean nMB = false;
    private boolean nMC = false;
    private boolean nMD = false;
    private boolean nME = false;

    public abstract void dNw() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nMz = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNz() {
        return this.nMC;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNA() {
        return this.nMD;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNB() {
        return this.nME;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Mn() {
        return this.nMy;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dNC() {
        return this.nMz;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dNy() {
        return this.nMA;
    }

    public String toString() {
        return "Framedata{ optcode:" + dNC() + ", fin:" + Mn() + ", rsv1:" + dNz() + ", rsv2:" + dNA() + ", rsv3:" + dNB() + ", payloadlength:[pos:" + this.nMA.position() + ", len:" + this.nMA.remaining() + "], payload:" + (this.nMA.remaining() > 1000 ? "(too big to display)" : new String(this.nMA.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nMA = byteBuffer;
    }

    public void cj(boolean z) {
        this.nMy = z;
    }

    public void wU(boolean z) {
        this.nMC = z;
    }

    public void wV(boolean z) {
        this.nMD = z;
    }

    public void wW(boolean z) {
        this.nME = z;
    }

    public void wX(boolean z) {
        this.nMB = z;
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
        if (this.nMy == fVar.nMy && this.nMB == fVar.nMB && this.nMC == fVar.nMC && this.nMD == fVar.nMD && this.nME == fVar.nME && this.nMz == fVar.nMz) {
            if (this.nMA != null) {
                z = this.nMA.equals(fVar.nMA);
            } else if (fVar.nMA != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nMD ? 1 : 0) + (((this.nMC ? 1 : 0) + (((this.nMB ? 1 : 0) + (((this.nMA != null ? this.nMA.hashCode() : 0) + ((((this.nMy ? 1 : 0) * 31) + this.nMz.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nME ? 1 : 0);
    }
}
