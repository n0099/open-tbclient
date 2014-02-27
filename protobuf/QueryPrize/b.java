package protobuf.QueryPrize;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryPrizeReq.DataReq, b> implements c {
    private int a;
    private int b;

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryPrizeReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryPrizeReq.DataReq.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b c() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryPrizeReq.DataReq build() {
        QueryPrizeReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final QueryPrizeReq.DataReq buildPartial() {
        QueryPrizeReq.DataReq dataReq = new QueryPrizeReq.DataReq(this, (QueryPrizeReq.DataReq) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        dataReq.bitField0_ = i;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(QueryPrizeReq.DataReq dataReq) {
        if (dataReq != QueryPrizeReq.DataReq.getDefaultInstance() && dataReq.hasGroupId()) {
            a(dataReq.getGroupId());
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryPrizeReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryPrizeReq.DataReq parsePartialFrom = QueryPrizeReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataReq = null;
                if (dataReq != null) {
                    mergeFrom(dataReq);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryPrizeReq.DataReq dataReq2 = (QueryPrizeReq.DataReq) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataReq = dataReq2;
                th = th3;
                if (dataReq != null) {
                }
                throw th;
            }
        }
    }

    public final b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }
}
