package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kml;
    private ByteBuffer kmm = org.java_websocket.e.b.cKV();
    private boolean kmk = true;
    private boolean kmn = false;
    private boolean kmo = false;
    private boolean kmp = false;
    private boolean kmq = false;

    public abstract void cKJ() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kml = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKN() {
        return this.kmo;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKO() {
        return this.kmp;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKP() {
        return this.kmq;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cKM() {
        return this.kmk;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cKQ() {
        return this.kml;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cKL() {
        return this.kmm;
    }

    public String toString() {
        return "Framedata{ optcode:" + cKQ() + ", fin:" + cKM() + ", rsv1:" + cKN() + ", rsv2:" + cKO() + ", rsv3:" + cKP() + ", payloadlength:[pos:" + this.kmm.position() + ", len:" + this.kmm.remaining() + "], payload:" + (this.kmm.remaining() > 1000 ? "(too big to display)" : new String(this.kmm.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kmm = byteBuffer;
    }

    public void su(boolean z) {
        this.kmk = z;
    }

    public void sv(boolean z) {
        this.kmo = z;
    }

    public void sw(boolean z) {
        this.kmp = z;
    }

    public void sx(boolean z) {
        this.kmq = z;
    }

    public void sy(boolean z) {
        this.kmn = z;
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
        if (this.kmk == fVar.kmk && this.kmn == fVar.kmn && this.kmo == fVar.kmo && this.kmp == fVar.kmp && this.kmq == fVar.kmq && this.kml == fVar.kml) {
            if (this.kmm != null) {
                z = this.kmm.equals(fVar.kmm);
            } else if (fVar.kmm != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kmp ? 1 : 0) + (((this.kmo ? 1 : 0) + (((this.kmn ? 1 : 0) + (((this.kmm != null ? this.kmm.hashCode() : 0) + ((((this.kmk ? 1 : 0) * 31) + this.kml.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kmq ? 1 : 0);
    }
}
