package protobuf.EnterChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.EnterChatroom.EnterChatroomReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<EnterChatroomReq.EnterChatroomReqIdl, e> implements f {
    private int a;
    private EnterChatroomReq.DataReq b = EnterChatroomReq.DataReq.getDefaultInstance();

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
        this.b = EnterChatroomReq.DataReq.getDefaultInstance();
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
    public EnterChatroomReq.EnterChatroomReqIdl getDefaultInstanceForType() {
        return EnterChatroomReq.EnterChatroomReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public EnterChatroomReq.EnterChatroomReqIdl build() {
        EnterChatroomReq.EnterChatroomReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public EnterChatroomReq.EnterChatroomReqIdl buildPartial() {
        EnterChatroomReq.EnterChatroomReqIdl enterChatroomReqIdl = new EnterChatroomReq.EnterChatroomReqIdl(this, (EnterChatroomReq.EnterChatroomReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        enterChatroomReqIdl.dataReq_ = this.b;
        enterChatroomReqIdl.bitField0_ = i;
        return enterChatroomReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(EnterChatroomReq.EnterChatroomReqIdl enterChatroomReqIdl) {
        if (enterChatroomReqIdl != EnterChatroomReq.EnterChatroomReqIdl.getDefaultInstance() && enterChatroomReqIdl.hasDataReq()) {
            b(enterChatroomReqIdl.getDataReq());
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
        EnterChatroomReq.EnterChatroomReqIdl enterChatroomReqIdl;
        Throwable th;
        try {
            try {
                EnterChatroomReq.EnterChatroomReqIdl parsePartialFrom = EnterChatroomReq.EnterChatroomReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                enterChatroomReqIdl = null;
                if (enterChatroomReqIdl != null) {
                    mergeFrom(enterChatroomReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            EnterChatroomReq.EnterChatroomReqIdl enterChatroomReqIdl2 = (EnterChatroomReq.EnterChatroomReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                enterChatroomReqIdl = enterChatroomReqIdl2;
                th = th3;
                if (enterChatroomReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(EnterChatroomReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(EnterChatroomReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != EnterChatroomReq.DataReq.getDefaultInstance()) {
            this.b = EnterChatroomReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
