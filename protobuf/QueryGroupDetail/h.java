package protobuf.QueryGroupDetail;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupDetail.QueryGroupDetailRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupDetailRes.DataRes, h> implements i {
    private int a;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();
    private List<Im.Photo> c = Collections.emptyList();
    private List<Im.UserInfo> d = Collections.emptyList();
    private List<Im.ActivityInfo> m = Collections.emptyList();

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
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        this.d = Collections.emptyList();
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        this.j = 0;
        this.a &= -257;
        this.k = 0;
        this.a &= -513;
        this.l = 0;
        this.a &= -1025;
        this.m = Collections.emptyList();
        this.a &= -2049;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryGroupDetailRes.DataRes getDefaultInstanceForType() {
        return QueryGroupDetailRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryGroupDetailRes.DataRes build() {
        QueryGroupDetailRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryGroupDetailRes.DataRes buildPartial() {
        QueryGroupDetailRes.DataRes dataRes = new QueryGroupDetailRes.DataRes(this, (QueryGroupDetailRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.group_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        dataRes.photo_ = this.c;
        if ((this.a & 4) == 4) {
            this.d = Collections.unmodifiableList(this.d);
            this.a &= -5;
        }
        dataRes.member_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 2;
        }
        dataRes.joinGroupNum_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 4;
        }
        dataRes.canJoinGroupNum_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 8;
        }
        dataRes.isJoin_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 16;
        }
        dataRes.isGroupManager_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 32;
        }
        dataRes.hideRecommendGroup_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 64;
        }
        dataRes.canCreateMember_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 128;
        }
        dataRes.alreadyCreateNum_ = this.k;
        if ((i & 1024) == 1024) {
            i2 |= 256;
        }
        dataRes.leftCreateNum_ = this.l;
        if ((this.a & 2048) == 2048) {
            this.m = Collections.unmodifiableList(this.m);
            this.a &= -2049;
        }
        dataRes.activity_ = this.m;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(QueryGroupDetailRes.DataRes dataRes) {
        List list;
        List list2;
        List list3;
        List list4;
        List<Im.ActivityInfo> list5;
        List list6;
        List<Im.UserInfo> list7;
        List list8;
        List<Im.Photo> list9;
        if (dataRes != QueryGroupDetailRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasGroup()) {
                a(dataRes.getGroup());
            }
            list = dataRes.photo_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list9 = dataRes.photo_;
                    this.c = list9;
                    this.a &= -3;
                } else {
                    i();
                    List<Im.Photo> list10 = this.c;
                    list8 = dataRes.photo_;
                    list10.addAll(list8);
                }
            }
            list2 = dataRes.member_;
            if (!list2.isEmpty()) {
                if (this.d.isEmpty()) {
                    list7 = dataRes.member_;
                    this.d = list7;
                    this.a &= -5;
                } else {
                    j();
                    List<Im.UserInfo> list11 = this.d;
                    list6 = dataRes.member_;
                    list11.addAll(list6);
                }
            }
            if (dataRes.hasJoinGroupNum()) {
                a(dataRes.getJoinGroupNum());
            }
            if (dataRes.hasCanJoinGroupNum()) {
                b(dataRes.getCanJoinGroupNum());
            }
            if (dataRes.hasIsJoin()) {
                c(dataRes.getIsJoin());
            }
            if (dataRes.hasIsGroupManager()) {
                d(dataRes.getIsGroupManager());
            }
            if (dataRes.hasHideRecommendGroup()) {
                e(dataRes.getHideRecommendGroup());
            }
            if (dataRes.hasCanCreateMember()) {
                f(dataRes.getCanCreateMember());
            }
            if (dataRes.hasAlreadyCreateNum()) {
                g(dataRes.getAlreadyCreateNum());
            }
            if (dataRes.hasLeftCreateNum()) {
                h(dataRes.getLeftCreateNum());
            }
            list3 = dataRes.activity_;
            if (!list3.isEmpty()) {
                if (this.m.isEmpty()) {
                    list5 = dataRes.activity_;
                    this.m = list5;
                    this.a &= -2049;
                } else {
                    k();
                    List<Im.ActivityInfo> list12 = this.m;
                    list4 = dataRes.activity_;
                    list12.addAll(list4);
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryGroupDetailRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupDetailRes.DataRes parsePartialFrom = QueryGroupDetailRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupDetailRes.DataRes dataRes2 = (QueryGroupDetailRes.DataRes) e.getUnfinishedMessage();
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

    public h a(Im.GroupInfo groupInfo) {
        if ((this.a & 1) == 1 && this.b != Im.GroupInfo.getDefaultInstance()) {
            this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(groupInfo).buildPartial();
        } else {
            this.b = groupInfo;
        }
        this.a |= 1;
        return this;
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new ArrayList(this.c);
            this.a |= 2;
        }
    }

    private void j() {
        if ((this.a & 4) != 4) {
            this.d = new ArrayList(this.d);
            this.a |= 4;
        }
    }

    public h a(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public h b(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public h c(int i) {
        this.a |= 32;
        this.g = i;
        return this;
    }

    public h d(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }

    public h e(int i) {
        this.a |= 128;
        this.i = i;
        return this;
    }

    public h f(int i) {
        this.a |= 256;
        this.j = i;
        return this;
    }

    public h g(int i) {
        this.a |= 512;
        this.k = i;
        return this;
    }

    public h h(int i) {
        this.a |= 1024;
        this.l = i;
        return this;
    }

    private void k() {
        if ((this.a & 2048) != 2048) {
            this.m = new ArrayList(this.m);
            this.a |= 2048;
        }
    }
}
