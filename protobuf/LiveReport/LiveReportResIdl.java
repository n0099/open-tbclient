package protobuf.LiveReport;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class LiveReportResIdl extends Message {
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ LiveReportResIdl(Builder builder, boolean z, LiveReportResIdl liveReportResIdl) {
        this(builder, z);
    }

    private LiveReportResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<LiveReportResIdl> {
        public Error error;

        public Builder(LiveReportResIdl liveReportResIdl) {
            super(liveReportResIdl);
            if (liveReportResIdl != null) {
                this.error = liveReportResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveReportResIdl build(boolean z) {
            return new LiveReportResIdl(this, z, null);
        }
    }
}
