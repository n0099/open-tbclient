package protobuf.AddGroup;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<AddGroupReq.DataReq, f> implements g {
    private int a;
    private int b;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    private Object f = "";
    private Object g = "";
    private double h;
    private double i;
    private int j;
    private int k;

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = "";
        this.a &= -9;
        this.f = "";
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
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public AddGroupReq.DataReq getDefaultInstanceForType() {
        return AddGroupReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupReq.DataReq build() {
        AddGroupReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupReq.DataReq buildPartial() {
        AddGroupReq.DataReq dataReq = new AddGroupReq.DataReq(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.forumId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.name_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.intro_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.portrait_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.position_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        dataReq.business_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        dataReq.lng_ = this.h;
        if ((i & DERTags.TAGGED) == 128) {
            i2 |= DERTags.TAGGED;
        }
        dataReq.lat_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        dataReq.groupType_ = this.j;
        if ((i & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) == 512) {
            i2 |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        }
        dataReq.flag_ = this.k;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(AddGroupReq.DataReq dataReq) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (dataReq != AddGroupReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasForumId()) {
                a(dataReq.getForumId());
            }
            if (dataReq.hasName()) {
                this.a |= 2;
                obj5 = dataReq.name_;
                this.c = obj5;
            }
            if (dataReq.hasIntro()) {
                this.a |= 4;
                obj4 = dataReq.intro_;
                this.d = obj4;
            }
            if (dataReq.hasPortrait()) {
                this.a |= 8;
                obj3 = dataReq.portrait_;
                this.e = obj3;
            }
            if (dataReq.hasPosition()) {
                this.a |= 16;
                obj2 = dataReq.position_;
                this.f = obj2;
            }
            if (dataReq.hasBusiness()) {
                this.a |= 32;
                obj = dataReq.business_;
                this.g = obj;
            }
            if (dataReq.hasLng()) {
                a(dataReq.getLng());
            }
            if (dataReq.hasLat()) {
                b(dataReq.getLat());
            }
            if (dataReq.hasGroupType()) {
                b(dataReq.getGroupType());
            }
            if (dataReq.hasFlag()) {
                c(dataReq.getFlag());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        AddGroupReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                AddGroupReq.DataReq parsePartialFrom = AddGroupReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            AddGroupReq.DataReq dataReq2 = (AddGroupReq.DataReq) e.getUnfinishedMessage();
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

    public f a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public f a(String str) {
        if (str != null) {
            this.a |= 2;
            this.c = str;
        }
        return this;
    }

    public f b(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }

    public f c(String str) {
        if (str != null) {
            this.a |= 8;
            this.e = str;
        }
        return this;
    }

    public f d(String str) {
        if (str != null) {
            this.a |= 16;
            this.f = str;
        }
        return this;
    }

    public f a(double d) {
        this.a |= 64;
        this.h = d;
        return this;
    }

    public f b(double d) {
        this.a |= DERTags.TAGGED;
        this.i = d;
        return this;
    }

    public f b(int i) {
        this.a |= 256;
        this.j = i;
        return this;
    }

    public f c(int i) {
        this.a |= ImageManager.DEFAULT_MAX_CACHEABLE_SIZE;
        this.k = i;
        return this;
    }
}
