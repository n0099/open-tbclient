package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kmm;
    private ByteBuffer kmn = org.java_websocket.e.b.cKX();
    private boolean kml = true;
    private boolean kmo = false;
    private boolean kmp = false;
    private boolean kmq = false;
    private boolean kmr = false;

    public abstract void cKL() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kmm = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKP() {
        return this.kmp;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKQ() {
        return this.kmq;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKR() {
        return this.kmr;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKO() {
        return this.kml;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cKS() {
        return this.kmm;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cKN() {
        return this.kmn;
    }

    public String toString() {
        return "Framedata{ optcode:" + cKS() + ", fin:" + cKO() + ", rsv1:" + cKP() + ", rsv2:" + cKQ() + ", rsv3:" + cKR() + ", payloadlength:[pos:" + this.kmn.position() + ", len:" + this.kmn.remaining() + "], payload:" + (this.kmn.remaining() > 1000 ? "(too big to display)" : new String(this.kmn.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kmn = byteBuffer;
    }

    public void su(boolean z) {
        this.kml = z;
    }

    public void sv(boolean z) {
        this.kmp = z;
    }

    public void sw(boolean z) {
        this.kmq = z;
    }

    public void sx(boolean z) {
        this.kmr = z;
    }

    public void sy(boolean z) {
        this.kmo = z;
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
        if (this.kml == fVar.kml && this.kmo == fVar.kmo && this.kmp == fVar.kmp && this.kmq == fVar.kmq && this.kmr == fVar.kmr && this.kmm == fVar.kmm) {
            if (this.kmn != null) {
                z = this.kmn.equals(fVar.kmn);
            } else if (fVar.kmn != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kmq ? 1 : 0) + (((this.kmp ? 1 : 0) + (((this.kmo ? 1 : 0) + (((this.kmn != null ? this.kmn.hashCode() : 0) + ((((this.kml ? 1 : 0) * 31) + this.kmm.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kmr ? 1 : 0);
    }
}
