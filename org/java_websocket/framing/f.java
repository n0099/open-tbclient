package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode iAo;
    private ByteBuffer iAp = org.java_websocket.e.b.ccK();
    private boolean iAn = true;
    private boolean iAq = false;
    private boolean iAr = false;
    private boolean iAs = false;
    private boolean iAt = false;

    public abstract void ccy() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.iAo = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ccC() {
        return this.iAr;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ccD() {
        return this.iAs;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ccE() {
        return this.iAt;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ccB() {
        return this.iAn;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ccF() {
        return this.iAo;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer ccA() {
        return this.iAp;
    }

    public String toString() {
        return "Framedata{ optcode:" + ccF() + ", fin:" + ccB() + ", rsv1:" + ccC() + ", rsv2:" + ccD() + ", rsv3:" + ccE() + ", payloadlength:[pos:" + this.iAp.position() + ", len:" + this.iAp.remaining() + "], payload:" + (this.iAp.remaining() > 1000 ? "(too big to display)" : new String(this.iAp.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.iAp = byteBuffer;
    }

    public void pi(boolean z) {
        this.iAn = z;
    }

    public void pj(boolean z) {
        this.iAr = z;
    }

    public void pk(boolean z) {
        this.iAs = z;
    }

    public void pl(boolean z) {
        this.iAt = z;
    }

    public void pm(boolean z) {
        this.iAq = z;
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
        if (this.iAn == fVar.iAn && this.iAq == fVar.iAq && this.iAr == fVar.iAr && this.iAs == fVar.iAs && this.iAt == fVar.iAt && this.iAo == fVar.iAo) {
            if (this.iAp != null) {
                z = this.iAp.equals(fVar.iAp);
            } else if (fVar.iAp != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iAs ? 1 : 0) + (((this.iAr ? 1 : 0) + (((this.iAq ? 1 : 0) + (((this.iAp != null ? this.iAp.hashCode() : 0) + ((((this.iAn ? 1 : 0) * 31) + this.iAo.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.iAt ? 1 : 0);
    }
}
