package protobuf.GetMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.GetMaskInfo.GetMaskInfoRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<GetMaskInfoRes.GetMaskInfoResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private GetMaskInfoRes.DataRes c = GetMaskInfoRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        GetMaskInfoRes.GetMaskInfoResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return GetMaskInfoRes.GetMaskInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return GetMaskInfoRes.GetMaskInfoResIdl.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = GetMaskInfoRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetMaskInfoRes.GetMaskInfoResIdl buildPartial() {
        GetMaskInfoRes.GetMaskInfoResIdl getMaskInfoResIdl = new GetMaskInfoRes.GetMaskInfoResIdl(this, (GetMaskInfoRes.GetMaskInfoResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        getMaskInfoResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        getMaskInfoResIdl.data_ = this.c;
        getMaskInfoResIdl.bitField0_ = i2;
        return getMaskInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(GetMaskInfoRes.GetMaskInfoResIdl getMaskInfoResIdl) {
        if (getMaskInfoResIdl != GetMaskInfoRes.GetMaskInfoResIdl.getDefaultInstance()) {
            if (getMaskInfoResIdl.hasError()) {
                Im.Error error = getMaskInfoResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (getMaskInfoResIdl.hasData()) {
                GetMaskInfoRes.DataRes data = getMaskInfoResIdl.getData();
                if ((this.a & 2) != 2 || this.c == GetMaskInfoRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = GetMaskInfoRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetMaskInfoRes.GetMaskInfoResIdl getMaskInfoResIdl;
        Throwable th;
        try {
            try {
                GetMaskInfoRes.GetMaskInfoResIdl parsePartialFrom = GetMaskInfoRes.GetMaskInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getMaskInfoResIdl = null;
                if (getMaskInfoResIdl != null) {
                    mergeFrom(getMaskInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetMaskInfoRes.GetMaskInfoResIdl getMaskInfoResIdl2 = (GetMaskInfoRes.GetMaskInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getMaskInfoResIdl = getMaskInfoResIdl2;
                th = th3;
                if (getMaskInfoResIdl != null) {
                }
                throw th;
            }
        }
    }
}
