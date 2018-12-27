package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode iDy;
    private ByteBuffer iDz = org.java_websocket.e.b.cdA();
    private boolean iDx = true;
    private boolean iDA = false;
    private boolean iDB = false;
    private boolean iDC = false;
    private boolean iDD = false;

    public abstract void cdo() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.iDy = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cds() {
        return this.iDB;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cdt() {
        return this.iDC;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cdu() {
        return this.iDD;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cdr() {
        return this.iDx;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cdv() {
        return this.iDy;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cdq() {
        return this.iDz;
    }

    public String toString() {
        return "Framedata{ optcode:" + cdv() + ", fin:" + cdr() + ", rsv1:" + cds() + ", rsv2:" + cdt() + ", rsv3:" + cdu() + ", payloadlength:[pos:" + this.iDz.position() + ", len:" + this.iDz.remaining() + "], payload:" + (this.iDz.remaining() > 1000 ? "(too big to display)" : new String(this.iDz.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.iDz = byteBuffer;
    }

    public void pl(boolean z) {
        this.iDx = z;
    }

    public void pm(boolean z) {
        this.iDB = z;
    }

    public void pn(boolean z) {
        this.iDC = z;
    }

    public void po(boolean z) {
        this.iDD = z;
    }

    public void pp(boolean z) {
        this.iDA = z;
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
        if (this.iDx == fVar.iDx && this.iDA == fVar.iDA && this.iDB == fVar.iDB && this.iDC == fVar.iDC && this.iDD == fVar.iDD && this.iDy == fVar.iDy) {
            if (this.iDz != null) {
                z = this.iDz.equals(fVar.iDz);
            } else if (fVar.iDz != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iDC ? 1 : 0) + (((this.iDB ? 1 : 0) + (((this.iDA ? 1 : 0) + (((this.iDz != null ? this.iDz.hashCode() : 0) + ((((this.iDx ? 1 : 0) * 31) + this.iDy.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.iDD ? 1 : 0);
    }
}
