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
    public int f43469b;

    /* renamed from: c  reason: collision with root package name */
    public long f43470c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f43471d;

    /* renamed from: e  reason: collision with root package name */
    public long f43472e;

    /* renamed from: f  reason: collision with root package name */
    public long f43473f;

    /* renamed from: g  reason: collision with root package name */
    public int f43474g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f43475h;
    public long i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public com.ss.android.socialbase.downloader.h.b o;
    public static final String a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* loaded from: classes7.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f43476b;

        /* renamed from: c  reason: collision with root package name */
        public long f43477c;

        /* renamed from: d  reason: collision with root package name */
        public long f43478d;

        /* renamed from: e  reason: collision with root package name */
        public long f43479e;

        /* renamed from: f  reason: collision with root package name */
        public int f43480f;

        /* renamed from: g  reason: collision with root package name */
        public long f43481g;

        /* renamed from: h  reason: collision with root package name */
        public b f43482h;

        public a(int i) {
            this.a = i;
        }

        public a a(long j) {
            this.f43476b = j;
            return this;
        }

        public a b(long j) {
            this.f43477c = j;
            return this;
        }

        public a c(long j) {
            this.f43478d = j;
            return this;
        }

        public a d(long j) {
            this.f43479e = j;
            return this;
        }

        public a e(long j) {
            this.f43481g = j;
            return this;
        }

        public a a(int i) {
            this.f43480f = i;
            return this;
        }

        public a a(b bVar) {
            this.f43482h = bVar;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f43469b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f43474g));
        contentValues.put("startOffset", Long.valueOf(this.f43470c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.f43472e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f43473f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public int b() {
        AtomicInteger atomicInteger = this.f43475h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean c() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean d() {
        return b() == -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b e() {
        b bVar = !d() ? this.k : this;
        if (bVar == null || !bVar.f()) {
            return null;
        }
        return bVar.g().get(0);
    }

    public boolean f() {
        List<b> list = this.j;
        return list != null && list.size() > 0;
    }

    public List<b> g() {
        return this.j;
    }

    public boolean h() {
        b bVar = this.k;
        if (bVar == null) {
            return true;
        }
        if (bVar.f()) {
            for (int i = 0; i < this.k.g().size(); i++) {
                b bVar2 = this.k.g().get(i);
                if (bVar2 != null) {
                    int indexOf = this.k.g().indexOf(this);
                    if (indexOf > i && !bVar2.i()) {
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

    public boolean i() {
        long j = this.f43470c;
        if (d()) {
            long j2 = this.i;
            if (j2 > this.f43470c) {
                j = j2;
            }
        }
        return n() - j >= this.f43473f;
    }

    public long j() {
        b bVar = this.k;
        if (bVar != null && bVar.g() != null) {
            int indexOf = this.k.g().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.k.g().size(); i++) {
                b bVar2 = this.k.g().get(i);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int k() {
        return this.f43469b;
    }

    public long l() {
        return this.f43470c;
    }

    public long m() {
        AtomicLong atomicLong = this.f43471d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long n() {
        if (d() && f()) {
            long j = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    if (!bVar.i()) {
                        return bVar.m();
                    }
                    if (j < bVar.m()) {
                        j = bVar.m();
                    }
                }
            }
            return j;
        }
        return m();
    }

    public long o() {
        long n = n() - this.f43470c;
        if (f()) {
            n = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    n += bVar.n() - bVar.l();
                }
            }
        }
        return n;
    }

    public long p() {
        return this.f43472e;
    }

    public long q() {
        return this.f43473f;
    }

    public void r() {
        this.i = n();
    }

    public int s() {
        return this.f43474g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f43469b);
        parcel.writeLong(this.f43470c);
        AtomicLong atomicLong = this.f43471d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f43472e);
        parcel.writeLong(this.f43473f);
        parcel.writeInt(this.f43474g);
        AtomicInteger atomicInteger = this.f43475h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f43469b = aVar.a;
        this.f43470c = aVar.f43476b;
        this.f43471d = new AtomicLong(aVar.f43477c);
        this.f43472e = aVar.f43478d;
        this.f43473f = aVar.f43479e;
        this.f43474g = aVar.f43480f;
        this.i = aVar.f43481g;
        this.f43475h = new AtomicInteger(-1);
        a(aVar.f43482h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void c(int i) {
        this.f43474g = i;
    }

    public void b(int i) {
        this.f43469b = i;
    }

    public long c(boolean z) {
        long n = n();
        long j = this.f43473f;
        long j2 = this.i;
        long j3 = j - (n - j2);
        if (!z && n == j2) {
            j3 = j - (n - this.f43470c);
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f43473f + " curOffset:" + n() + " oldOffset:" + this.i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void b(long j) {
        AtomicLong atomicLong = this.f43471d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f43471d = new AtomicLong(j);
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i = this.l + 1;
        this.l = i;
        sQLiteStatement.bindLong(i, this.f43469b);
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.f43474g);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f43470c);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, n());
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, this.f43472e);
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f43473f);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, b());
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f43469b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f43474g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f43470c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f43471d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f43471d = new AtomicLong(0L);
        }
        this.f43472e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f43475h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f43475h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f43473f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i) {
        AtomicInteger atomicInteger = this.f43475h;
        if (atomicInteger == null) {
            this.f43475h = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    public b(Parcel parcel) {
        this.f43469b = parcel.readInt();
        this.f43470c = parcel.readLong();
        this.f43471d = new AtomicLong(parcel.readLong());
        this.f43472e = parcel.readLong();
        this.f43473f = parcel.readLong();
        this.f43474g = parcel.readInt();
        this.f43475h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        this.k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public void a(List<b> list) {
        this.j = list;
    }

    public void a(long j) {
        this.f43473f = j;
    }

    public List<b> a(int i, long j) {
        b bVar;
        long p;
        long j2;
        long j3;
        long j4;
        long j5;
        b bVar2 = this;
        int i2 = i;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m = m();
        long c2 = bVar2.c(true);
        long j6 = c2 / i2;
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f43474g);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j3 = l();
                j2 = (m + j6) - 1;
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long p2 = p();
                    j4 = p2 > m ? (p2 - m) + 1 : c2 - (i4 * j6);
                    j5 = p2;
                    j3 = m;
                    long j7 = c2;
                    long j8 = j5;
                    b a2 = new a(bVar2.f43469b).a((-i3) - 1).a(j3).b(m).e(m).c(j8).d(j4).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + m + " endOffset:" + j8 + " contentLen:" + j4);
                    arrayList.add(a2);
                    m += j6;
                    i3++;
                    bVar2 = this;
                    i2 = i;
                    c2 = j7;
                } else {
                    j2 = (m + j6) - 1;
                    j3 = m;
                }
            }
            j4 = j6;
            j5 = j2;
            long j72 = c2;
            long j82 = j5;
            b a22 = new a(bVar2.f43469b).a((-i3) - 1).a(j3).b(m).e(m).c(j82).d(j4).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + m + " endOffset:" + j82 + " contentLen:" + j4);
            arrayList.add(a22);
            m += j6;
            i3++;
            bVar2 = this;
            i2 = i;
            c2 = j72;
        }
        long j9 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j9 += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:" + j9);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                p = j - l();
            } else {
                p = (p() - l()) + 1;
            }
            bVar4.a(p - j9);
            bVar = this;
            bVar4.c(bVar.f43474g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - j9);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }
}
