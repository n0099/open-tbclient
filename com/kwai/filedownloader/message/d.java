package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes7.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes7.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i2, boolean z, long j) {
            super(i2, z, j);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37813b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37814c;

        public b(int i2, boolean z, long j) {
            super(i2);
            this.f37813b = z;
            this.f37814c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37813b = parcel.readByte() != 0;
            this.f37814c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37814c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37813b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37813b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37814c);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37815b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37816c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37817d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37818e;

        public c(int i2, boolean z, long j, String str, String str2) {
            super(i2);
            this.f37815b = z;
            this.f37816c = j;
            this.f37817d = str;
            this.f37818e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37815b = parcel.readByte() != 0;
            this.f37816c = parcel.readLong();
            this.f37817d = parcel.readString();
            this.f37818e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37816c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37818e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37815b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37817d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37815b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37816c);
            parcel.writeString(this.f37817d);
            parcel.writeString(this.f37818e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0448d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37819b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37820c;

        public C0448d(int i2, long j, Throwable th) {
            super(i2);
            this.f37819b = j;
            this.f37820c = th;
        }

        public C0448d(Parcel parcel) {
            super(parcel);
            this.f37819b = parcel.readLong();
            this.f37820c = (Throwable) parcel.readSerializable();
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
            return this.f37819b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f37820c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37819b);
            parcel.writeSerializable(this.f37820c);
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends f {
        public e(int i2, long j, long j2) {
            super(i2, j, j2);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37821b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37822c;

        public f(int i2, long j, long j2) {
            super(i2);
            this.f37821b = j;
            this.f37822c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37821b = parcel.readLong();
            this.f37822c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37822c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f37821b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37821b);
            parcel.writeLong(this.f37822c);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37823b;

        public g(int i2, long j) {
            super(i2);
            this.f37823b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37823b = parcel.readLong();
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
            return this.f37823b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37823b);
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends C0448d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37824b;

        public h(int i2, long j, Throwable th, int i3) {
            super(i2, j, th);
            this.f37824b = i3;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f37824b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0448d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0448d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f37824b;
        }

        @Override // com.kwai.filedownloader.message.d.C0448d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37824b);
        }
    }

    /* loaded from: classes7.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i2, long j, long j2) {
            super(i2, j, j2);
        }
    }

    /* loaded from: classes7.dex */
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
        this.f37810a = true;
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
