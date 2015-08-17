package protobuf;

import com.baidu.location.a0;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GroupInfo extends Message {
    public static final String DEFAULT_ALBUM = "";
    public static final String DEFAULT_AUTHORNAME = "";
    public static final String DEFAULT_AUTHORPORTRAIT = "";
    public static final String DEFAULT_BUSINESS = "";
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_FORUMSHOWNAME = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_NOTICE = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer activeDay;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String album;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long authorId;
    @ProtoField(tag = DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB, type = Message.Datatype.INT32)
    public final Integer authorIsMeizhi;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String authorName;
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
    @ProtoField(tag = a0.h, type = Message.Datatype.STRING)
    public final String forumShowName;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer grade;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
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
    @ProtoField(tag = LiveCardData.LIVETYPE_PHOTOLIVE, type = Message.Datatype.INT32)
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
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_FORUMID = 0;
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_FLAG = 0;
    public static final Long DEFAULT_AUTHORID = 0L;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_MAXMEMBERNUM = 0;
    public static final Integer DEFAULT_MEMBERNUM = 0;
    public static final Integer DEFAULT_GROUPTYPE = 0;
    public static final Long DEFAULT_LASTMSGID = 0L;
    public static final Integer DEFAULT_GRADE = 0;
    public static final Integer DEFAULT_DISTANCE = 0;
    public static final Integer DEFAULT_ISHIDEPOSITION = 0;
    public static final Integer DEFAULT_ACTIVEDAY = 0;
    public static final Integer DEFAULT_ISGROUPMANAGER = 0;
    public static final Integer DEFAULT_AUTHORISMEIZHI = 0;
    public static final Integer DEFAULT_LASTMSGTIME = 0;
    public static final Integer DEFAULT_ISNEWLYCREATE = 0;
    public static final Integer DEFAULT_ISRECENTLYREPLY = 0;
    public static final Integer DEFAULT_ISMEMBERGROUP = 0;

    /* synthetic */ GroupInfo(Builder builder, boolean z, GroupInfo groupInfo) {
        this(builder, z);
    }

    private GroupInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.forumId == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = builder.forumId;
            }
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
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
            if (builder.position == null) {
                this.position = "";
            } else {
                this.position = builder.position;
            }
            if (builder.business == null) {
                this.business = "";
            } else {
                this.business = builder.business;
            }
            if (builder.lng == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = builder.lng;
            }
            if (builder.lat == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = builder.lat;
            }
            if (builder.notice == null) {
                this.notice = "";
            } else {
                this.notice = builder.notice;
            }
            if (builder.album == null) {
                this.album = "";
            } else {
                this.album = builder.album;
            }
            if (builder.status == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = builder.status;
            }
            if (builder.flag == null) {
                this.flag = DEFAULT_FLAG;
            } else {
                this.flag = builder.flag;
            }
            if (builder.authorId == null) {
                this.authorId = DEFAULT_AUTHORID;
            } else {
                this.authorId = builder.authorId;
            }
            if (builder.authorName == null) {
                this.authorName = "";
            } else {
                this.authorName = builder.authorName;
            }
            if (builder.authorPortrait == null) {
                this.authorPortrait = "";
            } else {
                this.authorPortrait = builder.authorPortrait;
            }
            if (builder.createTime == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = builder.createTime;
            }
            if (builder.maxMemberNum == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
            } else {
                this.maxMemberNum = builder.maxMemberNum;
            }
            if (builder.memberNum == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = builder.memberNum;
            }
            if (builder.groupType == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = builder.groupType;
            }
            if (builder.lastMsgId == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
            } else {
                this.lastMsgId = builder.lastMsgId;
            }
            if (builder.grade == null) {
                this.grade = DEFAULT_GRADE;
            } else {
                this.grade = builder.grade;
            }
            if (builder.distance == null) {
                this.distance = DEFAULT_DISTANCE;
            } else {
                this.distance = builder.distance;
            }
            if (builder.isHidePosition == null) {
                this.isHidePosition = DEFAULT_ISHIDEPOSITION;
            } else {
                this.isHidePosition = builder.isHidePosition;
            }
            if (builder.forumName == null) {
                this.forumName = "";
            } else {
                this.forumName = builder.forumName;
            }
            if (builder.nickName == null) {
                this.nickName = "";
            } else {
                this.nickName = builder.nickName;
            }
            if (builder.activeDay == null) {
                this.activeDay = DEFAULT_ACTIVEDAY;
            } else {
                this.activeDay = builder.activeDay;
            }
            if (builder.isGroupManager == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
            } else {
                this.isGroupManager = builder.isGroupManager;
            }
            if (builder.authorIsMeizhi == null) {
                this.authorIsMeizhi = DEFAULT_AUTHORISMEIZHI;
            } else {
                this.authorIsMeizhi = builder.authorIsMeizhi;
            }
            if (builder.lastMsgTime == null) {
                this.lastMsgTime = DEFAULT_LASTMSGTIME;
            } else {
                this.lastMsgTime = builder.lastMsgTime;
            }
            if (builder.forumShowName == null) {
                this.forumShowName = "";
            } else {
                this.forumShowName = builder.forumShowName;
            }
            if (builder.isNewlyCreate == null) {
                this.isNewlyCreate = DEFAULT_ISNEWLYCREATE;
            } else {
                this.isNewlyCreate = builder.isNewlyCreate;
            }
            if (builder.isRecentlyReply == null) {
                this.isRecentlyReply = DEFAULT_ISRECENTLYREPLY;
            } else {
                this.isRecentlyReply = builder.isRecentlyReply;
            }
            if (builder.isMemberGroup == null) {
                this.isMemberGroup = DEFAULT_ISMEMBERGROUP;
                return;
            } else {
                this.isMemberGroup = builder.isMemberGroup;
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
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GroupInfo> {
        public Integer activeDay;
        public String album;
        public Long authorId;
        public Integer authorIsMeizhi;
        public String authorName;
        public String authorPortrait;
        public String business;
        public Integer createTime;
        public Integer distance;
        public Integer flag;
        public Integer forumId;
        public String forumName;
        public String forumShowName;
        public Integer grade;
        public Integer groupId;
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
            if (groupInfo != null) {
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
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupInfo build(boolean z) {
            return new GroupInfo(this, z, null);
        }
    }
}
