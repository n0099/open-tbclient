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
        public final boolean f34329b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34330c;

        public b(int i2, boolean z, long j) {
            super(i2);
            this.f34329b = z;
            this.f34330c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f34329b = parcel.readByte() != 0;
            this.f34330c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34330c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f34329b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f34329b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f34330c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f34331b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34332c;

        /* renamed from: d  reason: collision with root package name */
        public final String f34333d;

        /* renamed from: e  reason: collision with root package name */
        public final String f34334e;

        public c(int i2, boolean z, long j, String str, String str2) {
            super(i2);
            this.f34331b = z;
            this.f34332c = j;
            this.f34333d = str;
            this.f34334e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f34331b = parcel.readByte() != 0;
            this.f34332c = parcel.readLong();
            this.f34333d = parcel.readString();
            this.f34334e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34332c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f34334e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f34331b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f34333d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f34331b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f34332c);
            parcel.writeString(this.f34333d);
            parcel.writeString(this.f34334e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0398d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f34335b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f34336c;

        public C0398d(int i2, long j, Throwable th) {
            super(i2);
            this.f34335b = j;
            this.f34336c = th;
        }

        public C0398d(Parcel parcel) {
            super(parcel);
            this.f34335b = parcel.readLong();
            this.f34336c = (Throwable) parcel.readSerializable();
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
            return this.f34335b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f34336c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34335b);
            parcel.writeSerializable(this.f34336c);
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
        public final long f34337b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34338c;

        public f(int i2, long j, long j2) {
            super(i2);
            this.f34337b = j;
            this.f34338c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f34337b = parcel.readLong();
            this.f34338c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34338c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f34337b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34337b);
            parcel.writeLong(this.f34338c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f34339b;

        public g(int i2, long j) {
            super(i2);
            this.f34339b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f34339b = parcel.readLong();
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
            return this.f34339b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34339b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0398d {

        /* renamed from: b  reason: collision with root package name */
        public final int f34340b;

        public h(int i2, long j, Throwable th, int i3) {
            super(i2, j, th);
            this.f34340b = i3;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f34340b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0398d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0398d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f34340b;
        }

        @Override // com.kwai.filedownloader.message.d.C0398d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f34340b);
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
        this.f34326a = true;
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
