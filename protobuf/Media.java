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
/* loaded from: classes8.dex */
public final class Media extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BIGPIC = "";
    public static final String DEFAULT_BSIZE = "";
    public static final Integer DEFAULT_DURINGTIME;
    public static final String DEFAULT_DYNAMICPIC = "";
    public static final Integer DEFAULT_ETYPE;
    public static final Integer DEFAULT_HEIGHT;
    public static final Double DEFAULT_HTHMIDLOC;
    public static final Integer DEFAULT_ISBLOCKEDPIC;
    public static final Integer DEFAULT_ISLONGPIC;
    public static final String DEFAULT_ORIGINPIC = "";
    public static final Integer DEFAULT_ORIGINSIZE;
    public static final Long DEFAULT_POSTID;
    public static final Integer DEFAULT_SHOWORIGINALBTN;
    public static final String DEFAULT_SMALLPIC = "";
    public static final String DEFAULT_SRCPIC = "";
    public static final String DEFAULT_TEXT = "";
    public static final Integer DEFAULT_TYPE;
    public static final String DEFAULT_VHSRC = "";
    public static final String DEFAULT_VPIC = "";
    public static final String DEFAULT_VSRC = "";
    public static final String DEFAULT_WATERPIC = "";
    public static final Integer DEFAULT_WIDTH;
    public static final Double DEFAULT_WTHMIDLOC;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bigPic;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String bsize;
    @ProtoField(tag = 13, type = Message.Datatype.UINT32)
    public final Integer duringTime;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String dynamicPic;
    @ProtoField(tag = 14, type = Message.Datatype.UINT32)
    public final Integer eType;
    @ProtoField(tag = 11, type = Message.Datatype.UINT32)
    public final Integer height;
    @ProtoField(tag = 23, type = Message.Datatype.DOUBLE)
    public final Double hthMidLoc;
    @ProtoField(tag = 21, type = Message.Datatype.UINT32)
    public final Integer isBlockedPic;
    @ProtoField(tag = 19, type = Message.Datatype.UINT32)
    public final Integer isLongPic;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String originPic;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer originSize;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long postId;
    @ProtoField(tag = 20, type = Message.Datatype.UINT32)
    public final Integer showOriginalBtn;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String smallPic;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String srcPic;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String vhsrc;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String vpic;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String vsrc;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String waterPic;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer width;
    @ProtoField(tag = 22, type = Message.Datatype.DOUBLE)
    public final Double wthMidLoc;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<Media> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bigPic;
        public String bsize;
        public Integer duringTime;
        public String dynamicPic;
        public Integer eType;
        public Integer height;
        public Double hthMidLoc;
        public Integer isBlockedPic;
        public Integer isLongPic;
        public String originPic;
        public Integer originSize;
        public Long postId;
        public Integer showOriginalBtn;
        public String smallPic;
        public String srcPic;
        public String text;
        public Integer type;
        public String vhsrc;
        public String vpic;
        public String vsrc;
        public String waterPic;
        public Integer width;
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
        public Builder(Media media) {
            super(media);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {media};
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
            if (media == null) {
                return;
            }
            this.type = media.type;
            this.smallPic = media.smallPic;
            this.bigPic = media.bigPic;
            this.waterPic = media.waterPic;
            this.vpic = media.vpic;
            this.vsrc = media.vsrc;
            this.vhsrc = media.vhsrc;
            this.srcPic = media.srcPic;
            this.text = media.text;
            this.width = media.width;
            this.height = media.height;
            this.bsize = media.bsize;
            this.duringTime = media.duringTime;
            this.eType = media.eType;
            this.originPic = media.originPic;
            this.originSize = media.originSize;
            this.postId = media.postId;
            this.dynamicPic = media.dynamicPic;
            this.isLongPic = media.isLongPic;
            this.showOriginalBtn = media.showOriginalBtn;
            this.isBlockedPic = media.isBlockedPic;
            this.wthMidLoc = media.wthMidLoc;
            this.hthMidLoc = media.hthMidLoc;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Media build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new Media(this, z, null) : (Media) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1024240175, "Lprotobuf/Media;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1024240175, "Lprotobuf/Media;");
                return;
            }
        }
        DEFAULT_TYPE = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_DURINGTIME = 0;
        DEFAULT_ETYPE = 0;
        DEFAULT_ORIGINSIZE = 0;
        DEFAULT_POSTID = 0L;
        DEFAULT_ISLONGPIC = 0;
        DEFAULT_SHOWORIGINALBTN = 0;
        DEFAULT_ISBLOCKEDPIC = 0;
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_WTHMIDLOC = valueOf;
        DEFAULT_HTHMIDLOC = valueOf;
    }

    public /* synthetic */ Media(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Media(Builder builder, boolean z) {
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
            String str = builder.smallPic;
            if (str == null) {
                this.smallPic = "";
            } else {
                this.smallPic = str;
            }
            String str2 = builder.bigPic;
            if (str2 == null) {
                this.bigPic = "";
            } else {
                this.bigPic = str2;
            }
            String str3 = builder.waterPic;
            if (str3 == null) {
                this.waterPic = "";
            } else {
                this.waterPic = str3;
            }
            String str4 = builder.vpic;
            if (str4 == null) {
                this.vpic = "";
            } else {
                this.vpic = str4;
            }
            String str5 = builder.vsrc;
            if (str5 == null) {
                this.vsrc = "";
            } else {
                this.vsrc = str5;
            }
            String str6 = builder.vhsrc;
            if (str6 == null) {
                this.vhsrc = "";
            } else {
                this.vhsrc = str6;
            }
            String str7 = builder.srcPic;
            if (str7 == null) {
                this.srcPic = "";
            } else {
                this.srcPic = str7;
            }
            String str8 = builder.text;
            if (str8 == null) {
                this.text = "";
            } else {
                this.text = str8;
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
            String str9 = builder.bsize;
            if (str9 == null) {
                this.bsize = "";
            } else {
                this.bsize = str9;
            }
            Integer num4 = builder.duringTime;
            if (num4 == null) {
                this.duringTime = DEFAULT_DURINGTIME;
            } else {
                this.duringTime = num4;
            }
            Integer num5 = builder.eType;
            if (num5 == null) {
                this.eType = DEFAULT_ETYPE;
            } else {
                this.eType = num5;
            }
            String str10 = builder.originPic;
            if (str10 == null) {
                this.originPic = "";
            } else {
                this.originPic = str10;
            }
            Integer num6 = builder.originSize;
            if (num6 == null) {
                this.originSize = DEFAULT_ORIGINSIZE;
            } else {
                this.originSize = num6;
            }
            Long l = builder.postId;
            if (l == null) {
                this.postId = DEFAULT_POSTID;
            } else {
                this.postId = l;
            }
            String str11 = builder.dynamicPic;
            if (str11 == null) {
                this.dynamicPic = "";
            } else {
                this.dynamicPic = str11;
            }
            Integer num7 = builder.isLongPic;
            if (num7 == null) {
                this.isLongPic = DEFAULT_ISLONGPIC;
            } else {
                this.isLongPic = num7;
            }
            Integer num8 = builder.showOriginalBtn;
            if (num8 == null) {
                this.showOriginalBtn = DEFAULT_SHOWORIGINALBTN;
            } else {
                this.showOriginalBtn = num8;
            }
            Integer num9 = builder.isBlockedPic;
            if (num9 == null) {
                this.isBlockedPic = DEFAULT_ISBLOCKEDPIC;
            } else {
                this.isBlockedPic = num9;
            }
            Double d = builder.wthMidLoc;
            if (d == null) {
                this.wthMidLoc = DEFAULT_WTHMIDLOC;
            } else {
                this.wthMidLoc = d;
            }
            Double d2 = builder.hthMidLoc;
            if (d2 == null) {
                this.hthMidLoc = DEFAULT_HTHMIDLOC;
                return;
            } else {
                this.hthMidLoc = d2;
                return;
            }
        }
        this.type = builder.type;
        this.smallPic = builder.smallPic;
        this.bigPic = builder.bigPic;
        this.waterPic = builder.waterPic;
        this.vpic = builder.vpic;
        this.vsrc = builder.vsrc;
        this.vhsrc = builder.vhsrc;
        this.srcPic = builder.srcPic;
        this.text = builder.text;
        this.width = builder.width;
        this.height = builder.height;
        this.bsize = builder.bsize;
        this.duringTime = builder.duringTime;
        this.eType = builder.eType;
        this.originPic = builder.originPic;
        this.originSize = builder.originSize;
        this.postId = builder.postId;
        this.dynamicPic = builder.dynamicPic;
        this.isLongPic = builder.isLongPic;
        this.showOriginalBtn = builder.showOriginalBtn;
        this.isBlockedPic = builder.isBlockedPic;
        this.wthMidLoc = builder.wthMidLoc;
        this.hthMidLoc = builder.hthMidLoc;
    }
}
