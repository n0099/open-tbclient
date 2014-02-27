package protobuf.QueryGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryGroupActivity.QueryGroupActivityRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryGroupActivityRes.DataRes, h> implements i {
    private int a;
    private int b;
    private int c;
    private int d;
    private long f;
    private int i;
    private Object e = "";
    private Object g = "";
    private Object h = "";
    private Object j = "";
    private Object k = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryGroupActivityRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryGroupActivityRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryGroupActivityRes.DataRes.getDefaultInstance();
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
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = 0L;
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = "";
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        this.j = "";
        this.a &= -257;
        this.k = "";
        this.a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryGroupActivityRes.DataRes buildPartial() {
        QueryGroupActivityRes.DataRes dataRes = new QueryGroupActivityRes.DataRes(this, (QueryGroupActivityRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.activityId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.groupId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.userId_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataRes.gActivityTitle_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataRes.gActivityTime_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataRes.gActivityContent_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataRes.gActivityArea_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        dataRes.isEnd_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        dataRes.activityPortrait_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        dataRes.userName_ = this.k;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(QueryGroupActivityRes.DataRes dataRes) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (dataRes != QueryGroupActivityRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasActivityId()) {
                int activityId = dataRes.getActivityId();
                this.a |= 1;
                this.b = activityId;
            }
            if (dataRes.hasGroupId()) {
                int groupId = dataRes.getGroupId();
                this.a |= 2;
                this.c = groupId;
            }
            if (dataRes.hasUserId()) {
                int userId = dataRes.getUserId();
                this.a |= 4;
                this.d = userId;
            }
            if (dataRes.hasGActivityTitle()) {
                this.a |= 8;
                obj5 = dataRes.gActivityTitle_;
                this.e = obj5;
            }
            if (dataRes.hasGActivityTime()) {
                long gActivityTime = dataRes.getGActivityTime();
                this.a |= 16;
                this.f = gActivityTime;
            }
            if (dataRes.hasGActivityContent()) {
                this.a |= 32;
                obj4 = dataRes.gActivityContent_;
                this.g = obj4;
            }
            if (dataRes.hasGActivityArea()) {
                this.a |= 64;
                obj3 = dataRes.gActivityArea_;
                this.h = obj3;
            }
            if (dataRes.hasIsEnd()) {
                int isEnd = dataRes.getIsEnd();
                this.a |= 128;
                this.i = isEnd;
            }
            if (dataRes.hasActivityPortrait()) {
                this.a |= 256;
                obj2 = dataRes.activityPortrait_;
                this.j = obj2;
            }
            if (dataRes.hasUserName()) {
                this.a |= 512;
                obj = dataRes.userName_;
                this.k = obj;
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
        QueryGroupActivityRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryGroupActivityRes.DataRes parsePartialFrom = QueryGroupActivityRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryGroupActivityRes.DataRes dataRes2 = (QueryGroupActivityRes.DataRes) e.getUnfinishedMessage();
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
