package protobuf.AddGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroup.AddGroupReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<AddGroupReq.AddGroupReqIdl, b> implements c {
    private int a;
    private AddGroupReq.DataReq b = AddGroupReq.DataReq.getDefaultInstance();

    private b() {
        g();
    }

    private void g() {
    }

    public static b h() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public b clear() {
        super.clear();
        this.b = AddGroupReq.DataReq.getDefaultInstance();
        this.a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public AddGroupReq.AddGroupReqIdl getDefaultInstanceForType() {
        return AddGroupReq.AddGroupReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupReq.AddGroupReqIdl build() {
        AddGroupReq.AddGroupReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupReq.AddGroupReqIdl buildPartial() {
        AddGroupReq.AddGroupReqIdl addGroupReqIdl = new AddGroupReq.AddGroupReqIdl(this, (AddGroupReq.AddGroupReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        addGroupReqIdl.data_ = this.b;
        addGroupReqIdl.bitField0_ = i;
        return addGroupReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(AddGroupReq.AddGroupReqIdl addGroupReqIdl) {
        if (addGroupReqIdl != AddGroupReq.AddGroupReqIdl.getDefaultInstance() && addGroupReqIdl.hasData()) {
            b(addGroupReqIdl.getData());
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
        AddGroupReq.AddGroupReqIdl addGroupReqIdl;
        Throwable th;
        try {
            try {
                AddGroupReq.AddGroupReqIdl parsePartialFrom = AddGroupReq.AddGroupReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupReqIdl = null;
                if (addGroupReqIdl != null) {
                    mergeFrom(addGroupReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupReq.AddGroupReqIdl addGroupReqIdl2 = (AddGroupReq.AddGroupReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupReqIdl = addGroupReqIdl2;
                th = th3;
                if (addGroupReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(AddGroupReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public b b(AddGroupReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != AddGroupReq.DataReq.getDefaultInstance()) {
            this.b = AddGroupReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
