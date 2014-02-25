package protobuf.DelGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupActivity.DelGroupActivityRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<DelGroupActivityRes.DelGroupActivityResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupActivityRes.DataRes c = DelGroupActivityRes.DataRes.getDefaultInstance();

    private k() {
        g();
    }

    private void g() {
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = DelGroupActivityRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public DelGroupActivityRes.DelGroupActivityResIdl getDefaultInstanceForType() {
        return DelGroupActivityRes.DelGroupActivityResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupActivityRes.DelGroupActivityResIdl build() {
        DelGroupActivityRes.DelGroupActivityResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupActivityRes.DelGroupActivityResIdl buildPartial() {
        DelGroupActivityRes.DelGroupActivityResIdl delGroupActivityResIdl = new DelGroupActivityRes.DelGroupActivityResIdl(this, (DelGroupActivityRes.DelGroupActivityResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        delGroupActivityResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        delGroupActivityResIdl.data_ = this.c;
        delGroupActivityResIdl.bitField0_ = i2;
        return delGroupActivityResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(DelGroupActivityRes.DelGroupActivityResIdl delGroupActivityResIdl) {
        if (delGroupActivityResIdl != DelGroupActivityRes.DelGroupActivityResIdl.getDefaultInstance()) {
            if (delGroupActivityResIdl.hasError()) {
                a(delGroupActivityResIdl.getError());
            }
            if (delGroupActivityResIdl.hasData()) {
                a(delGroupActivityResIdl.getData());
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
        DelGroupActivityRes.DelGroupActivityResIdl delGroupActivityResIdl;
        Throwable th;
        try {
            try {
                DelGroupActivityRes.DelGroupActivityResIdl parsePartialFrom = DelGroupActivityRes.DelGroupActivityResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupActivityResIdl = null;
                if (delGroupActivityResIdl != null) {
                    mergeFrom(delGroupActivityResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupActivityRes.DelGroupActivityResIdl delGroupActivityResIdl2 = (DelGroupActivityRes.DelGroupActivityResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupActivityResIdl = delGroupActivityResIdl2;
                th = th3;
                if (delGroupActivityResIdl != null) {
                }
                throw th;
            }
        }
    }

    public k a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public k a(DelGroupActivityRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != DelGroupActivityRes.DataRes.getDefaultInstance()) {
            this.c = DelGroupActivityRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
