package protobuf.GetMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.GetMaskInfo.GetMaskInfoRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<GetMaskInfoRes.DataRes, h> implements i {
    private int a;
    private int b;
    private Object c = "";
    private List<GetMaskInfoRes.UserInfo> d = Collections.emptyList();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        GetMaskInfoRes.DataRes buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return GetMaskInfoRes.DataRes.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return GetMaskInfoRes.DataRes.getDefaultInstance();
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
        this.d = Collections.emptyList();
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final GetMaskInfoRes.DataRes buildPartial() {
        GetMaskInfoRes.DataRes dataRes = new GetMaskInfoRes.DataRes(this, (GetMaskInfoRes.DataRes) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataRes.isMask_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataRes.list_ = this.c;
        if ((this.a & 4) == 4) {
            this.d = Collections.unmodifiableList(this.d);
            this.a &= -5;
        }
        dataRes.users_ = this.d;
        dataRes.bitField0_ = i2;
        return dataRes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(GetMaskInfoRes.DataRes dataRes) {
        List list;
        List list2;
        List<GetMaskInfoRes.UserInfo> list3;
        Object obj;
        if (dataRes != GetMaskInfoRes.DataRes.getDefaultInstance()) {
            if (dataRes.hasIsMask()) {
                int isMask = dataRes.getIsMask();
                this.a |= 1;
                this.b = isMask;
            }
            if (dataRes.hasList()) {
                this.a |= 2;
                obj = dataRes.list_;
                this.c = obj;
            }
            list = dataRes.users_;
            if (!list.isEmpty()) {
                if (this.d.isEmpty()) {
                    list3 = dataRes.users_;
                    this.d = list3;
                    this.a &= -5;
                } else {
                    if ((this.a & 4) != 4) {
                        this.d = new ArrayList(this.d);
                        this.a |= 4;
                    }
                    List<GetMaskInfoRes.UserInfo> list4 = this.d;
                    list2 = dataRes.users_;
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetMaskInfoRes.DataRes dataRes;
        Throwable th;
        try {
            try {
                GetMaskInfoRes.DataRes parsePartialFrom = GetMaskInfoRes.DataRes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            GetMaskInfoRes.DataRes dataRes2 = (GetMaskInfoRes.DataRes) e.getUnfinishedMessage();
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
