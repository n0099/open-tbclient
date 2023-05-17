package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class SpringVirtualUser extends Message {
    public static final Integer DEFAULT_ISVIRTUAL = 0;
    public static final String DEFAULT_URL = "";
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer isVirtual;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String url;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<SpringVirtualUser> {
        public Integer isVirtual;
        public String url;

        public Builder() {
        }

        public Builder(SpringVirtualUser springVirtualUser) {
            super(springVirtualUser);
            if (springVirtualUser == null) {
                return;
            }
            this.isVirtual = springVirtualUser.isVirtual;
            this.url = springVirtualUser.url;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SpringVirtualUser build(boolean z) {
            return new SpringVirtualUser(this, z);
        }
    }

    public SpringVirtualUser(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isVirtual;
            if (num == null) {
                this.isVirtual = DEFAULT_ISVIRTUAL;
            } else {
                this.isVirtual = num;
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
        this.isVirtual = builder.isVirtual;
        this.url = builder.url;
    }
}
