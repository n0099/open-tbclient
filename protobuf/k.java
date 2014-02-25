package protobuf;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import cn.jingling.lib.file.Shared;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<Im.GroupInfo, k> implements l {
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

    private k() {
        g();
    }

    private void g() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.GroupInfo.newBuilder():protobuf.k] */
    public static /* synthetic */ k f() {
        return h();
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
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

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.GroupInfo getDefaultInstanceForType() {
        return Im.GroupInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GroupInfo build() {
        Im.GroupInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GroupInfo buildPartial() {
        Im.GroupInfo groupInfo = new Im.GroupInfo(this, (Im.GroupInfo) null);
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
        if ((i & 4096) == 4096) {
            i3 |= 4096;
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
        if ((i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) == 65536) {
            i3 |= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
        }
        groupInfo.createTime_ = this.s;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) == 131072) {
            i3 |= AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        }
        groupInfo.maxMemberNum_ = this.t;
        if ((262144 & i) == 262144) {
            i3 |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
        }
        groupInfo.memberNum_ = this.u;
        if ((524288 & i) == 524288) {
            i3 |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        }
        groupInfo.groupType_ = this.v;
        if ((1048576 & i) == 1048576) {
            i3 |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
        }
        groupInfo.lastMsgId_ = this.w;
        if ((2097152 & i) == 2097152) {
            i3 |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        }
        groupInfo.grade_ = this.x;
        if ((4194304 & i) == 4194304) {
            i3 |= 4194304;
        }
        groupInfo.distance_ = this.y;
        if ((8388608 & i) == 8388608) {
            i3 |= GravityCompat.RELATIVE_LAYOUT_DIRECTION;
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

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(Im.GroupInfo groupInfo) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        if (groupInfo != Im.GroupInfo.getDefaultInstance()) {
            if (groupInfo.hasGroupId()) {
                a(groupInfo.getGroupId());
            }
            if (groupInfo.hasForumId()) {
                b(groupInfo.getForumId());
            }
            if (groupInfo.hasName()) {
                this.a |= 4;
                obj12 = groupInfo.name_;
                this.e = obj12;
            }
            if (groupInfo.hasIntro()) {
                this.a |= 8;
                obj11 = groupInfo.intro_;
                this.f = obj11;
            }
            if (groupInfo.hasPortrait()) {
                this.a |= 16;
                obj10 = groupInfo.portrait_;
                this.g = obj10;
            }
            if (groupInfo.hasPosition()) {
                this.a |= 32;
                obj9 = groupInfo.position_;
                this.h = obj9;
            }
            if (groupInfo.hasBusiness()) {
                this.a |= 64;
                obj8 = groupInfo.business_;
                this.i = obj8;
            }
            if (groupInfo.hasLng()) {
                a(groupInfo.getLng());
            }
            if (groupInfo.hasLat()) {
                b(groupInfo.getLat());
            }
            if (groupInfo.hasNotice()) {
                this.a |= 512;
                obj7 = groupInfo.notice_;
                this.l = obj7;
            }
            if (groupInfo.hasAlbum()) {
                this.a |= 1024;
                obj6 = groupInfo.album_;
                this.m = obj6;
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
                obj5 = groupInfo.authorName_;
                this.q = obj5;
            }
            if (groupInfo.hasAuthorPortrait()) {
                this.a |= 32768;
                obj4 = groupInfo.authorPortrait_;
                this.r = obj4;
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
                obj3 = groupInfo.forumName_;
                this.A = obj3;
            }
            if (groupInfo.hasNickName()) {
                this.a |= 33554432;
                obj2 = groupInfo.nickName_;
                this.B = obj2;
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
                obj = groupInfo.forumShowName_;
                this.G = obj;
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public k a(int i) {
        this.a |= 1;
        this.c = i;
        return this;
    }

    public k b(int i) {
        this.a |= 2;
        this.d = i;
        return this;
    }

    public k a(String str) {
        if (str != null) {
            this.a |= 4;
            this.e = str;
        }
        return this;
    }

    public k b(String str) {
        if (str != null) {
            this.a |= 8;
            this.f = str;
        }
        return this;
    }

    public k c(String str) {
        if (str != null) {
            this.a |= 16;
            this.g = str;
        }
        return this;
    }

    public k d(String str) {
        if (str != null) {
            this.a |= 32;
            this.h = str;
        }
        return this;
    }

    public k e(String str) {
        if (str != null) {
            this.a |= 64;
            this.i = str;
        }
        return this;
    }

    public k a(double d) {
        this.a |= 128;
        this.j = d;
        return this;
    }

    public k b(double d) {
        this.a |= 256;
        this.k = d;
        return this;
    }

    public k f(String str) {
        if (str != null) {
            this.a |= 1024;
            this.m = str;
        }
        return this;
    }

    public k c(int i) {
        this.a |= 2048;
        this.n = i;
        return this;
    }

    public k d(int i) {
        this.a |= 4096;
        this.o = i;
        return this;
    }

    public k e(int i) {
        this.a |= 8192;
        this.p = i;
        return this;
    }

    public k f(int i) {
        this.a |= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
        this.s = i;
        return this;
    }

    public k g(int i) {
        this.a |= AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        this.t = i;
        return this;
    }

    public k h(int i) {
        this.a |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
        this.u = i;
        return this;
    }

    public k i(int i) {
        this.a |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        this.v = i;
        return this;
    }

    public k a(long j) {
        this.a |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
        this.w = j;
        return this;
    }

    public k j(int i) {
        this.a |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        this.x = i;
        return this;
    }

    public k k(int i) {
        this.a |= 4194304;
        this.y = i;
        return this;
    }

    public k l(int i) {
        this.a |= GravityCompat.RELATIVE_LAYOUT_DIRECTION;
        this.z = i;
        return this;
    }

    public k m(int i) {
        this.a |= 67108864;
        this.C = i;
        return this;
    }

    public k n(int i) {
        this.a |= 134217728;
        this.D = i;
        return this;
    }

    public k o(int i) {
        this.a |= 268435456;
        this.E = i;
        return this;
    }

    public k p(int i) {
        this.a |= 536870912;
        this.F = i;
        return this;
    }

    public k q(int i) {
        this.a |= Integer.MIN_VALUE;
        this.H = i;
        return this;
    }

    public k r(int i) {
        this.b |= 1;
        this.I = i;
        return this;
    }

    public k s(int i) {
        this.b |= 2;
        this.J = i;
        return this;
    }
}
