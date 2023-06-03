package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class BawuThrones extends Message {
    public static final String DEFAULT_BAZHULEVEL = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bazhuLevel;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer hasSendBcast;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer newestBcastPushuserCnt;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer newestBcastPv;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer totalBcastCnt;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer totalRecommendNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer usedBcastCnt;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer usedRecommendNum;
    public static final Integer DEFAULT_TOTALRECOMMENDNUM = 0;
    public static final Integer DEFAULT_USEDRECOMMENDNUM = 0;
    public static final Integer DEFAULT_USEDBCASTCNT = 0;
    public static final Integer DEFAULT_TOTALBCASTCNT = 0;
    public static final Integer DEFAULT_NEWESTBCASTPV = 0;
    public static final Integer DEFAULT_HASSENDBCAST = 0;
    public static final Integer DEFAULT_NEWESTBCASTPUSHUSERCNT = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<BawuThrones> {
        public String bazhuLevel;
        public Integer hasSendBcast;
        public Integer newestBcastPushuserCnt;
        public Integer newestBcastPv;
        public Integer totalBcastCnt;
        public Integer totalRecommendNum;
        public Integer usedBcastCnt;
        public Integer usedRecommendNum;

        public Builder() {
        }

        public Builder(BawuThrones bawuThrones) {
            super(bawuThrones);
            if (bawuThrones == null) {
                return;
            }
            this.totalRecommendNum = bawuThrones.totalRecommendNum;
            this.usedRecommendNum = bawuThrones.usedRecommendNum;
            this.bazhuLevel = bawuThrones.bazhuLevel;
            this.usedBcastCnt = bawuThrones.usedBcastCnt;
            this.totalBcastCnt = bawuThrones.totalBcastCnt;
            this.newestBcastPv = bawuThrones.newestBcastPv;
            this.hasSendBcast = bawuThrones.hasSendBcast;
            this.newestBcastPushuserCnt = bawuThrones.newestBcastPushuserCnt;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BawuThrones build(boolean z) {
            return new BawuThrones(this, z);
        }
    }

    public BawuThrones(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.totalRecommendNum;
            if (num == null) {
                this.totalRecommendNum = DEFAULT_TOTALRECOMMENDNUM;
            } else {
                this.totalRecommendNum = num;
            }
            Integer num2 = builder.usedRecommendNum;
            if (num2 == null) {
                this.usedRecommendNum = DEFAULT_USEDRECOMMENDNUM;
            } else {
                this.usedRecommendNum = num2;
            }
            String str = builder.bazhuLevel;
            if (str == null) {
                this.bazhuLevel = "";
            } else {
                this.bazhuLevel = str;
            }
            Integer num3 = builder.usedBcastCnt;
            if (num3 == null) {
                this.usedBcastCnt = DEFAULT_USEDBCASTCNT;
            } else {
                this.usedBcastCnt = num3;
            }
            Integer num4 = builder.totalBcastCnt;
            if (num4 == null) {
                this.totalBcastCnt = DEFAULT_TOTALBCASTCNT;
            } else {
                this.totalBcastCnt = num4;
            }
            Integer num5 = builder.newestBcastPv;
            if (num5 == null) {
                this.newestBcastPv = DEFAULT_NEWESTBCASTPV;
            } else {
                this.newestBcastPv = num5;
            }
            Integer num6 = builder.hasSendBcast;
            if (num6 == null) {
                this.hasSendBcast = DEFAULT_HASSENDBCAST;
            } else {
                this.hasSendBcast = num6;
            }
            Integer num7 = builder.newestBcastPushuserCnt;
            if (num7 == null) {
                this.newestBcastPushuserCnt = DEFAULT_NEWESTBCASTPUSHUSERCNT;
                return;
            } else {
                this.newestBcastPushuserCnt = num7;
                return;
            }
        }
        this.totalRecommendNum = builder.totalRecommendNum;
        this.usedRecommendNum = builder.usedRecommendNum;
        this.bazhuLevel = builder.bazhuLevel;
        this.usedBcastCnt = builder.usedBcastCnt;
        this.totalBcastCnt = builder.totalBcastCnt;
        this.newestBcastPv = builder.newestBcastPv;
        this.hasSendBcast = builder.hasSendBcast;
        this.newestBcastPushuserCnt = builder.newestBcastPushuserCnt;
    }
}
