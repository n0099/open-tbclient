package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h extends GeneratedMessageLite.Builder<Im.GradeInfo, h> implements i {
    private int a;
    private int b;
    private Object c = "";
    private int d;
    private int e;

    @Override // com.google.protobuf.MessageLite.Builder
    public final /* synthetic */ MessageLite build() {
        Im.GradeInfo buildPartial = buildPartial();
        if (buildPartial.isInitialized()) {
            return buildPartial;
        }
        throw newUninitializedMessageException(buildPartial);
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
        return Im.GradeInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    public final /* synthetic */ MessageLite getDefaultInstanceForType() {
        return Im.GradeInfo.getDefaultInstance();
    }

    private h() {
    }

    public static /* synthetic */ h a() {
        return new h();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public h clear() {
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
    /* renamed from: c */
    public h clone() {
        return new h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.GradeInfo buildPartial() {
        Im.GradeInfo gradeInfo = new Im.GradeInfo(this, (Im.GradeInfo) null);
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
    public final h mergeFrom(Im.GradeInfo gradeInfo) {
        Object obj;
        if (gradeInfo != Im.GradeInfo.getDefaultInstance()) {
            if (gradeInfo.hasGrade()) {
                int grade = gradeInfo.getGrade();
                this.a |= 1;
                this.b = grade;
            }
            if (gradeInfo.hasIntro()) {
                this.a |= 2;
                obj = gradeInfo.intro_;
                this.c = obj;
            }
            if (gradeInfo.hasThresholdDay()) {
                int thresholdDay = gradeInfo.getThresholdDay();
                this.a |= 4;
                this.d = thresholdDay;
            }
            if (gradeInfo.hasMaxMemberNum()) {
                int maxMemberNum = gradeInfo.getMaxMemberNum();
                this.a |= 8;
                this.e = maxMemberNum;
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
    public h mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
}
