package protobuf.QueryGroupsByFid;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupsByFidRes.DataRes, h> implements i {
    private int a;
    private List<Im.GroupInfo> b = Collections.emptyList();
    private Im.GroupPermission c = Im.GroupPermission.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupsByFidRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupsByFidRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupsByFidRes.DataRes.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h b() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clear() {
        super.clear();
        this.b = Collections.emptyList();
        this.a &= -2;
        this.c = Im.GroupPermission.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupsByFidRes.DataRes buildPartial() {
        QueryGroupsByFidRes.DataRes dataRes = new QueryGroupsByFidRes.DataRes(this, (QueryGroupsByFidRes.DataRes) null);
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
    public final h mergeFrom(QueryGroupsByFidRes.DataRes dataRes) {
        List list;
        List list2;
        List<Im.GroupInfo> list3;
        if (dataRes != QueryGroupsByFidRes.DataRes.getDefaultInstance()) {
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
                    List<Im.GroupInfo> list4 = this.b;
                    list2 = dataRes.groups_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasGroupPerm()) {
                Im.GroupPermission groupPerm = dataRes.getGroupPerm();
                if ((this.a & 2) != 2 || this.c == Im.GroupPermission.getDefaultInstance()) {
                    this.c = groupPerm;
                } else {
                    this.c = Im.GroupPermission.newBuilder(this.c).mergeFrom(groupPerm).buildPartial();
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupsByFidRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupsByFidRes.DataRes parsePartialFrom = QueryGroupsByFidRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupsByFidRes.DataRes dataRes2 = (QueryGroupsByFidRes.DataRes) e.getUnfinishedMessage();
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
