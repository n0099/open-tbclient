package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
public final class ai extends GeneratedMessageLite.Builder<Im.UserInfo, ai> implements aj {
    private int a;
    private int b;
    private int f;
    private double h;
    private double i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int p;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    private Object g = "";
    private Im.UserPermission n = Im.UserPermission.getDefaultInstance();
    private List<Im.TshowInfo> o = Collections.emptyList();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.UserInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.UserInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.UserInfo.getDefaultInstance();
    }

    private ai() {
    }

    public static /* synthetic */ ai b() {
        return new ai();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public ai clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = 0.0d;
        this.a &= -65;
        this.i = 0.0d;
        this.a &= -129;
        this.j = 0;
        this.a &= -257;
        this.k = 0;
        this.a &= -513;
        this.l = 0;
        this.a &= -1025;
        this.m = 0;
        this.a &= -2049;
        this.n = Im.UserPermission.getDefaultInstance();
        this.a &= -4097;
        this.o = Collections.emptyList();
        this.a &= -8193;
        this.p = 0;
        this.a &= -16385;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public ai clone() {
        return new ai().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.UserInfo buildPartial() {
        Im.UserInfo userInfo = new Im.UserInfo(this, (Im.UserInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        userInfo.userId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        userInfo.userName_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        userInfo.nickName_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        userInfo.portrait_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        userInfo.sex_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        userInfo.position_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        userInfo.lng_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        userInfo.lat_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        userInfo.inTime_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        userInfo.loginTime_ = this.k;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        userInfo.lastReplyTime_ = this.l;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        userInfo.sysGroupId_ = this.m;
        if ((i & 4096) == 4096) {
            i2 |= 4096;
        }
        userInfo.permission_ = this.n;
        if ((this.a & 8192) == 8192) {
            this.o = Collections.unmodifiableList(this.o);
            this.a &= -8193;
        }
        userInfo.tshowIcon_ = this.o;
        if ((i & 16384) == 16384) {
            i2 |= 8192;
        }
        userInfo.userType_ = this.p;
        userInfo.bitField0_ = i2;
        return userInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final ai mergeFrom(Im.UserInfo userInfo) {
        List list;
        List list2;
        List<Im.TshowInfo> list3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (userInfo != Im.UserInfo.getDefaultInstance()) {
            if (userInfo.hasUserId()) {
                int userId = userInfo.getUserId();
                this.a |= 1;
                this.b = userId;
            }
            if (userInfo.hasUserName()) {
                this.a |= 2;
                obj4 = userInfo.userName_;
                this.c = obj4;
            }
            if (userInfo.hasNickName()) {
                this.a |= 4;
                obj3 = userInfo.nickName_;
                this.d = obj3;
            }
            if (userInfo.hasPortrait()) {
                this.a |= 8;
                obj2 = userInfo.portrait_;
                this.e = obj2;
            }
            if (userInfo.hasSex()) {
                int sex = userInfo.getSex();
                this.a |= 16;
                this.f = sex;
            }
            if (userInfo.hasPosition()) {
                this.a |= 32;
                obj = userInfo.position_;
                this.g = obj;
            }
            if (userInfo.hasLng()) {
                double lng = userInfo.getLng();
                this.a |= 64;
                this.h = lng;
            }
            if (userInfo.hasLat()) {
                double lat = userInfo.getLat();
                this.a |= 128;
                this.i = lat;
            }
            if (userInfo.hasInTime()) {
                int inTime = userInfo.getInTime();
                this.a |= 256;
                this.j = inTime;
            }
            if (userInfo.hasLoginTime()) {
                int loginTime = userInfo.getLoginTime();
                this.a |= 512;
                this.k = loginTime;
            }
            if (userInfo.hasLastReplyTime()) {
                int lastReplyTime = userInfo.getLastReplyTime();
                this.a |= 1024;
                this.l = lastReplyTime;
            }
            if (userInfo.hasSysGroupId()) {
                int sysGroupId = userInfo.getSysGroupId();
                this.a |= 2048;
                this.m = sysGroupId;
            }
            if (userInfo.hasPermission()) {
                Im.UserPermission permission = userInfo.getPermission();
                if ((this.a & 4096) != 4096 || this.n == Im.UserPermission.getDefaultInstance()) {
                    this.n = permission;
                } else {
                    this.n = Im.UserPermission.newBuilder(this.n).mergeFrom(permission).buildPartial();
                }
                this.a |= 4096;
            }
            list = userInfo.tshowIcon_;
            if (!list.isEmpty()) {
                if (this.o.isEmpty()) {
                    list3 = userInfo.tshowIcon_;
                    this.o = list3;
                    this.a &= -8193;
                } else {
                    if ((this.a & 8192) != 8192) {
                        this.o = new ArrayList(this.o);
                        this.a |= 8192;
                    }
                    List<Im.TshowInfo> list4 = this.o;
                    list2 = userInfo.tshowIcon_;
                    list4.addAll(list2);
                }
            }
            if (userInfo.hasUserType()) {
                int userType = userInfo.getUserType();
                this.a |= 16384;
                this.p = userType;
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
    public ai mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.UserInfo userInfo;
        Throwable th;
        try {
            try {
                Im.UserInfo parsePartialFrom = Im.UserInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                userInfo = null;
                if (userInfo != null) {
                    mergeFrom(userInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.UserInfo userInfo2 = (Im.UserInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                userInfo = userInfo2;
                th = th3;
                if (userInfo != null) {
                }
                throw th;
            }
        }
    }
}
