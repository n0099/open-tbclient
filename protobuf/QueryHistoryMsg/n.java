package protobuf.QueryHistoryMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.QueryHistoryMsg.QueryHistoryMsgRes;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<QueryHistoryMsgRes.QueryHistoryMsgResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private QueryHistoryMsgRes.DataRes c = QueryHistoryMsgRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryHistoryMsgRes.QueryHistoryMsgResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgRes.QueryHistoryMsgResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgRes.QueryHistoryMsgResIdl.getDefaultInstance();
    }

    private n() {
    }

    public static /* synthetic */ n a() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = QueryHistoryMsgRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public n clone() {
        return new n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHistoryMsgRes.QueryHistoryMsgResIdl buildPartial() {
        QueryHistoryMsgRes.QueryHistoryMsgResIdl queryHistoryMsgResIdl = new QueryHistoryMsgRes.QueryHistoryMsgResIdl(this, (QueryHistoryMsgRes.QueryHistoryMsgResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        queryHistoryMsgResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        queryHistoryMsgResIdl.data_ = this.c;
        queryHistoryMsgResIdl.bitField0_ = i2;
        return queryHistoryMsgResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final n mergeFrom(QueryHistoryMsgRes.QueryHistoryMsgResIdl queryHistoryMsgResIdl) {
        if (queryHistoryMsgResIdl != QueryHistoryMsgRes.QueryHistoryMsgResIdl.getDefaultInstance()) {
            if (queryHistoryMsgResIdl.hasError()) {
                Im.Error error = queryHistoryMsgResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (queryHistoryMsgResIdl.hasData()) {
                QueryHistoryMsgRes.DataRes data = queryHistoryMsgResIdl.getData();
                if ((this.a & 2) != 2 || this.c == QueryHistoryMsgRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = QueryHistoryMsgRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
    public n mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryHistoryMsgRes.QueryHistoryMsgResIdl queryHistoryMsgResIdl;
        Throwable th;
        try {
            try {
                QueryHistoryMsgRes.QueryHistoryMsgResIdl parsePartialFrom = QueryHistoryMsgRes.QueryHistoryMsgResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                queryHistoryMsgResIdl = null;
                if (queryHistoryMsgResIdl != null) {
                    mergeFrom(queryHistoryMsgResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHistoryMsgRes.QueryHistoryMsgResIdl queryHistoryMsgResIdl2 = (QueryHistoryMsgRes.QueryHistoryMsgResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                queryHistoryMsgResIdl = queryHistoryMsgResIdl2;
                th = th3;
                if (queryHistoryMsgResIdl != null) {
                }
                throw th;
            }
        }
    }
}
