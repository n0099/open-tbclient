package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class LiveGroupInfo extends Message {
    public static final String DEFAULT_AUTHORNAME = "";
    public static final String DEFAULT_BACKGROUND = "";
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PLAYURL = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_PORTRAITID = "";
    public static final String DEFAULT_PUBLISHERNAME = "";
    public static final String DEFAULT_PUBLISHERPORTRAIT = "";
    public static final String DEFAULT_SIGNATURE = "";
    public static final String DEFAULT_STREAMID = "";
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long authorId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String authorName;
    @ProtoField(tag = 32)
    public final Photo avatar;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String background;
    @ProtoField(label = Message.Label.REPEATED, tag = 31)
    public final List<Photo> backgrounds;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer createTime;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer deviceId;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer fromType;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer gagers;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer isLiving;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer isVip;
    @ProtoField(tag = 29)
    public final LiveGroupLabel label;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long lastMsgId;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer likers;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer listeners;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String playUrl;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String portraitId;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long publisherId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String publisherName;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String publisherPortrait;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer startTime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String streamId;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Long DEFAULT_AUTHORID = 0L;
    public static final Integer DEFAULT_GROUPTYPE = 0;
    public static final Long DEFAULT_PUBLISHERID = 0L;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_DEVICEID = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_LISTENERS = 0;
    public static final Integer DEFAULT_LIKERS = 0;
    public static final Integer DEFAULT_ISLIVING = 0;
    public static final Integer DEFAULT_GAGERS = 0;
    public static final Long DEFAULT_LASTMSGID = 0L;
    public static final Integer DEFAULT_FLAG = 0;
    public static final Integer DEFAULT_FROMTYPE = 0;
    public static final Integer DEFAULT_ISVIP = 0;
    public static final List<Photo> DEFAULT_BACKGROUNDS = Collections.emptyList();

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<LiveGroupInfo> {
        public Long authorId;
        public String authorName;
        public Photo avatar;
        public String background;
        public List<Photo> backgrounds;
        public Integer createTime;
        public Integer deviceId;
        public Integer flag;
        public Integer forumId;
        public String forumName;
        public Integer fromType;
        public Integer gagers;
        public Long groupId;
        public Integer groupType;
        public String intro;
        public Integer isLiving;
        public Integer isVip;
        public LiveGroupLabel label;
        public Long lastMsgId;
        public Integer likers;
        public Integer listeners;
        public String name;
        public String playUrl;
        public String portrait;
        public String portraitId;
        public Long publisherId;
        public String publisherName;
        public String publisherPortrait;
        public String signature;
        public Integer startTime;
        public Integer status;
        public String streamId;

        public Builder() {
        }

        public Builder(LiveGroupInfo liveGroupInfo) {
            super(liveGroupInfo);
            if (liveGroupInfo == null) {
                return;
            }
            this.name = liveGroupInfo.name;
            this.status = liveGroupInfo.status;
            this.forumId = liveGroupInfo.forumId;
            this.authorName = liveGroupInfo.authorName;
            this.authorId = liveGroupInfo.authorId;
            this.groupType = liveGroupInfo.groupType;
            this.publisherId = liveGroupInfo.publisherId;
            this.publisherName = liveGroupInfo.publisherName;
            this.createTime = liveGroupInfo.createTime;
            this.groupId = liveGroupInfo.groupId;
            this.deviceId = liveGroupInfo.deviceId;
            this.streamId = liveGroupInfo.streamId;
            this.intro = liveGroupInfo.intro;
            this.background = liveGroupInfo.background;
            this.portrait = liveGroupInfo.portrait;
            this.startTime = liveGroupInfo.startTime;
            this.publisherPortrait = liveGroupInfo.publisherPortrait;
            this.listeners = liveGroupInfo.listeners;
            this.likers = liveGroupInfo.likers;
            this.isLiving = liveGroupInfo.isLiving;
            this.playUrl = liveGroupInfo.playUrl;
            this.gagers = liveGroupInfo.gagers;
            this.portraitId = liveGroupInfo.portraitId;
            this.lastMsgId = liveGroupInfo.lastMsgId;
            this.forumName = liveGroupInfo.forumName;
            this.flag = liveGroupInfo.flag;
            this.fromType = liveGroupInfo.fromType;
            this.isVip = liveGroupInfo.isVip;
            this.label = liveGroupInfo.label;
            this.signature = liveGroupInfo.signature;
            this.backgrounds = Message.copyOf(liveGroupInfo.backgrounds);
            this.avatar = liveGroupInfo.avatar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveGroupInfo build(boolean z) {
            return new LiveGroupInfo(this, z);
        }
    }

    public LiveGroupInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            Integer num = builder.status;
            if (num == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = num;
            }
            Integer num2 = builder.forumId;
            if (num2 == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num2;
            }
            String str2 = builder.authorName;
            if (str2 == null) {
                this.authorName = "";
            } else {
                this.authorName = str2;
            }
            Long l = builder.authorId;
            if (l == null) {
                this.authorId = DEFAULT_AUTHORID;
            } else {
                this.authorId = l;
            }
            Integer num3 = builder.groupType;
            if (num3 == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num3;
            }
            Long l2 = builder.publisherId;
            if (l2 == null) {
                this.publisherId = DEFAULT_PUBLISHERID;
            } else {
                this.publisherId = l2;
            }
            String str3 = builder.publisherName;
            if (str3 == null) {
                this.publisherName = "";
            } else {
                this.publisherName = str3;
            }
            Integer num4 = builder.createTime;
            if (num4 == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = num4;
            }
            Long l3 = builder.groupId;
            if (l3 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l3;
            }
            Integer num5 = builder.deviceId;
            if (num5 == null) {
                this.deviceId = DEFAULT_DEVICEID;
            } else {
                this.deviceId = num5;
            }
            String str4 = builder.streamId;
            if (str4 == null) {
                this.streamId = "";
            } else {
                this.streamId = str4;
            }
            String str5 = builder.intro;
            if (str5 == null) {
                this.intro = "";
            } else {
                this.intro = str5;
            }
            String str6 = builder.background;
            if (str6 == null) {
                this.background = "";
            } else {
                this.background = str6;
            }
            String str7 = builder.portrait;
            if (str7 == null) {
                this.portrait = "";
            } else {
                this.portrait = str7;
            }
            Integer num6 = builder.startTime;
            if (num6 == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = num6;
            }
            String str8 = builder.publisherPortrait;
            if (str8 == null) {
                this.publisherPortrait = "";
            } else {
                this.publisherPortrait = str8;
            }
            Integer num7 = builder.listeners;
            if (num7 == null) {
                this.listeners = DEFAULT_LISTENERS;
            } else {
                this.listeners = num7;
            }
            Integer num8 = builder.likers;
            if (num8 == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = num8;
            }
            Integer num9 = builder.isLiving;
            if (num9 == null) {
                this.isLiving = DEFAULT_ISLIVING;
            } else {
                this.isLiving = num9;
            }
            String str9 = builder.playUrl;
            if (str9 == null) {
                this.playUrl = "";
            } else {
                this.playUrl = str9;
            }
            Integer num10 = builder.gagers;
            if (num10 == null) {
                this.gagers = DEFAULT_GAGERS;
            } else {
                this.gagers = num10;
            }
            String str10 = builder.portraitId;
            if (str10 == null) {
                this.portraitId = "";
            } else {
                this.portraitId = str10;
            }
            Long l4 = builder.lastMsgId;
            if (l4 == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
            } else {
                this.lastMsgId = l4;
            }
            String str11 = builder.forumName;
            if (str11 == null) {
                this.forumName = "";
            } else {
                this.forumName = str11;
            }
            Integer num11 = builder.flag;
            if (num11 == null) {
                this.flag = DEFAULT_FLAG;
            } else {
                this.flag = num11;
            }
            Integer num12 = builder.fromType;
            if (num12 == null) {
                this.fromType = DEFAULT_FROMTYPE;
            } else {
                this.fromType = num12;
            }
            Integer num13 = builder.isVip;
            if (num13 == null) {
                this.isVip = DEFAULT_ISVIP;
            } else {
                this.isVip = num13;
            }
            this.label = builder.label;
            String str12 = builder.signature;
            if (str12 == null) {
                this.signature = "";
            } else {
                this.signature = str12;
            }
            List<Photo> list = builder.backgrounds;
            if (list == null) {
                this.backgrounds = DEFAULT_BACKGROUNDS;
            } else {
                this.backgrounds = Message.immutableCopyOf(list);
            }
            this.avatar = builder.avatar;
            return;
        }
        this.name = builder.name;
        this.status = builder.status;
        this.forumId = builder.forumId;
        this.authorName = builder.authorName;
        this.authorId = builder.authorId;
        this.groupType = builder.groupType;
        this.publisherId = builder.publisherId;
        this.publisherName = builder.publisherName;
        this.createTime = builder.createTime;
        this.groupId = builder.groupId;
        this.deviceId = builder.deviceId;
        this.streamId = builder.streamId;
        this.intro = builder.intro;
        this.background = builder.background;
        this.portrait = builder.portrait;
        this.startTime = builder.startTime;
        this.publisherPortrait = builder.publisherPortrait;
        this.listeners = builder.listeners;
        this.likers = builder.likers;
        this.isLiving = builder.isLiving;
        this.playUrl = builder.playUrl;
        this.gagers = builder.gagers;
        this.portraitId = builder.portraitId;
        this.lastMsgId = builder.lastMsgId;
        this.forumName = builder.forumName;
        this.flag = builder.flag;
        this.fromType = builder.fromType;
        this.isVip = builder.isVip;
        this.label = builder.label;
        this.signature = builder.signature;
        this.backgrounds = Message.immutableCopyOf(builder.backgrounds);
        this.avatar = builder.avatar;
    }
}
