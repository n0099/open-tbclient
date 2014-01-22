package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class f extends GeneratedMessageLite.Builder<Im.GradeInfo, f> implements g {
    private int a;
    private int b;
    private Object c = "";
    private int d;
    private int e;

    private f() {
        g();
    }

    private void g() {
    }

    public static f h() {
        return new f();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public f clear() {
        super.clear();
        this.b = 0;
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = 0;
        this.a &= -5;
        this.e = 0;
        this.a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public f clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.GradeInfo getDefaultInstanceForType() {
        return Im.GradeInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GradeInfo build() {
        Im.GradeInfo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.GradeInfo buildPartial() {
        Im.GradeInfo gradeInfo = new Im.GradeInfo(this);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        gradeInfo.grade_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        gradeInfo.intro_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        gradeInfo.thresholdDay_ = this.d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        gradeInfo.maxMemberNum_ = this.e;
        gradeInfo.bitField0_ = i2;
        return gradeInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public f mergeFrom(Im.GradeInfo gradeInfo) {
        Object obj;
        if (gradeInfo != Im.GradeInfo.getDefaultInstance()) {
            if (gradeInfo.hasGrade()) {
                a(gradeInfo.getGrade());
            }
            if (gradeInfo.hasIntro()) {
                this.a |= 2;
                obj = gradeInfo.intro_;
                this.c = obj;
            }
            if (gradeInfo.hasThresholdDay()) {
                b(gradeInfo.getThresholdDay());
            }
            if (gradeInfo.hasMaxMemberNum()) {
                c(gradeInfo.getMaxMemberNum());
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
    public f mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.GradeInfo gradeInfo;
        Throwable th;
        try {
            try {
                Im.GradeInfo parsePartialFrom = Im.GradeInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                gradeInfo = null;
                if (gradeInfo != null) {
                    mergeFrom(gradeInfo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.GradeInfo gradeInfo2 = (Im.GradeInfo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                gradeInfo = gradeInfo2;
                th = th3;
                if (gradeInfo != null) {
                }
                throw th;
            }
        }
    }

    public f a(int i) {
        this.a |= 1;
        this.b = i;
        return this;
    }

    public f b(int i) {
        this.a |= 4;
        this.d = i;
        return this;
    }

    public f c(int i) {
        this.a |= 8;
        this.e = i;
        return this;
    }
}
