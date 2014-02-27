package protobuf.DelGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<DelGroupReq.DelGroupReqIdl, e> implements f {
    private int a;
    private DelGroupReq.DataReq b = DelGroupReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupReq.DelGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupReq.DelGroupReqIdl.getDefaultInstance();
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
        this.b = DelGroupReq.DataReq.getDefaultInstance();
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
    public final DelGroupReq.DelGroupReqIdl build() {
        DelGroupReq.DelGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupReq.DelGroupReqIdl buildPartial() {
        DelGroupReq.DelGroupReqIdl delGroupReqIdl = new DelGroupReq.DelGroupReqIdl(this, (DelGroupReq.DelGroupReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        delGroupReqIdl.data_ = this.b;
        delGroupReqIdl.bitField0_ = i;
        return delGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(DelGroupReq.DelGroupReqIdl delGroupReqIdl) {
        if (delGroupReqIdl != DelGroupReq.DelGroupReqIdl.getDefaultInstance() && delGroupReqIdl.hasData()) {
            DelGroupReq.DataReq data = delGroupReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == DelGroupReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = DelGroupReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        DelGroupReq.DelGroupReqIdl delGroupReqIdl;
        Throwable th;
        try {
            try {
                DelGroupReq.DelGroupReqIdl parsePartialFrom = DelGroupReq.DelGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupReqIdl = null;
                if (delGroupReqIdl != null) {
                    mergeFrom(delGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupReq.DelGroupReqIdl delGroupReqIdl2 = (DelGroupReq.DelGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupReqIdl = delGroupReqIdl2;
                th = th3;
                if (delGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(DelGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
