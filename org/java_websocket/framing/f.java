package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oCO;
    private ByteBuffer oCP = org.java_websocket.e.b.ejA();
    private boolean oCN = true;
    private boolean oCQ = false;
    private boolean oCR = false;
    private boolean oCS = false;
    private boolean oCT = false;

    public abstract void ejp() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oCO = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ejs() {
        return this.oCR;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ejt() {
        return this.oCS;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eju() {
        return this.oCT;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aeC() {
        return this.oCN;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ejv() {
        return this.oCO;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer ejr() {
        return this.oCP;
    }

    public String toString() {
        return "Framedata{ optcode:" + ejv() + ", fin:" + aeC() + ", rsv1:" + ejs() + ", rsv2:" + ejt() + ", rsv3:" + eju() + ", payloadlength:[pos:" + this.oCP.position() + ", len:" + this.oCP.remaining() + "], payload:" + (this.oCP.remaining() > 1000 ? "(too big to display)" : new String(this.oCP.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.oCP = byteBuffer;
    }

    public void dK(boolean z) {
        this.oCN = z;
    }

    public void yZ(boolean z) {
        this.oCR = z;
    }

    public void za(boolean z) {
        this.oCS = z;
    }

    public void zb(boolean z) {
        this.oCT = z;
    }

    public void zc(boolean z) {
        this.oCQ = z;
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
        if (this.oCN == fVar.oCN && this.oCQ == fVar.oCQ && this.oCR == fVar.oCR && this.oCS == fVar.oCS && this.oCT == fVar.oCT && this.oCO == fVar.oCO) {
            if (this.oCP != null) {
                z = this.oCP.equals(fVar.oCP);
            } else if (fVar.oCP != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oCS ? 1 : 0) + (((this.oCR ? 1 : 0) + (((this.oCQ ? 1 : 0) + (((this.oCP != null ? this.oCP.hashCode() : 0) + ((((this.oCN ? 1 : 0) * 31) + this.oCO.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oCT ? 1 : 0);
    }
}
