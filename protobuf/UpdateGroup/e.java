package protobuf.UpdateGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<UpdateGroupRes.DataRes, e> implements f {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();

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
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateGroupRes.DataRes getDefaultInstanceForType() {
        return UpdateGroupRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateGroupRes.DataRes build() {
        UpdateGroupRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateGroupRes.DataRes buildPartial() {
        UpdateGroupRes.DataRes dataRes = new UpdateGroupRes.DataRes(this, (UpdateGroupRes.DataRes) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.group_ = this.b;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(UpdateGroupRes.DataRes dataRes) {
        if (dataRes != UpdateGroupRes.DataRes.getDefaultInstance() && dataRes.hasGroup()) {
            a(dataRes.getGroup());
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
        UpdateGroupRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                UpdateGroupRes.DataRes parsePartialFrom = UpdateGroupRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateGroupRes.DataRes dataRes2 = (UpdateGroupRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public e a(Im.GroupInfo groupInfo) {
        if ((this.a & 1) == 1 && this.b != Im.GroupInfo.getDefaultInstance()) {
            this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(groupInfo).buildPartial();
        } else {
            this.b = groupInfo;
        }
        this.a |= 1;
        return this;
    }
}
