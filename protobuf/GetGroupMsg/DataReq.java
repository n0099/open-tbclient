package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupLastId;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_PUSHTIMES = "";
    @ProtoField(label = Message.Label.REPEATED, tag = 6)
    public final List<GroupLastId> groupMids;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String pushTimes;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer smallWidth;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer width;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final Integer DEFAULT_SMALLWIDTH = 0;
    public static final Integer DEFAULT_SMALLHEIGHT = 0;
    public static final List<GroupLastId> DEFAULT_GROUPMIDS = Collections.emptyList();

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
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
            } else {
                this.smallHeight = builder.smallHeight;
            }
            if (builder.pushTimes == null) {
                this.pushTimes = "";
            } else {
                this.pushTimes = builder.pushTimes;
            }
            if (builder.groupMids == null) {
                this.groupMids = DEFAULT_GROUPMIDS;
                return;
            } else {
                this.groupMids = immutableCopyOf(builder.groupMids);
                return;
            }
        }
        this.width = builder.width;
        this.height = builder.height;
        this.smallWidth = builder.smallWidth;
        this.smallHeight = builder.smallHeight;
        this.pushTimes = builder.pushTimes;
        this.groupMids = immutableCopyOf(builder.groupMids);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataReq> {
        public List<GroupLastId> groupMids;
        public Integer height;
        public String pushTimes;
        public Integer smallHeight;
        public Integer smallWidth;
        public Integer width;

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.width = dataReq.width;
                this.height = dataReq.height;
                this.smallWidth = dataReq.smallWidth;
                this.smallHeight = dataReq.smallHeight;
                this.pushTimes = dataReq.pushTimes;
                this.groupMids = DataReq.copyOf(dataReq.groupMids);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
