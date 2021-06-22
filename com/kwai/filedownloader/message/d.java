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
        public final boolean f37911b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37912c;

        public b(int i2, boolean z, long j) {
            super(i2);
            this.f37911b = z;
            this.f37912c = j;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37911b = parcel.readByte() != 0;
            this.f37912c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37912c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37911b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37911b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37912c);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37913b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37914c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37915d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37916e;

        public c(int i2, boolean z, long j, String str, String str2) {
            super(i2);
            this.f37913b = z;
            this.f37914c = j;
            this.f37915d = str;
            this.f37916e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37913b = parcel.readByte() != 0;
            this.f37914c = parcel.readLong();
            this.f37915d = parcel.readString();
            this.f37916e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37914c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37916e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37913b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37915d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37913b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f37914c);
            parcel.writeString(this.f37915d);
            parcel.writeString(this.f37916e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0451d extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37917b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37918c;

        public C0451d(int i2, long j, Throwable th) {
            super(i2);
            this.f37917b = j;
            this.f37918c = th;
        }

        public C0451d(Parcel parcel) {
            super(parcel);
            this.f37917b = parcel.readLong();
            this.f37918c = (Throwable) parcel.readSerializable();
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
            return this.f37917b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.f37918c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37917b);
            parcel.writeSerializable(this.f37918c);
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
        public final long f37919b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37920c;

        public f(int i2, long j, long j2) {
            super(i2);
            this.f37919b = j;
            this.f37920c = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37919b = parcel.readLong();
            this.f37920c = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.f37920c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f37919b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37919b);
            parcel.writeLong(this.f37920c);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        public final long f37921b;

        public g(int i2, long j) {
            super(i2);
            this.f37921b = j;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37921b = parcel.readLong();
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
            return this.f37921b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f37921b);
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends C0451d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37922b;

        public h(int i2, long j, Throwable th, int i3) {
            super(i2, j, th);
            this.f37922b = i3;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f37922b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0451d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C0451d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f37922b;
        }

        @Override // com.kwai.filedownloader.message.d.C0451d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37922b);
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
        this.f37908a = true;
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
