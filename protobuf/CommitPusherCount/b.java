package protobuf.CommitPusherCount;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<CommitPusherCountReq.CommitPusherCountReqIdl, b> implements c {
    private int a;
    private CommitPusherCountReq.DataReq b = CommitPusherCountReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.getDefaultInstance();
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
        this.b = CommitPusherCountReq.DataReq.getDefaultInstance();
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
    public final CommitPusherCountReq.CommitPusherCountReqIdl build() {
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
    public final b mergeFrom(CommitPusherCountReq.CommitPusherCountReqIdl commitPusherCountReqIdl) {
        if (commitPusherCountReqIdl != CommitPusherCountReq.CommitPusherCountReqIdl.getDefaultInstance() && commitPusherCountReqIdl.hasData()) {
            CommitPusherCountReq.DataReq data = commitPusherCountReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == CommitPusherCountReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = CommitPusherCountReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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

    public final b a(CommitPusherCountReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
