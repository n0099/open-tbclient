package protobuf.QueryHistoryMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes25.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer smallWidth;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer width;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_SMALLWIDTH = 0;
    public static final Integer DEFAULT_SMALLHEIGHT = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.forumId == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = builder.forumId;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.id == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = builder.id;
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
            if (builder.smallWidth == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = builder.smallWidth;
            }
            if (builder.smallHeight == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
                return;
            } else {
                this.smallHeight = builder.smallHeight;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.userId = builder.userId;
        this.id = builder.id;
        this.width = builder.width;
        this.height = builder.height;
        this.smallWidth = builder.smallWidth;
        this.smallHeight = builder.smallHeight;
    }

    /* loaded from: classes25.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer forumId;
        public Integer height;
        public Integer id;
        public Integer smallHeight;
        public Integer smallWidth;
        public Long userId;
        public Integer width;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.forumId = dataReq.forumId;
                this.userId = dataReq.userId;
                this.id = dataReq.id;
                this.width = dataReq.width;
                this.height = dataReq.height;
                this.smallWidth = dataReq.smallWidth;
                this.smallHeight = dataReq.smallHeight;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
