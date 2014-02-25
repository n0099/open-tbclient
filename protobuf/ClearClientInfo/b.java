package protobuf.ClearClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ClearClientInfo.ClearClientInfoReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<ClearClientInfoReq.ClearClientInfoReqIdl, b> implements c {
    private int a;
    private ClearClientInfoReq.DataReq b = ClearClientInfoReq.DataReq.getDefaultInstance();

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
        this.b = ClearClientInfoReq.DataReq.getDefaultInstance();
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
    public ClearClientInfoReq.ClearClientInfoReqIdl getDefaultInstanceForType() {
        return ClearClientInfoReq.ClearClientInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ClearClientInfoReq.ClearClientInfoReqIdl build() {
        ClearClientInfoReq.ClearClientInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ClearClientInfoReq.ClearClientInfoReqIdl buildPartial() {
        ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl = new ClearClientInfoReq.ClearClientInfoReqIdl(this, (ClearClientInfoReq.ClearClientInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        clearClientInfoReqIdl.data_ = this.b;
        clearClientInfoReqIdl.bitField0_ = i;
        return clearClientInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl) {
        if (clearClientInfoReqIdl != ClearClientInfoReq.ClearClientInfoReqIdl.getDefaultInstance() && clearClientInfoReqIdl.hasData()) {
            a(clearClientInfoReqIdl.getData());
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
        ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl;
        Throwable th;
        try {
            try {
                ClearClientInfoReq.ClearClientInfoReqIdl parsePartialFrom = ClearClientInfoReq.ClearClientInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                clearClientInfoReqIdl = null;
                if (clearClientInfoReqIdl != null) {
                    mergeFrom(clearClientInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl2 = (ClearClientInfoReq.ClearClientInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                clearClientInfoReqIdl = clearClientInfoReqIdl2;
                th = th3;
                if (clearClientInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(ClearClientInfoReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != ClearClientInfoReq.DataReq.getDefaultInstance()) {
            this.b = ClearClientInfoReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
