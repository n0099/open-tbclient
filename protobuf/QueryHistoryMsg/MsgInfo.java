package protobuf.QueryHistoryMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
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

    /* synthetic */ MsgInfo(Builder builder, boolean z, MsgInfo msgInfo) {
        this(builder, z);
    }

    private MsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.sendTime == null) {
                this.sendTime = DEFAULT_SENDTIME;
            } else {
                this.sendTime = builder.sendTime;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.id == null) {
                this.id = DEFAULT_ID;
                return;
            } else {
                this.id = builder.id;
                return;
            }
        }
        this.sendTime = builder.sendTime;
        this.type = builder.type;
        this.content = builder.content;
        this.id = builder.id;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<MsgInfo> {
        public String content;
        public Integer id;
        public Long sendTime;
        public Integer type;

        public Builder(MsgInfo msgInfo) {
            super(msgInfo);
            if (msgInfo != null) {
                this.sendTime = msgInfo.sendTime;
                this.type = msgInfo.type;
                this.content = msgInfo.content;
                this.id = msgInfo.id;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MsgInfo build(boolean z) {
            return new MsgInfo(this, z, null);
        }
    }
}
