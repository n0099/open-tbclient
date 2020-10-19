package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode pcb;
    private ByteBuffer pcc = org.java_websocket.e.b.ers();
    private boolean pca = true;
    private boolean pcd = false;
    private boolean pce = false;
    private boolean pcf = false;
    private boolean pcg = false;

    public abstract void erh() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.pcb = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean erk() {
        return this.pce;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean erl() {
        return this.pcf;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean erm() {
        return this.pcg;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ahX() {
        return this.pca;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ern() {
        return this.pcb;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer erj() {
        return this.pcc;
    }

    public String toString() {
        return "Framedata{ optcode:" + ern() + ", fin:" + ahX() + ", rsv1:" + erk() + ", rsv2:" + erl() + ", rsv3:" + erm() + ", payloadlength:[pos:" + this.pcc.position() + ", len:" + this.pcc.remaining() + "], payload:" + (this.pcc.remaining() > 1000 ? "(too big to display)" : new String(this.pcc.array())) + '}';
    }

    public void C(ByteBuffer byteBuffer) {
        this.pcc = byteBuffer;
    }

    public void ef(boolean z) {
        this.pca = z;
    }

    public void zQ(boolean z) {
        this.pce = z;
    }

    public void zR(boolean z) {
        this.pcf = z;
    }

    public void zS(boolean z) {
        this.pcg = z;
    }

    public void zT(boolean z) {
        this.pcd = z;
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
        if (this.pca == fVar.pca && this.pcd == fVar.pcd && this.pce == fVar.pce && this.pcf == fVar.pcf && this.pcg == fVar.pcg && this.pcb == fVar.pcb) {
            if (this.pcc != null) {
                z = this.pcc.equals(fVar.pcc);
            } else if (fVar.pcc != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pcf ? 1 : 0) + (((this.pce ? 1 : 0) + (((this.pcd ? 1 : 0) + (((this.pcc != null ? this.pcc.hashCode() : 0) + ((((this.pca ? 1 : 0) * 31) + this.pcb.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.pcg ? 1 : 0);
    }
}
