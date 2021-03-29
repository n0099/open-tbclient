package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_CUID = "";
    public static final Boolean DEFAULT_SENDER = Boolean.FALSE;
    public static final String DEFAULT_TO = "";
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cuid;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean sender;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String to;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public String content;
        public String cuid;
        public Boolean sender;
        public String to;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.sender = dataReq.sender;
            this.cuid = dataReq.cuid;
            this.to = dataReq.to;
            this.content = dataReq.content;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Boolean bool = builder.sender;
            if (bool == null) {
                this.sender = DEFAULT_SENDER;
            } else {
                this.sender = bool;
            }
            String str = builder.cuid;
            if (str == null) {
                this.cuid = "";
            } else {
                this.cuid = str;
            }
            String str2 = builder.to;
            if (str2 == null) {
                this.to = "";
            } else {
                this.to = str2;
            }
            String str3 = builder.content;
            if (str3 == null) {
                this.content = "";
                return;
            } else {
                this.content = str3;
                return;
            }
        }
        this.sender = builder.sender;
        this.cuid = builder.cuid;
        this.to = builder.to;
        this.content = builder.content;
    }
}
