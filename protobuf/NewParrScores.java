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
public final class NewParrScores extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_ITOTAL;
    public static final Long DEFAULT_SCORESTOTAL;
    public static final Integer DEFAULT_UPDATETIME;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long iTotal;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long scoresTotal;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer updateTime;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<NewParrScores> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long iTotal;
        public Long scoresTotal;
        public Integer updateTime;

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
        public Builder(NewParrScores newParrScores) {
            super(newParrScores);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newParrScores};
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
            if (newParrScores == null) {
                return;
            }
            this.scoresTotal = newParrScores.scoresTotal;
            this.updateTime = newParrScores.updateTime;
            this.iTotal = newParrScores.iTotal;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewParrScores build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new NewParrScores(this, z, null) : (NewParrScores) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-135593311, "Lprotobuf/NewParrScores;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-135593311, "Lprotobuf/NewParrScores;");
                return;
            }
        }
        DEFAULT_SCORESTOTAL = 0L;
        DEFAULT_UPDATETIME = 0;
        DEFAULT_ITOTAL = 0L;
    }

    public /* synthetic */ NewParrScores(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewParrScores(Builder builder, boolean z) {
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
            Long l = builder.scoresTotal;
            if (l == null) {
                this.scoresTotal = DEFAULT_SCORESTOTAL;
            } else {
                this.scoresTotal = l;
            }
            Integer num = builder.updateTime;
            if (num == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num;
            }
            Long l2 = builder.iTotal;
            if (l2 == null) {
                this.iTotal = DEFAULT_ITOTAL;
                return;
            } else {
                this.iTotal = l2;
                return;
            }
        }
        this.scoresTotal = builder.scoresTotal;
        this.updateTime = builder.updateTime;
        this.iTotal = builder.iTotal;
    }
}
