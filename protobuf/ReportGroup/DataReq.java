package protobuf.ReportGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_REPORTTYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer reportType;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.reportType == null) {
                this.reportType = DEFAULT_REPORTTYPE;
                return;
            } else {
                this.reportType = builder.reportType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.reportType = builder.reportType;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer groupId;
        public Integer reportType;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.reportType = dataReq.reportType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
