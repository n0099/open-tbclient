package protobuf.QueryUserInfos;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryUserInfosRes.DataRes, h> implements i {
    private int a;
    private long b;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    private Object f = "";
    private Object g = "";
    private List<QueryUserInfosRes.IconInfo> p = Collections.emptyList();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryUserInfosRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryUserInfosRes.DataRes.getDefaultInstance();
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
        this.b = 0L;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        this.g = "";
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
        this.m = 0;
        this.a &= -2049;
        this.n = 0;
        this.a &= -4097;
        this.o = 0;
        this.a &= -8193;
        this.p = Collections.emptyList();
        this.a &= -16385;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryUserInfosRes.DataRes buildPartial() {
        QueryUserInfosRes.DataRes dataRes = new QueryUserInfosRes.DataRes(this, (QueryUserInfosRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.id_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.name_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.nameShow_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataRes.portrait_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataRes.portraith_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataRes.intro_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataRes.sex_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        dataRes.hasConcerned_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        dataRes.isBlacklist_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        dataRes.meizhiLevel_ = this.k;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        dataRes.userType_ = this.l;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        dataRes.isCoreuser_ = this.m;
        if ((i & 4096) == 4096) {
            i2 |= 4096;
        }
        dataRes.superboy_ = this.n;
        if ((i & 8192) == 8192) {
            i2 |= 8192;
        }
        dataRes.isInterestman_ = this.o;
        if ((this.a & 16384) == 16384) {
            this.p = Collections.unmodifiableList(this.p);
            this.a &= -16385;
        }
        dataRes.iconInfo_ = this.p;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(QueryUserInfosRes.DataRes dataRes) {
        List list;
        List list2;
        List<QueryUserInfosRes.IconInfo> list3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (dataRes != QueryUserInfosRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasId()) {
                long id = dataRes.getId();
                this.a |= 1;
                this.b = id;
            }
            if (dataRes.hasName()) {
                this.a |= 2;
                obj5 = dataRes.name_;
                this.c = obj5;
            }
            if (dataRes.hasNameShow()) {
                this.a |= 4;
                obj4 = dataRes.nameShow_;
                this.d = obj4;
            }
            if (dataRes.hasPortrait()) {
                this.a |= 8;
                obj3 = dataRes.portrait_;
                this.e = obj3;
            }
            if (dataRes.hasPortraith()) {
                this.a |= 16;
                obj2 = dataRes.portraith_;
                this.f = obj2;
            }
            if (dataRes.hasIntro()) {
                this.a |= 32;
                obj = dataRes.intro_;
                this.g = obj;
            }
            if (dataRes.hasSex()) {
                int sex = dataRes.getSex();
                this.a |= 64;
                this.h = sex;
            }
            if (dataRes.hasHasConcerned()) {
                int hasConcerned = dataRes.getHasConcerned();
                this.a |= 128;
                this.i = hasConcerned;
            }
            if (dataRes.hasIsBlacklist()) {
                int isBlacklist = dataRes.getIsBlacklist();
                this.a |= 256;
                this.j = isBlacklist;
            }
            if (dataRes.hasMeizhiLevel()) {
                int meizhiLevel = dataRes.getMeizhiLevel();
                this.a |= 512;
                this.k = meizhiLevel;
            }
            if (dataRes.hasUserType()) {
                int userType = dataRes.getUserType();
                this.a |= 1024;
                this.l = userType;
            }
            if (dataRes.hasIsCoreuser()) {
                int isCoreuser = dataRes.getIsCoreuser();
                this.a |= 2048;
                this.m = isCoreuser;
            }
            if (dataRes.hasSuperboy()) {
                int superboy = dataRes.getSuperboy();
                this.a |= 4096;
                this.n = superboy;
            }
            if (dataRes.hasIsInterestman()) {
                int isInterestman = dataRes.getIsInterestman();
                this.a |= 8192;
                this.o = isInterestman;
            }
            list = dataRes.iconInfo_;
            if (!list.isEmpty()) {
                if (this.p.isEmpty()) {
                    list3 = dataRes.iconInfo_;
                    this.p = list3;
                    this.a &= -16385;
                } else {
                    if ((this.a & 16384) != 16384) {
                        this.p = new ArrayList(this.p);
                        this.a |= 16384;
                    }
                    List<QueryUserInfosRes.IconInfo> list4 = this.p;
                    list2 = dataRes.iconInfo_;
                    list4.addAll(list2);
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
        QueryUserInfosRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryUserInfosRes.DataRes parsePartialFrom = QueryUserInfosRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryUserInfosRes.DataRes dataRes2 = (QueryUserInfosRes.DataRes) e.getUnfinishedMessage();
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
