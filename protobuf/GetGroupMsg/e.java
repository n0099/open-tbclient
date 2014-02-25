package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetGroupMsg.GetGroupMsgReq;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<GetGroupMsgReq.GetGroupMsgReqIdl, e> implements f {
    private int a;
    private Object b = "";
    private GetGroupMsgReq.DataReq c = GetGroupMsgReq.DataReq.getDefaultInstance();

    private e() {
        g();
    }

    private void g() {
    }

    public static e h() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public e clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = GetGroupMsgReq.DataReq.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public e clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetGroupMsgReq.GetGroupMsgReqIdl getDefaultInstanceForType() {
        return GetGroupMsgReq.GetGroupMsgReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetGroupMsgReq.GetGroupMsgReqIdl build() {
        GetGroupMsgReq.GetGroupMsgReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetGroupMsgReq.GetGroupMsgReqIdl buildPartial() {
        GetGroupMsgReq.GetGroupMsgReqIdl getGroupMsgReqIdl = new GetGroupMsgReq.GetGroupMsgReqIdl(this, (GetGroupMsgReq.GetGroupMsgReqIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        getGroupMsgReqIdl.cuid_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        getGroupMsgReqIdl.data_ = this.c;
        getGroupMsgReqIdl.bitField0_ = i2;
        return getGroupMsgReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public e mergeFrom(GetGroupMsgReq.GetGroupMsgReqIdl getGroupMsgReqIdl) {
        Object obj;
        if (getGroupMsgReqIdl != GetGroupMsgReq.GetGroupMsgReqIdl.getDefaultInstance()) {
            if (getGroupMsgReqIdl.hasCuid()) {
                this.a |= 1;
                obj = getGroupMsgReqIdl.cuid_;
                this.b = obj;
            }
            if (getGroupMsgReqIdl.hasData()) {
                b(getGroupMsgReqIdl.getData());
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetGroupMsgReq.GetGroupMsgReqIdl getGroupMsgReqIdl;
        Throwable th;
        try {
            try {
                GetGroupMsgReq.GetGroupMsgReqIdl parsePartialFrom = GetGroupMsgReq.GetGroupMsgReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getGroupMsgReqIdl = null;
                if (getGroupMsgReqIdl != null) {
                    mergeFrom(getGroupMsgReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetGroupMsgReq.GetGroupMsgReqIdl getGroupMsgReqIdl2 = (GetGroupMsgReq.GetGroupMsgReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getGroupMsgReqIdl = getGroupMsgReqIdl2;
                th = th3;
                if (getGroupMsgReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public e a(String str) {
        if (str != null) {
            this.a |= 1;
            this.b = str;
        }
        return this;
    }

    public e a(GetGroupMsgReq.DataReq dataReq) {
        if (dataReq != null) {
            this.c = dataReq;
            this.a |= 2;
        }
        return this;
    }

    public e b(GetGroupMsgReq.DataReq dataReq) {
        if ((this.a & 2) == 2 && this.c != GetGroupMsgReq.DataReq.getDefaultInstance()) {
            this.c = GetGroupMsgReq.DataReq.newBuilder(this.c).mergeFrom(dataReq).buildPartial();
        } else {
            this.c = dataReq;
        }
        this.a |= 2;
        return this;
    }
}
