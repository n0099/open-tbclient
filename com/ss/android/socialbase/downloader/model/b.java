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
/* loaded from: classes6.dex */
public class b implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public int f36908b;

    /* renamed from: c  reason: collision with root package name */
    public long f36909c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f36910d;

    /* renamed from: e  reason: collision with root package name */
    public long f36911e;

    /* renamed from: f  reason: collision with root package name */
    public long f36912f;

    /* renamed from: g  reason: collision with root package name */
    public int f36913g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f36914h;

    /* renamed from: i  reason: collision with root package name */
    public long f36915i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public d.o.a.e.b.k.b o;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36907a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class C0464b {

        /* renamed from: a  reason: collision with root package name */
        public int f36916a;

        /* renamed from: b  reason: collision with root package name */
        public long f36917b;

        /* renamed from: c  reason: collision with root package name */
        public long f36918c;

        /* renamed from: d  reason: collision with root package name */
        public long f36919d;

        /* renamed from: e  reason: collision with root package name */
        public long f36920e;

        /* renamed from: f  reason: collision with root package name */
        public int f36921f;

        /* renamed from: g  reason: collision with root package name */
        public long f36922g;

        /* renamed from: h  reason: collision with root package name */
        public b f36923h;

        public C0464b(int i2) {
            this.f36916a = i2;
        }

        public C0464b b(int i2) {
            this.f36921f = i2;
            return this;
        }

        public C0464b c(long j) {
            this.f36917b = j;
            return this;
        }

        public C0464b d(b bVar) {
            this.f36923h = bVar;
            return this;
        }

        public b e() {
            return new b(this, null);
        }

        public C0464b g(long j) {
            this.f36918c = j;
            return this;
        }

        public C0464b i(long j) {
            this.f36919d = j;
            return this;
        }

        public C0464b k(long j) {
            this.f36920e = j;
            return this;
        }

        public C0464b m(long j) {
            this.f36922g = j;
            return this;
        }
    }

    public /* synthetic */ b(C0464b c0464b, a aVar) {
        this(c0464b);
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
        long A = A() - this.f36909c;
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
        return this.f36911e;
    }

    public long D() {
        return this.f36912f;
    }

    public void E() {
        this.f36915i = A();
    }

    public int F() {
        return this.f36913g;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f36908b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f36913g));
        contentValues.put("startOffset", Long.valueOf(this.f36909c));
        contentValues.put("curOffset", Long.valueOf(A()));
        contentValues.put("endOffset", Long.valueOf(this.f36911e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f36912f));
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
        d.o.a.e.b.c.a.g(f36907a, "retainLen:" + n + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f36913g);
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
                    C0464b c0464b = new C0464b(bVar2.f36908b);
                    c0464b.b((-i4) - 1);
                    c0464b.c(j3);
                    c0464b.g(z);
                    c0464b.m(z);
                    long j7 = j5;
                    c0464b.i(j7);
                    c0464b.k(j4);
                    c0464b.d(bVar2);
                    b e2 = c0464b.e();
                    d.o.a.e.b.c.a.g(f36907a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j7 + " contentLen:" + j4);
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
            C0464b c0464b2 = new C0464b(bVar2.f36908b);
            c0464b2.b((-i4) - 1);
            c0464b2.c(j3);
            c0464b2.g(z);
            c0464b2.m(z);
            long j72 = j5;
            c0464b2.i(j72);
            c0464b2.k(j4);
            c0464b2.d(bVar2);
            b e22 = c0464b2.e();
            d.o.a.e.b.c.a.g(f36907a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j72 + " contentLen:" + j4);
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
        d.o.a.e.b.c.a.g(f36907a, "reuseChunkContentLen:" + j8);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (C() == 0) {
                C = j - y();
            } else {
                C = (C() - y()) + 1;
            }
            bVar4.d(C - j8);
            bVar = this;
            bVar4.o(bVar.f36913g);
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
        AtomicInteger atomicInteger = this.f36914h;
        if (atomicInteger == null) {
            this.f36914h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void d(long j) {
        this.f36912f = j;
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
        sQLiteStatement.bindLong(i2, this.f36908b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f36913g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f36909c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, A());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f36911e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f36912f);
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
        AtomicInteger atomicInteger = this.f36914h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void k(int i2) {
        this.f36908b = i2;
    }

    public void l(long j) {
        AtomicLong atomicLong = this.f36910d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f36910d = new AtomicLong(j);
        }
    }

    public void m(boolean z) {
        this.m = z;
    }

    public long n(boolean z) {
        long A = A();
        long j = this.f36912f;
        long j2 = this.f36915i;
        long j3 = j - (A - j2);
        if (!z && A == j2) {
            j3 = j - (A - this.f36909c);
        }
        d.o.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f36912f + " curOffset:" + A() + " oldOffset:" + this.f36915i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void o(int i2) {
        this.f36913g = i2;
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
        long j = this.f36909c;
        if (q()) {
            long j2 = this.f36915i;
            if (j2 > this.f36909c) {
                j = j2;
            }
        }
        return A() - j >= this.f36912f;
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
        parcel.writeInt(this.f36908b);
        parcel.writeLong(this.f36909c);
        AtomicLong atomicLong = this.f36910d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f36911e);
        parcel.writeLong(this.f36912f);
        parcel.writeInt(this.f36913g);
        AtomicInteger atomicInteger = this.f36914h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public int x() {
        return this.f36908b;
    }

    public long y() {
        return this.f36909c;
    }

    public long z() {
        AtomicLong atomicLong = this.f36910d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public b(C0464b c0464b) {
        if (c0464b == null) {
            return;
        }
        this.f36908b = c0464b.f36916a;
        this.f36909c = c0464b.f36917b;
        this.f36910d = new AtomicLong(c0464b.f36918c);
        this.f36911e = c0464b.f36919d;
        this.f36912f = c0464b.f36920e;
        this.f36913g = c0464b.f36921f;
        this.f36915i = c0464b.f36922g;
        this.f36914h = new AtomicInteger(-1);
        g(c0464b.f36923h);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f36908b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f36913g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f36909c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f36910d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f36910d = new AtomicLong(0L);
        }
        this.f36911e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f36914h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f36914h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f36912f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public b(Parcel parcel) {
        this.f36908b = parcel.readInt();
        this.f36909c = parcel.readLong();
        this.f36910d = new AtomicLong(parcel.readLong());
        this.f36911e = parcel.readLong();
        this.f36912f = parcel.readLong();
        this.f36913g = parcel.readInt();
        this.f36914h = new AtomicInteger(parcel.readInt());
    }
}
