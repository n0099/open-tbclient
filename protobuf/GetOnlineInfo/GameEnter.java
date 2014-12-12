package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GameEnter extends Message {
    public static final String DEFAULT_LIBAOURL = "";
    public static final String DEFAULT_SINGLETAGNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String libaoUrl;
    @ProtoField(tag = 2)
    public final RateList rateList;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String singleTagName;

    /* synthetic */ GameEnter(Builder builder, boolean z, GameEnter gameEnter) {
        this(builder, z);
    }

    private GameEnter(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.libaoUrl == null) {
                this.libaoUrl = "";
            } else {
                this.libaoUrl = builder.libaoUrl;
            }
            this.rateList = builder.rateList;
            if (builder.singleTagName == null) {
                this.singleTagName = "";
                return;
            } else {
                this.singleTagName = builder.singleTagName;
                return;
            }
        }
        this.libaoUrl = builder.libaoUrl;
        this.rateList = builder.rateList;
        this.singleTagName = builder.singleTagName;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GameEnter> {
        public String libaoUrl;
        public RateList rateList;
        public String singleTagName;

        public Builder(GameEnter gameEnter) {
            super(gameEnter);
            if (gameEnter != null) {
                this.libaoUrl = gameEnter.libaoUrl;
                this.rateList = gameEnter.rateList;
                this.singleTagName = gameEnter.singleTagName;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GameEnter build(boolean z) {
            return new GameEnter(this, z, null);
        }
    }
}
