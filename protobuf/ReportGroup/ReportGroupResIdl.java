package protobuf.ReportGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes23.dex */
public final class ReportGroupResIdl extends Message {
    @ProtoField(tag = 4)
    public final Error error;

    private ReportGroupResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
        } else {
            this.error = builder.error;
        }
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<ReportGroupResIdl> {
        public Error error;

        public Builder() {
        }

        public Builder(ReportGroupResIdl reportGroupResIdl) {
            super(reportGroupResIdl);
            if (reportGroupResIdl != null) {
                this.error = reportGroupResIdl.error;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReportGroupResIdl build(boolean z) {
            return new ReportGroupResIdl(this, z);
        }
    }
}
