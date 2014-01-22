package protobuf.QuitChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QuitChatroom.QuitChatroomRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QuitChatroomRes.QuitChatroomResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QuitChatroomRes.QuitChatroomResIdl getDefaultInstanceForType() {
        return QuitChatroomRes.QuitChatroomResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QuitChatroomRes.QuitChatroomResIdl build() {
        QuitChatroomRes.QuitChatroomResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QuitChatroomRes.QuitChatroomResIdl buildPartial() {
        QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl = new QuitChatroomRes.QuitChatroomResIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        quitChatroomResIdl.error_ = this.b;
        quitChatroomResIdl.bitField0_ = i;
        return quitChatroomResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QuitChatroomRes.QuitChatroomResIdl quitChatroomResIdl) {
        if (quitChatroomResIdl != QuitChatroomRes.QuitChatroomResIdl.getDefaultInstance() && quitChatroomResIdl.hasError()) {
            a(quitChatroomResIdl.getError());
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public j a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }
}
