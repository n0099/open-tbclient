package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class PluginUser extends Message {
    public static final String DEFAULT_USERNAMESHOW = "";
    public static final String DEFAULT_USERPHOTO = "";
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer isDownloadCardWhiteuser;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userNameShow;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String userPhoto;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userType;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_USERTYPE = 0;
    public static final Integer DEFAULT_ISDOWNLOADCARDWHITEUSER = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<PluginUser> {
        public Integer isDownloadCardWhiteuser;
        public Long userId;
        public String userNameShow;
        public String userPhoto;
        public Integer userType;

        public Builder() {
        }

        public Builder(PluginUser pluginUser) {
            super(pluginUser);
            if (pluginUser == null) {
                return;
            }
            this.userId = pluginUser.userId;
            this.userNameShow = pluginUser.userNameShow;
            this.userType = pluginUser.userType;
            this.userPhoto = pluginUser.userPhoto;
            this.isDownloadCardWhiteuser = pluginUser.isDownloadCardWhiteuser;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PluginUser build(boolean z) {
            return new PluginUser(this, z);
        }
    }

    public PluginUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            String str = builder.userNameShow;
            if (str == null) {
                this.userNameShow = "";
            } else {
                this.userNameShow = str;
            }
            Integer num = builder.userType;
            if (num == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num;
            }
            String str2 = builder.userPhoto;
            if (str2 == null) {
                this.userPhoto = "";
            } else {
                this.userPhoto = str2;
            }
            Integer num2 = builder.isDownloadCardWhiteuser;
            if (num2 == null) {
                this.isDownloadCardWhiteuser = DEFAULT_ISDOWNLOADCARDWHITEUSER;
                return;
            } else {
                this.isDownloadCardWhiteuser = num2;
                return;
            }
        }
        this.userId = builder.userId;
        this.userNameShow = builder.userNameShow;
        this.userType = builder.userType;
        this.userPhoto = builder.userPhoto;
        this.isDownloadCardWhiteuser = builder.isDownloadCardWhiteuser;
    }
}
