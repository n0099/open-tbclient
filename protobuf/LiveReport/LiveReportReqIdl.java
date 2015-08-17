package protobuf.LiveReport;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class LiveReportReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ LiveReportReqIdl(Builder builder, boolean z, LiveReportReqIdl liveReportReqIdl) {
        this(builder, z);
    }

    private LiveReportReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<LiveReportReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(LiveReportReqIdl liveReportReqIdl) {
            super(liveReportReqIdl);
            if (liveReportReqIdl != null) {
                this.data = liveReportReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveReportReqIdl build(boolean z) {
            return new LiveReportReqIdl(this, z, null);
        }
    }
}
