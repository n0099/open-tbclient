package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nMB;
    private ByteBuffer nMC = org.java_websocket.e.b.dNJ();
    private boolean nMA = true;
    private boolean nMD = false;
    private boolean nME = false;
    private boolean nMF = false;
    private boolean nMG = false;

    public abstract void dNy() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nMB = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNB() {
        return this.nME;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNC() {
        return this.nMF;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dND() {
        return this.nMG;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Mp() {
        return this.nMA;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dNE() {
        return this.nMB;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dNA() {
        return this.nMC;
    }

    public String toString() {
        return "Framedata{ optcode:" + dNE() + ", fin:" + Mp() + ", rsv1:" + dNB() + ", rsv2:" + dNC() + ", rsv3:" + dND() + ", payloadlength:[pos:" + this.nMC.position() + ", len:" + this.nMC.remaining() + "], payload:" + (this.nMC.remaining() > 1000 ? "(too big to display)" : new String(this.nMC.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nMC = byteBuffer;
    }

    public void cj(boolean z) {
        this.nMA = z;
    }

    public void wU(boolean z) {
        this.nME = z;
    }

    public void wV(boolean z) {
        this.nMF = z;
    }

    public void wW(boolean z) {
        this.nMG = z;
    }

    public void wX(boolean z) {
        this.nMD = z;
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
        if (this.nMA == fVar.nMA && this.nMD == fVar.nMD && this.nME == fVar.nME && this.nMF == fVar.nMF && this.nMG == fVar.nMG && this.nMB == fVar.nMB) {
            if (this.nMC != null) {
                z = this.nMC.equals(fVar.nMC);
            } else if (fVar.nMC != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nMF ? 1 : 0) + (((this.nME ? 1 : 0) + (((this.nMD ? 1 : 0) + (((this.nMC != null ? this.nMC.hashCode() : 0) + ((((this.nMA ? 1 : 0) * 31) + this.nMB.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nMG ? 1 : 0);
    }
}
