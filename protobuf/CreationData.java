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
public final class CreationData extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_AGREECOUNT;
    public static final Integer DEFAULT_AGREECOUNTTREND;
    public static final Integer DEFAULT_COMMENTCOUNT;
    public static final Integer DEFAULT_COMMENTTREND;
    public static final Integer DEFAULT_VALIDPLAYCOUNT;
    public static final Integer DEFAULT_VALIDPLAYCOUNTTREND;
    public static final Integer DEFAULT_VIEWCOUNT;
    public static final Integer DEFAULT_VIEWCOUNTTREND;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer agreeCount;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer agreeCountTrend;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer commentCount;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer commentTrend;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer validPlayCount;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer validPlayCountTrend;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer viewCount;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer viewCountTrend;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer agreeCount;
        public Integer agreeCountTrend;
        public Integer commentCount;
        public Integer commentTrend;
        public Integer validPlayCount;
        public Integer validPlayCountTrend;
        public Integer viewCount;
        public Integer viewCountTrend;

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
        public Builder(CreationData creationData) {
            super(creationData);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {creationData};
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
            if (creationData == null) {
                return;
            }
            this.viewCount = creationData.viewCount;
            this.agreeCount = creationData.agreeCount;
            this.viewCountTrend = creationData.viewCountTrend;
            this.agreeCountTrend = creationData.agreeCountTrend;
            this.commentCount = creationData.commentCount;
            this.commentTrend = creationData.commentTrend;
            this.validPlayCount = creationData.validPlayCount;
            this.validPlayCountTrend = creationData.validPlayCountTrend;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CreationData build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new CreationData(this, z, null);
            }
            return (CreationData) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(941017562, "Lprotobuf/CreationData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(941017562, "Lprotobuf/CreationData;");
                return;
            }
        }
        DEFAULT_VIEWCOUNT = 0;
        DEFAULT_AGREECOUNT = 0;
        DEFAULT_VIEWCOUNTTREND = 0;
        DEFAULT_AGREECOUNTTREND = 0;
        DEFAULT_COMMENTCOUNT = 0;
        DEFAULT_COMMENTTREND = 0;
        DEFAULT_VALIDPLAYCOUNT = 0;
        DEFAULT_VALIDPLAYCOUNTTREND = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreationData(Builder builder, boolean z) {
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
            Integer num = builder.viewCount;
            if (num == null) {
                this.viewCount = DEFAULT_VIEWCOUNT;
            } else {
                this.viewCount = num;
            }
            Integer num2 = builder.agreeCount;
            if (num2 == null) {
                this.agreeCount = DEFAULT_AGREECOUNT;
            } else {
                this.agreeCount = num2;
            }
            Integer num3 = builder.viewCountTrend;
            if (num3 == null) {
                this.viewCountTrend = DEFAULT_VIEWCOUNTTREND;
            } else {
                this.viewCountTrend = num3;
            }
            Integer num4 = builder.agreeCountTrend;
            if (num4 == null) {
                this.agreeCountTrend = DEFAULT_AGREECOUNTTREND;
            } else {
                this.agreeCountTrend = num4;
            }
            Integer num5 = builder.commentCount;
            if (num5 == null) {
                this.commentCount = DEFAULT_COMMENTCOUNT;
            } else {
                this.commentCount = num5;
            }
            Integer num6 = builder.commentTrend;
            if (num6 == null) {
                this.commentTrend = DEFAULT_COMMENTTREND;
            } else {
                this.commentTrend = num6;
            }
            Integer num7 = builder.validPlayCount;
            if (num7 == null) {
                this.validPlayCount = DEFAULT_VALIDPLAYCOUNT;
            } else {
                this.validPlayCount = num7;
            }
            Integer num8 = builder.validPlayCountTrend;
            if (num8 == null) {
                this.validPlayCountTrend = DEFAULT_VALIDPLAYCOUNTTREND;
                return;
            } else {
                this.validPlayCountTrend = num8;
                return;
            }
        }
        this.viewCount = builder.viewCount;
        this.agreeCount = builder.agreeCount;
        this.viewCountTrend = builder.viewCountTrend;
        this.agreeCountTrend = builder.agreeCountTrend;
        this.commentCount = builder.commentCount;
        this.commentTrend = builder.commentTrend;
        this.validPlayCount = builder.validPlayCount;
        this.validPlayCountTrend = builder.validPlayCountTrend;
    }

    public /* synthetic */ CreationData(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
