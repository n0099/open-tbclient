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
        public final boolean f37933b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37934c;

        public b(int i2, boolean z, int i3) {
            super(i2);
            this.f37933b = z;
            this.f37934c = i3;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37933b = parcel.readByte() != 0;
            this.f37934c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37934c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37933b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37933b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37934c);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37935b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37936c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37937d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37938e;

        public c(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.f37935b = z;
            this.f37936c = i3;
            this.f37937d = str;
            this.f37938e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37935b = parcel.readByte() != 0;
            this.f37936c = parcel.readInt();
            this.f37937d = parcel.readString();
            this.f37938e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37936c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37938e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37935b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37937d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f37935b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37936c);
            parcel.writeString(this.f37937d);
            parcel.writeString(this.f37938e);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37939b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37940c;

        public d(int i2, int i3, Throwable th) {
            super(i2);
            this.f37939b = i3;
            this.f37940c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f37939b = parcel.readInt();
            this.f37940c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37939b;
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
            return this.f37940c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37939b);
            parcel.writeSerializable(this.f37940c);
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
        public final int f37941b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37942c;

        public f(int i2, int i3, int i4) {
            super(i2);
            this.f37941b = i3;
            this.f37942c = i4;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37941b = parcel.readInt();
            this.f37942c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37941b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37942c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37941b);
            parcel.writeInt(this.f37942c);
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37943b;

        public g(int i2, int i3) {
            super(i2);
            this.f37943b = i3;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37943b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37943b;
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
            parcel.writeInt(this.f37943b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0452h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37944b;

        public C0452h(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f37944b = i4;
        }

        public C0452h(Parcel parcel) {
            super(parcel);
            this.f37944b = parcel.readInt();
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
            return this.f37944b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f37944b);
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
        this.f37908a = false;
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
