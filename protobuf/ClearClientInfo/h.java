package protobuf.ClearClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.ClearClientInfo.ClearClientInfoRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<ClearClientInfoRes.ClearClientInfoResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private ClearClientInfoRes.DataRes c = ClearClientInfoRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        ClearClientInfoRes.ClearClientInfoResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return ClearClientInfoRes.ClearClientInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return ClearClientInfoRes.ClearClientInfoResIdl.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h a() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = ClearClientInfoRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ClearClientInfoRes.ClearClientInfoResIdl buildPartial() {
        ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl = new ClearClientInfoRes.ClearClientInfoResIdl(this, (ClearClientInfoRes.ClearClientInfoResIdl) null);
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
    public final h mergeFrom(ClearClientInfoRes.ClearClientInfoResIdl clearClientInfoResIdl) {
        if (clearClientInfoResIdl != ClearClientInfoRes.ClearClientInfoResIdl.getDefaultInstance()) {
            if (clearClientInfoResIdl.hasError()) {
                Im.Error error = clearClientInfoResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (clearClientInfoResIdl.hasData()) {
                ClearClientInfoRes.DataRes data = clearClientInfoResIdl.getData();
                if ((this.a & 2) != 2 || this.c == ClearClientInfoRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = ClearClientInfoRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
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
}
