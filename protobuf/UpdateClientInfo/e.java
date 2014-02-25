package protobuf.UpdateClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<UpdateClientInfoReq.UpdateClientInfoReqIdl, e> implements f {
    private int a;
    private Object b = "";
    private UpdateClientInfoReq.DataReq c = UpdateClientInfoReq.DataReq.getDefaultInstance();

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
        this.b = "";
        this.a &= -2;
        this.c = UpdateClientInfoReq.DataReq.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateClientInfoReq.UpdateClientInfoReqIdl getDefaultInstanceForType() {
        return UpdateClientInfoReq.UpdateClientInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateClientInfoReq.UpdateClientInfoReqIdl build() {
        UpdateClientInfoReq.UpdateClientInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateClientInfoReq.UpdateClientInfoReqIdl buildPartial() {
        UpdateClientInfoReq.UpdateClientInfoReqIdl updateClientInfoReqIdl = new UpdateClientInfoReq.UpdateClientInfoReqIdl(this, (UpdateClientInfoReq.UpdateClientInfoReqIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        updateClientInfoReqIdl.cuid_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        updateClientInfoReqIdl.data_ = this.c;
        updateClientInfoReqIdl.bitField0_ = i2;
        return updateClientInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(UpdateClientInfoReq.UpdateClientInfoReqIdl updateClientInfoReqIdl) {
        Object obj;
        if (updateClientInfoReqIdl != UpdateClientInfoReq.UpdateClientInfoReqIdl.getDefaultInstance()) {
            if (updateClientInfoReqIdl.hasCuid()) {
                this.a |= 1;
                obj = updateClientInfoReqIdl.cuid_;
                this.b = obj;
            }
            if (updateClientInfoReqIdl.hasData()) {
                b(updateClientInfoReqIdl.getData());
            }
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
        UpdateClientInfoReq.UpdateClientInfoReqIdl updateClientInfoReqIdl;
        Throwable th;
        try {
            try {
                UpdateClientInfoReq.UpdateClientInfoReqIdl parsePartialFrom = UpdateClientInfoReq.UpdateClientInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateClientInfoReqIdl = null;
                if (updateClientInfoReqIdl != null) {
                    mergeFrom(updateClientInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateClientInfoReq.UpdateClientInfoReqIdl updateClientInfoReqIdl2 = (UpdateClientInfoReq.UpdateClientInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateClientInfoReqIdl = updateClientInfoReqIdl2;
                th = th3;
                if (updateClientInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(String str) {
        if (str != null) {
            this.a |= 1;
            this.b = str;
        }
        return this;
    }

    public e a(UpdateClientInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.c = dataReq;
            this.a |= 2;
        }
        return this;
    }

    public e b(UpdateClientInfoReq.DataReq dataReq) {
        if ((this.a & 2) == 2 && this.c != UpdateClientInfoReq.DataReq.getDefaultInstance()) {
            this.c = UpdateClientInfoReq.DataReq.newBuilder(this.c).mergeFrom(dataReq).buildPartial();
        } else {
            this.c = dataReq;
        }
        this.a |= 2;
        return this;
    }
}
