package protobuf.QueryChatroomInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
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

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryChatroomInfoRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryChatroomInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryChatroomInfoRes.DataRes.getDefaultInstance();
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
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryChatroomInfoRes.DataRes buildPartial() {
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
    public final h mergeFrom(QueryChatroomInfoRes.DataRes dataRes) {
        List list;
        Object obj;
        Object obj2;
        List list2;
        List<Im.UserInfo> list3;
        if (dataRes != QueryChatroomInfoRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasUserNum()) {
                int userNum = dataRes.getUserNum();
                this.a |= 1;
                this.b = userNum;
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
            if (dataRes.hasMaxUserNum()) {
                int maxUserNum = dataRes.getMaxUserNum();
                this.a |= 4;
                this.d = maxUserNum;
            }
            if (dataRes.hasStatus()) {
                int status = dataRes.getStatus();
                this.a |= 8;
                this.e = status;
            }
            if (dataRes.hasLeftTime()) {
                int leftTime = dataRes.getLeftTime();
                this.a |= 16;
                this.f = leftTime;
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
                long lastMsgId = dataRes.getLastMsgId();
                this.a |= 128;
                this.i = lastMsgId;
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
}
