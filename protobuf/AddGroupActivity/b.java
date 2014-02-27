package protobuf.AddGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.AddGroupActivity.AddGroupActivityReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<AddGroupActivityReq.AddGroupActivityReqIdl, b> implements c {
    private int a;
    private AddGroupActivityReq.DataReq b = AddGroupActivityReq.DataReq.getDefaultInstance();

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return AddGroupActivityReq.AddGroupActivityReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return AddGroupActivityReq.AddGroupActivityReqIdl.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b b() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public b clear() {
        super.clear();
        this.b = AddGroupActivityReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final AddGroupActivityReq.AddGroupActivityReqIdl build() {
        AddGroupActivityReq.AddGroupActivityReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupActivityReq.AddGroupActivityReqIdl buildPartial() {
        AddGroupActivityReq.AddGroupActivityReqIdl addGroupActivityReqIdl = new AddGroupActivityReq.AddGroupActivityReqIdl(this, (AddGroupActivityReq.AddGroupActivityReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        addGroupActivityReqIdl.data_ = this.b;
        addGroupActivityReqIdl.bitField0_ = i;
        return addGroupActivityReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(AddGroupActivityReq.AddGroupActivityReqIdl addGroupActivityReqIdl) {
        if (addGroupActivityReqIdl != AddGroupActivityReq.AddGroupActivityReqIdl.getDefaultInstance() && addGroupActivityReqIdl.hasData()) {
            AddGroupActivityReq.DataReq data = addGroupActivityReqIdl.getData();
            if ((this.a & 1) != 1 || this.b == AddGroupActivityReq.DataReq.getDefaultInstance()) {
                this.b = data;
            } else {
                this.b = AddGroupActivityReq.DataReq.newBuilder(this.b).mergeFrom(data).buildPartial();
            }
            this.a |= 1;
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
        AddGroupActivityReq.AddGroupActivityReqIdl addGroupActivityReqIdl;
        Throwable th;
        try {
            try {
                AddGroupActivityReq.AddGroupActivityReqIdl parsePartialFrom = AddGroupActivityReq.AddGroupActivityReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupActivityReqIdl = null;
                if (addGroupActivityReqIdl != null) {
                    mergeFrom(addGroupActivityReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupActivityReq.AddGroupActivityReqIdl addGroupActivityReqIdl2 = (AddGroupActivityReq.AddGroupActivityReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupActivityReqIdl = addGroupActivityReqIdl2;
                th = th3;
                if (addGroupActivityReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public final b a(AddGroupActivityReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }
}
