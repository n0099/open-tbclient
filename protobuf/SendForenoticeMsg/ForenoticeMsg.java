package protobuf.SendForenoticeMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ForenoticeMsg extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_GROUPID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;

    /* synthetic */ ForenoticeMsg(Builder builder, boolean z, ForenoticeMsg forenoticeMsg) {
        this(builder, z);
    }

    private ForenoticeMsg(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.content == null) {
                this.content = "";
                return;
            } else {
                this.content = builder.content;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.content = builder.content;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ForenoticeMsg> {
        public String content;
        public Integer groupId;

        public Builder(ForenoticeMsg forenoticeMsg) {
            super(forenoticeMsg);
            if (forenoticeMsg != null) {
                this.groupId = forenoticeMsg.groupId;
                this.content = forenoticeMsg.content;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForenoticeMsg build(boolean z) {
            return new ForenoticeMsg(this, z, null);
        }
    }
}
