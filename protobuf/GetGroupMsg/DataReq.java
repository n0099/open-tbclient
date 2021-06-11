package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_GETTYPE = "";
    public static final String DEFAULT_MAX_TIME = "";
    public static final String DEFAULT_MIN_TIME = "";
    public static final String DEFAULT_PROCESS_TYPE = "";
    public static final String DEFAULT_PUSHTIMES = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String gettype;
    @ProtoField(label = Message.Label.REPEATED, tag = 6)
    public final List<GroupLastId> groupMids;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String max_time;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String min_time;
    @ProtoField(tag = 11)
    public final NewpushRepair newpushRepire;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String process_type;
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

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String gettype;
        public List<GroupLastId> groupMids;
        public Integer height;
        public String max_time;
        public String min_time;
        public NewpushRepair newpushRepire;
        public String process_type;
        public String pushTimes;
        public Integer smallHeight;
        public Integer smallWidth;
        public Integer width;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.width = dataReq.width;
            this.height = dataReq.height;
            this.smallWidth = dataReq.smallWidth;
            this.smallHeight = dataReq.smallHeight;
            this.pushTimes = dataReq.pushTimes;
            this.groupMids = Message.copyOf(dataReq.groupMids);
            this.gettype = dataReq.gettype;
            this.min_time = dataReq.min_time;
            this.max_time = dataReq.max_time;
            this.process_type = dataReq.process_type;
            this.newpushRepire = dataReq.newpushRepire;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
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
            Integer num3 = builder.smallWidth;
            if (num3 == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = num3;
            }
            Integer num4 = builder.smallHeight;
            if (num4 == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
            } else {
                this.smallHeight = num4;
            }
            String str = builder.pushTimes;
            if (str == null) {
                this.pushTimes = "";
            } else {
                this.pushTimes = str;
            }
            List<GroupLastId> list = builder.groupMids;
            if (list == null) {
                this.groupMids = DEFAULT_GROUPMIDS;
            } else {
                this.groupMids = Message.immutableCopyOf(list);
            }
            String str2 = builder.gettype;
            if (str2 == null) {
                this.gettype = "";
            } else {
                this.gettype = str2;
            }
            String str3 = builder.min_time;
            if (str3 == null) {
                this.min_time = "";
            } else {
                this.min_time = str3;
            }
            String str4 = builder.max_time;
            if (str4 == null) {
                this.max_time = "";
            } else {
                this.max_time = str4;
            }
            String str5 = builder.process_type;
            if (str5 == null) {
                this.process_type = "";
            } else {
                this.process_type = str5;
            }
            this.newpushRepire = builder.newpushRepire;
            return;
        }
        this.width = builder.width;
        this.height = builder.height;
        this.smallWidth = builder.smallWidth;
        this.smallHeight = builder.smallHeight;
        this.pushTimes = builder.pushTimes;
        this.groupMids = Message.immutableCopyOf(builder.groupMids);
        this.gettype = builder.gettype;
        this.min_time = builder.min_time;
        this.max_time = builder.max_time;
        this.process_type = builder.process_type;
        this.newpushRepire = builder.newpushRepire;
    }
}
