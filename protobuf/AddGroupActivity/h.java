package protobuf.AddGroupActivity;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.AddGroupActivity.AddGroupActivityRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<AddGroupActivityRes.AddGroupActivityResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private AddGroupActivityRes.DataRes c = AddGroupActivityRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        AddGroupActivityRes.AddGroupActivityResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return AddGroupActivityRes.AddGroupActivityResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return AddGroupActivityRes.AddGroupActivityResIdl.getDefaultInstance();
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
        this.c = AddGroupActivityRes.DataRes.getDefaultInstance();
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
    public AddGroupActivityRes.AddGroupActivityResIdl buildPartial() {
        AddGroupActivityRes.AddGroupActivityResIdl addGroupActivityResIdl = new AddGroupActivityRes.AddGroupActivityResIdl(this, (AddGroupActivityRes.AddGroupActivityResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        addGroupActivityResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        addGroupActivityResIdl.data_ = this.c;
        addGroupActivityResIdl.bitField0_ = i2;
        return addGroupActivityResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final h mergeFrom(AddGroupActivityRes.AddGroupActivityResIdl addGroupActivityResIdl) {
        if (addGroupActivityResIdl != AddGroupActivityRes.AddGroupActivityResIdl.getDefaultInstance()) {
            if (addGroupActivityResIdl.hasError()) {
                Im.Error error = addGroupActivityResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (addGroupActivityResIdl.hasData()) {
                AddGroupActivityRes.DataRes data = addGroupActivityResIdl.getData();
                if ((this.a & 2) != 2 || this.c == AddGroupActivityRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = AddGroupActivityRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
        AddGroupActivityRes.AddGroupActivityResIdl addGroupActivityResIdl;
        Throwable th;
        try {
            try {
                AddGroupActivityRes.AddGroupActivityResIdl parsePartialFrom = AddGroupActivityRes.AddGroupActivityResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                addGroupActivityResIdl = null;
                if (addGroupActivityResIdl != null) {
                    mergeFrom(addGroupActivityResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            AddGroupActivityRes.AddGroupActivityResIdl addGroupActivityResIdl2 = (AddGroupActivityRes.AddGroupActivityResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                addGroupActivityResIdl = addGroupActivityResIdl2;
                th = th3;
                if (addGroupActivityResIdl != null) {
                }
                throw th;
            }
        }
    }
}
