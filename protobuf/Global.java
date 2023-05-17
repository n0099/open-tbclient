package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class Global extends Message {
    public static final String DEFAULT_TBMALLNEWPROPS = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String tbmallNewprops;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<Global> {
        public String tbmallNewprops;

        public Builder() {
        }

        public Builder(Global global) {
            super(global);
            if (global == null) {
                return;
            }
            this.tbmallNewprops = global.tbmallNewprops;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Global build(boolean z) {
            return new Global(this, z);
        }
    }

    public Global(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.tbmallNewprops;
            if (str == null) {
                this.tbmallNewprops = "";
                return;
            } else {
                this.tbmallNewprops = str;
                return;
            }
        }
        this.tbmallNewprops = builder.tbmallNewprops;
    }
}
