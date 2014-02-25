package protobuf.UpdateMaskInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.UpdateMaskInfo.UpdateMaskInfoRes;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<UpdateMaskInfoRes.UpdateMaskInfoResIdl, h> implements i {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();

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
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateMaskInfoRes.UpdateMaskInfoResIdl getDefaultInstanceForType() {
        return UpdateMaskInfoRes.UpdateMaskInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateMaskInfoRes.UpdateMaskInfoResIdl build() {
        UpdateMaskInfoRes.UpdateMaskInfoResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateMaskInfoRes.UpdateMaskInfoResIdl buildPartial() {
        UpdateMaskInfoRes.UpdateMaskInfoResIdl updateMaskInfoResIdl = new UpdateMaskInfoRes.UpdateMaskInfoResIdl(this, (UpdateMaskInfoRes.UpdateMaskInfoResIdl) null);
        int i = (this.a & 1) != 1 ? 0 : 1;
        updateMaskInfoResIdl.error_ = this.b;
        updateMaskInfoResIdl.bitField0_ = i;
        return updateMaskInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public h mergeFrom(UpdateMaskInfoRes.UpdateMaskInfoResIdl updateMaskInfoResIdl) {
        if (updateMaskInfoResIdl != UpdateMaskInfoRes.UpdateMaskInfoResIdl.getDefaultInstance() && updateMaskInfoResIdl.hasError()) {
            a(updateMaskInfoResIdl.getError());
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
        UpdateMaskInfoRes.UpdateMaskInfoResIdl updateMaskInfoResIdl;
        Throwable th;
        try {
            try {
                UpdateMaskInfoRes.UpdateMaskInfoResIdl parsePartialFrom = UpdateMaskInfoRes.UpdateMaskInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateMaskInfoResIdl = null;
                if (updateMaskInfoResIdl != null) {
                    mergeFrom(updateMaskInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateMaskInfoRes.UpdateMaskInfoResIdl updateMaskInfoResIdl2 = (UpdateMaskInfoRes.UpdateMaskInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateMaskInfoResIdl = updateMaskInfoResIdl2;
                th = th3;
                if (updateMaskInfoResIdl != null) {
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
}
