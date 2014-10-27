package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    @ProtoField(tag = 2)
    public final Game game;
    @ProtoField(tag = 1)
    public final Gift gift;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.gift = builder.gift;
            this.game = builder.game;
            return;
        }
        this.gift = builder.gift;
        this.game = builder.game;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Game game;
        public Gift gift;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.gift = dataRes.gift;
                this.game = dataRes.game;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
