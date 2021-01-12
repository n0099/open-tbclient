package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes4.dex */
public class DeflatedChunksSet {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f10487a;

    /* renamed from: b  reason: collision with root package name */
    State f10488b;
    protected final boolean c;
    public final String f;
    private int g;
    private int h;
    private int i;
    private Inflater j;
    private final boolean k;
    private d l;
    private long m = 0;
    private long n = 0;
    int d = -1;
    int e = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public boolean isClosed() {
            return this == CLOSED;
        }

        public boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        this.f10488b = State.WAITING_FOR_INPUT;
        this.f = str;
        this.c = z;
        this.h = i;
        if (i < 1 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.j = inflater;
            this.k = false;
        } else {
            this.j = new Inflater();
            this.k = true;
        }
        this.f10487a = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.i = -1;
        this.f10488b = State.WAITING_FOR_INPUT;
        try {
            a(i);
        } catch (RuntimeException e) {
            f();
            throw e;
        }
    }

    private boolean i() {
        int i;
        try {
            if (this.f10488b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("invalid state"));
            }
            if (this.f10488b.isDone()) {
                return false;
            }
            if (this.f10487a == null || this.f10487a.length < this.h) {
                this.f10487a = new byte[this.h];
            }
            if (this.g < this.h && !this.j.finished()) {
                try {
                    i = this.j.inflate(this.f10487a, this.g, this.h - this.g);
                } catch (DataFormatException e) {
                    com.kwad.sdk.core.d.a.a(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.g += i;
                this.n += i;
            }
            this.f10488b = this.g == this.h ? State.ROW_READY : !this.j.finished() ? State.WAITING_FOR_INPUT : this.g > 0 ? State.ROW_READY : State.DONE;
            if (this.f10488b == State.ROW_READY) {
                a();
                return true;
            }
            return false;
        } catch (RuntimeException e2) {
            f();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void a(int i) {
        this.g = 0;
        this.i++;
        if (i < 1) {
            this.h = 0;
            g();
        } else if (this.j.finished()) {
            this.h = 0;
            g();
        } else {
            this.f10488b = State.WAITING_FOR_INPUT;
            this.h = i;
            if (this.c) {
                return;
            }
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        if (!this.f.equals(dVar.a().c)) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().c + ", expected:" + this.f));
        }
        this.l = dVar;
        this.d++;
        if (this.e >= 0) {
            dVar.a(this.d + this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(byte[] bArr, int i, int i2) {
        this.m += i2;
        if (i2 < 1 || this.f10488b.isDone()) {
            return;
        }
        if (this.f10488b == State.ROW_READY) {
            com.kwad.sdk.core.d.a.a(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.j.needsDictionary() || !this.j.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.j.setInput(bArr, i, i2);
        if (!this.c) {
            i();
            return;
        }
        while (i()) {
            a(b());
            if (d()) {
                c();
            }
        }
    }

    public boolean a(String str) {
        if (this.f10488b.isClosed()) {
            return false;
        }
        if (!str.equals(this.f) && !b(str)) {
            if (this.f10488b.isDone()) {
                if (this.f10488b.isClosed()) {
                    return false;
                }
                f();
                return false;
            }
            throw new PngjException("Unexpected chunk " + str + " while " + this.f + " set is not done");
        }
        return true;
    }

    protected int b() {
        throw new PngjException("not implemented");
    }

    public boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    public boolean d() {
        return this.f10488b.isDone();
    }

    public boolean e() {
        return this.f10488b.isClosed();
    }

    public void f() {
        try {
            if (!this.f10488b.isClosed()) {
                this.f10488b = State.CLOSED;
            }
            if (!this.k || this.j == null) {
                return;
            }
            this.j.end();
            this.j = null;
        } catch (Exception e) {
        }
    }

    public void g() {
        if (d()) {
            return;
        }
        this.f10488b = State.DONE;
    }

    public int h() {
        return this.i;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.l.a().c + " state=" + this.f10488b + " rows=" + this.i + " bytes=" + this.m + "/" + this.n).toString();
    }
}
