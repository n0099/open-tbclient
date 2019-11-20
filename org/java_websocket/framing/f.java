package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kxe;
    private ByteBuffer kxf = org.java_websocket.e.b.cNW();
    private boolean kxd = true;
    private boolean kxg = false;
    private boolean kxh = false;
    private boolean kxi = false;
    private boolean kxj = false;

    public abstract void cNK() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kxe = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNO() {
        return this.kxh;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNP() {
        return this.kxi;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNQ() {
        return this.kxj;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNN() {
        return this.kxd;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cNR() {
        return this.kxe;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cNM() {
        return this.kxf;
    }

    public String toString() {
        return "Framedata{ optcode:" + cNR() + ", fin:" + cNN() + ", rsv1:" + cNO() + ", rsv2:" + cNP() + ", rsv3:" + cNQ() + ", payloadlength:[pos:" + this.kxf.position() + ", len:" + this.kxf.remaining() + "], payload:" + (this.kxf.remaining() > 1000 ? "(too big to display)" : new String(this.kxf.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kxf = byteBuffer;
    }

    public void sB(boolean z) {
        this.kxd = z;
    }

    public void sC(boolean z) {
        this.kxh = z;
    }

    public void sD(boolean z) {
        this.kxi = z;
    }

    public void sE(boolean z) {
        this.kxj = z;
    }

    public void sF(boolean z) {
        this.kxg = z;
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
        if (this.kxd == fVar.kxd && this.kxg == fVar.kxg && this.kxh == fVar.kxh && this.kxi == fVar.kxi && this.kxj == fVar.kxj && this.kxe == fVar.kxe) {
            if (this.kxf != null) {
                z = this.kxf.equals(fVar.kxf);
            } else if (fVar.kxf != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kxi ? 1 : 0) + (((this.kxh ? 1 : 0) + (((this.kxg ? 1 : 0) + (((this.kxf != null ? this.kxf.hashCode() : 0) + ((((this.kxd ? 1 : 0) * 31) + this.kxe.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kxj ? 1 : 0);
    }
}
