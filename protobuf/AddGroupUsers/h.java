package protobuf.AddGroupUsers;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.AddGroupUsers.AddGroupUsersRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<AddGroupUsersRes.AddGroupUsersResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private AddGroupUsersRes.DataRes c = AddGroupUsersRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        AddGroupUsersRes.AddGroupUsersResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return AddGroupUsersRes.AddGroupUsersResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return AddGroupUsersRes.AddGroupUsersResIdl.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h a() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = AddGroupUsersRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupUsersRes.AddGroupUsersResIdl buildPartial() {
        AddGroupUsersRes.AddGroupUsersResIdl addGroupUsersResIdl = new AddGroupUsersRes.AddGroupUsersResIdl(this, (AddGroupUsersRes.AddGroupUsersResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        addGroupUsersResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        addGroupUsersResIdl.data_ = this.c;
        addGroupUsersResIdl.bitField0_ = i2;
        return addGroupUsersResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(AddGroupUsersRes.AddGroupUsersResIdl addGroupUsersResIdl) {
        if (addGroupUsersResIdl != AddGroupUsersRes.AddGroupUsersResIdl.getDefaultInstance()) {
            if (addGroupUsersResIdl.hasError()) {
                Im.Error error = addGroupUsersResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (addGroupUsersResIdl.hasData()) {
                AddGroupUsersRes.DataRes data = addGroupUsersResIdl.getData();
                if ((this.a & 2) != 2 || this.c == AddGroupUsersRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = AddGroupUsersRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
                }
                this.a |= 2;
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
        AddGroupUsersRes.AddGroupUsersResIdl addGroupUsersResIdl;
        Throwable th;
        try {
            try {
                AddGroupUsersRes.AddGroupUsersResIdl parsePartialFrom = AddGroupUsersRes.AddGroupUsersResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupUsersResIdl = null;
                if (addGroupUsersResIdl != null) {
                    mergeFrom(addGroupUsersResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupUsersRes.AddGroupUsersResIdl addGroupUsersResIdl2 = (AddGroupUsersRes.AddGroupUsersResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupUsersResIdl = addGroupUsersResIdl2;
                th = th3;
                if (addGroupUsersResIdl != null) {
                }
                throw th;
            }
        }
    }
}
