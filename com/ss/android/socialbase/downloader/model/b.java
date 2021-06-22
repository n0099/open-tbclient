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
    public int f39864b;

    /* renamed from: c  reason: collision with root package name */
    public long f39865c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f39866d;

    /* renamed from: e  reason: collision with root package name */
    public long f39867e;

    /* renamed from: f  reason: collision with root package name */
    public long f39868f;

    /* renamed from: g  reason: collision with root package name */
    public int f39869g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f39870h;

    /* renamed from: i  reason: collision with root package name */
    public long f39871i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public d.o.a.e.b.k.b o;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39863a = b.class.getSimpleName();
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
    public static class C0506b {

        /* renamed from: a  reason: collision with root package name */
        public int f39872a;

        /* renamed from: b  reason: collision with root package name */
        public long f39873b;

        /* renamed from: c  reason: collision with root package name */
        public long f39874c;

        /* renamed from: d  reason: collision with root package name */
        public long f39875d;

        /* renamed from: e  reason: collision with root package name */
        public long f39876e;

        /* renamed from: f  reason: collision with root package name */
        public int f39877f;

        /* renamed from: g  reason: collision with root package name */
        public long f39878g;

        /* renamed from: h  reason: collision with root package name */
        public b f39879h;

        public C0506b(int i2) {
            this.f39872a = i2;
        }

        public C0506b b(int i2) {
            this.f39877f = i2;
            return this;
        }

        public C0506b c(long j) {
            this.f39873b = j;
            return this;
        }

        public C0506b d(b bVar) {
            this.f39879h = bVar;
            return this;
        }

        public b e() {
            return new b(this, null);
        }

        public C0506b g(long j) {
            this.f39874c = j;
            return this;
        }

        public C0506b i(long j) {
            this.f39875d = j;
            return this;
        }

        public C0506b k(long j) {
            this.f39876e = j;
            return this;
        }

        public C0506b m(long j) {
            this.f39878g = j;
            return this;
        }
    }

    public /* synthetic */ b(C0506b c0506b, a aVar) {
        this(c0506b);
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
        long A = A() - this.f39865c;
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
        return this.f39867e;
    }

    public long D() {
        return this.f39868f;
    }

    public void E() {
        this.f39871i = A();
    }

    public int F() {
        return this.f39869g;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f39864b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f39869g));
        contentValues.put("startOffset", Long.valueOf(this.f39865c));
        contentValues.put("curOffset", Long.valueOf(A()));
        contentValues.put("endOffset", Long.valueOf(this.f39867e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f39868f));
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
        d.o.a.e.b.c.a.g(f39863a, "retainLen:" + n + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f39869g);
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
                    C0506b c0506b = new C0506b(bVar2.f39864b);
                    c0506b.b((-i4) - 1);
                    c0506b.c(j3);
                    c0506b.g(z);
                    c0506b.m(z);
                    long j7 = j5;
                    c0506b.i(j7);
                    c0506b.k(j4);
                    c0506b.d(bVar2);
                    b e2 = c0506b.e();
                    d.o.a.e.b.c.a.g(f39863a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j7 + " contentLen:" + j4);
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
            C0506b c0506b2 = new C0506b(bVar2.f39864b);
            c0506b2.b((-i4) - 1);
            c0506b2.c(j3);
            c0506b2.g(z);
            c0506b2.m(z);
            long j72 = j5;
            c0506b2.i(j72);
            c0506b2.k(j4);
            c0506b2.d(bVar2);
            b e22 = c0506b2.e();
            d.o.a.e.b.c.a.g(f39863a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + z + " endOffset:" + j72 + " contentLen:" + j4);
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
        d.o.a.e.b.c.a.g(f39863a, "reuseChunkContentLen:" + j8);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (C() == 0) {
                C = j - y();
            } else {
                C = (C() - y()) + 1;
            }
            bVar4.d(C - j8);
            bVar = this;
            bVar4.o(bVar.f39869g);
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
        AtomicInteger atomicInteger = this.f39870h;
        if (atomicInteger == null) {
            this.f39870h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void d(long j) {
        this.f39868f = j;
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
        sQLiteStatement.bindLong(i2, this.f39864b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f39869g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f39865c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, A());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f39867e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f39868f);
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
        AtomicInteger atomicInteger = this.f39870h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void k(int i2) {
        this.f39864b = i2;
    }

    public void l(long j) {
        AtomicLong atomicLong = this.f39866d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f39866d = new AtomicLong(j);
        }
    }

    public void m(boolean z) {
        this.m = z;
    }

    public long n(boolean z) {
        long A = A();
        long j = this.f39868f;
        long j2 = this.f39871i;
        long j3 = j - (A - j2);
        if (!z && A == j2) {
            j3 = j - (A - this.f39865c);
        }
        d.o.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f39868f + " curOffset:" + A() + " oldOffset:" + this.f39871i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void o(int i2) {
        this.f39869g = i2;
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
        long j = this.f39865c;
        if (q()) {
            long j2 = this.f39871i;
            if (j2 > this.f39865c) {
                j = j2;
            }
        }
        return A() - j >= this.f39868f;
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
        parcel.writeInt(this.f39864b);
        parcel.writeLong(this.f39865c);
        AtomicLong atomicLong = this.f39866d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f39867e);
        parcel.writeLong(this.f39868f);
        parcel.writeInt(this.f39869g);
        AtomicInteger atomicInteger = this.f39870h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public int x() {
        return this.f39864b;
    }

    public long y() {
        return this.f39865c;
    }

    public long z() {
        AtomicLong atomicLong = this.f39866d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public b(C0506b c0506b) {
        if (c0506b == null) {
            return;
        }
        this.f39864b = c0506b.f39872a;
        this.f39865c = c0506b.f39873b;
        this.f39866d = new AtomicLong(c0506b.f39874c);
        this.f39867e = c0506b.f39875d;
        this.f39868f = c0506b.f39876e;
        this.f39869g = c0506b.f39877f;
        this.f39871i = c0506b.f39878g;
        this.f39870h = new AtomicInteger(-1);
        g(c0506b.f39879h);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f39864b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f39869g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f39865c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f39866d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f39866d = new AtomicLong(0L);
        }
        this.f39867e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f39870h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f39870h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f39868f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public b(Parcel parcel) {
        this.f39864b = parcel.readInt();
        this.f39865c = parcel.readLong();
        this.f39866d = new AtomicLong(parcel.readLong());
        this.f39867e = parcel.readLong();
        this.f39868f = parcel.readLong();
        this.f39869g = parcel.readInt();
        this.f39870h = new AtomicInteger(parcel.readInt());
    }
}
