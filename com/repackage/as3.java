package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class as3 extends mr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846256, "Lcom/repackage/as3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846256, "Lcom/repackage/as3;");
                return;
            }
        }
        c = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as3() {
        super("ReservationGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.mr3
    public hr1 a(@NonNull JSONObject jSONObject, @NonNull lc2 lc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lc2Var)) == null) {
            if (jSONObject == null) {
                lc2Var.onFail(202, "params may be error");
                return null;
            }
            if (c) {
                Log.e("ReservationGameAction", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("apkId");
            int optInt = jSONObject.optInt("isReservation");
            if (TextUtils.isEmpty(optString)) {
                lc2Var.onFail(31023, "reservation apk id is empty");
                return null;
            } else if (optInt == 0) {
                lc2Var.onFail(31024, "reservation status error");
                return null;
            } else {
                String string = v73.a().getString("reservation_apk_ids", "");
                if (optInt == 1) {
                    d(string, optString);
                    lc2Var.a(null);
                } else if (optInt == 2) {
                    if (b(string, optString)) {
                        lc2Var.a(null);
                    } else {
                        lc2Var.onFail(31025, "reservation cancel fail");
                    }
                }
                return null;
            }
        }
        return (hr1) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split(",")));
            boolean remove = arrayList.remove(str2);
            if (remove) {
                c(arrayList);
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public final void c(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuffer.append(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            v73.a().putString("reservation_apk_ids", stringBuffer.toString());
        }
    }

    public final void d(String str, String str2) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(Arrays.asList(str.split(",")));
            }
            hashSet.add(str2);
            c(new ArrayList<>(hashSet));
        }
    }
}
