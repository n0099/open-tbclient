package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GradeInfo extends Message {
    public static final String DEFAULT_INTRO = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer grade;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer maxMemberNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer thresholdDay;
    public static final Integer DEFAULT_GRADE = 0;
    public static final Integer DEFAULT_THRESHOLDDAY = 0;
    public static final Integer DEFAULT_MAXMEMBERNUM = 0;

    /* synthetic */ GradeInfo(Builder builder, boolean z, GradeInfo gradeInfo) {
        this(builder, z);
    }

    private GradeInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.grade == null) {
                this.grade = DEFAULT_GRADE;
            } else {
                this.grade = builder.grade;
            }
            if (builder.intro == null) {
                this.intro = "";
            } else {
                this.intro = builder.intro;
            }
            if (builder.thresholdDay == null) {
                this.thresholdDay = DEFAULT_THRESHOLDDAY;
            } else {
                this.thresholdDay = builder.thresholdDay;
            }
            if (builder.maxMemberNum == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
                return;
            } else {
                this.maxMemberNum = builder.maxMemberNum;
                return;
            }
        }
        this.grade = builder.grade;
        this.intro = builder.intro;
        this.thresholdDay = builder.thresholdDay;
        this.maxMemberNum = builder.maxMemberNum;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GradeInfo> {
        public Integer grade;
        public String intro;
        public Integer maxMemberNum;
        public Integer thresholdDay;

        public Builder(GradeInfo gradeInfo) {
            super(gradeInfo);
            if (gradeInfo != null) {
                this.grade = gradeInfo.grade;
                this.intro = gradeInfo.intro;
                this.thresholdDay = gradeInfo.thresholdDay;
                this.maxMemberNum = gradeInfo.maxMemberNum;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GradeInfo build(boolean z) {
            return new GradeInfo(this, z, null);
        }
    }
}
