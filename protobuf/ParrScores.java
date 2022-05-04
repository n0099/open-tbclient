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
public final class ParrScores extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_IMONEY;
    public static final Long DEFAULT_IOTHER;
    public static final Long DEFAULT_ITOTAL;
    public static final Integer DEFAULT_LEVEL;
    public static final Integer DEFAULT_LIMIT;
    public static final Integer DEFAULT_SCORESFETCH;
    public static final Integer DEFAULT_SCORESMONEY;
    public static final Integer DEFAULT_SCORESOTHER;
    public static final Integer DEFAULT_SCORESTOTAL;
    public static final Integer DEFAULT_UPDATETIME;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long iMoney;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long iOther;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long iTotal;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer scoresFetch;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer scoresMoney;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer scoresOther;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer scoresTotal;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer updateTime;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<ParrScores> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long iMoney;
        public Long iOther;
        public Long iTotal;
        public Integer level;
        public Integer limit;
        public Integer scoresFetch;
        public Integer scoresMoney;
        public Integer scoresOther;
        public Integer scoresTotal;
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
        public Builder(ParrScores parrScores) {
            super(parrScores);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parrScores};
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
            if (parrScores == null) {
                return;
            }
            this.scoresTotal = parrScores.scoresTotal;
            this.scoresFetch = parrScores.scoresFetch;
            this.scoresMoney = parrScores.scoresMoney;
            this.scoresOther = parrScores.scoresOther;
            this.updateTime = parrScores.updateTime;
            this.level = parrScores.level;
            this.limit = parrScores.limit;
            this.iTotal = parrScores.iTotal;
            this.iMoney = parrScores.iMoney;
            this.iOther = parrScores.iOther;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ParrScores build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ParrScores(this, z, null) : (ParrScores) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2001830735, "Lprotobuf/ParrScores;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2001830735, "Lprotobuf/ParrScores;");
                return;
            }
        }
        DEFAULT_SCORESTOTAL = 0;
        DEFAULT_SCORESFETCH = 0;
        DEFAULT_SCORESMONEY = 0;
        DEFAULT_SCORESOTHER = 0;
        DEFAULT_UPDATETIME = 0;
        DEFAULT_LEVEL = 0;
        DEFAULT_LIMIT = 0;
        DEFAULT_ITOTAL = 0L;
        DEFAULT_IMONEY = 0L;
        DEFAULT_IOTHER = 0L;
    }

    public /* synthetic */ ParrScores(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParrScores(Builder builder, boolean z) {
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
            Integer num = builder.scoresTotal;
            if (num == null) {
                this.scoresTotal = DEFAULT_SCORESTOTAL;
            } else {
                this.scoresTotal = num;
            }
            Integer num2 = builder.scoresFetch;
            if (num2 == null) {
                this.scoresFetch = DEFAULT_SCORESFETCH;
            } else {
                this.scoresFetch = num2;
            }
            Integer num3 = builder.scoresMoney;
            if (num3 == null) {
                this.scoresMoney = DEFAULT_SCORESMONEY;
            } else {
                this.scoresMoney = num3;
            }
            Integer num4 = builder.scoresOther;
            if (num4 == null) {
                this.scoresOther = DEFAULT_SCORESOTHER;
            } else {
                this.scoresOther = num4;
            }
            Integer num5 = builder.updateTime;
            if (num5 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num5;
            }
            Integer num6 = builder.level;
            if (num6 == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num6;
            }
            Integer num7 = builder.limit;
            if (num7 == null) {
                this.limit = DEFAULT_LIMIT;
            } else {
                this.limit = num7;
            }
            Long l = builder.iTotal;
            if (l == null) {
                this.iTotal = DEFAULT_ITOTAL;
            } else {
                this.iTotal = l;
            }
            Long l2 = builder.iMoney;
            if (l2 == null) {
                this.iMoney = DEFAULT_IMONEY;
            } else {
                this.iMoney = l2;
            }
            Long l3 = builder.iOther;
            if (l3 == null) {
                this.iOther = DEFAULT_IOTHER;
                return;
            } else {
                this.iOther = l3;
                return;
            }
        }
        this.scoresTotal = builder.scoresTotal;
        this.scoresFetch = builder.scoresFetch;
        this.scoresMoney = builder.scoresMoney;
        this.scoresOther = builder.scoresOther;
        this.updateTime = builder.updateTime;
        this.level = builder.level;
        this.limit = builder.limit;
        this.iTotal = builder.iTotal;
        this.iMoney = builder.iMoney;
        this.iOther = builder.iOther;
    }
}
