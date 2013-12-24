package protobuf.QueryHotGroups;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<QueryHotGroupsReq.DataReq, c> implements d {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
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
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryHotGroupsReq.DataReq getDefaultInstanceForType() {
        return QueryHotGroupsReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHotGroupsReq.DataReq build() {
        QueryHotGroupsReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHotGroupsReq.DataReq buildPartial() {
        QueryHotGroupsReq.DataReq dataReq = new QueryHotGroupsReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.offset_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.rn_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.height_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.width_ = this.e;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public c mergeFrom(QueryHotGroupsReq.DataReq dataReq) {
        if (dataReq != QueryHotGroupsReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasOffset()) {
                a(dataReq.getOffset());
            }
            if (dataReq.hasRn()) {
                b(dataReq.getRn());
            }
            if (dataReq.hasHeight()) {
                c(dataReq.getHeight());
            }
            if (dataReq.hasWidth()) {
                d(dataReq.getWidth());
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryHotGroupsReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryHotGroupsReq.DataReq parsePartialFrom = QueryHotGroupsReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryHotGroupsReq.DataReq dataReq2 = (QueryHotGroupsReq.DataReq) e.getUnfinishedMessage();
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

    public c a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public c b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public c c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public c d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
