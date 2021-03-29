package protobuf.QueryGroupDetail;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ActivityInfo;
import protobuf.GroupInfo;
import protobuf.Photo;
import protobuf.UserInfo;
/* loaded from: classes7.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 12)
    public final ActivityInfo activity;
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

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public ActivityInfo activity;
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
            if (dataRes == null) {
                return;
            }
            this.group = dataRes.group;
            this.photo = Message.copyOf(dataRes.photo);
            this.member = Message.copyOf(dataRes.member);
            this.joinGroupNum = dataRes.joinGroupNum;
            this.canJoinGroupNum = dataRes.canJoinGroupNum;
            this.isJoin = dataRes.isJoin;
            this.isGroupManager = dataRes.isGroupManager;
            this.hideRecommendGroup = dataRes.hideRecommendGroup;
            this.canCreateMember = dataRes.canCreateMember;
            this.alreadyCreateNum = dataRes.alreadyCreateNum;
            this.leftCreateNum = dataRes.leftCreateNum;
            this.activity = dataRes.activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }

    public DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.group = builder.group;
            List<Photo> list = builder.photo;
            if (list == null) {
                this.photo = DEFAULT_PHOTO;
            } else {
                this.photo = Message.immutableCopyOf(list);
            }
            List<UserInfo> list2 = builder.member;
            if (list2 == null) {
                this.member = DEFAULT_MEMBER;
            } else {
                this.member = Message.immutableCopyOf(list2);
            }
            Integer num = builder.joinGroupNum;
            if (num == null) {
                this.joinGroupNum = DEFAULT_JOINGROUPNUM;
            } else {
                this.joinGroupNum = num;
            }
            Integer num2 = builder.canJoinGroupNum;
            if (num2 == null) {
                this.canJoinGroupNum = DEFAULT_CANJOINGROUPNUM;
            } else {
                this.canJoinGroupNum = num2;
            }
            Integer num3 = builder.isJoin;
            if (num3 == null) {
                this.isJoin = DEFAULT_ISJOIN;
            } else {
                this.isJoin = num3;
            }
            Integer num4 = builder.isGroupManager;
            if (num4 == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
            } else {
                this.isGroupManager = num4;
            }
            Integer num5 = builder.hideRecommendGroup;
            if (num5 == null) {
                this.hideRecommendGroup = DEFAULT_HIDERECOMMENDGROUP;
            } else {
                this.hideRecommendGroup = num5;
            }
            Integer num6 = builder.canCreateMember;
            if (num6 == null) {
                this.canCreateMember = DEFAULT_CANCREATEMEMBER;
            } else {
                this.canCreateMember = num6;
            }
            Integer num7 = builder.alreadyCreateNum;
            if (num7 == null) {
                this.alreadyCreateNum = DEFAULT_ALREADYCREATENUM;
            } else {
                this.alreadyCreateNum = num7;
            }
            Integer num8 = builder.leftCreateNum;
            if (num8 == null) {
                this.leftCreateNum = DEFAULT_LEFTCREATENUM;
            } else {
                this.leftCreateNum = num8;
            }
            this.activity = builder.activity;
            return;
        }
        this.group = builder.group;
        this.photo = Message.immutableCopyOf(builder.photo);
        this.member = Message.immutableCopyOf(builder.member);
        this.joinGroupNum = builder.joinGroupNum;
        this.canJoinGroupNum = builder.canJoinGroupNum;
        this.isJoin = builder.isJoin;
        this.isGroupManager = builder.isGroupManager;
        this.hideRecommendGroup = builder.hideRecommendGroup;
        this.canCreateMember = builder.canCreateMember;
        this.alreadyCreateNum = builder.alreadyCreateNum;
        this.leftCreateNum = builder.leftCreateNum;
        this.activity = builder.activity;
    }
}
