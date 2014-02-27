package protobuf.QuitChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QuitChatroom.QuitChatroomReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<QuitChatroomReq.QuitChatroomReqIdl, e> implements f {
    private int a;
    private QuitChatroomReq.DataReq b = QuitChatroomReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QuitChatroomReq.QuitChatroomReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QuitChatroomReq.QuitChatroomReqIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = QuitChatroomReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QuitChatroomReq.QuitChatroomReqIdl build() {
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
    public final e mergeFrom(QuitChatroomReq.QuitChatroomReqIdl quitChatroomReqIdl) {
        if (quitChatroomReqIdl != QuitChatroomReq.QuitChatroomReqIdl.getDefaultInstance() && quitChatroomReqIdl.hasData()) {
            QuitChatroomReq.DataReq data = quitChatroomReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == QuitChatroomReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = QuitChatroomReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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

    public final e a(QuitChatroomReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
