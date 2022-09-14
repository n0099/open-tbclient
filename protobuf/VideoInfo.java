package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class VideoInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FIRSTFRAMETHUMBNAIL = "";
    public static final Double DEFAULT_HTHMIDLOC;
    public static final Integer DEFAULT_ISVERTICAL;
    public static final String DEFAULT_MCNLEADPAGE = "";
    public static final String DEFAULT_MEDIASUBTITLE = "";
    public static final Integer DEFAULT_PLAYCOUNT;
    public static final String DEFAULT_SMALLTHUMBNAILURL = "";
    public static final Integer DEFAULT_THUMBNAILHEIGHT;
    public static final String DEFAULT_THUMBNAILURL = "";
    public static final Integer DEFAULT_THUMBNAILWIDTH;
    public static final List<VideoDesc> DEFAULT_VIDEODESC;
    public static final Integer DEFAULT_VIDEODURATION;
    public static final Integer DEFAULT_VIDEOHEIGHT;
    public static final Integer DEFAULT_VIDEOLENGTH;
    public static final String DEFAULT_VIDEOMD5 = "";
    public static final Integer DEFAULT_VIDEOSELECTFLAG;
    public static final Integer DEFAULT_VIDEOTYPE;
    public static final String DEFAULT_VIDEOURL = "";
    public static final Integer DEFAULT_VIDEOWIDTH;
    public static final Double DEFAULT_WTHMIDLOC;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String firstFrameThumbnail;
    @ProtoField(tag = 20, type = Message.Datatype.DOUBLE)
    public final Double hthMidLoc;
    @ProtoField(tag = 15, type = Message.Datatype.UINT32)
    public final Integer isVertical;
    @ProtoField(tag = 18)
    public final McnAdInfo mcnAdCard;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String mcnLeadPage;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String mediaSubtitle;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer playCount;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String smallThumbnailUrl;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer thumbnailHeight;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String thumbnailUrl;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer thumbnailWidth;
    @ProtoField(label = Message.Label.REPEATED, tag = 12)
    public final List<VideoDesc> videoDesc;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer videoDuration;
    @ProtoField(tag = 16)
    public final VideoDesc videoH265;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer videoHeight;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer videoLength;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String videoMd5;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer videoSelectFlag;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer videoType;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String videoUrl;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer videoWidth;
    @ProtoField(tag = 19, type = Message.Datatype.DOUBLE)
    public final Double wthMidLoc;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<VideoInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String firstFrameThumbnail;
        public Double hthMidLoc;
        public Integer isVertical;
        public McnAdInfo mcnAdCard;
        public String mcnLeadPage;
        public String mediaSubtitle;
        public Integer playCount;
        public String smallThumbnailUrl;
        public Integer thumbnailHeight;
        public String thumbnailUrl;
        public Integer thumbnailWidth;
        public List<VideoDesc> videoDesc;
        public Integer videoDuration;
        public VideoDesc videoH265;
        public Integer videoHeight;
        public Integer videoLength;
        public String videoMd5;
        public Integer videoSelectFlag;
        public Integer videoType;
        public String videoUrl;
        public Integer videoWidth;
        public Double wthMidLoc;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(VideoInfo videoInfo) {
            super(videoInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoInfo};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (videoInfo == null) {
                return;
            }
            this.videoMd5 = videoInfo.videoMd5;
            this.videoUrl = videoInfo.videoUrl;
            this.videoDuration = videoInfo.videoDuration;
            this.videoWidth = videoInfo.videoWidth;
            this.videoHeight = videoInfo.videoHeight;
            this.thumbnailUrl = videoInfo.thumbnailUrl;
            this.thumbnailWidth = videoInfo.thumbnailWidth;
            this.thumbnailHeight = videoInfo.thumbnailHeight;
            this.videoLength = videoInfo.videoLength;
            this.playCount = videoInfo.playCount;
            this.mediaSubtitle = videoInfo.mediaSubtitle;
            this.videoDesc = Message.copyOf(videoInfo.videoDesc);
            this.videoSelectFlag = videoInfo.videoSelectFlag;
            this.videoType = videoInfo.videoType;
            this.isVertical = videoInfo.isVertical;
            this.videoH265 = videoInfo.videoH265;
            this.mcnLeadPage = videoInfo.mcnLeadPage;
            this.mcnAdCard = videoInfo.mcnAdCard;
            this.wthMidLoc = videoInfo.wthMidLoc;
            this.hthMidLoc = videoInfo.hthMidLoc;
            this.smallThumbnailUrl = videoInfo.smallThumbnailUrl;
            this.firstFrameThumbnail = videoInfo.firstFrameThumbnail;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public VideoInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new VideoInfo(this, z, null) : (VideoInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1646818026, "Lprotobuf/VideoInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1646818026, "Lprotobuf/VideoInfo;");
                return;
            }
        }
        DEFAULT_VIDEODURATION = 0;
        DEFAULT_VIDEOWIDTH = 0;
        DEFAULT_VIDEOHEIGHT = 0;
        DEFAULT_THUMBNAILWIDTH = 0;
        DEFAULT_THUMBNAILHEIGHT = 0;
        DEFAULT_VIDEOLENGTH = 0;
        DEFAULT_PLAYCOUNT = 0;
        DEFAULT_VIDEODESC = Collections.emptyList();
        DEFAULT_VIDEOSELECTFLAG = 0;
        DEFAULT_VIDEOTYPE = 0;
        DEFAULT_ISVERTICAL = 0;
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_WTHMIDLOC = valueOf;
        DEFAULT_HTHMIDLOC = valueOf;
    }

    public /* synthetic */ VideoInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
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
            Integer num = builder.videoDuration;
            if (num == null) {
                this.videoDuration = DEFAULT_VIDEODURATION;
            } else {
                this.videoDuration = num;
            }
            Integer num2 = builder.videoWidth;
            if (num2 == null) {
                this.videoWidth = DEFAULT_VIDEOWIDTH;
            } else {
                this.videoWidth = num2;
            }
            Integer num3 = builder.videoHeight;
            if (num3 == null) {
                this.videoHeight = DEFAULT_VIDEOHEIGHT;
            } else {
                this.videoHeight = num3;
            }
            String str3 = builder.thumbnailUrl;
            if (str3 == null) {
                this.thumbnailUrl = "";
            } else {
                this.thumbnailUrl = str3;
            }
            Integer num4 = builder.thumbnailWidth;
            if (num4 == null) {
                this.thumbnailWidth = DEFAULT_THUMBNAILWIDTH;
            } else {
                this.thumbnailWidth = num4;
            }
            Integer num5 = builder.thumbnailHeight;
            if (num5 == null) {
                this.thumbnailHeight = DEFAULT_THUMBNAILHEIGHT;
            } else {
                this.thumbnailHeight = num5;
            }
            Integer num6 = builder.videoLength;
            if (num6 == null) {
                this.videoLength = DEFAULT_VIDEOLENGTH;
            } else {
                this.videoLength = num6;
            }
            Integer num7 = builder.playCount;
            if (num7 == null) {
                this.playCount = DEFAULT_PLAYCOUNT;
            } else {
                this.playCount = num7;
            }
            String str4 = builder.mediaSubtitle;
            if (str4 == null) {
                this.mediaSubtitle = "";
            } else {
                this.mediaSubtitle = str4;
            }
            List<VideoDesc> list = builder.videoDesc;
            if (list == null) {
                this.videoDesc = DEFAULT_VIDEODESC;
            } else {
                this.videoDesc = Message.immutableCopyOf(list);
            }
            Integer num8 = builder.videoSelectFlag;
            if (num8 == null) {
                this.videoSelectFlag = DEFAULT_VIDEOSELECTFLAG;
            } else {
                this.videoSelectFlag = num8;
            }
            Integer num9 = builder.videoType;
            if (num9 == null) {
                this.videoType = DEFAULT_VIDEOTYPE;
            } else {
                this.videoType = num9;
            }
            Integer num10 = builder.isVertical;
            if (num10 == null) {
                this.isVertical = DEFAULT_ISVERTICAL;
            } else {
                this.isVertical = num10;
            }
            this.videoH265 = builder.videoH265;
            String str5 = builder.mcnLeadPage;
            if (str5 == null) {
                this.mcnLeadPage = "";
            } else {
                this.mcnLeadPage = str5;
            }
            this.mcnAdCard = builder.mcnAdCard;
            Double d = builder.wthMidLoc;
            if (d == null) {
                this.wthMidLoc = DEFAULT_WTHMIDLOC;
            } else {
                this.wthMidLoc = d;
            }
            Double d2 = builder.hthMidLoc;
            if (d2 == null) {
                this.hthMidLoc = DEFAULT_HTHMIDLOC;
            } else {
                this.hthMidLoc = d2;
            }
            String str6 = builder.smallThumbnailUrl;
            if (str6 == null) {
                this.smallThumbnailUrl = "";
            } else {
                this.smallThumbnailUrl = str6;
            }
            String str7 = builder.firstFrameThumbnail;
            if (str7 == null) {
                this.firstFrameThumbnail = "";
                return;
            } else {
                this.firstFrameThumbnail = str7;
                return;
            }
        }
        this.videoMd5 = builder.videoMd5;
        this.videoUrl = builder.videoUrl;
        this.videoDuration = builder.videoDuration;
        this.videoWidth = builder.videoWidth;
        this.videoHeight = builder.videoHeight;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.thumbnailWidth = builder.thumbnailWidth;
        this.thumbnailHeight = builder.thumbnailHeight;
        this.videoLength = builder.videoLength;
        this.playCount = builder.playCount;
        this.mediaSubtitle = builder.mediaSubtitle;
        this.videoDesc = Message.immutableCopyOf(builder.videoDesc);
        this.videoSelectFlag = builder.videoSelectFlag;
        this.videoType = builder.videoType;
        this.isVertical = builder.isVertical;
        this.videoH265 = builder.videoH265;
        this.mcnLeadPage = builder.mcnLeadPage;
        this.mcnAdCard = builder.mcnAdCard;
        this.wthMidLoc = builder.wthMidLoc;
        this.hthMidLoc = builder.hthMidLoc;
        this.smallThumbnailUrl = builder.smallThumbnailUrl;
        this.firstFrameThumbnail = builder.firstFrameThumbnail;
    }
}
