package protobuf.AddGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes15.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_BUSINESS = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PAGE_FROM_DIM = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String business;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String page_from_dim;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String position;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);
    public static final Integer DEFAULT_GROUPTYPE = 0;
    public static final Integer DEFAULT_FLAG = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.forumId == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = builder.forumId;
            }
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.intro == null) {
                this.intro = "";
            } else {
                this.intro = builder.intro;
            }
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.position == null) {
                this.position = "";
            } else {
                this.position = builder.position;
            }
            if (builder.business == null) {
                this.business = "";
            } else {
                this.business = builder.business;
            }
            if (builder.lng == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = builder.lng;
            }
            if (builder.lat == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = builder.lat;
            }
            if (builder.groupType == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = builder.groupType;
            }
            if (builder.flag == null) {
                this.flag = DEFAULT_FLAG;
            } else {
                this.flag = builder.flag;
            }
            if (builder.page_from_dim == null) {
                this.page_from_dim = "";
                return;
            } else {
                this.page_from_dim = builder.page_from_dim;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.name = builder.name;
        this.intro = builder.intro;
        this.portrait = builder.portrait;
        this.position = builder.position;
        this.business = builder.business;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.groupType = builder.groupType;
        this.flag = builder.flag;
        this.page_from_dim = builder.page_from_dim;
    }

    /* loaded from: classes15.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String business;
        public Integer flag;
        public Integer forumId;
        public Integer groupType;
        public String intro;
        public Double lat;
        public Double lng;
        public String name;
        public String page_from_dim;
        public String portrait;
        public String position;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.forumId = dataReq.forumId;
                this.name = dataReq.name;
                this.intro = dataReq.intro;
                this.portrait = dataReq.portrait;
                this.position = dataReq.position;
                this.business = dataReq.business;
                this.lng = dataReq.lng;
                this.lat = dataReq.lat;
                this.groupType = dataReq.groupType;
                this.flag = dataReq.flag;
                this.page_from_dim = dataReq.page_from_dim;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
