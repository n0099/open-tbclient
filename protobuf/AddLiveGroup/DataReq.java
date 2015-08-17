package protobuf.AddLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PUBLISHERNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer labelId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long publisherId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String publisherName;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Integer DEFAULT_GROUPTYPE = 0;
    public static final Long DEFAULT_PUBLISHERID = 0L;
    public static final Integer DEFAULT_LABELID = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

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
            if (builder.groupType == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = builder.groupType;
            }
            if (builder.publisherName == null) {
                this.publisherName = "";
            } else {
                this.publisherName = builder.publisherName;
            }
            if (builder.publisherId == null) {
                this.publisherId = DEFAULT_PUBLISHERID;
            } else {
                this.publisherId = builder.publisherId;
            }
            if (builder.labelId == null) {
                this.labelId = DEFAULT_LABELID;
                return;
            } else {
                this.labelId = builder.labelId;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.name = builder.name;
        this.groupType = builder.groupType;
        this.publisherName = builder.publisherName;
        this.publisherId = builder.publisherId;
        this.labelId = builder.labelId;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer forumId;
        public Integer groupType;
        public Integer labelId;
        public String name;
        public Long publisherId;
        public String publisherName;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.forumId = dataReq.forumId;
                this.name = dataReq.name;
                this.groupType = dataReq.groupType;
                this.publisherName = dataReq.publisherName;
                this.publisherId = dataReq.publisherId;
                this.labelId = dataReq.labelId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
