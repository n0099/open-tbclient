package protobuf.UpdateMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<UpdateMaskInfoReq.DataReq, b> implements c {
    private int a;
    private int b;
    private int c;
    private Object d = "";

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return UpdateMaskInfoReq.DataReq.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return UpdateMaskInfoReq.DataReq.getDefaultInstance();
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
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final UpdateMaskInfoReq.DataReq build() {
        UpdateMaskInfoReq.DataReq buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public final UpdateMaskInfoReq.DataReq buildPartial() {
        UpdateMaskInfoReq.DataReq dataReq = new UpdateMaskInfoReq.DataReq(this, (UpdateMaskInfoReq.DataReq) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        dataReq.type_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        dataReq.isMask_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        dataReq.list_ = this.d;
        dataReq.bitField0_ = i2;
        return dataReq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(UpdateMaskInfoReq.DataReq dataReq) {
        Object obj;
        if (dataReq != UpdateMaskInfoReq.DataReq.getDefaultInstance()) {
            if (dataReq.hasType()) {
                a(dataReq.getType());
            }
            if (dataReq.hasIsMask()) {
                b(dataReq.getIsMask());
            }
            if (dataReq.hasList()) {
                this.a |= 4;
                obj = dataReq.list_;
                this.d = obj;
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
        UpdateMaskInfoReq.DataReq dataReq;
        Throwable th;
        try {
            try {
                UpdateMaskInfoReq.DataReq parsePartialFrom = UpdateMaskInfoReq.DataReq.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
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
            UpdateMaskInfoReq.DataReq dataReq2 = (UpdateMaskInfoReq.DataReq) e.getUnfinishedMessage();
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

    public final b a(String str) {
        if (str != null) {
            this.a |= 4;
            this.d = str;
        }
        return this;
    }
}
