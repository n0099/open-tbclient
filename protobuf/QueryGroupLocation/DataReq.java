package protobuf.QueryGroupLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes23.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lng;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.lng == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = builder.lng;
            }
            if (builder.lat == null) {
                this.lat = DEFAULT_LAT;
                return;
            } else {
                this.lat = builder.lat;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.lng = builder.lng;
        this.lat = builder.lat;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public Double lat;
        public Double lng;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.lng = dataReq.lng;
                this.lat = dataReq.lat;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
