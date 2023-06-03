package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class SignatureInfo extends Message {
    public static final String DEFAULT_GAMEID = "";
    public static final String DEFAULT_GAMENAME = "";
    public static final String DEFAULT_PLAYER = "";
    public static final String DEFAULT_POWER = "";
    public static final String DEFAULT_SERVER = "";
    @ProtoField(tag = 5)
    public final Avatar avatar;
    @ProtoField(tag = 1)
    public final Equipment equipment;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String gameId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String gameName;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String player;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String power;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String server;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<SignatureInfo> {
        public Avatar avatar;
        public Equipment equipment;
        public String gameId;
        public String gameName;
        public String player;
        public String power;
        public String server;

        public Builder() {
        }

        public Builder(SignatureInfo signatureInfo) {
            super(signatureInfo);
            if (signatureInfo == null) {
                return;
            }
            this.equipment = signatureInfo.equipment;
            this.gameId = signatureInfo.gameId;
            this.gameName = signatureInfo.gameName;
            this.player = signatureInfo.player;
            this.avatar = signatureInfo.avatar;
            this.power = signatureInfo.power;
            this.server = signatureInfo.server;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SignatureInfo build(boolean z) {
            return new SignatureInfo(this, z);
        }
    }

    public SignatureInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.equipment = builder.equipment;
            String str = builder.gameId;
            if (str == null) {
                this.gameId = "";
            } else {
                this.gameId = str;
            }
            String str2 = builder.gameName;
            if (str2 == null) {
                this.gameName = "";
            } else {
                this.gameName = str2;
            }
            String str3 = builder.player;
            if (str3 == null) {
                this.player = "";
            } else {
                this.player = str3;
            }
            this.avatar = builder.avatar;
            String str4 = builder.power;
            if (str4 == null) {
                this.power = "";
            } else {
                this.power = str4;
            }
            String str5 = builder.server;
            if (str5 == null) {
                this.server = "";
                return;
            } else {
                this.server = str5;
                return;
            }
        }
        this.equipment = builder.equipment;
        this.gameId = builder.gameId;
        this.gameName = builder.gameName;
        this.player = builder.player;
        this.avatar = builder.avatar;
        this.power = builder.power;
        this.server = builder.server;
    }
}
