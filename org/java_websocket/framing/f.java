package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oiS;
    private ByteBuffer oiT = org.java_websocket.e.b.dXw();
    private boolean oiR = true;
    private boolean oiU = false;
    private boolean oiV = false;
    private boolean oiW = false;
    private boolean oiX = false;

    public abstract void dXl() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oiS = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXo() {
        return this.oiV;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXp() {
        return this.oiW;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dXq() {
        return this.oiX;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Yw() {
        return this.oiR;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dXr() {
        return this.oiS;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dXn() {
        return this.oiT;
    }

    public String toString() {
        return "Framedata{ optcode:" + dXr() + ", fin:" + Yw() + ", rsv1:" + dXo() + ", rsv2:" + dXp() + ", rsv3:" + dXq() + ", payloadlength:[pos:" + this.oiT.position() + ", len:" + this.oiT.remaining() + "], payload:" + (this.oiT.remaining() > 1000 ? "(too big to display)" : new String(this.oiT.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.oiT = byteBuffer;
    }

    public void dB(boolean z) {
        this.oiR = z;
    }

    public void yh(boolean z) {
        this.oiV = z;
    }

    public void yi(boolean z) {
        this.oiW = z;
    }

    public void yj(boolean z) {
        this.oiX = z;
    }

    public void yk(boolean z) {
        this.oiU = z;
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
        if (this.oiR == fVar.oiR && this.oiU == fVar.oiU && this.oiV == fVar.oiV && this.oiW == fVar.oiW && this.oiX == fVar.oiX && this.oiS == fVar.oiS) {
            if (this.oiT != null) {
                z = this.oiT.equals(fVar.oiT);
            } else if (fVar.oiT != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oiW ? 1 : 0) + (((this.oiV ? 1 : 0) + (((this.oiU ? 1 : 0) + (((this.oiT != null ? this.oiT.hashCode() : 0) + ((((this.oiR ? 1 : 0) * 31) + this.oiS.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oiX ? 1 : 0);
    }
}
