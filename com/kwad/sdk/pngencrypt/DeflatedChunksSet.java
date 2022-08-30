package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes7.dex */
public class DeflatedChunksSet {
    public final boolean ajQ;
    public byte[] akg;
    public int akh;
    public int aki;
    public int akj;
    public State akk;
    public final boolean akl;
    public d akm;
    public long akn = 0;
    public long ako = 0;
    public int akp = -1;
    public int akq = -1;
    public final String akr;
    public Inflater inf;

    /* loaded from: classes7.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        boolean z2;
        this.akk = State.WAITING_FOR_INPUT;
        this.akr = str;
        this.ajQ = z;
        this.aki = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.inf = inflater;
            z2 = false;
        } else {
            this.inf = new Inflater();
            z2 = true;
        }
        this.akl = z2;
        this.akg = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.akj = -1;
        this.akk = State.WAITING_FOR_INPUT;
        try {
            bh(i);
        } catch (RuntimeException e) {
            close();
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: RuntimeException -> 0x0087, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0010, B:8:0x001a, B:10:0x001e, B:13:0x002b, B:15:0x0031, B:17:0x0039, B:21:0x0055, B:20:0x004a, B:22:0x0060, B:24:0x0066, B:32:0x007b, B:34:0x0081, B:25:0x0069, B:27:0x0071, B:28:0x0074, B:31:0x0079, B:12:0x0025), top: B:41:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean yg() {
        State state;
        int i;
        try {
            if (this.akk == State.ROW_READY) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("invalid state"));
            }
            if (this.akk.isDone()) {
                return false;
            }
            if (this.akg == null || this.akg.length < this.aki) {
                this.akg = new byte[this.aki];
            }
            if (this.akh < this.aki && !this.inf.finished()) {
                try {
                    i = this.inf.inflate(this.akg, this.akh, this.aki - this.akh);
                } catch (DataFormatException e) {
                    com.kwad.sdk.core.e.b.printStackTrace(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.akh += i;
                this.ako += i;
            }
            if (this.akh != this.aki) {
                if (!this.inf.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.akh <= 0) {
                    state = State.DONE;
                }
                this.akk = state;
                if (state != State.ROW_READY) {
                    yh();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.akk = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    public final void a(d dVar) {
        if (!this.akr.equals(dVar.xT().alB)) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.xT().alB + ", expected:" + this.akr));
        }
        this.akm = dVar;
        int i = this.akp + 1;
        this.akp = i;
        int i2 = this.akq;
        if (i2 >= 0) {
            dVar.bg(i + i2);
        }
    }

    public final void bh(int i) {
        this.akh = 0;
        this.akj++;
        if (i <= 0 || this.inf.finished()) {
            this.aki = 0;
            yj();
            return;
        }
        this.akk = State.WAITING_FOR_INPUT;
        this.aki = i;
        if (this.ajQ) {
            return;
        }
        yg();
    }

    public final void c(byte[] bArr, int i, int i2) {
        this.akn += i2;
        if (i2 <= 0 || this.akk.isDone()) {
            return;
        }
        if (this.akk == State.ROW_READY) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i, i2);
        if (!this.ajQ) {
            yg();
            return;
        }
        while (yg()) {
            bh(yi());
            isDone();
        }
    }

    public void close() {
        try {
            if (!this.akk.isClosed()) {
                this.akk = State.CLOSED;
            }
            if (!this.akl || this.inf == null) {
                return;
            }
            this.inf.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final boolean dp(String str) {
        if (this.akk.isClosed()) {
            return false;
        }
        if (str.equals(this.akr)) {
            return true;
        }
        if (this.akk.isDone()) {
            if (!this.akk.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.akr + " set is not done");
    }

    public final boolean isClosed() {
        return this.akk.isClosed();
    }

    public final boolean isDone() {
        return this.akk.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.akm.xT().alB + " state=" + this.akk + " rows=" + this.akj + " bytes=" + this.akn + "/" + this.ako).toString();
    }

    public void yh() {
    }

    public int yi() {
        throw new PngjException("not implemented");
    }

    public final void yj() {
        if (isDone()) {
            return;
        }
        this.akk = State.DONE;
    }

    public final int yk() {
        return this.akj;
    }
}
