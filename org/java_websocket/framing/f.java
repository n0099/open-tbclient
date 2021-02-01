package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qxh;
    private ByteBuffer qxi = org.java_websocket.e.b.eMs();
    private boolean qxg = true;
    private boolean qxj = false;
    private boolean qxk = false;
    private boolean qxl = false;
    private boolean qxm = false;

    public abstract void eMh() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qxh = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMk() {
        return this.qxk;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMl() {
        return this.qxl;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMm() {
        return this.qxm;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amI() {
        return this.qxg;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eMn() {
        return this.qxh;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eMj() {
        return this.qxi;
    }

    public String toString() {
        return "Framedata{ optcode:" + eMn() + ", fin:" + amI() + ", rsv1:" + eMk() + ", rsv2:" + eMl() + ", rsv3:" + eMm() + ", payloadlength:[pos:" + this.qxi.position() + ", len:" + this.qxi.remaining() + "], payload:" + (this.qxi.remaining() > 1000 ? "(too big to display)" : new String(this.qxi.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qxi = byteBuffer;
    }

    public void fa(boolean z) {
        this.qxg = z;
    }

    public void CZ(boolean z) {
        this.qxk = z;
    }

    public void Da(boolean z) {
        this.qxl = z;
    }

    public void Db(boolean z) {
        this.qxm = z;
    }

    public void Dc(boolean z) {
        this.qxj = z;
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
        if (this.qxg == fVar.qxg && this.qxj == fVar.qxj && this.qxk == fVar.qxk && this.qxl == fVar.qxl && this.qxm == fVar.qxm && this.qxh == fVar.qxh) {
            if (this.qxi != null) {
                z = this.qxi.equals(fVar.qxi);
            } else if (fVar.qxi != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qxl ? 1 : 0) + (((this.qxk ? 1 : 0) + (((this.qxj ? 1 : 0) + (((this.qxi != null ? this.qxi.hashCode() : 0) + ((((this.qxg ? 1 : 0) * 31) + this.qxh.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qxm ? 1 : 0);
    }
}
