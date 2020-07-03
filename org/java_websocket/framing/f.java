package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oad;
    private ByteBuffer oae = org.java_websocket.e.b.dTV();
    private boolean oac = true;
    private boolean oaf = false;
    private boolean oag = false;
    private boolean oah = false;
    private boolean oai = false;

    public abstract void dTK() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oad = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTN() {
        return this.oag;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTO() {
        return this.oah;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dTP() {
        return this.oai;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean XQ() {
        return this.oac;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dTQ() {
        return this.oad;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dTM() {
        return this.oae;
    }

    public String toString() {
        return "Framedata{ optcode:" + dTQ() + ", fin:" + XQ() + ", rsv1:" + dTN() + ", rsv2:" + dTO() + ", rsv3:" + dTP() + ", payloadlength:[pos:" + this.oae.position() + ", len:" + this.oae.remaining() + "], payload:" + (this.oae.remaining() > 1000 ? "(too big to display)" : new String(this.oae.array())) + '}';
    }

    public void z(ByteBuffer byteBuffer) {
        this.oae = byteBuffer;
    }

    public void dy(boolean z) {
        this.oac = z;
    }

    public void xC(boolean z) {
        this.oag = z;
    }

    public void xD(boolean z) {
        this.oah = z;
    }

    public void xE(boolean z) {
        this.oai = z;
    }

    public void xF(boolean z) {
        this.oaf = z;
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
        if (this.oac == fVar.oac && this.oaf == fVar.oaf && this.oag == fVar.oag && this.oah == fVar.oah && this.oai == fVar.oai && this.oad == fVar.oad) {
            if (this.oae != null) {
                z = this.oae.equals(fVar.oae);
            } else if (fVar.oae != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oah ? 1 : 0) + (((this.oag ? 1 : 0) + (((this.oaf ? 1 : 0) + (((this.oae != null ? this.oae.hashCode() : 0) + ((((this.oac ? 1 : 0) * 31) + this.oad.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oai ? 1 : 0);
    }
}
