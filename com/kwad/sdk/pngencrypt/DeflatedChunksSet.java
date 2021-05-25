package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public class DeflatedChunksSet {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f33338a;

    /* renamed from: b  reason: collision with root package name */
    public State f33339b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33340c;

    /* renamed from: f  reason: collision with root package name */
    public final String f33343f;

    /* renamed from: g  reason: collision with root package name */
    public int f33344g;

    /* renamed from: h  reason: collision with root package name */
    public int f33345h;

    /* renamed from: i  reason: collision with root package name */
    public int f33346i;
    public Inflater j;
    public final boolean k;
    public d l;
    public long m = 0;
    public long n = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f33341d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f33342e = -1;

    /* loaded from: classes6.dex */
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

    public DeflatedChunksSet(String str, boolean z, int i2, int i3, Inflater inflater, byte[] bArr) {
        this.f33339b = State.WAITING_FOR_INPUT;
        this.f33343f = str;
        this.f33340c = z;
        this.f33345h = i2;
        boolean z2 = true;
        if (i2 < 1 || i3 < i2) {
            throw new PngjException("bad inital row len " + i2);
        }
        if (inflater != null) {
            this.j = inflater;
            z2 = false;
        } else {
            this.j = new Inflater();
        }
        this.k = z2;
        this.f33338a = (bArr == null || bArr.length < i2) ? new byte[i3] : bArr;
        this.f33346i = -1;
        this.f33339b = State.WAITING_FOR_INPUT;
        try {
            a(i2);
        } catch (RuntimeException e2) {
            f();
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: RuntimeException -> 0x0087, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0010, B:8:0x001a, B:10:0x001e, B:13:0x002b, B:15:0x0031, B:17:0x0039, B:21:0x0055, B:20:0x004a, B:22:0x0060, B:24:0x0066, B:32:0x007b, B:34:0x0081, B:25:0x0069, B:27:0x0071, B:28:0x0074, B:31:0x0079, B:12:0x0025), top: B:41:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        State state;
        int i2;
        try {
            if (this.f33339b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("invalid state"));
            }
            if (this.f33339b.isDone()) {
                return false;
            }
            if (this.f33338a == null || this.f33338a.length < this.f33345h) {
                this.f33338a = new byte[this.f33345h];
            }
            if (this.f33344g < this.f33345h && !this.j.finished()) {
                try {
                    i2 = this.j.inflate(this.f33338a, this.f33344g, this.f33345h - this.f33344g);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.d.a.a(new PngjException("error decompressing zlib stream ", e2));
                    i2 = 0;
                }
                this.f33344g += i2;
                this.n += i2;
            }
            if (this.f33344g != this.f33345h) {
                if (!this.j.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.f33344g <= 0) {
                    state = State.DONE;
                }
                this.f33339b = state;
                if (state != State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.f33339b = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e3) {
            f();
            throw e3;
        }
    }

    public void a() {
    }

    public void a(int i2) {
        this.f33344g = 0;
        this.f33346i++;
        if (i2 < 1 || this.j.finished()) {
            this.f33345h = 0;
            g();
            return;
        }
        this.f33339b = State.WAITING_FOR_INPUT;
        this.f33345h = i2;
        if (this.f33340c) {
            return;
        }
        i();
    }

    public void a(d dVar) {
        if (!this.f33343f.equals(dVar.a().f33398c)) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().f33398c + ", expected:" + this.f33343f));
        }
        this.l = dVar;
        int i2 = this.f33341d + 1;
        this.f33341d = i2;
        int i3 = this.f33342e;
        if (i3 >= 0) {
            dVar.a(i2 + i3);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.m += i3;
        if (i3 < 1 || this.f33339b.isDone()) {
            return;
        }
        if (this.f33339b == State.ROW_READY) {
            com.kwad.sdk.core.d.a.a(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.j.needsDictionary() || !this.j.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.j.setInput(bArr, i2, i3);
        if (!this.f33340c) {
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
        if (this.f33339b.isClosed()) {
            return false;
        }
        if (str.equals(this.f33343f) || b(str)) {
            return true;
        }
        if (this.f33339b.isDone()) {
            if (!this.f33339b.isClosed()) {
                f();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.f33343f + " set is not done");
    }

    public int b() {
        throw new PngjException("not implemented");
    }

    public boolean b(String str) {
        return false;
    }

    public void c() {
    }

    public boolean d() {
        return this.f33339b.isDone();
    }

    public boolean e() {
        return this.f33339b.isClosed();
    }

    public void f() {
        try {
            if (!this.f33339b.isClosed()) {
                this.f33339b = State.CLOSED;
            }
            if (!this.k || this.j == null) {
                return;
            }
            this.j.end();
            this.j = null;
        } catch (Exception unused) {
        }
    }

    public void g() {
        if (d()) {
            return;
        }
        this.f33339b = State.DONE;
    }

    public int h() {
        return this.f33346i;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.l.a().f33398c + " state=" + this.f33339b + " rows=" + this.f33346i + " bytes=" + this.m + "/" + this.n).toString();
    }
}
