package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class LiveRoomInfo extends Message {
    public static final String DEFAULT_BTNTITLE = "";
    public static final String DEFAULT_JUMPURL = "";
    public static final Integer DEFAULT_OWNROOMCOUNT = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String btnTitle;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String jumpUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ownRoomCount;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<LiveRoomInfo> {
        public String btnTitle;
        public String jumpUrl;
        public Integer ownRoomCount;

        public Builder() {
        }

        public Builder(LiveRoomInfo liveRoomInfo) {
            super(liveRoomInfo);
            if (liveRoomInfo == null) {
                return;
            }
            this.btnTitle = liveRoomInfo.btnTitle;
            this.ownRoomCount = liveRoomInfo.ownRoomCount;
            this.jumpUrl = liveRoomInfo.jumpUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveRoomInfo build(boolean z) {
            return new LiveRoomInfo(this, z);
        }
    }

    public LiveRoomInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.btnTitle;
            if (str == null) {
                this.btnTitle = "";
            } else {
                this.btnTitle = str;
            }
            Integer num = builder.ownRoomCount;
            if (num == null) {
                this.ownRoomCount = DEFAULT_OWNROOMCOUNT;
            } else {
                this.ownRoomCount = num;
            }
            String str2 = builder.jumpUrl;
            if (str2 == null) {
                this.jumpUrl = "";
                return;
            } else {
                this.jumpUrl = str2;
                return;
            }
        }
        this.btnTitle = builder.btnTitle;
        this.ownRoomCount = builder.ownRoomCount;
        this.jumpUrl = builder.jumpUrl;
    }
}
