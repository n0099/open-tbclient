package protobuf.UpdateMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<UpdateMaskInfoReq.UpdateMaskInfoReqIdl, e> implements f {
    private int a;
    private UpdateMaskInfoReq.DataReq b = UpdateMaskInfoReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateMaskInfoReq.UpdateMaskInfoReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateMaskInfoReq.UpdateMaskInfoReqIdl.getDefaultInstance();
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
        this.b = UpdateMaskInfoReq.DataReq.getDefaultInstance();
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
    public final UpdateMaskInfoReq.UpdateMaskInfoReqIdl build() {
        UpdateMaskInfoReq.UpdateMaskInfoReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateMaskInfoReq.UpdateMaskInfoReqIdl buildPartial() {
        UpdateMaskInfoReq.UpdateMaskInfoReqIdl updateMaskInfoReqIdl = new UpdateMaskInfoReq.UpdateMaskInfoReqIdl(this, (UpdateMaskInfoReq.UpdateMaskInfoReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateMaskInfoReqIdl.data_ = this.b;
        updateMaskInfoReqIdl.bitField0_ = i;
        return updateMaskInfoReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(UpdateMaskInfoReq.UpdateMaskInfoReqIdl updateMaskInfoReqIdl) {
        if (updateMaskInfoReqIdl != UpdateMaskInfoReq.UpdateMaskInfoReqIdl.getDefaultInstance() && updateMaskInfoReqIdl.hasData()) {
            UpdateMaskInfoReq.DataReq data = updateMaskInfoReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == UpdateMaskInfoReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = UpdateMaskInfoReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        UpdateMaskInfoReq.UpdateMaskInfoReqIdl updateMaskInfoReqIdl;
        Throwable th;
        try {
            try {
                UpdateMaskInfoReq.UpdateMaskInfoReqIdl parsePartialFrom = UpdateMaskInfoReq.UpdateMaskInfoReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateMaskInfoReqIdl = null;
                if (updateMaskInfoReqIdl != null) {
                    mergeFrom(updateMaskInfoReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateMaskInfoReq.UpdateMaskInfoReqIdl updateMaskInfoReqIdl2 = (UpdateMaskInfoReq.UpdateMaskInfoReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateMaskInfoReqIdl = updateMaskInfoReqIdl2;
                th = th3;
                if (updateMaskInfoReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final e a(UpdateMaskInfoReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
