package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode pOv;
    private ByteBuffer pOw = org.java_websocket.e.b.eFg();
    private boolean pOu = true;
    private boolean pOx = false;
    private boolean pOy = false;
    private boolean pOz = false;
    private boolean pOA = false;

    public abstract void eEV() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.pOv = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEY() {
        return this.pOy;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEZ() {
        return this.pOz;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eFa() {
        return this.pOA;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aoR() {
        return this.pOu;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eFb() {
        return this.pOv;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eEX() {
        return this.pOw;
    }

    public String toString() {
        return "Framedata{ optcode:" + eFb() + ", fin:" + aoR() + ", rsv1:" + eEY() + ", rsv2:" + eEZ() + ", rsv3:" + eFa() + ", payloadlength:[pos:" + this.pOw.position() + ", len:" + this.pOw.remaining() + "], payload:" + (this.pOw.remaining() > 1000 ? "(too big to display)" : new String(this.pOw.array())) + '}';
    }

    public void B(ByteBuffer byteBuffer) {
        this.pOw = byteBuffer;
    }

    public void eT(boolean z) {
        this.pOu = z;
    }

    public void Br(boolean z) {
        this.pOy = z;
    }

    public void Bs(boolean z) {
        this.pOz = z;
    }

    public void Bt(boolean z) {
        this.pOA = z;
    }

    public void Bu(boolean z) {
        this.pOx = z;
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
        if (this.pOu == fVar.pOu && this.pOx == fVar.pOx && this.pOy == fVar.pOy && this.pOz == fVar.pOz && this.pOA == fVar.pOA && this.pOv == fVar.pOv) {
            if (this.pOw != null) {
                z = this.pOw.equals(fVar.pOw);
            } else if (fVar.pOw != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pOz ? 1 : 0) + (((this.pOy ? 1 : 0) + (((this.pOx ? 1 : 0) + (((this.pOw != null ? this.pOw.hashCode() : 0) + ((((this.pOu ? 1 : 0) * 31) + this.pOv.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.pOA ? 1 : 0);
    }
}
