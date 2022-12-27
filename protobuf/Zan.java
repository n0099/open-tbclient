package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class Zan extends Message {
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer consentType;
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
    public static final Integer DEFAULT_CONSENTTYPE = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<Zan> {
        public Integer consentType;
        public Integer isLiked;
        public Integer lastTime;
        public List<Long> likerId;
        public Integer num;

        public Builder() {
        }

        public Builder(Zan zan) {
            super(zan);
            if (zan == null) {
                return;
            }
            this.num = zan.num;
            this.isLiked = zan.isLiked;
            this.lastTime = zan.lastTime;
            this.likerId = Message.copyOf(zan.likerId);
            this.consentType = zan.consentType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Zan build(boolean z) {
            return new Zan(this, z);
        }
    }

    public Zan(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.num;
            if (num == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = num;
            }
            Integer num2 = builder.isLiked;
            if (num2 == null) {
                this.isLiked = DEFAULT_ISLIKED;
            } else {
                this.isLiked = num2;
            }
            Integer num3 = builder.lastTime;
            if (num3 == null) {
                this.lastTime = DEFAULT_LASTTIME;
            } else {
                this.lastTime = num3;
            }
            List<Long> list = builder.likerId;
            if (list == null) {
                this.likerId = DEFAULT_LIKERID;
            } else {
                this.likerId = Message.immutableCopyOf(list);
            }
            Integer num4 = builder.consentType;
            if (num4 == null) {
                this.consentType = DEFAULT_CONSENTTYPE;
                return;
            } else {
                this.consentType = num4;
                return;
            }
        }
        this.num = builder.num;
        this.isLiked = builder.isLiked;
        this.lastTime = builder.lastTime;
        this.likerId = Message.immutableCopyOf(builder.likerId);
        this.consentType = builder.consentType;
    }
}
