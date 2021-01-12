package com.kwai.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.IMConstants;
import com.kwai.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
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
    private int f10888a;

    /* renamed from: b  reason: collision with root package name */
    private String f10889b;
    private String c;
    private boolean d;
    private String e;
    private final AtomicInteger f;
    private final AtomicLong g;
    private long h;
    private String i;
    private String j;
    private int k;
    private boolean l;

    public c() {
        this.g = new AtomicLong();
        this.f = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.f10888a = parcel.readInt();
        this.f10889b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readString();
        this.f = new AtomicInteger(parcel.readByte());
        this.g = new AtomicLong(parcel.readLong());
        this.h = parcel.readLong();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        return this.f10888a;
    }

    public void a(byte b2) {
        this.f.set(b2);
    }

    public void a(int i) {
        this.f10888a = i;
    }

    public void a(long j) {
        this.g.set(j);
    }

    public void a(String str) {
        this.f10889b = str;
    }

    public void a(String str, boolean z) {
        this.c = str;
        this.d = z;
    }

    public String b() {
        return this.f10889b;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(long j) {
        this.g.addAndGet(j);
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.c;
    }

    public void c(long j) {
        this.l = j > 2147483647L;
        this.h = j;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.e = str;
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
        return (byte) this.f.get();
    }

    public long g() {
        return this.g.get();
    }

    public long h() {
        return this.h;
    }

    public boolean i() {
        return this.h == -1;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.d;
    }

    public String m() {
        return this.e;
    }

    public int n() {
        return this.k;
    }

    public void o() {
        this.k = 1;
    }

    public ContentValues p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMConstants.MSG_ROW_ID, Integer.valueOf(a()));
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
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f10888a), this.f10889b, this.c, Integer.valueOf(this.f.get()), this.g, Long.valueOf(this.h), this.j, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10888a);
        parcel.writeString(this.f10889b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.e);
        parcel.writeByte((byte) this.f.get());
        parcel.writeLong(this.g.get());
        parcel.writeLong(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
