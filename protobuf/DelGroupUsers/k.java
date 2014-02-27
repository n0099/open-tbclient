package protobuf.DelGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroupUsers.DelGroupUsersRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<DelGroupUsersRes.DelGroupUsersResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupUsersRes.DataRes c = DelGroupUsersRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        DelGroupUsersRes.DelGroupUsersResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupUsersRes.DelGroupUsersResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupUsersRes.DelGroupUsersResIdl.getDefaultInstance();
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
        this.c = DelGroupUsersRes.DataRes.getDefaultInstance();
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
    public DelGroupUsersRes.DelGroupUsersResIdl buildPartial() {
        DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl = new DelGroupUsersRes.DelGroupUsersResIdl(this, (DelGroupUsersRes.DelGroupUsersResIdl) null);
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
    public final k mergeFrom(DelGroupUsersRes.DelGroupUsersResIdl delGroupUsersResIdl) {
        if (delGroupUsersResIdl != DelGroupUsersRes.DelGroupUsersResIdl.getDefaultInstance()) {
            if (delGroupUsersResIdl.hasError()) {
                Im.Error error = delGroupUsersResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (delGroupUsersResIdl.hasData()) {
                DelGroupUsersRes.DataRes data = delGroupUsersResIdl.getData();
                if ((this.a & 2) != 2 || this.c == DelGroupUsersRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = DelGroupUsersRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
