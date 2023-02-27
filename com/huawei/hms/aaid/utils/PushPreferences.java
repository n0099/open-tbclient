package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class PushPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushPreferences";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    public PushPreferences(Context context, String str) {
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
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
                if (!sharedPreferences.getBoolean(str, false)) {
                    if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = createDeviceProtectedStorageContext;
            }
            SharedPreferences b = b(context, str);
            this.a = b;
            if (b == null) {
                HMSLog.w(TAG, "get new sharedPreferences failed,start to get from context. ");
                this.a = context.getSharedPreferences(str, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public final File a(Context context, String str) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    file = new File(context.getDataDir() + "/shared_prefs", str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
                } else {
                    file = new File(context.getFilesDir().getParent() + "/shared_prefs", str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
                }
                if (!file.exists()) {
                    return null;
                }
                return file;
            } catch (Exception e) {
                HMSLog.e(TAG, "get failed error." + e.getMessage());
                return null;
            }
        }
        return (File) invokeLL.objValue;
    }

    public boolean save(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, obj)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof String) {
                edit.putString(str, String.valueOf(obj));
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Short) {
                edit.putInt(str, ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                edit.putInt(str, ((Byte) obj).byteValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                edit.putFloat(str, (float) ((Double) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            }
            return edit.commit();
        }
        return invokeLL.booleanValue;
    }

    public final SharedPreferences b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            File a = a(context, str);
            if (a == null) {
                return null;
            }
            try {
                Constructor<?> declaredConstructor = Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(File.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
                return (SharedPreferences) declaredConstructor.newInstance(a, 0);
            } catch (Exception e) {
                HMSLog.e(TAG, "get SharedPreferences error." + e.getMessage());
                return null;
            }
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    public boolean clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                return sharedPreferences.edit().clear().commit();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                return sharedPreferences.getAll();
            }
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }

    public boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null && sharedPreferences.contains(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || !sharedPreferences.getBoolean(str, false)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int getInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return 0;
            }
            return sharedPreferences.getInt(str, 0);
        }
        return invokeL.intValue;
    }

    public long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return 0L;
            }
            return sharedPreferences.getLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return "";
            }
            return sharedPreferences.getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public boolean removeKey(String str) {
        InterceptResult invokeL;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null && sharedPreferences.contains(str) && (edit = this.a.edit()) != null) {
                return edit.remove(str).commit();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void saveMap(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                save(entry.getKey(), entry.getValue());
            }
        }
    }

    public ContentValues read() {
        InterceptResult invokeV;
        Map<String, ?> all;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    contentValues.put(key, String.valueOf(value));
                } else if (!(value instanceof Integer) && !(value instanceof Short) && !(value instanceof Byte)) {
                    if (value instanceof Long) {
                        contentValues.put(key, (Long) value);
                    } else if (value instanceof Float) {
                        contentValues.put(key, (Float) value);
                    } else if (value instanceof Double) {
                        contentValues.put(key, Float.valueOf((float) ((Double) value).doubleValue()));
                    } else if (value instanceof Boolean) {
                        contentValues.put(key, (Boolean) value);
                    }
                } else {
                    contentValues.put(key, (Integer) value);
                }
            }
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public boolean removeKey(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, strArr)) == null) {
            if (this.a == null) {
                return false;
            }
            for (String str : strArr) {
                if (this.a.contains(str)) {
                    this.a.edit().remove(str);
                }
            }
            this.a.edit().commit();
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean write(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, contentValues)) == null) {
            if (this.a == null || contentValues == null) {
                return false;
            }
            boolean z = true;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (!save(entry.getKey(), entry.getValue())) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void saveBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) && (sharedPreferences = this.a) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean(str, z).commit();
        }
    }

    public void saveInt(String str, Integer num) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, num) == null) && (sharedPreferences = this.a) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, num.intValue()).commit();
        }
    }

    public void saveLong(String str, Long l) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, l) == null) && (sharedPreferences = this.a) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l.longValue()).commit();
        }
    }

    public boolean saveString(String str, String str2) {
        InterceptResult invokeLL;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return false;
            }
            return edit.putString(str, str2).commit();
        }
        return invokeLL.booleanValue;
    }
}
