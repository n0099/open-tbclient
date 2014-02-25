package protobuf.QueryGroupDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryGroupDetailReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Object g = "";

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
        this.g = "";
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
    public QueryGroupDetailReq.DataReq getDefaultInstanceForType() {
        return QueryGroupDetailReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupDetailReq.DataReq build() {
        QueryGroupDetailReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupDetailReq.DataReq buildPartial() {
        QueryGroupDetailReq.DataReq dataReq = new QueryGroupDetailReq.DataReq(this, (QueryGroupDetailReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.smallHeight_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.smallWidth_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.bigHeight_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.bigWidth_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.from_ = this.g;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(QueryGroupDetailReq.DataReq dataReq) {
        Object obj;
        if (dataReq != QueryGroupDetailReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasGroupId()) {
                a(dataReq.getGroupId());
            }
            if (dataReq.hasSmallHeight()) {
                b(dataReq.getSmallHeight());
            }
            if (dataReq.hasSmallWidth()) {
                c(dataReq.getSmallWidth());
            }
            if (dataReq.hasBigHeight()) {
                d(dataReq.getBigHeight());
            }
            if (dataReq.hasBigWidth()) {
                e(dataReq.getBigWidth());
            }
            if (dataReq.hasFrom()) {
                this.a |= 32;
                obj = dataReq.from_;
                this.g = obj;
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
        QueryGroupDetailReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryGroupDetailReq.DataReq parsePartialFrom = QueryGroupDetailReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupDetailReq.DataReq dataReq2 = (QueryGroupDetailReq.DataReq) e.getUnfinishedMessage();
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

    public b a(String str) {
        if (str != null) {
            this.a |= 32;
            this.g = str;
        }
        return this;
    }
}
