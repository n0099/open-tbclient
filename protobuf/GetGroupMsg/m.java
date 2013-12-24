package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m extends GeneratedMessageLite.Builder<GetGroupMsgRes.GetGroupMsgResIdl, m> implements n {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private GetGroupMsgRes.DataRes c = GetGroupMsgRes.DataRes.getDefaultInstance();

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
        this.c = GetGroupMsgRes.DataRes.getDefaultInstance();
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
    public GetGroupMsgRes.GetGroupMsgResIdl getDefaultInstanceForType() {
        return GetGroupMsgRes.GetGroupMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetGroupMsgRes.GetGroupMsgResIdl build() {
        GetGroupMsgRes.GetGroupMsgResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetGroupMsgRes.GetGroupMsgResIdl buildPartial() {
        GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl = new GetGroupMsgRes.GetGroupMsgResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        getGroupMsgResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        getGroupMsgResIdl.data_ = this.c;
        getGroupMsgResIdl.bitField0_ = i2;
        return getGroupMsgResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public m mergeFrom(GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl) {
        if (getGroupMsgResIdl != GetGroupMsgRes.GetGroupMsgResIdl.getDefaultInstance()) {
            if (getGroupMsgResIdl.hasError()) {
                a(getGroupMsgResIdl.getError());
            }
            if (getGroupMsgResIdl.hasData()) {
                a(getGroupMsgResIdl.getData());
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
        GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl;
        Throwable th;
        try {
            try {
                GetGroupMsgRes.GetGroupMsgResIdl parsePartialFrom = GetGroupMsgRes.GetGroupMsgResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                getGroupMsgResIdl = null;
                if (getGroupMsgResIdl != null) {
                    mergeFrom(getGroupMsgResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl2 = (GetGroupMsgRes.GetGroupMsgResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                getGroupMsgResIdl = getGroupMsgResIdl2;
                th = th3;
                if (getGroupMsgResIdl != null) {
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

    public m a(GetGroupMsgRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != GetGroupMsgRes.DataRes.getDefaultInstance()) {
            this.c = GetGroupMsgRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
