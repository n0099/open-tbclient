package protobuf.CommitPersonalMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<CommitPersonalMsgReq.DataReq, e> implements f {
    private int a;
    private int b;
    private long c;
    private int d;
    private Object e = "";
    private int f;
    private long g;

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitPersonalMsgReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitPersonalMsgReq.DataReq.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e c() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0L;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = 0L;
        this.a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final CommitPersonalMsgReq.DataReq build() {
        CommitPersonalMsgReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final CommitPersonalMsgReq.DataReq buildPartial() {
        CommitPersonalMsgReq.DataReq dataReq = new CommitPersonalMsgReq.DataReq(this, (CommitPersonalMsgReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.toUid_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.msgType_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.content_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.duration_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.recordId_ = this.g;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(CommitPersonalMsgReq.DataReq dataReq) {
        Object obj;
        if (dataReq != CommitPersonalMsgReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasToUid()) {
                a(dataReq.getToUid());
            }
            if (dataReq.hasMsgType()) {
                b(dataReq.getMsgType());
            }
            if (dataReq.hasContent()) {
                this.a |= 8;
                obj = dataReq.content_;
                this.e = obj;
            }
            if (dataReq.hasDuration()) {
                int duration = dataReq.getDuration();
                this.a |= 16;
                this.f = duration;
            }
            if (dataReq.hasRecordId()) {
                b(dataReq.getRecordId());
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        CommitPersonalMsgReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                CommitPersonalMsgReq.DataReq parsePartialFrom = CommitPersonalMsgReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            CommitPersonalMsgReq.DataReq dataReq2 = (CommitPersonalMsgReq.DataReq) e.getUnfinishedMessage();
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

    public final e a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public final e a(long j) {
        this.a |= 2;
        this.c = j;
        return this;
    }

    public final e b(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public final e a(String str) {
        if (str != null) {
            this.a |= 8;
            this.e = str;
        }
        return this;
    }

    public final e b(long j) {
        this.a |= 32;
        this.g = j;
        return this;
    }
}
