package protobuf.DelGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupUsers.DelGroupUsersReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<DelGroupUsersReq.DelGroupUsersReqIdl, f> implements g {
    private int a;
    private DelGroupUsersReq.DataReq b = DelGroupUsersReq.DataReq.getDefaultInstance();

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = DelGroupUsersReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public DelGroupUsersReq.DelGroupUsersReqIdl getDefaultInstanceForType() {
        return DelGroupUsersReq.DelGroupUsersReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupUsersReq.DelGroupUsersReqIdl build() {
        DelGroupUsersReq.DelGroupUsersReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupUsersReq.DelGroupUsersReqIdl buildPartial() {
        DelGroupUsersReq.DelGroupUsersReqIdl delGroupUsersReqIdl = new DelGroupUsersReq.DelGroupUsersReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        delGroupUsersReqIdl.data_ = this.b;
        delGroupUsersReqIdl.bitField0_ = i;
        return delGroupUsersReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(DelGroupUsersReq.DelGroupUsersReqIdl delGroupUsersReqIdl) {
        if (delGroupUsersReqIdl != DelGroupUsersReq.DelGroupUsersReqIdl.getDefaultInstance() && delGroupUsersReqIdl.hasData()) {
            b(delGroupUsersReqIdl.getData());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DelGroupUsersReq.DelGroupUsersReqIdl delGroupUsersReqIdl;
        Throwable th;
        try {
            try {
                DelGroupUsersReq.DelGroupUsersReqIdl parsePartialFrom = DelGroupUsersReq.DelGroupUsersReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupUsersReqIdl = null;
                if (delGroupUsersReqIdl != null) {
                    mergeFrom(delGroupUsersReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupUsersReq.DelGroupUsersReqIdl delGroupUsersReqIdl2 = (DelGroupUsersReq.DelGroupUsersReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupUsersReqIdl = delGroupUsersReqIdl2;
                th = th3;
                if (delGroupUsersReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(DelGroupUsersReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(DelGroupUsersReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != DelGroupUsersReq.DataReq.getDefaultInstance()) {
            this.b = DelGroupUsersReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
