package d.a.n0.a.k2.g;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f45902a;

    /* renamed from: b  reason: collision with root package name */
    public final int f45903b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45904c;

    /* renamed from: d  reason: collision with root package name */
    public final String f45905d;

    public c(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45902a = str;
        this.f45903b = i2;
        this.f45904c = str2;
        this.f45905d = str3;
    }

    public static Bundle a(String str, int i2, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65537, null, str, i2, str2, str3)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_sp_name_key", str);
            bundle.putString("bundle_prefs_key", str2);
            bundle.putInt("bundle_data_type_key", i2);
            bundle.putString("bundle_data_value_key", str3);
            return bundle;
        }
        return (Bundle) invokeLILL.objValue;
    }

    public static c b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            if (bundle.isEmpty()) {
                return null;
            }
            return new c(bundle.getString("bundle_sp_name_key"), bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
        }
        return (c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SpMethodInfo{mDataType=" + this.f45903b + ", mPrefName='" + this.f45904c + "', mDataValue='" + this.f45905d + "'}";
        }
        return (String) invokeV.objValue;
    }
}
