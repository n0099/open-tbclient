package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class l extends GeneratedMessageLite.Builder<Im.GroupLastId, l> implements m {
    private int a;
    private int b;
    private long c;

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.GroupLastId.newBuilder():protobuf.l] */
    public static /* synthetic */ l f() {
        return h();
    }

    private l() {
        g();
    }

    private void g() {
    }

    public static l h() {
        return new l();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public l clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = 0L;
        this.a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public l clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.GroupLastId getDefaultInstanceForType() {
        return Im.GroupLastId.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GroupLastId build() {
        Im.GroupLastId buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GroupLastId buildPartial() {
        Im.GroupLastId groupLastId = new Im.GroupLastId(this);
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
    public l mergeFrom(Im.GroupLastId groupLastId) {
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
    public l mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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

    public l a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public l a(long j) {
        this.a |= 2;
        this.c = j;
        return this;
    }
}
