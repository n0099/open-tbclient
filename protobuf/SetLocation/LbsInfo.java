package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes6.dex */
public final class LbsInfo extends Message {
    public static final String DEFAULT_DISTANCE = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String distance;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isHide;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long time;
    public static final Long DEFAULT_TIME = 0L;
    public static final Integer DEFAULT_ISHIDE = 0;

    private LbsInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.distance == null) {
                this.distance = "";
            } else {
                this.distance = builder.distance;
            }
            if (builder.time == null) {
                this.time = DEFAULT_TIME;
            } else {
                this.time = builder.time;
            }
            if (builder.isHide == null) {
                this.isHide = DEFAULT_ISHIDE;
                return;
            } else {
                this.isHide = builder.isHide;
                return;
            }
        }
        this.distance = builder.distance;
        this.time = builder.time;
        this.isHide = builder.isHide;
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.Builder<LbsInfo> {
        public String distance;
        public Integer isHide;
        public Long time;

        public Builder() {
        }

        public Builder(LbsInfo lbsInfo) {
            super(lbsInfo);
            if (lbsInfo != null) {
                this.distance = lbsInfo.distance;
                this.time = lbsInfo.time;
                this.isHide = lbsInfo.isHide;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LbsInfo build(boolean z) {
            return new LbsInfo(this, z);
        }
    }
}
