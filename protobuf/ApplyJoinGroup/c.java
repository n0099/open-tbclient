package protobuf.ApplyJoinGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ApplyJoinGroup.ApplyJoinGroupReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<ApplyJoinGroupReq.ApplyJoinGroupReqIdl, c> implements d {
    private int a;
    private ApplyJoinGroupReq.DataReq b = ApplyJoinGroupReq.DataReq.getDefaultInstance();

    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
        super.clear();
        this.b = ApplyJoinGroupReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ApplyJoinGroupReq.ApplyJoinGroupReqIdl getDefaultInstanceForType() {
        return ApplyJoinGroupReq.ApplyJoinGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ApplyJoinGroupReq.ApplyJoinGroupReqIdl build() {
        ApplyJoinGroupReq.ApplyJoinGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ApplyJoinGroupReq.ApplyJoinGroupReqIdl buildPartial() {
        ApplyJoinGroupReq.ApplyJoinGroupReqIdl applyJoinGroupReqIdl = new ApplyJoinGroupReq.ApplyJoinGroupReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        applyJoinGroupReqIdl.data_ = this.b;
        applyJoinGroupReqIdl.bitField0_ = i;
        return applyJoinGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(ApplyJoinGroupReq.ApplyJoinGroupReqIdl applyJoinGroupReqIdl) {
        if (applyJoinGroupReqIdl != ApplyJoinGroupReq.ApplyJoinGroupReqIdl.getDefaultInstance() && applyJoinGroupReqIdl.hasData()) {
            b(applyJoinGroupReqIdl.getData());
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ApplyJoinGroupReq.ApplyJoinGroupReqIdl applyJoinGroupReqIdl;
        Throwable th;
        try {
            try {
                ApplyJoinGroupReq.ApplyJoinGroupReqIdl parsePartialFrom = ApplyJoinGroupReq.ApplyJoinGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                applyJoinGroupReqIdl = null;
                if (applyJoinGroupReqIdl != null) {
                    mergeFrom(applyJoinGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ApplyJoinGroupReq.ApplyJoinGroupReqIdl applyJoinGroupReqIdl2 = (ApplyJoinGroupReq.ApplyJoinGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                applyJoinGroupReqIdl = applyJoinGroupReqIdl2;
                th = th3;
                if (applyJoinGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public c a(ApplyJoinGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public c b(ApplyJoinGroupReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != ApplyJoinGroupReq.DataReq.getDefaultInstance()) {
            this.b = ApplyJoinGroupReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
