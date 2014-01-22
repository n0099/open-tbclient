package protobuf;

import cn.jingling.lib.file.Shared;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class i extends GeneratedMessageLite.Builder<Im.GroupInfo, i> implements j {
    private int C;
    private int D;
    private int E;
    private int F;
    private int H;
    private int I;
    private int J;
    private int a;
    private int b;
    private int c;
    private int d;
    private double j;
    private double k;
    private int n;
    private int o;
    private int p;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private int x;
    private int y;
    private int z;
    private Object e = "";
    private Object f = "";
    private Object g = "";
    private Object h = "";
    private Object i = "";
    private Object l = "";
    private Object m = "";
    private Object q = "";
    private Object r = "";
    private Object A = "";
    private Object B = "";
    private Object G = "";

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
        this.c = 0;
        this.a &= -2;
        this.d = 0;
        this.a &= -3;
        this.e = "";
        this.a &= -5;
        this.f = "";
        this.a &= -9;
        this.g = "";
        this.a &= -17;
        this.h = "";
        this.a &= -33;
        this.i = "";
        this.a &= -65;
        this.j = 0.0d;
        this.a &= -129;
        this.k = 0.0d;
        this.a &= -257;
        this.l = "";
        this.a &= -513;
        this.m = "";
        this.a &= -1025;
        this.n = 0;
        this.a &= -2049;
        this.o = 0;
        this.a &= -4097;
        this.p = 0;
        this.a &= -8193;
        this.q = "";
        this.a &= -16385;
        this.r = "";
        this.a &= -32769;
        this.s = 0;
        this.a &= -65537;
        this.t = 0;
        this.a &= -131073;
        this.u = 0;
        this.a &= -262145;
        this.v = 0;
        this.a &= -524289;
        this.w = 0L;
        this.a &= -1048577;
        this.x = 0;
        this.a &= -2097153;
        this.y = 0;
        this.a &= -4194305;
        this.z = 0;
        this.a &= -8388609;
        this.A = "";
        this.a &= -16777217;
        this.B = "";
        this.a &= -33554433;
        this.C = 0;
        this.a &= -67108865;
        this.D = 0;
        this.a &= -134217729;
        this.E = 0;
        this.a &= -268435457;
        this.F = 0;
        this.a &= -536870913;
        this.G = "";
        this.a &= -1073741825;
        this.H = 0;
        this.a &= Shared.INFINITY;
        this.I = 0;
        this.b &= -2;
        this.J = 0;
        this.b &= -3;
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
        int i2 = this.b;
        int i3 = (i & 1) == 1 ? 1 : 0;
        groupInfo.groupId_ = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        groupInfo.forumId_ = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        groupInfo.name_ = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        groupInfo.intro_ = this.f;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        groupInfo.portrait_ = this.g;
        if ((i & 32) == 32) {
            i3 |= 32;
        }
        groupInfo.position_ = this.h;
        if ((i & 64) == 64) {
            i3 |= 64;
        }
        groupInfo.business_ = this.i;
        if ((i & 128) == 128) {
            i3 |= 128;
        }
        groupInfo.lng_ = this.j;
        if ((i & 256) == 256) {
            i3 |= 256;
        }
        groupInfo.lat_ = this.k;
        if ((i & 512) == 512) {
            i3 |= 512;
        }
        groupInfo.notice_ = this.l;
        if ((i & 1024) == 1024) {
            i3 |= 1024;
        }
        groupInfo.album_ = this.m;
        if ((i & 2048) == 2048) {
            i3 |= 2048;
        }
        groupInfo.status_ = this.n;
        if ((i & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
            i3 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        groupInfo.flag_ = this.o;
        if ((i & 8192) == 8192) {
            i3 |= 8192;
        }
        groupInfo.authorId_ = this.p;
        if ((i & 16384) == 16384) {
            i3 |= 16384;
        }
        groupInfo.authorName_ = this.q;
        if ((i & 32768) == 32768) {
            i3 |= 32768;
        }
        groupInfo.authorPortrait_ = this.r;
        if ((i & 65536) == 65536) {
            i3 |= 65536;
        }
        groupInfo.createTime_ = this.s;
        if ((i & 131072) == 131072) {
            i3 |= 131072;
        }
        groupInfo.maxMemberNum_ = this.t;
        if ((262144 & i) == 262144) {
            i3 |= 262144;
        }
        groupInfo.memberNum_ = this.u;
        if ((524288 & i) == 524288) {
            i3 |= 524288;
        }
        groupInfo.groupType_ = this.v;
        if ((1048576 & i) == 1048576) {
            i3 |= 1048576;
        }
        groupInfo.lastMsgId_ = this.w;
        if ((2097152 & i) == 2097152) {
            i3 |= 2097152;
        }
        groupInfo.grade_ = this.x;
        if ((4194304 & i) == 4194304) {
            i3 |= 4194304;
        }
        groupInfo.distance_ = this.y;
        if ((8388608 & i) == 8388608) {
            i3 |= 8388608;
        }
        groupInfo.isHidePosition_ = this.z;
        if ((16777216 & i) == 16777216) {
            i3 |= 16777216;
        }
        groupInfo.forumName_ = this.A;
        if ((33554432 & i) == 33554432) {
            i3 |= 33554432;
        }
        groupInfo.nickName_ = this.B;
        if ((67108864 & i) == 67108864) {
            i3 |= 67108864;
        }
        groupInfo.activeDay_ = this.C;
        if ((134217728 & i) == 134217728) {
            i3 |= 134217728;
        }
        groupInfo.isGroupManager_ = this.D;
        if ((268435456 & i) == 268435456) {
            i3 |= 268435456;
        }
        groupInfo.authorIsMeizhi_ = this.E;
        if ((536870912 & i) == 536870912) {
            i3 |= 536870912;
        }
        groupInfo.lastMsgTime_ = this.F;
        if ((1073741824 & i) == 1073741824) {
            i3 |= 1073741824;
        }
        groupInfo.forumShowName_ = this.G;
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            i3 |= Integer.MIN_VALUE;
        }
        groupInfo.isNewlyCreate_ = this.H;
        int i4 = (i2 & 1) != 1 ? 0 : 1;
        groupInfo.isRecentlyReply_ = this.I;
        if ((i2 & 2) == 2) {
            i4 |= 2;
        }
        groupInfo.isMemberGroup_ = this.J;
        groupInfo.bitField0_ = i3;
        groupInfo.bitField1_ = i4;
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
                this.e = groupInfo.name_;
            }
            if (groupInfo.hasIntro()) {
                this.a |= 8;
                this.f = groupInfo.intro_;
            }
            if (groupInfo.hasPortrait()) {
                this.a |= 16;
                this.g = groupInfo.portrait_;
            }
            if (groupInfo.hasPosition()) {
                this.a |= 32;
                this.h = groupInfo.position_;
            }
            if (groupInfo.hasBusiness()) {
                this.a |= 64;
                this.i = groupInfo.business_;
            }
            if (groupInfo.hasLng()) {
                a(groupInfo.getLng());
            }
            if (groupInfo.hasLat()) {
                b(groupInfo.getLat());
            }
            if (groupInfo.hasNotice()) {
                this.a |= 512;
                this.l = groupInfo.notice_;
            }
            if (groupInfo.hasAlbum()) {
                this.a |= 1024;
                this.m = groupInfo.album_;
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
                this.q = groupInfo.authorName_;
            }
            if (groupInfo.hasAuthorPortrait()) {
                this.a |= 32768;
                this.r = groupInfo.authorPortrait_;
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
                this.A = groupInfo.forumName_;
            }
            if (groupInfo.hasNickName()) {
                this.a |= 33554432;
                this.B = groupInfo.nickName_;
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
                this.G = groupInfo.forumShowName_;
            }
            if (groupInfo.hasIsNewlyCreate()) {
                q(groupInfo.getIsNewlyCreate());
            }
            if (groupInfo.hasIsRecentlyReply()) {
                r(groupInfo.getIsRecentlyReply());
            }
            if (groupInfo.hasIsMemberGroup()) {
                s(groupInfo.getIsMemberGroup());
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
        this.c = i;
        return this;
    }

    public i b(int i) {
        this.a |= 2;
        this.d = i;
        return this;
    }

    public i a(String str) {
        if (str != null) {
            this.a |= 4;
            this.e = str;
        }
        return this;
    }

    public i b(String str) {
        if (str != null) {
            this.a |= 8;
            this.f = str;
        }
        return this;
    }

    public i c(String str) {
        if (str != null) {
            this.a |= 16;
            this.g = str;
        }
        return this;
    }

    public i d(String str) {
        if (str != null) {
            this.a |= 32;
            this.h = str;
        }
        return this;
    }

    public i a(double d) {
        this.a |= 128;
        this.j = d;
        return this;
    }

    public i b(double d) {
        this.a |= 256;
        this.k = d;
        return this;
    }

    public i e(String str) {
        if (str != null) {
            this.a |= 1024;
            this.m = str;
        }
        return this;
    }

    public i c(int i) {
        this.a |= 2048;
        this.n = i;
        return this;
    }

    public i d(int i) {
        this.a |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        this.o = i;
        return this;
    }

    public i e(int i) {
        this.a |= 8192;
        this.p = i;
        return this;
    }

    public i f(int i) {
        this.a |= 65536;
        this.s = i;
        return this;
    }

    public i g(int i) {
        this.a |= 131072;
        this.t = i;
        return this;
    }

    public i h(int i) {
        this.a |= 262144;
        this.u = i;
        return this;
    }

    public i i(int i) {
        this.a |= 524288;
        this.v = i;
        return this;
    }

    public i a(long j) {
        this.a |= 1048576;
        this.w = j;
        return this;
    }

    public i j(int i) {
        this.a |= 2097152;
        this.x = i;
        return this;
    }

    public i k(int i) {
        this.a |= 4194304;
        this.y = i;
        return this;
    }

    public i l(int i) {
        this.a |= 8388608;
        this.z = i;
        return this;
    }

    public i m(int i) {
        this.a |= 67108864;
        this.C = i;
        return this;
    }

    public i n(int i) {
        this.a |= 134217728;
        this.D = i;
        return this;
    }

    public i o(int i) {
        this.a |= 268435456;
        this.E = i;
        return this;
    }

    public i p(int i) {
        this.a |= 536870912;
        this.F = i;
        return this;
    }

    public i q(int i) {
        this.a |= Integer.MIN_VALUE;
        this.H = i;
        return this;
    }

    public i r(int i) {
        this.b |= 1;
        this.I = i;
        return this;
    }

    public i s(int i) {
        this.b |= 2;
        this.J = i;
        return this;
    }
}
