package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class ActivitySponsor extends Message {
    public static final Integer DEFAULT_ISSPONSOR = 0;
    public static final String DEFAULT_SPONSORURL = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isSponsor;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sponsorUrl;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<ActivitySponsor> {
        public Integer isSponsor;
        public String sponsorUrl;

        public Builder() {
        }

        public Builder(ActivitySponsor activitySponsor) {
            super(activitySponsor);
            if (activitySponsor == null) {
                return;
            }
            this.isSponsor = activitySponsor.isSponsor;
            this.sponsorUrl = activitySponsor.sponsorUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ActivitySponsor build(boolean z) {
            return new ActivitySponsor(this, z);
        }
    }

    public ActivitySponsor(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isSponsor;
            if (num == null) {
                this.isSponsor = DEFAULT_ISSPONSOR;
            } else {
                this.isSponsor = num;
            }
            String str = builder.sponsorUrl;
            if (str == null) {
                this.sponsorUrl = "";
                return;
            } else {
                this.sponsorUrl = str;
                return;
            }
        }
        this.isSponsor = builder.isSponsor;
        this.sponsorUrl = builder.sponsorUrl;
    }
}
