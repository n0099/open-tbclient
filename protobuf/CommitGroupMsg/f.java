package protobuf.CommitGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<CommitGroupMsgReq.DataReq, f> implements g {
    private int a;
    private int b;
    private int c;
    private Object d = "";
    private int e;
    private long f;

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = 0L;
        this.a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CommitGroupMsgReq.DataReq getDefaultInstanceForType() {
        return CommitGroupMsgReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitGroupMsgReq.DataReq build() {
        CommitGroupMsgReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitGroupMsgReq.DataReq buildPartial() {
        CommitGroupMsgReq.DataReq dataReq = new CommitGroupMsgReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.msgType_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.content_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.duration_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.recordId_ = this.f;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(CommitGroupMsgReq.DataReq dataReq) {
        Object obj;
        if (dataReq != CommitGroupMsgReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasMsgType()) {
                b(dataReq.getMsgType());
            }
            if (dataReq.hasContent()) {
                this.a |= 4;
                obj = dataReq.content_;
                this.d = obj;
            }
            if (dataReq.hasDuration()) {
                c(dataReq.getDuration());
            }
            if (dataReq.hasRecordId()) {
                a(dataReq.getRecordId());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        CommitGroupMsgReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                CommitGroupMsgReq.DataReq parsePartialFrom = CommitGroupMsgReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataReq = null;
                if (dataReq != null) {
                    mergeFrom(dataReq);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitGroupMsgReq.DataReq dataReq2 = (CommitGroupMsgReq.DataReq) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataReq = dataReq2;
                th = th3;
                if (dataReq != null) {
                }
                throw th;
            }
        }
    }

    public f a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public f b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public f a(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }

    public f c(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public f a(long j) {
        this.a |= 16;
        this.f = j;
        return this;
    }
}
