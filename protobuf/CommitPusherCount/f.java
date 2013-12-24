package protobuf.CommitPusherCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<CommitPusherCountReq.DataReq, f> implements g {
    private int a;
    private long b;
    private long c;
    private long d;
    private long e;

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
        this.b = 0L;
        this.a &= -2;
        this.c = 0L;
        this.a &= -3;
        this.d = 0L;
        this.a &= -5;
        this.e = 0L;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public CommitPusherCountReq.DataReq getDefaultInstanceForType() {
        return CommitPusherCountReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitPusherCountReq.DataReq build() {
        CommitPusherCountReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitPusherCountReq.DataReq buildPartial() {
        CommitPusherCountReq.DataReq dataReq = new CommitPusherCountReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.pusherCount_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.upFlowSize_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.downFlowSize_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.enterForeCount_ = this.e;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(CommitPusherCountReq.DataReq dataReq) {
        if (dataReq != CommitPusherCountReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasPusherCount()) {
                a(dataReq.getPusherCount());
            }
            if (dataReq.hasUpFlowSize()) {
                b(dataReq.getUpFlowSize());
            }
            if (dataReq.hasDownFlowSize()) {
                c(dataReq.getDownFlowSize());
            }
            if (dataReq.hasEnterForeCount()) {
                d(dataReq.getEnterForeCount());
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
        CommitPusherCountReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                CommitPusherCountReq.DataReq parsePartialFrom = CommitPusherCountReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            CommitPusherCountReq.DataReq dataReq2 = (CommitPusherCountReq.DataReq) e.getUnfinishedMessage();
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

    public f a(long j) {
        this.a |= 1;
        this.b = j;
        return this;
    }

    public f b(long j) {
        this.a |= 2;
        this.c = j;
        return this;
    }

    public f c(long j) {
        this.a |= 4;
        this.d = j;
        return this;
    }

    public f d(long j) {
        this.a |= 8;
        this.e = j;
        return this;
    }
}
