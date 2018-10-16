package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
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

    private ActivityInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.activityTitle == null) {
                this.activityTitle = "";
            } else {
                this.activityTitle = builder.activityTitle;
            }
            if (builder.isEnd == null) {
                this.isEnd = DEFAULT_ISEND;
                return;
            } else {
                this.isEnd = builder.isEnd;
                return;
            }
        }
        this.activityId = builder.activityId;
        this.activityTitle = builder.activityTitle;
        this.isEnd = builder.isEnd;
    }

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<ActivityInfo> {
        public Integer activityId;
        public String activityTitle;
        public Integer isEnd;

        public Builder() {
        }

        public Builder(ActivityInfo activityInfo) {
            super(activityInfo);
            if (activityInfo != null) {
                this.activityId = activityInfo.activityId;
                this.activityTitle = activityInfo.activityTitle;
                this.isEnd = activityInfo.isEnd;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ActivityInfo build(boolean z) {
            return new ActivityInfo(this, z);
        }
    }
}
