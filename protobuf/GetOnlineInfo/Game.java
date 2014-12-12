package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class Game extends Message {
    @ProtoField(tag = 3)
    public final GameEnter gameEnter;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long gameLastLaunchtime;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long game_last_launchtime;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer hasGameCenter;
    public static final Long DEFAULT_GAME_LAST_LAUNCHTIME = 0L;
    public static final Long DEFAULT_GAMELASTLAUNCHTIME = 0L;
    public static final Integer DEFAULT_HASGAMECENTER = 0;

    /* synthetic */ Game(Builder builder, boolean z, Game game) {
        this(builder, z);
    }

    private Game(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.game_last_launchtime == null) {
                this.game_last_launchtime = DEFAULT_GAME_LAST_LAUNCHTIME;
            } else {
                this.game_last_launchtime = builder.game_last_launchtime;
            }
            if (builder.gameLastLaunchtime == null) {
                this.gameLastLaunchtime = DEFAULT_GAMELASTLAUNCHTIME;
            } else {
                this.gameLastLaunchtime = builder.gameLastLaunchtime;
            }
            this.gameEnter = builder.gameEnter;
            if (builder.hasGameCenter == null) {
                this.hasGameCenter = DEFAULT_HASGAMECENTER;
                return;
            } else {
                this.hasGameCenter = builder.hasGameCenter;
                return;
            }
        }
        this.game_last_launchtime = builder.game_last_launchtime;
        this.gameLastLaunchtime = builder.gameLastLaunchtime;
        this.gameEnter = builder.gameEnter;
        this.hasGameCenter = builder.hasGameCenter;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<Game> {
        public GameEnter gameEnter;
        public Long gameLastLaunchtime;
        public Long game_last_launchtime;
        public Integer hasGameCenter;

        public Builder(Game game) {
            super(game);
            if (game != null) {
                this.game_last_launchtime = game.game_last_launchtime;
                this.gameLastLaunchtime = game.gameLastLaunchtime;
                this.gameEnter = game.gameEnter;
                this.hasGameCenter = game.hasGameCenter;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Game build(boolean z) {
            return new Game(this, z, null);
        }
    }
}
