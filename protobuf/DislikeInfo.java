package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class DislikeInfo extends Message {
    public static final Integer DEFAULT_DISLIKEID = 0;
    public static final String DEFAULT_DISLIKEREASON = "";
    public static final String DEFAULT_EXTRA = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer dislikeId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String dislikeReason;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String extra;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DislikeInfo> {
        public Integer dislikeId;
        public String dislikeReason;
        public String extra;

        public Builder() {
        }

        public Builder(DislikeInfo dislikeInfo) {
            super(dislikeInfo);
            if (dislikeInfo == null) {
                return;
            }
            this.dislikeReason = dislikeInfo.dislikeReason;
            this.dislikeId = dislikeInfo.dislikeId;
            this.extra = dislikeInfo.extra;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DislikeInfo build(boolean z) {
            return new DislikeInfo(this, z);
        }
    }

    public DislikeInfo(Builder builder, boolean z) {
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
            } else {
                this.dislikeId = num;
            }
            String str2 = builder.extra;
            if (str2 == null) {
                this.extra = "";
                return;
            } else {
                this.extra = str2;
                return;
            }
        }
        this.dislikeReason = builder.dislikeReason;
        this.dislikeId = builder.dislikeId;
        this.extra = builder.extra;
    }
}
