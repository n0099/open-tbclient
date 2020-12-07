package protobuf.UpdateClientInfo;

import com.squareup.wire.ByteString;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_BDUSS = "";
    public static final String DEFAULT_DEVICE = "";
    public static final String DEFAULT_PROJECT = "";
    public static final String DEFAULT_STOKEN = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String bduss;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String device;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String project;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer pub_env;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final ByteString secretKey;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String stoken;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer unread_msg;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer width;
    public static final ByteString DEFAULT_SECRETKEY = ByteString.EMPTY;
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_UNREAD_MSG = 0;
    public static final Integer DEFAULT_PUB_ENV = 0;
    public static final Long DEFAULT_GROUPID = 0L;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.bduss == null) {
                this.bduss = "";
            } else {
                this.bduss = builder.bduss;
            }
            if (builder.device == null) {
                this.device = "";
            } else {
                this.device = builder.device;
            }
            if (builder.secretKey == null) {
                this.secretKey = DEFAULT_SECRETKEY;
            } else {
                this.secretKey = builder.secretKey;
            }
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
            if (builder.width == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = builder.width;
            }
            if (builder.height == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = builder.height;
            }
            if (builder.unread_msg == null) {
                this.unread_msg = DEFAULT_UNREAD_MSG;
            } else {
                this.unread_msg = builder.unread_msg;
            }
            if (builder.pub_env == null) {
                this.pub_env = DEFAULT_PUB_ENV;
            } else {
                this.pub_env = builder.pub_env;
            }
            if (builder.project == null) {
                this.project = "";
            } else {
                this.project = builder.project;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.stoken == null) {
                this.stoken = "";
                return;
            } else {
                this.stoken = builder.stoken;
                return;
            }
        }
        this.bduss = builder.bduss;
        this.device = builder.device;
        this.secretKey = builder.secretKey;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.width = builder.width;
        this.height = builder.height;
        this.unread_msg = builder.unread_msg;
        this.pub_env = builder.pub_env;
        this.project = builder.project;
        this.groupId = builder.groupId;
        this.stoken = builder.stoken;
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String bduss;
        public String device;
        public Long groupId;
        public Integer height;
        public Double lat;
        public Double lng;
        public String project;
        public Integer pub_env;
        public ByteString secretKey;
        public String stoken;
        public Integer unread_msg;
        public Integer width;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.bduss = dataReq.bduss;
                this.device = dataReq.device;
                this.secretKey = dataReq.secretKey;
                this.lat = dataReq.lat;
                this.lng = dataReq.lng;
                this.width = dataReq.width;
                this.height = dataReq.height;
                this.unread_msg = dataReq.unread_msg;
                this.pub_env = dataReq.pub_env;
                this.project = dataReq.project;
                this.groupId = dataReq.groupId;
                this.stoken = dataReq.stoken;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
