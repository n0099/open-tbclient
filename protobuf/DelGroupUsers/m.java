package protobuf.DelGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupUsers.DelGroupUsersRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<DelGroupUsersRes.DelGroupUsersResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupUsersRes.DataRes c = DelGroupUsersRes.DataRes.getDefaultInstance();

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
        this.c = DelGroupUsersRes.DataRes.getDefaultInstance();
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
    public DelGroupUsersRes.DelGroupUsersResIdl getDefaultInstanceForType() {
        return DelGroupUsersRes.DelGroupUsersResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupUsersRes.DelGroupUsersResIdl build() {
        DelGroupUsersRes.DelGroupUsersResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupUsersRes.DelGroupUsersResIdl buildPartial() {
        DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl = new DelGroupUsersRes.DelGroupUsersResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        delGroupUsersResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        delGroupUsersResIdl.data_ = this.c;
        delGroupUsersResIdl.bitField0_ = i2;
        return delGroupUsersResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl) {
        if (delGroupUsersResIdl != DelGroupUsersRes.DelGroupUsersResIdl.getDefaultInstance()) {
            if (delGroupUsersResIdl.hasError()) {
                a(delGroupUsersResIdl.getError());
            }
            if (delGroupUsersResIdl.hasData()) {
                a(delGroupUsersResIdl.getData());
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
        DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl;
        Throwable th;
        try {
            try {
                DelGroupUsersRes.DelGroupUsersResIdl parsePartialFrom = DelGroupUsersRes.DelGroupUsersResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupUsersResIdl = null;
                if (delGroupUsersResIdl != null) {
                    mergeFrom(delGroupUsersResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl2 = (DelGroupUsersRes.DelGroupUsersResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupUsersResIdl = delGroupUsersResIdl2;
                th = th3;
                if (delGroupUsersResIdl != null) {
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

    public m a(DelGroupUsersRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != DelGroupUsersRes.DataRes.getDefaultInstance()) {
            this.c = DelGroupUsersRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
