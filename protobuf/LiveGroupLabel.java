package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class LiveGroupLabel extends Message {
    public static final String DEFAULT_LABELNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer labelId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String labelName;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Integer DEFAULT_LABELID = 0;
    public static final Integer DEFAULT_TYPE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<LiveGroupLabel> {
        public Integer labelId;
        public String labelName;
        public Integer type;

        public Builder() {
        }

        public Builder(LiveGroupLabel liveGroupLabel) {
            super(liveGroupLabel);
            if (liveGroupLabel == null) {
                return;
            }
            this.labelId = liveGroupLabel.labelId;
            this.labelName = liveGroupLabel.labelName;
            this.type = liveGroupLabel.type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveGroupLabel build(boolean z) {
            return new LiveGroupLabel(this, z);
        }
    }

    public LiveGroupLabel(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.labelId;
            if (num == null) {
                this.labelId = DEFAULT_LABELID;
            } else {
                this.labelId = num;
            }
            String str = builder.labelName;
            if (str == null) {
                this.labelName = "";
            } else {
                this.labelName = str;
            }
            Integer num2 = builder.type;
            if (num2 == null) {
                this.type = DEFAULT_TYPE;
                return;
            } else {
                this.type = num2;
                return;
            }
        }
        this.labelId = builder.labelId;
        this.labelName = builder.labelName;
        this.type = builder.type;
    }
}
