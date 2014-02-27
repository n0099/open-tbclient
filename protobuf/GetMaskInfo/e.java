package protobuf.GetMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<GetMaskInfoReq.GetMaskInfoReqIdl, e> implements f {
    private int a;
    private GetMaskInfoReq.DataReq b = GetMaskInfoReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = GetMaskInfoReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final GetMaskInfoReq.GetMaskInfoReqIdl build() {
        GetMaskInfoReq.GetMaskInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetMaskInfoReq.GetMaskInfoReqIdl buildPartial() {
        GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl = new GetMaskInfoReq.GetMaskInfoReqIdl(this, (GetMaskInfoReq.GetMaskInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        getMaskInfoReqIdl.data_ = this.b;
        getMaskInfoReqIdl.bitField0_ = i;
        return getMaskInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl) {
        if (getMaskInfoReqIdl != GetMaskInfoReq.GetMaskInfoReqIdl.getDefaultInstance() && getMaskInfoReqIdl.hasData()) {
            GetMaskInfoReq.DataReq data = getMaskInfoReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == GetMaskInfoReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = GetMaskInfoReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl;
        Throwable th;
        try {
            try {
                GetMaskInfoReq.GetMaskInfoReqIdl parsePartialFrom = GetMaskInfoReq.GetMaskInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getMaskInfoReqIdl = null;
                if (getMaskInfoReqIdl != null) {
                    mergeFrom(getMaskInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl2 = (GetMaskInfoReq.GetMaskInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getMaskInfoReqIdl = getMaskInfoReqIdl2;
                th = th3;
                if (getMaskInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(GetMaskInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
