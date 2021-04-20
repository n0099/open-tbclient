package com.kwai.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f37196a;

    /* renamed from: b  reason: collision with root package name */
    public String f37197b;

    /* renamed from: c  reason: collision with root package name */
    public String f37198c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37199d;

    /* renamed from: e  reason: collision with root package name */
    public String f37200e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f37201f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f37202g;

    /* renamed from: h  reason: collision with root package name */
    public long f37203h;
    public String i;
    public String j;
    public int k;
    public boolean l;

    public c() {
        this.f37202g = new AtomicLong();
        this.f37201f = new AtomicInteger();
    }

    public c(Parcel parcel) {
        this.f37196a = parcel.readInt();
        this.f37197b = parcel.readString();
        this.f37198c = parcel.readString();
        this.f37199d = parcel.readByte() != 0;
        this.f37200e = parcel.readString();
        this.f37201f = new AtomicInteger(parcel.readByte());
        this.f37202g = new AtomicLong(parcel.readLong());
        this.f37203h = parcel.readLong();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        return this.f37196a;
    }

    public void a(byte b2) {
        this.f37201f.set(b2);
    }

    public void a(int i) {
        this.f37196a = i;
    }

    public void a(long j) {
        this.f37202g.set(j);
    }

    public void a(String str) {
        this.f37197b = str;
    }

    public void a(String str, boolean z) {
        this.f37198c = str;
        this.f37199d = z;
    }

    public String b() {
        return this.f37197b;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(long j) {
        this.f37202g.addAndGet(j);
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f37198c;
    }

    public void c(long j) {
        this.l = j > 2147483647L;
        this.f37203h = j;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.f37200e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        if (d() == null) {
            return null;
        }
        return f.d(d());
    }

    public byte f() {
        return (byte) this.f37201f.get();
    }

    public long g() {
        return this.f37202g.get();
    }

    public long h() {
        return this.f37203h;
    }

    public boolean i() {
        return this.f37203h == -1;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.f37199d;
    }

    public String m() {
        return this.f37200e;
    }

    public int n() {
        return this.k;
    }

    public void o() {
        this.k = 1;
    }

    public ContentValues p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(a()));
        contentValues.put("url", b());
        contentValues.put("path", c());
        contentValues.put("status", Byte.valueOf(f()));
        contentValues.put("sofar", Long.valueOf(g()));
        contentValues.put("total", Long.valueOf(h()));
        contentValues.put("errMsg", k());
        contentValues.put("etag", j());
        contentValues.put("connectionCount", Integer.valueOf(n()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(l()));
        if (l() && m() != null) {
            contentValues.put("filename", m());
        }
        return contentValues;
    }

    public boolean q() {
        return this.l;
    }

    public String toString() {
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f37196a), this.f37197b, this.f37198c, Integer.valueOf(this.f37201f.get()), this.f37202g, Long.valueOf(this.f37203h), this.j, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f37196a);
        parcel.writeString(this.f37197b);
        parcel.writeString(this.f37198c);
        parcel.writeByte(this.f37199d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f37200e);
        parcel.writeByte((byte) this.f37201f.get());
        parcel.writeLong(this.f37202g.get());
        parcel.writeLong(this.f37203h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
