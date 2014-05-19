package protobuf.QueryGroupCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lng;
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
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
        this.lng = builder.lng;
        this.lat = builder.lat;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Double lat;
        public Double lng;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.lng = dataReq.lng;
                this.lat = dataReq.lat;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
