package protobuf.GetGroupMsg;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import protobuf.GetGroupMsg.GetGroupMsgReq;
import protobuf.Im;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<GetGroupMsgReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Object f = "";
    private List<Im.GroupLastId> g = Collections.emptyList();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return GetGroupMsgReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return GetGroupMsgReq.DataReq.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b c() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clear() {
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
        this.g = Collections.emptyList();
        this.a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final GetGroupMsgReq.DataReq build() {
        GetGroupMsgReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final GetGroupMsgReq.DataReq buildPartial() {
        GetGroupMsgReq.DataReq dataReq = new GetGroupMsgReq.DataReq(this, (GetGroupMsgReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.width_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.height_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.smallWidth_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        dataReq.smallHeight_ = this.e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        dataReq.pushTimes_ = this.f;
        if ((this.a & 32) == 32) {
            this.g = Collections.unmodifiableList(this.g);
            this.a &= -33;
        }
        dataReq.groupMids_ = this.g;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(GetGroupMsgReq.DataReq dataReq) {
        List list;
        List list2;
        List<Im.GroupLastId> list3;
        Object obj;
        if (dataReq != GetGroupMsgReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasWidth()) {
                a(dataReq.getWidth());
            }
            if (dataReq.hasHeight()) {
                b(dataReq.getHeight());
            }
            if (dataReq.hasSmallWidth()) {
                c(dataReq.getSmallWidth());
            }
            if (dataReq.hasSmallHeight()) {
                d(dataReq.getSmallHeight());
            }
            if (dataReq.hasPushTimes()) {
                this.a |= 16;
                obj = dataReq.pushTimes_;
                this.f = obj;
            }
            list = dataReq.groupMids_;
            if (!list.isEmpty()) {
                if (this.g.isEmpty()) {
                    list3 = dataReq.groupMids_;
                    this.g = list3;
                    this.a &= -33;
                } else {
                    f();
                    List<Im.GroupLastId> list4 = this.g;
                    list2 = dataReq.groupMids_;
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        GetGroupMsgReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                GetGroupMsgReq.DataReq parsePartialFrom = GetGroupMsgReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            GetGroupMsgReq.DataReq dataReq2 = (GetGroupMsgReq.DataReq) e.getUnfinishedMessage();
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

    public final b a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public final b b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }

    public final b c(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public final b d(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }

    public final b a(String str) {
        if (str != null) {
            this.a |= 16;
            this.f = str;
        }
        return this;
    }

    private void f() {
        if ((this.a & 32) != 32) {
            this.g = new ArrayList(this.g);
            this.a |= 32;
        }
    }

    public final b a(protobuf.n nVar) {
        f();
        this.g.add(nVar.build());
        return this;
    }
}
