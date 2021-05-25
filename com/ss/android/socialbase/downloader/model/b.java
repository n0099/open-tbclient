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
    public int f36082b;

    /* renamed from: c  reason: collision with root package name */
    public long f36083c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f36084d;

    /* renamed from: e  reason: collision with root package name */
    public long f36085e;

    /* renamed from: f  reason: collision with root package name */
    public long f36086f;

    /* renamed from: g  reason: collision with root package name */
    public int f36087g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f36088h;

    /* renamed from: i  reason: collision with root package name */
    public long f36089i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public d.o.a.e.b.k.b o;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36081a = b.class.getSimpleName();
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
    public static class C0452b {

        /* renamed from: a  reason: collision with root package name */
        public int f36090a;

        /* renamed from: b  reason: collision with root package name */
        public long f36091b;

        /* renamed from: c  reason: collision with root package name */
        public long f36092c;

        /* renamed from: d  reason: collision with root package name */
        public long f36093d;

        /* renamed from: e  reason: collision with root package name */
        public long f36094e;

        /* renamed from: f  reason: collision with root package name */
        public int f36095f;

        /* renamed from: g  reason: collision with root package name */
        public long f36096g;

        /* renamed from: h  reason: collision with root package name */
        public b f36097h;

        public C0452b(int i2) {
            this.f36090a = i2;
        }

        public C0452b b(int i2) {
            this.f36095f = i2;
            return this;
        }

        public C0452b c(long j) {
            this.f36091b = j;
            return this;
        }

        public C0452b d(b bVar) {
            this.f36097h = bVar;
            return this;
        }

        public b e() {
            return new b(this, null);
        }

        public C0452b g(long j) {
            this.f36092c = j;
            return this;
        }

        public C0452b i(long j) {
            this.f36093d = j;
            return this;
        }

        public C0452b k(long j) {
            this.f36094e = j;
            return this;
        }

        public C0452b m(long j) {
            this.f36096g = j;
            return this;
        }
    }

    public /* synthetic */ b(C0452b c0452b, a aVar) {
        this(c0452b);
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
        long A = A() - this.f36083c;
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
        return this.f36085e;
    }

    public long D() {
        return this.f36086f;
    }

    public void E() {
        this.f36089i = A();
    }

    public int F() {
        return this.f36087g;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f36082b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f36087g));
        contentValues.put("startOffset", Long.valueOf(this.f36083c));
        contentValues.put("curOffset", Long.valueOf(A()));
        contentValues.put("endOffset", Long.valueOf(this.f36085e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f36086f));
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
        d.o.a.e.b.c.a.g(f36081a, "retainLen:" + n + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f36087g);
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
                    C0452b c0452b = new C0452b(bVar2.f36082b);
                    c0452b.b((-i4) - 1);
                    c0452b.c(j3);
                    c0452b.g(z);
                    c0452b.m(z);
                    long j7 = j5;
                    c0452b.i(j7);
                    c0452b.k(j4);
                    c0452b.d(bVar2);
                    b e2 = c0452b.e();
                    d.o.a.e.b.c.a.g(f36081a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j7 + " contentLen:" + j4);
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
            C0452b c0452b2 = new C0452b(bVar2.f36082b);
            c0452b2.b((-i4) - 1);
            c0452b2.c(j3);
            c0452b2.g(z);
            c0452b2.m(z);
            long j72 = j5;
            c0452b2.i(j72);
            c0452b2.k(j4);
            c0452b2.d(bVar2);
            b e22 = c0452b2.e();
            d.o.a.e.b.c.a.g(f36081a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j72 + " contentLen:" + j4);
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
        d.o.a.e.b.c.a.g(f36081a, "reuseChunkContentLen:" + j8);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (C() == 0) {
                C = j - y();
            } else {
                C = (C() - y()) + 1;
            }
            bVar4.d(C - j8);
            bVar = this;
            bVar4.o(bVar.f36087g);
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
        AtomicInteger atomicInteger = this.f36088h;
        if (atomicInteger == null) {
            this.f36088h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void d(long j) {
        this.f36086f = j;
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
        sQLiteStatement.bindLong(i2, this.f36082b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f36087g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f36083c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, A());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f36085e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f36086f);
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
        AtomicInteger atomicInteger = this.f36088h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void k(int i2) {
        this.f36082b = i2;
    }

    public void l(long j) {
        AtomicLong atomicLong = this.f36084d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f36084d = new AtomicLong(j);
        }
    }

    public void m(boolean z) {
        this.m = z;
    }

    public long n(boolean z) {
        long A = A();
        long j = this.f36086f;
        long j2 = this.f36089i;
        long j3 = j - (A - j2);
        if (!z && A == j2) {
            j3 = j - (A - this.f36083c);
        }
        d.o.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f36086f + " curOffset:" + A() + " oldOffset:" + this.f36089i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void o(int i2) {
        this.f36087g = i2;
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
        long j = this.f36083c;
        if (q()) {
            long j2 = this.f36089i;
            if (j2 > this.f36083c) {
                j = j2;
            }
        }
        return A() - j >= this.f36086f;
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
        parcel.writeInt(this.f36082b);
        parcel.writeLong(this.f36083c);
        AtomicLong atomicLong = this.f36084d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f36085e);
        parcel.writeLong(this.f36086f);
        parcel.writeInt(this.f36087g);
        AtomicInteger atomicInteger = this.f36088h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public int x() {
        return this.f36082b;
    }

    public long y() {
        return this.f36083c;
    }

    public long z() {
        AtomicLong atomicLong = this.f36084d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public b(C0452b c0452b) {
        if (c0452b == null) {
            return;
        }
        this.f36082b = c0452b.f36090a;
        this.f36083c = c0452b.f36091b;
        this.f36084d = new AtomicLong(c0452b.f36092c);
        this.f36085e = c0452b.f36093d;
        this.f36086f = c0452b.f36094e;
        this.f36087g = c0452b.f36095f;
        this.f36089i = c0452b.f36096g;
        this.f36088h = new AtomicInteger(-1);
        g(c0452b.f36097h);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f36082b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f36087g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f36083c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f36084d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f36084d = new AtomicLong(0L);
        }
        this.f36085e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f36088h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f36088h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f36086f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public b(Parcel parcel) {
        this.f36082b = parcel.readInt();
        this.f36083c = parcel.readLong();
        this.f36084d = new AtomicLong(parcel.readLong());
        this.f36085e = parcel.readLong();
        this.f36086f = parcel.readLong();
        this.f36087g = parcel.readInt();
        this.f36088h = new AtomicInteger(parcel.readInt());
    }
}
