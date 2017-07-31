package protobuf.QueryUserInfos;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    private IconInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.weight == null) {
                this.weight = DEFAULT_WEIGHT;
            } else {
                this.weight = builder.weight;
            }
            if (builder.iconUrl == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = builder.iconUrl;
                return;
            }
        }
        this.name = builder.name;
        this.weight = builder.weight;
        this.iconUrl = builder.iconUrl;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<IconInfo> {
        public String iconUrl;
        public String name;
        public Integer weight;

        public Builder() {
        }

        public Builder(IconInfo iconInfo) {
            super(iconInfo);
            if (iconInfo != null) {
                this.name = iconInfo.name;
                this.weight = iconInfo.weight;
                this.iconUrl = iconInfo.iconUrl;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IconInfo build(boolean z) {
            return new IconInfo(this, z);
        }
    }
}
