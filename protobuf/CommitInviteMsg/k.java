package protobuf.CommitInviteMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitInviteMsg.CommitInviteMsgRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<CommitInviteMsgRes.DataRes, k> implements l {
    private int a;
    private long b;
    private int c;
    private long d;

    private k() {
        g();
    }

    private void g() {
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0L;
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CommitInviteMsgRes.DataRes getDefaultInstanceForType() {
        return CommitInviteMsgRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitInviteMsgRes.DataRes build() {
        CommitInviteMsgRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitInviteMsgRes.DataRes buildPartial() {
        CommitInviteMsgRes.DataRes dataRes = new CommitInviteMsgRes.DataRes(this, (CommitInviteMsgRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.msgId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.groupId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.recordId_ = this.d;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(CommitInviteMsgRes.DataRes dataRes) {
        if (dataRes != CommitInviteMsgRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasMsgId()) {
                a(dataRes.getMsgId());
            }
            if (dataRes.hasGroupId()) {
                a(dataRes.getGroupId());
            }
            if (dataRes.hasRecordId()) {
                b(dataRes.getRecordId());
            }
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        CommitInviteMsgRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                CommitInviteMsgRes.DataRes parsePartialFrom = CommitInviteMsgRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitInviteMsgRes.DataRes dataRes2 = (CommitInviteMsgRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public k a(long j) {
        this.a |= 1;
        this.b = j;
        return this;
    }

    public k a(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public k b(long j) {
        this.a |= 4;
        this.d = j;
        return this;
    }
}
