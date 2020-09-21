package protobuf.SetLocation;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes21.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_LAT = "";
    public static final String DEFAULT_LNG = "";
    public static final Long DEFAULT_TOUID = 0L;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String lat;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String lng;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long toUid;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.toUid == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = builder.toUid;
            }
            if (builder.lng == null) {
                this.lng = "";
            } else {
                this.lng = builder.lng;
            }
            if (builder.lat == null) {
                this.lat = "";
                return;
            } else {
                this.lat = builder.lat;
                return;
            }
        }
        this.toUid = builder.toUid;
        this.lng = builder.lng;
        this.lat = builder.lat;
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String lat;
        public String lng;
        public Long toUid;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.toUid = dataReq.toUid;
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
