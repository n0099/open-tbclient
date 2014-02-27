package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class b extends GeneratedMessageLite.Builder<Im.ActivityInfo, b> implements c {
    private int a;
    private int b;
    private Object c = "";
    private int d;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.ActivityInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.ActivityInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.ActivityInfo.getDefaultInstance();
    }

    private b() {
    }

    public static /* synthetic */ b a() {
        return new b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public b clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: c */
    public b clone() {
        return new b().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.ActivityInfo buildPartial() {
        Im.ActivityInfo activityInfo = new Im.ActivityInfo(this, (Im.ActivityInfo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        activityInfo.activityId_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        activityInfo.activityTitle_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        activityInfo.isEnd_ = this.d;
        activityInfo.bitField0_ = i2;
        return activityInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public final b mergeFrom(Im.ActivityInfo activityInfo) {
        Object obj;
        if (activityInfo != Im.ActivityInfo.getDefaultInstance()) {
            if (activityInfo.hasActivityId()) {
                int activityId = activityInfo.getActivityId();
                this.a |= 1;
                this.b = activityId;
            }
            if (activityInfo.hasActivityTitle()) {
                this.a |= 2;
                obj = activityInfo.activityTitle_;
                this.c = obj;
            }
            if (activityInfo.hasIsEnd()) {
                int isEnd = activityInfo.getIsEnd();
                this.a |= 4;
                this.d = isEnd;
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
    public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.ActivityInfo activityInfo;
        Throwable th;
        try {
            try {
                Im.ActivityInfo parsePartialFrom = Im.ActivityInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                activityInfo = null;
                if (activityInfo != null) {
                    mergeFrom(activityInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.ActivityInfo activityInfo2 = (Im.ActivityInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                activityInfo = activityInfo2;
                th = th3;
                if (activityInfo != null) {
                }
                throw th;
            }
        }
    }
}
