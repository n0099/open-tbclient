package protobuf.UploadClientLog;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    public static final List<ClientLog> DEFAULT_CLIENT_LOG = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<ClientLog> client_log;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.client_log == null) {
                this.client_log = DEFAULT_CLIENT_LOG;
                return;
            } else {
                this.client_log = immutableCopyOf(builder.client_log);
                return;
            }
        }
        this.client_log = immutableCopyOf(builder.client_log);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public List<ClientLog> client_log;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.client_log = DataReq.copyOf(dataReq.client_log);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
