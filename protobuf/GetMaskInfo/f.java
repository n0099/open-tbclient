package protobuf.GetMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<GetMaskInfoReq.GetMaskInfoReqIdl, f> implements g {
    private int a;
    private GetMaskInfoReq.DataReq b = GetMaskInfoReq.DataReq.getDefaultInstance();

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
        this.b = GetMaskInfoReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetMaskInfoReq.GetMaskInfoReqIdl getDefaultInstanceForType() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetMaskInfoReq.GetMaskInfoReqIdl build() {
        GetMaskInfoReq.GetMaskInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetMaskInfoReq.GetMaskInfoReqIdl buildPartial() {
        GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl = new GetMaskInfoReq.GetMaskInfoReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        getMaskInfoReqIdl.data_ = this.b;
        getMaskInfoReqIdl.bitField0_ = i;
        return getMaskInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(GetMaskInfoReq.GetMaskInfoReqIdl getMaskInfoReqIdl) {
        if (getMaskInfoReqIdl != GetMaskInfoReq.GetMaskInfoReqIdl.getDefaultInstance() && getMaskInfoReqIdl.hasData()) {
            b(getMaskInfoReqIdl.getData());
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

    public f a(GetMaskInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(GetMaskInfoReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != GetMaskInfoReq.DataReq.getDefaultInstance()) {
            this.b = GetMaskInfoReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
