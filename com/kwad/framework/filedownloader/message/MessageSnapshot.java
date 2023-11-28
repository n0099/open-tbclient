package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
/* loaded from: classes10.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwad.framework.filedownloader.message.MessageSnapshot.1
        /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static MessageSnapshot a(Parcel parcel) {
            boolean z;
            MessageSnapshot jVar;
            MessageSnapshot messageSnapshot;
            if (parcel.readByte() == 1) {
                z = true;
            } else {
                z = false;
            }
            byte readByte = parcel.readByte();
            if (readByte != -4) {
                if (readByte != -3) {
                    if (readByte != -1) {
                        if (readByte != 1) {
                            if (readByte != 2) {
                                if (readByte != 3) {
                                    if (readByte != 5) {
                                        if (readByte != 6) {
                                            messageSnapshot = null;
                                            if (messageSnapshot == null) {
                                                messageSnapshot.ahc = z;
                                                return messageSnapshot;
                                            }
                                            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
                                        }
                                        jVar = new b(parcel);
                                    } else if (z) {
                                        jVar = new d.h(parcel);
                                    } else {
                                        jVar = new h.C0686h(parcel);
                                    }
                                } else if (z) {
                                    jVar = new d.g(parcel);
                                } else {
                                    jVar = new h.g(parcel);
                                }
                            } else if (z) {
                                jVar = new d.c(parcel);
                            } else {
                                jVar = new h.c(parcel);
                            }
                        } else if (z) {
                            jVar = new d.f(parcel);
                        } else {
                            jVar = new h.f(parcel);
                        }
                    } else if (z) {
                        jVar = new d.C0685d(parcel);
                    } else {
                        jVar = new h.d(parcel);
                    }
                } else if (z) {
                    jVar = new d.b(parcel);
                } else {
                    jVar = new h.b(parcel);
                }
            } else if (z) {
                jVar = new d.j(parcel);
            } else {
                jVar = new h.j(parcel);
            }
            messageSnapshot = jVar;
            if (messageSnapshot == null) {
            }
        }

        public static MessageSnapshot[] bv(int i) {
            return new MessageSnapshot[i];
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return bv(i);
        }
    };
    public boolean ahc;
    public final int id;

    /* loaded from: classes10.dex */
    public interface a {
        MessageSnapshot vU();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes10.dex */
    public static class NoFieldException extends IllegalStateException {
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwad.framework.filedownloader.f.f.b("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tL()), messageSnapshot.getClass().getName()));
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends MessageSnapshot {
        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tL() {
            return (byte) 6;
        }

        public b(int i) {
            super(i);
        }

        public b(Parcel parcel) {
            super(parcel);
        }
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.id;
    }

    public int tP() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public final boolean tR() {
        return this.ahc;
    }

    public boolean vG() {
        throw new NoFieldException("isResuming", this);
    }

    public int vO() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int vP() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long vQ() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public boolean vR() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public long vS() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable vT() {
        throw new NoFieldException("getThrowable", this);
    }

    public MessageSnapshot(int i) {
        this.id = i;
    }

    public MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.ahc ? (byte) 1 : (byte) 0);
        parcel.writeByte(tL());
        parcel.writeInt(this.id);
    }
}
