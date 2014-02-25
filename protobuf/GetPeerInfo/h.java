package protobuf.GetPeerInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<GetPeerInfoRes.DataRes, h> implements i {
    private int a;
    private int b;
    private Object c = "";

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
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetPeerInfoRes.DataRes getDefaultInstanceForType() {
        return GetPeerInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetPeerInfoRes.DataRes build() {
        GetPeerInfoRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetPeerInfoRes.DataRes buildPartial() {
        GetPeerInfoRes.DataRes dataRes = new GetPeerInfoRes.DataRes(this, (GetPeerInfoRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.isAllowed_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.lbs_ = this.c;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(GetPeerInfoRes.DataRes dataRes) {
        Object obj;
        if (dataRes != GetPeerInfoRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasIsAllowed()) {
                a(dataRes.getIsAllowed());
            }
            if (dataRes.hasLbs()) {
                this.a |= 2;
                obj = dataRes.lbs_;
                this.c = obj;
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetPeerInfoRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                GetPeerInfoRes.DataRes parsePartialFrom = GetPeerInfoRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            GetPeerInfoRes.DataRes dataRes2 = (GetPeerInfoRes.DataRes) e.getUnfinishedMessage();
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
