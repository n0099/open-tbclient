package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Baijiahao extends Message {
    public static final String DEFAULT_FORWARDURL = "";
    public static final String DEFAULT_ORIUGCNID = "";
    public static final String DEFAULT_ORIUGCTID = "";
    public static final Integer DEFAULT_ORIUGCTYPE = 0;
    public static final String DEFAULT_ORIUGCVID = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String forwardUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String oriUgcNid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String oriUgcTid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer oriUgcType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String oriUgcVid;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Baijiahao> {
        public String forwardUrl;
        public String oriUgcNid;
        public String oriUgcTid;
        public Integer oriUgcType;
        public String oriUgcVid;

        public Builder() {
        }

        public Builder(Baijiahao baijiahao) {
            super(baijiahao);
            if (baijiahao == null) {
                return;
            }
            this.oriUgcNid = baijiahao.oriUgcNid;
            this.oriUgcTid = baijiahao.oriUgcTid;
            this.oriUgcType = baijiahao.oriUgcType;
            this.oriUgcVid = baijiahao.oriUgcVid;
            this.forwardUrl = baijiahao.forwardUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Baijiahao build(boolean z) {
            return new Baijiahao(this, z);
        }
    }

    public Baijiahao(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.oriUgcNid;
            if (str == null) {
                this.oriUgcNid = "";
            } else {
                this.oriUgcNid = str;
            }
            String str2 = builder.oriUgcTid;
            if (str2 == null) {
                this.oriUgcTid = "";
            } else {
                this.oriUgcTid = str2;
            }
            Integer num = builder.oriUgcType;
            if (num == null) {
                this.oriUgcType = DEFAULT_ORIUGCTYPE;
            } else {
                this.oriUgcType = num;
            }
            String str3 = builder.oriUgcVid;
            if (str3 == null) {
                this.oriUgcVid = "";
            } else {
                this.oriUgcVid = str3;
            }
            String str4 = builder.forwardUrl;
            if (str4 == null) {
                this.forwardUrl = "";
                return;
            } else {
                this.forwardUrl = str4;
                return;
            }
        }
        this.oriUgcNid = builder.oriUgcNid;
        this.oriUgcTid = builder.oriUgcTid;
        this.oriUgcType = builder.oriUgcType;
        this.oriUgcVid = builder.oriUgcVid;
        this.forwardUrl = builder.forwardUrl;
    }
}
