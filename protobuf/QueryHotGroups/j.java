package protobuf.QueryHotGroups;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryHotGroupsRes.DataRes, j> implements k {
    private int a;
    private List<Im.GroupInfo> b = Collections.emptyList();
    private int c;

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
        this.b = Collections.emptyList();
        this.a &= -2;
        this.c = 0;
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
    public QueryHotGroupsRes.DataRes getDefaultInstanceForType() {
        return QueryHotGroupsRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHotGroupsRes.DataRes build() {
        QueryHotGroupsRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryHotGroupsRes.DataRes buildPartial() {
        QueryHotGroupsRes.DataRes dataRes = new QueryHotGroupsRes.DataRes(this);
        int i = this.a;
        if ((this.a & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
            this.a &= -2;
        }
        dataRes.groups_ = this.b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        dataRes.hasMore_ = this.c;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryHotGroupsRes.DataRes dataRes) {
        List list;
        List list2;
        List<Im.GroupInfo> list3;
        if (dataRes != QueryHotGroupsRes.DataRes.getDefaultInstance()) {
            list = dataRes.groups_;
            if (!list.isEmpty()) {
                if (this.b.isEmpty()) {
                    list3 = dataRes.groups_;
                    this.b = list3;
                    this.a &= -2;
                } else {
                    i();
                    List<Im.GroupInfo> list4 = this.b;
                    list2 = dataRes.groups_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasHasMore()) {
                a(dataRes.getHasMore());
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
        QueryHotGroupsRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryHotGroupsRes.DataRes parsePartialFrom = QueryHotGroupsRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryHotGroupsRes.DataRes dataRes2 = (QueryHotGroupsRes.DataRes) e.getUnfinishedMessage();
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
        if ((this.a & 1) != 1) {
            this.b = new ArrayList(this.b);
            this.a |= 1;
        }
    }

    public j a(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }
}
