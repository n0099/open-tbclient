package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class e extends GeneratedMessageLite.Builder<Im.Error, e> implements f {
    private int a;
    private int b;
    private Object c = "";

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.Error buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.Error.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.Error.getDefaultInstance();
    }

    private e() {
    }

    public static /* synthetic */ e b() {
        return new e();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public e clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public e clone() {
        return new e().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.Error buildPartial() {
        Im.Error error = new Im.Error(this, (Im.Error) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        error.errorno_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        error.usermsg_ = this.c;
        error.bitField0_ = i2;
        return error;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final e mergeFrom(Im.Error error) {
        Object obj;
        if (error != Im.Error.getDefaultInstance()) {
            if (error.hasErrorno()) {
                int errorno = error.getErrorno();
                this.a |= 1;
                this.b = errorno;
            }
            if (error.hasUsermsg()) {
                this.a |= 2;
                obj = error.usermsg_;
                this.c = obj;
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
    public e mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.Error error;
        Throwable th;
        try {
            try {
                Im.Error parsePartialFrom = Im.Error.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                error = null;
                if (error != null) {
                    mergeFrom(error);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.Error error2 = (Im.Error) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                error = error2;
                th = th3;
                if (error != null) {
                }
                throw th;
            }
        }
    }
}
