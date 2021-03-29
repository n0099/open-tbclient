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
        public final boolean f37071b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37072c;

        public b(int i, boolean z, int i2) {
            super(i);
            this.f37071b = z;
            this.f37072c = i2;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f37071b = parcel.readByte() != 0;
            this.f37072c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37072c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f37071b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37071b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37072c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37073b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37074c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37075d;

        /* renamed from: e  reason: collision with root package name */
        public final String f37076e;

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.f37073b = z;
            this.f37074c = i2;
            this.f37075d = str;
            this.f37076e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f37073b = parcel.readByte() != 0;
            this.f37074c = parcel.readInt();
            this.f37075d = parcel.readString();
            this.f37076e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37074c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f37076e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f37073b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f37075d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f37073b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f37074c);
            parcel.writeString(this.f37075d);
            parcel.writeString(this.f37076e);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37077b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f37078c;

        public d(int i, int i2, Throwable th) {
            super(i);
            this.f37077b = i2;
            this.f37078c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f37077b = parcel.readInt();
            this.f37078c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37077b;
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
            return this.f37078c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37077b);
            parcel.writeSerializable(this.f37078c);
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
        public final int f37079b;

        /* renamed from: c  reason: collision with root package name */
        public final int f37080c;

        public f(int i, int i2, int i3) {
            super(i);
            this.f37079b = i2;
            this.f37080c = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f37079b = parcel.readInt();
            this.f37080c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37079b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f37080c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37079b);
            parcel.writeInt(this.f37080c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f37081b;

        public g(int i, int i2) {
            super(i);
            this.f37081b = i2;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f37081b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f37081b;
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
            parcel.writeInt(this.f37081b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0449h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f37082b;

        public C0449h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.f37082b = i3;
        }

        public C0449h(Parcel parcel) {
            super(parcel);
            this.f37082b = parcel.readInt();
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
            return this.f37082b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f37082b);
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
        this.f37046a = false;
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
