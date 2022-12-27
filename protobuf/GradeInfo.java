package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<GradeInfo> {
        public Integer grade;
        public String intro;
        public Integer maxMemberNum;
        public Integer thresholdDay;

        public Builder() {
        }

        public Builder(GradeInfo gradeInfo) {
            super(gradeInfo);
            if (gradeInfo == null) {
                return;
            }
            this.grade = gradeInfo.grade;
            this.intro = gradeInfo.intro;
            this.thresholdDay = gradeInfo.thresholdDay;
            this.maxMemberNum = gradeInfo.maxMemberNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GradeInfo build(boolean z) {
            return new GradeInfo(this, z);
        }
    }

    public GradeInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.grade;
            if (num == null) {
                this.grade = DEFAULT_GRADE;
            } else {
                this.grade = num;
            }
            String str = builder.intro;
            if (str == null) {
                this.intro = "";
            } else {
                this.intro = str;
            }
            Integer num2 = builder.thresholdDay;
            if (num2 == null) {
                this.thresholdDay = DEFAULT_THRESHOLDDAY;
            } else {
                this.thresholdDay = num2;
            }
            Integer num3 = builder.maxMemberNum;
            if (num3 == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
                return;
            } else {
                this.maxMemberNum = num3;
                return;
            }
        }
        this.grade = builder.grade;
        this.intro = builder.intro;
        this.thresholdDay = builder.thresholdDay;
        this.maxMemberNum = builder.maxMemberNum;
    }
}
