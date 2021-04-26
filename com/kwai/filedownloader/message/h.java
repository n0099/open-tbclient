package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes6.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes6.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        public a(int i2, boolean z, int i3) {
            super(i2, z, i3);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35177b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35178c;

        public b(int i2, boolean z, int i3) {
            super(i2);
            this.f35177b = z;
            this.f35178c = i3;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f35177b = parcel.readByte() != 0;
            this.f35178c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f35178c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f35177b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f35177b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f35178c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends h {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35179b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35180c;

        /* renamed from: d  reason: collision with root package name */
        public final String f35181d;

        /* renamed from: e  reason: collision with root package name */
        public final String f35182e;

        public c(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.f35179b = z;
            this.f35180c = i3;
            this.f35181d = str;
            this.f35182e = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f35179b = parcel.readByte() != 0;
            this.f35180c = parcel.readInt();
            this.f35181d = parcel.readString();
            this.f35182e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f35180c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.f35182e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f35179b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.f35181d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f35179b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f35180c);
            parcel.writeString(this.f35181d);
            parcel.writeString(this.f35182e);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f35183b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f35184c;

        public d(int i2, int i3, Throwable th) {
            super(i2);
            this.f35183b = i3;
            this.f35184c = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f35183b = parcel.readInt();
            this.f35184c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f35183b;
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
            return this.f35184c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f35183b);
            parcel.writeSerializable(this.f35184c);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends f {
        public e(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f35185b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35186c;

        public f(int i2, int i3, int i4) {
            super(i2);
            this.f35185b = i3;
            this.f35186c = i4;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f35185b = parcel.readInt();
            this.f35186c = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f35185b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.f35186c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f35185b);
            parcel.writeInt(this.f35186c);
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends h {

        /* renamed from: b  reason: collision with root package name */
        public final int f35187b;

        public g(int i2, int i3) {
            super(i2);
            this.f35187b = i3;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.f35187b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.f35187b;
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
            parcel.writeInt(this.f35187b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0411h extends d {

        /* renamed from: b  reason: collision with root package name */
        public final int f35188b;

        public C0411h(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f35188b = i4;
        }

        public C0411h(Parcel parcel) {
            super(parcel);
            this.f35188b = parcel.readInt();
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
            return this.f35188b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f35188b);
        }
    }

    /* loaded from: classes6.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        public i(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    /* loaded from: classes6.dex */
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
        this.f35152a = false;
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
