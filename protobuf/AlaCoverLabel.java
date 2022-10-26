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
public final class AlaCoverLabel extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_LABELID;
    public static final String DEFAULT_LABELNAME = "";
    public static final String DEFAULT_LABELRGB = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer labelId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String labelName;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String labelRgb;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer labelId;
        public String labelName;
        public String labelRgb;

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
        public Builder(AlaCoverLabel alaCoverLabel) {
            super(alaCoverLabel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaCoverLabel};
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
            if (alaCoverLabel == null) {
                return;
            }
            this.labelId = alaCoverLabel.labelId;
            this.labelName = alaCoverLabel.labelName;
            this.labelRgb = alaCoverLabel.labelRgb;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaCoverLabel build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new AlaCoverLabel(this, z, null);
            }
            return (AlaCoverLabel) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1926722624, "Lprotobuf/AlaCoverLabel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1926722624, "Lprotobuf/AlaCoverLabel;");
                return;
            }
        }
        DEFAULT_LABELID = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaCoverLabel(Builder builder, boolean z) {
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
            Integer num = builder.labelId;
            if (num == null) {
                this.labelId = DEFAULT_LABELID;
            } else {
                this.labelId = num;
            }
            String str = builder.labelName;
            if (str == null) {
                this.labelName = "";
            } else {
                this.labelName = str;
            }
            String str2 = builder.labelRgb;
            if (str2 == null) {
                this.labelRgb = "";
                return;
            } else {
                this.labelRgb = str2;
                return;
            }
        }
        this.labelId = builder.labelId;
        this.labelName = builder.labelName;
        this.labelRgb = builder.labelRgb;
    }

    public /* synthetic */ AlaCoverLabel(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
