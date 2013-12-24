package protobuf.QueryGroupLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import protobuf.QueryGroupLocation.QueryGroupLocationRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryGroupLocationRes.DataRes, j> implements k {
    private int a;
    private Object b = "";
    private LazyStringList c = LazyStringArrayList.EMPTY;

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = LazyStringArrayList.EMPTY;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupLocationRes.DataRes getDefaultInstanceForType() {
        return QueryGroupLocationRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupLocationRes.DataRes build() {
        QueryGroupLocationRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupLocationRes.DataRes buildPartial() {
        QueryGroupLocationRes.DataRes dataRes = new QueryGroupLocationRes.DataRes(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.position_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = new UnmodifiableLazyStringList(this.c);
            this.a &= -3;
        }
        dataRes.business_ = this.c;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryGroupLocationRes.DataRes dataRes) {
        LazyStringList lazyStringList;
        LazyStringList lazyStringList2;
        LazyStringList lazyStringList3;
        Object obj;
        if (dataRes != QueryGroupLocationRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasPosition()) {
                this.a |= 1;
                obj = dataRes.position_;
                this.b = obj;
            }
            lazyStringList = dataRes.business_;
            if (!lazyStringList.isEmpty()) {
                if (this.c.isEmpty()) {
                    lazyStringList3 = dataRes.business_;
                    this.c = lazyStringList3;
                    this.a &= -3;
                } else {
                    i();
                    LazyStringList lazyStringList4 = this.c;
                    lazyStringList2 = dataRes.business_;
                    lazyStringList4.addAll(lazyStringList2);
                }
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupLocationRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupLocationRes.DataRes parsePartialFrom = QueryGroupLocationRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryGroupLocationRes.DataRes dataRes2 = (QueryGroupLocationRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new LazyStringArrayList(this.c);
            this.a |= 2;
        }
    }
}
