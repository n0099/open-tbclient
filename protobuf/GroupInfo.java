package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class GroupInfo extends Message {
    public static final Integer DEFAULT_ACTIVEDAY;
    public static final String DEFAULT_ALBUM = "";
    public static final Long DEFAULT_AUTHORID;
    public static final Integer DEFAULT_AUTHORISMEIZHI;
    public static final String DEFAULT_AUTHORNAME = "";
    public static final String DEFAULT_AUTHORNAMESHOW = "";
    public static final String DEFAULT_AUTHORPORTRAIT = "";
    public static final String DEFAULT_BUSINESS = "";
    public static final Integer DEFAULT_CREATETIME;
    public static final Integer DEFAULT_DISTANCE;
    public static final Integer DEFAULT_FLAG;
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_FORUMSHOWNAME = "";
    public static final Integer DEFAULT_GRADE;
    public static final Integer DEFAULT_GROUPTYPE;
    public static final String DEFAULT_INTRO = "";
    public static final Integer DEFAULT_ISGROUPMANAGER;
    public static final Integer DEFAULT_ISHIDEPOSITION;
    public static final Integer DEFAULT_ISMEMBERGROUP;
    public static final Integer DEFAULT_ISNEWLYCREATE;
    public static final Integer DEFAULT_ISRECENTLYREPLY;
    public static final Long DEFAULT_LASTMSGID;
    public static final Integer DEFAULT_LASTMSGTIME;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final Integer DEFAULT_MAXMEMBERNUM;
    public static final Integer DEFAULT_MEMBERNUM;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_NOTICE = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    public static final Integer DEFAULT_STATUS;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer activeDay;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String album;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long authorId;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer authorIsMeizhi;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String authorName;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String authorNameShow;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String authorPortrait;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String business;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer createTime;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String forumShowName;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer grade;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer isGroupManager;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer isHidePosition;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer isMemberGroup;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer isNewlyCreate;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer isRecentlyReply;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long lastMsgId;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer lastMsgTime;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer maxMemberNum;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer memberNum;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String nickName;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String notice;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String position;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer status;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_FORUMID = 0;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<GroupInfo> {
        public Integer activeDay;
        public String album;
        public Long authorId;
        public Integer authorIsMeizhi;
        public String authorName;
        public String authorNameShow;
        public String authorPortrait;
        public String business;
        public Integer createTime;
        public Integer distance;
        public Integer flag;
        public Integer forumId;
        public String forumName;
        public String forumShowName;
        public Integer grade;
        public Long groupId;
        public Integer groupType;
        public String intro;
        public Integer isGroupManager;
        public Integer isHidePosition;
        public Integer isMemberGroup;
        public Integer isNewlyCreate;
        public Integer isRecentlyReply;
        public Long lastMsgId;
        public Integer lastMsgTime;
        public Double lat;
        public Double lng;
        public Integer maxMemberNum;
        public Integer memberNum;
        public String name;
        public String nickName;
        public String notice;
        public String portrait;
        public String position;
        public Integer status;

        public Builder() {
        }

        public Builder(GroupInfo groupInfo) {
            super(groupInfo);
            if (groupInfo == null) {
                return;
            }
            this.groupId = groupInfo.groupId;
            this.forumId = groupInfo.forumId;
            this.name = groupInfo.name;
            this.intro = groupInfo.intro;
            this.portrait = groupInfo.portrait;
            this.position = groupInfo.position;
            this.business = groupInfo.business;
            this.lng = groupInfo.lng;
            this.lat = groupInfo.lat;
            this.notice = groupInfo.notice;
            this.album = groupInfo.album;
            this.status = groupInfo.status;
            this.flag = groupInfo.flag;
            this.authorId = groupInfo.authorId;
            this.authorName = groupInfo.authorName;
            this.authorPortrait = groupInfo.authorPortrait;
            this.createTime = groupInfo.createTime;
            this.maxMemberNum = groupInfo.maxMemberNum;
            this.memberNum = groupInfo.memberNum;
            this.groupType = groupInfo.groupType;
            this.lastMsgId = groupInfo.lastMsgId;
            this.grade = groupInfo.grade;
            this.distance = groupInfo.distance;
            this.isHidePosition = groupInfo.isHidePosition;
            this.forumName = groupInfo.forumName;
            this.nickName = groupInfo.nickName;
            this.activeDay = groupInfo.activeDay;
            this.isGroupManager = groupInfo.isGroupManager;
            this.authorIsMeizhi = groupInfo.authorIsMeizhi;
            this.lastMsgTime = groupInfo.lastMsgTime;
            this.forumShowName = groupInfo.forumShowName;
            this.isNewlyCreate = groupInfo.isNewlyCreate;
            this.isRecentlyReply = groupInfo.isRecentlyReply;
            this.isMemberGroup = groupInfo.isMemberGroup;
            this.authorNameShow = groupInfo.authorNameShow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupInfo build(boolean z) {
            return new GroupInfo(this, z);
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_STATUS = 0;
        DEFAULT_FLAG = 0;
        DEFAULT_AUTHORID = 0L;
        DEFAULT_CREATETIME = 0;
        DEFAULT_MAXMEMBERNUM = 0;
        DEFAULT_MEMBERNUM = 0;
        DEFAULT_GROUPTYPE = 0;
        DEFAULT_LASTMSGID = 0L;
        DEFAULT_GRADE = 0;
        DEFAULT_DISTANCE = 0;
        DEFAULT_ISHIDEPOSITION = 0;
        DEFAULT_ACTIVEDAY = 0;
        DEFAULT_ISGROUPMANAGER = 0;
        DEFAULT_AUTHORISMEIZHI = 0;
        DEFAULT_LASTMSGTIME = 0;
        DEFAULT_ISNEWLYCREATE = 0;
        DEFAULT_ISRECENTLYREPLY = 0;
        DEFAULT_ISMEMBERGROUP = 0;
    }

    public GroupInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Integer num = builder.forumId;
            if (num == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.intro;
            if (str2 == null) {
                this.intro = "";
            } else {
                this.intro = str2;
            }
            String str3 = builder.portrait;
            if (str3 == null) {
                this.portrait = "";
            } else {
                this.portrait = str3;
            }
            String str4 = builder.position;
            if (str4 == null) {
                this.position = "";
            } else {
                this.position = str4;
            }
            String str5 = builder.business;
            if (str5 == null) {
                this.business = "";
            } else {
                this.business = str5;
            }
            Double d2 = builder.lng;
            if (d2 == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d2;
            }
            Double d3 = builder.lat;
            if (d3 == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d3;
            }
            String str6 = builder.notice;
            if (str6 == null) {
                this.notice = "";
            } else {
                this.notice = str6;
            }
            String str7 = builder.album;
            if (str7 == null) {
                this.album = "";
            } else {
                this.album = str7;
            }
            Integer num2 = builder.status;
            if (num2 == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = num2;
            }
            Integer num3 = builder.flag;
            if (num3 == null) {
                this.flag = DEFAULT_FLAG;
            } else {
                this.flag = num3;
            }
            Long l2 = builder.authorId;
            if (l2 == null) {
                this.authorId = DEFAULT_AUTHORID;
            } else {
                this.authorId = l2;
            }
            String str8 = builder.authorName;
            if (str8 == null) {
                this.authorName = "";
            } else {
                this.authorName = str8;
            }
            String str9 = builder.authorPortrait;
            if (str9 == null) {
                this.authorPortrait = "";
            } else {
                this.authorPortrait = str9;
            }
            Integer num4 = builder.createTime;
            if (num4 == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = num4;
            }
            Integer num5 = builder.maxMemberNum;
            if (num5 == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
            } else {
                this.maxMemberNum = num5;
            }
            Integer num6 = builder.memberNum;
            if (num6 == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = num6;
            }
            Integer num7 = builder.groupType;
            if (num7 == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num7;
            }
            Long l3 = builder.lastMsgId;
            if (l3 == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
            } else {
                this.lastMsgId = l3;
            }
            Integer num8 = builder.grade;
            if (num8 == null) {
                this.grade = DEFAULT_GRADE;
            } else {
                this.grade = num8;
            }
            Integer num9 = builder.distance;
            if (num9 == null) {
                this.distance = DEFAULT_DISTANCE;
            } else {
                this.distance = num9;
            }
            Integer num10 = builder.isHidePosition;
            if (num10 == null) {
                this.isHidePosition = DEFAULT_ISHIDEPOSITION;
            } else {
                this.isHidePosition = num10;
            }
            String str10 = builder.forumName;
            if (str10 == null) {
                this.forumName = "";
            } else {
                this.forumName = str10;
            }
            String str11 = builder.nickName;
            if (str11 == null) {
                this.nickName = "";
            } else {
                this.nickName = str11;
            }
            Integer num11 = builder.activeDay;
            if (num11 == null) {
                this.activeDay = DEFAULT_ACTIVEDAY;
            } else {
                this.activeDay = num11;
            }
            Integer num12 = builder.isGroupManager;
            if (num12 == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
            } else {
                this.isGroupManager = num12;
            }
            Integer num13 = builder.authorIsMeizhi;
            if (num13 == null) {
                this.authorIsMeizhi = DEFAULT_AUTHORISMEIZHI;
            } else {
                this.authorIsMeizhi = num13;
            }
            Integer num14 = builder.lastMsgTime;
            if (num14 == null) {
                this.lastMsgTime = DEFAULT_LASTMSGTIME;
            } else {
                this.lastMsgTime = num14;
            }
            String str12 = builder.forumShowName;
            if (str12 == null) {
                this.forumShowName = "";
            } else {
                this.forumShowName = str12;
            }
            Integer num15 = builder.isNewlyCreate;
            if (num15 == null) {
                this.isNewlyCreate = DEFAULT_ISNEWLYCREATE;
            } else {
                this.isNewlyCreate = num15;
            }
            Integer num16 = builder.isRecentlyReply;
            if (num16 == null) {
                this.isRecentlyReply = DEFAULT_ISRECENTLYREPLY;
            } else {
                this.isRecentlyReply = num16;
            }
            Integer num17 = builder.isMemberGroup;
            if (num17 == null) {
                this.isMemberGroup = DEFAULT_ISMEMBERGROUP;
            } else {
                this.isMemberGroup = num17;
            }
            String str13 = builder.authorNameShow;
            if (str13 == null) {
                this.authorNameShow = "";
                return;
            } else {
                this.authorNameShow = str13;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.forumId = builder.forumId;
        this.name = builder.name;
        this.intro = builder.intro;
        this.portrait = builder.portrait;
        this.position = builder.position;
        this.business = builder.business;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.notice = builder.notice;
        this.album = builder.album;
        this.status = builder.status;
        this.flag = builder.flag;
        this.authorId = builder.authorId;
        this.authorName = builder.authorName;
        this.authorPortrait = builder.authorPortrait;
        this.createTime = builder.createTime;
        this.maxMemberNum = builder.maxMemberNum;
        this.memberNum = builder.memberNum;
        this.groupType = builder.groupType;
        this.lastMsgId = builder.lastMsgId;
        this.grade = builder.grade;
        this.distance = builder.distance;
        this.isHidePosition = builder.isHidePosition;
        this.forumName = builder.forumName;
        this.nickName = builder.nickName;
        this.activeDay = builder.activeDay;
        this.isGroupManager = builder.isGroupManager;
        this.authorIsMeizhi = builder.authorIsMeizhi;
        this.lastMsgTime = builder.lastMsgTime;
        this.forumShowName = builder.forumShowName;
        this.isNewlyCreate = builder.isNewlyCreate;
        this.isRecentlyReply = builder.isRecentlyReply;
        this.isMemberGroup = builder.isMemberGroup;
        this.authorNameShow = builder.authorNameShow;
    }
}
