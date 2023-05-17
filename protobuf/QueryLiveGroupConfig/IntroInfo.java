package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class IntroInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATETIME = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long createTime;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<IntroInfo> {
        public String content;
        public Long createTime;

        public Builder() {
        }

        public Builder(IntroInfo introInfo) {
            super(introInfo);
            if (introInfo == null) {
                return;
            }
            this.createTime = introInfo.createTime;
            this.content = introInfo.content;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IntroInfo build(boolean z) {
            return new IntroInfo(this, z);
        }
    }

    public IntroInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.createTime;
            if (l == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = l;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
                return;
            } else {
                this.content = str;
                return;
            }
        }
        this.createTime = builder.createTime;
        this.content = builder.content;
    }
}
