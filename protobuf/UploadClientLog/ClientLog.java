package protobuf.UploadClientLog;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class ClientLog extends Message {
    public static final String DEFAULT_ET = "";
    public static final String DEFAULT_NET = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String net;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer process_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer pushcnt;
    public static final Integer DEFAULT_PUSHCNT = 0;
    public static final Integer DEFAULT_PROCESS_TYPE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ClientLog> {
        public String et;
        public String net;
        public Integer process_type;
        public Integer pushcnt;

        public Builder() {
        }

        public Builder(ClientLog clientLog) {
            super(clientLog);
            if (clientLog == null) {
                return;
            }
            this.et = clientLog.et;
            this.pushcnt = clientLog.pushcnt;
            this.net = clientLog.net;
            this.process_type = clientLog.process_type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ClientLog build(boolean z) {
            return new ClientLog(this, z);
        }
    }

    public ClientLog(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.et;
            if (str == null) {
                this.et = "";
            } else {
                this.et = str;
            }
            Integer num = builder.pushcnt;
            if (num == null) {
                this.pushcnt = DEFAULT_PUSHCNT;
            } else {
                this.pushcnt = num;
            }
            String str2 = builder.net;
            if (str2 == null) {
                this.net = "";
            } else {
                this.net = str2;
            }
            Integer num2 = builder.process_type;
            if (num2 == null) {
                this.process_type = DEFAULT_PROCESS_TYPE;
                return;
            } else {
                this.process_type = num2;
                return;
            }
        }
        this.et = builder.et;
        this.pushcnt = builder.pushcnt;
        this.net = builder.net;
        this.process_type = builder.process_type;
    }
}
