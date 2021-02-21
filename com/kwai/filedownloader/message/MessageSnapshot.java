package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
/* loaded from: classes3.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwai.filedownloader.message.MessageSnapshot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot jVar;
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            switch (readByte) {
                case -4:
                    if (!z) {
                        jVar = new h.j(parcel);
                        break;
                    } else {
                        jVar = new d.j(parcel);
                        break;
                    }
                case -3:
                    if (!z) {
                        jVar = new h.b(parcel);
                        break;
                    } else {
                        jVar = new d.b(parcel);
                        break;
                    }
                case -2:
                case 0:
                case 4:
                default:
                    jVar = null;
                    break;
                case -1:
                    if (!z) {
                        jVar = new h.d(parcel);
                        break;
                    } else {
                        jVar = new d.C1163d(parcel);
                        break;
                    }
                case 1:
                    if (!z) {
                        jVar = new h.f(parcel);
                        break;
                    } else {
                        jVar = new d.f(parcel);
                        break;
                    }
                case 2:
                    if (!z) {
                        jVar = new h.c(parcel);
                        break;
                    } else {
                        jVar = new d.c(parcel);
                        break;
                    }
                case 3:
                    if (!z) {
                        jVar = new h.g(parcel);
                        break;
                    } else {
                        jVar = new d.g(parcel);
                        break;
                    }
                case 5:
                    if (!z) {
                        jVar = new h.C1164h(parcel);
                        break;
                    } else {
                        jVar = new d.h(parcel);
                        break;
                    }
                case 6:
                    jVar = new b(parcel);
                    break;
            }
            if (jVar != null) {
                jVar.f10948a = z;
                return jVar;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageSnapshot[] newArray(int i) {
            return new MessageSnapshot[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected boolean f10948a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10949b;

    /* loaded from: classes3.dex */
    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.f.f.a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()), messageSnapshot.getClass().getName()));
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        MessageSnapshot l();
    }

    /* loaded from: classes3.dex */
    public static class b extends MessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            super(i);
        }

        b(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(int i) {
        this.f10949b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(Parcel parcel) {
        this.f10949b = parcel.readInt();
    }

    public int a() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int c() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long d() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public String f() {
        throw new NoFieldException("getFileName", this);
    }

    public boolean g() {
        throw new NoFieldException("isResuming", this);
    }

    public String h() {
        throw new NoFieldException("getEtag", this);
    }

    public long i() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable j() {
        throw new NoFieldException("getThrowable", this);
    }

    public int k() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int m() {
        return this.f10949b;
    }

    public boolean n() {
        return this.f10948a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f10948a ? 1 : 0));
        parcel.writeByte(b());
        parcel.writeInt(this.f10949b);
    }
}
