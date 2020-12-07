package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode pOt;
    private ByteBuffer pOu = org.java_websocket.e.b.eFf();
    private boolean pOs = true;
    private boolean pOv = false;
    private boolean pOw = false;
    private boolean pOx = false;
    private boolean pOy = false;

    public abstract void eEU() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.pOt = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEX() {
        return this.pOw;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEY() {
        return this.pOx;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEZ() {
        return this.pOy;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aoR() {
        return this.pOs;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eFa() {
        return this.pOt;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eEW() {
        return this.pOu;
    }

    public String toString() {
        return "Framedata{ optcode:" + eFa() + ", fin:" + aoR() + ", rsv1:" + eEX() + ", rsv2:" + eEY() + ", rsv3:" + eEZ() + ", payloadlength:[pos:" + this.pOu.position() + ", len:" + this.pOu.remaining() + "], payload:" + (this.pOu.remaining() > 1000 ? "(too big to display)" : new String(this.pOu.array())) + '}';
    }

    public void B(ByteBuffer byteBuffer) {
        this.pOu = byteBuffer;
    }

    public void eT(boolean z) {
        this.pOs = z;
    }

    public void Br(boolean z) {
        this.pOw = z;
    }

    public void Bs(boolean z) {
        this.pOx = z;
    }

    public void Bt(boolean z) {
        this.pOy = z;
    }

    public void Bu(boolean z) {
        this.pOv = z;
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
        if (this.pOs == fVar.pOs && this.pOv == fVar.pOv && this.pOw == fVar.pOw && this.pOx == fVar.pOx && this.pOy == fVar.pOy && this.pOt == fVar.pOt) {
            if (this.pOu != null) {
                z = this.pOu.equals(fVar.pOu);
            } else if (fVar.pOu != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pOx ? 1 : 0) + (((this.pOw ? 1 : 0) + (((this.pOv ? 1 : 0) + (((this.pOu != null ? this.pOu.hashCode() : 0) + ((((this.pOs ? 1 : 0) * 31) + this.pOt.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.pOy ? 1 : 0);
    }
}
