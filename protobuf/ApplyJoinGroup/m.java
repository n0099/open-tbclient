package protobuf.ApplyJoinGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<ApplyJoinGroupRes.DataRes, m> implements n {
    private int a;
    private int b;

    private m() {
        g();
    }

    private void g() {
    }

    public static m h() {
        return new m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public m clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ApplyJoinGroupRes.DataRes getDefaultInstanceForType() {
        return ApplyJoinGroupRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ApplyJoinGroupRes.DataRes build() {
        ApplyJoinGroupRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ApplyJoinGroupRes.DataRes buildPartial() {
        ApplyJoinGroupRes.DataRes dataRes = new ApplyJoinGroupRes.DataRes(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.groupId_ = this.b;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(ApplyJoinGroupRes.DataRes dataRes) {
        if (dataRes != ApplyJoinGroupRes.DataRes.getDefaultInstance() && dataRes.hasGroupId()) {
            a(dataRes.getGroupId());
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
    public m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ApplyJoinGroupRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                ApplyJoinGroupRes.DataRes parsePartialFrom = ApplyJoinGroupRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            ApplyJoinGroupRes.DataRes dataRes2 = (ApplyJoinGroupRes.DataRes) e.getUnfinishedMessage();
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

    public m a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }
}
