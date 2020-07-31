package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oiQ;
    private ByteBuffer oiR = org.java_websocket.e.b.dXv();
    private boolean oiP = true;
    private boolean oiS = false;
    private boolean oiT = false;
    private boolean oiU = false;
    private boolean oiV = false;

    public abstract void dXk() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oiQ = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXn() {
        return this.oiT;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXo() {
        return this.oiU;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXp() {
        return this.oiV;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Yw() {
        return this.oiP;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dXq() {
        return this.oiQ;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dXm() {
        return this.oiR;
    }

    public String toString() {
        return "Framedata{ optcode:" + dXq() + ", fin:" + Yw() + ", rsv1:" + dXn() + ", rsv2:" + dXo() + ", rsv3:" + dXp() + ", payloadlength:[pos:" + this.oiR.position() + ", len:" + this.oiR.remaining() + "], payload:" + (this.oiR.remaining() > 1000 ? "(too big to display)" : new String(this.oiR.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.oiR = byteBuffer;
    }

    public void dB(boolean z) {
        this.oiP = z;
    }

    public void yh(boolean z) {
        this.oiT = z;
    }

    public void yi(boolean z) {
        this.oiU = z;
    }

    public void yj(boolean z) {
        this.oiV = z;
    }

    public void yk(boolean z) {
        this.oiS = z;
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
        if (this.oiP == fVar.oiP && this.oiS == fVar.oiS && this.oiT == fVar.oiT && this.oiU == fVar.oiU && this.oiV == fVar.oiV && this.oiQ == fVar.oiQ) {
            if (this.oiR != null) {
                z = this.oiR.equals(fVar.oiR);
            } else if (fVar.oiR != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oiU ? 1 : 0) + (((this.oiT ? 1 : 0) + (((this.oiS ? 1 : 0) + (((this.oiR != null ? this.oiR.hashCode() : 0) + ((((this.oiP ? 1 : 0) * 31) + this.oiQ.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oiV ? 1 : 0);
    }
}
