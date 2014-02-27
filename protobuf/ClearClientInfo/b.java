package protobuf.ClearClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.ClearClientInfo.ClearClientInfoReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<ClearClientInfoReq.ClearClientInfoReqIdl, b> implements c {
    private int a;
    private ClearClientInfoReq.DataReq b = ClearClientInfoReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        ClearClientInfoReq.ClearClientInfoReqIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return ClearClientInfoReq.ClearClientInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return ClearClientInfoReq.ClearClientInfoReqIdl.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b a() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clear() {
        super.clear();
        this.b = ClearClientInfoReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ClearClientInfoReq.ClearClientInfoReqIdl buildPartial() {
        ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl = new ClearClientInfoReq.ClearClientInfoReqIdl(this, (ClearClientInfoReq.ClearClientInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        clearClientInfoReqIdl.data_ = this.b;
        clearClientInfoReqIdl.bitField0_ = i;
        return clearClientInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(ClearClientInfoReq.ClearClientInfoReqIdl clearClientInfoReqIdl) {
        if (clearClientInfoReqIdl != ClearClientInfoReq.ClearClientInfoReqIdl.getDefaultInstance() && clearClientInfoReqIdl.hasData()) {
            ClearClientInfoReq.DataReq data = clearClientInfoReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == ClearClientInfoReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = ClearClientInfoReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
}
