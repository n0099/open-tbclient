package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class n extends GeneratedMessageLite.Builder<Im.GroupLastId, n> implements o {
    private int a;
    private int b;
    private long c;

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.GroupLastId.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.GroupLastId.getDefaultInstance();
    }

    private n() {
    }

    public static /* synthetic */ n b() {
        return new n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public n clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0L;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public n clone() {
        return new n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public final Im.GroupLastId build() {
        Im.GroupLastId buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GroupLastId buildPartial() {
        Im.GroupLastId groupLastId = new Im.GroupLastId(this, (Im.GroupLastId) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        groupLastId.groupId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        groupLastId.lastMsgId_ = this.c;
        groupLastId.bitField0_ = i2;
        return groupLastId;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final n mergeFrom(Im.GroupLastId groupLastId) {
        if (groupLastId != Im.GroupLastId.getDefaultInstance()) {
            if (groupLastId.hasGroupId()) {
                a(groupLastId.getGroupId());
            }
            if (groupLastId.hasLastMsgId()) {
                a(groupLastId.getLastMsgId());
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
        Im.GroupLastId groupLastId;
        Throwable th;
        try {
            try {
                Im.GroupLastId parsePartialFrom = Im.GroupLastId.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                groupLastId = null;
                if (groupLastId != null) {
                    mergeFrom(groupLastId);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.GroupLastId groupLastId2 = (Im.GroupLastId) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                groupLastId = groupLastId2;
                th = th3;
                if (groupLastId != null) {
                }
                throw th;
            }
        }
    }

    public final n a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public final n a(long j) {
        this.a |= 2;
        this.c = j;
        return this;
    }
}
