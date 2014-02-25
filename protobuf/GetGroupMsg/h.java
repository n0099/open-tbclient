package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<GetGroupMsgRes.DataRes, h> implements i {
    private int a;
    private List<GetGroupMsgRes.GroupMsg> b = Collections.emptyList();
    private int c;

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = Collections.emptyList();
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetGroupMsgRes.DataRes getDefaultInstanceForType() {
        return GetGroupMsgRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetGroupMsgRes.DataRes build() {
        GetGroupMsgRes.DataRes buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetGroupMsgRes.DataRes buildPartial() {
        GetGroupMsgRes.DataRes dataRes = new GetGroupMsgRes.DataRes(this, (GetGroupMsgRes.DataRes) null);
        int i = this.a;
        if ((this.a & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
            this.a &= -2;
        }
        dataRes.groupMsg_ = this.b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        dataRes.allowEggs_ = this.c;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(GetGroupMsgRes.DataRes dataRes) {
        List list;
        List list2;
        List<GetGroupMsgRes.GroupMsg> list3;
        if (dataRes != GetGroupMsgRes.DataRes.getDefaultInstance()) {
            list = dataRes.groupMsg_;
            if (!list.isEmpty()) {
                if (this.b.isEmpty()) {
                    list3 = dataRes.groupMsg_;
                    this.b = list3;
                    this.a &= -2;
                } else {
                    i();
                    List<GetGroupMsgRes.GroupMsg> list4 = this.b;
                    list2 = dataRes.groupMsg_;
                    list4.addAll(list2);
                }
            }
            if (dataRes.hasAllowEggs()) {
                a(dataRes.getAllowEggs());
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
        GetGroupMsgRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                GetGroupMsgRes.DataRes parsePartialFrom = GetGroupMsgRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            GetGroupMsgRes.DataRes dataRes2 = (GetGroupMsgRes.DataRes) e.getUnfinishedMessage();
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

    private void i() {
        if ((this.a & 1) != 1) {
            this.b = new ArrayList(this.b);
            this.a |= 1;
        }
    }

    public h a(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }
}
