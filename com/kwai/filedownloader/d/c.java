package com.kwai.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
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
    public int f36907a;

    /* renamed from: b  reason: collision with root package name */
    public String f36908b;

    /* renamed from: c  reason: collision with root package name */
    public String f36909c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36910d;

    /* renamed from: e  reason: collision with root package name */
    public String f36911e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f36912f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f36913g;

    /* renamed from: h  reason: collision with root package name */
    public long f36914h;
    public String i;
    public String j;
    public int k;
    public boolean l;

    public c() {
        this.f36913g = new AtomicLong();
        this.f36912f = new AtomicInteger();
    }

    public c(Parcel parcel) {
        this.f36907a = parcel.readInt();
        this.f36908b = parcel.readString();
        this.f36909c = parcel.readString();
        this.f36910d = parcel.readByte() != 0;
        this.f36911e = parcel.readString();
        this.f36912f = new AtomicInteger(parcel.readByte());
        this.f36913g = new AtomicLong(parcel.readLong());
        this.f36914h = parcel.readLong();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        return this.f36907a;
    }

    public void a(byte b2) {
        this.f36912f.set(b2);
    }

    public void a(int i) {
        this.f36907a = i;
    }

    public void a(long j) {
        this.f36913g.set(j);
    }

    public void a(String str) {
        this.f36908b = str;
    }

    public void a(String str, boolean z) {
        this.f36909c = str;
        this.f36910d = z;
    }

    public String b() {
        return this.f36908b;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(long j) {
        this.f36913g.addAndGet(j);
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.f36909c;
    }

    public void c(long j) {
        this.l = j > 2147483647L;
        this.f36914h = j;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.f36911e = str;
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
        return (byte) this.f36912f.get();
    }

    public long g() {
        return this.f36913g.get();
    }

    public long h() {
        return this.f36914h;
    }

    public boolean i() {
        return this.f36914h == -1;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.f36910d;
    }

    public String m() {
        return this.f36911e;
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
            contentValues.put(BreakpointSQLiteKey.FILENAME, m());
        }
        return contentValues;
    }

    public boolean q() {
        return this.l;
    }

    public String toString() {
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f36907a), this.f36908b, this.f36909c, Integer.valueOf(this.f36912f.get()), this.f36913g, Long.valueOf(this.f36914h), this.j, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f36907a);
        parcel.writeString(this.f36908b);
        parcel.writeString(this.f36909c);
        parcel.writeByte(this.f36910d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f36911e);
        parcel.writeByte((byte) this.f36912f.get());
        parcel.writeLong(this.f36913g.get());
        parcel.writeLong(this.f36914h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
