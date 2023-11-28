package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes10.dex */
public class DeflatedChunksSet {
    public final boolean aIG;
    public byte[] aIW;
    public int aIX;
    public int aIY;
    public int aIZ;
    public State aJa;
    public final boolean aJb;
    public d aJc;
    public long aJd = 0;
    public long aJe = 0;
    public int aJf = -1;
    public int aJg = -1;
    public final String aJh;
    public Inflater inf;

    public void Ik() {
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        this.aJa = State.WAITING_FOR_INPUT;
        this.aJh = str;
        this.aIG = z;
        this.aIY = i;
        if (i > 0 && i2 >= i) {
            if (inflater != null) {
                this.inf = inflater;
                this.aJb = false;
            } else {
                this.inf = new Inflater();
                this.aJb = true;
            }
            this.aIW = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
            this.aIZ = -1;
            this.aJa = State.WAITING_FOR_INPUT;
            try {
                dg(i);
                return;
            } catch (RuntimeException e) {
                close();
                throw e;
            }
        }
        throw new PngjException("bad inital row len " + i);
    }

    private boolean Ij() {
        State state;
        int i;
        try {
            if (this.aJa == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("invalid state"));
            }
            if (this.aJa.isDone()) {
                return false;
            }
            if (this.aIW == null || this.aIW.length < this.aIY) {
                this.aIW = new byte[this.aIY];
            }
            if (this.aIX < this.aIY && !this.inf.finished()) {
                try {
                    i = this.inf.inflate(this.aIW, this.aIX, this.aIY - this.aIX);
                } catch (DataFormatException e) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.aIX += i;
                this.aJe += i;
            }
            if (this.aIX == this.aIY) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.aIX > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.aJa = state;
            if (state != State.ROW_READY) {
                return false;
            }
            Ik();
            return true;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    public int Il() {
        throw new PngjException("not implemented");
    }

    public final void Im() {
        if (!isDone()) {
            this.aJa = State.DONE;
        }
    }

    public final int In() {
        return this.aIZ;
    }

    public void close() {
        try {
            if (!this.aJa.isClosed()) {
                this.aJa = State.CLOSED;
            }
            if (this.aJb && this.inf != null) {
                this.inf.end();
                this.inf = null;
            }
        } catch (Exception unused) {
        }
    }

    public final boolean isClosed() {
        return this.aJa.isClosed();
    }

    public final boolean isDone() {
        return this.aJa.isDone();
    }

    /* loaded from: classes10.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            if (this == CLOSED) {
                return true;
            }
            return false;
        }

        public final boolean isDone() {
            if (this != DONE && this != CLOSED) {
                return false;
            }
            return true;
        }
    }

    public final void a(d dVar) {
        if (!this.aJh.equals(dVar.HW().agT)) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.HW().agT + ", expected:" + this.aJh));
        }
        this.aJc = dVar;
        int i = this.aJf + 1;
        this.aJf = i;
        int i2 = this.aJg;
        if (i2 >= 0) {
            dVar.df(i + i2);
        }
    }

    public final void c(byte[] bArr, int i, int i2) {
        this.aJd += i2;
        if (i2 > 0 && !this.aJa.isDone()) {
            if (this.aJa == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
            }
            if (!this.inf.needsDictionary() && this.inf.needsInput()) {
                this.inf.setInput(bArr, i, i2);
                if (this.aIG) {
                    while (Ij()) {
                        dg(Il());
                        isDone();
                    }
                    return;
                }
                Ij();
                return;
            }
            throw new RuntimeException("should not happen");
        }
    }

    public final void dg(int i) {
        this.aIX = 0;
        this.aIZ++;
        if (i <= 0) {
            this.aIY = 0;
            Im();
        } else if (this.inf.finished()) {
            this.aIY = 0;
            Im();
        } else {
            this.aJa = State.WAITING_FOR_INPUT;
            this.aIY = i;
            if (!this.aIG) {
                Ij();
            }
        }
    }

    public final boolean fz(String str) {
        if (this.aJa.isClosed()) {
            return false;
        }
        if (str.equals(this.aJh)) {
            return true;
        }
        if (this.aJa.isDone()) {
            if (!this.aJa.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aJh + " set is not done");
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aJc.HW().agT + " state=" + this.aJa + " rows=" + this.aIZ + " bytes=" + this.aJd + "/" + this.aJe).toString();
    }
}
