package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class VipCloseAd extends Message {
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> forumClose;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isOpen;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer vipClose;
    public static final Integer DEFAULT_ISOPEN = 0;
    public static final Integer DEFAULT_VIPCLOSE = 0;
    public static final List<Integer> DEFAULT_FORUMCLOSE = Collections.emptyList();

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<VipCloseAd> {
        public List<Integer> forumClose;
        public Integer isOpen;
        public Integer vipClose;

        public Builder() {
        }

        public Builder(VipCloseAd vipCloseAd) {
            super(vipCloseAd);
            if (vipCloseAd == null) {
                return;
            }
            this.isOpen = vipCloseAd.isOpen;
            this.vipClose = vipCloseAd.vipClose;
            this.forumClose = Message.copyOf(vipCloseAd.forumClose);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public VipCloseAd build(boolean z) {
            return new VipCloseAd(this, z);
        }
    }

    public VipCloseAd(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.isOpen;
            if (num == null) {
                this.isOpen = DEFAULT_ISOPEN;
            } else {
                this.isOpen = num;
            }
            Integer num2 = builder.vipClose;
            if (num2 == null) {
                this.vipClose = DEFAULT_VIPCLOSE;
            } else {
                this.vipClose = num2;
            }
            List<Integer> list = builder.forumClose;
            if (list == null) {
                this.forumClose = DEFAULT_FORUMCLOSE;
                return;
            } else {
                this.forumClose = Message.immutableCopyOf(list);
                return;
            }
        }
        this.isOpen = builder.isOpen;
        this.vipClose = builder.vipClose;
        this.forumClose = Message.immutableCopyOf(builder.forumClose);
    }
}
