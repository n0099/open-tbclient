package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class GameAttr extends Message {
    public static final String DEFAULT_ISOPEN = "";
    public static final String DEFAULT_USERID = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String isOpen;
    @ProtoField(tag = 2)
    public final SignatureInfo signatureInfo;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String userId;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<GameAttr> {
        public String isOpen;
        public SignatureInfo signatureInfo;
        public String userId;

        public Builder() {
        }

        public Builder(GameAttr gameAttr) {
            super(gameAttr);
            if (gameAttr == null) {
                return;
            }
            this.userId = gameAttr.userId;
            this.signatureInfo = gameAttr.signatureInfo;
            this.isOpen = gameAttr.isOpen;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GameAttr build(boolean z) {
            return new GameAttr(this, z);
        }
    }

    public GameAttr(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.userId;
            if (str == null) {
                this.userId = "";
            } else {
                this.userId = str;
            }
            this.signatureInfo = builder.signatureInfo;
            String str2 = builder.isOpen;
            if (str2 == null) {
                this.isOpen = "";
                return;
            } else {
                this.isOpen = str2;
                return;
            }
        }
        this.userId = builder.userId;
        this.signatureInfo = builder.signatureInfo;
        this.isOpen = builder.isOpen;
    }
}
