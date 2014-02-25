package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class al extends GeneratedMessageLite.Builder<Im.UserPermission, al> implements am {
    private int a;
    private int b;
    private int c;

    private al() {
        g();
    }

    private void g() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.UserPermission.newBuilder():protobuf.al] */
    public static /* synthetic */ al f() {
        return h();
    }

    public static al h() {
        return new al();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public al clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public al clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.UserPermission getDefaultInstanceForType() {
        return Im.UserPermission.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.UserPermission build() {
        Im.UserPermission buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.UserPermission buildPartial() {
        Im.UserPermission userPermission = new Im.UserPermission(this, (Im.UserPermission) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        userPermission.isGroupOwner_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        userPermission.isGroupManager_ = this.c;
        userPermission.bitField0_ = i2;
        return userPermission;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public al mergeFrom(Im.UserPermission userPermission) {
        if (userPermission != Im.UserPermission.getDefaultInstance()) {
            if (userPermission.hasIsGroupOwner()) {
                a(userPermission.getIsGroupOwner());
            }
            if (userPermission.hasIsGroupManager()) {
                b(userPermission.getIsGroupManager());
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
    public al mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.UserPermission userPermission;
        Throwable th;
        try {
            try {
                Im.UserPermission parsePartialFrom = Im.UserPermission.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                userPermission = null;
                if (userPermission != null) {
                    mergeFrom(userPermission);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.UserPermission userPermission2 = (Im.UserPermission) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                userPermission = userPermission2;
                th = th3;
                if (userPermission != null) {
                }
                throw th;
            }
        }
    }

    public al a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public al b(int i) {
        this.a |= 2;
        this.c = i;
        return this;
    }
}
