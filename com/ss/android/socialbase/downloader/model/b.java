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
/* loaded from: classes4.dex */
public class b implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public int f60424b;

    /* renamed from: c  reason: collision with root package name */
    public long f60425c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f60426d;

    /* renamed from: e  reason: collision with root package name */
    public long f60427e;

    /* renamed from: f  reason: collision with root package name */
    public long f60428f;

    /* renamed from: g  reason: collision with root package name */
    public int f60429g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f60430h;

    /* renamed from: i  reason: collision with root package name */
    public long f60431i;

    /* renamed from: j  reason: collision with root package name */
    public List<b> f60432j;
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
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };

    /* loaded from: classes4.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f60433b;

        /* renamed from: c  reason: collision with root package name */
        public long f60434c;

        /* renamed from: d  reason: collision with root package name */
        public long f60435d;

        /* renamed from: e  reason: collision with root package name */
        public long f60436e;

        /* renamed from: f  reason: collision with root package name */
        public int f60437f;

        /* renamed from: g  reason: collision with root package name */
        public long f60438g;

        /* renamed from: h  reason: collision with root package name */
        public b f60439h;

        public a(int i2) {
            this.a = i2;
        }

        public a a(long j2) {
            this.f60433b = j2;
            return this;
        }

        public a b(long j2) {
            this.f60434c = j2;
            return this;
        }

        public a c(long j2) {
            this.f60435d = j2;
            return this;
        }

        public a d(long j2) {
            this.f60436e = j2;
            return this;
        }

        public a e(long j2) {
            this.f60438g = j2;
            return this;
        }

        public a a(int i2) {
            this.f60437f = i2;
            return this;
        }

        public a a(b bVar) {
            this.f60439h = bVar;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.f60424b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f60429g));
        contentValues.put("startOffset", Long.valueOf(this.f60425c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.f60427e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f60428f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public int b() {
        AtomicInteger atomicInteger = this.f60430h;
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
        List<b> list = this.f60432j;
        return list != null && list.size() > 0;
    }

    public List<b> g() {
        return this.f60432j;
    }

    public boolean h() {
        b bVar = this.k;
        if (bVar == null) {
            return true;
        }
        if (bVar.f()) {
            for (int i2 = 0; i2 < this.k.g().size(); i2++) {
                b bVar2 = this.k.g().get(i2);
                if (bVar2 != null) {
                    int indexOf = this.k.g().indexOf(this);
                    if (indexOf > i2 && !bVar2.i()) {
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

    public boolean i() {
        long j2 = this.f60425c;
        if (d()) {
            long j3 = this.f60431i;
            if (j3 > this.f60425c) {
                j2 = j3;
            }
        }
        return n() - j2 >= this.f60428f;
    }

    public long j() {
        b bVar = this.k;
        if (bVar != null && bVar.g() != null) {
            int indexOf = this.k.g().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.k.g().size(); i2++) {
                b bVar2 = this.k.g().get(i2);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (indexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int k() {
        return this.f60424b;
    }

    public long l() {
        return this.f60425c;
    }

    public long m() {
        AtomicLong atomicLong = this.f60426d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long n() {
        if (d() && f()) {
            long j2 = 0;
            for (int i2 = 0; i2 < this.f60432j.size(); i2++) {
                b bVar = this.f60432j.get(i2);
                if (bVar != null) {
                    if (!bVar.i()) {
                        return bVar.m();
                    }
                    if (j2 < bVar.m()) {
                        j2 = bVar.m();
                    }
                }
            }
            return j2;
        }
        return m();
    }

    public long o() {
        long n = n() - this.f60425c;
        if (f()) {
            n = 0;
            for (int i2 = 0; i2 < this.f60432j.size(); i2++) {
                b bVar = this.f60432j.get(i2);
                if (bVar != null) {
                    n += bVar.n() - bVar.l();
                }
            }
        }
        return n;
    }

    public long p() {
        return this.f60427e;
    }

    public long q() {
        return this.f60428f;
    }

    public void r() {
        this.f60431i = n();
    }

    public int s() {
        return this.f60429g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f60424b);
        parcel.writeLong(this.f60425c);
        AtomicLong atomicLong = this.f60426d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f60427e);
        parcel.writeLong(this.f60428f);
        parcel.writeInt(this.f60429g);
        AtomicInteger atomicInteger = this.f60430h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f60424b = aVar.a;
        this.f60425c = aVar.f60433b;
        this.f60426d = new AtomicLong(aVar.f60434c);
        this.f60427e = aVar.f60435d;
        this.f60428f = aVar.f60436e;
        this.f60429g = aVar.f60437f;
        this.f60431i = aVar.f60438g;
        this.f60430h = new AtomicInteger(-1);
        a(aVar.f60439h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void c(int i2) {
        this.f60429g = i2;
    }

    public void b(int i2) {
        this.f60424b = i2;
    }

    public long c(boolean z) {
        long n = n();
        long j2 = this.f60428f;
        long j3 = this.f60431i;
        long j4 = j2 - (n - j3);
        if (!z && n == j3) {
            j4 = j2 - (n - this.f60425c);
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f60428f + " curOffset:" + n() + " oldOffset:" + this.f60431i + " retainLen:" + j4);
        if (j4 < 0) {
            return 0L;
        }
        return j4;
    }

    public void b(long j2) {
        AtomicLong atomicLong = this.f60426d;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.f60426d = new AtomicLong(j2);
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.f60424b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f60429g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f60425c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, n());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f60427e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f60428f);
        int i8 = this.l + 1;
        this.l = i8;
        sQLiteStatement.bindLong(i8, b());
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f60424b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f60429g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f60425c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f60426d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f60426d = new AtomicLong(0L);
        }
        this.f60427e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f60430h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f60430h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f60428f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.f60430h;
        if (atomicInteger == null) {
            this.f60430h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
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
        this.f60424b = parcel.readInt();
        this.f60425c = parcel.readLong();
        this.f60426d = new AtomicLong(parcel.readLong());
        this.f60427e = parcel.readLong();
        this.f60428f = parcel.readLong();
        this.f60429g = parcel.readInt();
        this.f60430h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        this.k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public void a(List<b> list) {
        this.f60432j = list;
    }

    public void a(long j2) {
        this.f60428f = j2;
    }

    public List<b> a(int i2, long j2) {
        b bVar;
        long p;
        long j3;
        long j4;
        long j5;
        long j6;
        b bVar2 = this;
        int i3 = i2;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m = m();
        long c2 = bVar2.c(true);
        long j7 = c2 / i3;
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j7 + " current host downloadChunk index:" + bVar2.f60429g);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                j4 = l();
                j3 = (m + j7) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long p2 = p();
                    j5 = p2 > m ? (p2 - m) + 1 : c2 - (i5 * j7);
                    j6 = p2;
                    j4 = m;
                    long j8 = c2;
                    long j9 = j6;
                    b a2 = new a(bVar2.f60424b).a((-i4) - 1).a(j4).b(m).e(m).c(j9).d(j5).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m + " endOffset:" + j9 + " contentLen:" + j5);
                    arrayList.add(a2);
                    m += j7;
                    i4++;
                    bVar2 = this;
                    i3 = i2;
                    c2 = j8;
                } else {
                    j3 = (m + j7) - 1;
                    j4 = m;
                }
            }
            j5 = j7;
            j6 = j3;
            long j82 = c2;
            long j92 = j6;
            b a22 = new a(bVar2.f60424b).a((-i4) - 1).a(j4).b(m).e(m).c(j92).d(j5).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m + " endOffset:" + j92 + " contentLen:" + j5);
            arrayList.add(a22);
            m += j7;
            i4++;
            bVar2 = this;
            i3 = i2;
            c2 = j82;
        }
        long j10 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j10 += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:" + j10);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                p = j2 - l();
            } else {
                p = (p() - l()) + 1;
            }
            bVar4.a(p - j10);
            bVar = this;
            bVar4.c(bVar.f60429g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - j10);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }
}
