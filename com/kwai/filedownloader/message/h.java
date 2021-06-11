package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes7.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes7.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i2, boolean z, int i3) {
            super(i2, z, i3);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37835b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37836c;

        public b(int i2, boolean z, int i3) {
            super(i2);
            this.f37835b = z;
            this.f37836c = i3;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37835b = parcel.readByte() != 0;
            this.f37836c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37836c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37835b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37835b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37836c);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37837b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37838c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37839d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37840e;

        public c(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.f37837b = z;
            this.f37838c = i3;
            this.f37839d = str;
            this.f37840e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37837b = parcel.readByte() != 0;
            this.f37838c = parcel.readInt();
            this.f37839d = parcel.readString();
            this.f37840e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37838c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37840e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37837b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37839d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37837b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37838c);
            parcel.writeString(this.f37839d);
            parcel.writeString(this.f37840e);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37841b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37842c;

        public d(int i2, int i3, Throwable th) {
            super(i2);
            this.f37841b = i3;
            this.f37842c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f37841b = parcel.readInt();
            this.f37842c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37841b;
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
            return this.f37842c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37841b);
            parcel.writeSerializable(this.f37842c);
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends f {
        public e(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37843b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37844c;

        public f(int i2, int i3, int i4) {
            super(i2);
            this.f37843b = i3;
            this.f37844c = i4;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37843b = parcel.readInt();
            this.f37844c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37843b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37844c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37843b);
            parcel.writeInt(this.f37844c);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37845b;

        public g(int i2, int i3) {
            super(i2);
            this.f37845b = i3;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37845b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37845b;
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
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37845b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0449h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37846b;

        public C0449h(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f37846b = i4;
        }

        public C0449h(Parcel parcel) {
            super(parcel);
            this.f37846b = parcel.readInt();
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
            return this.f37846b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37846b);
        }
    }

    /* loaded from: classes7.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    /* loaded from: classes7.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i2, int i3, int i4) {
            super(i2, i3, i4);
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
        this.f37810a = false;
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
