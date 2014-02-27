package protobuf.CommitGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<CommitGroupMsgRes.DataRes, k> implements l {
    private int a;
    private long b;
    private int c;
    private long d;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        CommitGroupMsgRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitGroupMsgRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitGroupMsgRes.DataRes.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
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
    /* renamed from: d */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final CommitGroupMsgRes.DataRes buildPartial() {
        CommitGroupMsgRes.DataRes dataRes = new CommitGroupMsgRes.DataRes(this, (CommitGroupMsgRes.DataRes) null);
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
    public final k mergeFrom(CommitGroupMsgRes.DataRes dataRes) {
        if (dataRes != CommitGroupMsgRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasMsgId()) {
                long msgId = dataRes.getMsgId();
                this.a |= 1;
                this.b = msgId;
            }
            if (dataRes.hasGroupId()) {
                int groupId = dataRes.getGroupId();
                this.a |= 2;
                this.c = groupId;
            }
            if (dataRes.hasRecordId()) {
                long recordId = dataRes.getRecordId();
                this.a |= 4;
                this.d = recordId;
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
        CommitGroupMsgRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                CommitGroupMsgRes.DataRes parsePartialFrom = CommitGroupMsgRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            CommitGroupMsgRes.DataRes dataRes2 = (CommitGroupMsgRes.DataRes) e.getUnfinishedMessage();
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
}
