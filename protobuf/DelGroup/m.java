package protobuf.DelGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroup.DelGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<DelGroupRes.DelGroupResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupRes.DataRes c = DelGroupRes.DataRes.getDefaultInstance();

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
        this.c = DelGroupRes.DataRes.getDefaultInstance();
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
    public DelGroupRes.DelGroupResIdl getDefaultInstanceForType() {
        return DelGroupRes.DelGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupRes.DelGroupResIdl build() {
        DelGroupRes.DelGroupResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupRes.DelGroupResIdl buildPartial() {
        DelGroupRes.DelGroupResIdl delGroupResIdl = new DelGroupRes.DelGroupResIdl(this);
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
    public m mergeFrom(DelGroupRes.DelGroupResIdl delGroupResIdl) {
        if (delGroupResIdl != DelGroupRes.DelGroupResIdl.getDefaultInstance()) {
            if (delGroupResIdl.hasError()) {
                a(delGroupResIdl.getError());
            }
            if (delGroupResIdl.hasData()) {
                a(delGroupResIdl.getData());
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

    public m a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public m a(DelGroupRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != DelGroupRes.DataRes.getDefaultInstance()) {
            this.c = DelGroupRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
