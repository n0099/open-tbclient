package protobuf.ReportGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class ReportGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    private ReportGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<ReportGroupReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(ReportGroupReqIdl reportGroupReqIdl) {
            super(reportGroupReqIdl);
            if (reportGroupReqIdl != null) {
                this.data = reportGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReportGroupReqIdl build(boolean z) {
            return new ReportGroupReqIdl(this, z);
        }
    }
}
