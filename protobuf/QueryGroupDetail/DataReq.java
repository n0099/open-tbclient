package protobuf.QueryGroupDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_FROM = "";
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer bigHeight;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer bigWidth;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer smallWidth;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_SMALLHEIGHT = 0;
    public static final Integer DEFAULT_SMALLWIDTH = 0;
    public static final Integer DEFAULT_BIGHEIGHT = 0;
    public static final Integer DEFAULT_BIGWIDTH = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.smallHeight == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
            } else {
                this.smallHeight = builder.smallHeight;
            }
            if (builder.smallWidth == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = builder.smallWidth;
            }
            if (builder.bigHeight == null) {
                this.bigHeight = DEFAULT_BIGHEIGHT;
            } else {
                this.bigHeight = builder.bigHeight;
            }
            if (builder.bigWidth == null) {
                this.bigWidth = DEFAULT_BIGWIDTH;
            } else {
                this.bigWidth = builder.bigWidth;
            }
            if (builder.from == null) {
                this.from = "";
                return;
            } else {
                this.from = builder.from;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.smallHeight = builder.smallHeight;
        this.smallWidth = builder.smallWidth;
        this.bigHeight = builder.bigHeight;
        this.bigWidth = builder.bigWidth;
        this.from = builder.from;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer bigHeight;
        public Integer bigWidth;
        public String from;
        public Integer groupId;
        public Integer smallHeight;
        public Integer smallWidth;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.smallHeight = dataReq.smallHeight;
                this.smallWidth = dataReq.smallWidth;
                this.bigHeight = dataReq.bigHeight;
                this.bigWidth = dataReq.bigWidth;
                this.from = dataReq.from;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
