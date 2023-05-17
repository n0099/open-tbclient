package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class VideoDesc extends Message {
    public static final String DEFAULT_VIDEOHEIGHT = "";
    public static final Integer DEFAULT_VIDEOID = 0;
    public static final String DEFAULT_VIDEOMD5 = "";
    public static final String DEFAULT_VIDEOURL = "";
    public static final String DEFAULT_VIDEOWIDTH = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String videoHeight;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer videoId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String videoMd5;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String videoUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String videoWidth;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<VideoDesc> {
        public String videoHeight;
        public Integer videoId;
        public String videoMd5;
        public String videoUrl;
        public String videoWidth;

        public Builder() {
        }

        public Builder(VideoDesc videoDesc) {
            super(videoDesc);
            if (videoDesc == null) {
                return;
            }
            this.videoId = videoDesc.videoId;
            this.videoMd5 = videoDesc.videoMd5;
            this.videoUrl = videoDesc.videoUrl;
            this.videoWidth = videoDesc.videoWidth;
            this.videoHeight = videoDesc.videoHeight;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public VideoDesc build(boolean z) {
            return new VideoDesc(this, z);
        }
    }

    public VideoDesc(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.videoId;
            if (num == null) {
                this.videoId = DEFAULT_VIDEOID;
            } else {
                this.videoId = num;
            }
            String str = builder.videoMd5;
            if (str == null) {
                this.videoMd5 = "";
            } else {
                this.videoMd5 = str;
            }
            String str2 = builder.videoUrl;
            if (str2 == null) {
                this.videoUrl = "";
            } else {
                this.videoUrl = str2;
            }
            String str3 = builder.videoWidth;
            if (str3 == null) {
                this.videoWidth = "";
            } else {
                this.videoWidth = str3;
            }
            String str4 = builder.videoHeight;
            if (str4 == null) {
                this.videoHeight = "";
                return;
            } else {
                this.videoHeight = str4;
                return;
            }
        }
        this.videoId = builder.videoId;
        this.videoMd5 = builder.videoMd5;
        this.videoUrl = builder.videoUrl;
        this.videoWidth = builder.videoWidth;
        this.videoHeight = builder.videoHeight;
    }
}
