package protobuf.UpdateClientInfo;

import com.squareup.wire.ByteString;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_BDUSS = "";
    public static final String DEFAULT_DEVICE = "";
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_HEIGHT;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_PROJECT = "";
    public static final Integer DEFAULT_PUB_ENV;
    public static final ByteString DEFAULT_SECRETKEY = ByteString.EMPTY;
    public static final String DEFAULT_STOKEN = "";
    public static final Integer DEFAULT_UNREAD_MSG;
    public static final Integer DEFAULT_WIDTH;
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

    /* loaded from: classes7.dex */
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
            if (dataReq == null) {
                return;
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_UNREAD_MSG = 0;
        DEFAULT_PUB_ENV = 0;
        DEFAULT_GROUPID = 0L;
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.bduss;
            if (str == null) {
                this.bduss = "";
            } else {
                this.bduss = str;
            }
            String str2 = builder.device;
            if (str2 == null) {
                this.device = "";
            } else {
                this.device = str2;
            }
            ByteString byteString = builder.secretKey;
            if (byteString == null) {
                this.secretKey = DEFAULT_SECRETKEY;
            } else {
                this.secretKey = byteString;
            }
            Double d2 = builder.lat;
            if (d2 == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d2;
            }
            Double d3 = builder.lng;
            if (d3 == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d3;
            }
            Integer num = builder.width;
            if (num == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num;
            }
            Integer num2 = builder.height;
            if (num2 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num2;
            }
            Integer num3 = builder.unread_msg;
            if (num3 == null) {
                this.unread_msg = DEFAULT_UNREAD_MSG;
            } else {
                this.unread_msg = num3;
            }
            Integer num4 = builder.pub_env;
            if (num4 == null) {
                this.pub_env = DEFAULT_PUB_ENV;
            } else {
                this.pub_env = num4;
            }
            String str3 = builder.project;
            if (str3 == null) {
                this.project = "";
            } else {
                this.project = str3;
            }
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str4 = builder.stoken;
            if (str4 == null) {
                this.stoken = "";
                return;
            } else {
                this.stoken = str4;
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
}
