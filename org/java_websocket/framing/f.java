package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kxn;
    private ByteBuffer kxo = org.java_websocket.e.b.cPR();
    private boolean kxm = true;
    private boolean kxp = false;
    private boolean kxq = false;
    private boolean kxr = false;
    private boolean kxs = false;

    public abstract void cPF() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kxn = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cPJ() {
        return this.kxq;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cPK() {
        return this.kxr;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cPL() {
        return this.kxs;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cPI() {
        return this.kxm;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cPM() {
        return this.kxn;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cPH() {
        return this.kxo;
    }

    public String toString() {
        return "Framedata{ optcode:" + cPM() + ", fin:" + cPI() + ", rsv1:" + cPJ() + ", rsv2:" + cPK() + ", rsv3:" + cPL() + ", payloadlength:[pos:" + this.kxo.position() + ", len:" + this.kxo.remaining() + "], payload:" + (this.kxo.remaining() > 1000 ? "(too big to display)" : new String(this.kxo.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kxo = byteBuffer;
    }

    public void sW(boolean z) {
        this.kxm = z;
    }

    public void sX(boolean z) {
        this.kxq = z;
    }

    public void sY(boolean z) {
        this.kxr = z;
    }

    public void sZ(boolean z) {
        this.kxs = z;
    }

    public void ta(boolean z) {
        this.kxp = z;
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
        if (this.kxm == fVar.kxm && this.kxp == fVar.kxp && this.kxq == fVar.kxq && this.kxr == fVar.kxr && this.kxs == fVar.kxs && this.kxn == fVar.kxn) {
            if (this.kxo != null) {
                z = this.kxo.equals(fVar.kxo);
            } else if (fVar.kxo != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kxr ? 1 : 0) + (((this.kxq ? 1 : 0) + (((this.kxp ? 1 : 0) + (((this.kxo != null ? this.kxo.hashCode() : 0) + ((((this.kxm ? 1 : 0) * 31) + this.kxn.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kxs ? 1 : 0);
    }
}
