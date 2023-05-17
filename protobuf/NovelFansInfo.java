package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class NovelFansInfo extends Message {
    public static final Integer DEFAULT_LEVEL = 0;
    public static final String DEFAULT_LEVELICON = "";
    public static final String DEFAULT_LEVELNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String levelIcon;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String levelName;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<NovelFansInfo> {
        public Integer level;
        public String levelIcon;
        public String levelName;

        public Builder() {
        }

        public Builder(NovelFansInfo novelFansInfo) {
            super(novelFansInfo);
            if (novelFansInfo == null) {
                return;
            }
            this.level = novelFansInfo.level;
            this.levelName = novelFansInfo.levelName;
            this.levelIcon = novelFansInfo.levelIcon;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NovelFansInfo build(boolean z) {
            return new NovelFansInfo(this, z);
        }
    }

    public NovelFansInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.level;
            if (num == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num;
            }
            String str = builder.levelName;
            if (str == null) {
                this.levelName = "";
            } else {
                this.levelName = str;
            }
            String str2 = builder.levelIcon;
            if (str2 == null) {
                this.levelIcon = "";
                return;
            } else {
                this.levelIcon = str2;
                return;
            }
        }
        this.level = builder.level;
        this.levelName = builder.levelName;
        this.levelIcon = builder.levelIcon;
    }
}
