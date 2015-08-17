package protobuf.LiveReport;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_BACKGROUND = "";
    public static final String DEFAULT_CREATE_UNAME = "";
    public static final String DEFAULT_FORUM_NAME = "";
    public static final String DEFAULT_GROUP_NAME = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_PLAY_URL = "";
    public static final String DEFAULT_PORTRAIT = "";
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String background;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer create_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long create_uid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String create_uname;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long forum_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String forum_name;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer group_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String group_name;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer group_type;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String play_url;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer report_type;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long thread_id;
    public static final Integer DEFAULT_REPORT_TYPE = 0;
    public static final Integer DEFAULT_GROUP_ID = 0;
    public static final Long DEFAULT_FORUM_ID = 0L;
    public static final Integer DEFAULT_GROUP_TYPE = 0;
    public static final Long DEFAULT_THREAD_ID = 0L;
    public static final Long DEFAULT_CREATE_UID = 0L;
    public static final Integer DEFAULT_CREATE_TIME = 0;

    /* synthetic */ DataReq(Builder builder, boolean z, DataReq dataReq) {
        this(builder, z);
    }

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.report_type == null) {
                this.report_type = DEFAULT_REPORT_TYPE;
            } else {
                this.report_type = builder.report_type;
            }
            if (builder.group_id == null) {
                this.group_id = DEFAULT_GROUP_ID;
            } else {
                this.group_id = builder.group_id;
            }
            if (builder.group_name == null) {
                this.group_name = "";
            } else {
                this.group_name = builder.group_name;
            }
            if (builder.forum_id == null) {
                this.forum_id = DEFAULT_FORUM_ID;
            } else {
                this.forum_id = builder.forum_id;
            }
            if (builder.forum_name == null) {
                this.forum_name = "";
            } else {
                this.forum_name = builder.forum_name;
            }
            if (builder.group_type == null) {
                this.group_type = DEFAULT_GROUP_TYPE;
            } else {
                this.group_type = builder.group_type;
            }
            if (builder.thread_id == null) {
                this.thread_id = DEFAULT_THREAD_ID;
            } else {
                this.thread_id = builder.thread_id;
            }
            if (builder.create_uid == null) {
                this.create_uid = DEFAULT_CREATE_UID;
            } else {
                this.create_uid = builder.create_uid;
            }
            if (builder.create_uname == null) {
                this.create_uname = "";
            } else {
                this.create_uname = builder.create_uname;
            }
            if (builder.create_time == null) {
                this.create_time = DEFAULT_CREATE_TIME;
            } else {
                this.create_time = builder.create_time;
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
            if (builder.background == null) {
                this.background = "";
            } else {
                this.background = builder.background;
            }
            if (builder.play_url == null) {
                this.play_url = "";
                return;
            } else {
                this.play_url = builder.play_url;
                return;
            }
        }
        this.report_type = builder.report_type;
        this.group_id = builder.group_id;
        this.group_name = builder.group_name;
        this.forum_id = builder.forum_id;
        this.forum_name = builder.forum_name;
        this.group_type = builder.group_type;
        this.thread_id = builder.thread_id;
        this.create_uid = builder.create_uid;
        this.create_uname = builder.create_uname;
        this.create_time = builder.create_time;
        this.intro = builder.intro;
        this.portrait = builder.portrait;
        this.background = builder.background;
        this.play_url = builder.play_url;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String background;
        public Integer create_time;
        public Long create_uid;
        public String create_uname;
        public Long forum_id;
        public String forum_name;
        public Integer group_id;
        public String group_name;
        public Integer group_type;
        public String intro;
        public String play_url;
        public String portrait;
        public Integer report_type;
        public Long thread_id;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.report_type = dataReq.report_type;
                this.group_id = dataReq.group_id;
                this.group_name = dataReq.group_name;
                this.forum_id = dataReq.forum_id;
                this.forum_name = dataReq.forum_name;
                this.group_type = dataReq.group_type;
                this.thread_id = dataReq.thread_id;
                this.create_uid = dataReq.create_uid;
                this.create_uname = dataReq.create_uname;
                this.create_time = dataReq.create_time;
                this.intro = dataReq.intro;
                this.portrait = dataReq.portrait;
                this.background = dataReq.background;
                this.play_url = dataReq.play_url;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z, null);
        }
    }
}
