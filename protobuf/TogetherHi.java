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
public final class TogetherHi extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_ALBUMID;
    public static final String DEFAULT_ALBUMNAME = "";
    public static final Integer DEFAULT_ENDTIME;
    public static final String DEFAULT_LOCATION = "";
    public static final Integer DEFAULT_NUMJOIN;
    public static final Integer DEFAULT_NUMSIGNUP;
    public static final List<String> DEFAULT_PICURLS;
    public static final List<String> DEFAULT_POTRAITS;
    public static final Integer DEFAULT_STARTTIME;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long albumId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String albumName;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer endTime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String location;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer numJoin;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer numSignup;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.STRING)
    public final List<String> picUrls;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> potraits;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer startTime;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<TogetherHi> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long albumId;
        public String albumName;
        public Integer endTime;
        public String location;
        public Integer numJoin;
        public Integer numSignup;
        public List<String> picUrls;
        public List<String> potraits;
        public Integer startTime;

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
        public Builder(TogetherHi togetherHi) {
            super(togetherHi);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {togetherHi};
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
            if (togetherHi == null) {
                return;
            }
            this.albumName = togetherHi.albumName;
            this.albumId = togetherHi.albumId;
            this.startTime = togetherHi.startTime;
            this.endTime = togetherHi.endTime;
            this.location = togetherHi.location;
            this.numSignup = togetherHi.numSignup;
            this.potraits = Message.copyOf(togetherHi.potraits);
            this.numJoin = togetherHi.numJoin;
            this.picUrls = Message.copyOf(togetherHi.picUrls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TogetherHi build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new TogetherHi(this, z, null);
            }
            return (TogetherHi) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1821241448, "Lprotobuf/TogetherHi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1821241448, "Lprotobuf/TogetherHi;");
                return;
            }
        }
        DEFAULT_ALBUMID = 0L;
        DEFAULT_STARTTIME = 0;
        DEFAULT_ENDTIME = 0;
        DEFAULT_NUMSIGNUP = 0;
        DEFAULT_POTRAITS = Collections.emptyList();
        DEFAULT_NUMJOIN = 0;
        DEFAULT_PICURLS = Collections.emptyList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TogetherHi(Builder builder, boolean z) {
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
            String str = builder.albumName;
            if (str == null) {
                this.albumName = "";
            } else {
                this.albumName = str;
            }
            Long l = builder.albumId;
            if (l == null) {
                this.albumId = DEFAULT_ALBUMID;
            } else {
                this.albumId = l;
            }
            Integer num = builder.startTime;
            if (num == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            String str2 = builder.location;
            if (str2 == null) {
                this.location = "";
            } else {
                this.location = str2;
            }
            Integer num3 = builder.numSignup;
            if (num3 == null) {
                this.numSignup = DEFAULT_NUMSIGNUP;
            } else {
                this.numSignup = num3;
            }
            List<String> list = builder.potraits;
            if (list == null) {
                this.potraits = DEFAULT_POTRAITS;
            } else {
                this.potraits = Message.immutableCopyOf(list);
            }
            Integer num4 = builder.numJoin;
            if (num4 == null) {
                this.numJoin = DEFAULT_NUMJOIN;
            } else {
                this.numJoin = num4;
            }
            List<String> list2 = builder.picUrls;
            if (list2 == null) {
                this.picUrls = DEFAULT_PICURLS;
                return;
            } else {
                this.picUrls = Message.immutableCopyOf(list2);
                return;
            }
        }
        this.albumName = builder.albumName;
        this.albumId = builder.albumId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.location = builder.location;
        this.numSignup = builder.numSignup;
        this.potraits = Message.immutableCopyOf(builder.potraits);
        this.numJoin = builder.numJoin;
        this.picUrls = Message.immutableCopyOf(builder.picUrls);
    }

    public /* synthetic */ TogetherHi(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
