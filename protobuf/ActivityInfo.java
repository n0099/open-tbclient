package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ActivityInfo extends Message {
    public static final String DEFAULT_ACTIVITYTITLE = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String activityTitle;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isEnd;
    public static final Integer DEFAULT_ACTIVITYID = 0;
    public static final Integer DEFAULT_ISEND = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<ActivityInfo> {
        public Integer activityId;
        public String activityTitle;
        public Integer isEnd;

        public Builder() {
        }

        public Builder(ActivityInfo activityInfo) {
            super(activityInfo);
            if (activityInfo == null) {
                return;
            }
            this.activityId = activityInfo.activityId;
            this.activityTitle = activityInfo.activityTitle;
            this.isEnd = activityInfo.isEnd;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ActivityInfo build(boolean z) {
            return new ActivityInfo(this, z);
        }
    }

    public ActivityInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.activityId;
            if (num == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = num;
            }
            String str = builder.activityTitle;
            if (str == null) {
                this.activityTitle = "";
            } else {
                this.activityTitle = str;
            }
            Integer num2 = builder.isEnd;
            if (num2 == null) {
                this.isEnd = DEFAULT_ISEND;
                return;
            } else {
                this.isEnd = num2;
                return;
            }
        }
        this.activityId = builder.activityId;
        this.activityTitle = builder.activityTitle;
        this.isEnd = builder.isEnd;
    }
}
