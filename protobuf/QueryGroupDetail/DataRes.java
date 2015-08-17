package protobuf.QueryGroupDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ActivityInfo;
import protobuf.GroupInfo;
import protobuf.Photo;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 12)
    public final List<ActivityInfo> activity;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer alreadyCreateNum;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer canCreateMember;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer canJoinGroupNum;
    @ProtoField(tag = 1)
    public final GroupInfo group;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer hideRecommendGroup;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer isGroupManager;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer isJoin;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer joinGroupNum;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer leftCreateNum;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<UserInfo> member;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<Photo> photo;
    public static final List<Photo> DEFAULT_PHOTO = Collections.emptyList();
    public static final List<UserInfo> DEFAULT_MEMBER = Collections.emptyList();
    public static final Integer DEFAULT_JOINGROUPNUM = 0;
    public static final Integer DEFAULT_CANJOINGROUPNUM = 0;
    public static final Integer DEFAULT_ISJOIN = 0;
    public static final Integer DEFAULT_ISGROUPMANAGER = 0;
    public static final Integer DEFAULT_HIDERECOMMENDGROUP = 0;
    public static final Integer DEFAULT_CANCREATEMEMBER = 0;
    public static final Integer DEFAULT_ALREADYCREATENUM = 0;
    public static final Integer DEFAULT_LEFTCREATENUM = 0;
    public static final List<ActivityInfo> DEFAULT_ACTIVITY = Collections.emptyList();

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            if (builder.photo == null) {
                this.photo = DEFAULT_PHOTO;
            } else {
                this.photo = immutableCopyOf(builder.photo);
            }
            if (builder.member == null) {
                this.member = DEFAULT_MEMBER;
            } else {
                this.member = immutableCopyOf(builder.member);
            }
            if (builder.joinGroupNum == null) {
                this.joinGroupNum = DEFAULT_JOINGROUPNUM;
            } else {
                this.joinGroupNum = builder.joinGroupNum;
            }
            if (builder.canJoinGroupNum == null) {
                this.canJoinGroupNum = DEFAULT_CANJOINGROUPNUM;
            } else {
                this.canJoinGroupNum = builder.canJoinGroupNum;
            }
            if (builder.isJoin == null) {
                this.isJoin = DEFAULT_ISJOIN;
            } else {
                this.isJoin = builder.isJoin;
            }
            if (builder.isGroupManager == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
            } else {
                this.isGroupManager = builder.isGroupManager;
            }
            if (builder.hideRecommendGroup == null) {
                this.hideRecommendGroup = DEFAULT_HIDERECOMMENDGROUP;
            } else {
                this.hideRecommendGroup = builder.hideRecommendGroup;
            }
            if (builder.canCreateMember == null) {
                this.canCreateMember = DEFAULT_CANCREATEMEMBER;
            } else {
                this.canCreateMember = builder.canCreateMember;
            }
            if (builder.alreadyCreateNum == null) {
                this.alreadyCreateNum = DEFAULT_ALREADYCREATENUM;
            } else {
                this.alreadyCreateNum = builder.alreadyCreateNum;
            }
            if (builder.leftCreateNum == null) {
                this.leftCreateNum = DEFAULT_LEFTCREATENUM;
            } else {
                this.leftCreateNum = builder.leftCreateNum;
            }
            if (builder.activity == null) {
                this.activity = DEFAULT_ACTIVITY;
                return;
            } else {
                this.activity = immutableCopyOf(builder.activity);
                return;
            }
        }
        this.group = builder.group;
        this.photo = immutableCopyOf(builder.photo);
        this.member = immutableCopyOf(builder.member);
        this.joinGroupNum = builder.joinGroupNum;
        this.canJoinGroupNum = builder.canJoinGroupNum;
        this.isJoin = builder.isJoin;
        this.isGroupManager = builder.isGroupManager;
        this.hideRecommendGroup = builder.hideRecommendGroup;
        this.canCreateMember = builder.canCreateMember;
        this.alreadyCreateNum = builder.alreadyCreateNum;
        this.leftCreateNum = builder.leftCreateNum;
        this.activity = immutableCopyOf(builder.activity);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public List<ActivityInfo> activity;
        public Integer alreadyCreateNum;
        public Integer canCreateMember;
        public Integer canJoinGroupNum;
        public GroupInfo group;
        public Integer hideRecommendGroup;
        public Integer isGroupManager;
        public Integer isJoin;
        public Integer joinGroupNum;
        public Integer leftCreateNum;
        public List<UserInfo> member;
        public List<Photo> photo;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.group = dataRes.group;
                this.photo = DataRes.copyOf(dataRes.photo);
                this.member = DataRes.copyOf(dataRes.member);
                this.joinGroupNum = dataRes.joinGroupNum;
                this.canJoinGroupNum = dataRes.canJoinGroupNum;
                this.isJoin = dataRes.isJoin;
                this.isGroupManager = dataRes.isGroupManager;
                this.hideRecommendGroup = dataRes.hideRecommendGroup;
                this.canCreateMember = dataRes.canCreateMember;
                this.alreadyCreateNum = dataRes.alreadyCreateNum;
                this.leftCreateNum = dataRes.leftCreateNum;
                this.activity = DataRes.copyOf(dataRes.activity);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
