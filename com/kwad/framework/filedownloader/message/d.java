package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
/* loaded from: classes10.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes10.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends d {
        public final boolean agX;
        public final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -3;
        }

        public b(int i, boolean z, long j) {
            super(i);
            this.agX = z;
            this.totalBytes = j;
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
            this.totalBytes = parcel.readLong();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long vQ() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean vR() {
            return this.agX;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.agX ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends d {
        public final String afu;
        public final boolean agY;
        public final String agZ;
        public final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 2;
        }

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.agY = z;
            this.totalBytes = j;
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
            this.totalBytes = parcel.readLong();
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
        public final long vQ() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.agY ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.afu);
            parcel.writeString(this.agZ);
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0685d extends d {
        public final long aha;
        public final Throwable ahb;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte tL() {
            return (byte) -1;
        }

        public C0685d(int i, long j, Throwable th) {
            super(i);
            this.aha = j;
            this.ahb = th;
        }

        public C0685d(Parcel parcel) {
            super(parcel);
            this.aha = parcel.readLong();
            this.ahb = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long vS() {
            return this.aha;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable vT() {
            return this.ahb;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aha);
            parcel.writeSerializable(this.ahb);
        }
    }

    /* loaded from: classes10.dex */
    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -2;
        }

        public e(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* loaded from: classes10.dex */
    public static class f extends d {
        public final long aha;
        public final long totalBytes;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte tL() {
            return (byte) 1;
        }

        public f(int i, long j, long j2) {
            super(i);
            this.aha = j;
            this.totalBytes = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.aha = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }

        public f(f fVar) {
            this(fVar.getId(), fVar.vS(), fVar.vQ());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long vQ() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long vS() {
            return this.aha;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aha);
            parcel.writeLong(this.totalBytes);
        }
    }

    /* loaded from: classes10.dex */
    public static class g extends d {
        public final long aha;

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 3;
        }

        public g(int i, long j) {
            super(i);
            this.aha = j;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aha);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.aha = parcel.readLong();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long vS() {
            return this.aha;
        }
    }

    /* loaded from: classes10.dex */
    public static class h extends C0685d {
        public final int agF;

        @Override // com.kwad.framework.filedownloader.message.d.C0685d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0685d, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 5;
        }

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.agF = i2;
        }

        public h(Parcel parcel) {
            super(parcel);
            this.agF = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int tP() {
            return this.agF;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0685d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.agF);
        }
    }

    /* loaded from: classes10.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* loaded from: classes10.dex */
    public static class j extends f implements MessageSnapshot.a {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) -4;
        }

        public j(int i, long j, long j2) {
            super(i, j, j2);
        }

        public j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot vU() {
            return new f(this);
        }
    }

    public d(int i2) {
        super(i2);
        this.ahc = true;
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vO() {
        if (vS() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) vS();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int vP() {
        if (vQ() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) vQ();
    }
}
