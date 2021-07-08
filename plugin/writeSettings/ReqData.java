package plugin.writeSettings;

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
public final class ReqData extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTAINER_VERSION = "";
    public static final String DEFAULT_FORBIDDEN_FEATURE = "";
    public static final List<Plugin_setting> DEFAULT_PLUGIN_SETTINGS_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String container_version;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String forbidden_feature;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<Plugin_setting> plugin_settings_list;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ReqData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String container_version;
        public String forbidden_feature;
        public List<Plugin_setting> plugin_settings_list;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(ReqData reqData) {
            super(reqData);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reqData};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (reqData == null) {
                return;
            }
            this.plugin_settings_list = Message.copyOf(reqData.plugin_settings_list);
            this.container_version = reqData.container_version;
            this.forbidden_feature = reqData.forbidden_feature;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ReqData build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ReqData(this, z, null) : (ReqData) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-238481456, "Lplugin/writeSettings/ReqData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-238481456, "Lplugin/writeSettings/ReqData;");
                return;
            }
        }
        DEFAULT_PLUGIN_SETTINGS_LIST = Collections.emptyList();
    }

    public /* synthetic */ ReqData(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReqData(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            List<Plugin_setting> list = builder.plugin_settings_list;
            if (list == null) {
                this.plugin_settings_list = DEFAULT_PLUGIN_SETTINGS_LIST;
            } else {
                this.plugin_settings_list = Message.immutableCopyOf(list);
            }
            String str = builder.container_version;
            if (str == null) {
                this.container_version = "";
            } else {
                this.container_version = str;
            }
            String str2 = builder.forbidden_feature;
            if (str2 == null) {
                this.forbidden_feature = "";
                return;
            } else {
                this.forbidden_feature = str2;
                return;
            }
        }
        this.plugin_settings_list = Message.immutableCopyOf(builder.plugin_settings_list);
        this.container_version = builder.container_version;
        this.forbidden_feature = builder.forbidden_feature;
    }
}
