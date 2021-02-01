package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes3.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes3.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, boolean z, long j) {
            super(i, z, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10951b;
        private final long c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, boolean z, long j) {
            super(i);
            this.f10951b = z;
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Parcel parcel) {
            super(parcel);
            this.f10951b = parcel.readByte() != 0;
            this.c = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.f10951b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f10951b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10952b;
        private final long c;
        private final String d;
        private final String e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.f10952b = z;
            this.c = j;
            this.d = str;
            this.e = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Parcel parcel) {
            super(parcel);
            this.f10952b = parcel.readByte() != 0;
            this.c = parcel.readLong();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String f() {
            return this.e;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean g() {
            return this.f10952b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f10952b ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1161d extends d {

        /* renamed from: b  reason: collision with root package name */
        private final long f10953b;
        private final Throwable c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1161d(int i, long j, Throwable th) {
            super(i);
            this.f10953b = j;
            this.c = th;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1161d(Parcel parcel) {
            super(parcel);
            this.f10953b = parcel.readLong();
            this.c = (Throwable) parcel.readSerializable();
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
            return this.f10953b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public Throwable j() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f10953b);
            parcel.writeSerializable(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        private final long f10954b;
        private final long c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, long j, long j2) {
            super(i);
            this.f10954b = j;
            this.c = j2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(Parcel parcel) {
            super(parcel);
            this.f10954b = parcel.readLong();
            this.c = parcel.readLong();
        }

        f(f fVar) {
            this(fVar.m(), fVar.i(), fVar.d());
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long d() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public long i() {
            return this.f10954b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f10954b);
            parcel.writeLong(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends d {

        /* renamed from: b  reason: collision with root package name */
        private final long f10955b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, long j) {
            super(i);
            this.f10955b = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Parcel parcel) {
            super(parcel);
            this.f10955b = parcel.readLong();
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
            return this.f10955b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f10955b);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends C1161d {

        /* renamed from: b  reason: collision with root package name */
        private final int f10956b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.f10956b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Parcel parcel) {
            super(parcel);
            this.f10956b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C1161d, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.d.C1161d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int k() {
            return this.f10956b;
        }

        @Override // com.kwai.filedownloader.message.d.C1161d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f10956b);
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends f implements MessageSnapshot.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public j(int i, long j, long j2) {
            super(i, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

    d(int i2) {
        super(i2);
        this.f10948a = true;
    }

    d(Parcel parcel) {
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
