package protobuf.UpdateClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class ClientConfig extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> groupTypes;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> serviceIds;
    public static final List<String> DEFAULT_SERVICEIDS = Collections.emptyList();
    public static final List<String> DEFAULT_GROUPTYPES = Collections.emptyList();

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ClientConfig> {
        public List<String> groupTypes;
        public List<String> serviceIds;

        public Builder() {
        }

        public Builder(ClientConfig clientConfig) {
            super(clientConfig);
            if (clientConfig == null) {
                return;
            }
            this.serviceIds = Message.copyOf(clientConfig.serviceIds);
            this.groupTypes = Message.copyOf(clientConfig.groupTypes);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ClientConfig build(boolean z) {
            return new ClientConfig(this, z);
        }
    }

    public ClientConfig(Builder builder, boolean z) {
        super(builder);
        if (z) {
            List<String> list = builder.serviceIds;
            if (list == null) {
                this.serviceIds = DEFAULT_SERVICEIDS;
            } else {
                this.serviceIds = Message.immutableCopyOf(list);
            }
            List<String> list2 = builder.groupTypes;
            if (list2 == null) {
                this.groupTypes = DEFAULT_GROUPTYPES;
                return;
            } else {
                this.groupTypes = Message.immutableCopyOf(list2);
                return;
            }
        }
        this.serviceIds = Message.immutableCopyOf(builder.serviceIds);
        this.groupTypes = Message.immutableCopyOf(builder.groupTypes);
    }
}
