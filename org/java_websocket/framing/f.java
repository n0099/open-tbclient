package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode jUC;
    private ByteBuffer jUD = org.java_websocket.e.b.cDA();
    private boolean jUB = true;
    private boolean jUE = false;
    private boolean jUF = false;
    private boolean jUG = false;
    private boolean jUH = false;

    public abstract void cDo() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.jUC = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDs() {
        return this.jUF;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDt() {
        return this.jUG;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDu() {
        return this.jUH;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cDr() {
        return this.jUB;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cDv() {
        return this.jUC;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cDq() {
        return this.jUD;
    }

    public String toString() {
        return "Framedata{ optcode:" + cDv() + ", fin:" + cDr() + ", rsv1:" + cDs() + ", rsv2:" + cDt() + ", rsv3:" + cDu() + ", payloadlength:[pos:" + this.jUD.position() + ", len:" + this.jUD.remaining() + "], payload:" + (this.jUD.remaining() > 1000 ? "(too big to display)" : new String(this.jUD.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.jUD = byteBuffer;
    }

    public void rG(boolean z) {
        this.jUB = z;
    }

    public void rH(boolean z) {
        this.jUF = z;
    }

    public void rI(boolean z) {
        this.jUG = z;
    }

    public void rJ(boolean z) {
        this.jUH = z;
    }

    public void rK(boolean z) {
        this.jUE = z;
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
        if (this.jUB == fVar.jUB && this.jUE == fVar.jUE && this.jUF == fVar.jUF && this.jUG == fVar.jUG && this.jUH == fVar.jUH && this.jUC == fVar.jUC) {
            if (this.jUD != null) {
                z = this.jUD.equals(fVar.jUD);
            } else if (fVar.jUD != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.jUG ? 1 : 0) + (((this.jUF ? 1 : 0) + (((this.jUE ? 1 : 0) + (((this.jUD != null ? this.jUD.hashCode() : 0) + ((((this.jUB ? 1 : 0) * 31) + this.jUC.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.jUH ? 1 : 0);
    }
}
