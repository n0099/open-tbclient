package protobuf.DelGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<DelGroupActivityRes.DataRes, h> implements i {
    private int a;
    private int b;
    private Object c = "";
    private int d;
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        DelGroupActivityRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupActivityRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupActivityRes.DataRes.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h b() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final DelGroupActivityRes.DataRes buildPartial() {
        DelGroupActivityRes.DataRes dataRes = new DelGroupActivityRes.DataRes(this, (DelGroupActivityRes.DataRes) null);
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
        dataRes.activityId_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataRes.isEnd_ = this.e;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(DelGroupActivityRes.DataRes dataRes) {
        Object obj;
        if (dataRes != DelGroupActivityRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasGroupId()) {
                int groupId = dataRes.getGroupId();
                this.a |= 1;
                this.b = groupId;
            }
            if (dataRes.hasGroupName()) {
                this.a |= 2;
                obj = dataRes.groupName_;
                this.c = obj;
            }
            if (dataRes.hasActivityId()) {
                int activityId = dataRes.getActivityId();
                this.a |= 4;
                this.d = activityId;
            }
            if (dataRes.hasIsEnd()) {
                int isEnd = dataRes.getIsEnd();
                this.a |= 8;
                this.e = isEnd;
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DelGroupActivityRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                DelGroupActivityRes.DataRes parsePartialFrom = DelGroupActivityRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            DelGroupActivityRes.DataRes dataRes2 = (DelGroupActivityRes.DataRes) e.getUnfinishedMessage();
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
