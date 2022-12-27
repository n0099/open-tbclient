package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class NoticeMask extends Message {
    public static final Integer DEFAULT_ATTRTYPE = 0;
    public static final String DEFAULT_ATTRVALUE = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer attrType;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String attrValue;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<NoticeMask> {
        public Integer attrType;
        public String attrValue;

        public Builder() {
        }

        public Builder(NoticeMask noticeMask) {
            super(noticeMask);
            if (noticeMask == null) {
                return;
            }
            this.attrType = noticeMask.attrType;
            this.attrValue = noticeMask.attrValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NoticeMask build(boolean z) {
            return new NoticeMask(this, z);
        }
    }

    public NoticeMask(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.attrType;
            if (num == null) {
                this.attrType = DEFAULT_ATTRTYPE;
            } else {
                this.attrType = num;
            }
            String str = builder.attrValue;
            if (str == null) {
                this.attrValue = "";
                return;
            } else {
                this.attrValue = str;
                return;
            }
        }
        this.attrType = builder.attrType;
        this.attrValue = builder.attrValue;
    }
}
