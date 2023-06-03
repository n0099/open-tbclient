package protobuf.QueryHistoryMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class MsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long sendTime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Long DEFAULT_SENDTIME = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_ID = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<MsgInfo> {
        public String content;
        public Integer id;
        public Long sendTime;
        public Integer type;

        public Builder() {
        }

        public Builder(MsgInfo msgInfo) {
            super(msgInfo);
            if (msgInfo == null) {
                return;
            }
            this.sendTime = msgInfo.sendTime;
            this.type = msgInfo.type;
            this.content = msgInfo.content;
            this.id = msgInfo.id;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MsgInfo build(boolean z) {
            return new MsgInfo(this, z);
        }
    }

    public MsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.sendTime;
            if (l == null) {
                this.sendTime = DEFAULT_SENDTIME;
            } else {
                this.sendTime = l;
            }
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            Integer num2 = builder.id;
            if (num2 == null) {
                this.id = DEFAULT_ID;
                return;
            } else {
                this.id = num2;
                return;
            }
        }
        this.sendTime = builder.sendTime;
        this.type = builder.type;
        this.content = builder.content;
        this.id = builder.id;
    }
}
