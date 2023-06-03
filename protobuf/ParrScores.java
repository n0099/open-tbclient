package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class ParrScores extends Message {
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long iMoney;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long iOther;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long iTotal;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer scoresFetch;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer scoresMoney;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer scoresOther;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer scoresTotal;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer updateTime;
    public static final Integer DEFAULT_SCORESTOTAL = 0;
    public static final Integer DEFAULT_SCORESFETCH = 0;
    public static final Integer DEFAULT_SCORESMONEY = 0;
    public static final Integer DEFAULT_SCORESOTHER = 0;
    public static final Integer DEFAULT_UPDATETIME = 0;
    public static final Integer DEFAULT_LEVEL = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Long DEFAULT_ITOTAL = 0L;
    public static final Long DEFAULT_IMONEY = 0L;
    public static final Long DEFAULT_IOTHER = 0L;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ParrScores> {
        public Long iMoney;
        public Long iOther;
        public Long iTotal;
        public Integer level;
        public Integer limit;
        public Integer scoresFetch;
        public Integer scoresMoney;
        public Integer scoresOther;
        public Integer scoresTotal;
        public Integer updateTime;

        public Builder() {
        }

        public Builder(ParrScores parrScores) {
            super(parrScores);
            if (parrScores == null) {
                return;
            }
            this.scoresTotal = parrScores.scoresTotal;
            this.scoresFetch = parrScores.scoresFetch;
            this.scoresMoney = parrScores.scoresMoney;
            this.scoresOther = parrScores.scoresOther;
            this.updateTime = parrScores.updateTime;
            this.level = parrScores.level;
            this.limit = parrScores.limit;
            this.iTotal = parrScores.iTotal;
            this.iMoney = parrScores.iMoney;
            this.iOther = parrScores.iOther;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ParrScores build(boolean z) {
            return new ParrScores(this, z);
        }
    }

    public ParrScores(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.scoresTotal;
            if (num == null) {
                this.scoresTotal = DEFAULT_SCORESTOTAL;
            } else {
                this.scoresTotal = num;
            }
            Integer num2 = builder.scoresFetch;
            if (num2 == null) {
                this.scoresFetch = DEFAULT_SCORESFETCH;
            } else {
                this.scoresFetch = num2;
            }
            Integer num3 = builder.scoresMoney;
            if (num3 == null) {
                this.scoresMoney = DEFAULT_SCORESMONEY;
            } else {
                this.scoresMoney = num3;
            }
            Integer num4 = builder.scoresOther;
            if (num4 == null) {
                this.scoresOther = DEFAULT_SCORESOTHER;
            } else {
                this.scoresOther = num4;
            }
            Integer num5 = builder.updateTime;
            if (num5 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num5;
            }
            Integer num6 = builder.level;
            if (num6 == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num6;
            }
            Integer num7 = builder.limit;
            if (num7 == null) {
                this.limit = DEFAULT_LIMIT;
            } else {
                this.limit = num7;
            }
            Long l = builder.iTotal;
            if (l == null) {
                this.iTotal = DEFAULT_ITOTAL;
            } else {
                this.iTotal = l;
            }
            Long l2 = builder.iMoney;
            if (l2 == null) {
                this.iMoney = DEFAULT_IMONEY;
            } else {
                this.iMoney = l2;
            }
            Long l3 = builder.iOther;
            if (l3 == null) {
                this.iOther = DEFAULT_IOTHER;
                return;
            } else {
                this.iOther = l3;
                return;
            }
        }
        this.scoresTotal = builder.scoresTotal;
        this.scoresFetch = builder.scoresFetch;
        this.scoresMoney = builder.scoresMoney;
        this.scoresOther = builder.scoresOther;
        this.updateTime = builder.updateTime;
        this.level = builder.level;
        this.limit = builder.limit;
        this.iTotal = builder.iTotal;
        this.iMoney = builder.iMoney;
        this.iOther = builder.iOther;
    }
}
