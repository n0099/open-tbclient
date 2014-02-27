package protobuf.QueryGroupUserList;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupUserList.QueryGroupUserListRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupUserListRes.DataRes, h> implements i {
    private int a;
    private int b;
    private List<Im.UserInfo> c = Collections.emptyList();
    private Im.UserPermission d = Im.UserPermission.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupUserListRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupUserListRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupUserListRes.DataRes.getDefaultInstance();
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
        this.b = 0;
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        this.d = Im.UserPermission.getDefaultInstance();
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupUserListRes.DataRes buildPartial() {
        QueryGroupUserListRes.DataRes dataRes = new QueryGroupUserListRes.DataRes(this, (QueryGroupUserListRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.memberNum_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        dataRes.userList_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        dataRes.permission_ = this.d;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(QueryGroupUserListRes.DataRes dataRes) {
        List list;
        List list2;
        List<Im.UserInfo> list3;
        if (dataRes != QueryGroupUserListRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasMemberNum()) {
                int memberNum = dataRes.getMemberNum();
                this.a |= 1;
                this.b = memberNum;
            }
            list = dataRes.userList_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list3 = dataRes.userList_;
                    this.c = list3;
                    this.a &= -3;
                } else {
                    if ((this.a & 2) != 2) {
                        this.c = new ArrayList(this.c);
                        this.a |= 2;
                    }
                    List<Im.UserInfo> list4 = this.c;
                    list2 = dataRes.userList_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasPermission()) {
                Im.UserPermission permission = dataRes.getPermission();
                if ((this.a & 4) != 4 || this.d == Im.UserPermission.getDefaultInstance()) {
                    this.d = permission;
                } else {
                    this.d = Im.UserPermission.newBuilder(this.d).mergeFrom(permission).buildPartial();
                }
                this.a |= 4;
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
        QueryGroupUserListRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupUserListRes.DataRes parsePartialFrom = QueryGroupUserListRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupUserListRes.DataRes dataRes2 = (QueryGroupUserListRes.DataRes) e.getUnfinishedMessage();
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
