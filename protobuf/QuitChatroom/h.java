package protobuf.QuitChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QuitChatroomRes.QuitChatroomResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QuitChatroomRes.QuitChatroomResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QuitChatroomRes.QuitChatroomResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QuitChatroomRes.QuitChatroomResIdl.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h a() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QuitChatroomRes.QuitChatroomResIdl buildPartial() {
        QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl = new QuitChatroomRes.QuitChatroomResIdl(this, (QuitChatroomRes.QuitChatroomResIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        quitChatroomResIdl.error_ = this.b;
        quitChatroomResIdl.bitField0_ = i;
        return quitChatroomResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl) {
        if (quitChatroomResIdl != QuitChatroomRes.QuitChatroomResIdl.getDefaultInstance() && quitChatroomResIdl.hasError()) {
            Im.Error error = quitChatroomResIdl.getError();
            if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                this.b = error;
            } else {
                this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
            }
            this.a |= 1;
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl;
        Throwable th;
        try {
            try {
                QuitChatroomRes.QuitChatroomResIdl parsePartialFrom = QuitChatroomRes.QuitChatroomResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                quitChatroomResIdl = null;
                if (quitChatroomResIdl != null) {
                    mergeFrom(quitChatroomResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl2 = (QuitChatroomRes.QuitChatroomResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                quitChatroomResIdl = quitChatroomResIdl2;
                th = th3;
                if (quitChatroomResIdl != null) {
                }
                throw th;
            }
        }
    }
}
