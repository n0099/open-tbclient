package protobuf.QueryLiveGroupConfig;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class IntroInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATETIME = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long createTime;

    /* synthetic */ IntroInfo(Builder builder, boolean z, IntroInfo introInfo) {
        this(builder, z);
    }

    private IntroInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.createTime == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = builder.createTime;
            }
            if (builder.content == null) {
                this.content = "";
                return;
            } else {
                this.content = builder.content;
                return;
            }
        }
        this.createTime = builder.createTime;
        this.content = builder.content;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<IntroInfo> {
        public String content;
        public Long createTime;

        public Builder(IntroInfo introInfo) {
            super(introInfo);
            if (introInfo != null) {
                this.createTime = introInfo.createTime;
                this.content = introInfo.content;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public IntroInfo build(boolean z) {
            return new IntroInfo(this, z, null);
        }
    }
}
