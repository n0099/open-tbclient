package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Portrait extends Message {
    public static final String DEFAULT_URL = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;
    public static final Integer DEFAULT_PROPSID = 0;
    public static final Integer DEFAULT_ENDTIME = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Portrait> {
        public Integer endTime;
        public Integer propsId;
        public String url;

        public Builder() {
        }

        public Builder(Portrait portrait) {
            super(portrait);
            if (portrait == null) {
                return;
            }
            this.propsId = portrait.propsId;
            this.endTime = portrait.endTime;
            this.url = portrait.url;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Portrait build(boolean z) {
            return new Portrait(this, z);
        }
    }

    public Portrait(Builder builder, boolean z) {
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
            } else {
                this.endTime = num2;
            }
            String str = builder.url;
            if (str == null) {
                this.url = "";
                return;
            } else {
                this.url = str;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.endTime = builder.endTime;
        this.url = builder.url;
    }
}
