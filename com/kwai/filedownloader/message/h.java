package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes6.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes6.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i, boolean z, int i2) {
            super(i, z, i2);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37360b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37361c;

        public b(int i, boolean z, int i2) {
            super(i);
            this.f37360b = z;
            this.f37361c = i2;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37360b = parcel.readByte() != 0;
            this.f37361c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37361c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37360b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37360b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37361c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37362b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37363c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37364d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37365e;

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.f37362b = z;
            this.f37363c = i2;
            this.f37364d = str;
            this.f37365e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37362b = parcel.readByte() != 0;
            this.f37363c = parcel.readInt();
            this.f37364d = parcel.readString();
            this.f37365e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37363c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37365e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37362b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37364d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37362b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37363c);
            parcel.writeString(this.f37364d);
            parcel.writeString(this.f37365e);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37366b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37367c;

        public d(int i, int i2, Throwable th) {
            super(i);
            this.f37366b = i2;
            this.f37367c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f37366b = parcel.readInt();
            this.f37367c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37366b;
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
        public Throwable j() {
            return this.f37367c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37366b);
            parcel.writeSerializable(this.f37367c);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends f {
        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37368b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37369c;

        public f(int i, int i2, int i3) {
            super(i);
            this.f37368b = i2;
            this.f37369c = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37368b = parcel.readInt();
            this.f37369c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37368b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37369c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37368b);
            parcel.writeInt(this.f37369c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37370b;

        public g(int i, int i2) {
            super(i);
            this.f37370b = i2;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37370b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37370b;
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37370b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0463h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37371b;

        public C0463h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.f37371b = i3;
        }

        public C0463h(Parcel parcel) {
            super(parcel);
            this.f37371b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f37371b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37371b);
        }
    }

    /* loaded from: classes6.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: classes6.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public MessageSnapshot l() {
            return new f(this);
        }
    }

    public h(int i2) {
        super(i2);
        this.f37335a = false;
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public long d() {
        return c();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public long i() {
        return a();
    }
}
