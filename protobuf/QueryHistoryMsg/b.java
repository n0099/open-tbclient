package protobuf.QueryHistoryMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<QueryHistoryMsgReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgReq.DataReq.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b c() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final QueryHistoryMsgReq.DataReq build() {
        QueryHistoryMsgReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final QueryHistoryMsgReq.DataReq buildPartial() {
        QueryHistoryMsgReq.DataReq dataReq = new QueryHistoryMsgReq.DataReq(this, (QueryHistoryMsgReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.forumId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.userId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.id_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.width_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.height_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.smallWidth_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataReq.smallHeight_ = this.h;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(QueryHistoryMsgReq.DataReq dataReq) {
        if (dataReq != QueryHistoryMsgReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasForumId()) {
                a(dataReq.getForumId());
            }
            if (dataReq.hasUserId()) {
                b(dataReq.getUserId());
            }
            if (dataReq.hasId()) {
                c(dataReq.getId());
            }
            if (dataReq.hasWidth()) {
                d(dataReq.getWidth());
            }
            if (dataReq.hasHeight()) {
                e(dataReq.getHeight());
            }
            if (dataReq.hasSmallWidth()) {
                f(dataReq.getSmallWidth());
            }
            if (dataReq.hasSmallHeight()) {
                g(dataReq.getSmallHeight());
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryHistoryMsgReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                QueryHistoryMsgReq.DataReq parsePartialFrom = QueryHistoryMsgReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataReq = null;
                if (dataReq != null) {
                    mergeFrom(dataReq);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHistoryMsgReq.DataReq dataReq2 = (QueryHistoryMsgReq.DataReq) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataReq = dataReq2;
                th = th3;
                if (dataReq != null) {
                }
                throw th;
            }
        }
    }

    public final b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public final b b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public final b c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public final b d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public final b e(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public final b f(int i) {
        this.a |= 32;
        this.g = i;
        return this;
    }

    public final b g(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }
}
