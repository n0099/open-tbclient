package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class AlaCoverLabel extends Message {
    public static final Integer DEFAULT_LABELID = 0;
    public static final String DEFAULT_LABELNAME = "";
    public static final String DEFAULT_LABELRGB = "";
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer labelId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String labelName;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String labelRgb;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<AlaCoverLabel> {
        public Integer labelId;
        public String labelName;
        public String labelRgb;

        public Builder() {
        }

        public Builder(AlaCoverLabel alaCoverLabel) {
            super(alaCoverLabel);
            if (alaCoverLabel == null) {
                return;
            }
            this.labelId = alaCoverLabel.labelId;
            this.labelName = alaCoverLabel.labelName;
            this.labelRgb = alaCoverLabel.labelRgb;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaCoverLabel build(boolean z) {
            return new AlaCoverLabel(this, z);
        }
    }

    public AlaCoverLabel(Builder builder, boolean z) {
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
            String str2 = builder.labelRgb;
            if (str2 == null) {
                this.labelRgb = "";
                return;
            } else {
                this.labelRgb = str2;
                return;
            }
        }
        this.labelId = builder.labelId;
        this.labelName = builder.labelName;
        this.labelRgb = builder.labelRgb;
    }
}
