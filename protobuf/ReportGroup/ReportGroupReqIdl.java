package protobuf.ReportGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ReportGroupReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ ReportGroupReqIdl(Builder builder, boolean z, ReportGroupReqIdl reportGroupReqIdl) {
        this(builder, z);
    }

    private ReportGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<ReportGroupReqIdl> {
        public DataReq data;

        public Builder(ReportGroupReqIdl reportGroupReqIdl) {
            super(reportGroupReqIdl);
            if (reportGroupReqIdl != null) {
                this.data = reportGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReportGroupReqIdl build(boolean z) {
            return new ReportGroupReqIdl(this, z, null);
        }
    }
}
