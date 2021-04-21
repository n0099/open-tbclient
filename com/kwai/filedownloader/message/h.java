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
        public final boolean f37455b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37456c;

        public b(int i, boolean z, int i2) {
            super(i);
            this.f37455b = z;
            this.f37456c = i2;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37455b = parcel.readByte() != 0;
            this.f37456c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37456c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37455b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37455b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37456c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37457b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37458c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37459d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37460e;

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.f37457b = z;
            this.f37458c = i2;
            this.f37459d = str;
            this.f37460e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37457b = parcel.readByte() != 0;
            this.f37458c = parcel.readInt();
            this.f37459d = parcel.readString();
            this.f37460e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37458c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37460e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37457b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37459d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37457b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37458c);
            parcel.writeString(this.f37459d);
            parcel.writeString(this.f37460e);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37461b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37462c;

        public d(int i, int i2, Throwable th) {
            super(i);
            this.f37461b = i2;
            this.f37462c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f37461b = parcel.readInt();
            this.f37462c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37461b;
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
            return this.f37462c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37461b);
            parcel.writeSerializable(this.f37462c);
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
        public final int f37463b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37464c;

        public f(int i, int i2, int i3) {
            super(i);
            this.f37463b = i2;
            this.f37464c = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37463b = parcel.readInt();
            this.f37464c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37463b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37464c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37463b);
            parcel.writeInt(this.f37464c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37465b;

        public g(int i, int i2) {
            super(i);
            this.f37465b = i2;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37465b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37465b;
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
            parcel.writeInt(this.f37465b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0466h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37466b;

        public C0466h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.f37466b = i3;
        }

        public C0466h(Parcel parcel) {
            super(parcel);
            this.f37466b = parcel.readInt();
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
            return this.f37466b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37466b);
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
        this.f37430a = false;
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
