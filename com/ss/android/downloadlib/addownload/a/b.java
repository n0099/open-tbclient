package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            try {
                String string = j.getContext().getSharedPreferences(str, 0).getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        com.ss.android.downloadlib.addownload.b.a a2 = com.ss.android.downloadlib.addownload.b.a.a(jSONObject.optJSONObject(keys.next()));
                        if (a2 != null) {
                            copyOnWriteArrayList.add(a2);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return copyOnWriteArrayList;
        }
        return (CopyOnWriteArrayList) invokeLL.objValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        j.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    public void a(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, copyOnWriteArrayList) == null) || copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.b.a> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.b.a next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f69399b), next.a());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        j.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
