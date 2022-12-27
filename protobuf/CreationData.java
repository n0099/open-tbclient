package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class CreationData extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer agreeCount;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer agreeCountTrend;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer commentCount;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer commentTrend;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer validPlayCount;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer validPlayCountTrend;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer viewCount;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer viewCountTrend;
    public static final Integer DEFAULT_VIEWCOUNT = 0;
    public static final Integer DEFAULT_AGREECOUNT = 0;
    public static final Integer DEFAULT_VIEWCOUNTTREND = 0;
    public static final Integer DEFAULT_AGREECOUNTTREND = 0;
    public static final Integer DEFAULT_COMMENTCOUNT = 0;
    public static final Integer DEFAULT_COMMENTTREND = 0;
    public static final Integer DEFAULT_VALIDPLAYCOUNT = 0;
    public static final Integer DEFAULT_VALIDPLAYCOUNTTREND = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<CreationData> {
        public Integer agreeCount;
        public Integer agreeCountTrend;
        public Integer commentCount;
        public Integer commentTrend;
        public Integer validPlayCount;
        public Integer validPlayCountTrend;
        public Integer viewCount;
        public Integer viewCountTrend;

        public Builder() {
        }

        public Builder(CreationData creationData) {
            super(creationData);
            if (creationData == null) {
                return;
            }
            this.viewCount = creationData.viewCount;
            this.agreeCount = creationData.agreeCount;
            this.viewCountTrend = creationData.viewCountTrend;
            this.agreeCountTrend = creationData.agreeCountTrend;
            this.commentCount = creationData.commentCount;
            this.commentTrend = creationData.commentTrend;
            this.validPlayCount = creationData.validPlayCount;
            this.validPlayCountTrend = creationData.validPlayCountTrend;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CreationData build(boolean z) {
            return new CreationData(this, z);
        }
    }

    public CreationData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.viewCount;
            if (num == null) {
                this.viewCount = DEFAULT_VIEWCOUNT;
            } else {
                this.viewCount = num;
            }
            Integer num2 = builder.agreeCount;
            if (num2 == null) {
                this.agreeCount = DEFAULT_AGREECOUNT;
            } else {
                this.agreeCount = num2;
            }
            Integer num3 = builder.viewCountTrend;
            if (num3 == null) {
                this.viewCountTrend = DEFAULT_VIEWCOUNTTREND;
            } else {
                this.viewCountTrend = num3;
            }
            Integer num4 = builder.agreeCountTrend;
            if (num4 == null) {
                this.agreeCountTrend = DEFAULT_AGREECOUNTTREND;
            } else {
                this.agreeCountTrend = num4;
            }
            Integer num5 = builder.commentCount;
            if (num5 == null) {
                this.commentCount = DEFAULT_COMMENTCOUNT;
            } else {
                this.commentCount = num5;
            }
            Integer num6 = builder.commentTrend;
            if (num6 == null) {
                this.commentTrend = DEFAULT_COMMENTTREND;
            } else {
                this.commentTrend = num6;
            }
            Integer num7 = builder.validPlayCount;
            if (num7 == null) {
                this.validPlayCount = DEFAULT_VALIDPLAYCOUNT;
            } else {
                this.validPlayCount = num7;
            }
            Integer num8 = builder.validPlayCountTrend;
            if (num8 == null) {
                this.validPlayCountTrend = DEFAULT_VALIDPLAYCOUNTTREND;
                return;
            } else {
                this.validPlayCountTrend = num8;
                return;
            }
        }
        this.viewCount = builder.viewCount;
        this.agreeCount = builder.agreeCount;
        this.viewCountTrend = builder.viewCountTrend;
        this.agreeCountTrend = builder.agreeCountTrend;
        this.commentCount = builder.commentCount;
        this.commentTrend = builder.commentTrend;
        this.validPlayCount = builder.validPlayCount;
        this.validPlayCountTrend = builder.validPlayCountTrend;
    }
}
