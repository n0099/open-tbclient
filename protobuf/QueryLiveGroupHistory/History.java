package protobuf.QueryLiveGroupHistory;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class History extends Message {
    public static final String DEFAULT_PLAYURL = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
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
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_LISTENERS = 0;
    public static final Integer DEFAULT_LIKERS = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<History> {
        public Integer endTime;
        public Long groupId;
        public Integer likers;
        public Integer listeners;
        public String playUrl;
        public Integer startTime;
        public Long userId;

        public Builder() {
        }

        public Builder(History history) {
            super(history);
            if (history == null) {
                return;
            }
            this.groupId = history.groupId;
            this.startTime = history.startTime;
            this.endTime = history.endTime;
            this.userId = history.userId;
            this.listeners = history.listeners;
            this.likers = history.likers;
            this.playUrl = history.playUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public History build(boolean z) {
            return new History(this, z);
        }
    }

    public History(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Integer num = builder.startTime;
            if (num == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            Long l2 = builder.userId;
            if (l2 == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l2;
            }
            Integer num3 = builder.listeners;
            if (num3 == null) {
                this.listeners = DEFAULT_LISTENERS;
            } else {
                this.listeners = num3;
            }
            Integer num4 = builder.likers;
            if (num4 == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = num4;
            }
            String str = builder.playUrl;
            if (str == null) {
                this.playUrl = "";
                return;
            } else {
                this.playUrl = str;
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
}
