package com.kwad.sdk.api.loader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1887a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63922a;

        /* renamed from: b  reason: collision with root package name */
        public String f63923b;

        /* renamed from: c  reason: collision with root package name */
        public String f63924c;

        /* renamed from: d  reason: collision with root package name */
        public long f63925d;

        /* renamed from: e  reason: collision with root package name */
        public String f63926e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f63927f;

        public C1887a() {
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

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f63922a = jSONObject.optInt("dynamicType");
            this.f63923b = jSONObject.optString("dynamicUrl");
            this.f63924c = jSONObject.optString(PackageTable.MD5);
            this.f63925d = jSONObject.optLong("interval");
            this.f63926e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63922a == 1 : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63922a == -1 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f63928a;

        /* renamed from: b  reason: collision with root package name */
        public String f63929b;

        /* renamed from: c  reason: collision with root package name */
        public C1887a f63930c;

        public b() {
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

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f63928a = jSONObject.optLong("result");
            this.f63929b = jSONObject.optString("errorMsg");
            C1887a c1887a = new C1887a();
            this.f63930c = c1887a;
            c1887a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63928a == 1 && this.f63930c != null : invokeV.booleanValue;
        }
    }
}
