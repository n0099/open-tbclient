package protobuf.CommitPersonalMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<CommitPersonalMsgReq.CommitPersonalMsgReqIdl, b> implements c {
    private int a;
    private CommitPersonalMsgReq.DataReq b = CommitPersonalMsgReq.DataReq.getDefaultInstance();

    private b() {
        g();
    }

    private void g() {
    }

    public static b h() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public b clear() {
        super.clear();
        this.b = CommitPersonalMsgReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CommitPersonalMsgReq.CommitPersonalMsgReqIdl getDefaultInstanceForType() {
        return CommitPersonalMsgReq.CommitPersonalMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitPersonalMsgReq.CommitPersonalMsgReqIdl build() {
        CommitPersonalMsgReq.CommitPersonalMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitPersonalMsgReq.CommitPersonalMsgReqIdl buildPartial() {
        CommitPersonalMsgReq.CommitPersonalMsgReqIdl commitPersonalMsgReqIdl = new CommitPersonalMsgReq.CommitPersonalMsgReqIdl(this, (CommitPersonalMsgReq.CommitPersonalMsgReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        commitPersonalMsgReqIdl.data_ = this.b;
        commitPersonalMsgReqIdl.bitField0_ = i;
        return commitPersonalMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(CommitPersonalMsgReq.CommitPersonalMsgReqIdl commitPersonalMsgReqIdl) {
        if (commitPersonalMsgReqIdl != CommitPersonalMsgReq.CommitPersonalMsgReqIdl.getDefaultInstance() && commitPersonalMsgReqIdl.hasData()) {
            b(commitPersonalMsgReqIdl.getData());
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        CommitPersonalMsgReq.CommitPersonalMsgReqIdl commitPersonalMsgReqIdl;
        Throwable th;
        try {
            try {
                CommitPersonalMsgReq.CommitPersonalMsgReqIdl parsePartialFrom = CommitPersonalMsgReq.CommitPersonalMsgReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitPersonalMsgReqIdl = null;
                if (commitPersonalMsgReqIdl != null) {
                    mergeFrom(commitPersonalMsgReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitPersonalMsgReq.CommitPersonalMsgReqIdl commitPersonalMsgReqIdl2 = (CommitPersonalMsgReq.CommitPersonalMsgReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitPersonalMsgReqIdl = commitPersonalMsgReqIdl2;
                th = th3;
                if (commitPersonalMsgReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(CommitPersonalMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public b b(CommitPersonalMsgReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != CommitPersonalMsgReq.DataReq.getDefaultInstance()) {
            this.b = CommitPersonalMsgReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
