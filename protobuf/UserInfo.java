package protobuf;

import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class UserInfo extends Message {
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer inTime;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer lastReplyTime;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer loginTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String nickName;
    @ProtoField(tag = 13)
    public final UserPermission permission;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String position;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sex;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer sysGroupId;
    @ProtoField(label = Message.Label.REPEATED, tag = DealIntentService.CLASS_TYPE_GROUP_EVENT)
    public final List<TshowInfo> tshowIcon;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer userType;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_SEX = 0;
    public static final Double DEFAULT_LNG = Double.valueOf(0.0d);
    public static final Double DEFAULT_LAT = Double.valueOf(0.0d);
    public static final Integer DEFAULT_INTIME = 0;
    public static final Integer DEFAULT_LOGINTIME = 0;
    public static final Integer DEFAULT_LASTREPLYTIME = 0;
    public static final Integer DEFAULT_SYSGROUPID = 0;
    public static final List<TshowInfo> DEFAULT_TSHOWICON = Collections.emptyList();
    public static final Integer DEFAULT_USERTYPE = 0;

    /* synthetic */ UserInfo(Builder builder, boolean z, UserInfo userInfo) {
        this(builder, z);
    }

    private UserInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.userName == null) {
                this.userName = "";
            } else {
                this.userName = builder.userName;
            }
            if (builder.nickName == null) {
                this.nickName = "";
            } else {
                this.nickName = builder.nickName;
            }
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.sex == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = builder.sex;
            }
            if (builder.position == null) {
                this.position = "";
            } else {
                this.position = builder.position;
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
            if (builder.inTime == null) {
                this.inTime = DEFAULT_INTIME;
            } else {
                this.inTime = builder.inTime;
            }
            if (builder.loginTime == null) {
                this.loginTime = DEFAULT_LOGINTIME;
            } else {
                this.loginTime = builder.loginTime;
            }
            if (builder.lastReplyTime == null) {
                this.lastReplyTime = DEFAULT_LASTREPLYTIME;
            } else {
                this.lastReplyTime = builder.lastReplyTime;
            }
            if (builder.sysGroupId == null) {
                this.sysGroupId = DEFAULT_SYSGROUPID;
            } else {
                this.sysGroupId = builder.sysGroupId;
            }
            this.permission = builder.permission;
            if (builder.tshowIcon == null) {
                this.tshowIcon = DEFAULT_TSHOWICON;
            } else {
                this.tshowIcon = immutableCopyOf(builder.tshowIcon);
            }
            if (builder.userType == null) {
                this.userType = DEFAULT_USERTYPE;
                return;
            } else {
                this.userType = builder.userType;
                return;
            }
        }
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.nickName = builder.nickName;
        this.portrait = builder.portrait;
        this.sex = builder.sex;
        this.position = builder.position;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.inTime = builder.inTime;
        this.loginTime = builder.loginTime;
        this.lastReplyTime = builder.lastReplyTime;
        this.sysGroupId = builder.sysGroupId;
        this.permission = builder.permission;
        this.tshowIcon = immutableCopyOf(builder.tshowIcon);
        this.userType = builder.userType;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UserInfo> {
        public Integer inTime;
        public Integer lastReplyTime;
        public Double lat;
        public Double lng;
        public Integer loginTime;
        public String nickName;
        public UserPermission permission;
        public String portrait;
        public String position;
        public Integer sex;
        public Integer sysGroupId;
        public List<TshowInfo> tshowIcon;
        public Integer userId;
        public String userName;
        public Integer userType;

        public Builder(UserInfo userInfo) {
            super(userInfo);
            if (userInfo != null) {
                this.userId = userInfo.userId;
                this.userName = userInfo.userName;
                this.nickName = userInfo.nickName;
                this.portrait = userInfo.portrait;
                this.sex = userInfo.sex;
                this.position = userInfo.position;
                this.lng = userInfo.lng;
                this.lat = userInfo.lat;
                this.inTime = userInfo.inTime;
                this.loginTime = userInfo.loginTime;
                this.lastReplyTime = userInfo.lastReplyTime;
                this.sysGroupId = userInfo.sysGroupId;
                this.permission = userInfo.permission;
                this.tshowIcon = UserInfo.copyOf(userInfo.tshowIcon);
                this.userType = userInfo.userType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserInfo build(boolean z) {
            return new UserInfo(this, z, null);
        }
    }
}
