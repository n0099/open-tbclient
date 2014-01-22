package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite.Builder<Im.Error, c> implements d {
    private int a;
    private int b;
    private Object c = "";

    private c() {
        g();
    }

    private void g() {
    }

    public static c h() {
        return new c();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public c clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public c clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.Error getDefaultInstanceForType() {
        return Im.Error.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.Error build() {
        Im.Error buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.Error buildPartial() {
        Im.Error error = new Im.Error(this);
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
    public c mergeFrom(Im.Error error) {
        Object obj;
        if (error != Im.Error.getDefaultInstance()) {
            if (error.hasErrorno()) {
                a(error.getErrorno());
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
    public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public c a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }
}
