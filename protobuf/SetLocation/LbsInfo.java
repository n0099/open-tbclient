package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<LbsInfo> {
        public String distance;
        public Integer isHide;
        public Long time;

        public Builder() {
        }

        public Builder(LbsInfo lbsInfo) {
            super(lbsInfo);
            if (lbsInfo == null) {
                return;
            }
            this.distance = lbsInfo.distance;
            this.time = lbsInfo.time;
            this.isHide = lbsInfo.isHide;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LbsInfo build(boolean z) {
            return new LbsInfo(this, z);
        }
    }

    public LbsInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.distance;
            if (str == null) {
                this.distance = "";
            } else {
                this.distance = str;
            }
            Long l = builder.time;
            if (l == null) {
                this.time = DEFAULT_TIME;
            } else {
                this.time = l;
            }
            Integer num = builder.isHide;
            if (num == null) {
                this.isHide = DEFAULT_ISHIDE;
                return;
            } else {
                this.isHide = num;
                return;
            }
        }
        this.distance = builder.distance;
        this.time = builder.time;
        this.isHide = builder.isHide;
    }
}
