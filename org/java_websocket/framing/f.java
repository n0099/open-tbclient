package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode ite;
    private ByteBuffer itf = org.java_websocket.e.b.caE();
    private boolean itd = true;
    private boolean itg = false;
    private boolean ith = false;
    private boolean iti = false;
    private boolean itj = false;

    public abstract void cas() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.ite = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean caw() {
        return this.ith;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cax() {
        return this.iti;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cay() {
        return this.itj;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cav() {
        return this.itd;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode caz() {
        return this.ite;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cau() {
        return this.itf;
    }

    public String toString() {
        return "Framedata{ optcode:" + caz() + ", fin:" + cav() + ", rsv1:" + caw() + ", rsv2:" + cax() + ", rsv3:" + cay() + ", payloadlength:[pos:" + this.itf.position() + ", len:" + this.itf.remaining() + "], payload:" + (this.itf.remaining() > 1000 ? "(too big to display)" : new String(this.itf.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.itf = byteBuffer;
    }

    public void pg(boolean z) {
        this.itd = z;
    }

    public void ph(boolean z) {
        this.ith = z;
    }

    public void pi(boolean z) {
        this.iti = z;
    }

    public void pj(boolean z) {
        this.itj = z;
    }

    public void pk(boolean z) {
        this.itg = z;
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
        if (this.itd == fVar.itd && this.itg == fVar.itg && this.ith == fVar.ith && this.iti == fVar.iti && this.itj == fVar.itj && this.ite == fVar.ite) {
            if (this.itf != null) {
                z = this.itf.equals(fVar.itf);
            } else if (fVar.itf != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iti ? 1 : 0) + (((this.ith ? 1 : 0) + (((this.itg ? 1 : 0) + (((this.itf != null ? this.itf.hashCode() : 0) + ((((this.itd ? 1 : 0) * 31) + this.ite.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.itj ? 1 : 0);
    }
}
