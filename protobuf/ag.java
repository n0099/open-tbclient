package protobuf;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.zeus.NotificationProxy;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
public final class ag extends GeneratedMessageLite.Builder<Im.UserInfo, ag> implements ah {
    private int a;
    private int b;
    private int f;
    private double h;
    private double i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    private Object g = "";
    private Im.UserPermission n = Im.UserPermission.getDefaultInstance();
    private List<Im.TshowInfo> o = Collections.emptyList();

    private ag() {
        g();
    }

    private void g() {
    }

    public static ag h() {
        return new ag();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public ag clear() {
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
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public ag clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.UserInfo getDefaultInstanceForType() {
        return Im.UserInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.UserInfo build() {
        Im.UserInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.UserInfo buildPartial() {
        Im.UserInfo userInfo = new Im.UserInfo(this);
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
        if ((i & DERTags.TAGGED) == 128) {
            i2 |= DERTags.TAGGED;
        }
        userInfo.lat_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        userInfo.inTime_ = this.j;
        if ((i & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
            i2 |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        }
        userInfo.loginTime_ = this.k;
        if ((i & NotificationProxy.MAX_URL_LENGTH) == 1024) {
            i2 |= NotificationProxy.MAX_URL_LENGTH;
        }
        userInfo.lastReplyTime_ = this.l;
        if ((i & 2048) == 2048) {
            i2 |= 2048;
        }
        userInfo.sysGroupId_ = this.m;
        if ((i & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096) {
            i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        userInfo.permission_ = this.n;
        if ((this.a & 8192) == 8192) {
            this.o = Collections.unmodifiableList(this.o);
            this.a &= -8193;
        }
        userInfo.tshowIcon_ = this.o;
        userInfo.bitField0_ = i2;
        return userInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public ag mergeFrom(Im.UserInfo userInfo) {
        List list;
        List list2;
        List<Im.TshowInfo> list3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (userInfo != Im.UserInfo.getDefaultInstance()) {
            if (userInfo.hasUserId()) {
                a(userInfo.getUserId());
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
                b(userInfo.getSex());
            }
            if (userInfo.hasPosition()) {
                this.a |= 32;
                obj = userInfo.position_;
                this.g = obj;
            }
            if (userInfo.hasLng()) {
                a(userInfo.getLng());
            }
            if (userInfo.hasLat()) {
                b(userInfo.getLat());
            }
            if (userInfo.hasInTime()) {
                c(userInfo.getInTime());
            }
            if (userInfo.hasLoginTime()) {
                d(userInfo.getLoginTime());
            }
            if (userInfo.hasLastReplyTime()) {
                e(userInfo.getLastReplyTime());
            }
            if (userInfo.hasSysGroupId()) {
                f(userInfo.getSysGroupId());
            }
            if (userInfo.hasPermission()) {
                a(userInfo.getPermission());
            }
            list = userInfo.tshowIcon_;
            if (!list.isEmpty()) {
                if (this.o.isEmpty()) {
                    list3 = userInfo.tshowIcon_;
                    this.o = list3;
                    this.a &= -8193;
                } else {
                    i();
                    List<Im.TshowInfo> list4 = this.o;
                    list2 = userInfo.tshowIcon_;
                    list4.addAll(list2);
                }
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
    public ag mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public ag a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public ag b(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public ag a(double d) {
        this.a |= 64;
        this.h = d;
        return this;
    }

    public ag b(double d) {
        this.a |= DERTags.TAGGED;
        this.i = d;
        return this;
    }

    public ag c(int i) {
        this.a |= 256;
        this.j = i;
        return this;
    }

    public ag d(int i) {
        this.a |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        this.k = i;
        return this;
    }

    public ag e(int i) {
        this.a |= NotificationProxy.MAX_URL_LENGTH;
        this.l = i;
        return this;
    }

    public ag f(int i) {
        this.a |= 2048;
        this.m = i;
        return this;
    }

    public ag a(Im.UserPermission userPermission) {
        if ((this.a & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 4096 && this.n != Im.UserPermission.getDefaultInstance()) {
            this.n = Im.UserPermission.newBuilder(this.n).mergeFrom(userPermission).buildPartial();
        } else {
            this.n = userPermission;
        }
        this.a |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        return this;
    }

    private void i() {
        if ((this.a & 8192) != 8192) {
            this.o = new ArrayList(this.o);
            this.a |= 8192;
        }
    }
}
