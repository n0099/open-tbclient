package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<GetGroupMsgRes.GetGroupMsgResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private GetGroupMsgRes.DataRes c = GetGroupMsgRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        GetGroupMsgRes.GetGroupMsgResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return GetGroupMsgRes.GetGroupMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return GetGroupMsgRes.GetGroupMsgResIdl.getDefaultInstance();
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
        this.c = GetGroupMsgRes.DataRes.getDefaultInstance();
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
    public GetGroupMsgRes.GetGroupMsgResIdl buildPartial() {
        GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl = new GetGroupMsgRes.GetGroupMsgResIdl(this, (GetGroupMsgRes.GetGroupMsgResIdl) null);
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
    public final k mergeFrom(GetGroupMsgRes.GetGroupMsgResIdl getGroupMsgResIdl) {
        if (getGroupMsgResIdl != GetGroupMsgRes.GetGroupMsgResIdl.getDefaultInstance()) {
            if (getGroupMsgResIdl.hasError()) {
                Im.Error error = getGroupMsgResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (getGroupMsgResIdl.hasData()) {
                GetGroupMsgRes.DataRes data = getGroupMsgResIdl.getData();
                if ((this.a & 2) != 2 || this.c == GetGroupMsgRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = GetGroupMsgRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
