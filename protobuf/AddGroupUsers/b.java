package protobuf.AddGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroupUsers.AddGroupUsersReq;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<AddGroupUsersReq.AddGroupUsersReqIdl, b> implements c {
    private int a;
    private AddGroupUsersReq.DataReq b = AddGroupUsersReq.DataReq.getDefaultInstance();

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
        this.b = AddGroupUsersReq.DataReq.getDefaultInstance();
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
    public AddGroupUsersReq.AddGroupUsersReqIdl getDefaultInstanceForType() {
        return AddGroupUsersReq.AddGroupUsersReqIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupUsersReq.AddGroupUsersReqIdl build() {
        AddGroupUsersReq.AddGroupUsersReqIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupUsersReq.AddGroupUsersReqIdl buildPartial() {
        AddGroupUsersReq.AddGroupUsersReqIdl addGroupUsersReqIdl = new AddGroupUsersReq.AddGroupUsersReqIdl(this, (AddGroupUsersReq.AddGroupUsersReqIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        addGroupUsersReqIdl.data_ = this.b;
        addGroupUsersReqIdl.bitField0_ = i;
        return addGroupUsersReqIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public b mergeFrom(AddGroupUsersReq.AddGroupUsersReqIdl addGroupUsersReqIdl) {
        if (addGroupUsersReqIdl != AddGroupUsersReq.AddGroupUsersReqIdl.getDefaultInstance() && addGroupUsersReqIdl.hasData()) {
            b(addGroupUsersReqIdl.getData());
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
        AddGroupUsersReq.AddGroupUsersReqIdl addGroupUsersReqIdl;
        Throwable th;
        try {
            try {
                AddGroupUsersReq.AddGroupUsersReqIdl parsePartialFrom = AddGroupUsersReq.AddGroupUsersReqIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupUsersReqIdl = null;
                if (addGroupUsersReqIdl != null) {
                    mergeFrom(addGroupUsersReqIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupUsersReq.AddGroupUsersReqIdl addGroupUsersReqIdl2 = (AddGroupUsersReq.AddGroupUsersReqIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupUsersReqIdl = addGroupUsersReqIdl2;
                th = th3;
                if (addGroupUsersReqIdl != null) {
                }
                throw th;
            }
        }
    }

    public b a(AddGroupUsersReq.DataReq dataReq) {
        if (dataReq != null) {
            this.b = dataReq;
            this.a |= 1;
        }
        return this;
    }

    public b b(AddGroupUsersReq.DataReq dataReq) {
        if ((this.a & 1) == 1 && this.b != AddGroupUsersReq.DataReq.getDefaultInstance()) {
            this.b = AddGroupUsersReq.DataReq.newBuilder(this.b).mergeFrom(dataReq).buildPartial();
        } else {
            this.b = dataReq;
        }
        this.a |= 1;
        return this;
    }
}
