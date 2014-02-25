package protobuf.EnterChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.EnterChatroom.EnterChatroomRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<EnterChatroomRes.DataRes, k> implements l {
    private int a;
    private int b;
    private int c;
    private int d;
    private int f;
    private int g;
    private int h;
    private long l;
    private List<Im.UserInfo> e = Collections.emptyList();
    private Object i = "";
    private Object j = "";
    private List<EnterChatroomRes.ChatroomTopic> k = Collections.emptyList();

    private k() {
        g();
    }

    private void g() {
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = Collections.emptyList();
        this.a &= -9;
        this.f = 0;
        this.a &= -17;
        this.g = 0;
        this.a &= -33;
        this.h = 0;
        this.a &= -65;
        this.i = "";
        this.a &= -129;
        this.j = "";
        this.a &= -257;
        this.k = Collections.emptyList();
        this.a &= -513;
        this.l = 0L;
        this.a &= -1025;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public EnterChatroomRes.DataRes getDefaultInstanceForType() {
        return EnterChatroomRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public EnterChatroomRes.DataRes build() {
        EnterChatroomRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public EnterChatroomRes.DataRes buildPartial() {
        EnterChatroomRes.DataRes dataRes = new EnterChatroomRes.DataRes(this, (EnterChatroomRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.userNum_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.maxUserNum_ = this.d;
        if ((this.a & 8) == 8) {
            this.e = Collections.unmodifiableList(this.e);
            this.a &= -9;
        }
        dataRes.userList_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        dataRes.durationTime_ = this.f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        dataRes.silenceTime_ = this.g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        dataRes.averageWaitTime_ = this.h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        dataRes.title_ = this.i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        dataRes.content_ = this.j;
        if ((this.a & 512) == 512) {
            this.k = Collections.unmodifiableList(this.k);
            this.a &= -513;
        }
        dataRes.topicList_ = this.k;
        if ((i & 1024) == 1024) {
            i2 |= 256;
        }
        dataRes.lastMsgId_ = this.l;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(EnterChatroomRes.DataRes dataRes) {
        List list;
        List list2;
        List list3;
        List<EnterChatroomRes.ChatroomTopic> list4;
        Object obj;
        Object obj2;
        List list5;
        List<Im.UserInfo> list6;
        if (dataRes != EnterChatroomRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasGroupId()) {
                a(dataRes.getGroupId());
            }
            if (dataRes.hasUserNum()) {
                b(dataRes.getUserNum());
            }
            if (dataRes.hasMaxUserNum()) {
                c(dataRes.getMaxUserNum());
            }
            list = dataRes.userList_;
            if (!list.isEmpty()) {
                if (this.e.isEmpty()) {
                    list6 = dataRes.userList_;
                    this.e = list6;
                    this.a &= -9;
                } else {
                    i();
                    List<Im.UserInfo> list7 = this.e;
                    list5 = dataRes.userList_;
                    list7.addAll(list5);
                }
            }
            if (dataRes.hasDurationTime()) {
                d(dataRes.getDurationTime());
            }
            if (dataRes.hasSilenceTime()) {
                e(dataRes.getSilenceTime());
            }
            if (dataRes.hasAverageWaitTime()) {
                f(dataRes.getAverageWaitTime());
            }
            if (dataRes.hasTitle()) {
                this.a |= 128;
                obj2 = dataRes.title_;
                this.i = obj2;
            }
            if (dataRes.hasContent()) {
                this.a |= 256;
                obj = dataRes.content_;
                this.j = obj;
            }
            list2 = dataRes.topicList_;
            if (!list2.isEmpty()) {
                if (this.k.isEmpty()) {
                    list4 = dataRes.topicList_;
                    this.k = list4;
                    this.a &= -513;
                } else {
                    j();
                    List<EnterChatroomRes.ChatroomTopic> list8 = this.k;
                    list3 = dataRes.topicList_;
                    list8.addAll(list3);
                }
            }
            if (dataRes.hasLastMsgId()) {
                a(dataRes.getLastMsgId());
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
        EnterChatroomRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                EnterChatroomRes.DataRes parsePartialFrom = EnterChatroomRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                dataRes = null;
                if (dataRes != null) {
                    mergeFrom(dataRes);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            EnterChatroomRes.DataRes dataRes2 = (EnterChatroomRes.DataRes) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                dataRes = dataRes2;
                th = th3;
                if (dataRes != null) {
                }
                throw th;
            }
        }
    }

    public k a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public k b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public k c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    private void i() {
        if ((this.a & 8) != 8) {
            this.e = new ArrayList(this.e);
            this.a |= 8;
        }
    }

    public k d(int i) {
        this.a |= 16;
        this.f = i;
        return this;
    }

    public k e(int i) {
        this.a |= 32;
        this.g = i;
        return this;
    }

    public k f(int i) {
        this.a |= 64;
        this.h = i;
        return this;
    }

    private void j() {
        if ((this.a & 512) != 512) {
            this.k = new ArrayList(this.k);
            this.a |= 512;
        }
    }

    public k a(long j) {
        this.a |= 1024;
        this.l = j;
        return this;
    }
}
