package protobuf.EnterChatroom;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.EnterChatroom.EnterChatroomRes;
import protobuf.Im;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<EnterChatroomRes.EnterChatroomResIdl, n> implements o {
    private int a;
    private Im.Error b = Im.Error.getDefaultInstance();
    private EnterChatroomRes.DataRes c = EnterChatroomRes.DataRes.getDefaultInstance();

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        EnterChatroomRes.EnterChatroomResIdl buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return EnterChatroomRes.EnterChatroomResIdl.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return EnterChatroomRes.EnterChatroomResIdl.getDefaultInstance();
    }

    private n() {
    }

    public static /* synthetic */ n a() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public n clear() {
        super.clear();
        this.b = Im.Error.getDefaultInstance();
        this.a &= -2;
        this.c = EnterChatroomRes.DataRes.getDefaultInstance();
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public n clone() {
        return new n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public EnterChatroomRes.EnterChatroomResIdl buildPartial() {
        EnterChatroomRes.EnterChatroomResIdl enterChatroomResIdl = new EnterChatroomRes.EnterChatroomResIdl(this, (EnterChatroomRes.EnterChatroomResIdl) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        enterChatroomResIdl.error_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        enterChatroomResIdl.data_ = this.c;
        enterChatroomResIdl.bitField0_ = i2;
        return enterChatroomResIdl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final n mergeFrom(EnterChatroomRes.EnterChatroomResIdl enterChatroomResIdl) {
        if (enterChatroomResIdl != EnterChatroomRes.EnterChatroomResIdl.getDefaultInstance()) {
            if (enterChatroomResIdl.hasError()) {
                Im.Error error = enterChatroomResIdl.getError();
                if ((this.a & 1) != 1 || this.b == Im.Error.getDefaultInstance()) {
                    this.b = error;
                } else {
                    this.b = Im.Error.newBuilder(this.b).mergeFrom(error).buildPartial();
                }
                this.a |= 1;
            }
            if (enterChatroomResIdl.hasData()) {
                EnterChatroomRes.DataRes data = enterChatroomResIdl.getData();
                if ((this.a & 2) != 2 || this.c == EnterChatroomRes.DataRes.getDefaultInstance()) {
                    this.c = data;
                } else {
                    this.c = EnterChatroomRes.DataRes.newBuilder(this.c).mergeFrom(data).buildPartial();
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
    public n mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        EnterChatroomRes.EnterChatroomResIdl enterChatroomResIdl;
        Throwable th;
        try {
            try {
                EnterChatroomRes.EnterChatroomResIdl parsePartialFrom = EnterChatroomRes.EnterChatroomResIdl.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                enterChatroomResIdl = null;
                if (enterChatroomResIdl != null) {
                    mergeFrom(enterChatroomResIdl);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            EnterChatroomRes.EnterChatroomResIdl enterChatroomResIdl2 = (EnterChatroomRes.EnterChatroomResIdl) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                enterChatroomResIdl = enterChatroomResIdl2;
                th = th3;
                if (enterChatroomResIdl != null) {
                }
                throw th;
            }
        }
    }
}
