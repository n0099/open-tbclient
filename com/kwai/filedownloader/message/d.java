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
        public final boolean f34400b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34401c;

        public b(int i2, boolean z, long j) {
            super(i2);
            this.f34400b = z;
            this.f34401c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f34400b = parcel.readByte() != 0;
            this.f34401c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34401c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f34400b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f34400b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f34401c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f34402b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34403c;

        /* renamed from: d  reason: collision with root package name */
        public final String f34404d;

        /* renamed from: e  reason: collision with root package name */
        public final String f34405e;

        public c(int i2, boolean z, long j, String str, String str2) {
            super(i2);
            this.f34402b = z;
            this.f34403c = j;
            this.f34404d = str;
            this.f34405e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f34402b = parcel.readByte() != 0;
            this.f34403c = parcel.readLong();
            this.f34404d = parcel.readString();
            this.f34405e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34403c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f34405e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f34402b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f34404d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f34402b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f34403c);
            parcel.writeString(this.f34404d);
            parcel.writeString(this.f34405e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0397d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f34406b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f34407c;

        public C0397d(int i2, long j, Throwable th) {
            super(i2);
            this.f34406b = j;
            this.f34407c = th;
        }

        public C0397d(Parcel parcel) {
            super(parcel);
            this.f34406b = parcel.readLong();
            this.f34407c = (Throwable) parcel.readSerializable();
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
            return this.f34406b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f34407c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34406b);
            parcel.writeSerializable(this.f34407c);
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
        public final long f34408b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34409c;

        public f(int i2, long j, long j2) {
            super(i2);
            this.f34408b = j;
            this.f34409c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f34408b = parcel.readLong();
            this.f34409c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f34409c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f34408b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34408b);
            parcel.writeLong(this.f34409c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f34410b;

        public g(int i2, long j) {
            super(i2);
            this.f34410b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f34410b = parcel.readLong();
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
            return this.f34410b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f34410b);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends C0397d {

        /* renamed from: b  reason: collision with root package name */
        public final int f34411b;

        public h(int i2, long j, Throwable th, int i3) {
            super(i2, j, th);
            this.f34411b = i3;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f34411b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0397d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0397d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f34411b;
        }

        @Override // com.kwai.filedownloader.message.d.C0397d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f34411b);
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
        this.f34397a = true;
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
