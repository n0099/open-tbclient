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
public final class BawuThrones extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BAZHULEVEL = "";
    public static final Integer DEFAULT_HASSENDBCAST;
    public static final Integer DEFAULT_NEWESTBCASTPUSHUSERCNT;
    public static final Integer DEFAULT_NEWESTBCASTPV;
    public static final Integer DEFAULT_TOTALBCASTCNT;
    public static final Integer DEFAULT_TOTALRECOMMENDNUM;
    public static final Integer DEFAULT_USEDBCASTCNT;
    public static final Integer DEFAULT_USEDRECOMMENDNUM;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bazhuLevel;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer hasSendBcast;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer newestBcastPushuserCnt;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer newestBcastPv;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer totalBcastCnt;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer totalRecommendNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer usedBcastCnt;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer usedRecommendNum;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<BawuThrones> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bazhuLevel;
        public Integer hasSendBcast;
        public Integer newestBcastPushuserCnt;
        public Integer newestBcastPv;
        public Integer totalBcastCnt;
        public Integer totalRecommendNum;
        public Integer usedBcastCnt;
        public Integer usedRecommendNum;

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
        public Builder(BawuThrones bawuThrones) {
            super(bawuThrones);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bawuThrones};
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
            if (bawuThrones == null) {
                return;
            }
            this.totalRecommendNum = bawuThrones.totalRecommendNum;
            this.usedRecommendNum = bawuThrones.usedRecommendNum;
            this.bazhuLevel = bawuThrones.bazhuLevel;
            this.usedBcastCnt = bawuThrones.usedBcastCnt;
            this.totalBcastCnt = bawuThrones.totalBcastCnt;
            this.newestBcastPv = bawuThrones.newestBcastPv;
            this.hasSendBcast = bawuThrones.hasSendBcast;
            this.newestBcastPushuserCnt = bawuThrones.newestBcastPushuserCnt;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BawuThrones build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new BawuThrones(this, z, null) : (BawuThrones) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(419369765, "Lprotobuf/BawuThrones;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(419369765, "Lprotobuf/BawuThrones;");
                return;
            }
        }
        DEFAULT_TOTALRECOMMENDNUM = 0;
        DEFAULT_USEDRECOMMENDNUM = 0;
        DEFAULT_USEDBCASTCNT = 0;
        DEFAULT_TOTALBCASTCNT = 0;
        DEFAULT_NEWESTBCASTPV = 0;
        DEFAULT_HASSENDBCAST = 0;
        DEFAULT_NEWESTBCASTPUSHUSERCNT = 0;
    }

    public /* synthetic */ BawuThrones(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuThrones(Builder builder, boolean z) {
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
            Integer num = builder.totalRecommendNum;
            if (num == null) {
                this.totalRecommendNum = DEFAULT_TOTALRECOMMENDNUM;
            } else {
                this.totalRecommendNum = num;
            }
            Integer num2 = builder.usedRecommendNum;
            if (num2 == null) {
                this.usedRecommendNum = DEFAULT_USEDRECOMMENDNUM;
            } else {
                this.usedRecommendNum = num2;
            }
            String str = builder.bazhuLevel;
            if (str == null) {
                this.bazhuLevel = "";
            } else {
                this.bazhuLevel = str;
            }
            Integer num3 = builder.usedBcastCnt;
            if (num3 == null) {
                this.usedBcastCnt = DEFAULT_USEDBCASTCNT;
            } else {
                this.usedBcastCnt = num3;
            }
            Integer num4 = builder.totalBcastCnt;
            if (num4 == null) {
                this.totalBcastCnt = DEFAULT_TOTALBCASTCNT;
            } else {
                this.totalBcastCnt = num4;
            }
            Integer num5 = builder.newestBcastPv;
            if (num5 == null) {
                this.newestBcastPv = DEFAULT_NEWESTBCASTPV;
            } else {
                this.newestBcastPv = num5;
            }
            Integer num6 = builder.hasSendBcast;
            if (num6 == null) {
                this.hasSendBcast = DEFAULT_HASSENDBCAST;
            } else {
                this.hasSendBcast = num6;
            }
            Integer num7 = builder.newestBcastPushuserCnt;
            if (num7 == null) {
                this.newestBcastPushuserCnt = DEFAULT_NEWESTBCASTPUSHUSERCNT;
                return;
            } else {
                this.newestBcastPushuserCnt = num7;
                return;
            }
        }
        this.totalRecommendNum = builder.totalRecommendNum;
        this.usedRecommendNum = builder.usedRecommendNum;
        this.bazhuLevel = builder.bazhuLevel;
        this.usedBcastCnt = builder.usedBcastCnt;
        this.totalBcastCnt = builder.totalBcastCnt;
        this.newestBcastPv = builder.newestBcastPv;
        this.hasSendBcast = builder.hasSendBcast;
        this.newestBcastPushuserCnt = builder.newestBcastPushuserCnt;
    }
}
