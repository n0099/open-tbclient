package protobuf.UpdateClientInfo;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
import protobuf.UpdateClientInfo.UpdateClientInfoRes;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<UpdateClientInfoRes.UpdateClientInfoResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private UpdateClientInfoRes.DataRes c = UpdateClientInfoRes.DataRes.getDefaultInstance();

    private k() {
        g();
    }

    private void g() {
    }

    public static k h() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = UpdateClientInfoRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public UpdateClientInfoRes.UpdateClientInfoResIdl getDefaultInstanceForType() {
        return UpdateClientInfoRes.UpdateClientInfoResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public UpdateClientInfoRes.UpdateClientInfoResIdl build() {
        UpdateClientInfoRes.UpdateClientInfoResIdl buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public UpdateClientInfoRes.UpdateClientInfoResIdl buildPartial() {
        UpdateClientInfoRes.UpdateClientInfoResIdl updateClientInfoResIdl = new UpdateClientInfoRes.UpdateClientInfoResIdl(this, (UpdateClientInfoRes.UpdateClientInfoResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        updateClientInfoResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        updateClientInfoResIdl.data_ = this.c;
        updateClientInfoResIdl.bitField0_ = i2;
        return updateClientInfoResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public k mergeFrom(UpdateClientInfoRes.UpdateClientInfoResIdl updateClientInfoResIdl) {
        if (updateClientInfoResIdl != UpdateClientInfoRes.UpdateClientInfoResIdl.getDefaultInstance()) {
            if (updateClientInfoResIdl.hasError()) {
                a(updateClientInfoResIdl.getError());
            }
            if (updateClientInfoResIdl.hasData()) {
                a(updateClientInfoResIdl.getData());
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UpdateClientInfoRes.UpdateClientInfoResIdl updateClientInfoResIdl;
        Throwable th;
        try {
            try {
                UpdateClientInfoRes.UpdateClientInfoResIdl parsePartialFrom = UpdateClientInfoRes.UpdateClientInfoResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                updateClientInfoResIdl = null;
                if (updateClientInfoResIdl != null) {
                    mergeFrom(updateClientInfoResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            UpdateClientInfoRes.UpdateClientInfoResIdl updateClientInfoResIdl2 = (UpdateClientInfoRes.UpdateClientInfoResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                updateClientInfoResIdl = updateClientInfoResIdl2;
                th = th3;
                if (updateClientInfoResIdl != null) {
                }
                throw th;
            }
        }
    }

    public k a(Im.Error error) {
        if ((this.a & 1) == 1 && this.b != Im.Error.getDefaultInstance()) {
            this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
        } else {
            this.b = error;
        }
        this.a |= 1;
        return this;
    }

    public k a(UpdateClientInfoRes.DataRes dataRes) {
        if ((this.a & 2) == 2 && this.c != UpdateClientInfoRes.DataRes.getDefaultInstance()) {
            this.c = UpdateClientInfoRes.DataRes.newBuilder(this.c).mergeFrom(dataRes).buildPartial();
        } else {
            this.c = dataRes;
        }
        this.a |= 2;
        return this;
    }
}
