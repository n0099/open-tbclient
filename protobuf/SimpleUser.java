package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class SimpleUser extends Message {
    public static final String DEFAULT_AHEADURL = "";
    public static final String DEFAULT_BLOCKMSG = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_SECUREEMAIL = "";
    public static final String DEFAULT_SECUREMOBIL = "";
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_USERNICKNAME = "";
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer agreeType;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String aheadUrl;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String blockMsg;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer incompleteUser;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String secureemail;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String securemobil;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer showOnlyme;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String userNickname;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userStatus;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_USERSTATUS = 0;
    public static final Integer DEFAULT_INCOMPLETEUSER = 0;
    public static final Integer DEFAULT_AGREETYPE = 0;
    public static final Integer DEFAULT_SHOWONLYME = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<SimpleUser> {
        public Integer agreeType;
        public String aheadUrl;
        public String blockMsg;
        public Integer incompleteUser;
        public String portrait;
        public String secureemail;
        public String securemobil;
        public Integer showOnlyme;
        public Long userId;
        public String userName;
        public String userNickname;
        public Integer userStatus;

        public Builder() {
        }

        public Builder(SimpleUser simpleUser) {
            super(simpleUser);
            if (simpleUser == null) {
                return;
            }
            this.userId = simpleUser.userId;
            this.userStatus = simpleUser.userStatus;
            this.secureemail = simpleUser.secureemail;
            this.securemobil = simpleUser.securemobil;
            this.userName = simpleUser.userName;
            this.userNickname = simpleUser.userNickname;
            this.incompleteUser = simpleUser.incompleteUser;
            this.portrait = simpleUser.portrait;
            this.agreeType = simpleUser.agreeType;
            this.aheadUrl = simpleUser.aheadUrl;
            this.blockMsg = simpleUser.blockMsg;
            this.showOnlyme = simpleUser.showOnlyme;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SimpleUser build(boolean z) {
            return new SimpleUser(this, z);
        }
    }

    public SimpleUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            Integer num = builder.userStatus;
            if (num == null) {
                this.userStatus = DEFAULT_USERSTATUS;
            } else {
                this.userStatus = num;
            }
            String str = builder.secureemail;
            if (str == null) {
                this.secureemail = "";
            } else {
                this.secureemail = str;
            }
            String str2 = builder.securemobil;
            if (str2 == null) {
                this.securemobil = "";
            } else {
                this.securemobil = str2;
            }
            String str3 = builder.userName;
            if (str3 == null) {
                this.userName = "";
            } else {
                this.userName = str3;
            }
            String str4 = builder.userNickname;
            if (str4 == null) {
                this.userNickname = "";
            } else {
                this.userNickname = str4;
            }
            Integer num2 = builder.incompleteUser;
            if (num2 == null) {
                this.incompleteUser = DEFAULT_INCOMPLETEUSER;
            } else {
                this.incompleteUser = num2;
            }
            String str5 = builder.portrait;
            if (str5 == null) {
                this.portrait = "";
            } else {
                this.portrait = str5;
            }
            Integer num3 = builder.agreeType;
            if (num3 == null) {
                this.agreeType = DEFAULT_AGREETYPE;
            } else {
                this.agreeType = num3;
            }
            String str6 = builder.aheadUrl;
            if (str6 == null) {
                this.aheadUrl = "";
            } else {
                this.aheadUrl = str6;
            }
            String str7 = builder.blockMsg;
            if (str7 == null) {
                this.blockMsg = "";
            } else {
                this.blockMsg = str7;
            }
            Integer num4 = builder.showOnlyme;
            if (num4 == null) {
                this.showOnlyme = DEFAULT_SHOWONLYME;
                return;
            } else {
                this.showOnlyme = num4;
                return;
            }
        }
        this.userId = builder.userId;
        this.userStatus = builder.userStatus;
        this.secureemail = builder.secureemail;
        this.securemobil = builder.securemobil;
        this.userName = builder.userName;
        this.userNickname = builder.userNickname;
        this.incompleteUser = builder.incompleteUser;
        this.portrait = builder.portrait;
        this.agreeType = builder.agreeType;
        this.aheadUrl = builder.aheadUrl;
        this.blockMsg = builder.blockMsg;
        this.showOnlyme = builder.showOnlyme;
    }
}
