package protobuf.ClearClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.ClearClientInfo.ClearClientInfoRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<ClearClientInfoRes.ClearClientInfoResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private ClearClientInfoRes.DataRes c = ClearClientInfoRes.DataRes.getDefaultInstance();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = ClearClientInfoRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public ClearClientInfoRes.ClearClientInfoResIdl getDefaultInstanceForType() {
        return ClearClientInfoRes.ClearClientInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ClearClientInfoRes.ClearClientInfoResIdl build() {
        ClearClientInfoRes.ClearClientInfoResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public ClearClientInfoRes.ClearClientInfoResIdl buildPartial() {
        ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl = new ClearClientInfoRes.ClearClientInfoResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        clearClientInfoResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        clearClientInfoResIdl.data_ = this.c;
        clearClientInfoResIdl.bitField0_ = i2;
        return clearClientInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl) {
        if (clearClientInfoResIdl != ClearClientInfoRes.ClearClientInfoResIdl.getDefaultInstance()) {
            if (clearClientInfoResIdl.hasError()) {
                a(clearClientInfoResIdl.getError());
            }
            if (clearClientInfoResIdl.hasData()) {
                a(clearClientInfoResIdl.getData());
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl;
        Throwable th;
        try {
            try {
                ClearClientInfoRes.ClearClientInfoResIdl parsePartialFrom = ClearClientInfoRes.ClearClientInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                clearClientInfoResIdl = null;
                if (clearClientInfoResIdl != null) {
                    mergeFrom(clearClientInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl2 = (ClearClientInfoRes.ClearClientInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                clearClientInfoResIdl = clearClientInfoResIdl2;
                th = th3;
                if (clearClientInfoResIdl != null) {
                }
                throw th;
            }
        }
    }

    public j a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public j a(ClearClientInfoRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != ClearClientInfoRes.DataRes.getDefaultInstance()) {
            this.c = ClearClientInfoRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
