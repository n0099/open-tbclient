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
        public final boolean f37338b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37339c;

        public b(int i, boolean z, long j) {
            super(i);
            this.f37338b = z;
            this.f37339c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37338b = parcel.readByte() != 0;
            this.f37339c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37339c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37338b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37338b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37339c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37340b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37341c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37342d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37343e;

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.f37340b = z;
            this.f37341c = j;
            this.f37342d = str;
            this.f37343e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37340b = parcel.readByte() != 0;
            this.f37341c = parcel.readLong();
            this.f37342d = parcel.readString();
            this.f37343e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37341c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37343e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37340b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37342d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37340b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37341c);
            parcel.writeString(this.f37342d);
            parcel.writeString(this.f37343e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0462d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37344b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37345c;

        public C0462d(int i, long j, Throwable th) {
            super(i);
            this.f37344b = j;
            this.f37345c = th;
        }

        public C0462d(Parcel parcel) {
            super(parcel);
            this.f37344b = parcel.readLong();
            this.f37345c = (Throwable) parcel.readSerializable();
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
            return this.f37344b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f37345c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37344b);
            parcel.writeSerializable(this.f37345c);
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
        public final long f37346b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37347c;

        public f(int i, long j, long j2) {
            super(i);
            this.f37346b = j;
            this.f37347c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37346b = parcel.readLong();
            this.f37347c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37347c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f37346b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37346b);
            parcel.writeLong(this.f37347c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37348b;

        public g(int i, long j) {
            super(i);
            this.f37348b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37348b = parcel.readLong();
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
            return this.f37348b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f37348b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0462d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37349b;

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.f37349b = i2;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f37349b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0462d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0462d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f37349b;
        }

        @Override // com.kwai.filedownloader.message.d.C0462d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37349b);
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
        this.f37335a = true;
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
