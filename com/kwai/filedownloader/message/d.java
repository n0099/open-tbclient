package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes6.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes6.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i, boolean z, long j) {
            super(i, z, j);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37433b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37434c;

        public b(int i, boolean z, long j) {
            super(i);
            this.f37433b = z;
            this.f37434c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37433b = parcel.readByte() != 0;
            this.f37434c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37434c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37433b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37433b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37434c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37435b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37436c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37437d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37438e;

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.f37435b = z;
            this.f37436c = j;
            this.f37437d = str;
            this.f37438e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37435b = parcel.readByte() != 0;
            this.f37436c = parcel.readLong();
            this.f37437d = parcel.readString();
            this.f37438e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37436c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37438e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37435b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37437d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37435b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37436c);
            parcel.writeString(this.f37437d);
            parcel.writeString(this.f37438e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0465d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37439b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37440c;

        public C0465d(int i, long j, Throwable th) {
            super(i);
            this.f37439b = j;
            this.f37440c = th;
        }

        public C0465d(Parcel parcel) {
            super(parcel);
            this.f37439b = parcel.readLong();
            this.f37440c = (Throwable) parcel.readSerializable();
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
            return this.f37439b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f37440c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37439b);
            parcel.writeSerializable(this.f37440c);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends f {
        public e(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37441b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37442c;

        public f(int i, long j, long j2) {
            super(i);
            this.f37441b = j;
            this.f37442c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37441b = parcel.readLong();
            this.f37442c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37442c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f37441b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37441b);
            parcel.writeLong(this.f37442c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37443b;

        public g(int i, long j) {
            super(i);
            this.f37443b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37443b = parcel.readLong();
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
            return this.f37443b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37443b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0465d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37444b;

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.f37444b = i2;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f37444b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0465d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0465d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f37444b;
        }

        @Override // com.kwai.filedownloader.message.d.C0465d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37444b);
        }
    }

    /* loaded from: classes6.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* loaded from: classes6.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i, long j, long j2) {
            super(i, j, j2);
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
        this.f37430a = true;
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
