package protobuf.AddGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.AddGroup.AddGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class j extends GeneratedMessageLite.Builder<AddGroupRes.AddGroupResIdl, j> implements k {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private AddGroupRes.DataRes c = AddGroupRes.DataRes.getDefaultInstance();

    private j() {
        g();
    }

    private void g() {
    }

    public static j h() {
        return new j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public j clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = AddGroupRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public j clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public AddGroupRes.AddGroupResIdl getDefaultInstanceForType() {
        return AddGroupRes.AddGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public AddGroupRes.AddGroupResIdl build() {
        AddGroupRes.AddGroupResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public AddGroupRes.AddGroupResIdl buildPartial() {
        AddGroupRes.AddGroupResIdl addGroupResIdl = new AddGroupRes.AddGroupResIdl(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        addGroupResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        addGroupResIdl.data_ = this.c;
        addGroupResIdl.bitField0_ = i2;
        return addGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public j mergeFrom(AddGroupRes.AddGroupResIdl addGroupResIdl) {
        if (addGroupResIdl != AddGroupRes.AddGroupResIdl.getDefaultInstance()) {
            if (addGroupResIdl.hasError()) {
                a(addGroupResIdl.getError());
            }
            if (addGroupResIdl.hasData()) {
                a(addGroupResIdl.getData());
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
    public j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        AddGroupRes.AddGroupResIdl addGroupResIdl;
        Throwable th;
        try {
            try {
                AddGroupRes.AddGroupResIdl parsePartialFrom = AddGroupRes.AddGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupResIdl = null;
                if (addGroupResIdl != null) {
                    mergeFrom(addGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupRes.AddGroupResIdl addGroupResIdl2 = (AddGroupRes.AddGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupResIdl = addGroupResIdl2;
                th = th3;
                if (addGroupResIdl != null) {
                }
                throw th;
            }
        }
    }

    public j a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public j a(AddGroupRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != AddGroupRes.DataRes.getDefaultInstance()) {
            this.c = AddGroupRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
