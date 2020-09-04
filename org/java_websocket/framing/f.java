package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oDg;
    private ByteBuffer oDh = org.java_websocket.e.b.ejJ();
    private boolean oDf = true;
    private boolean oDi = false;
    private boolean oDj = false;
    private boolean oDk = false;
    private boolean oDl = false;

    public abstract void ejy() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oDg = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ejB() {
        return this.oDj;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ejC() {
        return this.oDk;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ejD() {
        return this.oDl;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aeC() {
        return this.oDf;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ejE() {
        return this.oDg;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer ejA() {
        return this.oDh;
    }

    public String toString() {
        return "Framedata{ optcode:" + ejE() + ", fin:" + aeC() + ", rsv1:" + ejB() + ", rsv2:" + ejC() + ", rsv3:" + ejD() + ", payloadlength:[pos:" + this.oDh.position() + ", len:" + this.oDh.remaining() + "], payload:" + (this.oDh.remaining() > 1000 ? "(too big to display)" : new String(this.oDh.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.oDh = byteBuffer;
    }

    public void dL(boolean z) {
        this.oDf = z;
    }

    public void zb(boolean z) {
        this.oDj = z;
    }

    public void zc(boolean z) {
        this.oDk = z;
    }

    public void zd(boolean z) {
        this.oDl = z;
    }

    public void ze(boolean z) {
        this.oDi = z;
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
        if (this.oDf == fVar.oDf && this.oDi == fVar.oDi && this.oDj == fVar.oDj && this.oDk == fVar.oDk && this.oDl == fVar.oDl && this.oDg == fVar.oDg) {
            if (this.oDh != null) {
                z = this.oDh.equals(fVar.oDh);
            } else if (fVar.oDh != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oDk ? 1 : 0) + (((this.oDj ? 1 : 0) + (((this.oDi ? 1 : 0) + (((this.oDh != null ? this.oDh.hashCode() : 0) + ((((this.oDf ? 1 : 0) * 31) + this.oDg.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oDl ? 1 : 0);
    }
}
