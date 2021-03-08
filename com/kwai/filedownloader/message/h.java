package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes3.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes3.dex */
    public static class a extends b implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, boolean z, int i2) {
            super(i, z, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends h {
        private final boolean b;
        private final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, boolean z, int i2) {
            super(i);
            this.b = z;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Parcel parcel) {
            super(parcel);
            this.b = parcel.readByte() != 0;
            this.c = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public boolean e() {
            return this.b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends h {
        private final boolean b;
        private final int c;
        private final String d;
        private final String e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.b = z;
            this.c = i2;
            this.d = str;
            this.e = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Parcel parcel) {
            super(parcel);
            this.b = parcel.readByte() != 0;
            this.c = parcel.readInt();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
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
            return this.b;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public String h() {
            return this.d;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends h {
        private final int b;
        private final Throwable c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i, int i2, Throwable th) {
            super(i);
            this.b = i2;
            this.c = th;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
            this.c = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.b;
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
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeSerializable(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) -2;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends h {
        private final int b;
        private final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, int i2, int i3) {
            super(i);
            this.b = i2;
            this.c = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
            this.c = parcel.readInt();
        }

        f(f fVar) {
            this(fVar.m(), fVar.a(), fVar.c());
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.b;
        }

        public byte b() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int c() {
            return this.c;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends h {
        private final int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, int i2) {
            super(i);
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public int a() {
            return this.b;
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
            parcel.writeInt(this.b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1181h extends d {
        private final int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1181h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.b = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1181h(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
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
            return this.b;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends j implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends f implements MessageSnapshot.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

    h(int i2) {
        super(i2);
        this.f7225a = false;
    }

    h(Parcel parcel) {
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
