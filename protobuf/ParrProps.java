package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class ParrProps extends Message {
    public static final Integer DEFAULT_PORTRAITTIME = 0;
    public static final List<Props> DEFAULT_PROPS = Collections.emptyList();
    @ProtoField(tag = 2)
    public final Level level;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer portraitTime;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<Props> props;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<ParrProps> {
        public Level level;
        public Integer portraitTime;
        public List<Props> props;

        public Builder() {
        }

        public Builder(ParrProps parrProps) {
            super(parrProps);
            if (parrProps == null) {
                return;
            }
            this.portraitTime = parrProps.portraitTime;
            this.level = parrProps.level;
            this.props = Message.copyOf(parrProps.props);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ParrProps build(boolean z) {
            return new ParrProps(this, z);
        }
    }

    public ParrProps(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.portraitTime;
            if (num == null) {
                this.portraitTime = DEFAULT_PORTRAITTIME;
            } else {
                this.portraitTime = num;
            }
            this.level = builder.level;
            List<Props> list = builder.props;
            if (list == null) {
                this.props = DEFAULT_PROPS;
                return;
            } else {
                this.props = Message.immutableCopyOf(list);
                return;
            }
        }
        this.portraitTime = builder.portraitTime;
        this.level = builder.level;
        this.props = Message.immutableCopyOf(builder.props);
    }
}
