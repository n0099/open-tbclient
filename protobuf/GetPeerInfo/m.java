package protobuf.GetPeerInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetPeerInfo.GetPeerInfoRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<GetPeerInfoRes.GetPeerInfoResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private GetPeerInfoRes.DataRes c = GetPeerInfoRes.DataRes.getDefaultInstance();

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
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = GetPeerInfoRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public m clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetPeerInfoRes.GetPeerInfoResIdl getDefaultInstanceForType() {
        return GetPeerInfoRes.GetPeerInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetPeerInfoRes.GetPeerInfoResIdl build() {
        GetPeerInfoRes.GetPeerInfoResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetPeerInfoRes.GetPeerInfoResIdl buildPartial() {
        GetPeerInfoRes.GetPeerInfoResIdl getPeerInfoResIdl = new GetPeerInfoRes.GetPeerInfoResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        getPeerInfoResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        getPeerInfoResIdl.data_ = this.c;
        getPeerInfoResIdl.bitField0_ = i2;
        return getPeerInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(GetPeerInfoRes.GetPeerInfoResIdl getPeerInfoResIdl) {
        if (getPeerInfoResIdl != GetPeerInfoRes.GetPeerInfoResIdl.getDefaultInstance()) {
            if (getPeerInfoResIdl.hasError()) {
                a(getPeerInfoResIdl.getError());
            }
            if (getPeerInfoResIdl.hasData()) {
                a(getPeerInfoResIdl.getData());
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
    public m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetPeerInfoRes.GetPeerInfoResIdl getPeerInfoResIdl;
        Throwable th;
        try {
            try {
                GetPeerInfoRes.GetPeerInfoResIdl parsePartialFrom = GetPeerInfoRes.GetPeerInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getPeerInfoResIdl = null;
                if (getPeerInfoResIdl != null) {
                    mergeFrom(getPeerInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetPeerInfoRes.GetPeerInfoResIdl getPeerInfoResIdl2 = (GetPeerInfoRes.GetPeerInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getPeerInfoResIdl = getPeerInfoResIdl2;
                th = th3;
                if (getPeerInfoResIdl != null) {
                }
                throw th;
            }
        }
    }

    public m a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public m a(GetPeerInfoRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != GetPeerInfoRes.DataRes.getDefaultInstance()) {
            this.c = GetPeerInfoRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
