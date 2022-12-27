package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class Level extends Message {
    public static final String DEFAULT_EXPIREDNOTIFY = "";
    public static final String DEFAULT_EXPIRINGNOTIFY = "";
    public static final String DEFAULT_MAXFREESCORE = "";
    public static final String DEFAULT_OPENSTATUS = "";
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_PROPSCATEGORY = "";
    public static final String DEFAULT_PROPSTYPE = "";
    public static final String DEFAULT_USEDSTATUS = "";
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String expiredNotify;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String expiringNotify;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer leftNum;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String maxFreeScore;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String openStatus;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String propsCategory;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String propsType;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer updateTime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String usedStatus;
    public static final Integer DEFAULT_PROPSID = 0;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Integer DEFAULT_LEFTNUM = 0;
    public static final Integer DEFAULT_UPDATETIME = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<Level> {
        public Integer endTime;
        public String expiredNotify;
        public String expiringNotify;
        public Integer leftNum;
        public String maxFreeScore;
        public String openStatus;
        public String picUrl;
        public String propsCategory;
        public Integer propsId;
        public String propsType;
        public Integer updateTime;
        public String usedStatus;

        public Builder() {
        }

        public Builder(Level level) {
            super(level);
            if (level == null) {
                return;
            }
            this.propsId = level.propsId;
            this.propsType = level.propsType;
            this.propsCategory = level.propsCategory;
            this.endTime = level.endTime;
            this.leftNum = level.leftNum;
            this.updateTime = level.updateTime;
            this.usedStatus = level.usedStatus;
            this.openStatus = level.openStatus;
            this.expiringNotify = level.expiringNotify;
            this.expiredNotify = level.expiredNotify;
            this.maxFreeScore = level.maxFreeScore;
            this.picUrl = level.picUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Level build(boolean z) {
            return new Level(this, z);
        }
    }

    public Level(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.propsId;
            if (num == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = num;
            }
            String str = builder.propsType;
            if (str == null) {
                this.propsType = "";
            } else {
                this.propsType = str;
            }
            String str2 = builder.propsCategory;
            if (str2 == null) {
                this.propsCategory = "";
            } else {
                this.propsCategory = str2;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            Integer num3 = builder.leftNum;
            if (num3 == null) {
                this.leftNum = DEFAULT_LEFTNUM;
            } else {
                this.leftNum = num3;
            }
            Integer num4 = builder.updateTime;
            if (num4 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num4;
            }
            String str3 = builder.usedStatus;
            if (str3 == null) {
                this.usedStatus = "";
            } else {
                this.usedStatus = str3;
            }
            String str4 = builder.openStatus;
            if (str4 == null) {
                this.openStatus = "";
            } else {
                this.openStatus = str4;
            }
            String str5 = builder.expiringNotify;
            if (str5 == null) {
                this.expiringNotify = "";
            } else {
                this.expiringNotify = str5;
            }
            String str6 = builder.expiredNotify;
            if (str6 == null) {
                this.expiredNotify = "";
            } else {
                this.expiredNotify = str6;
            }
            String str7 = builder.maxFreeScore;
            if (str7 == null) {
                this.maxFreeScore = "";
            } else {
                this.maxFreeScore = str7;
            }
            String str8 = builder.picUrl;
            if (str8 == null) {
                this.picUrl = "";
                return;
            } else {
                this.picUrl = str8;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.propsType = builder.propsType;
        this.propsCategory = builder.propsCategory;
        this.endTime = builder.endTime;
        this.leftNum = builder.leftNum;
        this.updateTime = builder.updateTime;
        this.usedStatus = builder.usedStatus;
        this.openStatus = builder.openStatus;
        this.expiringNotify = builder.expiringNotify;
        this.expiredNotify = builder.expiredNotify;
        this.maxFreeScore = builder.maxFreeScore;
        this.picUrl = builder.picUrl;
    }
}
