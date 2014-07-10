package protobuf.QueryLiveGroupLikeList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LikeUserInfo extends Message {
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer time;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_TIME = 0;

    /* synthetic */ LikeUserInfo(Builder builder, boolean z, LikeUserInfo likeUserInfo) {
        this(builder, z);
    }

    private LikeUserInfo(Builder builder, boolean z) {
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
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.time == null) {
                this.time = DEFAULT_TIME;
                return;
            } else {
                this.time = builder.time;
                return;
            }
        }
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.portrait = builder.portrait;
        this.time = builder.time;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<LikeUserInfo> {
        public String portrait;
        public Integer time;
        public Integer userId;
        public String userName;

        public Builder(LikeUserInfo likeUserInfo) {
            super(likeUserInfo);
            if (likeUserInfo != null) {
                this.userId = likeUserInfo.userId;
                this.userName = likeUserInfo.userName;
                this.portrait = likeUserInfo.portrait;
                this.time = likeUserInfo.time;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LikeUserInfo build(boolean z) {
            return new LikeUserInfo(this, z, null);
        }
    }
}
