package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nDi;
    private ByteBuffer nDj = org.java_websocket.e.b.dPb();
    private boolean nDh = true;
    private boolean nDk = false;
    private boolean nDl = false;
    private boolean nDm = false;
    private boolean nDn = false;

    public abstract void dOQ() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nDi = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOT() {
        return this.nDl;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOU() {
        return this.nDm;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dOV() {
        return this.nDn;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean WK() {
        return this.nDh;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dOW() {
        return this.nDi;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dOS() {
        return this.nDj;
    }

    public String toString() {
        return "Framedata{ optcode:" + dOW() + ", fin:" + WK() + ", rsv1:" + dOT() + ", rsv2:" + dOU() + ", rsv3:" + dOV() + ", payloadlength:[pos:" + this.nDj.position() + ", len:" + this.nDj.remaining() + "], payload:" + (this.nDj.remaining() > 1000 ? "(too big to display)" : new String(this.nDj.array())) + '}';
    }

    public void z(ByteBuffer byteBuffer) {
        this.nDj = byteBuffer;
    }

    public void dt(boolean z) {
        this.nDh = z;
    }

    public void xf(boolean z) {
        this.nDl = z;
    }

    public void xg(boolean z) {
        this.nDm = z;
    }

    public void xh(boolean z) {
        this.nDn = z;
    }

    public void xi(boolean z) {
        this.nDk = z;
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
        if (this.nDh == fVar.nDh && this.nDk == fVar.nDk && this.nDl == fVar.nDl && this.nDm == fVar.nDm && this.nDn == fVar.nDn && this.nDi == fVar.nDi) {
            if (this.nDj != null) {
                z = this.nDj.equals(fVar.nDj);
            } else if (fVar.nDj != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nDm ? 1 : 0) + (((this.nDl ? 1 : 0) + (((this.nDk ? 1 : 0) + (((this.nDj != null ? this.nDj.hashCode() : 0) + ((((this.nDh ? 1 : 0) * 31) + this.nDi.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nDn ? 1 : 0);
    }
}
