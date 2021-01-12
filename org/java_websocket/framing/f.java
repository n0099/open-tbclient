package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qnd;
    private ByteBuffer qne = org.java_websocket.e.b.eKc();
    private boolean qnc = true;
    private boolean qnf = false;
    private boolean qng = false;
    private boolean qnh = false;
    private boolean qni = false;

    public abstract void eJR() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qnd = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJU() {
        return this.qng;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJV() {
        return this.qnh;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eJW() {
        return this.qni;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amk() {
        return this.qnc;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eJX() {
        return this.qnd;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eJT() {
        return this.qne;
    }

    public String toString() {
        return "Framedata{ optcode:" + eJX() + ", fin:" + amk() + ", rsv1:" + eJU() + ", rsv2:" + eJV() + ", rsv3:" + eJW() + ", payloadlength:[pos:" + this.qne.position() + ", len:" + this.qne.remaining() + "], payload:" + (this.qne.remaining() > 1000 ? "(too big to display)" : new String(this.qne.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qne = byteBuffer;
    }

    public void eY(boolean z) {
        this.qnc = z;
    }

    public void CF(boolean z) {
        this.qng = z;
    }

    public void CG(boolean z) {
        this.qnh = z;
    }

    public void CH(boolean z) {
        this.qni = z;
    }

    public void CI(boolean z) {
        this.qnf = z;
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
        if (this.qnc == fVar.qnc && this.qnf == fVar.qnf && this.qng == fVar.qng && this.qnh == fVar.qnh && this.qni == fVar.qni && this.qnd == fVar.qnd) {
            if (this.qne != null) {
                z = this.qne.equals(fVar.qne);
            } else if (fVar.qne != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qnh ? 1 : 0) + (((this.qng ? 1 : 0) + (((this.qnf ? 1 : 0) + (((this.qne != null ? this.qne.hashCode() : 0) + ((((this.qnc ? 1 : 0) * 31) + this.qnd.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qni ? 1 : 0);
    }
}
