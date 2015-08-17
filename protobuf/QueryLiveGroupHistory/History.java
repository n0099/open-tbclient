package protobuf.QueryLiveGroupHistory;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class History extends Message {
    public static final String DEFAULT_PLAYURL = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer likers;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer listeners;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String playUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer startTime;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long userId;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_LISTENERS = 0;
    public static final Integer DEFAULT_LIKERS = 0;

    /* synthetic */ History(Builder builder, boolean z, History history) {
        this(builder, z);
    }

    private History(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.startTime == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = builder.startTime;
            }
            if (builder.endTime == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = builder.endTime;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.listeners == null) {
                this.listeners = DEFAULT_LISTENERS;
            } else {
                this.listeners = builder.listeners;
            }
            if (builder.likers == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = builder.likers;
            }
            if (builder.playUrl == null) {
                this.playUrl = "";
                return;
            } else {
                this.playUrl = builder.playUrl;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.userId = builder.userId;
        this.listeners = builder.listeners;
        this.likers = builder.likers;
        this.playUrl = builder.playUrl;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<History> {
        public Integer endTime;
        public Integer groupId;
        public Integer likers;
        public Integer listeners;
        public String playUrl;
        public Integer startTime;
        public Long userId;

        public Builder() {
        }

        public Builder(History history) {
            super(history);
            if (history != null) {
                this.groupId = history.groupId;
                this.startTime = history.startTime;
                this.endTime = history.endTime;
                this.userId = history.userId;
                this.listeners = history.listeners;
                this.likers = history.likers;
                this.playUrl = history.playUrl;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public History build(boolean z) {
            return new History(this, z, null);
        }
    }
}
