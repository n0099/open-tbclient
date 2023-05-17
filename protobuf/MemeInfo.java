package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class MemeInfo extends Message {
    public static final String DEFAULT_DETAILLINK = "";
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_THUMBNAIL = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String detailLink;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer height;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer pckId;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long picId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String thumbnail;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer width;
    public static final Integer DEFAULT_PCKID = 0;
    public static final Long DEFAULT_PICID = 0L;
    public static final Integer DEFAULT_WIDTH = 0;
    public static final Integer DEFAULT_HEIGHT = 0;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<MemeInfo> {
        public String detailLink;
        public Integer height;
        public Integer pckId;
        public Long picId;
        public String picUrl;
        public String thumbnail;
        public Integer width;

        public Builder() {
        }

        public Builder(MemeInfo memeInfo) {
            super(memeInfo);
            if (memeInfo == null) {
                return;
            }
            this.pckId = memeInfo.pckId;
            this.picId = memeInfo.picId;
            this.picUrl = memeInfo.picUrl;
            this.thumbnail = memeInfo.thumbnail;
            this.width = memeInfo.width;
            this.height = memeInfo.height;
            this.detailLink = memeInfo.detailLink;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MemeInfo build(boolean z) {
            return new MemeInfo(this, z);
        }
    }

    public MemeInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.pckId;
            if (num == null) {
                this.pckId = DEFAULT_PCKID;
            } else {
                this.pckId = num;
            }
            Long l = builder.picId;
            if (l == null) {
                this.picId = DEFAULT_PICID;
            } else {
                this.picId = l;
            }
            String str = builder.picUrl;
            if (str == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str;
            }
            String str2 = builder.thumbnail;
            if (str2 == null) {
                this.thumbnail = "";
            } else {
                this.thumbnail = str2;
            }
            Integer num2 = builder.width;
            if (num2 == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num2;
            }
            Integer num3 = builder.height;
            if (num3 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num3;
            }
            String str3 = builder.detailLink;
            if (str3 == null) {
                this.detailLink = "";
                return;
            } else {
                this.detailLink = str3;
                return;
            }
        }
        this.pckId = builder.pckId;
        this.picId = builder.picId;
        this.picUrl = builder.picUrl;
        this.thumbnail = builder.thumbnail;
        this.width = builder.width;
        this.height = builder.height;
        this.detailLink = builder.detailLink;
    }
}
