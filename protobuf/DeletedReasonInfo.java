package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class DeletedReasonInfo extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isBoomgrow;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isGraysCaleForum;
    public static final Integer DEFAULT_ISGRAYSCALEFORUM = 0;
    public static final Integer DEFAULT_ISBOOMGROW = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DeletedReasonInfo> {
        public Integer isBoomgrow;
        public Integer isGraysCaleForum;

        public Builder() {
        }

        public Builder(DeletedReasonInfo deletedReasonInfo) {
            super(deletedReasonInfo);
            if (deletedReasonInfo == null) {
                return;
            }
            this.isGraysCaleForum = deletedReasonInfo.isGraysCaleForum;
            this.isBoomgrow = deletedReasonInfo.isBoomgrow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DeletedReasonInfo build(boolean z) {
            return new DeletedReasonInfo(this, z);
        }
    }

    public DeletedReasonInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isGraysCaleForum;
            if (num == null) {
                this.isGraysCaleForum = DEFAULT_ISGRAYSCALEFORUM;
            } else {
                this.isGraysCaleForum = num;
            }
            Integer num2 = builder.isBoomgrow;
            if (num2 == null) {
                this.isBoomgrow = DEFAULT_ISBOOMGROW;
                return;
            } else {
                this.isBoomgrow = num2;
                return;
            }
        }
        this.isGraysCaleForum = builder.isGraysCaleForum;
        this.isBoomgrow = builder.isBoomgrow;
    }
}
