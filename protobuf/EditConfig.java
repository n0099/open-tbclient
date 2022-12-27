package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class EditConfig extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isFirstEdit;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer showEdit;
    public static final Integer DEFAULT_SHOWEDIT = 0;
    public static final Integer DEFAULT_ISFIRSTEDIT = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<EditConfig> {
        public Integer isFirstEdit;
        public Integer showEdit;

        public Builder() {
        }

        public Builder(EditConfig editConfig) {
            super(editConfig);
            if (editConfig == null) {
                return;
            }
            this.showEdit = editConfig.showEdit;
            this.isFirstEdit = editConfig.isFirstEdit;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public EditConfig build(boolean z) {
            return new EditConfig(this, z);
        }
    }

    public EditConfig(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.showEdit;
            if (num == null) {
                this.showEdit = DEFAULT_SHOWEDIT;
            } else {
                this.showEdit = num;
            }
            Integer num2 = builder.isFirstEdit;
            if (num2 == null) {
                this.isFirstEdit = DEFAULT_ISFIRSTEDIT;
                return;
            } else {
                this.isFirstEdit = num2;
                return;
            }
        }
        this.showEdit = builder.showEdit;
        this.isFirstEdit = builder.isFirstEdit;
    }
}
