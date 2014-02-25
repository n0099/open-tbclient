package protobuf.QuitChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QuitChatroomReq.QuitChatroomReqIdl, e> implements f {
    private int a;
    private QuitChatroomReq.DataReq b = QuitChatroomReq.DataReq.getDefaultInstance();

    private e() {
        g();
    }

    private void g() {
    }

    public static e h() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public e clear() {
        super.clear();
        this.b = QuitChatroomReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QuitChatroomReq.QuitChatroomReqIdl getDefaultInstanceForType() {
        return QuitChatroomReq.QuitChatroomReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QuitChatroomReq.QuitChatroomReqIdl build() {
        QuitChatroomReq.QuitChatroomReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QuitChatroomReq.QuitChatroomReqIdl buildPartial() {
        QuitChatroomReq.QuitChatroomReqIdl quitChatroomReqIdl = new QuitChatroomReq.QuitChatroomReqIdl(this, (QuitChatroomReq.QuitChatroomReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        quitChatroomReqIdl.data_ = this.b;
        quitChatroomReqIdl.bitField0_ = i;
        return quitChatroomReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(QuitChatroomReq.QuitChatroomReqIdl quitChatroomReqIdl) {
        if (quitChatroomReqIdl != QuitChatroomReq.QuitChatroomReqIdl.getDefaultInstance() && quitChatroomReqIdl.hasData()) {
            b(quitChatroomReqIdl.getData());
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QuitChatroomReq.QuitChatroomReqIdl quitChatroomReqIdl;
        Throwable th;
        try {
            try {
                QuitChatroomReq.QuitChatroomReqIdl parsePartialFrom = QuitChatroomReq.QuitChatroomReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                quitChatroomReqIdl = null;
                if (quitChatroomReqIdl != null) {
                    mergeFrom(quitChatroomReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QuitChatroomReq.QuitChatroomReqIdl quitChatroomReqIdl2 = (QuitChatroomReq.QuitChatroomReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                quitChatroomReqIdl = quitChatroomReqIdl2;
                th = th3;
                if (quitChatroomReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(QuitChatroomReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(QuitChatroomReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != QuitChatroomReq.DataReq.getDefaultInstance()) {
            this.b = QuitChatroomReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
