package protobuf.QueryUserPermission;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.QueryUserPermission.QueryUserPermissionRes;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<QueryUserPermissionRes.DataRes, j> implements k {
    private int a;
    private Im.GroupPermission b = Im.GroupPermission.getDefaultInstance();

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
        this.b = Im.GroupPermission.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryUserPermissionRes.DataRes getDefaultInstanceForType() {
        return QueryUserPermissionRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryUserPermissionRes.DataRes build() {
        QueryUserPermissionRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryUserPermissionRes.DataRes buildPartial() {
        QueryUserPermissionRes.DataRes dataRes = new QueryUserPermissionRes.DataRes(this);
        int i = (this.a & 1) != 1 ? 0 : 1;
        dataRes.groupPerm_ = this.b;
        dataRes.bitField0_ = i;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(QueryUserPermissionRes.DataRes dataRes) {
        if (dataRes != QueryUserPermissionRes.DataRes.getDefaultInstance() && dataRes.hasGroupPerm()) {
            a(dataRes.getGroupPerm());
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
        QueryUserPermissionRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryUserPermissionRes.DataRes parsePartialFrom = QueryUserPermissionRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryUserPermissionRes.DataRes dataRes2 = (QueryUserPermissionRes.DataRes) e.getUnfinishedMessage();
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

    public j a(Im.GroupPermission groupPermission) {
        if ((this.a & 1) == 1 && this.b != Im.GroupPermission.getDefaultInstance()) {
            this.b = Im.GroupPermission.newBuilder(this.b).mergeFrom(groupPermission).buildPartial();
        } else {
            this.b = groupPermission;
        }
        this.a |= 1;
        return this;
    }
}
