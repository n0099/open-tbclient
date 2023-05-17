package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class TbVipInfo extends Message {
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_VDETAIL = "";
    public static final String DEFAULT_VURL = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String vDetail;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String vUrl;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<TbVipInfo> {
        public String intro;
        public String vDetail;
        public String vUrl;

        public Builder() {
        }

        public Builder(TbVipInfo tbVipInfo) {
            super(tbVipInfo);
            if (tbVipInfo == null) {
                return;
            }
            this.intro = tbVipInfo.intro;
            this.vUrl = tbVipInfo.vUrl;
            this.vDetail = tbVipInfo.vDetail;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TbVipInfo build(boolean z) {
            return new TbVipInfo(this, z);
        }
    }

    public TbVipInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.intro;
            if (str == null) {
                this.intro = "";
            } else {
                this.intro = str;
            }
            String str2 = builder.vUrl;
            if (str2 == null) {
                this.vUrl = "";
            } else {
                this.vUrl = str2;
            }
            String str3 = builder.vDetail;
            if (str3 == null) {
                this.vDetail = "";
                return;
            } else {
                this.vDetail = str3;
                return;
            }
        }
        this.intro = builder.intro;
        this.vUrl = builder.vUrl;
        this.vDetail = builder.vDetail;
    }
}
