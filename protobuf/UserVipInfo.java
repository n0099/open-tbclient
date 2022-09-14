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
public final class UserVipInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ASCORE;
    public static final Integer DEFAULT_ETIME;
    public static final Integer DEFAULT_EXTSCORE;
    public static final String DEFAULT_ICONURL = "";
    public static final Integer DEFAULT_NSCORE;
    public static final Integer DEFAULT_STIME;
    public static final Integer DEFAULT_VLEVEL;
    public static final Integer DEFAULT_VSTATUS;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer aScore;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer eTime;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer extScore;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer nScore;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer sTime;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer vLevel;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer vStatus;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<UserVipInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer aScore;
        public Integer eTime;
        public Integer extScore;
        public String iconUrl;
        public Integer nScore;
        public Integer sTime;
        public Integer vLevel;
        public Integer vStatus;

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
        public Builder(UserVipInfo userVipInfo) {
            super(userVipInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userVipInfo};
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
            if (userVipInfo == null) {
                return;
            }
            this.vStatus = userVipInfo.vStatus;
            this.sTime = userVipInfo.sTime;
            this.eTime = userVipInfo.eTime;
            this.extScore = userVipInfo.extScore;
            this.vLevel = userVipInfo.vLevel;
            this.aScore = userVipInfo.aScore;
            this.nScore = userVipInfo.nScore;
            this.iconUrl = userVipInfo.iconUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserVipInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new UserVipInfo(this, z, null) : (UserVipInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(947065715, "Lprotobuf/UserVipInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(947065715, "Lprotobuf/UserVipInfo;");
                return;
            }
        }
        DEFAULT_VSTATUS = 0;
        DEFAULT_STIME = 0;
        DEFAULT_ETIME = 0;
        DEFAULT_EXTSCORE = 0;
        DEFAULT_VLEVEL = 0;
        DEFAULT_ASCORE = 0;
        DEFAULT_NSCORE = 0;
    }

    public /* synthetic */ UserVipInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserVipInfo(Builder builder, boolean z) {
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
            Integer num = builder.vStatus;
            if (num == null) {
                this.vStatus = DEFAULT_VSTATUS;
            } else {
                this.vStatus = num;
            }
            Integer num2 = builder.sTime;
            if (num2 == null) {
                this.sTime = DEFAULT_STIME;
            } else {
                this.sTime = num2;
            }
            Integer num3 = builder.eTime;
            if (num3 == null) {
                this.eTime = DEFAULT_ETIME;
            } else {
                this.eTime = num3;
            }
            Integer num4 = builder.extScore;
            if (num4 == null) {
                this.extScore = DEFAULT_EXTSCORE;
            } else {
                this.extScore = num4;
            }
            Integer num5 = builder.vLevel;
            if (num5 == null) {
                this.vLevel = DEFAULT_VLEVEL;
            } else {
                this.vLevel = num5;
            }
            Integer num6 = builder.aScore;
            if (num6 == null) {
                this.aScore = DEFAULT_ASCORE;
            } else {
                this.aScore = num6;
            }
            Integer num7 = builder.nScore;
            if (num7 == null) {
                this.nScore = DEFAULT_NSCORE;
            } else {
                this.nScore = num7;
            }
            String str = builder.iconUrl;
            if (str == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = str;
                return;
            }
        }
        this.vStatus = builder.vStatus;
        this.sTime = builder.sTime;
        this.eTime = builder.eTime;
        this.extScore = builder.extScore;
        this.vLevel = builder.vLevel;
        this.aScore = builder.aScore;
        this.nScore = builder.nScore;
        this.iconUrl = builder.iconUrl;
    }
}
