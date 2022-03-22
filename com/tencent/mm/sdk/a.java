package com.tencent.mm.sdk;

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
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class a implements SharedPreferences {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f43677b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Object> f43678c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences$EditorC2102a f43679d;

    /* renamed from: com.tencent.mm.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class SharedPreferences$EditorC2102a implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ContentResolver a;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f43680e;

        /* renamed from: f  reason: collision with root package name */
        public Set<String> f43681f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43682g;

        public SharedPreferences$EditorC2102a(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43680e = new HashMap();
            this.f43681f = new HashSet();
            this.f43682g = false;
            this.a = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f43682g = true;
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
        public final boolean commit() {
            InterceptResult invokeV;
            String str;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ContentValues contentValues = new ContentValues();
                if (this.f43682g) {
                    this.a.delete(a.b.CONTENT_URI, null, null);
                    this.f43682g = false;
                }
                Iterator<String> it = this.f43681f.iterator();
                while (it.hasNext()) {
                    this.a.delete(a.b.CONTENT_URI, "key = ?", new String[]{it.next()});
                }
                for (Map.Entry<String, Object> entry : this.f43680e.entrySet()) {
                    Object value = entry.getValue();
                    if (value == null) {
                        str = "unresolve failed, null value";
                    } else {
                        if (value instanceof Integer) {
                            i = 1;
                        } else if (value instanceof Long) {
                            i = 2;
                        } else if (value instanceof String) {
                            i = 3;
                        } else if (value instanceof Boolean) {
                            i = 4;
                        } else if (value instanceof Float) {
                            i = 5;
                        } else if (value instanceof Double) {
                            i = 6;
                        } else {
                            str = "unresolve failed, unknown type=" + value.getClass().toString();
                        }
                        if (i != 0) {
                            z = false;
                        } else {
                            contentValues.put("type", Integer.valueOf(i));
                            contentValues.put("value", value.toString());
                            z = true;
                        }
                        if (!z) {
                            this.a.update(a.b.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                        }
                    }
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", str);
                    i = 0;
                    if (i != 0) {
                    }
                    if (!z) {
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
                this.f43680e.put(str, Boolean.valueOf(z));
                this.f43681f.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLZ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
                this.f43680e.put(str, Float.valueOf(f2));
                this.f43681f.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLF.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
                this.f43680e.put(str, Integer.valueOf(i));
                this.f43681f.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLI.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
                this.f43680e.put(str, Long.valueOf(j));
                this.f43681f.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLJ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                this.f43680e.put(str, str2);
                this.f43681f.remove(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
                return null;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f43681f.add(str);
                return this;
            }
            return (SharedPreferences.Editor) invokeL.objValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43677b = new String[]{"_id", "key", "type", "value"};
        this.f43678c = new HashMap<>();
        this.f43679d = null;
        this.a = context.getContentResolver();
    }

    private Object getValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                Cursor query = this.a.query(a.b.CONTENT_URI, this.f43677b, "key = ?", new String[]{str}, null);
                if (query == null) {
                    return null;
                }
                Object a = query.moveToFirst() ? a.C2106a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
                query.close();
                return a;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return invokeL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? getValue(str) != null : invokeL.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f43679d == null) {
                this.f43679d = new SharedPreferences$EditorC2102a(this.a);
            }
            return this.f43679d;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Cursor query = this.a.query(a.b.CONTENT_URI, this.f43677b, null, null, null);
                if (query == null) {
                    return null;
                }
                int columnIndex = query.getColumnIndex("key");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("value");
                while (query.moveToNext()) {
                    this.f43678c.put(query.getString(columnIndex), a.C2106a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
                }
                query.close();
                return this.f43678c;
            } catch (Exception e2) {
                e2.printStackTrace();
                return this.f43678c;
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
        }
        return invokeLZ.booleanValue;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Float)) ? f2 : ((Float) value).floatValue();
        }
        return invokeLF.floatValue;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
        }
        return invokeLI.intValue;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
        }
        return invokeLJ.longValue;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            Object value = getValue(str);
            return (value == null || !(value instanceof String)) ? str2 : (String) value;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            return null;
        }
        return (Set) invokeLL.objValue;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onSharedPreferenceChangeListener) == null) {
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onSharedPreferenceChangeListener) == null) {
        }
    }
}
