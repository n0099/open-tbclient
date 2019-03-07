package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode jUr;
    private ByteBuffer jUs = org.java_websocket.e.b.cDn();
    private boolean jUq = true;
    private boolean jUt = false;
    private boolean jUu = false;
    private boolean jUv = false;
    private boolean jUw = false;

    public abstract void cDb() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.jUr = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDf() {
        return this.jUu;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDg() {
        return this.jUv;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDh() {
        return this.jUw;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDe() {
        return this.jUq;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cDi() {
        return this.jUr;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cDd() {
        return this.jUs;
    }

    public String toString() {
        return "Framedata{ optcode:" + cDi() + ", fin:" + cDe() + ", rsv1:" + cDf() + ", rsv2:" + cDg() + ", rsv3:" + cDh() + ", payloadlength:[pos:" + this.jUs.position() + ", len:" + this.jUs.remaining() + "], payload:" + (this.jUs.remaining() > 1000 ? "(too big to display)" : new String(this.jUs.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.jUs = byteBuffer;
    }

    public void rG(boolean z) {
        this.jUq = z;
    }

    public void rH(boolean z) {
        this.jUu = z;
    }

    public void rI(boolean z) {
        this.jUv = z;
    }

    public void rJ(boolean z) {
        this.jUw = z;
    }

    public void rK(boolean z) {
        this.jUt = z;
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
        if (this.jUq == fVar.jUq && this.jUt == fVar.jUt && this.jUu == fVar.jUu && this.jUv == fVar.jUv && this.jUw == fVar.jUw && this.jUr == fVar.jUr) {
            if (this.jUs != null) {
                z = this.jUs.equals(fVar.jUs);
            } else if (fVar.jUs != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.jUv ? 1 : 0) + (((this.jUu ? 1 : 0) + (((this.jUt ? 1 : 0) + (((this.jUs != null ? this.jUs.hashCode() : 0) + ((((this.jUq ? 1 : 0) * 31) + this.jUr.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.jUw ? 1 : 0);
    }
}
