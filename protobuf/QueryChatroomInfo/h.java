package protobuf.QueryChatroomInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.QueryChatroomInfo.QueryChatroomInfoRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<QueryChatroomInfoRes.DataRes, h> implements i {
    private int a;
    private int b;
    private int d;
    private int e;
    private int f;
    private long i;
    private List<Im.UserInfo> c = Collections.emptyList();
    private Object g = "";
    private Object h = "";

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
        this.b = 0;
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = "";
        this.a &= -65;
        this.i = 0L;
        this.a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public QueryChatroomInfoRes.DataRes getDefaultInstanceForType() {
        return QueryChatroomInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryChatroomInfoRes.DataRes build() {
        QueryChatroomInfoRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public QueryChatroomInfoRes.DataRes buildPartial() {
        QueryChatroomInfoRes.DataRes dataRes = new QueryChatroomInfoRes.DataRes(this, (QueryChatroomInfoRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.userNum_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        dataRes.userList_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        dataRes.maxUserNum_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        dataRes.status_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        dataRes.leftTime_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        dataRes.title_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        dataRes.content_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        dataRes.lastMsgId_ = this.i;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(QueryChatroomInfoRes.DataRes dataRes) {
        List list;
        Object obj;
        Object obj2;
        List list2;
        List<Im.UserInfo> list3;
        if (dataRes != QueryChatroomInfoRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasUserNum()) {
                a(dataRes.getUserNum());
            }
            list = dataRes.userList_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list3 = dataRes.userList_;
                    this.c = list3;
                    this.a &= -3;
                } else {
                    i();
                    List<Im.UserInfo> list4 = this.c;
                    list2 = dataRes.userList_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasMaxUserNum()) {
                b(dataRes.getMaxUserNum());
            }
            if (dataRes.hasStatus()) {
                c(dataRes.getStatus());
            }
            if (dataRes.hasLeftTime()) {
                d(dataRes.getLeftTime());
            }
            if (dataRes.hasTitle()) {
                this.a |= 32;
                obj2 = dataRes.title_;
                this.g = obj2;
            }
            if (dataRes.hasContent()) {
                this.a |= 64;
                obj = dataRes.content_;
                this.h = obj;
            }
            if (dataRes.hasLastMsgId()) {
                a(dataRes.getLastMsgId());
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
        QueryChatroomInfoRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                QueryChatroomInfoRes.DataRes parsePartialFrom = QueryChatroomInfoRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            QueryChatroomInfoRes.DataRes dataRes2 = (QueryChatroomInfoRes.DataRes) e.getUnfinishedMessage();
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

    public h a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new ArrayList(this.c);
            this.a |= 2;
        }
    }

    public h b(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public h c(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public h d(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public h a(long j) {
        this.a |= 128;
        this.i = j;
        return this;
    }
}
