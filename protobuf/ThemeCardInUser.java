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
public final class ThemeCardInUser extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_COORDINATE = "";
    public static final String DEFAULT_IMGANDROID = "";
    public static final String DEFAULT_IMGIOS = "";
    public static final Integer DEFAULT_LEVEL;
    public static final Long DEFAULT_PROPSID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String coordinate;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String imgAndroid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String imgIos;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer level;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long propsId;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ThemeCardInUser> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String coordinate;
        public String imgAndroid;
        public String imgIos;
        public Integer level;
        public Long propsId;

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
        public Builder(ThemeCardInUser themeCardInUser) {
            super(themeCardInUser);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {themeCardInUser};
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
            if (themeCardInUser == null) {
                return;
            }
            this.propsId = themeCardInUser.propsId;
            this.imgIos = themeCardInUser.imgIos;
            this.coordinate = themeCardInUser.coordinate;
            this.imgAndroid = themeCardInUser.imgAndroid;
            this.level = themeCardInUser.level;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ThemeCardInUser build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new ThemeCardInUser(this, z, null);
            }
            return (ThemeCardInUser) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(765772874, "Lprotobuf/ThemeCardInUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(765772874, "Lprotobuf/ThemeCardInUser;");
                return;
            }
        }
        DEFAULT_PROPSID = 0L;
        DEFAULT_LEVEL = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemeCardInUser(Builder builder, boolean z) {
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
            Long l = builder.propsId;
            if (l == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = l;
            }
            String str = builder.imgIos;
            if (str == null) {
                this.imgIos = "";
            } else {
                this.imgIos = str;
            }
            String str2 = builder.coordinate;
            if (str2 == null) {
                this.coordinate = "";
            } else {
                this.coordinate = str2;
            }
            String str3 = builder.imgAndroid;
            if (str3 == null) {
                this.imgAndroid = "";
            } else {
                this.imgAndroid = str3;
            }
            Integer num = builder.level;
            if (num == null) {
                this.level = DEFAULT_LEVEL;
                return;
            } else {
                this.level = num;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.imgIos = builder.imgIos;
        this.coordinate = builder.coordinate;
        this.imgAndroid = builder.imgAndroid;
        this.level = builder.level;
    }

    public /* synthetic */ ThemeCardInUser(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
