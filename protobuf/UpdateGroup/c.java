package protobuf.UpdateGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<UpdateGroupReq.UpdateGroupReqIdl, c> implements d {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();

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
        this.b = Im.GroupInfo.getDefaultInstance();
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
    public UpdateGroupReq.UpdateGroupReqIdl getDefaultInstanceForType() {
        return UpdateGroupReq.UpdateGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateGroupReq.UpdateGroupReqIdl build() {
        UpdateGroupReq.UpdateGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateGroupReq.UpdateGroupReqIdl buildPartial() {
        UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl = new UpdateGroupReq.UpdateGroupReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateGroupReqIdl.data_ = this.b;
        updateGroupReqIdl.bitField0_ = i;
        return updateGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(UpdateGroupReq.UpdateGroupReqIdl updateGroupReqIdl) {
        if (updateGroupReqIdl != UpdateGroupReq.UpdateGroupReqIdl.getDefaultInstance() && updateGroupReqIdl.hasData()) {
            b(updateGroupReqIdl.getData());
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

    public c a(Im.GroupInfo groupInfo) {
        if (groupInfo != null) {
            this.b = groupInfo;
            this.a |= 1;
        }
        return this;
    }

    public c b(Im.GroupInfo groupInfo) {
        if ((this.a & 1) == 1 && this.b != Im.GroupInfo.getDefaultInstance()) {
            this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(groupInfo).buildPartial();
        } else {
            this.b = groupInfo;
        }
        this.a |= 1;
        return this;
    }
}
