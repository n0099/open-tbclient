package protobuf.GetMaskInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class UserInfo extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAMESHOW = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final Long DEFAULT_UID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String nameShow;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long uid;

    private UserInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.portrait == null) {
                this.portrait = "";
            } else {
                this.portrait = builder.portrait;
            }
            if (builder.uid == null) {
                this.uid = DEFAULT_UID;
            } else {
                this.uid = builder.uid;
            }
            if (builder.nameShow == null) {
                this.nameShow = "";
                return;
            } else {
                this.nameShow = builder.nameShow;
                return;
            }
        }
        this.name = builder.name;
        this.portrait = builder.portrait;
        this.uid = builder.uid;
        this.nameShow = builder.nameShow;
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<UserInfo> {
        public String name;
        public String nameShow;
        public String portrait;
        public Long uid;

        public Builder() {
        }

        public Builder(UserInfo userInfo) {
            super(userInfo);
            if (userInfo != null) {
                this.name = userInfo.name;
                this.portrait = userInfo.portrait;
                this.uid = userInfo.uid;
                this.nameShow = userInfo.nameShow;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserInfo build(boolean z) {
            return new UserInfo(this, z);
        }
    }
}
