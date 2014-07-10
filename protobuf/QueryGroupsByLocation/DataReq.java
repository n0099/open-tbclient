package protobuf.QueryGroupsByLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer geo;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer rn;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer width;
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_RN = 0;
    public static final Integer DEFAULT_GEO = 0;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.lat == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = builder.lat;
            }
            if (builder.lng == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = builder.lng;
            }
            if (builder.offset == null) {
                this.offset = DEFAULT_OFFSET;
            } else {
                this.offset = builder.offset;
            }
            if (builder.rn == null) {
                this.rn = DEFAULT_RN;
            } else {
                this.rn = builder.rn;
            }
            if (builder.geo == null) {
                this.geo = DEFAULT_GEO;
            } else {
                this.geo = builder.geo;
            }
            if (builder.width == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = builder.width;
            }
            if (builder.height == null) {
                this.height = DEFAULT_HEIGHT;
                return;
            } else {
                this.height = builder.height;
                return;
            }
        }
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.offset = builder.offset;
        this.rn = builder.rn;
        this.geo = builder.geo;
        this.width = builder.width;
        this.height = builder.height;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public Integer geo;
        public Integer height;
        public Double lat;
        public Double lng;
        public Integer offset;
        public Integer rn;
        public Integer width;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.lat = dataReq.lat;
                this.lng = dataReq.lng;
                this.offset = dataReq.offset;
                this.rn = dataReq.rn;
                this.geo = dataReq.geo;
                this.width = dataReq.width;
                this.height = dataReq.height;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
