package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode jUK;
    private ByteBuffer jUL = org.java_websocket.e.b.cDx();
    private boolean jUJ = true;
    private boolean jUM = false;
    private boolean jUN = false;
    private boolean jUO = false;
    private boolean jUP = false;

    public abstract void cDl() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.jUK = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDp() {
        return this.jUN;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDq() {
        return this.jUO;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDr() {
        return this.jUP;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDo() {
        return this.jUJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cDs() {
        return this.jUK;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cDn() {
        return this.jUL;
    }

    public String toString() {
        return "Framedata{ optcode:" + cDs() + ", fin:" + cDo() + ", rsv1:" + cDp() + ", rsv2:" + cDq() + ", rsv3:" + cDr() + ", payloadlength:[pos:" + this.jUL.position() + ", len:" + this.jUL.remaining() + "], payload:" + (this.jUL.remaining() > 1000 ? "(too big to display)" : new String(this.jUL.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.jUL = byteBuffer;
    }

    public void rG(boolean z) {
        this.jUJ = z;
    }

    public void rH(boolean z) {
        this.jUN = z;
    }

    public void rI(boolean z) {
        this.jUO = z;
    }

    public void rJ(boolean z) {
        this.jUP = z;
    }

    public void rK(boolean z) {
        this.jUM = z;
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
        if (this.jUJ == fVar.jUJ && this.jUM == fVar.jUM && this.jUN == fVar.jUN && this.jUO == fVar.jUO && this.jUP == fVar.jUP && this.jUK == fVar.jUK) {
            if (this.jUL != null) {
                z = this.jUL.equals(fVar.jUL);
            } else if (fVar.jUL != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.jUO ? 1 : 0) + (((this.jUN ? 1 : 0) + (((this.jUM ? 1 : 0) + (((this.jUL != null ? this.jUL.hashCode() : 0) + ((((this.jUJ ? 1 : 0) * 31) + this.jUK.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.jUP ? 1 : 0);
    }
}
