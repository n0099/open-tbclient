package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes18.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qer;
    private ByteBuffer qes = org.java_websocket.e.b.eFg();
    private boolean qeq = true;
    private boolean qet = false;
    private boolean qeu = false;
    private boolean qev = false;
    private boolean qew = false;

    public abstract void eEV() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qer = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEY() {
        return this.qeu;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEZ() {
        return this.qev;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eFa() {
        return this.qew;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean alJ() {
        return this.qeq;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eFb() {
        return this.qer;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eEX() {
        return this.qes;
    }

    public String toString() {
        return "Framedata{ optcode:" + eFb() + ", fin:" + alJ() + ", rsv1:" + eEY() + ", rsv2:" + eEZ() + ", rsv3:" + eFa() + ", payloadlength:[pos:" + this.qes.position() + ", len:" + this.qes.remaining() + "], payload:" + (this.qes.remaining() > 1000 ? "(too big to display)" : new String(this.qes.array())) + '}';
    }

    public void B(ByteBuffer byteBuffer) {
        this.qes = byteBuffer;
    }

    public void eE(boolean z) {
        this.qeq = z;
    }

    public void Bq(boolean z) {
        this.qeu = z;
    }

    public void Br(boolean z) {
        this.qev = z;
    }

    public void Bs(boolean z) {
        this.qew = z;
    }

    public void Bt(boolean z) {
        this.qet = z;
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
        if (this.qeq == fVar.qeq && this.qet == fVar.qet && this.qeu == fVar.qeu && this.qev == fVar.qev && this.qew == fVar.qew && this.qer == fVar.qer) {
            if (this.qes != null) {
                z = this.qes.equals(fVar.qes);
            } else if (fVar.qes != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qev ? 1 : 0) + (((this.qeu ? 1 : 0) + (((this.qet ? 1 : 0) + (((this.qes != null ? this.qes.hashCode() : 0) + ((((this.qeq ? 1 : 0) * 31) + this.qer.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qew ? 1 : 0);
    }
}
