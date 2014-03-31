package protobuf;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
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

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.GroupInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.GroupInfo.getDefaultInstance();
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ k c() {
        return new k();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
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
        this.a &= Integer.MAX_VALUE;
        this.I = 0;
        this.b &= -2;
        this.J = 0;
        this.b &= -3;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.GroupInfo build() {
        Im.GroupInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final Im.GroupInfo buildPartial() {
        Im.GroupInfo groupInfo = new Im.GroupInfo(this, (Im.GroupInfo) null);
        int i = this.a;
        int i2 = this.b;
        int i3 = (i & 1) == 1 ? 1 : 0;
        Im.GroupInfo.access$5(groupInfo, this.c);
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        Im.GroupInfo.access$6(groupInfo, this.d);
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        Im.GroupInfo.access$7(groupInfo, this.e);
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        Im.GroupInfo.access$8(groupInfo, this.f);
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        Im.GroupInfo.access$9(groupInfo, this.g);
        if ((i & 32) == 32) {
            i3 |= 32;
        }
        Im.GroupInfo.access$10(groupInfo, this.h);
        if ((i & 64) == 64) {
            i3 |= 64;
        }
        Im.GroupInfo.access$11(groupInfo, this.i);
        if ((i & 128) == 128) {
            i3 |= 128;
        }
        Im.GroupInfo.access$12(groupInfo, this.j);
        if ((i & 256) == 256) {
            i3 |= 256;
        }
        Im.GroupInfo.access$13(groupInfo, this.k);
        if ((i & 512) == 512) {
            i3 |= 512;
        }
        Im.GroupInfo.access$14(groupInfo, this.l);
        if ((i & 1024) == 1024) {
            i3 |= 1024;
        }
        Im.GroupInfo.access$15(groupInfo, this.m);
        if ((i & 2048) == 2048) {
            i3 |= 2048;
        }
        Im.GroupInfo.access$16(groupInfo, this.n);
        if ((i & 4096) == 4096) {
            i3 |= 4096;
        }
        Im.GroupInfo.access$17(groupInfo, this.o);
        if ((i & 8192) == 8192) {
            i3 |= 8192;
        }
        Im.GroupInfo.access$18(groupInfo, this.p);
        if ((i & 16384) == 16384) {
            i3 |= 16384;
        }
        Im.GroupInfo.access$19(groupInfo, this.q);
        if ((i & 32768) == 32768) {
            i3 |= 32768;
        }
        Im.GroupInfo.access$20(groupInfo, this.r);
        if ((i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) == 65536) {
            i3 |= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
        }
        Im.GroupInfo.access$21(groupInfo, this.s);
        if ((i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) == 131072) {
            i3 |= AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        }
        Im.GroupInfo.access$22(groupInfo, this.t);
        if ((262144 & i) == 262144) {
            i3 |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
        }
        Im.GroupInfo.access$23(groupInfo, this.u);
        if ((524288 & i) == 524288) {
            i3 |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        }
        Im.GroupInfo.access$24(groupInfo, this.v);
        if ((1048576 & i) == 1048576) {
            i3 |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
        }
        Im.GroupInfo.access$25(groupInfo, this.w);
        if ((2097152 & i) == 2097152) {
            i3 |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        }
        Im.GroupInfo.access$26(groupInfo, this.x);
        if ((4194304 & i) == 4194304) {
            i3 |= 4194304;
        }
        Im.GroupInfo.access$27(groupInfo, this.y);
        if ((8388608 & i) == 8388608) {
            i3 |= GravityCompat.RELATIVE_LAYOUT_DIRECTION;
        }
        Im.GroupInfo.access$28(groupInfo, this.z);
        if ((16777216 & i) == 16777216) {
            i3 |= 16777216;
        }
        Im.GroupInfo.access$29(groupInfo, this.A);
        if ((33554432 & i) == 33554432) {
            i3 |= 33554432;
        }
        Im.GroupInfo.access$30(groupInfo, this.B);
        if ((67108864 & i) == 67108864) {
            i3 |= 67108864;
        }
        Im.GroupInfo.access$31(groupInfo, this.C);
        if ((134217728 & i) == 134217728) {
            i3 |= 134217728;
        }
        Im.GroupInfo.access$32(groupInfo, this.D);
        if ((268435456 & i) == 268435456) {
            i3 |= 268435456;
        }
        Im.GroupInfo.access$33(groupInfo, this.E);
        if ((536870912 & i) == 536870912) {
            i3 |= 536870912;
        }
        Im.GroupInfo.access$34(groupInfo, this.F);
        if ((1073741824 & i) == 1073741824) {
            i3 |= 1073741824;
        }
        Im.GroupInfo.access$35(groupInfo, this.G);
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            i3 |= Integer.MIN_VALUE;
        }
        Im.GroupInfo.access$36(groupInfo, this.H);
        int i4 = (i2 & 1) != 1 ? 0 : 1;
        Im.GroupInfo.access$37(groupInfo, this.I);
        if ((i2 & 2) == 2) {
            i4 |= 2;
        }
        Im.GroupInfo.access$38(groupInfo, this.J);
        Im.GroupInfo.access$39(groupInfo, i3);
        Im.GroupInfo.access$40(groupInfo, i4);
        return groupInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(Im.GroupInfo groupInfo) {
        if (groupInfo != Im.GroupInfo.getDefaultInstance()) {
            if (groupInfo.hasGroupId()) {
                a(groupInfo.getGroupId());
            }
            if (groupInfo.hasForumId()) {
                int forumId = groupInfo.getForumId();
                this.a |= 2;
                this.d = forumId;
            }
            if (groupInfo.hasName()) {
                this.a |= 4;
                this.e = Im.GroupInfo.access$41(groupInfo);
            }
            if (groupInfo.hasIntro()) {
                this.a |= 8;
                this.f = Im.GroupInfo.access$42(groupInfo);
            }
            if (groupInfo.hasPortrait()) {
                this.a |= 16;
                this.g = Im.GroupInfo.access$43(groupInfo);
            }
            if (groupInfo.hasPosition()) {
                this.a |= 32;
                this.h = Im.GroupInfo.access$44(groupInfo);
            }
            if (groupInfo.hasBusiness()) {
                this.a |= 64;
                this.i = Im.GroupInfo.access$45(groupInfo);
            }
            if (groupInfo.hasLng()) {
                double lng = groupInfo.getLng();
                this.a |= 128;
                this.j = lng;
            }
            if (groupInfo.hasLat()) {
                double lat = groupInfo.getLat();
                this.a |= 256;
                this.k = lat;
            }
            if (groupInfo.hasNotice()) {
                this.a |= 512;
                this.l = Im.GroupInfo.access$46(groupInfo);
            }
            if (groupInfo.hasAlbum()) {
                this.a |= 1024;
                this.m = Im.GroupInfo.access$47(groupInfo);
            }
            if (groupInfo.hasStatus()) {
                int status = groupInfo.getStatus();
                this.a |= 2048;
                this.n = status;
            }
            if (groupInfo.hasFlag()) {
                b(groupInfo.getFlag());
            }
            if (groupInfo.hasAuthorId()) {
                int authorId = groupInfo.getAuthorId();
                this.a |= 8192;
                this.p = authorId;
            }
            if (groupInfo.hasAuthorName()) {
                this.a |= 16384;
                this.q = Im.GroupInfo.access$48(groupInfo);
            }
            if (groupInfo.hasAuthorPortrait()) {
                this.a |= 32768;
                this.r = Im.GroupInfo.access$49(groupInfo);
            }
            if (groupInfo.hasCreateTime()) {
                int createTime = groupInfo.getCreateTime();
                this.a |= AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
                this.s = createTime;
            }
            if (groupInfo.hasMaxMemberNum()) {
                int maxMemberNum = groupInfo.getMaxMemberNum();
                this.a |= AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
                this.t = maxMemberNum;
            }
            if (groupInfo.hasMemberNum()) {
                int memberNum = groupInfo.getMemberNum();
                this.a |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START;
                this.u = memberNum;
            }
            if (groupInfo.hasGroupType()) {
                int groupType = groupInfo.getGroupType();
                this.a |= AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
                this.v = groupType;
            }
            if (groupInfo.hasLastMsgId()) {
                long lastMsgId = groupInfo.getLastMsgId();
                this.a |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START;
                this.w = lastMsgId;
            }
            if (groupInfo.hasGrade()) {
                int grade = groupInfo.getGrade();
                this.a |= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
                this.x = grade;
            }
            if (groupInfo.hasDistance()) {
                int distance = groupInfo.getDistance();
                this.a |= 4194304;
                this.y = distance;
            }
            if (groupInfo.hasIsHidePosition()) {
                int isHidePosition = groupInfo.getIsHidePosition();
                this.a |= GravityCompat.RELATIVE_LAYOUT_DIRECTION;
                this.z = isHidePosition;
            }
            if (groupInfo.hasForumName()) {
                this.a |= 16777216;
                this.A = Im.GroupInfo.access$50(groupInfo);
            }
            if (groupInfo.hasNickName()) {
                this.a |= 33554432;
                this.B = Im.GroupInfo.access$51(groupInfo);
            }
            if (groupInfo.hasActiveDay()) {
                int activeDay = groupInfo.getActiveDay();
                this.a |= 67108864;
                this.C = activeDay;
            }
            if (groupInfo.hasIsGroupManager()) {
                int isGroupManager = groupInfo.getIsGroupManager();
                this.a |= 134217728;
                this.D = isGroupManager;
            }
            if (groupInfo.hasAuthorIsMeizhi()) {
                int authorIsMeizhi = groupInfo.getAuthorIsMeizhi();
                this.a |= 268435456;
                this.E = authorIsMeizhi;
            }
            if (groupInfo.hasLastMsgTime()) {
                int lastMsgTime = groupInfo.getLastMsgTime();
                this.a |= 536870912;
                this.F = lastMsgTime;
            }
            if (groupInfo.hasForumShowName()) {
                this.a |= 1073741824;
                this.G = Im.GroupInfo.access$52(groupInfo);
            }
            if (groupInfo.hasIsNewlyCreate()) {
                int isNewlyCreate = groupInfo.getIsNewlyCreate();
                this.a |= Integer.MIN_VALUE;
                this.H = isNewlyCreate;
            }
            if (groupInfo.hasIsRecentlyReply()) {
                int isRecentlyReply = groupInfo.getIsRecentlyReply();
                this.b |= 1;
                this.I = isRecentlyReply;
            }
            if (groupInfo.hasIsMemberGroup()) {
                int isMemberGroup = groupInfo.getIsMemberGroup();
                this.b |= 2;
                this.J = isMemberGroup;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
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

    public final k a(int i) {
        this.a |= 1;
        this.c = i;
        return this;
    }

    public final k a(String str) {
        if (str != null) {
            this.a |= 4;
            this.e = str;
        }
        return this;
    }

    public final k b(String str) {
        if (str != null) {
            this.a |= 8;
            this.f = str;
        }
        return this;
    }

    public final k c(String str) {
        if (str != null) {
            this.a |= 16;
            this.g = str;
        }
        return this;
    }

    public final k d(String str) {
        if (str != null) {
            this.a |= 32;
            this.h = str;
        }
        return this;
    }

    public final k e(String str) {
        if (str != null) {
            this.a |= 64;
            this.i = str;
        }
        return this;
    }

    public final k f(String str) {
        if (str != null) {
            this.a |= 1024;
            this.m = str;
        }
        return this;
    }

    public final k b(int i) {
        this.a |= 4096;
        this.o = i;
        return this;
    }
}
