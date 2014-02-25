package protobuf.CommitPusherCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<CommitPusherCountReq.CommitPusherCountReqIdl, b> implements c {
    private int a;
    private CommitPusherCountReq.DataReq b = CommitPusherCountReq.DataReq.getDefaultInstance();

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
        this.b = CommitPusherCountReq.DataReq.getDefaultInstance();
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
    public CommitPusherCountReq.CommitPusherCountReqIdl getDefaultInstanceForType() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public CommitPusherCountReq.CommitPusherCountReqIdl build() {
        CommitPusherCountReq.CommitPusherCountReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public CommitPusherCountReq.CommitPusherCountReqIdl buildPartial() {
        CommitPusherCountReq.CommitPusherCountReqIdl commitPusherCountReqIdl = new CommitPusherCountReq.CommitPusherCountReqIdl(this, (CommitPusherCountReq.CommitPusherCountReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        commitPusherCountReqIdl.data_ = this.b;
        commitPusherCountReqIdl.bitField0_ = i;
        return commitPusherCountReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(CommitPusherCountReq.CommitPusherCountReqIdl commitPusherCountReqIdl) {
        if (commitPusherCountReqIdl != CommitPusherCountReq.CommitPusherCountReqIdl.getDefaultInstance() && commitPusherCountReqIdl.hasData()) {
            b(commitPusherCountReqIdl.getData());
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
        CommitPusherCountReq.CommitPusherCountReqIdl commitPusherCountReqIdl;
        Throwable th;
        try {
            try {
                CommitPusherCountReq.CommitPusherCountReqIdl parsePartialFrom = CommitPusherCountReq.CommitPusherCountReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                commitPusherCountReqIdl = null;
                if (commitPusherCountReqIdl != null) {
                    mergeFrom(commitPusherCountReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            CommitPusherCountReq.CommitPusherCountReqIdl commitPusherCountReqIdl2 = (CommitPusherCountReq.CommitPusherCountReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                commitPusherCountReqIdl = commitPusherCountReqIdl2;
                th = th3;
                if (commitPusherCountReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(CommitPusherCountReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public b b(CommitPusherCountReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != CommitPusherCountReq.DataReq.getDefaultInstance()) {
            this.b = CommitPusherCountReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
