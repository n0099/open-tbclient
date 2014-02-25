package protobuf.DelGroupMsgs;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<DelGroupMsgsRes.DataRes, h> implements i {
    private int a;
    private int b;

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public DelGroupMsgsRes.DataRes getDefaultInstanceForType() {
        return DelGroupMsgsRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupMsgsRes.DataRes build() {
        DelGroupMsgsRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupMsgsRes.DataRes buildPartial() {
        DelGroupMsgsRes.DataRes dataRes = new DelGroupMsgsRes.DataRes(this, (DelGroupMsgsRes.DataRes) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.groupId_ = this.b;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(DelGroupMsgsRes.DataRes dataRes) {
        if (dataRes != DelGroupMsgsRes.DataRes.getDefaultInstance() && dataRes.hasGroupId()) {
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DelGroupMsgsRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                DelGroupMsgsRes.DataRes parsePartialFrom = DelGroupMsgsRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            DelGroupMsgsRes.DataRes dataRes2 = (DelGroupMsgsRes.DataRes) e.getUnfinishedMessage();
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

    public h a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }
}
