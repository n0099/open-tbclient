package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Balv extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer daysTofree;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBlack;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isBlock;
    public static final Integer DEFAULT_ISBLACK = 0;
    public static final Integer DEFAULT_ISBLOCK = 0;
    public static final Integer DEFAULT_DAYSTOFREE = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Balv> {
        public Integer daysTofree;
        public Integer isBlack;
        public Integer isBlock;

        public Builder() {
        }

        public Builder(Balv balv) {
            super(balv);
            if (balv == null) {
                return;
            }
            this.isBlack = balv.isBlack;
            this.isBlock = balv.isBlock;
            this.daysTofree = balv.daysTofree;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Balv build(boolean z) {
            return new Balv(this, z);
        }
    }

    public Balv(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isBlack;
            if (num == null) {
                this.isBlack = DEFAULT_ISBLACK;
            } else {
                this.isBlack = num;
            }
            Integer num2 = builder.isBlock;
            if (num2 == null) {
                this.isBlock = DEFAULT_ISBLOCK;
            } else {
                this.isBlock = num2;
            }
            Integer num3 = builder.daysTofree;
            if (num3 == null) {
                this.daysTofree = DEFAULT_DAYSTOFREE;
                return;
            } else {
                this.daysTofree = num3;
                return;
            }
        }
        this.isBlack = builder.isBlack;
        this.isBlock = builder.isBlock;
        this.daysTofree = builder.daysTofree;
    }
}
