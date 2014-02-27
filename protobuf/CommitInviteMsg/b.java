package protobuf.CommitInviteMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitInviteMsg.CommitInviteMsgReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<CommitInviteMsgReq.CommitInviteMsgReqIdl, b> implements c {
    private int a;
    private CommitInviteMsgReq.DataReq b = CommitInviteMsgReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitInviteMsgReq.CommitInviteMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitInviteMsgReq.CommitInviteMsgReqIdl.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b b() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public b clear() {
        super.clear();
        this.b = CommitInviteMsgReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final CommitInviteMsgReq.CommitInviteMsgReqIdl build() {
        CommitInviteMsgReq.CommitInviteMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitInviteMsgReq.CommitInviteMsgReqIdl buildPartial() {
        CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl = new CommitInviteMsgReq.CommitInviteMsgReqIdl(this, (CommitInviteMsgReq.CommitInviteMsgReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        commitInviteMsgReqIdl.data_ = this.b;
        commitInviteMsgReqIdl.bitField0_ = i;
        return commitInviteMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(CommitInviteMsgReq.CommitInviteMsgReqIdl commitInviteMsgReqIdl) {
        if (commitInviteMsgReqIdl != CommitInviteMsgReq.CommitInviteMsgReqIdl.getDefaultInstance() && commitInviteMsgReqIdl.hasData()) {
            CommitInviteMsgReq.DataReq data = commitInviteMsgReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == CommitInviteMsgReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = CommitInviteMsgReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public final b a(CommitInviteMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
