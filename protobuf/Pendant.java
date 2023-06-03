package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Pendant extends Message {
    public static final String DEFAULT_IMGURL = "";
    public static final Long DEFAULT_PROPSID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String imgUrl;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long propsId;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Pendant> {
        public String imgUrl;
        public Long propsId;

        public Builder() {
        }

        public Builder(Pendant pendant) {
            super(pendant);
            if (pendant == null) {
                return;
            }
            this.propsId = pendant.propsId;
            this.imgUrl = pendant.imgUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Pendant build(boolean z) {
            return new Pendant(this, z);
        }
    }

    public Pendant(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.propsId;
            if (l == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = l;
            }
            String str = builder.imgUrl;
            if (str == null) {
                this.imgUrl = "";
                return;
            } else {
                this.imgUrl = str;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.imgUrl = builder.imgUrl;
    }
}
