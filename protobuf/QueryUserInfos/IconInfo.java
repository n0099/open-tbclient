package protobuf.QueryUserInfos;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class IconInfo extends Message {
    public static final String DEFAULT_ICONURL = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_WEIGHT = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer weight;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<IconInfo> {
        public String iconUrl;
        public String name;
        public Integer weight;

        public Builder() {
        }

        public Builder(IconInfo iconInfo) {
            super(iconInfo);
            if (iconInfo == null) {
                return;
            }
            this.name = iconInfo.name;
            this.weight = iconInfo.weight;
            this.iconUrl = iconInfo.iconUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IconInfo build(boolean z) {
            return new IconInfo(this, z);
        }
    }

    public IconInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            Integer num = builder.weight;
            if (num == null) {
                this.weight = DEFAULT_WEIGHT;
            } else {
                this.weight = num;
            }
            String str2 = builder.iconUrl;
            if (str2 == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = str2;
                return;
            }
        }
        this.name = builder.name;
        this.weight = builder.weight;
        this.iconUrl = builder.iconUrl;
    }
}
