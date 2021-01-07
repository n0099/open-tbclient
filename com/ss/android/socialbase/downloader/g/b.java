package com.ss.android.socialbase.downloader.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class b implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    private int f13450b;
    private long c;
    private AtomicLong d;
    private long e;
    private long f;
    private int g;
    private AtomicInteger h;
    private long i;
    private List<b> j;
    private b k;
    private int l;
    private boolean m;
    private AtomicBoolean n;
    private com.ss.android.socialbase.downloader.l.b o;

    /* renamed from: a  reason: collision with root package name */
    private static final String f13449a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.g.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aq */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: SM */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    private b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f13450b = aVar.f13451a;
        this.c = aVar.f13452b;
        this.d = new AtomicLong(aVar.c);
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.i = aVar.g;
        this.h = new AtomicInteger(-1);
        a(aVar.qan);
        this.n = new AtomicBoolean(false);
    }

    public b(Cursor cursor) {
        if (cursor != null) {
            this.f13450b = cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
            this.g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
            this.c = cursor.getLong(cursor.getColumnIndex("startOffset"));
            int columnIndex = cursor.getColumnIndex("curOffset");
            if (columnIndex != -1) {
                this.d = new AtomicLong(cursor.getLong(columnIndex));
            } else {
                this.d = new AtomicLong(0L);
            }
            this.e = cursor.getLong(cursor.getColumnIndex("endOffset"));
            int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
            if (columnIndex2 != -1) {
                this.h = new AtomicInteger(cursor.getInt(columnIndex2));
            } else {
                this.h = new AtomicInteger(-1);
            }
            int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
            if (columnIndex3 != -1) {
                this.f = cursor.getLong(columnIndex3);
            }
            this.n = new AtomicBoolean(false);
        }
    }

    protected b(Parcel parcel) {
        this.f13450b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = new AtomicLong(parcel.readLong());
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readInt();
        this.h = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13450b);
        parcel.writeLong(this.c);
        long j = 0;
        if (this.d != null) {
            j = this.d.get();
        }
        parcel.writeLong(j);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g);
        int i2 = -1;
        if (this.h != null) {
            i2 = this.h.get();
        }
        parcel.writeInt(i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContentValues eIk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMConstants.MSG_ROW_ID, Integer.valueOf(this.f13450b));
        contentValues.put("chunkIndex", Integer.valueOf(this.g));
        contentValues.put("startOffset", Long.valueOf(this.c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public void b(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.l = 0;
            sQLiteStatement.clearBindings();
            int i = this.l + 1;
            this.l = i;
            sQLiteStatement.bindLong(i, this.f13450b);
            int i2 = this.l + 1;
            this.l = i2;
            sQLiteStatement.bindLong(i2, this.g);
            int i3 = this.l + 1;
            this.l = i3;
            sQLiteStatement.bindLong(i3, this.c);
            int i4 = this.l + 1;
            this.l = i4;
            sQLiteStatement.bindLong(i4, n());
            int i5 = this.l + 1;
            this.l = i5;
            sQLiteStatement.bindLong(i5, this.e);
            int i6 = this.l + 1;
            this.l = i6;
            sQLiteStatement.bindLong(i6, this.f);
            int i7 = this.l + 1;
            this.l = i7;
            sQLiteStatement.bindLong(i7, b());
        }
    }

    public int b() {
        if (this.h == null) {
            return -1;
        }
        return this.h.get();
    }

    public void a(int i) {
        if (this.h == null) {
            this.h = new AtomicInteger(i);
        } else {
            this.h.set(i);
        }
    }

    public boolean c() {
        if (this.n == null) {
            return false;
        }
        return this.n.get();
    }

    public void a(com.ss.android.socialbase.downloader.l.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        if (this.n == null) {
            this.n = new AtomicBoolean(z);
        } else {
            this.n.set(z);
        }
        this.o = null;
    }

    public void a(b bVar) {
        this.k = bVar;
        if (this.k != null) {
            a(this.k.s());
        }
    }

    public boolean d() {
        return b() == -1;
    }

    public b eIl() {
        if (!d()) {
            this = this.k;
        }
        if (this == null || !this.f()) {
            return null;
        }
        return this.g().get(0);
    }

    public boolean f() {
        return this.j != null && this.j.size() > 0;
    }

    public void a(List<b> list) {
        this.j = list;
    }

    public List<b> g() {
        return this.j;
    }

    public boolean h() {
        if (this.k == null) {
            return true;
        }
        if (this.k.f()) {
            for (int i = 0; i < this.k.g().size(); i++) {
                b bVar = this.k.g().get(i);
                if (bVar != null) {
                    int indexOf = this.k.g().indexOf(this);
                    if (indexOf > i && !bVar.i()) {
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

    public void b(boolean z) {
        this.m = z;
    }

    public boolean i() {
        long j = this.c;
        if (d() && this.i > this.c) {
            j = this.i;
        }
        return n() - j >= this.f;
    }

    public long j() {
        if (this.k == null || this.k.g() == null) {
            return -1L;
        }
        int indexOf = this.k.g().indexOf(this);
        boolean z = false;
        for (int i = 0; i < this.k.g().size(); i++) {
            b bVar = this.k.g().get(i);
            if (bVar != null) {
                if (z) {
                    return bVar.n();
                }
                if (indexOf == i) {
                    z = true;
                }
            }
        }
        return -1L;
    }

    public void b(int i) {
        this.f13450b = i;
    }

    public void c(int i) {
        this.g = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public int k() {
        return this.f13450b;
    }

    public long l() {
        return this.c;
    }

    public long m() {
        if (this.d != null) {
            return this.d.get();
        }
        return 0L;
    }

    public long n() {
        if (d() && f()) {
            long j = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.j.size()) {
                    b bVar = this.j.get(i2);
                    if (bVar != null) {
                        if (!bVar.i()) {
                            return bVar.m();
                        }
                        if (j < bVar.m()) {
                            j = bVar.m();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return j;
                }
            }
        } else {
            return m();
        }
    }

    public void b(long j) {
        if (this.d != null) {
            this.d.set(j);
        } else {
            this.d = new AtomicLong(j);
        }
    }

    public long o() {
        long n = n() - this.c;
        if (f()) {
            n = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.j.size()) {
                    break;
                }
                b bVar = this.j.get(i2);
                if (bVar != null) {
                    n += bVar.n() - bVar.l();
                }
                i = i2 + 1;
            }
        }
        return n;
    }

    public long p() {
        return this.e;
    }

    public long q() {
        return this.f;
    }

    public void r() {
        this.i = n();
    }

    public long BX(boolean z) {
        long n = n();
        long j = this.f - (n - this.i);
        if (!z && n == this.i) {
            j = this.f - (n - this.c);
        }
        com.ss.android.socialbase.downloader.f.a.b("DownloadChunk", "contentLength:" + this.f + " curOffset:" + n() + " oldOffset:" + this.i + " retainLen:" + j);
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public List<b> D(int i, long j) {
        long p;
        long j2;
        long j3;
        long j4;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m = m();
        long BX = BX(true);
        long j5 = BX / i;
        com.ss.android.socialbase.downloader.f.a.b(f13449a, "retainLen:" + BX + " divideChunkForReuse chunkSize:" + j5 + " current host downloadChunk index:" + this.g);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            if (i3 == 0) {
                j3 = l();
                j2 = (m + j5) - 1;
                j4 = j5;
            } else if (i3 == i - 1) {
                j2 = p();
                if (j2 > m) {
                    j4 = 1 + (j2 - m);
                    j3 = m;
                } else {
                    j4 = BX - ((i - 1) * j5);
                    j3 = m;
                }
            } else {
                j2 = (m + j5) - 1;
                j3 = m;
                j4 = j5;
            }
            b eIm = new a(this.f13450b).SN((-i3) - 1).jf(j3).jg(m).jj(m).jh(j2).ji(j4).c(this).eIm();
            com.ss.android.socialbase.downloader.f.a.b(f13449a, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + m + " endOffset:" + j2 + " contentLen:" + j4);
            arrayList.add(eIm);
            m += j5;
            i2 = i3 + 1;
        }
        long j6 = 0;
        int size = arrayList.size() - 1;
        while (size > 0) {
            b bVar = arrayList.get(size);
            size--;
            j6 = bVar != null ? bVar.q() + j6 : j6;
        }
        com.ss.android.socialbase.downloader.f.a.b(f13449a, "reuseChunkContentLen:" + j6);
        b bVar2 = arrayList.get(0);
        if (bVar2 != null) {
            if (p() == 0) {
                p = j - l();
            } else {
                p = (p() - l()) + 1;
            }
            bVar2.a(p - j6);
            bVar2.c(this.g);
            if (this.o != null) {
                this.o.a(bVar2.p(), q() - j6);
            }
        }
        a(arrayList);
        return arrayList;
    }

    public int s() {
        return this.g;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f13451a;

        /* renamed from: b  reason: collision with root package name */
        private long f13452b;
        private long c;
        private long d;
        private long e;
        private int f;
        private long g;
        private b qan;

        public a(int i) {
            this.f13451a = i;
        }

        public a jf(long j) {
            this.f13452b = j;
            return this;
        }

        public a jg(long j) {
            this.c = j;
            return this;
        }

        public a jh(long j) {
            this.d = j;
            return this;
        }

        public a ji(long j) {
            this.e = j;
            return this;
        }

        public a SN(int i) {
            this.f = i;
            return this;
        }

        public a c(b bVar) {
            this.qan = bVar;
            return this;
        }

        public a jj(long j) {
            this.g = j;
            return this;
        }

        public b eIm() {
            return new b(this);
        }
    }
}
