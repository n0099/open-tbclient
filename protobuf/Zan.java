package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Zan extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isLiked;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer lastTime;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT64)
    public final List<Long> likerId;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer num;
    public static final Integer DEFAULT_NUM = 0;
    public static final Integer DEFAULT_ISLIKED = 0;
    public static final Integer DEFAULT_LASTTIME = 0;
    public static final List<Long> DEFAULT_LIKERID = Collections.emptyList();

    private Zan(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.num == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = builder.num;
            }
            if (builder.isLiked == null) {
                this.isLiked = DEFAULT_ISLIKED;
            } else {
                this.isLiked = builder.isLiked;
            }
            if (builder.lastTime == null) {
                this.lastTime = DEFAULT_LASTTIME;
            } else {
                this.lastTime = builder.lastTime;
            }
            if (builder.likerId == null) {
                this.likerId = DEFAULT_LIKERID;
                return;
            } else {
                this.likerId = immutableCopyOf(builder.likerId);
                return;
            }
        }
        this.num = builder.num;
        this.isLiked = builder.isLiked;
        this.lastTime = builder.lastTime;
        this.likerId = immutableCopyOf(builder.likerId);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<Zan> {
        public Integer isLiked;
        public Integer lastTime;
        public List<Long> likerId;
        public Integer num;

        public Builder() {
        }

        public Builder(Zan zan) {
            super(zan);
            if (zan != null) {
                this.num = zan.num;
                this.isLiked = zan.isLiked;
                this.lastTime = zan.lastTime;
                this.likerId = Zan.copyOf(zan.likerId);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Zan build(boolean z) {
            return new Zan(this, z);
        }
    }
}
