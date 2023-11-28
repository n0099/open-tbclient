package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
/* loaded from: classes10.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes10.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends h {
        public final boolean agX;
        public final int ahm;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -3;
        }

        public b(int i, boolean z, int i2) {
            super(i);
            this.agX = z;
            this.ahm = i2;
        }

        public b(Parcel parcel) {
            super(parcel);
            boolean z;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.agX = z;
            this.ahm = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vP() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean vR() {
            return this.agX;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.agX ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahm);
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends h {
        public final String afu;
        public final boolean agY;
        public final String agZ;
        public final int ahm;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 2;
        }

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.agY = z;
            this.ahm = i2;
            this.afu = str;
            this.agZ = str2;
        }

        public c(Parcel parcel) {
            super(parcel);
            boolean z;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.agY = z;
            this.ahm = parcel.readInt();
            this.afu = parcel.readString();
            this.agZ = parcel.readString();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.afu;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.agZ;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean vG() {
            return this.agY;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vP() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.agY ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.ahm);
            parcel.writeString(this.afu);
            parcel.writeString(this.agZ);
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends h {
        public final Throwable ahb;
        public final int ahn;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte tL() {
            return (byte) -1;
        }

        public d(int i, int i2, Throwable th) {
            super(i);
            this.ahn = i2;
            this.ahb = th;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readInt();
            this.ahb = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vO() {
            return this.ahn;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable vT() {
            return this.ahb;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahn);
            parcel.writeSerializable(this.ahb);
        }
    }

    /* loaded from: classes10.dex */
    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -2;
        }

        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: classes10.dex */
    public static class f extends h {
        public final int ahm;
        public final int ahn;

        public byte tL() {
            return (byte) 1;
        }

        public f(int i, int i2, int i3) {
            super(i);
            this.ahn = i2;
            this.ahm = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readInt();
            this.ahm = parcel.readInt();
        }

        public f(f fVar) {
            this(fVar.getId(), fVar.vO(), fVar.vP());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vO() {
            return this.ahn;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vP() {
            return this.ahm;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahn);
            parcel.writeInt(this.ahm);
        }
    }

    /* loaded from: classes10.dex */
    public static class g extends h {
        public final int ahn;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 3;
        }

        public g(int i, int i2) {
            super(i);
            this.ahn = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahn);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.ahn = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vO() {
            return this.ahn;
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0686h extends d {
        public final int agF;

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 5;
        }

        public C0686h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.agF = i3;
        }

        public C0686h(Parcel parcel) {
            super(parcel);
            this.agF = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tP() {
            return this.agF;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.agF);
        }
    }

    /* loaded from: classes10.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: classes10.dex */
    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -4;
        }

        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot vU() {
            return new f(this);
        }
    }

    public h(int i2) {
        super(i2);
        this.ahc = false;
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long vQ() {
        return vP();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long vS() {
        return vO();
    }
}
