package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qyj;
    private ByteBuffer qyk = org.java_websocket.e.b.eMi();
    private boolean qyi = true;
    private boolean qyl = false;
    private boolean qym = false;
    private boolean qyn = false;
    private boolean qyo = false;

    public abstract void eLX() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qyj = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMa() {
        return this.qym;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMb() {
        return this.qyn;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMc() {
        return this.qyo;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amL() {
        return this.qyi;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eMd() {
        return this.qyj;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eLZ() {
        return this.qyk;
    }

    public String toString() {
        return "Framedata{ optcode:" + eMd() + ", fin:" + amL() + ", rsv1:" + eMa() + ", rsv2:" + eMb() + ", rsv3:" + eMc() + ", payloadlength:[pos:" + this.qyk.position() + ", len:" + this.qyk.remaining() + "], payload:" + (this.qyk.remaining() > 1000 ? "(too big to display)" : new String(this.qyk.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qyk = byteBuffer;
    }

    public void fa(boolean z) {
        this.qyi = z;
    }

    public void CV(boolean z) {
        this.qym = z;
    }

    public void CW(boolean z) {
        this.qyn = z;
    }

    public void CX(boolean z) {
        this.qyo = z;
    }

    public void CY(boolean z) {
        this.qyl = z;
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
        if (this.qyi == fVar.qyi && this.qyl == fVar.qyl && this.qym == fVar.qym && this.qyn == fVar.qyn && this.qyo == fVar.qyo && this.qyj == fVar.qyj) {
            if (this.qyk != null) {
                z = this.qyk.equals(fVar.qyk);
            } else if (fVar.qyk != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qyn ? 1 : 0) + (((this.qym ? 1 : 0) + (((this.qyl ? 1 : 0) + (((this.qyk != null ? this.qyk.hashCode() : 0) + ((((this.qyi ? 1 : 0) * 31) + this.qyj.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qyo ? 1 : 0);
    }
}
