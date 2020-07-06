package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oag;
    private ByteBuffer oah = org.java_websocket.e.b.dTZ();
    private boolean oaf = true;
    private boolean oai = false;
    private boolean oaj = false;
    private boolean oak = false;
    private boolean oal = false;

    public abstract void dTO() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oag = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTR() {
        return this.oaj;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTS() {
        return this.oak;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTT() {
        return this.oal;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean XQ() {
        return this.oaf;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dTU() {
        return this.oag;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dTQ() {
        return this.oah;
    }

    public String toString() {
        return "Framedata{ optcode:" + dTU() + ", fin:" + XQ() + ", rsv1:" + dTR() + ", rsv2:" + dTS() + ", rsv3:" + dTT() + ", payloadlength:[pos:" + this.oah.position() + ", len:" + this.oah.remaining() + "], payload:" + (this.oah.remaining() > 1000 ? "(too big to display)" : new String(this.oah.array())) + '}';
    }

    public void z(ByteBuffer byteBuffer) {
        this.oah = byteBuffer;
    }

    public void dy(boolean z) {
        this.oaf = z;
    }

    public void xC(boolean z) {
        this.oaj = z;
    }

    public void xD(boolean z) {
        this.oak = z;
    }

    public void xE(boolean z) {
        this.oal = z;
    }

    public void xF(boolean z) {
        this.oai = z;
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
        if (this.oaf == fVar.oaf && this.oai == fVar.oai && this.oaj == fVar.oaj && this.oak == fVar.oak && this.oal == fVar.oal && this.oag == fVar.oag) {
            if (this.oah != null) {
                z = this.oah.equals(fVar.oah);
            } else if (fVar.oah != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oak ? 1 : 0) + (((this.oaj ? 1 : 0) + (((this.oai ? 1 : 0) + (((this.oah != null ? this.oah.hashCode() : 0) + ((((this.oaf ? 1 : 0) * 31) + this.oag.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oal ? 1 : 0);
    }
}
