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
    public static class C1927a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f64835a;

        /* renamed from: b  reason: collision with root package name */
        public String f64836b;

        /* renamed from: c  reason: collision with root package name */
        public String f64837c;

        /* renamed from: d  reason: collision with root package name */
        public long f64838d;

        /* renamed from: e  reason: collision with root package name */
        public String f64839e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f64840f;

        public C1927a() {
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
            this.f64835a = jSONObject.optInt("dynamicType");
            this.f64836b = jSONObject.optString("dynamicUrl");
            this.f64837c = jSONObject.optString(PackageTable.MD5);
            this.f64838d = jSONObject.optLong("interval");
            this.f64839e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64835a == 1 : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64835a == -1 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f64841a;

        /* renamed from: b  reason: collision with root package name */
        public String f64842b;

        /* renamed from: c  reason: collision with root package name */
        public C1927a f64843c;

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
            this.f64841a = jSONObject.optLong("result");
            this.f64842b = jSONObject.optString("errorMsg");
            C1927a c1927a = new C1927a();
            this.f64843c = c1927a;
            c1927a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64841a == 1 && this.f64843c != null : invokeV.booleanValue;
        }
    }
}
