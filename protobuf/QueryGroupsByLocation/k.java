package protobuf.QueryGroupsByLocation;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryGroupsByLocationRes.DataRes, k> implements l {
    private int a;
    private List<QueryGroupsByLocationRes.Business> b = Collections.emptyList();
    private int c;
    private int d;
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupsByLocationRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByLocationRes.DataRes.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clear() {
        super.clear();
        this.b = Collections.emptyList();
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
    /* renamed from: d */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupsByLocationRes.DataRes buildPartial() {
        QueryGroupsByLocationRes.DataRes dataRes = new QueryGroupsByLocationRes.DataRes(this, (QueryGroupsByLocationRes.DataRes) null);
        int i = this.a;
        if ((this.a & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
            this.a &= -2;
        }
        dataRes.groups_ = this.b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        dataRes.geo_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        dataRes.offset_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        dataRes.hasMore_ = this.e;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryGroupsByLocationRes.DataRes dataRes) {
        List list;
        List list2;
        List<QueryGroupsByLocationRes.Business> list3;
        if (dataRes != QueryGroupsByLocationRes.DataRes.getDefaultInstance()) {
            list = dataRes.groups_;
            if (!list.isEmpty()) {
                if (this.b.isEmpty()) {
                    list3 = dataRes.groups_;
                    this.b = list3;
                    this.a &= -2;
                } else {
                    if ((this.a & 1) != 1) {
                        this.b = new ArrayList(this.b);
                        this.a |= 1;
                    }
                    List<QueryGroupsByLocationRes.Business> list4 = this.b;
                    list2 = dataRes.groups_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasGeo()) {
                int geo = dataRes.getGeo();
                this.a |= 2;
                this.c = geo;
            }
            if (dataRes.hasOffset()) {
                int offset = dataRes.getOffset();
                this.a |= 4;
                this.d = offset;
            }
            if (dataRes.hasHasMore()) {
                int hasMore = dataRes.getHasMore();
                this.a |= 8;
                this.e = hasMore;
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
        QueryGroupsByLocationRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupsByLocationRes.DataRes parsePartialFrom = QueryGroupsByLocationRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupsByLocationRes.DataRes dataRes2 = (QueryGroupsByLocationRes.DataRes) e.getUnfinishedMessage();
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
}
