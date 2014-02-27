package protobuf.UpdateClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.Im;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<UpdateClientInfoRes.DataRes, h> implements i {
    private int a;
    private List<Im.GroupInfo> b = Collections.emptyList();
    private Im.UserInfo c = Im.UserInfo.getDefaultInstance();
    private Im.MaskInfo d = Im.MaskInfo.getDefaultInstance();
    private List<Integer> e = Collections.emptyList();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        UpdateClientInfoRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateClientInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateClientInfoRes.DataRes.getDefaultInstance();
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
        this.b = Collections.emptyList();
        this.a &= -2;
        this.c = Im.UserInfo.getDefaultInstance();
        this.a &= -3;
        this.d = Im.MaskInfo.getDefaultInstance();
        this.a &= -5;
        this.e = Collections.emptyList();
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
    public final UpdateClientInfoRes.DataRes buildPartial() {
        UpdateClientInfoRes.DataRes dataRes = new UpdateClientInfoRes.DataRes(this, (UpdateClientInfoRes.DataRes) null);
        int i = this.a;
        if ((this.a & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
            this.a &= -2;
        }
        dataRes.groupInfo_ = this.b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        dataRes.userInfo_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        dataRes.maskInfo_ = this.d;
        if ((this.a & 8) == 8) {
            this.e = Collections.unmodifiableList(this.e);
            this.a &= -9;
        }
        dataRes.heartbeatInterval_ = this.e;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(UpdateClientInfoRes.DataRes dataRes) {
        List list;
        List list2;
        List list3;
        List<Integer> list4;
        List list5;
        List<Im.GroupInfo> list6;
        if (dataRes != UpdateClientInfoRes.DataRes.getDefaultInstance()) {
            list = dataRes.groupInfo_;
            if (!list.isEmpty()) {
                if (this.b.isEmpty()) {
                    list6 = dataRes.groupInfo_;
                    this.b = list6;
                    this.a &= -2;
                } else {
                    if ((this.a & 1) != 1) {
                        this.b = new ArrayList(this.b);
                        this.a |= 1;
                    }
                    List<Im.GroupInfo> list7 = this.b;
                    list5 = dataRes.groupInfo_;
                    list7.addAll(list5);
                }
            }
            if (dataRes.hasUserInfo()) {
                Im.UserInfo userInfo = dataRes.getUserInfo();
                if ((this.a & 2) != 2 || this.c == Im.UserInfo.getDefaultInstance()) {
                    this.c = userInfo;
                } else {
                    this.c = Im.UserInfo.newBuilder(this.c).mergeFrom(userInfo).buildPartial();
                }
                this.a |= 2;
            }
            if (dataRes.hasMaskInfo()) {
                Im.MaskInfo maskInfo = dataRes.getMaskInfo();
                if ((this.a & 4) != 4 || this.d == Im.MaskInfo.getDefaultInstance()) {
                    this.d = maskInfo;
                } else {
                    this.d = Im.MaskInfo.newBuilder(this.d).mergeFrom(maskInfo).buildPartial();
                }
                this.a |= 4;
            }
            list2 = dataRes.heartbeatInterval_;
            if (!list2.isEmpty()) {
                if (this.e.isEmpty()) {
                    list4 = dataRes.heartbeatInterval_;
                    this.e = list4;
                    this.a &= -9;
                } else {
                    if ((this.a & 8) != 8) {
                        this.e = new ArrayList(this.e);
                        this.a |= 8;
                    }
                    List<Integer> list8 = this.e;
                    list3 = dataRes.heartbeatInterval_;
                    list8.addAll(list3);
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UpdateClientInfoRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                UpdateClientInfoRes.DataRes parsePartialFrom = UpdateClientInfoRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            UpdateClientInfoRes.DataRes dataRes2 = (UpdateClientInfoRes.DataRes) e.getUnfinishedMessage();
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
