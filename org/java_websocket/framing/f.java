package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qne;
    private ByteBuffer qnf = org.java_websocket.e.b.eKc();
    private boolean qnd = true;
    private boolean qng = false;
    private boolean qnh = false;
    private boolean qni = false;
    private boolean qnj = false;

    public abstract void eJR() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qne = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJU() {
        return this.qnh;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJV() {
        return this.qni;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJW() {
        return this.qnj;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amk() {
        return this.qnd;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eJX() {
        return this.qne;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eJT() {
        return this.qnf;
    }

    public String toString() {
        return "Framedata{ optcode:" + eJX() + ", fin:" + amk() + ", rsv1:" + eJU() + ", rsv2:" + eJV() + ", rsv3:" + eJW() + ", payloadlength:[pos:" + this.qnf.position() + ", len:" + this.qnf.remaining() + "], payload:" + (this.qnf.remaining() > 1000 ? "(too big to display)" : new String(this.qnf.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qnf = byteBuffer;
    }

    public void eY(boolean z) {
        this.qnd = z;
    }

    public void CF(boolean z) {
        this.qnh = z;
    }

    public void CG(boolean z) {
        this.qni = z;
    }

    public void CH(boolean z) {
        this.qnj = z;
    }

    public void CI(boolean z) {
        this.qng = z;
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
        if (this.qnd == fVar.qnd && this.qng == fVar.qng && this.qnh == fVar.qnh && this.qni == fVar.qni && this.qnj == fVar.qnj && this.qne == fVar.qne) {
            if (this.qnf != null) {
                z = this.qnf.equals(fVar.qnf);
            } else if (fVar.qnf != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qni ? 1 : 0) + (((this.qnh ? 1 : 0) + (((this.qng ? 1 : 0) + (((this.qnf != null ? this.qnf.hashCode() : 0) + ((((this.qnd ? 1 : 0) * 31) + this.qne.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qnj ? 1 : 0);
    }
}
