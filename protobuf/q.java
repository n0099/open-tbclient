package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class q extends GeneratedMessageLite.Builder<Im.GroupPermission, q> implements r {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Object f = "";
    private Object g = "";
    private Object h = "";
    private int i;
    private int j;
    private int k;

    private q() {
        g();
    }

    private void g() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.GroupPermission.newBuilder():protobuf.q] */
    public static /* synthetic */ q f() {
        return h();
    }

    public static q h() {
        return new q();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public q clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        this.g = "";
        this.a &= -33;
        this.h = "";
        this.a &= -65;
        this.i = 0;
        this.a &= -129;
        this.j = 0;
        this.a &= -257;
        this.k = 0;
        this.a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public q clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.GroupPermission getDefaultInstanceForType() {
        return Im.GroupPermission.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GroupPermission build() {
        Im.GroupPermission buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GroupPermission buildPartial() {
        Im.GroupPermission groupPermission = new Im.GroupPermission(this, (Im.GroupPermission) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        groupPermission.isForumManager_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        groupPermission.canCreateNormal_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        groupPermission.canCreateOfficial_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        groupPermission.canCreatePersonal_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        groupPermission.createNormalTip_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        groupPermission.createOfficialTip_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        groupPermission.createPersonalTip_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        groupPermission.canCreateNormalNum_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        groupPermission.canCreateOfficialNum_ = this.j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        groupPermission.canCreatePersonalNum_ = this.k;
        groupPermission.bitField0_ = i2;
        return groupPermission;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public q mergeFrom(Im.GroupPermission groupPermission) {
        Object obj;
        Object obj2;
        Object obj3;
        if (groupPermission != Im.GroupPermission.getDefaultInstance()) {
            if (groupPermission.hasIsForumManager()) {
                a(groupPermission.getIsForumManager());
            }
            if (groupPermission.hasCanCreateNormal()) {
                b(groupPermission.getCanCreateNormal());
            }
            if (groupPermission.hasCanCreateOfficial()) {
                c(groupPermission.getCanCreateOfficial());
            }
            if (groupPermission.hasCanCreatePersonal()) {
                d(groupPermission.getCanCreatePersonal());
            }
            if (groupPermission.hasCreateNormalTip()) {
                this.a |= 16;
                obj3 = groupPermission.createNormalTip_;
                this.f = obj3;
            }
            if (groupPermission.hasCreateOfficialTip()) {
                this.a |= 32;
                obj2 = groupPermission.createOfficialTip_;
                this.g = obj2;
            }
            if (groupPermission.hasCreatePersonalTip()) {
                this.a |= 64;
                obj = groupPermission.createPersonalTip_;
                this.h = obj;
            }
            if (groupPermission.hasCanCreateNormalNum()) {
                e(groupPermission.getCanCreateNormalNum());
            }
            if (groupPermission.hasCanCreateOfficialNum()) {
                f(groupPermission.getCanCreateOfficialNum());
            }
            if (groupPermission.hasCanCreatePersonalNum()) {
                g(groupPermission.getCanCreatePersonalNum());
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
    public q mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.GroupPermission groupPermission;
        Throwable th;
        try {
            try {
                Im.GroupPermission parsePartialFrom = Im.GroupPermission.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                groupPermission = null;
                if (groupPermission != null) {
                    mergeFrom(groupPermission);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.GroupPermission groupPermission2 = (Im.GroupPermission) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                groupPermission = groupPermission2;
                th = th3;
                if (groupPermission != null) {
                }
                throw th;
            }
        }
    }

    public q a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public q b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public q c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public q d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public q e(int i) {
        this.a |= 128;
        this.i = i;
        return this;
    }

    public q f(int i) {
        this.a |= 256;
        this.j = i;
        return this;
    }

    public q g(int i) {
        this.a |= 512;
        this.k = i;
        return this;
    }
}
