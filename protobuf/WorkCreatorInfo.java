package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class WorkCreatorInfo extends Message {
    public static final String DEFAULT_AUTHDESC = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String authDesc;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<WorkCreatorInfo> {
        public String authDesc;

        public Builder() {
        }

        public Builder(WorkCreatorInfo workCreatorInfo) {
            super(workCreatorInfo);
            if (workCreatorInfo == null) {
                return;
            }
            this.authDesc = workCreatorInfo.authDesc;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public WorkCreatorInfo build(boolean z) {
            return new WorkCreatorInfo(this, z);
        }
    }

    public WorkCreatorInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.authDesc;
            if (str == null) {
                this.authDesc = "";
                return;
            } else {
                this.authDesc = str;
                return;
            }
        }
        this.authDesc = builder.authDesc;
    }
}
