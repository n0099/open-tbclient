package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ta.utdid2.a.a.g;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f22a;

    /* renamed from: a  reason: collision with other field name */
    public b.a f23a;

    /* renamed from: a  reason: collision with other field name */
    public b f24a;

    /* renamed from: a  reason: collision with other field name */
    public d f25a;
    public String b;
    public String c;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Context mContext;

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017a A[Catch: Exception -> 0x0186, TRY_LEAVE, TryCatch #1 {Exception -> 0x0186, blocks: (B:79:0x0176, B:81:0x017a), top: B:91:0x0176 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(Context context, String str, String str2, boolean z, boolean z2) {
        long j;
        long j2;
        boolean z3;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = "";
        this.f = false;
        this.g = false;
        this.h = false;
        String str3 = null;
        this.f22a = null;
        this.f24a = null;
        this.a = null;
        this.f23a = null;
        this.mContext = null;
        this.f25a = null;
        this.i = false;
        this.f = z;
        this.i = z2;
        this.b = str2;
        this.c = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f22a = sharedPreferences2;
            j = sharedPreferences2.getLong("t", 0L);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (g.m93a(str3)) {
            this.h = false;
            this.g = false;
        } else if (str3.equals("mounted")) {
            this.h = true;
            this.g = true;
        } else if (str3.equals("mounted_ro")) {
            this.g = true;
            this.h = false;
        } else {
            this.h = false;
            this.g = false;
        }
        try {
            if ((this.g || this.h) && context != null && !g.m93a(str)) {
                d a = a(str);
                this.f25a = a;
                if (a != null) {
                    try {
                        b a2 = a.a(str2, 0);
                        this.f24a = a2;
                        j2 = a2.getLong("t", 0L);
                    } catch (Exception unused) {
                    }
                    if (!z2) {
                        int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i3 > 0) {
                            a(this.f22a, this.f24a);
                            this.f24a = this.f25a.a(str2, 0);
                        } else if (i3 < 0) {
                            a(this.f24a, this.f22a);
                            this.f22a = context.getSharedPreferences(str2, 0);
                        } else {
                            if (i3 == 0) {
                                a(this.f22a, this.f24a);
                                this.f24a = this.f25a.a(str2, 0);
                            }
                            if (j == j2 || (j == 0 && j2 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z3 = this.i;
                                if (z3 || (z3 && j == 0 && j2 == 0)) {
                                    sharedPreferences = this.f22a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    if (this.f24a != null) {
                                        b.a a3 = this.f24a.a();
                                        a3.a("t2", currentTimeMillis);
                                        a3.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        j = this.f22a.getLong("t2", 0L);
                        j2 = this.f24a.getLong("t2", 0L);
                        int i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i4 < 0 && j > 0) {
                            a(this.f22a, this.f24a);
                            this.f24a = this.f25a.a(str2, 0);
                        } else if (i4 > 0 && j2 > 0) {
                            a(this.f24a, this.f22a);
                            this.f22a = context.getSharedPreferences(str2, 0);
                        } else {
                            int i5 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                            if (i5 == 0 && j2 > 0) {
                                a(this.f24a, this.f22a);
                                this.f22a = context.getSharedPreferences(str2, 0);
                            } else if (j2 == 0 && i5 > 0) {
                                a(this.f22a, this.f24a);
                                this.f24a = this.f25a.a(str2, 0);
                            } else if (i4 == 0) {
                                a(this.f22a, this.f24a);
                                this.f24a = this.f25a.a(str2, 0);
                            }
                        }
                    }
                    if (j == j2) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    z3 = this.i;
                    if (z3) {
                    }
                    sharedPreferences = this.f22a;
                    if (sharedPreferences != null) {
                    }
                    if (this.f24a != null) {
                    }
                }
            }
            if (this.f24a != null) {
            }
        } catch (Exception unused2) {
            return;
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        z3 = this.i;
        if (z3) {
        }
        sharedPreferences = this.f22a;
        if (sharedPreferences != null) {
        }
    }

    private d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            File m94a = m94a(str);
            if (m94a != null) {
                d dVar = new d(m94a.getAbsolutePath());
                this.f25a = dVar;
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c();
            SharedPreferences sharedPreferences = this.f22a;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(str, "");
                if (!g.m93a(string)) {
                    return string;
                }
            }
            b bVar = this.f24a;
            if (bVar == null) {
                return "";
            }
            return bVar.getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !g.m93a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                editor.remove(str);
            }
            b.a aVar = this.f23a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m94a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, sharedPreferences, bVar) == null) && sharedPreferences != null && bVar != null && (a = bVar.a()) != null) {
            a.b();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    a.a(key, (String) value);
                } else if (value instanceof Integer) {
                    a.a(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    a.a(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    a.a(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    a.a(key, ((Boolean) value).booleanValue());
                }
            }
            try {
                a.commit();
            } catch (Exception unused) {
            }
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, sharedPreferences) == null) && bVar != null && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
        }
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.a == null && (sharedPreferences = this.f22a) != null) {
                this.a = sharedPreferences.edit();
            }
            if (this.h && this.f23a == null && (bVar = this.f24a) != null) {
                this.f23a = bVar.a();
            }
            c();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b bVar = this.f24a;
            if (bVar != null) {
                boolean b = bVar.b();
                if (!b) {
                    commit();
                }
                return b;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|(4:5|(1:9)|10|(9:12|13|(1:17)|18|19|20|21|(4:23|(2:25|(2:27|(3:29|(1:31)(1:33)|32))(3:34|35|(1:37)))|42|(3:48|49|(1:51)))|54))|59|13|(2:15|17)|18|19|20|21|(0)|54) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
        if (r6.f23a.commit() == false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a6, blocks: (B:49:0x0098, B:51:0x009c), top: B:61:0x0098 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean commit() {
        InterceptResult invokeV;
        boolean z;
        String str;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                if (!this.i && this.f22a != null) {
                    editor.putLong("t", currentTimeMillis);
                }
                if (!this.a.commit()) {
                    z = false;
                    if (this.f22a != null && (context = this.mContext) != null) {
                        this.f22a = context.getSharedPreferences(this.b, 0);
                    }
                    str = null;
                    str = Environment.getExternalStorageState();
                    if (!g.m93a(str)) {
                        if (str.equals("mounted")) {
                            if (this.f24a == null) {
                                d a = a(this.c);
                                if (a != null) {
                                    b a2 = a.a(this.b, 0);
                                    this.f24a = a2;
                                    if (!this.i) {
                                        a(this.f22a, a2);
                                    } else {
                                        a(a2, this.f22a);
                                    }
                                    this.f23a = this.f24a.a();
                                }
                            } else {
                                try {
                                    if (this.f23a != null) {
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (!str.equals("mounted") || (str.equals("mounted_ro") && this.f24a != null)) {
                            try {
                                if (this.f25a != null) {
                                    this.f24a = this.f25a.a(this.b, 0);
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    return z;
                }
            }
            z = true;
            if (this.f22a != null) {
                this.f22a = context.getSharedPreferences(this.b, 0);
            }
            str = null;
            str = Environment.getExternalStorageState();
            if (!g.m93a(str)) {
            }
            return z;
        }
        return invokeV.booleanValue;
        z = false;
        if (!str.equals("mounted")) {
        }
        if (this.f25a != null) {
        }
        return z;
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && !g.m93a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                editor.putString(str, str2);
            }
            b.a aVar = this.f23a;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }
    }
}
