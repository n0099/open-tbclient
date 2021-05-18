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
    public int f36153b;

    /* renamed from: c  reason: collision with root package name */
    public long f36154c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f36155d;

    /* renamed from: e  reason: collision with root package name */
    public long f36156e;

    /* renamed from: f  reason: collision with root package name */
    public long f36157f;

    /* renamed from: g  reason: collision with root package name */
    public int f36158g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f36159h;

    /* renamed from: i  reason: collision with root package name */
    public long f36160i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public d.o.a.e.b.k.b o;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36152a = b.class.getSimpleName();
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
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0451b {

        /* renamed from: a  reason: collision with root package name */
        public int f36161a;

        /* renamed from: b  reason: collision with root package name */
        public long f36162b;

        /* renamed from: c  reason: collision with root package name */
        public long f36163c;

        /* renamed from: d  reason: collision with root package name */
        public long f36164d;

        /* renamed from: e  reason: collision with root package name */
        public long f36165e;

        /* renamed from: f  reason: collision with root package name */
        public int f36166f;

        /* renamed from: g  reason: collision with root package name */
        public long f36167g;

        /* renamed from: h  reason: collision with root package name */
        public b f36168h;

        public C0451b(int i2) {
            this.f36161a = i2;
        }

        public C0451b b(int i2) {
            this.f36166f = i2;
            return this;
        }

        public C0451b c(long j) {
            this.f36162b = j;
            return this;
        }

        public C0451b d(b bVar) {
            this.f36168h = bVar;
            return this;
        }

        public b e() {
            return new b(this, null);
        }

        public C0451b g(long j) {
            this.f36163c = j;
            return this;
        }

        public C0451b i(long j) {
            this.f36164d = j;
            return this;
        }

        public C0451b k(long j) {
            this.f36165e = j;
            return this;
        }

        public C0451b m(long j) {
            this.f36167g = j;
            return this;
        }
    }

    public /* synthetic */ b(C0451b c0451b, a aVar) {
        this(c0451b);
    }

    public long A() {
        if (q() && s()) {
            long j = 0;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                b bVar = this.j.get(i2);
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
        long A = A() - this.f36154c;
        if (s()) {
            A = 0;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                b bVar = this.j.get(i2);
                if (bVar != null) {
                    A += bVar.A() - bVar.y();
                }
            }
        }
        return A;
    }

    public long C() {
        return this.f36156e;
    }

    public long D() {
        return this.f36157f;
    }

    public void E() {
        this.f36160i = A();
    }

    public int F() {
        return this.f36158g;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f36153b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f36158g));
        contentValues.put("startOffset", Long.valueOf(this.f36154c));
        contentValues.put("curOffset", Long.valueOf(A()));
        contentValues.put("endOffset", Long.valueOf(this.f36156e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f36157f));
        contentValues.put("hostChunkIndex", Integer.valueOf(j()));
        return contentValues;
    }

    public List<b> b(int i2, long j) {
        b bVar;
        long C;
        long j2;
        long j3;
        long j4;
        long j5;
        b bVar2 = this;
        int i3 = i2;
        if (!q() || s()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long z = z();
        long n = bVar2.n(true);
        long j6 = n / i3;
        d.o.a.e.b.c.a.g(f36152a, "retainLen:" + n + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f36158g);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                j3 = y();
                j2 = (z + j6) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long C2 = C();
                    j4 = C2 > z ? (C2 - z) + 1 : n - (i5 * j6);
                    j5 = C2;
                    j3 = z;
                    C0451b c0451b = new C0451b(bVar2.f36153b);
                    c0451b.b((-i4) - 1);
                    c0451b.c(j3);
                    c0451b.g(z);
                    c0451b.m(z);
                    long j7 = j5;
                    c0451b.i(j7);
                    c0451b.k(j4);
                    c0451b.d(bVar2);
                    b e2 = c0451b.e();
                    d.o.a.e.b.c.a.g(f36152a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j7 + " contentLen:" + j4);
                    arrayList.add(e2);
                    z += j6;
                    i4++;
                    bVar2 = this;
                    i3 = i2;
                    n = n;
                } else {
                    j2 = (z + j6) - 1;
                    j3 = z;
                }
            }
            j4 = j6;
            j5 = j2;
            C0451b c0451b2 = new C0451b(bVar2.f36153b);
            c0451b2.b((-i4) - 1);
            c0451b2.c(j3);
            c0451b2.g(z);
            c0451b2.m(z);
            long j72 = j5;
            c0451b2.i(j72);
            c0451b2.k(j4);
            c0451b2.d(bVar2);
            b e22 = c0451b2.e();
            d.o.a.e.b.c.a.g(f36152a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j72 + " contentLen:" + j4);
            arrayList.add(e22);
            z += j6;
            i4++;
            bVar2 = this;
            i3 = i2;
            n = n;
        }
        long j8 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j8 += bVar3.D();
            }
        }
        d.o.a.e.b.c.a.g(f36152a, "reuseChunkContentLen:" + j8);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (C() == 0) {
                C = j - y();
            } else {
                C = (C() - y()) + 1;
            }
            bVar4.d(C - j8);
            bVar = this;
            bVar4.o(bVar.f36158g);
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

    public void c(int i2) {
        AtomicInteger atomicInteger = this.f36159h;
        if (atomicInteger == null) {
            this.f36159h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void d(long j) {
        this.f36157f = j;
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
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.f36153b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f36158g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f36154c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, A());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f36156e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f36157f);
        int i8 = this.l + 1;
        this.l = i8;
        sQLiteStatement.bindLong(i8, j());
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
        AtomicInteger atomicInteger = this.f36159h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void k(int i2) {
        this.f36153b = i2;
    }

    public void l(long j) {
        AtomicLong atomicLong = this.f36155d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f36155d = new AtomicLong(j);
        }
    }

    public void m(boolean z) {
        this.m = z;
    }

    public long n(boolean z) {
        long A = A();
        long j = this.f36157f;
        long j2 = this.f36160i;
        long j3 = j - (A - j2);
        if (!z && A == j2) {
            j3 = j - (A - this.f36154c);
        }
        d.o.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f36157f + " curOffset:" + A() + " oldOffset:" + this.f36160i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void o(int i2) {
        this.f36158g = i2;
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
            for (int i2 = 0; i2 < this.k.t().size(); i2++) {
                b bVar2 = this.k.t().get(i2);
                if (bVar2 != null) {
                    int indexOf = this.k.t().indexOf(this);
                    if (indexOf > i2 && !bVar2.v()) {
                        return false;
                    }
                    if (indexOf == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public boolean v() {
        long j = this.f36154c;
        if (q()) {
            long j2 = this.f36160i;
            if (j2 > this.f36154c) {
                j = j2;
            }
        }
        return A() - j >= this.f36157f;
    }

    public long w() {
        b bVar = this.k;
        if (bVar != null && bVar.t() != null) {
            int indexOf = this.k.t().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.k.t().size(); i2++) {
                b bVar2 = this.k.t().get(i2);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.A();
                    }
                    if (indexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f36153b);
        parcel.writeLong(this.f36154c);
        AtomicLong atomicLong = this.f36155d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f36156e);
        parcel.writeLong(this.f36157f);
        parcel.writeInt(this.f36158g);
        AtomicInteger atomicInteger = this.f36159h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public int x() {
        return this.f36153b;
    }

    public long y() {
        return this.f36154c;
    }

    public long z() {
        AtomicLong atomicLong = this.f36155d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public b(C0451b c0451b) {
        if (c0451b == null) {
            return;
        }
        this.f36153b = c0451b.f36161a;
        this.f36154c = c0451b.f36162b;
        this.f36155d = new AtomicLong(c0451b.f36163c);
        this.f36156e = c0451b.f36164d;
        this.f36157f = c0451b.f36165e;
        this.f36158g = c0451b.f36166f;
        this.f36160i = c0451b.f36167g;
        this.f36159h = new AtomicInteger(-1);
        g(c0451b.f36168h);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f36153b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f36158g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f36154c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f36155d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f36155d = new AtomicLong(0L);
        }
        this.f36156e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f36159h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f36159h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f36157f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public b(Parcel parcel) {
        this.f36153b = parcel.readInt();
        this.f36154c = parcel.readLong();
        this.f36155d = new AtomicLong(parcel.readLong());
        this.f36156e = parcel.readLong();
        this.f36157f = parcel.readLong();
        this.f36158g = parcel.readInt();
        this.f36159h = new AtomicInteger(parcel.readInt());
    }
}
