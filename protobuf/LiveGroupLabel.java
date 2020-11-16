package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes21.dex */
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

    private LiveGroupLabel(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.labelId == null) {
                this.labelId = DEFAULT_LABELID;
            } else {
                this.labelId = builder.labelId;
            }
            if (builder.labelName == null) {
                this.labelName = "";
            } else {
                this.labelName = builder.labelName;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
                return;
            } else {
                this.type = builder.type;
                return;
            }
        }
        this.labelId = builder.labelId;
        this.labelName = builder.labelName;
        this.type = builder.type;
    }

    /* loaded from: classes21.dex */
    public static final class Builder extends Message.Builder<LiveGroupLabel> {
        public Integer labelId;
        public String labelName;
        public Integer type;

        public Builder() {
        }

        public Builder(LiveGroupLabel liveGroupLabel) {
            super(liveGroupLabel);
            if (liveGroupLabel != null) {
                this.labelId = liveGroupLabel.labelId;
                this.labelName = liveGroupLabel.labelName;
                this.type = liveGroupLabel.type;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveGroupLabel build(boolean z) {
            return new LiveGroupLabel(this, z);
        }
    }
}
