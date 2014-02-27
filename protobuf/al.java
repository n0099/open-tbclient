package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class al extends GeneratedMessageLite.Builder<Im.UserPermission, al> implements am {
    private int a;
    private int b;
    private int c;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.UserPermission buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.UserPermission.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.UserPermission.getDefaultInstance();
    }

    private al() {
    }

    public static /* synthetic */ al b() {
        return new al();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public al clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public al clone() {
        return new al().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.UserPermission buildPartial() {
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
    public final al mergeFrom(Im.UserPermission userPermission) {
        if (userPermission != Im.UserPermission.getDefaultInstance()) {
            if (userPermission.hasIsGroupOwner()) {
                int isGroupOwner = userPermission.getIsGroupOwner();
                this.a |= 1;
                this.b = isGroupOwner;
            }
            if (userPermission.hasIsGroupManager()) {
                int isGroupManager = userPermission.getIsGroupManager();
                this.a |= 2;
                this.c = isGroupManager;
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
}
