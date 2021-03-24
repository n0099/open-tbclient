package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class b implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public int f38932b;

    /* renamed from: c  reason: collision with root package name */
    public long f38933c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f38934d;

    /* renamed from: e  reason: collision with root package name */
    public long f38935e;

    /* renamed from: f  reason: collision with root package name */
    public long f38936f;

    /* renamed from: g  reason: collision with root package name */
    public int f38937g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f38938h;
    public long i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public d.o.a.e.b.k.b o;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38931a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* loaded from: classes7.dex */
    public static class a implements Parcelable.Creator<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0502b {

        /* renamed from: a  reason: collision with root package name */
        public int f38939a;

        /* renamed from: b  reason: collision with root package name */
        public long f38940b;

        /* renamed from: c  reason: collision with root package name */
        public long f38941c;

        /* renamed from: d  reason: collision with root package name */
        public long f38942d;

        /* renamed from: e  reason: collision with root package name */
        public long f38943e;

        /* renamed from: f  reason: collision with root package name */
        public int f38944f;

        /* renamed from: g  reason: collision with root package name */
        public long f38945g;

        /* renamed from: h  reason: collision with root package name */
        public b f38946h;

        public C0502b(int i) {
            this.f38939a = i;
        }

        public C0502b b(int i) {
            this.f38944f = i;
            return this;
        }

        public C0502b c(long j) {
            this.f38940b = j;
            return this;
        }

        public C0502b d(b bVar) {
            this.f38946h = bVar;
            return this;
        }

        public b e() {
            return new b(this, null);
        }

        public C0502b g(long j) {
            this.f38941c = j;
            return this;
        }

        public C0502b i(long j) {
            this.f38942d = j;
            return this;
        }

        public C0502b k(long j) {
            this.f38943e = j;
            return this;
        }

        public C0502b m(long j) {
            this.f38945g = j;
            return this;
        }
    }

    public /* synthetic */ b(C0502b c0502b, a aVar) {
        this(c0502b);
    }

    public long A() {
        if (q() && s()) {
            long j = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    if (!bVar.v()) {
                        return bVar.z();
                    }
                    if (j < bVar.z()) {
                        j = bVar.z();
                    }
                }
            }
            return j;
        }
        return z();
    }

    public long B() {
        long A = A() - this.f38933c;
        if (s()) {
            A = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    A += bVar.A() - bVar.y();
                }
            }
        }
        return A;
    }

    public long C() {
        return this.f38935e;
    }

    public long D() {
        return this.f38936f;
    }

    public void E() {
        this.i = A();
    }

    public int F() {
        return this.f38937g;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f38932b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f38937g));
        contentValues.put("startOffset", Long.valueOf(this.f38933c));
        contentValues.put("curOffset", Long.valueOf(A()));
        contentValues.put("endOffset", Long.valueOf(this.f38935e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f38936f));
        contentValues.put("hostChunkIndex", Integer.valueOf(j()));
        return contentValues;
    }

    public List<b> b(int i, long j) {
        b bVar;
        long C;
        long j2;
        long j3;
        long j4;
        long j5;
        b bVar2 = this;
        int i2 = i;
        if (!q() || s()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long z = z();
        long n = bVar2.n(true);
        long j6 = n / i2;
        d.o.a.e.b.c.a.g(f38931a, "retainLen:" + n + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f38937g);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j3 = y();
                j2 = (z + j6) - 1;
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long C2 = C();
                    j4 = C2 > z ? (C2 - z) + 1 : n - (i4 * j6);
                    j5 = C2;
                    j3 = z;
                    C0502b c0502b = new C0502b(bVar2.f38932b);
                    c0502b.b((-i3) - 1);
                    c0502b.c(j3);
                    c0502b.g(z);
                    c0502b.m(z);
                    long j7 = j5;
                    c0502b.i(j7);
                    c0502b.k(j4);
                    c0502b.d(bVar2);
                    b e2 = c0502b.e();
                    d.o.a.e.b.c.a.g(f38931a, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j7 + " contentLen:" + j4);
                    arrayList.add(e2);
                    z += j6;
                    i3++;
                    bVar2 = this;
                    i2 = i;
                    n = n;
                } else {
                    j2 = (z + j6) - 1;
                    j3 = z;
                }
            }
            j4 = j6;
            j5 = j2;
            C0502b c0502b2 = new C0502b(bVar2.f38932b);
            c0502b2.b((-i3) - 1);
            c0502b2.c(j3);
            c0502b2.g(z);
            c0502b2.m(z);
            long j72 = j5;
            c0502b2.i(j72);
            c0502b2.k(j4);
            c0502b2.d(bVar2);
            b e22 = c0502b2.e();
            d.o.a.e.b.c.a.g(f38931a, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j72 + " contentLen:" + j4);
            arrayList.add(e22);
            z += j6;
            i3++;
            bVar2 = this;
            i2 = i;
            n = n;
        }
        long j8 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j8 += bVar3.D();
            }
        }
        d.o.a.e.b.c.a.g(f38931a, "reuseChunkContentLen:" + j8);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (C() == 0) {
                C = j - y();
            } else {
                C = (C() - y()) + 1;
            }
            bVar4.d(C - j8);
            bVar = this;
            bVar4.o(bVar.f38937g);
            d.o.a.e.b.k.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.b(bVar4.C(), D() - j8);
            }
        } else {
            bVar = this;
        }
        bVar.h(arrayList);
        return arrayList;
    }

    public void c(int i) {
        AtomicInteger atomicInteger = this.f38938h;
        if (atomicInteger == null) {
            this.f38938h = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void d(long j) {
        this.f38936f = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i = this.l + 1;
        this.l = i;
        sQLiteStatement.bindLong(i, this.f38932b);
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.f38937g);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f38933c);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, A());
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, this.f38935e);
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f38936f);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, j());
    }

    public void f(d.o.a.e.b.k.b bVar) {
        this.o = bVar;
        E();
    }

    public void g(b bVar) {
        this.k = bVar;
        if (bVar != null) {
            c(bVar.F());
        }
    }

    public void h(List<b> list) {
        this.j = list;
    }

    public void i(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    public int j() {
        AtomicInteger atomicInteger = this.f38938h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void k(int i) {
        this.f38932b = i;
    }

    public void l(long j) {
        AtomicLong atomicLong = this.f38934d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f38934d = new AtomicLong(j);
        }
    }

    public void m(boolean z) {
        this.m = z;
    }

    public long n(boolean z) {
        long A = A();
        long j = this.f38936f;
        long j2 = this.i;
        long j3 = j - (A - j2);
        if (!z && A == j2) {
            j3 = j - (A - this.f38933c);
        }
        d.o.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f38936f + " curOffset:" + A() + " oldOffset:" + this.i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void o(int i) {
        this.f38937g = i;
    }

    public boolean p() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean q() {
        return j() == -1;
    }

    public b r() {
        b bVar = !q() ? this.k : this;
        if (bVar == null || !bVar.s()) {
            return null;
        }
        return bVar.t().get(0);
    }

    public boolean s() {
        List<b> list = this.j;
        return list != null && list.size() > 0;
    }

    public List<b> t() {
        return this.j;
    }

    public boolean u() {
        b bVar = this.k;
        if (bVar == null) {
            return true;
        }
        if (bVar.s()) {
            for (int i = 0; i < this.k.t().size(); i++) {
                b bVar2 = this.k.t().get(i);
                if (bVar2 != null) {
                    int indexOf = this.k.t().indexOf(this);
                    if (indexOf > i && !bVar2.v()) {
                        return false;
                    }
                    if (indexOf == i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean v() {
        long j = this.f38933c;
        if (q()) {
            long j2 = this.i;
            if (j2 > this.f38933c) {
                j = j2;
            }
        }
        return A() - j >= this.f38936f;
    }

    public long w() {
        b bVar = this.k;
        if (bVar != null && bVar.t() != null) {
            int indexOf = this.k.t().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.k.t().size(); i++) {
                b bVar2 = this.k.t().get(i);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.A();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38932b);
        parcel.writeLong(this.f38933c);
        AtomicLong atomicLong = this.f38934d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f38935e);
        parcel.writeLong(this.f38936f);
        parcel.writeInt(this.f38937g);
        AtomicInteger atomicInteger = this.f38938h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public int x() {
        return this.f38932b;
    }

    public long y() {
        return this.f38933c;
    }

    public long z() {
        AtomicLong atomicLong = this.f38934d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public b(C0502b c0502b) {
        if (c0502b == null) {
            return;
        }
        this.f38932b = c0502b.f38939a;
        this.f38933c = c0502b.f38940b;
        this.f38934d = new AtomicLong(c0502b.f38941c);
        this.f38935e = c0502b.f38942d;
        this.f38936f = c0502b.f38943e;
        this.f38937g = c0502b.f38944f;
        this.i = c0502b.f38945g;
        this.f38938h = new AtomicInteger(-1);
        g(c0502b.f38946h);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f38932b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f38937g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f38933c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f38934d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f38934d = new AtomicLong(0L);
        }
        this.f38935e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f38938h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f38938h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f38936f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public b(Parcel parcel) {
        this.f38932b = parcel.readInt();
        this.f38933c = parcel.readLong();
        this.f38934d = new AtomicLong(parcel.readLong());
        this.f38935e = parcel.readLong();
        this.f38936f = parcel.readLong();
        this.f38937g = parcel.readInt();
        this.f38938h = new AtomicInteger(parcel.readInt());
    }
}
