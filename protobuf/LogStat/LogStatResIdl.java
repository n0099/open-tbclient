package protobuf.LogStat;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes11.dex */
public final class LogStatResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private LogStatResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes11.dex */
    public static final class Builder extends Message.Builder<LogStatResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(LogStatResIdl logStatResIdl) {
            super(logStatResIdl);
            if (logStatResIdl != null) {
                this.error = logStatResIdl.error;
                this.data = logStatResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LogStatResIdl build(boolean z) {
            return new LogStatResIdl(this, z);
        }
    }
}
