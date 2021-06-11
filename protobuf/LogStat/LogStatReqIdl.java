package protobuf.LogStat;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class LogStatReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<LogStatReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(LogStatReqIdl logStatReqIdl) {
            super(logStatReqIdl);
            if (logStatReqIdl == null) {
                return;
            }
            this.data = logStatReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LogStatReqIdl build(boolean z) {
            return new LogStatReqIdl(this, z);
        }
    }

    public LogStatReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
