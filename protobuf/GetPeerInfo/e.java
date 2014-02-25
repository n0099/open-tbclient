package protobuf.GetPeerInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetPeerInfo.GetPeerInfoReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<GetPeerInfoReq.GetPeerInfoReqIdl, e> implements f {
    private int a;
    private GetPeerInfoReq.DataReq b = GetPeerInfoReq.DataReq.getDefaultInstance();

    private e() {
        g();
    }

    private void g() {
    }

    public static e h() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public e clear() {
        super.clear();
        this.b = GetPeerInfoReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetPeerInfoReq.GetPeerInfoReqIdl getDefaultInstanceForType() {
        return GetPeerInfoReq.GetPeerInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetPeerInfoReq.GetPeerInfoReqIdl build() {
        GetPeerInfoReq.GetPeerInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetPeerInfoReq.GetPeerInfoReqIdl buildPartial() {
        GetPeerInfoReq.GetPeerInfoReqIdl getPeerInfoReqIdl = new GetPeerInfoReq.GetPeerInfoReqIdl(this, (GetPeerInfoReq.GetPeerInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        getPeerInfoReqIdl.data_ = this.b;
        getPeerInfoReqIdl.bitField0_ = i;
        return getPeerInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(GetPeerInfoReq.GetPeerInfoReqIdl getPeerInfoReqIdl) {
        if (getPeerInfoReqIdl != GetPeerInfoReq.GetPeerInfoReqIdl.getDefaultInstance() && getPeerInfoReqIdl.hasData()) {
            b(getPeerInfoReqIdl.getData());
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
        GetPeerInfoReq.GetPeerInfoReqIdl getPeerInfoReqIdl;
        Throwable th;
        try {
            try {
                GetPeerInfoReq.GetPeerInfoReqIdl parsePartialFrom = GetPeerInfoReq.GetPeerInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getPeerInfoReqIdl = null;
                if (getPeerInfoReqIdl != null) {
                    mergeFrom(getPeerInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetPeerInfoReq.GetPeerInfoReqIdl getPeerInfoReqIdl2 = (GetPeerInfoReq.GetPeerInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getPeerInfoReqIdl = getPeerInfoReqIdl2;
                th = th3;
                if (getPeerInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(GetPeerInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public e b(GetPeerInfoReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != GetPeerInfoReq.DataReq.getDefaultInstance()) {
            this.b = GetPeerInfoReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
