package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class MMSharedPreferences implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.SDK.SharedPreferences";
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] columns;
    public final ContentResolver cr;
    public REditor editor;
    public final HashMap<String, Object> values;

    /* loaded from: classes2.dex */
    public static class REditor implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean clear;
        public ContentResolver cr;
        public Set<String> remove;
        public Map<String, Object> values;

        public REditor(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.values = new HashMap();
            this.remove = new HashSet();
            this.clear = false;
            this.cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.clear = true;
                return this;
            }
            return (SharedPreferences.Editor) invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0043 A[SYNTHETIC] */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean commit() {
            InterceptResult invokeV;
            String str;
            int i2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ContentValues contentValues = new ContentValues();
                if (this.clear) {
                    this.cr.delete(c.b.CONTENT_URI, null, null);
                    this.clear = false;
                }
                Iterator<String> it = this.remove.iterator();
                while (it.hasNext()) {
                    this.cr.delete(c.b.CONTENT_URI, "key = ?", new String[]{it.next()});
                }
                for (Map.Entry<String, Object> entry : this.values.entrySet()) {
                    Object value = entry.getValue();
                    if (value == null) {
                        str = "unresolve failed, null value";
                    } else {
                        if (value instanceof Integer) {
                            i2 = 1;
                        } else if (value instanceof Long) {
                            i2 = 2;
                        } else if (value instanceof String) {
                            i2 = 3;
                        } else if (value instanceof Boolean) {
                            i2 = 4;
                        } else if (value instanceof Float) {
                            i2 = 5;
                        } else if (value instanceof Double) {
                            i2 = 6;
                        } else {
                            str = "unresolve failed, unknown type=" + value.getClass().toString();
                        }
                        if (i2 != 0) {
                            z = false;
                        } else {
                            contentValues.put("type", Integer.valueOf(i2));
                            contentValues.put("value", value.toString());
                            z = true;
                        }
                        if (!z) {
                            this.cr.update(c.b.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                        }
                    }
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", str);
                    i2 = 0;
                    if (i2 != 0) {
                    }
                    if (!z) {
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
                this.values.put(str, Boolean.valueOf(z));
                this.remove.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLZ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
                this.values.put(str, Float.valueOf(f2));
                this.remove.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLF.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
                this.values.put(str, Integer.valueOf(i2));
                this.remove.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLI.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
                this.values.put(str, Long.valueOf(j));
                this.remove.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLJ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                this.values.put(str, str2);
                this.remove.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
                return null;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.remove.add(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeL.objValue;
        }
    }

    public MMSharedPreferences(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.columns = new String[]{"_id", "key", "type", "value"};
        this.values = new HashMap<>();
        this.editor = null;
        this.cr = context.getContentResolver();
    }

    private Object getValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                Cursor query = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
                if (query == null) {
                    return null;
                }
                Object a2 = query.moveToFirst() ? c.a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
                query.close();
                return a2;
            } catch (Exception e2) {
                Log.e(TAG, "getValue exception:" + e2.getMessage());
                return null;
            }
        }
        return invokeL.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? getValue(str) != null : invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.editor == null) {
                this.editor = new REditor(this.cr);
            }
            return this.editor;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Cursor query = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
                if (query == null) {
                    return null;
                }
                int columnIndex = query.getColumnIndex("key");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("value");
                while (query.moveToNext()) {
                    this.values.put(query.getString(columnIndex), c.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
                }
                query.close();
                return this.values;
            } catch (Exception e2) {
                Log.e(TAG, "getAll exception:" + e2.getMessage());
                return this.values;
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Float)) ? f2 : ((Float) value).floatValue();
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Integer)) ? i2 : ((Integer) value).intValue();
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof String)) ? str2 : (String) value;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            return null;
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onSharedPreferenceChangeListener) == null) {
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onSharedPreferenceChangeListener) == null) {
        }
    }
}
