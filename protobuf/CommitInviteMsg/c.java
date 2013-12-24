package protobuf.CommitInviteMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<CommitInviteMsgReq.CommitInviteMsgReqIdl, c> implements d {
    private int a;
    private CommitInviteMsgReq.DataReq b = CommitInviteMsgReq.DataReq.getDefaultInstance();

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
        this.b = CommitInviteMsgReq.DataReq.getDefaultInstance();
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
    public CommitInviteMsgReq.CommitInviteMsgReqIdl getDefaultInstanceForType() {
        return CommitInviteMsgReq.CommitInviteMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitInviteMsgReq.CommitInviteMsgReqIdl build() {
        CommitInviteMsgReq.CommitInviteMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitInviteMsgReq.CommitInviteMsgReqIdl buildPartial() {
        CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl = new CommitInviteMsgReq.CommitInviteMsgReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        commitInviteMsgReqIdl.data_ = this.b;
        commitInviteMsgReqIdl.bitField0_ = i;
        return commitInviteMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
        if (commitInviteMsgReqIdl != CommitInviteMsgReq.CommitInviteMsgReqIdl.getDefaultInstance() && commitInviteMsgReqIdl.hasData()) {
            b(commitInviteMsgReqIdl.getData());
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
        CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl;
        Throwable th;
        try {
            try {
                CommitInviteMsgReq.CommitInviteMsgReqIdl parsePartialFrom = CommitInviteMsgReq.CommitInviteMsgReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitInviteMsgReqIdl = null;
                if (commitInviteMsgReqIdl != null) {
                    mergeFrom(commitInviteMsgReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl2 = (CommitInviteMsgReq.CommitInviteMsgReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitInviteMsgReqIdl = commitInviteMsgReqIdl2;
                th = th3;
                if (commitInviteMsgReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public c a(CommitInviteMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public c b(CommitInviteMsgReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != CommitInviteMsgReq.DataReq.getDefaultInstance()) {
            this.b = CommitInviteMsgReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
