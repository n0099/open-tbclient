package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes6.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes6.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i2, boolean z, long j) {
            super(i2, z, j);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35155b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35156c;

        public b(int i2, boolean z, long j) {
            super(i2);
            this.f35155b = z;
            this.f35156c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f35155b = parcel.readByte() != 0;
            this.f35156c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f35156c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f35155b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f35155b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f35156c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35157b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35158c;

        /* renamed from: d  reason: collision with root package name */
        public final String f35159d;

        /* renamed from: e  reason: collision with root package name */
        public final String f35160e;

        public c(int i2, boolean z, long j, String str, String str2) {
            super(i2);
            this.f35157b = z;
            this.f35158c = j;
            this.f35159d = str;
            this.f35160e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f35157b = parcel.readByte() != 0;
            this.f35158c = parcel.readLong();
            this.f35159d = parcel.readString();
            this.f35160e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f35158c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f35160e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f35157b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f35159d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f35157b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f35158c);
            parcel.writeString(this.f35159d);
            parcel.writeString(this.f35160e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0410d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f35161b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f35162c;

        public C0410d(int i2, long j, Throwable th) {
            super(i2);
            this.f35161b = j;
            this.f35162c = th;
        }

        public C0410d(Parcel parcel) {
            super(parcel);
            this.f35161b = parcel.readLong();
            this.f35162c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f35161b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f35162c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f35161b);
            parcel.writeSerializable(this.f35162c);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends f {
        public e(int i2, long j, long j2) {
            super(i2, j, j2);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f35163b;

        /* renamed from: c  reason: collision with root package name */
        public final long f35164c;

        public f(int i2, long j, long j2) {
            super(i2);
            this.f35163b = j;
            this.f35164c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f35163b = parcel.readLong();
            this.f35164c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f35164c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f35163b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f35163b);
            parcel.writeLong(this.f35164c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f35165b;

        public g(int i2, long j) {
            super(i2);
            this.f35165b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f35165b = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f35165b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f35165b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0410d {

        /* renamed from: b  reason: collision with root package name */
        public final int f35166b;

        public h(int i2, long j, Throwable th, int i3) {
            super(i2, j, th);
            this.f35166b = i3;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f35166b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0410d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0410d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f35166b;
        }

        @Override // com.kwai.filedownloader.message.d.C0410d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f35166b);
        }
    }

    /* loaded from: classes6.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i2, long j, long j2) {
            super(i2, j, j2);
        }
    }

    /* loaded from: classes6.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i2, long j, long j2) {
            super(i2, j, j2);
        }

        public j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public MessageSnapshot l() {
            return new f(this);
        }
    }

    public d(int i2) {
        super(i2);
        this.f35152a = true;
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public int a() {
        if (i() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) i();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public int c() {
        if (d() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) d();
    }
}
