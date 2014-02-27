package protobuf.QueryChatroomInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryChatroomInfo.QueryChatroomInfoRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryChatroomInfoRes.QueryChatroomInfoResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryChatroomInfoRes.DataRes c = QueryChatroomInfoRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryChatroomInfoRes.QueryChatroomInfoResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryChatroomInfoRes.QueryChatroomInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryChatroomInfoRes.QueryChatroomInfoResIdl.getDefaultInstance();
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
        this.c = QueryChatroomInfoRes.DataRes.getDefaultInstance();
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
    public QueryChatroomInfoRes.QueryChatroomInfoResIdl buildPartial() {
        QueryChatroomInfoRes.QueryChatroomInfoResIdl queryChatroomInfoResIdl = new QueryChatroomInfoRes.QueryChatroomInfoResIdl(this, (QueryChatroomInfoRes.QueryChatroomInfoResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryChatroomInfoResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryChatroomInfoResIdl.data_ = this.c;
        queryChatroomInfoResIdl.bitField0_ = i2;
        return queryChatroomInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryChatroomInfoRes.QueryChatroomInfoResIdl queryChatroomInfoResIdl) {
        if (queryChatroomInfoResIdl != QueryChatroomInfoRes.QueryChatroomInfoResIdl.getDefaultInstance()) {
            if (queryChatroomInfoResIdl.hasError()) {
                Im.Error error = queryChatroomInfoResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryChatroomInfoResIdl.hasData()) {
                QueryChatroomInfoRes.DataRes data = queryChatroomInfoResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryChatroomInfoRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryChatroomInfoRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        QueryChatroomInfoRes.QueryChatroomInfoResIdl queryChatroomInfoResIdl;
        Throwable th;
        try {
            try {
                QueryChatroomInfoRes.QueryChatroomInfoResIdl parsePartialFrom = QueryChatroomInfoRes.QueryChatroomInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryChatroomInfoResIdl = null;
                if (queryChatroomInfoResIdl != null) {
                    mergeFrom(queryChatroomInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryChatroomInfoRes.QueryChatroomInfoResIdl queryChatroomInfoResIdl2 = (QueryChatroomInfoRes.QueryChatroomInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryChatroomInfoResIdl = queryChatroomInfoResIdl2;
                th = th3;
                if (queryChatroomInfoResIdl != null) {
                }
                throw th;
            }
        }
    }
}
