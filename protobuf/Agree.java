package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Agree extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long agreeNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer agreeType;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long diffAgreeNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long disagreeNum;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer hasAgree;
    public static final Long DEFAULT_AGREENUM = 0L;
    public static final Integer DEFAULT_HASAGREE = 0;
    public static final Integer DEFAULT_AGREETYPE = 0;
    public static final Long DEFAULT_DISAGREENUM = 0L;
    public static final Long DEFAULT_DIFFAGREENUM = 0L;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Agree> {
        public Long agreeNum;
        public Integer agreeType;
        public Long diffAgreeNum;
        public Long disagreeNum;
        public Integer hasAgree;

        public Builder() {
        }

        public Builder(Agree agree) {
            super(agree);
            if (agree == null) {
                return;
            }
            this.agreeNum = agree.agreeNum;
            this.hasAgree = agree.hasAgree;
            this.agreeType = agree.agreeType;
            this.disagreeNum = agree.disagreeNum;
            this.diffAgreeNum = agree.diffAgreeNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Agree build(boolean z) {
            return new Agree(this, z);
        }
    }

    public Agree(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.agreeNum;
            if (l == null) {
                this.agreeNum = DEFAULT_AGREENUM;
            } else {
                this.agreeNum = l;
            }
            Integer num = builder.hasAgree;
            if (num == null) {
                this.hasAgree = DEFAULT_HASAGREE;
            } else {
                this.hasAgree = num;
            }
            Integer num2 = builder.agreeType;
            if (num2 == null) {
                this.agreeType = DEFAULT_AGREETYPE;
            } else {
                this.agreeType = num2;
            }
            Long l2 = builder.disagreeNum;
            if (l2 == null) {
                this.disagreeNum = DEFAULT_DISAGREENUM;
            } else {
                this.disagreeNum = l2;
            }
            Long l3 = builder.diffAgreeNum;
            if (l3 == null) {
                this.diffAgreeNum = DEFAULT_DIFFAGREENUM;
                return;
            } else {
                this.diffAgreeNum = l3;
                return;
            }
        }
        this.agreeNum = builder.agreeNum;
        this.hasAgree = builder.hasAgree;
        this.agreeType = builder.agreeType;
        this.disagreeNum = builder.disagreeNum;
        this.diffAgreeNum = builder.diffAgreeNum;
    }
}
