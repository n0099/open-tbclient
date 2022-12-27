package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class TwAnchorProfitItem extends Message {
    public static final String DEFAULT_ICONLOCKURL = "";
    public static final String DEFAULT_ICONUNLOCKURL = "";
    public static final String DEFAULT_NAME = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer availableAnchorLevel;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String iconLockUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String iconUnlockUrl;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_AVAILABLEANCHORLEVEL = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<TwAnchorProfitItem> {
        public Integer availableAnchorLevel;
        public String iconLockUrl;
        public String iconUnlockUrl;
        public Integer id;
        public String name;

        public Builder() {
        }

        public Builder(TwAnchorProfitItem twAnchorProfitItem) {
            super(twAnchorProfitItem);
            if (twAnchorProfitItem == null) {
                return;
            }
            this.id = twAnchorProfitItem.id;
            this.availableAnchorLevel = twAnchorProfitItem.availableAnchorLevel;
            this.name = twAnchorProfitItem.name;
            this.iconUnlockUrl = twAnchorProfitItem.iconUnlockUrl;
            this.iconLockUrl = twAnchorProfitItem.iconLockUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TwAnchorProfitItem build(boolean z) {
            return new TwAnchorProfitItem(this, z);
        }
    }

    public TwAnchorProfitItem(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.id;
            if (num == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = num;
            }
            Integer num2 = builder.availableAnchorLevel;
            if (num2 == null) {
                this.availableAnchorLevel = DEFAULT_AVAILABLEANCHORLEVEL;
            } else {
                this.availableAnchorLevel = num2;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.iconUnlockUrl;
            if (str2 == null) {
                this.iconUnlockUrl = "";
            } else {
                this.iconUnlockUrl = str2;
            }
            String str3 = builder.iconLockUrl;
            if (str3 == null) {
                this.iconLockUrl = "";
                return;
            } else {
                this.iconLockUrl = str3;
                return;
            }
        }
        this.id = builder.id;
        this.availableAnchorLevel = builder.availableAnchorLevel;
        this.name = builder.name;
        this.iconUnlockUrl = builder.iconUnlockUrl;
        this.iconLockUrl = builder.iconLockUrl;
    }
}
