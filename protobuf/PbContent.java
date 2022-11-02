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
/* loaded from: classes9.dex */
public final class PbContent extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BIGCDNSRC = "";
    public static final String DEFAULT_BIGSIZE = "";
    public static final String DEFAULT_BIGSRC = "";
    public static final String DEFAULT_BSIZE = "";
    public static final Integer DEFAULT_BTNTYPE;
    public static final String DEFAULT_C = "";
    public static final String DEFAULT_CDNSRC = "";
    public static final String DEFAULT_CDNSRCACTIVE = "";
    public static final Integer DEFAULT_COUNT;
    public static final Integer DEFAULT_DURINGTIME;
    public static final String DEFAULT_DYNAMIC = "";
    public static final Integer DEFAULT_ETYPE;
    public static final Integer DEFAULT_HEIGHT;
    public static final String DEFAULT_IMGTYPE = "";
    public static final Integer DEFAULT_ISLONGPIC;
    public static final Integer DEFAULT_ISNATIVEAPP;
    public static final Integer DEFAULT_ISSUB;
    public static final String DEFAULT_ITEMFORUMNAME = "";
    public static final Long DEFAULT_ITEMID;
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_MEDIASUBTITLE = "";
    public static final Integer DEFAULT_ORIGINSIZE;
    public static final String DEFAULT_ORIGINSRC = "";
    public static final String DEFAULT_PACKETNAME = "";
    public static final String DEFAULT_PHONETYPE = "";
    public static final Long DEFAULT_PICID;
    public static final Integer DEFAULT_SHOWORIGINALBTN;
    public static final String DEFAULT_SRC = "";
    public static final String DEFAULT_STATIC = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TOPICSPECIALICON = "";
    public static final Integer DEFAULT_TYPE;
    public static final Long DEFAULT_UID;
    public static final Integer DEFAULT_URLTYPE;
    public static final String DEFAULT_VOICEMD5 = "";
    public static final Integer DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String _static;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String bigCdnSrc;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String bigSize;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String bigSrc;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String bsize;
    @ProtoField(tag = 26, type = Message.Datatype.UINT32)
    public final Integer btnType;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String c;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String cdnSrc;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String cdnSrcActive;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 13, type = Message.Datatype.UINT32)
    public final Integer duringTime;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String dynamic;
    @ProtoField(tag = 24, type = Message.Datatype.UINT32)
    public final Integer eType;
    @ProtoField(tag = 29)
    public final GraffitiInfo graffitiInfo;
    @ProtoField(tag = 19, type = Message.Datatype.UINT32)
    public final Integer height;
    @ProtoField(tag = 30)
    public final TogetherHi highTogether;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String imgtype;
    @ProtoField(tag = 34, type = Message.Datatype.UINT32)
    public final Integer isLongPic;
    @ProtoField(tag = 22, type = Message.Datatype.UINT32)
    public final Integer isNativeApp;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer isSub;
    @ProtoField(tag = 41)
    public final Item item;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String itemForumName;
    @ProtoField(tag = 38, type = Message.Datatype.UINT64)
    public final Long itemId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String mediaSubtitle;
    @ProtoField(tag = 33)
    public final MemeInfo memeInfo;
    @ProtoField(tag = 23)
    public final NativeApp nativeApp;
    @ProtoField(tag = 27, type = Message.Datatype.UINT32)
    public final Integer originSize;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String originSrc;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String packetName;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String phonetype;
    @ProtoField(tag = 42, type = Message.Datatype.INT64)
    public final Long picId;
    @ProtoField(tag = 35, type = Message.Datatype.UINT32)
    public final Integer showOriginalBtn;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String src;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 40)
    public final TiebaPlusInfo tiebaplusInfo;
    @ProtoField(tag = 37, type = Message.Datatype.STRING)
    public final String topicSpecialIcon;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long uid;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer urlType;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String voiceMd5;
    @ProtoField(tag = 18, type = Message.Datatype.UINT32)
    public final Integer width;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PbContent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String _static;
        public String bigCdnSrc;
        public String bigSize;
        public String bigSrc;
        public String bsize;
        public Integer btnType;
        public String c;
        public String cdnSrc;
        public String cdnSrcActive;
        public Integer count;
        public Integer duringTime;
        public String dynamic;
        public Integer eType;
        public GraffitiInfo graffitiInfo;
        public Integer height;
        public TogetherHi highTogether;
        public String imgtype;
        public Integer isLongPic;
        public Integer isNativeApp;
        public Integer isSub;
        public Item item;
        public String itemForumName;
        public Long itemId;
        public String link;
        public String mediaSubtitle;
        public MemeInfo memeInfo;
        public NativeApp nativeApp;
        public Integer originSize;
        public String originSrc;
        public String packetName;
        public String phonetype;
        public Long picId;
        public Integer showOriginalBtn;
        public String src;
        public String text;
        public TiebaPlusInfo tiebaplusInfo;
        public String topicSpecialIcon;
        public Integer type;
        public Long uid;
        public Integer urlType;
        public String voiceMd5;
        public Integer width;

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
        public Builder(PbContent pbContent) {
            super(pbContent);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbContent};
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
            if (pbContent == null) {
                return;
            }
            this.type = pbContent.type;
            this.text = pbContent.text;
            this.link = pbContent.link;
            this.src = pbContent.src;
            this.bsize = pbContent.bsize;
            this.bigSrc = pbContent.bigSrc;
            this.bigSize = pbContent.bigSize;
            this.cdnSrc = pbContent.cdnSrc;
            this.bigCdnSrc = pbContent.bigCdnSrc;
            this.imgtype = pbContent.imgtype;
            this.c = pbContent.c;
            this.voiceMd5 = pbContent.voiceMd5;
            this.duringTime = pbContent.duringTime;
            this.isSub = pbContent.isSub;
            this.uid = pbContent.uid;
            this.dynamic = pbContent.dynamic;
            this._static = pbContent._static;
            this.width = pbContent.width;
            this.height = pbContent.height;
            this.packetName = pbContent.packetName;
            this.phonetype = pbContent.phonetype;
            this.isNativeApp = pbContent.isNativeApp;
            this.nativeApp = pbContent.nativeApp;
            this.eType = pbContent.eType;
            this.originSrc = pbContent.originSrc;
            this.btnType = pbContent.btnType;
            this.originSize = pbContent.originSize;
            this.count = pbContent.count;
            this.graffitiInfo = pbContent.graffitiInfo;
            this.highTogether = pbContent.highTogether;
            this.mediaSubtitle = pbContent.mediaSubtitle;
            this.urlType = pbContent.urlType;
            this.memeInfo = pbContent.memeInfo;
            this.isLongPic = pbContent.isLongPic;
            this.showOriginalBtn = pbContent.showOriginalBtn;
            this.cdnSrcActive = pbContent.cdnSrcActive;
            this.topicSpecialIcon = pbContent.topicSpecialIcon;
            this.itemId = pbContent.itemId;
            this.itemForumName = pbContent.itemForumName;
            this.tiebaplusInfo = pbContent.tiebaplusInfo;
            this.item = pbContent.item;
            this.picId = pbContent.picId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PbContent build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new PbContent(this, z, null);
            }
            return (PbContent) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1210936396, "Lprotobuf/PbContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1210936396, "Lprotobuf/PbContent;");
                return;
            }
        }
        DEFAULT_TYPE = 0;
        DEFAULT_DURINGTIME = 0;
        DEFAULT_ISSUB = 0;
        DEFAULT_UID = 0L;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_ISNATIVEAPP = 0;
        DEFAULT_ETYPE = 0;
        DEFAULT_BTNTYPE = 0;
        DEFAULT_ORIGINSIZE = 0;
        DEFAULT_COUNT = 0;
        DEFAULT_URLTYPE = 0;
        DEFAULT_ISLONGPIC = 0;
        DEFAULT_SHOWORIGINALBTN = 0;
        DEFAULT_ITEMID = 0L;
        DEFAULT_PICID = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbContent(Builder builder, boolean z) {
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
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.text;
            if (str == null) {
                this.text = "";
            } else {
                this.text = str;
            }
            String str2 = builder.link;
            if (str2 == null) {
                this.link = "";
            } else {
                this.link = str2;
            }
            String str3 = builder.src;
            if (str3 == null) {
                this.src = "";
            } else {
                this.src = str3;
            }
            String str4 = builder.bsize;
            if (str4 == null) {
                this.bsize = "";
            } else {
                this.bsize = str4;
            }
            String str5 = builder.bigSrc;
            if (str5 == null) {
                this.bigSrc = "";
            } else {
                this.bigSrc = str5;
            }
            String str6 = builder.bigSize;
            if (str6 == null) {
                this.bigSize = "";
            } else {
                this.bigSize = str6;
            }
            String str7 = builder.cdnSrc;
            if (str7 == null) {
                this.cdnSrc = "";
            } else {
                this.cdnSrc = str7;
            }
            String str8 = builder.bigCdnSrc;
            if (str8 == null) {
                this.bigCdnSrc = "";
            } else {
                this.bigCdnSrc = str8;
            }
            String str9 = builder.imgtype;
            if (str9 == null) {
                this.imgtype = "";
            } else {
                this.imgtype = str9;
            }
            String str10 = builder.c;
            if (str10 == null) {
                this.c = "";
            } else {
                this.c = str10;
            }
            String str11 = builder.voiceMd5;
            if (str11 == null) {
                this.voiceMd5 = "";
            } else {
                this.voiceMd5 = str11;
            }
            Integer num2 = builder.duringTime;
            if (num2 == null) {
                this.duringTime = DEFAULT_DURINGTIME;
            } else {
                this.duringTime = num2;
            }
            Integer num3 = builder.isSub;
            if (num3 == null) {
                this.isSub = DEFAULT_ISSUB;
            } else {
                this.isSub = num3;
            }
            Long l = builder.uid;
            if (l == null) {
                this.uid = DEFAULT_UID;
            } else {
                this.uid = l;
            }
            String str12 = builder.dynamic;
            if (str12 == null) {
                this.dynamic = "";
            } else {
                this.dynamic = str12;
            }
            String str13 = builder._static;
            if (str13 == null) {
                this._static = "";
            } else {
                this._static = str13;
            }
            Integer num4 = builder.width;
            if (num4 == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num4;
            }
            Integer num5 = builder.height;
            if (num5 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num5;
            }
            String str14 = builder.packetName;
            if (str14 == null) {
                this.packetName = "";
            } else {
                this.packetName = str14;
            }
            String str15 = builder.phonetype;
            if (str15 == null) {
                this.phonetype = "";
            } else {
                this.phonetype = str15;
            }
            Integer num6 = builder.isNativeApp;
            if (num6 == null) {
                this.isNativeApp = DEFAULT_ISNATIVEAPP;
            } else {
                this.isNativeApp = num6;
            }
            this.nativeApp = builder.nativeApp;
            Integer num7 = builder.eType;
            if (num7 == null) {
                this.eType = DEFAULT_ETYPE;
            } else {
                this.eType = num7;
            }
            String str16 = builder.originSrc;
            if (str16 == null) {
                this.originSrc = "";
            } else {
                this.originSrc = str16;
            }
            Integer num8 = builder.btnType;
            if (num8 == null) {
                this.btnType = DEFAULT_BTNTYPE;
            } else {
                this.btnType = num8;
            }
            Integer num9 = builder.originSize;
            if (num9 == null) {
                this.originSize = DEFAULT_ORIGINSIZE;
            } else {
                this.originSize = num9;
            }
            Integer num10 = builder.count;
            if (num10 == null) {
                this.count = DEFAULT_COUNT;
            } else {
                this.count = num10;
            }
            this.graffitiInfo = builder.graffitiInfo;
            this.highTogether = builder.highTogether;
            String str17 = builder.mediaSubtitle;
            if (str17 == null) {
                this.mediaSubtitle = "";
            } else {
                this.mediaSubtitle = str17;
            }
            Integer num11 = builder.urlType;
            if (num11 == null) {
                this.urlType = DEFAULT_URLTYPE;
            } else {
                this.urlType = num11;
            }
            this.memeInfo = builder.memeInfo;
            Integer num12 = builder.isLongPic;
            if (num12 == null) {
                this.isLongPic = DEFAULT_ISLONGPIC;
            } else {
                this.isLongPic = num12;
            }
            Integer num13 = builder.showOriginalBtn;
            if (num13 == null) {
                this.showOriginalBtn = DEFAULT_SHOWORIGINALBTN;
            } else {
                this.showOriginalBtn = num13;
            }
            String str18 = builder.cdnSrcActive;
            if (str18 == null) {
                this.cdnSrcActive = "";
            } else {
                this.cdnSrcActive = str18;
            }
            String str19 = builder.topicSpecialIcon;
            if (str19 == null) {
                this.topicSpecialIcon = "";
            } else {
                this.topicSpecialIcon = str19;
            }
            Long l2 = builder.itemId;
            if (l2 == null) {
                this.itemId = DEFAULT_ITEMID;
            } else {
                this.itemId = l2;
            }
            String str20 = builder.itemForumName;
            if (str20 == null) {
                this.itemForumName = "";
            } else {
                this.itemForumName = str20;
            }
            this.tiebaplusInfo = builder.tiebaplusInfo;
            this.item = builder.item;
            Long l3 = builder.picId;
            if (l3 == null) {
                this.picId = DEFAULT_PICID;
                return;
            } else {
                this.picId = l3;
                return;
            }
        }
        this.type = builder.type;
        this.text = builder.text;
        this.link = builder.link;
        this.src = builder.src;
        this.bsize = builder.bsize;
        this.bigSrc = builder.bigSrc;
        this.bigSize = builder.bigSize;
        this.cdnSrc = builder.cdnSrc;
        this.bigCdnSrc = builder.bigCdnSrc;
        this.imgtype = builder.imgtype;
        this.c = builder.c;
        this.voiceMd5 = builder.voiceMd5;
        this.duringTime = builder.duringTime;
        this.isSub = builder.isSub;
        this.uid = builder.uid;
        this.dynamic = builder.dynamic;
        this._static = builder._static;
        this.width = builder.width;
        this.height = builder.height;
        this.packetName = builder.packetName;
        this.phonetype = builder.phonetype;
        this.isNativeApp = builder.isNativeApp;
        this.nativeApp = builder.nativeApp;
        this.eType = builder.eType;
        this.originSrc = builder.originSrc;
        this.btnType = builder.btnType;
        this.originSize = builder.originSize;
        this.count = builder.count;
        this.graffitiInfo = builder.graffitiInfo;
        this.highTogether = builder.highTogether;
        this.mediaSubtitle = builder.mediaSubtitle;
        this.urlType = builder.urlType;
        this.memeInfo = builder.memeInfo;
        this.isLongPic = builder.isLongPic;
        this.showOriginalBtn = builder.showOriginalBtn;
        this.cdnSrcActive = builder.cdnSrcActive;
        this.topicSpecialIcon = builder.topicSpecialIcon;
        this.itemId = builder.itemId;
        this.itemForumName = builder.itemForumName;
        this.tiebaplusInfo = builder.tiebaplusInfo;
        this.item = builder.item;
        this.picId = builder.picId;
    }

    public /* synthetic */ PbContent(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
