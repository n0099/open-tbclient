package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class UserVipInfo extends Message {
    public static final String DEFAULT_ICONURL = "";
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer aScore;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer eTime;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer extScore;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer nScore;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer sTime;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer vLevel;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer vStatus;
    public static final Integer DEFAULT_VSTATUS = 0;
    public static final Integer DEFAULT_STIME = 0;
    public static final Integer DEFAULT_ETIME = 0;
    public static final Integer DEFAULT_EXTSCORE = 0;
    public static final Integer DEFAULT_VLEVEL = 0;
    public static final Integer DEFAULT_ASCORE = 0;
    public static final Integer DEFAULT_NSCORE = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<UserVipInfo> {
        public Integer aScore;
        public Integer eTime;
        public Integer extScore;
        public String iconUrl;
        public Integer nScore;
        public Integer sTime;
        public Integer vLevel;
        public Integer vStatus;

        public Builder() {
        }

        public Builder(UserVipInfo userVipInfo) {
            super(userVipInfo);
            if (userVipInfo == null) {
                return;
            }
            this.vStatus = userVipInfo.vStatus;
            this.sTime = userVipInfo.sTime;
            this.eTime = userVipInfo.eTime;
            this.extScore = userVipInfo.extScore;
            this.vLevel = userVipInfo.vLevel;
            this.aScore = userVipInfo.aScore;
            this.nScore = userVipInfo.nScore;
            this.iconUrl = userVipInfo.iconUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserVipInfo build(boolean z) {
            return new UserVipInfo(this, z);
        }
    }

    public UserVipInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.vStatus;
            if (num == null) {
                this.vStatus = DEFAULT_VSTATUS;
            } else {
                this.vStatus = num;
            }
            Integer num2 = builder.sTime;
            if (num2 == null) {
                this.sTime = DEFAULT_STIME;
            } else {
                this.sTime = num2;
            }
            Integer num3 = builder.eTime;
            if (num3 == null) {
                this.eTime = DEFAULT_ETIME;
            } else {
                this.eTime = num3;
            }
            Integer num4 = builder.extScore;
            if (num4 == null) {
                this.extScore = DEFAULT_EXTSCORE;
            } else {
                this.extScore = num4;
            }
            Integer num5 = builder.vLevel;
            if (num5 == null) {
                this.vLevel = DEFAULT_VLEVEL;
            } else {
                this.vLevel = num5;
            }
            Integer num6 = builder.aScore;
            if (num6 == null) {
                this.aScore = DEFAULT_ASCORE;
            } else {
                this.aScore = num6;
            }
            Integer num7 = builder.nScore;
            if (num7 == null) {
                this.nScore = DEFAULT_NSCORE;
            } else {
                this.nScore = num7;
            }
            String str = builder.iconUrl;
            if (str == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = str;
                return;
            }
        }
        this.vStatus = builder.vStatus;
        this.sTime = builder.sTime;
        this.eTime = builder.eTime;
        this.extScore = builder.extScore;
        this.vLevel = builder.vLevel;
        this.aScore = builder.aScore;
        this.nScore = builder.nScore;
        this.iconUrl = builder.iconUrl;
    }
}
