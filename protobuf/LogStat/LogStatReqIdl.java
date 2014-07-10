package protobuf.LogStat;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LogStatReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ LogStatReqIdl(Builder builder, boolean z, LogStatReqIdl logStatReqIdl) {
        this(builder, z);
    }

    private LogStatReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<LogStatReqIdl> {
        public DataReq data;

        public Builder(LogStatReqIdl logStatReqIdl) {
            super(logStatReqIdl);
            if (logStatReqIdl != null) {
                this.data = logStatReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LogStatReqIdl build(boolean z) {
            return new LogStatReqIdl(this, z, null);
        }
    }
}
