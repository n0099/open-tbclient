package protobuf.UpdateGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<UpdateGroupReq.UpdateGroupReqIdl, b> implements c {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateGroupReq.UpdateGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateGroupReq.UpdateGroupReqIdl.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b b() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public b clear() {
        super.clear();
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final UpdateGroupReq.UpdateGroupReqIdl build() {
        UpdateGroupReq.UpdateGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateGroupReq.UpdateGroupReqIdl buildPartial() {
        UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl = new UpdateGroupReq.UpdateGroupReqIdl(this, (UpdateGroupReq.UpdateGroupReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateGroupReqIdl.data_ = this.b;
        updateGroupReqIdl.bitField0_ = i;
        return updateGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl) {
        if (updateGroupReqIdl != UpdateGroupReq.UpdateGroupReqIdl.getDefaultInstance() && updateGroupReqIdl.hasData()) {
            Im.GroupInfo data = updateGroupReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == Im.GroupInfo.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(data).buildPartial();
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
        UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl;
        Throwable th;
        try {
            try {
                UpdateGroupReq.UpdateGroupReqIdl parsePartialFrom = UpdateGroupReq.UpdateGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateGroupReqIdl = null;
                if (updateGroupReqIdl != null) {
                    mergeFrom(updateGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl2 = (UpdateGroupReq.UpdateGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateGroupReqIdl = updateGroupReqIdl2;
                th = th3;
                if (updateGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final b a(Im.GroupInfo groupInfo) {
        if (groupInfo != null) {
            this.b = groupInfo;
            this.a |= 1;
        }
        return this;
    }
}
