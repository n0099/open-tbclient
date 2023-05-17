package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class LiveCoverStatus extends Message {
    public static final String DEFAULT_STATUS = "";
    public static final Integer DEFAULT_STATUSNUM = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer statusNum;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<LiveCoverStatus> {
        public String status;
        public Integer statusNum;

        public Builder() {
        }

        public Builder(LiveCoverStatus liveCoverStatus) {
            super(liveCoverStatus);
            if (liveCoverStatus == null) {
                return;
            }
            this.statusNum = liveCoverStatus.statusNum;
            this.status = liveCoverStatus.status;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveCoverStatus build(boolean z) {
            return new LiveCoverStatus(this, z);
        }
    }

    public LiveCoverStatus(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.statusNum;
            if (num == null) {
                this.statusNum = DEFAULT_STATUSNUM;
            } else {
                this.statusNum = num;
            }
            String str = builder.status;
            if (str == null) {
                this.status = "";
                return;
            } else {
                this.status = str;
                return;
            }
        }
        this.statusNum = builder.statusNum;
        this.status = builder.status;
    }
}
