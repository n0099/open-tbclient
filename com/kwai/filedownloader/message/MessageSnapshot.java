package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
/* loaded from: classes6.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwai.filedownloader.message.MessageSnapshot.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot jVar;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            if (readByte == -4) {
                jVar = z ? new d.j(parcel) : new h.j(parcel);
            } else if (readByte == -3) {
                jVar = z ? new d.b(parcel) : new h.b(parcel);
            } else if (readByte == -1) {
                jVar = z ? new d.C0447d(parcel) : new h.d(parcel);
            } else if (readByte == 1) {
                jVar = z ? new d.f(parcel) : new h.f(parcel);
            } else if (readByte == 2) {
                jVar = z ? new d.c(parcel) : new h.c(parcel);
            } else if (readByte == 3) {
                jVar = z ? new d.g(parcel) : new h.g(parcel);
            } else if (readByte == 5) {
                jVar = z ? new d.h(parcel) : new h.C0448h(parcel);
            } else if (readByte != 6) {
                messageSnapshot = null;
                if (messageSnapshot == null) {
                    messageSnapshot.f37045a = z;
                    return messageSnapshot;
                }
                throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
            } else {
                jVar = new b(parcel);
            }
            messageSnapshot = jVar;
            if (messageSnapshot == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MessageSnapshot[] newArray(int i) {
            return new MessageSnapshot[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f37045a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37046b;

    /* loaded from: classes6.dex */
    public static class NoFieldException extends IllegalStateException {
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.f.f.a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()), messageSnapshot.getClass().getName()));
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        MessageSnapshot l();
    }

    /* loaded from: classes6.dex */
    public static class b extends MessageSnapshot {
        public b(int i) {
            super(i);
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            return (byte) 6;
        }
    }

    public MessageSnapshot(int i) {
        this.f37046b = i;
    }

    public MessageSnapshot(Parcel parcel) {
        this.f37046b = parcel.readInt();
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
        return this.f37046b;
    }

    public boolean n() {
        return this.f37045a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f37045a ? (byte) 1 : (byte) 0);
        parcel.writeByte(b());
        parcel.writeInt(this.f37046b);
    }
}
