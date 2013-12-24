package protobuf.CommitGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<CommitGroupMsgReq.CommitGroupMsgReqIdl, c> implements d {
    private int a;
    private CommitGroupMsgReq.DataReq b = CommitGroupMsgReq.DataReq.getDefaultInstance();

    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
        super.clear();
        this.b = CommitGroupMsgReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CommitGroupMsgReq.CommitGroupMsgReqIdl getDefaultInstanceForType() {
        return CommitGroupMsgReq.CommitGroupMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitGroupMsgReq.CommitGroupMsgReqIdl build() {
        CommitGroupMsgReq.CommitGroupMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitGroupMsgReq.CommitGroupMsgReqIdl buildPartial() {
        CommitGroupMsgReq.CommitGroupMsgReqIdl commitGroupMsgReqIdl = new CommitGroupMsgReq.CommitGroupMsgReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        commitGroupMsgReqIdl.data_ = this.b;
        commitGroupMsgReqIdl.bitField0_ = i;
        return commitGroupMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(CommitGroupMsgReq.CommitGroupMsgReqIdl commitGroupMsgReqIdl) {
        if (commitGroupMsgReqIdl != CommitGroupMsgReq.CommitGroupMsgReqIdl.getDefaultInstance() && commitGroupMsgReqIdl.hasData()) {
            b(commitGroupMsgReqIdl.getData());
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        CommitGroupMsgReq.CommitGroupMsgReqIdl commitGroupMsgReqIdl;
        Throwable th;
        try {
            try {
                CommitGroupMsgReq.CommitGroupMsgReqIdl parsePartialFrom = CommitGroupMsgReq.CommitGroupMsgReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitGroupMsgReqIdl = null;
                if (commitGroupMsgReqIdl != null) {
                    mergeFrom(commitGroupMsgReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitGroupMsgReq.CommitGroupMsgReqIdl commitGroupMsgReqIdl2 = (CommitGroupMsgReq.CommitGroupMsgReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitGroupMsgReqIdl = commitGroupMsgReqIdl2;
                th = th3;
                if (commitGroupMsgReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public c a(CommitGroupMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public c b(CommitGroupMsgReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != CommitGroupMsgReq.DataReq.getDefaultInstance()) {
            this.b = CommitGroupMsgReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
