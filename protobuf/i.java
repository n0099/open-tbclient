package protobuf;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class i extends GeneratedMessageLite.Builder<Im.GroupInfo, i> implements j {
    private int B;
    private int C;
    private int D;
    private int E;
    private int a;
    private int b;
    private int c;
    private double i;
    private double j;
    private int m;
    private int n;
    private int o;
    private int r;
    private int s;
    private int t;
    private int u;
    private long v;
    private int w;
    private int x;
    private int y;
    private Object d = "";
    private Object e = "";
    private Object f = "";
    private Object g = "";
    private Object h = "";
    private Object k = "";
    private Object l = "";
    private Object p = "";
    private Object q = "";
    private Object z = "";
    private Object A = "";
    private Object F = "";

    private i() {
        g();
    }

    private void g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static i h() {
        return new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public i clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = "";
        this.a &= -65;
        this.i = 0.0d;
        this.a &= -129;
        this.j = 0.0d;
        this.a &= -257;
        this.k = "";
        this.a &= -513;
        this.l = "";
        this.a &= -1025;
        this.m = 0;
        this.a &= -2049;
        this.n = 0;
        this.a &= -4097;
        this.o = 0;
        this.a &= -8193;
        this.p = "";
        this.a &= -16385;
        this.q = "";
        this.a &= -32769;
        this.r = 0;
        this.a &= -65537;
        this.s = 0;
        this.a &= -131073;
        this.t = 0;
        this.a &= -262145;
        this.u = 0;
        this.a &= -524289;
        this.v = 0L;
        this.a &= -1048577;
        this.w = 0;
        this.a &= -2097153;
        this.x = 0;
        this.a &= -4194305;
        this.y = 0;
        this.a &= -8388609;
        this.z = "";
        this.a &= -16777217;
        this.A = "";
        this.a &= -33554433;
        this.B = 0;
        this.a &= -67108865;
        this.C = 0;
        this.a &= -134217729;
        this.D = 0;
        this.a &= -268435457;
        this.E = 0;
        this.a &= -536870913;
        this.F = "";
        this.a &= -1073741825;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public i clone() {
        return h().mergeFrom(buildPartial());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.GroupInfo getDefaultInstanceForType() {
        return Im.GroupInfo.getDefaultInstance();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GroupInfo build() {
        Im.GroupInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GroupInfo buildPartial() {
        Im.GroupInfo groupInfo = new Im.GroupInfo(this);
        int i = this.a;
        int i2 = 0;
        if ((i & 1) == 1) {
            i2 = 1;
        }
        groupInfo.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        groupInfo.forumId_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        groupInfo.name_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        groupInfo.intro_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        groupInfo.portrait_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        groupInfo.position_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        groupInfo.business_ = this.h;
        if ((i & DERTags.TAGGED) == 128) {
            i2 |= DERTags.TAGGED;
        }
        groupInfo.lng_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        groupInfo.lat_ = this.j;
        if ((i & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
            i2 |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        }
        groupInfo.notice_ = this.k;
        if ((i & NotificationProxy.MAX_URL_LENGTH) == 1024) {
            i2 |= NotificationProxy.MAX_URL_LENGTH;
        }
        groupInfo.album_ = this.l;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        groupInfo.status_ = this.m;
        if ((i & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
            i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        groupInfo.flag_ = this.n;
        if ((i & 8192) == 8192) {
            i2 |= 8192;
        }
        groupInfo.authorId_ = this.o;
        if ((i & 16384) == 16384) {
            i2 |= 16384;
        }
        groupInfo.authorName_ = this.p;
        if ((i & 32768) == 32768) {
            i2 |= 32768;
        }
        groupInfo.authorPortrait_ = this.q;
        if ((i & 65536) == 65536) {
            i2 |= 65536;
        }
        groupInfo.createTime_ = this.r;
        if ((i & 131072) == 131072) {
            i2 |= 131072;
        }
        groupInfo.maxMemberNum_ = this.s;
        if ((i & 262144) == 262144) {
            i2 |= 262144;
        }
        groupInfo.memberNum_ = this.t;
        if ((i & 524288) == 524288) {
            i2 |= 524288;
        }
        groupInfo.groupType_ = this.u;
        if ((1048576 & i) == 1048576) {
            i2 |= 1048576;
        }
        groupInfo.lastMsgId_ = this.v;
        if ((2097152 & i) == 2097152) {
            i2 |= 2097152;
        }
        groupInfo.grade_ = this.w;
        if ((4194304 & i) == 4194304) {
            i2 |= 4194304;
        }
        groupInfo.distance_ = this.x;
        if ((8388608 & i) == 8388608) {
            i2 |= 8388608;
        }
        groupInfo.isHidePosition_ = this.y;
        if ((16777216 & i) == 16777216) {
            i2 |= 16777216;
        }
        groupInfo.forumName_ = this.z;
        if ((33554432 & i) == 33554432) {
            i2 |= 33554432;
        }
        groupInfo.nickName_ = this.A;
        if ((67108864 & i) == 67108864) {
            i2 |= 67108864;
        }
        groupInfo.activeDay_ = this.B;
        if ((134217728 & i) == 134217728) {
            i2 |= 134217728;
        }
        groupInfo.isGroupManager_ = this.C;
        if ((268435456 & i) == 268435456) {
            i2 |= 268435456;
        }
        groupInfo.authorIsMeizhi_ = this.D;
        if ((536870912 & i) == 536870912) {
            i2 |= 536870912;
        }
        groupInfo.lastMsgTime_ = this.E;
        if ((i & 1073741824) == 1073741824) {
            i2 |= 1073741824;
        }
        groupInfo.forumShowName_ = this.F;
        groupInfo.bitField0_ = i2;
        return groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public i mergeFrom(Im.GroupInfo groupInfo) {
        if (groupInfo != Im.GroupInfo.getDefaultInstance()) {
            if (groupInfo.hasGroupId()) {
                a(groupInfo.getGroupId());
            }
            if (groupInfo.hasForumId()) {
                b(groupInfo.getForumId());
            }
            if (groupInfo.hasName()) {
                this.a |= 4;
                this.d = groupInfo.name_;
            }
            if (groupInfo.hasIntro()) {
                this.a |= 8;
                this.e = groupInfo.intro_;
            }
            if (groupInfo.hasPortrait()) {
                this.a |= 16;
                this.f = groupInfo.portrait_;
            }
            if (groupInfo.hasPosition()) {
                this.a |= 32;
                this.g = groupInfo.position_;
            }
            if (groupInfo.hasBusiness()) {
                this.a |= 64;
                this.h = groupInfo.business_;
            }
            if (groupInfo.hasLng()) {
                a(groupInfo.getLng());
            }
            if (groupInfo.hasLat()) {
                b(groupInfo.getLat());
            }
            if (groupInfo.hasNotice()) {
                this.a |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
                this.k = groupInfo.notice_;
            }
            if (groupInfo.hasAlbum()) {
                this.a |= NotificationProxy.MAX_URL_LENGTH;
                this.l = groupInfo.album_;
            }
            if (groupInfo.hasStatus()) {
                c(groupInfo.getStatus());
            }
            if (groupInfo.hasFlag()) {
                d(groupInfo.getFlag());
            }
            if (groupInfo.hasAuthorId()) {
                e(groupInfo.getAuthorId());
            }
            if (groupInfo.hasAuthorName()) {
                this.a |= 16384;
                this.p = groupInfo.authorName_;
            }
            if (groupInfo.hasAuthorPortrait()) {
                this.a |= 32768;
                this.q = groupInfo.authorPortrait_;
            }
            if (groupInfo.hasCreateTime()) {
                f(groupInfo.getCreateTime());
            }
            if (groupInfo.hasMaxMemberNum()) {
                g(groupInfo.getMaxMemberNum());
            }
            if (groupInfo.hasMemberNum()) {
                h(groupInfo.getMemberNum());
            }
            if (groupInfo.hasGroupType()) {
                i(groupInfo.getGroupType());
            }
            if (groupInfo.hasLastMsgId()) {
                a(groupInfo.getLastMsgId());
            }
            if (groupInfo.hasGrade()) {
                j(groupInfo.getGrade());
            }
            if (groupInfo.hasDistance()) {
                k(groupInfo.getDistance());
            }
            if (groupInfo.hasIsHidePosition()) {
                l(groupInfo.getIsHidePosition());
            }
            if (groupInfo.hasForumName()) {
                this.a |= 16777216;
                this.z = groupInfo.forumName_;
            }
            if (groupInfo.hasNickName()) {
                this.a |= 33554432;
                this.A = groupInfo.nickName_;
            }
            if (groupInfo.hasActiveDay()) {
                m(groupInfo.getActiveDay());
            }
            if (groupInfo.hasIsGroupManager()) {
                n(groupInfo.getIsGroupManager());
            }
            if (groupInfo.hasAuthorIsMeizhi()) {
                o(groupInfo.getAuthorIsMeizhi());
            }
            if (groupInfo.hasLastMsgTime()) {
                p(groupInfo.getLastMsgTime());
            }
            if (groupInfo.hasForumShowName()) {
                this.a |= 1073741824;
                this.F = groupInfo.forumShowName_;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.GroupInfo groupInfo;
        Throwable th;
        try {
            try {
                Im.GroupInfo parsePartialFrom = Im.GroupInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                groupInfo = null;
                if (groupInfo != null) {
                    mergeFrom(groupInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.GroupInfo groupInfo2 = (Im.GroupInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                groupInfo = groupInfo2;
                th = th3;
                if (groupInfo != null) {
                }
                throw th;
            }
        }
    }

    public i a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public i b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public i a(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }

    public i b(String str) {
        if (str != null) {
            this.a |= 8;
            this.e = str;
        }
        return this;
    }

    public i c(String str) {
        if (str != null) {
            this.a |= 16;
            this.f = str;
        }
        return this;
    }

    public i d(String str) {
        if (str != null) {
            this.a |= 32;
            this.g = str;
        }
        return this;
    }

    public i a(double d) {
        this.a |= DERTags.TAGGED;
        this.i = d;
        return this;
    }

    public i b(double d) {
        this.a |= 256;
        this.j = d;
        return this;
    }

    public i e(String str) {
        if (str != null) {
            this.a |= NotificationProxy.MAX_URL_LENGTH;
            this.l = str;
        }
        return this;
    }

    public i c(int i) {
        this.a |= 2048;
        this.m = i;
        return this;
    }

    public i d(int i) {
        this.a |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        this.n = i;
        return this;
    }

    public i e(int i) {
        this.a |= 8192;
        this.o = i;
        return this;
    }

    public i f(int i) {
        this.a |= 65536;
        this.r = i;
        return this;
    }

    public i g(int i) {
        this.a |= 131072;
        this.s = i;
        return this;
    }

    public i h(int i) {
        this.a |= 262144;
        this.t = i;
        return this;
    }

    public i i(int i) {
        this.a |= 524288;
        this.u = i;
        return this;
    }

    public i a(long j) {
        this.a |= 1048576;
        this.v = j;
        return this;
    }

    public i j(int i) {
        this.a |= 2097152;
        this.w = i;
        return this;
    }

    public i k(int i) {
        this.a |= 4194304;
        this.x = i;
        return this;
    }

    public i l(int i) {
        this.a |= 8388608;
        this.y = i;
        return this;
    }

    public i m(int i) {
        this.a |= 67108864;
        this.B = i;
        return this;
    }

    public i n(int i) {
        this.a |= 134217728;
        this.C = i;
        return this;
    }

    public i o(int i) {
        this.a |= 268435456;
        this.D = i;
        return this;
    }

    public i p(int i) {
        this.a |= 536870912;
        this.E = i;
        return this;
    }
}
