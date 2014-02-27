package protobuf.AddGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.AddGroup.AddGroupRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<AddGroupRes.AddGroupResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private AddGroupRes.DataRes c = AddGroupRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        AddGroupRes.AddGroupResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return AddGroupRes.AddGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return AddGroupRes.AddGroupResIdl.getDefaultInstance();
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
        this.c = AddGroupRes.DataRes.getDefaultInstance();
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
    public AddGroupRes.AddGroupResIdl buildPartial() {
        AddGroupRes.AddGroupResIdl addGroupResIdl = new AddGroupRes.AddGroupResIdl(this, (AddGroupRes.AddGroupResIdl) null);
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
    public final h mergeFrom(AddGroupRes.AddGroupResIdl addGroupResIdl) {
        if (addGroupResIdl != AddGroupRes.AddGroupResIdl.getDefaultInstance()) {
            if (addGroupResIdl.hasError()) {
                Im.Error error = addGroupResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (addGroupResIdl.hasData()) {
                AddGroupRes.DataRes data = addGroupResIdl.getData();
                if ((this.a & 2) != 2 || this.c == AddGroupRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = AddGroupRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
}
