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
        public c[] newArray(int i2) {
            return new c[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f35009a;

    /* renamed from: b  reason: collision with root package name */
    public String f35010b;

    /* renamed from: c  reason: collision with root package name */
    public String f35011c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35012d;

    /* renamed from: e  reason: collision with root package name */
    public String f35013e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f35014f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f35015g;

    /* renamed from: h  reason: collision with root package name */
    public long f35016h;

    /* renamed from: i  reason: collision with root package name */
    public String f35017i;
    public String j;
    public int k;
    public boolean l;

    public c() {
        this.f35015g = new AtomicLong();
        this.f35014f = new AtomicInteger();
    }

    public c(Parcel parcel) {
        this.f35009a = parcel.readInt();
        this.f35010b = parcel.readString();
        this.f35011c = parcel.readString();
        this.f35012d = parcel.readByte() != 0;
        this.f35013e = parcel.readString();
        this.f35014f = new AtomicInteger(parcel.readByte());
        this.f35015g = new AtomicLong(parcel.readLong());
        this.f35016h = parcel.readLong();
        this.f35017i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        return this.f35009a;
    }

    public void a(byte b2) {
        this.f35014f.set(b2);
    }

    public void a(int i2) {
        this.f35009a = i2;
    }

    public void a(long j) {
        this.f35015g.set(j);
    }

    public void a(String str) {
        this.f35010b = str;
    }

    public void a(String str, boolean z) {
        this.f35011c = str;
        this.f35012d = z;
    }

    public String b() {
        return this.f35010b;
    }

    public void b(int i2) {
        this.k = i2;
    }

    public void b(long j) {
        this.f35015g.addAndGet(j);
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f35011c;
    }

    public void c(long j) {
        this.l = j > 2147483647L;
        this.f35016h = j;
    }

    public void c(String str) {
        this.f35017i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.f35013e = str;
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
        return (byte) this.f35014f.get();
    }

    public long g() {
        return this.f35015g.get();
    }

    public long h() {
        return this.f35016h;
    }

    public boolean i() {
        return this.f35016h == -1;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.f35017i;
    }

    public boolean l() {
        return this.f35012d;
    }

    public String m() {
        return this.f35013e;
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
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f35009a), this.f35010b, this.f35011c, Integer.valueOf(this.f35014f.get()), this.f35015g, Long.valueOf(this.f35016h), this.j, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35009a);
        parcel.writeString(this.f35010b);
        parcel.writeString(this.f35011c);
        parcel.writeByte(this.f35012d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f35013e);
        parcel.writeByte((byte) this.f35014f.get());
        parcel.writeLong(this.f35015g.get());
        parcel.writeLong(this.f35016h);
        parcel.writeString(this.f35017i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
