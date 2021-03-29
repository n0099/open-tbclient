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
        public final boolean f37049b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37050c;

        public b(int i, boolean z, long j) {
            super(i);
            this.f37049b = z;
            this.f37050c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37049b = parcel.readByte() != 0;
            this.f37050c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37050c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37049b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37049b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37050c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37051b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37052c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37053d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37054e;

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.f37051b = z;
            this.f37052c = j;
            this.f37053d = str;
            this.f37054e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37051b = parcel.readByte() != 0;
            this.f37052c = parcel.readLong();
            this.f37053d = parcel.readString();
            this.f37054e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37052c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37054e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37051b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37053d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37051b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37052c);
            parcel.writeString(this.f37053d);
            parcel.writeString(this.f37054e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0448d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37055b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37056c;

        public C0448d(int i, long j, Throwable th) {
            super(i);
            this.f37055b = j;
            this.f37056c = th;
        }

        public C0448d(Parcel parcel) {
            super(parcel);
            this.f37055b = parcel.readLong();
            this.f37056c = (Throwable) parcel.readSerializable();
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
            return this.f37055b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f37056c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37055b);
            parcel.writeSerializable(this.f37056c);
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
        public final long f37057b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37058c;

        public f(int i, long j, long j2) {
            super(i);
            this.f37057b = j;
            this.f37058c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37057b = parcel.readLong();
            this.f37058c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37058c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f37057b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37057b);
            parcel.writeLong(this.f37058c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37059b;

        public g(int i, long j) {
            super(i);
            this.f37059b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37059b = parcel.readLong();
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
            return this.f37059b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37059b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0448d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37060b;

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.f37060b = i2;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f37060b = parcel.readInt();
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
            return this.f37060b;
        }

        @Override // com.kwai.filedownloader.message.d.C0448d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37060b);
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
        this.f37046a = true;
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
