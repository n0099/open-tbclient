package protobuf.AddGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.AddGroupActivity.AddGroupActivityRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<AddGroupActivityRes.DataRes, k> implements l {
    private int a;
    private int b;
    private long e;
    private Object c = "";
    private Object d = "";
    private Object f = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        AddGroupActivityRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return AddGroupActivityRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return AddGroupActivityRes.DataRes.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k b() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        this.e = 0L;
        this.a &= -9;
        this.f = "";
        this.a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final AddGroupActivityRes.DataRes buildPartial() {
        AddGroupActivityRes.DataRes dataRes = new AddGroupActivityRes.DataRes(this, (AddGroupActivityRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.groupName_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataRes.gActivityTitle_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataRes.gActivityTime_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataRes.gActivityArea_ = this.f;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(AddGroupActivityRes.DataRes dataRes) {
        Object obj;
        Object obj2;
        Object obj3;
        if (dataRes != AddGroupActivityRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasGroupId()) {
                int groupId = dataRes.getGroupId();
                this.a |= 1;
                this.b = groupId;
            }
            if (dataRes.hasGroupName()) {
                this.a |= 2;
                obj3 = dataRes.groupName_;
                this.c = obj3;
            }
            if (dataRes.hasGActivityTitle()) {
                this.a |= 4;
                obj2 = dataRes.gActivityTitle_;
                this.d = obj2;
            }
            if (dataRes.hasGActivityTime()) {
                long gActivityTime = dataRes.getGActivityTime();
                this.a |= 8;
                this.e = gActivityTime;
            }
            if (dataRes.hasGActivityArea()) {
                this.a |= 16;
                obj = dataRes.gActivityArea_;
                this.f = obj;
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
        AddGroupActivityRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                AddGroupActivityRes.DataRes parsePartialFrom = AddGroupActivityRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            AddGroupActivityRes.DataRes dataRes2 = (AddGroupActivityRes.DataRes) e.getUnfinishedMessage();
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
}
