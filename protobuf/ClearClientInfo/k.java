package protobuf.ClearClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.ClearClientInfo.ClearClientInfoRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<ClearClientInfoRes.DataRes, k> implements l {
    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        ClearClientInfoRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
        super.clear();
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    public final /* bridge */ /* synthetic */ MessageLite.Builder clear() {
        super.clear();
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return ClearClientInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return ClearClientInfoRes.DataRes.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final ClearClientInfoRes.DataRes buildPartial() {
        return new ClearClientInfoRes.DataRes(this, (ClearClientInfoRes.DataRes) null);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(ClearClientInfoRes.DataRes dataRes) {
        if (dataRes == ClearClientInfoRes.DataRes.getDefaultInstance()) {
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ClearClientInfoRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                ClearClientInfoRes.DataRes parsePartialFrom = ClearClientInfoRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            ClearClientInfoRes.DataRes dataRes2 = (ClearClientInfoRes.DataRes) e.getUnfinishedMessage();
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
}
