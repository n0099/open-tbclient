package protobuf.DelGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroup.DelGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<DelGroupRes.DelGroupResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupRes.DataRes c = DelGroupRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        DelGroupRes.DelGroupResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupRes.DelGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupRes.DelGroupResIdl.getDefaultInstance();
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
        this.c = DelGroupRes.DataRes.getDefaultInstance();
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
    public DelGroupRes.DelGroupResIdl buildPartial() {
        DelGroupRes.DelGroupResIdl delGroupResIdl = new DelGroupRes.DelGroupResIdl(this, (DelGroupRes.DelGroupResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        delGroupResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        delGroupResIdl.data_ = this.c;
        delGroupResIdl.bitField0_ = i2;
        return delGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(DelGroupRes.DelGroupResIdl delGroupResIdl) {
        if (delGroupResIdl != DelGroupRes.DelGroupResIdl.getDefaultInstance()) {
            if (delGroupResIdl.hasError()) {
                Im.Error error = delGroupResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (delGroupResIdl.hasData()) {
                DelGroupRes.DataRes data = delGroupResIdl.getData();
                if ((this.a & 2) != 2 || this.c == DelGroupRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = DelGroupRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        DelGroupRes.DelGroupResIdl delGroupResIdl;
        Throwable th;
        try {
            try {
                DelGroupRes.DelGroupResIdl parsePartialFrom = DelGroupRes.DelGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupResIdl = null;
                if (delGroupResIdl != null) {
                    mergeFrom(delGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupRes.DelGroupResIdl delGroupResIdl2 = (DelGroupRes.DelGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupResIdl = delGroupResIdl2;
                th = th3;
                if (delGroupResIdl != null) {
                }
                throw th;
            }
        }
    }
}
