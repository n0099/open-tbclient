package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class AvatarFrame extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    public static final Integer DEFAULT_PROPSID = 0;
    public static final Integer DEFAULT_ENDTIME = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<AvatarFrame> {
        public Integer endTime;
        public Integer propsId;

        public Builder() {
        }

        public Builder(AvatarFrame avatarFrame) {
            super(avatarFrame);
            if (avatarFrame == null) {
                return;
            }
            this.propsId = avatarFrame.propsId;
            this.endTime = avatarFrame.endTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AvatarFrame build(boolean z) {
            return new AvatarFrame(this, z);
        }
    }

    public AvatarFrame(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.propsId;
            if (num == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
                return;
            } else {
                this.endTime = num2;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.endTime = builder.endTime;
    }
}
