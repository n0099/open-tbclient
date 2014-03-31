package protobuf.QueryHistoryMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<QueryHistoryMsgRes.MsgInfo, k> implements l {
    private int a;
    private long b;
    private int c;
    private Object d = "";
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        QueryHistoryMsgRes.MsgInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgRes.MsgInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return QueryHistoryMsgRes.MsgInfo.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public QueryHistoryMsgRes.MsgInfo buildPartial() {
        QueryHistoryMsgRes.MsgInfo msgInfo = new QueryHistoryMsgRes.MsgInfo(this, (QueryHistoryMsgRes.MsgInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        msgInfo.sendTime_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        msgInfo.type_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        msgInfo.content_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        msgInfo.id_ = this.e;
        msgInfo.bitField0_ = i2;
        return msgInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(QueryHistoryMsgRes.MsgInfo msgInfo) {
        Object obj;
        if (msgInfo != QueryHistoryMsgRes.MsgInfo.getDefaultInstance()) {
            if (msgInfo.hasSendTime()) {
                long sendTime = msgInfo.getSendTime();
                this.a |= 1;
                this.b = sendTime;
            }
            if (msgInfo.hasType()) {
                int type = msgInfo.getType();
                this.a |= 2;
                this.c = type;
            }
            if (msgInfo.hasContent()) {
                this.a |= 4;
                obj = msgInfo.content_;
                this.d = obj;
            }
            if (msgInfo.hasId()) {
                int id = msgInfo.getId();
                this.a |= 8;
                this.e = id;
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        QueryHistoryMsgRes.MsgInfo msgInfo;
        Throwable th;
        try {
            try {
                QueryHistoryMsgRes.MsgInfo parsePartialFrom = QueryHistoryMsgRes.MsgInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                msgInfo = null;
                if (msgInfo != null) {
                    mergeFrom(msgInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            QueryHistoryMsgRes.MsgInfo msgInfo2 = (QueryHistoryMsgRes.MsgInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                msgInfo = msgInfo2;
                th = th3;
                if (msgInfo != null) {
                }
                throw th;
            }
        }
    }
}
