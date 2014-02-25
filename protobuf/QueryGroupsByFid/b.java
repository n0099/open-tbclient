package protobuf.QueryGroupsByFid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryGroupsByFidReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

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
        this.f = 0;
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupsByFidReq.DataReq getDefaultInstanceForType() {
        return QueryGroupsByFidReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByFidReq.DataReq build() {
        QueryGroupsByFidReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByFidReq.DataReq buildPartial() {
        QueryGroupsByFidReq.DataReq dataReq = new QueryGroupsByFidReq.DataReq(this, (QueryGroupsByFidReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.forumId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.type_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.offset_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.rn_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.height_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.width_ = this.g;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(QueryGroupsByFidReq.DataReq dataReq) {
        if (dataReq != QueryGroupsByFidReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasForumId()) {
                a(dataReq.getForumId());
            }
            if (dataReq.hasType()) {
                b(dataReq.getType());
            }
            if (dataReq.hasOffset()) {
                c(dataReq.getOffset());
            }
            if (dataReq.hasRn()) {
                d(dataReq.getRn());
            }
            if (dataReq.hasHeight()) {
                e(dataReq.getHeight());
            }
            if (dataReq.hasWidth()) {
                f(dataReq.getWidth());
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
        QueryGroupsByFidReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryGroupsByFidReq.DataReq parsePartialFrom = QueryGroupsByFidReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupsByFidReq.DataReq dataReq2 = (QueryGroupsByFidReq.DataReq) e.getUnfinishedMessage();
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

    public b e(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public b f(int i) {
        this.a |= 32;
        this.g = i;
        return this;
    }
}
