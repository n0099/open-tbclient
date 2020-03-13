package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nMM;
    private ByteBuffer nMN = org.java_websocket.e.b.dNK();
    private boolean nML = true;
    private boolean nMO = false;
    private boolean nMP = false;
    private boolean nMQ = false;
    private boolean nMR = false;

    public abstract void dNz() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nMM = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNC() {
        return this.nMP;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dND() {
        return this.nMQ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dNE() {
        return this.nMR;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Mp() {
        return this.nML;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dNF() {
        return this.nMM;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dNB() {
        return this.nMN;
    }

    public String toString() {
        return "Framedata{ optcode:" + dNF() + ", fin:" + Mp() + ", rsv1:" + dNC() + ", rsv2:" + dND() + ", rsv3:" + dNE() + ", payloadlength:[pos:" + this.nMN.position() + ", len:" + this.nMN.remaining() + "], payload:" + (this.nMN.remaining() > 1000 ? "(too big to display)" : new String(this.nMN.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nMN = byteBuffer;
    }

    public void cj(boolean z) {
        this.nML = z;
    }

    public void wU(boolean z) {
        this.nMP = z;
    }

    public void wV(boolean z) {
        this.nMQ = z;
    }

    public void wW(boolean z) {
        this.nMR = z;
    }

    public void wX(boolean z) {
        this.nMO = z;
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
        if (this.nML == fVar.nML && this.nMO == fVar.nMO && this.nMP == fVar.nMP && this.nMQ == fVar.nMQ && this.nMR == fVar.nMR && this.nMM == fVar.nMM) {
            if (this.nMN != null) {
                z = this.nMN.equals(fVar.nMN);
            } else if (fVar.nMN != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nMQ ? 1 : 0) + (((this.nMP ? 1 : 0) + (((this.nMO ? 1 : 0) + (((this.nMN != null ? this.nMN.hashCode() : 0) + ((((this.nML ? 1 : 0) * 31) + this.nMM.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nMR ? 1 : 0);
    }
}
