package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class VipShowInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_VIPICON = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String vipIcon;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<VipShowInfo> {
        public String content;
        public String link;
        public String title;
        public String vipIcon;

        public Builder() {
        }

        public Builder(VipShowInfo vipShowInfo) {
            super(vipShowInfo);
            if (vipShowInfo == null) {
                return;
            }
            this.vipIcon = vipShowInfo.vipIcon;
            this.content = vipShowInfo.content;
            this.link = vipShowInfo.link;
            this.title = vipShowInfo.title;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public VipShowInfo build(boolean z) {
            return new VipShowInfo(this, z);
        }
    }

    public VipShowInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.vipIcon;
            if (str == null) {
                this.vipIcon = "";
            } else {
                this.vipIcon = str;
            }
            String str2 = builder.content;
            if (str2 == null) {
                this.content = "";
            } else {
                this.content = str2;
            }
            String str3 = builder.link;
            if (str3 == null) {
                this.link = "";
            } else {
                this.link = str3;
            }
            String str4 = builder.title;
            if (str4 == null) {
                this.title = "";
                return;
            } else {
                this.title = str4;
                return;
            }
        }
        this.vipIcon = builder.vipIcon;
        this.content = builder.content;
        this.link = builder.link;
        this.title = builder.title;
    }
}
