package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kmp;
    private ByteBuffer kmq = org.java_websocket.e.b.cKW();
    private boolean kmo = true;
    private boolean kmr = false;
    private boolean kms = false;
    private boolean kmt = false;
    private boolean kmu = false;

    public abstract void cKK() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kmp = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKO() {
        return this.kms;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKP() {
        return this.kmt;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKQ() {
        return this.kmu;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKN() {
        return this.kmo;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cKR() {
        return this.kmp;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cKM() {
        return this.kmq;
    }

    public String toString() {
        return "Framedata{ optcode:" + cKR() + ", fin:" + cKN() + ", rsv1:" + cKO() + ", rsv2:" + cKP() + ", rsv3:" + cKQ() + ", payloadlength:[pos:" + this.kmq.position() + ", len:" + this.kmq.remaining() + "], payload:" + (this.kmq.remaining() > 1000 ? "(too big to display)" : new String(this.kmq.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kmq = byteBuffer;
    }

    public void sv(boolean z) {
        this.kmo = z;
    }

    public void sw(boolean z) {
        this.kms = z;
    }

    public void sx(boolean z) {
        this.kmt = z;
    }

    public void sy(boolean z) {
        this.kmu = z;
    }

    public void sz(boolean z) {
        this.kmr = z;
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
        if (this.kmo == fVar.kmo && this.kmr == fVar.kmr && this.kms == fVar.kms && this.kmt == fVar.kmt && this.kmu == fVar.kmu && this.kmp == fVar.kmp) {
            if (this.kmq != null) {
                z = this.kmq.equals(fVar.kmq);
            } else if (fVar.kmq != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kmt ? 1 : 0) + (((this.kms ? 1 : 0) + (((this.kmr ? 1 : 0) + (((this.kmq != null ? this.kmq.hashCode() : 0) + ((((this.kmo ? 1 : 0) * 31) + this.kmp.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kmu ? 1 : 0);
    }
}
