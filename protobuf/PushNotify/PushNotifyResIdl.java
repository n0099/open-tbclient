package protobuf.PushNotify;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class PushNotifyResIdl extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<PusherMsg> multiMsg;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pushTime;
    public static final Long DEFAULT_PUSHTIME = 0L;
    public static final List<PusherMsg> DEFAULT_MULTIMSG = Collections.emptyList();

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<PushNotifyResIdl> {
        public List<PusherMsg> multiMsg;
        public Long pushTime;

        public Builder() {
        }

        public Builder(PushNotifyResIdl pushNotifyResIdl) {
            super(pushNotifyResIdl);
            if (pushNotifyResIdl == null) {
                return;
            }
            this.pushTime = pushNotifyResIdl.pushTime;
            this.multiMsg = Message.copyOf(pushNotifyResIdl.multiMsg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushNotifyResIdl build(boolean z) {
            return new PushNotifyResIdl(this, z);
        }
    }

    public PushNotifyResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.pushTime;
            if (l == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = l;
            }
            List<PusherMsg> list = builder.multiMsg;
            if (list == null) {
                this.multiMsg = DEFAULT_MULTIMSG;
                return;
            } else {
                this.multiMsg = Message.immutableCopyOf(list);
                return;
            }
        }
        this.pushTime = builder.pushTime;
        this.multiMsg = Message.immutableCopyOf(builder.multiMsg);
    }
}
