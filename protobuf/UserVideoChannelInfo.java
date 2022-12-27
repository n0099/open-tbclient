package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class UserVideoChannelInfo extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer followChannel;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer manChannel;
    public static final Integer DEFAULT_MANCHANNEL = 0;
    public static final Integer DEFAULT_FOLLOWCHANNEL = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<UserVideoChannelInfo> {
        public Integer followChannel;
        public Integer manChannel;

        public Builder() {
        }

        public Builder(UserVideoChannelInfo userVideoChannelInfo) {
            super(userVideoChannelInfo);
            if (userVideoChannelInfo == null) {
                return;
            }
            this.manChannel = userVideoChannelInfo.manChannel;
            this.followChannel = userVideoChannelInfo.followChannel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserVideoChannelInfo build(boolean z) {
            return new UserVideoChannelInfo(this, z);
        }
    }

    public UserVideoChannelInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.manChannel;
            if (num == null) {
                this.manChannel = DEFAULT_MANCHANNEL;
            } else {
                this.manChannel = num;
            }
            Integer num2 = builder.followChannel;
            if (num2 == null) {
                this.followChannel = DEFAULT_FOLLOWCHANNEL;
                return;
            } else {
                this.followChannel = num2;
                return;
            }
        }
        this.manChannel = builder.manChannel;
        this.followChannel = builder.followChannel;
    }
}
