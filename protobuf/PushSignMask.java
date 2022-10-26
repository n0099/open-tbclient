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
public final class PushSignMask extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_SIGNPUSHMASK;
    public static final Integer DEFAULT_SIGNPUSHTIMESTAMP;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer signPushMask;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer signPushTimeStamp;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer signPushMask;
        public Integer signPushTimeStamp;

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
        public Builder(PushSignMask pushSignMask) {
            super(pushSignMask);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushSignMask};
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
            if (pushSignMask == null) {
                return;
            }
            this.signPushMask = pushSignMask.signPushMask;
            this.signPushTimeStamp = pushSignMask.signPushTimeStamp;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushSignMask build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new PushSignMask(this, z, null);
            }
            return (PushSignMask) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2060555456, "Lprotobuf/PushSignMask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2060555456, "Lprotobuf/PushSignMask;");
                return;
            }
        }
        DEFAULT_SIGNPUSHMASK = 0;
        DEFAULT_SIGNPUSHTIMESTAMP = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSignMask(Builder builder, boolean z) {
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
            Integer num = builder.signPushMask;
            if (num == null) {
                this.signPushMask = DEFAULT_SIGNPUSHMASK;
            } else {
                this.signPushMask = num;
            }
            Integer num2 = builder.signPushTimeStamp;
            if (num2 == null) {
                this.signPushTimeStamp = DEFAULT_SIGNPUSHTIMESTAMP;
                return;
            } else {
                this.signPushTimeStamp = num2;
                return;
            }
        }
        this.signPushMask = builder.signPushMask;
        this.signPushTimeStamp = builder.signPushTimeStamp;
    }

    public /* synthetic */ PushSignMask(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
