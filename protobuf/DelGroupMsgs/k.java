package protobuf.DelGroupMsgs;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class k extends GeneratedMessageLite.Builder<DelGroupMsgsRes.DelGroupMsgsResIdl, k> implements l {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private DelGroupMsgsRes.DataRes c = DelGroupMsgsRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        DelGroupMsgsRes.DelGroupMsgsResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return DelGroupMsgsRes.DelGroupMsgsResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return DelGroupMsgsRes.DelGroupMsgsResIdl.getDefaultInstance();
    }

    private k() {
    }

    public static /* synthetic */ k a() {
        return new k();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public k clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = DelGroupMsgsRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public k clone() {
        return new k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public DelGroupMsgsRes.DelGroupMsgsResIdl buildPartial() {
        DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl = new DelGroupMsgsRes.DelGroupMsgsResIdl(this, (DelGroupMsgsRes.DelGroupMsgsResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        delGroupMsgsResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        delGroupMsgsResIdl.data_ = this.c;
        delGroupMsgsResIdl.bitField0_ = i2;
        return delGroupMsgsResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final k mergeFrom(DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl) {
        if (delGroupMsgsResIdl != DelGroupMsgsRes.DelGroupMsgsResIdl.getDefaultInstance()) {
            if (delGroupMsgsResIdl.hasError()) {
                Im.Error error = delGroupMsgsResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (delGroupMsgsResIdl.hasData()) {
                DelGroupMsgsRes.DataRes data = delGroupMsgsResIdl.getData();
                if ((this.a & 2) != 2 || this.c == DelGroupMsgsRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = DelGroupMsgsRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
    public k mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl;
        Throwable th;
        try {
            try {
                DelGroupMsgsRes.DelGroupMsgsResIdl parsePartialFrom = DelGroupMsgsRes.DelGroupMsgsResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                delGroupMsgsResIdl = null;
                if (delGroupMsgsResIdl != null) {
                    mergeFrom(delGroupMsgsResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            DelGroupMsgsRes.DelGroupMsgsResIdl delGroupMsgsResIdl2 = (DelGroupMsgsRes.DelGroupMsgsResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                delGroupMsgsResIdl = delGroupMsgsResIdl2;
                th = th3;
                if (delGroupMsgsResIdl != null) {
                }
                throw th;
            }
        }
    }
}
