package protobuf.DelGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<DelGroupActivityRes.DelGroupActivityResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupActivityRes.DataRes c = DelGroupActivityRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        DelGroupActivityRes.DelGroupActivityResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupActivityRes.DelGroupActivityResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupActivityRes.DelGroupActivityResIdl.getDefaultInstance();
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
        this.c = DelGroupActivityRes.DataRes.getDefaultInstance();
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
    public final k mergeFrom(DelGroupActivityRes.DelGroupActivityResIdl delGroupActivityResIdl) {
        if (delGroupActivityResIdl != DelGroupActivityRes.DelGroupActivityResIdl.getDefaultInstance()) {
            if (delGroupActivityResIdl.hasError()) {
                Im.Error error = delGroupActivityResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (delGroupActivityResIdl.hasData()) {
                DelGroupActivityRes.DataRes data = delGroupActivityResIdl.getData();
                if ((this.a & 2) != 2 || this.c == DelGroupActivityRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = DelGroupActivityRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
