package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class BaijiahaoInfo extends Message {
    public static final String DEFAULT_AUTHDESC = "";
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_AVATARH = "";
    public static final String DEFAULT_BRIEF = "";
    public static final String DEFAULT_NAME = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String authDesc;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer authId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatarH;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String brief;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer canModifyAvatar;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    public static final Integer DEFAULT_AUTHID = 0;
    public static final Integer DEFAULT_CANMODIFYAVATAR = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<BaijiahaoInfo> {
        public String authDesc;
        public Integer authId;
        public String avatar;
        public String avatarH;
        public String brief;
        public Integer canModifyAvatar;
        public String name;

        public Builder() {
        }

        public Builder(BaijiahaoInfo baijiahaoInfo) {
            super(baijiahaoInfo);
            if (baijiahaoInfo == null) {
                return;
            }
            this.name = baijiahaoInfo.name;
            this.avatar = baijiahaoInfo.avatar;
            this.avatarH = baijiahaoInfo.avatarH;
            this.brief = baijiahaoInfo.brief;
            this.authId = baijiahaoInfo.authId;
            this.authDesc = baijiahaoInfo.authDesc;
            this.canModifyAvatar = baijiahaoInfo.canModifyAvatar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BaijiahaoInfo build(boolean z) {
            return new BaijiahaoInfo(this, z);
        }
    }

    public BaijiahaoInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            String str3 = builder.avatarH;
            if (str3 == null) {
                this.avatarH = "";
            } else {
                this.avatarH = str3;
            }
            String str4 = builder.brief;
            if (str4 == null) {
                this.brief = "";
            } else {
                this.brief = str4;
            }
            Integer num = builder.authId;
            if (num == null) {
                this.authId = DEFAULT_AUTHID;
            } else {
                this.authId = num;
            }
            String str5 = builder.authDesc;
            if (str5 == null) {
                this.authDesc = "";
            } else {
                this.authDesc = str5;
            }
            Integer num2 = builder.canModifyAvatar;
            if (num2 == null) {
                this.canModifyAvatar = DEFAULT_CANMODIFYAVATAR;
                return;
            } else {
                this.canModifyAvatar = num2;
                return;
            }
        }
        this.name = builder.name;
        this.avatar = builder.avatar;
        this.avatarH = builder.avatarH;
        this.brief = builder.brief;
        this.authId = builder.authId;
        this.authDesc = builder.authDesc;
        this.canModifyAvatar = builder.canModifyAvatar;
    }
}
