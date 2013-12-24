package protobuf.DelGroupMsgs;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.DelGroupMsgs.DelGroupMsgsReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<DelGroupMsgsReq.DelGroupMsgsReqIdl, f> implements g {
    private int a;
    private DelGroupMsgsReq.DataReq b = DelGroupMsgsReq.DataReq.getDefaultInstance();

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
        this.b = DelGroupMsgsReq.DataReq.getDefaultInstance();
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
    public DelGroupMsgsReq.DelGroupMsgsReqIdl getDefaultInstanceForType() {
        return DelGroupMsgsReq.DelGroupMsgsReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupMsgsReq.DelGroupMsgsReqIdl build() {
        DelGroupMsgsReq.DelGroupMsgsReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public DelGroupMsgsReq.DelGroupMsgsReqIdl buildPartial() {
        DelGroupMsgsReq.DelGroupMsgsReqIdl delGroupMsgsReqIdl = new DelGroupMsgsReq.DelGroupMsgsReqIdl(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        delGroupMsgsReqIdl.data_ = this.b;
        delGroupMsgsReqIdl.bitField0_ = i;
        return delGroupMsgsReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(DelGroupMsgsReq.DelGroupMsgsReqIdl delGroupMsgsReqIdl) {
        if (delGroupMsgsReqIdl != DelGroupMsgsReq.DelGroupMsgsReqIdl.getDefaultInstance() && delGroupMsgsReqIdl.hasData()) {
            b(delGroupMsgsReqIdl.getData());
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
        DelGroupMsgsReq.DelGroupMsgsReqIdl delGroupMsgsReqIdl;
        Throwable th;
        try {
            try {
                DelGroupMsgsReq.DelGroupMsgsReqIdl parsePartialFrom = DelGroupMsgsReq.DelGroupMsgsReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupMsgsReqIdl = null;
                if (delGroupMsgsReqIdl != null) {
                    mergeFrom(delGroupMsgsReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupMsgsReq.DelGroupMsgsReqIdl delGroupMsgsReqIdl2 = (DelGroupMsgsReq.DelGroupMsgsReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupMsgsReqIdl = delGroupMsgsReqIdl2;
                th = th3;
                if (delGroupMsgsReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public f a(DelGroupMsgsReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public f b(DelGroupMsgsReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != DelGroupMsgsReq.DataReq.getDefaultInstance()) {
            this.b = DelGroupMsgsReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
