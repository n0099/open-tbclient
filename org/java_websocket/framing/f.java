package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nEs;
    private ByteBuffer nEt = org.java_websocket.e.b.dPp();
    private boolean nEr = true;
    private boolean nEu = false;
    private boolean nEv = false;
    private boolean nEw = false;
    private boolean nEx = false;

    public abstract void dPe() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nEs = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dPh() {
        return this.nEv;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dPi() {
        return this.nEw;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dPj() {
        return this.nEx;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean WK() {
        return this.nEr;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dPk() {
        return this.nEs;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dPg() {
        return this.nEt;
    }

    public String toString() {
        return "Framedata{ optcode:" + dPk() + ", fin:" + WK() + ", rsv1:" + dPh() + ", rsv2:" + dPi() + ", rsv3:" + dPj() + ", payloadlength:[pos:" + this.nEt.position() + ", len:" + this.nEt.remaining() + "], payload:" + (this.nEt.remaining() > 1000 ? "(too big to display)" : new String(this.nEt.array())) + '}';
    }

    public void z(ByteBuffer byteBuffer) {
        this.nEt = byteBuffer;
    }

    public void dt(boolean z) {
        this.nEr = z;
    }

    public void xh(boolean z) {
        this.nEv = z;
    }

    public void xi(boolean z) {
        this.nEw = z;
    }

    public void xj(boolean z) {
        this.nEx = z;
    }

    public void xk(boolean z) {
        this.nEu = z;
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
        if (this.nEr == fVar.nEr && this.nEu == fVar.nEu && this.nEv == fVar.nEv && this.nEw == fVar.nEw && this.nEx == fVar.nEx && this.nEs == fVar.nEs) {
            if (this.nEt != null) {
                z = this.nEt.equals(fVar.nEt);
            } else if (fVar.nEt != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nEw ? 1 : 0) + (((this.nEv ? 1 : 0) + (((this.nEu ? 1 : 0) + (((this.nEt != null ? this.nEt.hashCode() : 0) + ((((this.nEr ? 1 : 0) * 31) + this.nEs.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nEx ? 1 : 0);
    }
}
