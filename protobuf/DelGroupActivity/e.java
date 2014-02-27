package protobuf.DelGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<DelGroupActivityReq.DelGroupActivityReqIdl, e> implements f {
    private int a;
    private DelGroupActivityReq.DataReq b = DelGroupActivityReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupActivityReq.DelGroupActivityReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupActivityReq.DelGroupActivityReqIdl.getDefaultInstance();
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
        this.b = DelGroupActivityReq.DataReq.getDefaultInstance();
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
    public final DelGroupActivityReq.DelGroupActivityReqIdl build() {
        DelGroupActivityReq.DelGroupActivityReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupActivityReq.DelGroupActivityReqIdl buildPartial() {
        DelGroupActivityReq.DelGroupActivityReqIdl delGroupActivityReqIdl = new DelGroupActivityReq.DelGroupActivityReqIdl(this, (DelGroupActivityReq.DelGroupActivityReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        delGroupActivityReqIdl.data_ = this.b;
        delGroupActivityReqIdl.bitField0_ = i;
        return delGroupActivityReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(DelGroupActivityReq.DelGroupActivityReqIdl delGroupActivityReqIdl) {
        if (delGroupActivityReqIdl != DelGroupActivityReq.DelGroupActivityReqIdl.getDefaultInstance() && delGroupActivityReqIdl.hasData()) {
            DelGroupActivityReq.DataReq data = delGroupActivityReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == DelGroupActivityReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = DelGroupActivityReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        DelGroupActivityReq.DelGroupActivityReqIdl delGroupActivityReqIdl;
        Throwable th;
        try {
            try {
                DelGroupActivityReq.DelGroupActivityReqIdl parsePartialFrom = DelGroupActivityReq.DelGroupActivityReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupActivityReqIdl = null;
                if (delGroupActivityReqIdl != null) {
                    mergeFrom(delGroupActivityReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupActivityReq.DelGroupActivityReqIdl delGroupActivityReqIdl2 = (DelGroupActivityReq.DelGroupActivityReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupActivityReqIdl = delGroupActivityReqIdl2;
                th = th3;
                if (delGroupActivityReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(DelGroupActivityReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
