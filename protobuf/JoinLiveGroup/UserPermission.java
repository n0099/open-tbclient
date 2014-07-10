package protobuf.JoinLiveGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class UserPermission extends Message {
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer canForenoticeMsg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer canForenoticeThread;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isBanned;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isGroupOwner;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer isLike;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer isSubscribe;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String userName;
    public static final Integer DEFAULT_ISGROUPOWNER = 0;
    public static final Integer DEFAULT_ISBANNED = 0;
    public static final Integer DEFAULT_CANFORENOTICETHREAD = 0;
    public static final Integer DEFAULT_CANFORENOTICEMSG = 0;
    public static final Integer DEFAULT_ISSUBSCRIBE = 0;
    public static final Integer DEFAULT_ISLIKE = 0;
    public static final Integer DEFAULT_USERID = 0;

    /* synthetic */ UserPermission(Builder builder, boolean z, UserPermission userPermission) {
        this(builder, z);
    }

    private UserPermission(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.isGroupOwner == null) {
                this.isGroupOwner = DEFAULT_ISGROUPOWNER;
            } else {
                this.isGroupOwner = builder.isGroupOwner;
            }
            if (builder.isBanned == null) {
                this.isBanned = DEFAULT_ISBANNED;
            } else {
                this.isBanned = builder.isBanned;
            }
            if (builder.canForenoticeThread == null) {
                this.canForenoticeThread = DEFAULT_CANFORENOTICETHREAD;
            } else {
                this.canForenoticeThread = builder.canForenoticeThread;
            }
            if (builder.canForenoticeMsg == null) {
                this.canForenoticeMsg = DEFAULT_CANFORENOTICEMSG;
            } else {
                this.canForenoticeMsg = builder.canForenoticeMsg;
            }
            if (builder.isSubscribe == null) {
                this.isSubscribe = DEFAULT_ISSUBSCRIBE;
            } else {
                this.isSubscribe = builder.isSubscribe;
            }
            if (builder.isLike == null) {
                this.isLike = DEFAULT_ISLIKE;
            } else {
                this.isLike = builder.isLike;
            }
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
            if (builder.portrait == null) {
                this.portrait = "";
                return;
            } else {
                this.portrait = builder.portrait;
                return;
            }
        }
        this.isGroupOwner = builder.isGroupOwner;
        this.isBanned = builder.isBanned;
        this.canForenoticeThread = builder.canForenoticeThread;
        this.canForenoticeMsg = builder.canForenoticeMsg;
        this.isSubscribe = builder.isSubscribe;
        this.isLike = builder.isLike;
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.portrait = builder.portrait;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<UserPermission> {
        public Integer canForenoticeMsg;
        public Integer canForenoticeThread;
        public Integer isBanned;
        public Integer isGroupOwner;
        public Integer isLike;
        public Integer isSubscribe;
        public String portrait;
        public Integer userId;
        public String userName;

        public Builder(UserPermission userPermission) {
            super(userPermission);
            if (userPermission != null) {
                this.isGroupOwner = userPermission.isGroupOwner;
                this.isBanned = userPermission.isBanned;
                this.canForenoticeThread = userPermission.canForenoticeThread;
                this.canForenoticeMsg = userPermission.canForenoticeMsg;
                this.isSubscribe = userPermission.isSubscribe;
                this.isLike = userPermission.isLike;
                this.userId = userPermission.userId;
                this.userName = userPermission.userName;
                this.portrait = userPermission.portrait;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserPermission build(boolean z) {
            return new UserPermission(this, z, null);
        }
    }
}
