package protobuf.UpdateGroup;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<UpdateGroupRes.UpdateGroupResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private UpdateGroupRes.DataRes c = UpdateGroupRes.DataRes.getDefaultInstance();

    private h() {
        g();
    }

    private void g() {
    }

    public static h h() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public h clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = UpdateGroupRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateGroupRes.UpdateGroupResIdl getDefaultInstanceForType() {
        return UpdateGroupRes.UpdateGroupResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateGroupRes.UpdateGroupResIdl build() {
        UpdateGroupRes.UpdateGroupResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateGroupRes.UpdateGroupResIdl buildPartial() {
        UpdateGroupRes.UpdateGroupResIdl updateGroupResIdl = new UpdateGroupRes.UpdateGroupResIdl(this, (UpdateGroupRes.UpdateGroupResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        updateGroupResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        updateGroupResIdl.data_ = this.c;
        updateGroupResIdl.bitField0_ = i2;
        return updateGroupResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(UpdateGroupRes.UpdateGroupResIdl updateGroupResIdl) {
        if (updateGroupResIdl != UpdateGroupRes.UpdateGroupResIdl.getDefaultInstance()) {
            if (updateGroupResIdl.hasError()) {
                a(updateGroupResIdl.getError());
            }
            if (updateGroupResIdl.hasData()) {
                a(updateGroupResIdl.getData());
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
        UpdateGroupRes.UpdateGroupResIdl updateGroupResIdl;
        Throwable th;
        try {
            try {
                UpdateGroupRes.UpdateGroupResIdl parsePartialFrom = UpdateGroupRes.UpdateGroupResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateGroupResIdl = null;
                if (updateGroupResIdl != null) {
                    mergeFrom(updateGroupResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateGroupRes.UpdateGroupResIdl updateGroupResIdl2 = (UpdateGroupRes.UpdateGroupResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateGroupResIdl = updateGroupResIdl2;
                th = th3;
                if (updateGroupResIdl != null) {
                }
                throw th;
            }
        }
    }

    public h a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public h a(UpdateGroupRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != UpdateGroupRes.DataRes.getDefaultInstance()) {
            this.c = UpdateGroupRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
