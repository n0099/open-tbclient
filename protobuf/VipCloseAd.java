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
/* loaded from: classes8.dex */
public final class VipCloseAd extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> DEFAULT_FORUMCLOSE;
    public static final Integer DEFAULT_ISOPEN;
    public static final Integer DEFAULT_VIPCLOSE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> forumClose;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isOpen;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer vipClose;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<VipCloseAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Integer> forumClose;
        public Integer isOpen;
        public Integer vipClose;

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
        public Builder(VipCloseAd vipCloseAd) {
            super(vipCloseAd);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vipCloseAd};
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
            if (vipCloseAd == null) {
                return;
            }
            this.isOpen = vipCloseAd.isOpen;
            this.vipClose = vipCloseAd.vipClose;
            this.forumClose = Message.copyOf(vipCloseAd.forumClose);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public VipCloseAd build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new VipCloseAd(this, z, null) : (VipCloseAd) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1398933435, "Lprotobuf/VipCloseAd;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1398933435, "Lprotobuf/VipCloseAd;");
                return;
            }
        }
        DEFAULT_ISOPEN = 0;
        DEFAULT_VIPCLOSE = 0;
        DEFAULT_FORUMCLOSE = Collections.emptyList();
    }

    public /* synthetic */ VipCloseAd(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipCloseAd(Builder builder, boolean z) {
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
            Integer num = builder.isOpen;
            if (num == null) {
                this.isOpen = DEFAULT_ISOPEN;
            } else {
                this.isOpen = num;
            }
            Integer num2 = builder.vipClose;
            if (num2 == null) {
                this.vipClose = DEFAULT_VIPCLOSE;
            } else {
                this.vipClose = num2;
            }
            List<Integer> list = builder.forumClose;
            if (list == null) {
                this.forumClose = DEFAULT_FORUMCLOSE;
                return;
            } else {
                this.forumClose = Message.immutableCopyOf(list);
                return;
            }
        }
        this.isOpen = builder.isOpen;
        this.vipClose = builder.vipClose;
        this.forumClose = Message.immutableCopyOf(builder.forumClose);
    }
}
