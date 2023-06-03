package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class AlaStageDislikeInfo extends Message {
    public static final Integer DEFAULT_DISLIKEID = 0;
    public static final String DEFAULT_DISLIKEREASON = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer dislikeId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String dislikeReason;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<AlaStageDislikeInfo> {
        public Integer dislikeId;
        public String dislikeReason;

        public Builder() {
        }

        public Builder(AlaStageDislikeInfo alaStageDislikeInfo) {
            super(alaStageDislikeInfo);
            if (alaStageDislikeInfo == null) {
                return;
            }
            this.dislikeReason = alaStageDislikeInfo.dislikeReason;
            this.dislikeId = alaStageDislikeInfo.dislikeId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaStageDislikeInfo build(boolean z) {
            return new AlaStageDislikeInfo(this, z);
        }
    }

    public AlaStageDislikeInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.dislikeReason;
            if (str == null) {
                this.dislikeReason = "";
            } else {
                this.dislikeReason = str;
            }
            Integer num = builder.dislikeId;
            if (num == null) {
                this.dislikeId = DEFAULT_DISLIKEID;
                return;
            } else {
                this.dislikeId = num;
                return;
            }
        }
        this.dislikeReason = builder.dislikeReason;
        this.dislikeId = builder.dislikeId;
    }
}
