package protobuf.QueryGroupsByUid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupsByUidRes.DataRes, h> implements i {
    private int a;
    private List<Im.GroupInfo> b = Collections.emptyList();
    private Im.GroupPermission c = Im.GroupPermission.getDefaultInstance();

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = Collections.emptyList();
        this.a &= -2;
        this.c = Im.GroupPermission.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupsByUidRes.DataRes getDefaultInstanceForType() {
        return QueryGroupsByUidRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupsByUidRes.DataRes build() {
        QueryGroupsByUidRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupsByUidRes.DataRes buildPartial() {
        QueryGroupsByUidRes.DataRes dataRes = new QueryGroupsByUidRes.DataRes(this, (QueryGroupsByUidRes.DataRes) null);
        int i = this.a;
        if ((this.a & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
            this.a &= -2;
        }
        dataRes.groups_ = this.b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        dataRes.groupPerm_ = this.c;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(QueryGroupsByUidRes.DataRes dataRes) {
        List list;
        List list2;
        List<Im.GroupInfo> list3;
        if (dataRes != QueryGroupsByUidRes.DataRes.getDefaultInstance()) {
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
            if (dataRes.hasGroupPerm()) {
                a(dataRes.getGroupPerm());
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupsByUidRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupsByUidRes.DataRes parsePartialFrom = QueryGroupsByUidRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupsByUidRes.DataRes dataRes2 = (QueryGroupsByUidRes.DataRes) e.getUnfinishedMessage();
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

    public h a(Im.GroupPermission groupPermission) {
        if ((this.a & 2) == 2 && this.c != Im.GroupPermission.getDefaultInstance()) {
            this.c = Im.GroupPermission.newBuilder(this.c).mergeFrom(groupPermission).buildPartial();
        } else {
            this.c = groupPermission;
        }
        this.a |= 2;
        return this;
    }
}
