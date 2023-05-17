package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class NewParrScores extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long iTotal;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long scoresTotal;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer updateTime;
    public static final Long DEFAULT_SCORESTOTAL = 0L;
    public static final Integer DEFAULT_UPDATETIME = 0;
    public static final Long DEFAULT_ITOTAL = 0L;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<NewParrScores> {
        public Long iTotal;
        public Long scoresTotal;
        public Integer updateTime;

        public Builder() {
        }

        public Builder(NewParrScores newParrScores) {
            super(newParrScores);
            if (newParrScores == null) {
                return;
            }
            this.scoresTotal = newParrScores.scoresTotal;
            this.updateTime = newParrScores.updateTime;
            this.iTotal = newParrScores.iTotal;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewParrScores build(boolean z) {
            return new NewParrScores(this, z);
        }
    }

    public NewParrScores(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.scoresTotal;
            if (l == null) {
                this.scoresTotal = DEFAULT_SCORESTOTAL;
            } else {
                this.scoresTotal = l;
            }
            Integer num = builder.updateTime;
            if (num == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num;
            }
            Long l2 = builder.iTotal;
            if (l2 == null) {
                this.iTotal = DEFAULT_ITOTAL;
                return;
            } else {
                this.iTotal = l2;
                return;
            }
        }
        this.scoresTotal = builder.scoresTotal;
        this.updateTime = builder.updateTime;
        this.iTotal = builder.iTotal;
    }
}
