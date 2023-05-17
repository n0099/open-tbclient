package protobuf.GetTWHotBenefitRule;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class BenefitInfo extends Message {
    public static final String DEFAULT_BENEFIT = "";
    public static final String DEFAULT_IMAGE = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String benefit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String image;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<BenefitInfo> {
        public String benefit;
        public String image;

        public Builder() {
        }

        public Builder(BenefitInfo benefitInfo) {
            super(benefitInfo);
            if (benefitInfo == null) {
                return;
            }
            this.image = benefitInfo.image;
            this.benefit = benefitInfo.benefit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BenefitInfo build(boolean z) {
            return new BenefitInfo(this, z);
        }
    }

    public BenefitInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.image;
            if (str == null) {
                this.image = "";
            } else {
                this.image = str;
            }
            String str2 = builder.benefit;
            if (str2 == null) {
                this.benefit = "";
                return;
            } else {
                this.benefit = str2;
                return;
            }
        }
        this.image = builder.image;
        this.benefit = builder.benefit;
    }
}
