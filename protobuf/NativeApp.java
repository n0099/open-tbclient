package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class NativeApp extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_DOWNLOADAND = "";
    public static final String DEFAULT_DOWNLOADIOS = "";
    public static final String DEFAULT_JUMPAND = "";
    public static final String DEFAULT_JUMPIOS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String downloadAnd;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String downloadIos;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String jumpAnd;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String jumpIos;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<NativeApp> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String downloadAnd;
        public String downloadIos;
        public String jumpAnd;
        public String jumpIos;

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
        public Builder(NativeApp nativeApp) {
            super(nativeApp);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeApp};
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
            if (nativeApp == null) {
                return;
            }
            this.jumpAnd = nativeApp.jumpAnd;
            this.jumpIos = nativeApp.jumpIos;
            this.downloadAnd = nativeApp.downloadAnd;
            this.downloadIos = nativeApp.downloadIos;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NativeApp build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new NativeApp(this, z, null) : (NativeApp) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ NativeApp(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeApp(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.jumpAnd;
            if (str == null) {
                this.jumpAnd = "";
            } else {
                this.jumpAnd = str;
            }
            String str2 = builder.jumpIos;
            if (str2 == null) {
                this.jumpIos = "";
            } else {
                this.jumpIos = str2;
            }
            String str3 = builder.downloadAnd;
            if (str3 == null) {
                this.downloadAnd = "";
            } else {
                this.downloadAnd = str3;
            }
            String str4 = builder.downloadIos;
            if (str4 == null) {
                this.downloadIos = "";
                return;
            } else {
                this.downloadIos = str4;
                return;
            }
        }
        this.jumpAnd = builder.jumpAnd;
        this.jumpIos = builder.jumpIos;
        this.downloadAnd = builder.downloadAnd;
        this.downloadIos = builder.downloadIos;
    }
}
