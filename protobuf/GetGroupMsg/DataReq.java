package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes2.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_GETTYPE = "";
    public static final String DEFAULT_MAX_TIME = "";
    public static final String DEFAULT_MIN_TIME = "";
    public static final String DEFAULT_PROCESS_TYPE = "";
    public static final String DEFAULT_PUSHTIMES = "";
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer agree_count;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer atme_count;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer fan_count;
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
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long notify_msg_id;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String process_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String pushTimes;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer replyme_count;
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
    public static final Long DEFAULT_NOTIFY_MSG_ID = 0L;
    public static final Integer DEFAULT_FAN_COUNT = 0;
    public static final Integer DEFAULT_ATME_COUNT = 0;
    public static final Integer DEFAULT_REPLYME_COUNT = 0;
    public static final Integer DEFAULT_AGREE_COUNT = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer agree_count;
        public Integer atme_count;
        public Integer fan_count;
        public String gettype;
        public List<GroupLastId> groupMids;
        public Integer height;
        public String max_time;
        public String min_time;
        public NewpushRepair newpushRepire;
        public Long notify_msg_id;
        public String process_type;
        public String pushTimes;
        public Integer replyme_count;
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
            this.notify_msg_id = dataReq.notify_msg_id;
            this.fan_count = dataReq.fan_count;
            this.atme_count = dataReq.atme_count;
            this.replyme_count = dataReq.replyme_count;
            this.agree_count = dataReq.agree_count;
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
            Long l = builder.notify_msg_id;
            if (l == null) {
                this.notify_msg_id = DEFAULT_NOTIFY_MSG_ID;
            } else {
                this.notify_msg_id = l;
            }
            Integer num5 = builder.fan_count;
            if (num5 == null) {
                this.fan_count = DEFAULT_FAN_COUNT;
            } else {
                this.fan_count = num5;
            }
            Integer num6 = builder.atme_count;
            if (num6 == null) {
                this.atme_count = DEFAULT_ATME_COUNT;
            } else {
                this.atme_count = num6;
            }
            Integer num7 = builder.replyme_count;
            if (num7 == null) {
                this.replyme_count = DEFAULT_REPLYME_COUNT;
            } else {
                this.replyme_count = num7;
            }
            Integer num8 = builder.agree_count;
            if (num8 == null) {
                this.agree_count = DEFAULT_AGREE_COUNT;
                return;
            } else {
                this.agree_count = num8;
                return;
            }
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
        this.notify_msg_id = builder.notify_msg_id;
        this.fan_count = builder.fan_count;
        this.atme_count = builder.atme_count;
        this.replyme_count = builder.replyme_count;
        this.agree_count = builder.agree_count;
    }
}
