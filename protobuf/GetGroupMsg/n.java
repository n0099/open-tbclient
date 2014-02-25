package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<GetGroupMsgRes.GroupMsg, n> implements o {
    private int a;
    private Im.GroupInfo b = Im.GroupInfo.getDefaultInstance();
    private List<Im.MsgInfo> c = Collections.emptyList();

    private n() {
        g();
    }

    private void g() {
    }

    public static n h() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public n clear() {
        super.clear();
        this.b = Im.GroupInfo.getDefaultInstance();
        this.a &= -2;
        this.c = Collections.emptyList();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public GetGroupMsgRes.GroupMsg getDefaultInstanceForType() {
        return GetGroupMsgRes.GroupMsg.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public GetGroupMsgRes.GroupMsg build() {
        GetGroupMsgRes.GroupMsg buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public GetGroupMsgRes.GroupMsg buildPartial() {
        GetGroupMsgRes.GroupMsg groupMsg = new GetGroupMsgRes.GroupMsg(this, (GetGroupMsgRes.GroupMsg) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        groupMsg.groupInfo_ = this.b;
        if ((this.a & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
            this.a &= -3;
        }
        groupMsg.msgList_ = this.c;
        groupMsg.bitField0_ = i;
        return groupMsg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public n mergeFrom(GetGroupMsgRes.GroupMsg groupMsg) {
        List list;
        List list2;
        List<Im.MsgInfo> list3;
        if (groupMsg != GetGroupMsgRes.GroupMsg.getDefaultInstance()) {
            if (groupMsg.hasGroupInfo()) {
                a(groupMsg.getGroupInfo());
            }
            list = groupMsg.msgList_;
            if (!list.isEmpty()) {
                if (this.c.isEmpty()) {
                    list3 = groupMsg.msgList_;
                    this.c = list3;
                    this.a &= -3;
                } else {
                    i();
                    List<Im.MsgInfo> list4 = this.c;
                    list2 = groupMsg.msgList_;
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
    public n mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetGroupMsgRes.GroupMsg groupMsg;
        Throwable th;
        try {
            try {
                GetGroupMsgRes.GroupMsg parsePartialFrom = GetGroupMsgRes.GroupMsg.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                groupMsg = null;
                if (groupMsg != null) {
                    mergeFrom(groupMsg);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            GetGroupMsgRes.GroupMsg groupMsg2 = (GetGroupMsgRes.GroupMsg) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                groupMsg = groupMsg2;
                th = th3;
                if (groupMsg != null) {
                }
                throw th;
            }
        }
    }

    public n a(Im.GroupInfo groupInfo) {
        if ((this.a & 1) == 1 && this.b != Im.GroupInfo.getDefaultInstance()) {
            this.b = Im.GroupInfo.newBuilder(this.b).mergeFrom(groupInfo).buildPartial();
        } else {
            this.b = groupInfo;
        }
        this.a |= 1;
        return this;
    }

    private void i() {
        if ((this.a & 2) != 2) {
            this.c = new ArrayList(this.c);
            this.a |= 2;
        }
    }
}
