package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class w extends GeneratedMessageLite.Builder<Im.MsgInfo, w> implements x {
    private int a;
    private long b;
    private int c;
    private int d;
    private long e;
    private int g;
    private int h;
    private int i;
    private long j;
    private long l;
    private Object f = "";
    private Im.UserInfo k = Im.UserInfo.getDefaultInstance();
    private Im.UserInfo m = Im.UserInfo.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.MsgInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.MsgInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.MsgInfo.getDefaultInstance();
    }

    private w() {
    }

    public static /* synthetic */ w a() {
        return new w();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public w clear() {
        super.clear();
        this.b = 0L;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0L;
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        this.j = 0L;
        this.a &= -257;
        this.k = Im.UserInfo.getDefaultInstance();
        this.a &= -513;
        this.l = 0L;
        this.a &= -1025;
        this.m = Im.UserInfo.getDefaultInstance();
        this.a &= -2049;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public w clone() {
        return new w().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.MsgInfo buildPartial() {
        Im.MsgInfo msgInfo = new Im.MsgInfo(this, (Im.MsgInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        msgInfo.msgId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        msgInfo.groupId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        msgInfo.msgType_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        msgInfo.userId_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        msgInfo.content_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        msgInfo.status_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        msgInfo.duration_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        msgInfo.createTime_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        msgInfo.recordId_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        msgInfo.userInfo_ = this.k;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        msgInfo.toUid_ = this.l;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        msgInfo.toUserInfo_ = this.m;
        msgInfo.bitField0_ = i2;
        return msgInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final w mergeFrom(Im.MsgInfo msgInfo) {
        Object obj;
        if (msgInfo != Im.MsgInfo.getDefaultInstance()) {
            if (msgInfo.hasMsgId()) {
                long msgId = msgInfo.getMsgId();
                this.a |= 1;
                this.b = msgId;
            }
            if (msgInfo.hasGroupId()) {
                int groupId = msgInfo.getGroupId();
                this.a |= 2;
                this.c = groupId;
            }
            if (msgInfo.hasMsgType()) {
                int msgType = msgInfo.getMsgType();
                this.a |= 4;
                this.d = msgType;
            }
            if (msgInfo.hasUserId()) {
                long userId = msgInfo.getUserId();
                this.a |= 8;
                this.e = userId;
            }
            if (msgInfo.hasContent()) {
                this.a |= 16;
                obj = msgInfo.content_;
                this.f = obj;
            }
            if (msgInfo.hasStatus()) {
                int status = msgInfo.getStatus();
                this.a |= 32;
                this.g = status;
            }
            if (msgInfo.hasDuration()) {
                int duration = msgInfo.getDuration();
                this.a |= 64;
                this.h = duration;
            }
            if (msgInfo.hasCreateTime()) {
                int createTime = msgInfo.getCreateTime();
                this.a |= 128;
                this.i = createTime;
            }
            if (msgInfo.hasRecordId()) {
                long recordId = msgInfo.getRecordId();
                this.a |= 256;
                this.j = recordId;
            }
            if (msgInfo.hasUserInfo()) {
                Im.UserInfo userInfo = msgInfo.getUserInfo();
                if ((this.a & 512) != 512 || this.k == Im.UserInfo.getDefaultInstance()) {
                    this.k = userInfo;
                } else {
                    this.k = Im.UserInfo.newBuilder(this.k).mergeFrom(userInfo).buildPartial();
                }
                this.a |= 512;
            }
            if (msgInfo.hasToUid()) {
                long toUid = msgInfo.getToUid();
                this.a |= 1024;
                this.l = toUid;
            }
            if (msgInfo.hasToUserInfo()) {
                Im.UserInfo toUserInfo = msgInfo.getToUserInfo();
                if ((this.a & 2048) != 2048 || this.m == Im.UserInfo.getDefaultInstance()) {
                    this.m = toUserInfo;
                } else {
                    this.m = Im.UserInfo.newBuilder(this.m).mergeFrom(toUserInfo).buildPartial();
                }
                this.a |= 2048;
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
    public w mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.MsgInfo msgInfo;
        Throwable th;
        try {
            try {
                Im.MsgInfo parsePartialFrom = Im.MsgInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            Im.MsgInfo msgInfo2 = (Im.MsgInfo) e.getUnfinishedMessage();
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
