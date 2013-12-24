package protobuf.DelGroupMsgs;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<DelGroupMsgsRes.DelGroupMsgsResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupMsgsRes.DataRes c = DelGroupMsgsRes.DataRes.getDefaultInstance();

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
        this.c = DelGroupMsgsRes.DataRes.getDefaultInstance();
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
    public DelGroupMsgsRes.DelGroupMsgsResIdl getDefaultInstanceForType() {
        return DelGroupMsgsRes.DelGroupMsgsResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupMsgsRes.DelGroupMsgsResIdl build() {
        DelGroupMsgsRes.DelGroupMsgsResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupMsgsRes.DelGroupMsgsResIdl buildPartial() {
        DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl = new DelGroupMsgsRes.DelGroupMsgsResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        delGroupMsgsResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        delGroupMsgsResIdl.data_ = this.c;
        delGroupMsgsResIdl.bitField0_ = i2;
        return delGroupMsgsResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl) {
        if (delGroupMsgsResIdl != DelGroupMsgsRes.DelGroupMsgsResIdl.getDefaultInstance()) {
            if (delGroupMsgsResIdl.hasError()) {
                a(delGroupMsgsResIdl.getError());
            }
            if (delGroupMsgsResIdl.hasData()) {
                a(delGroupMsgsResIdl.getData());
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
        DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl;
        Throwable th;
        try {
            try {
                DelGroupMsgsRes.DelGroupMsgsResIdl parsePartialFrom = DelGroupMsgsRes.DelGroupMsgsResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupMsgsResIdl = null;
                if (delGroupMsgsResIdl != null) {
                    mergeFrom(delGroupMsgsResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl2 = (DelGroupMsgsRes.DelGroupMsgsResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupMsgsResIdl = delGroupMsgsResIdl2;
                th = th3;
                if (delGroupMsgsResIdl != null) {
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

    public m a(DelGroupMsgsRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != DelGroupMsgsRes.DataRes.getDefaultInstance()) {
            this.c = DelGroupMsgsRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
