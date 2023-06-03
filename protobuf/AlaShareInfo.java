package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class AlaShareInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long recordTid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shareCount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shareUserCount;
    public static final Integer DEFAULT_SHAREUSERCOUNT = 0;
    public static final Integer DEFAULT_SHARECOUNT = 0;
    public static final Long DEFAULT_RECORDTID = 0L;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<AlaShareInfo> {
        public String content;
        public Long recordTid;
        public Integer shareCount;
        public Integer shareUserCount;

        public Builder() {
        }

        public Builder(AlaShareInfo alaShareInfo) {
            super(alaShareInfo);
            if (alaShareInfo == null) {
                return;
            }
            this.content = alaShareInfo.content;
            this.shareUserCount = alaShareInfo.shareUserCount;
            this.shareCount = alaShareInfo.shareCount;
            this.recordTid = alaShareInfo.recordTid;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaShareInfo build(boolean z) {
            return new AlaShareInfo(this, z);
        }
    }

    public AlaShareInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            Integer num = builder.shareUserCount;
            if (num == null) {
                this.shareUserCount = DEFAULT_SHAREUSERCOUNT;
            } else {
                this.shareUserCount = num;
            }
            Integer num2 = builder.shareCount;
            if (num2 == null) {
                this.shareCount = DEFAULT_SHARECOUNT;
            } else {
                this.shareCount = num2;
            }
            Long l = builder.recordTid;
            if (l == null) {
                this.recordTid = DEFAULT_RECORDTID;
                return;
            } else {
                this.recordTid = l;
                return;
            }
        }
        this.content = builder.content;
        this.shareUserCount = builder.shareUserCount;
        this.shareCount = builder.shareCount;
        this.recordTid = builder.recordTid;
    }
}
