package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode pTu;
    private ByteBuffer pTv = org.java_websocket.e.b.eBq();
    private boolean pTt = true;
    private boolean pTw = false;
    private boolean pTx = false;
    private boolean pTy = false;
    private boolean pTz = false;

    public abstract void eBf() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.pTu = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eBi() {
        return this.pTx;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eBj() {
        return this.pTy;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eBk() {
        return this.pTz;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ajR() {
        return this.pTt;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eBl() {
        return this.pTu;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eBh() {
        return this.pTv;
    }

    public String toString() {
        return "Framedata{ optcode:" + eBl() + ", fin:" + ajR() + ", rsv1:" + eBi() + ", rsv2:" + eBj() + ", rsv3:" + eBk() + ", payloadlength:[pos:" + this.pTv.position() + ", len:" + this.pTv.remaining() + "], payload:" + (this.pTv.remaining() > 1000 ? "(too big to display)" : new String(this.pTv.array())) + '}';
    }

    public void B(ByteBuffer byteBuffer) {
        this.pTv = byteBuffer;
    }

    public void es(boolean z) {
        this.pTt = z;
    }

    public void AY(boolean z) {
        this.pTx = z;
    }

    public void AZ(boolean z) {
        this.pTy = z;
    }

    public void Ba(boolean z) {
        this.pTz = z;
    }

    public void Bb(boolean z) {
        this.pTw = z;
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
        if (this.pTt == fVar.pTt && this.pTw == fVar.pTw && this.pTx == fVar.pTx && this.pTy == fVar.pTy && this.pTz == fVar.pTz && this.pTu == fVar.pTu) {
            if (this.pTv != null) {
                z = this.pTv.equals(fVar.pTv);
            } else if (fVar.pTv != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pTy ? 1 : 0) + (((this.pTx ? 1 : 0) + (((this.pTw ? 1 : 0) + (((this.pTv != null ? this.pTv.hashCode() : 0) + ((((this.pTt ? 1 : 0) * 31) + this.pTu.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.pTz ? 1 : 0);
    }
}
