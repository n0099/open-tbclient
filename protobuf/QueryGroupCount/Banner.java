package protobuf.QueryGroupCount;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class Banner extends Message {
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_PICURL = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String picUrl;

    /* synthetic */ Banner(Builder builder, boolean z, Banner banner) {
        this(builder, z);
    }

    private Banner(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.link == null) {
                this.link = "";
            } else {
                this.link = builder.link;
            }
            if (builder.picUrl == null) {
                this.picUrl = "";
                return;
            } else {
                this.picUrl = builder.picUrl;
                return;
            }
        }
        this.link = builder.link;
        this.picUrl = builder.picUrl;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<Banner> {
        public String link;
        public String picUrl;

        public Builder(Banner banner) {
            super(banner);
            if (banner != null) {
                this.link = banner.link;
                this.picUrl = banner.picUrl;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Banner build(boolean z) {
            return new Banner(this, z, null);
        }
    }
}
