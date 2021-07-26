package d.a.n.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43690a;

    /* renamed from: b  reason: collision with root package name */
    public String f43691b;

    /* renamed from: c  reason: collision with root package name */
    public String f43692c;

    /* renamed from: d  reason: collision with root package name */
    public String f43693d;

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
                return;
            }
        }
        b();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43693d : (String) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = Build.MODEL;
            this.f43690a = str;
            if (TextUtils.isEmpty(str)) {
                this.f43690a = "NUL";
            } else {
                this.f43690a = this.f43690a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f43691b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f43691b = "NUL";
            } else {
                this.f43691b = this.f43691b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f43692c = str3;
            if (TextUtils.isEmpty(str3)) {
                this.f43692c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
            } else {
                this.f43692c = this.f43692c.replace("_", "-");
            }
            this.f43693d = c();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.f43690a;
            String str2 = this.f43692c;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.f43691b;
            return str + "_" + str2 + "_" + i2 + "_" + str3;
        }
        return (String) invokeV.objValue;
    }
}
