package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nOz;
    private ByteBuffer nOA = org.java_websocket.e.b.dOk();
    private boolean nOy = true;
    private boolean nOB = false;
    private boolean nOC = false;
    private boolean nOD = false;
    private boolean nOE = false;

    public abstract void dNZ() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nOz = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOc() {
        return this.nOC;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOd() {
        return this.nOD;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOe() {
        return this.nOE;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Ms() {
        return this.nOy;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dOf() {
        return this.nOz;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dOb() {
        return this.nOA;
    }

    public String toString() {
        return "Framedata{ optcode:" + dOf() + ", fin:" + Ms() + ", rsv1:" + dOc() + ", rsv2:" + dOd() + ", rsv3:" + dOe() + ", payloadlength:[pos:" + this.nOA.position() + ", len:" + this.nOA.remaining() + "], payload:" + (this.nOA.remaining() > 1000 ? "(too big to display)" : new String(this.nOA.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nOA = byteBuffer;
    }

    public void ck(boolean z) {
        this.nOy = z;
    }

    public void xc(boolean z) {
        this.nOC = z;
    }

    public void xd(boolean z) {
        this.nOD = z;
    }

    public void xe(boolean z) {
        this.nOE = z;
    }

    public void xf(boolean z) {
        this.nOB = z;
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
        if (this.nOy == fVar.nOy && this.nOB == fVar.nOB && this.nOC == fVar.nOC && this.nOD == fVar.nOD && this.nOE == fVar.nOE && this.nOz == fVar.nOz) {
            if (this.nOA != null) {
                z = this.nOA.equals(fVar.nOA);
            } else if (fVar.nOA != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nOD ? 1 : 0) + (((this.nOC ? 1 : 0) + (((this.nOB ? 1 : 0) + (((this.nOA != null ? this.nOA.hashCode() : 0) + ((((this.nOy ? 1 : 0) * 31) + this.nOz.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nOE ? 1 : 0);
    }
}
