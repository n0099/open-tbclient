package protobuf.QueryGroupUserList;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryGroupUserListReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    private b() {
        g();
    }

    private void g() {
    }

    public static b h() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupUserListReq.DataReq getDefaultInstanceForType() {
        return QueryGroupUserListReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupUserListReq.DataReq build() {
        QueryGroupUserListReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupUserListReq.DataReq buildPartial() {
        QueryGroupUserListReq.DataReq dataReq = new QueryGroupUserListReq.DataReq(this, (QueryGroupUserListReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.offset_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.rn_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.orderType_ = this.e;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(QueryGroupUserListReq.DataReq dataReq) {
        if (dataReq != QueryGroupUserListReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasOffset()) {
                b(dataReq.getOffset());
            }
            if (dataReq.hasRn()) {
                c(dataReq.getRn());
            }
            if (dataReq.hasOrderType()) {
                d(dataReq.getOrderType());
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupUserListReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryGroupUserListReq.DataReq parsePartialFrom = QueryGroupUserListReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupUserListReq.DataReq dataReq2 = (QueryGroupUserListReq.DataReq) e.getUnfinishedMessage();
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

    public b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public b b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public b c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public b d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
