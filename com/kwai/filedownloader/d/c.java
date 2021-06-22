package com.kwai.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
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
        public c[] newArray(int i2) {
            return new c[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f37765a;

    /* renamed from: b  reason: collision with root package name */
    public String f37766b;

    /* renamed from: c  reason: collision with root package name */
    public String f37767c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37768d;

    /* renamed from: e  reason: collision with root package name */
    public String f37769e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f37770f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f37771g;

    /* renamed from: h  reason: collision with root package name */
    public long f37772h;

    /* renamed from: i  reason: collision with root package name */
    public String f37773i;
    public String j;
    public int k;
    public boolean l;

    public c() {
        this.f37771g = new AtomicLong();
        this.f37770f = new AtomicInteger();
    }

    public c(Parcel parcel) {
        this.f37765a = parcel.readInt();
        this.f37766b = parcel.readString();
        this.f37767c = parcel.readString();
        this.f37768d = parcel.readByte() != 0;
        this.f37769e = parcel.readString();
        this.f37770f = new AtomicInteger(parcel.readByte());
        this.f37771g = new AtomicLong(parcel.readLong());
        this.f37772h = parcel.readLong();
        this.f37773i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        return this.f37765a;
    }

    public void a(byte b2) {
        this.f37770f.set(b2);
    }

    public void a(int i2) {
        this.f37765a = i2;
    }

    public void a(long j) {
        this.f37771g.set(j);
    }

    public void a(String str) {
        this.f37766b = str;
    }

    public void a(String str, boolean z) {
        this.f37767c = str;
        this.f37768d = z;
    }

    public String b() {
        return this.f37766b;
    }

    public void b(int i2) {
        this.k = i2;
    }

    public void b(long j) {
        this.f37771g.addAndGet(j);
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f37767c;
    }

    public void c(long j) {
        this.l = j > 2147483647L;
        this.f37772h = j;
    }

    public void c(String str) {
        this.f37773i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.f37769e = str;
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
        return (byte) this.f37770f.get();
    }

    public long g() {
        return this.f37771g.get();
    }

    public long h() {
        return this.f37772h;
    }

    public boolean i() {
        return this.f37772h == -1;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.f37773i;
    }

    public boolean l() {
        return this.f37768d;
    }

    public String m() {
        return this.f37769e;
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
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f37765a), this.f37766b, this.f37767c, Integer.valueOf(this.f37770f.get()), this.f37771g, Long.valueOf(this.f37772h), this.j, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f37765a);
        parcel.writeString(this.f37766b);
        parcel.writeString(this.f37767c);
        parcel.writeByte(this.f37768d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f37769e);
        parcel.writeByte((byte) this.f37770f.get());
        parcel.writeLong(this.f37771g.get());
        parcel.writeLong(this.f37772h);
        parcel.writeString(this.f37773i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
