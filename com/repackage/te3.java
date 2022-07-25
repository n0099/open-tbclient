package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vc3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class te3 extends vc3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755293681, "Lcom/repackage/te3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755293681, "Lcom/repackage/te3;");
                return;
            }
        }
        c = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te3(boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String str = z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt";
        this.b = ej2.g().getPath() + File.separator + "js_native" + File.separator + str;
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            String str = ej2.g().getPath() + File.separator + "js_native" + File.separator;
            if ((i & 1) != 0) {
                z = kg4.M(str + "swan_js_native_v8_ab.txt");
            } else {
                z = true;
            }
            if ((i & 2) != 0) {
                return z & kg4.M(str + "swan_js_native_webview_ab.txt");
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public final List<String> b(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            List<JSONObject> b = re3.b(z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW, z ? "swan/v8_ab" : "swan/webview_ab");
            if (b != null) {
                File file = new File(str);
                ArrayList arrayList = new ArrayList();
                for (JSONObject jSONObject : b) {
                    if (jSONObject != null) {
                        arrayList.add(jSONObject.toString());
                    }
                }
                if (file.exists()) {
                    kg4.L(file);
                }
                kg4.h(file);
                kg4.P(arrayList, file);
                return arrayList;
            }
            return null;
        }
        return (List) invokeZL.objValue;
    }

    public boolean c(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            if (jSONArray.length() <= 0 || !kg4.v(this.b)) {
                return false;
            }
            return se3.a(jSONArray, new File(this.b), SchemeCollecter.getSchemesDesListSize(this.a ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW));
        }
        return invokeL.booleanValue;
    }

    public List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c) {
                Log.i("SwanAppCompat", "FileDescriptionsManager obtain desc...");
            }
            if (!nc4.b() && !TextUtils.equals(nc4.a(), "0")) {
                File file = new File(this.b);
                if (file.exists()) {
                    kg4.L(file);
                }
            }
            if (kg4.v(this.b)) {
                if (c) {
                    Log.d("SwanAppCompat", "start create cache");
                }
                return kg4.F(new File(this.b));
            }
            return b(this.a, this.b);
        }
        return (List) invokeV.objValue;
    }
}
