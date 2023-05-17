package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PLSharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    public static final String TAG = "PLSharedPreferences";
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences sp;

    public PLSharedPreferences(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sp = getSharedPreferences(context, str);
    }

    private SharedPreferences getSharedPreferences(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, str)) == null) {
            if (context == null) {
                Logger.e(TAG, "context is null, must call init method to set context");
                return null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
                if (!sharedPreferences.getBoolean(str, false)) {
                    if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = createDeviceProtectedStorageContext;
            }
            return context.getSharedPreferences(str, 0);
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    public void clear() {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (sharedPreferences = this.sp) == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences == null) {
                return null;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            StringBuilder sb = new StringBuilder();
            sb.append("sp size ");
            if (all == null) {
                size = 0;
            } else {
                size = all.size();
            }
            sb.append(size);
            Logger.i(TAG, sb.toString());
            return all;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, String> getHashMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences == null) {
                return hashMap;
            }
            try {
                JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONArray names = jSONObject.names();
                    if (names != null) {
                        for (int i2 = 0; i2 < names.length(); i2++) {
                            String string = names.getString(i2);
                            hashMap.put(string, jSONObject.getString(string));
                        }
                    }
                }
            } catch (JSONException e) {
                Logger.w(TAG, "getHashMap parse Json to map error: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences == null) {
                return j;
            }
            return sharedPreferences.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.sp;
            if (sharedPreferences == null) {
                return str2;
            }
            return sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j) != null) || (sharedPreferences = this.sp) == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, str2) != null) || (sharedPreferences = this.sp) == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || (sharedPreferences = this.sp) == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void removeKeyValue(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || (sharedPreferences = this.sp) == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void putHashMap(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, map) == null) && this.sp != null && map != null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    Logger.w(TAG, "putHashMap one object error: %s", StringUtils.anonymizeMessage(e.getMessage()));
                }
            }
            jSONArray.put(jSONObject);
            this.sp.edit().putString(str, jSONArray.toString()).apply();
        }
    }
}
