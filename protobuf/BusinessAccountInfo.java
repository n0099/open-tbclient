package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class BusinessAccountInfo extends Message {
    public static final String DEFAULT_BUSINESSNAME = "";
    public static final String DEFAULT_IDENTIFIEXPLAIN = "";
    public static final Integer DEFAULT_ISBUSINESSACCOUNT = 0;
    public static final Integer DEFAULT_ISFORUMBUSINESSACCOUNT = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String businessName;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String identifiExplain;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBusinessAccount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isForumBusinessAccount;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<BusinessAccountInfo> {
        public String businessName;
        public String identifiExplain;
        public Integer isBusinessAccount;
        public Integer isForumBusinessAccount;

        public Builder() {
        }

        public Builder(BusinessAccountInfo businessAccountInfo) {
            super(businessAccountInfo);
            if (businessAccountInfo == null) {
                return;
            }
            this.isBusinessAccount = businessAccountInfo.isBusinessAccount;
            this.isForumBusinessAccount = businessAccountInfo.isForumBusinessAccount;
            this.businessName = businessAccountInfo.businessName;
            this.identifiExplain = businessAccountInfo.identifiExplain;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BusinessAccountInfo build(boolean z) {
            return new BusinessAccountInfo(this, z);
        }
    }

    public BusinessAccountInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isBusinessAccount;
            if (num == null) {
                this.isBusinessAccount = DEFAULT_ISBUSINESSACCOUNT;
            } else {
                this.isBusinessAccount = num;
            }
            Integer num2 = builder.isForumBusinessAccount;
            if (num2 == null) {
                this.isForumBusinessAccount = DEFAULT_ISFORUMBUSINESSACCOUNT;
            } else {
                this.isForumBusinessAccount = num2;
            }
            String str = builder.businessName;
            if (str == null) {
                this.businessName = "";
            } else {
                this.businessName = str;
            }
            String str2 = builder.identifiExplain;
            if (str2 == null) {
                this.identifiExplain = "";
                return;
            } else {
                this.identifiExplain = str2;
                return;
            }
        }
        this.isBusinessAccount = builder.isBusinessAccount;
        this.isForumBusinessAccount = builder.isForumBusinessAccount;
        this.businessName = builder.businessName;
        this.identifiExplain = builder.identifiExplain;
    }
}
