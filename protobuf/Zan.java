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
public final class Zan extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_CONSENTTYPE;
    public static final Integer DEFAULT_ISLIKED;
    public static final Integer DEFAULT_LASTTIME;
    public static final List<Long> DEFAULT_LIKERID;
    public static final Integer DEFAULT_NUM;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer consentType;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isLiked;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer lastTime;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT64)
    public final List<Long> likerId;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer num;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer consentType;
        public Integer isLiked;
        public Integer lastTime;
        public List likerId;
        public Integer num;

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
        public Builder(Zan zan) {
            super(zan);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zan};
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
            if (zan == null) {
                return;
            }
            this.num = zan.num;
            this.isLiked = zan.isLiked;
            this.lastTime = zan.lastTime;
            this.likerId = Message.copyOf(zan.likerId);
            this.consentType = zan.consentType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Zan build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new Zan(this, z, null);
            }
            return (Zan) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10388044, "Lprotobuf/Zan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(10388044, "Lprotobuf/Zan;");
                return;
            }
        }
        DEFAULT_NUM = 0;
        DEFAULT_ISLIKED = 0;
        DEFAULT_LASTTIME = 0;
        DEFAULT_LIKERID = Collections.emptyList();
        DEFAULT_CONSENTTYPE = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Zan(Builder builder, boolean z) {
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
            Integer num = builder.num;
            if (num == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = num;
            }
            Integer num2 = builder.isLiked;
            if (num2 == null) {
                this.isLiked = DEFAULT_ISLIKED;
            } else {
                this.isLiked = num2;
            }
            Integer num3 = builder.lastTime;
            if (num3 == null) {
                this.lastTime = DEFAULT_LASTTIME;
            } else {
                this.lastTime = num3;
            }
            List list = builder.likerId;
            if (list == null) {
                this.likerId = DEFAULT_LIKERID;
            } else {
                this.likerId = Message.immutableCopyOf(list);
            }
            Integer num4 = builder.consentType;
            if (num4 == null) {
                this.consentType = DEFAULT_CONSENTTYPE;
                return;
            } else {
                this.consentType = num4;
                return;
            }
        }
        this.num = builder.num;
        this.isLiked = builder.isLiked;
        this.lastTime = builder.lastTime;
        this.likerId = Message.immutableCopyOf(builder.likerId);
        this.consentType = builder.consentType;
    }

    public /* synthetic */ Zan(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
