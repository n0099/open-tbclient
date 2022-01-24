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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f16a;

    /* renamed from: a  reason: collision with other field name */
    public b.a f17a;

    /* renamed from: a  reason: collision with other field name */
    public b f18a;

    /* renamed from: a  reason: collision with other field name */
    public d f19a;

    /* renamed from: b  reason: collision with root package name */
    public String f60367b;

    /* renamed from: c  reason: collision with root package name */
    public String f60368c;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60369f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60370g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60371h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60372i;
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
        long j2;
        long j3;
        boolean z3;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60367b = "";
        this.f60368c = "";
        this.f60369f = false;
        this.f60370g = false;
        this.f60371h = false;
        String str3 = null;
        this.f16a = null;
        this.f18a = null;
        this.a = null;
        this.f17a = null;
        this.mContext = null;
        this.f19a = null;
        this.f60372i = false;
        this.f60369f = z;
        this.f60372i = z2;
        this.f60367b = str2;
        this.f60368c = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f16a = sharedPreferences2;
            j2 = sharedPreferences2.getLong("t", 0L);
        } else {
            j2 = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (g.m124a(str3)) {
            this.f60371h = false;
            this.f60370g = false;
        } else if (str3.equals("mounted")) {
            this.f60371h = true;
            this.f60370g = true;
        } else if (str3.equals("mounted_ro")) {
            this.f60370g = true;
            this.f60371h = false;
        } else {
            this.f60371h = false;
            this.f60370g = false;
        }
        try {
            if ((this.f60370g || this.f60371h) && context != null && !g.m124a(str)) {
                d a = a(str);
                this.f19a = a;
                if (a != null) {
                    try {
                        b a2 = a.a(str2, 0);
                        this.f18a = a2;
                        j3 = a2.getLong("t", 0L);
                    } catch (Exception unused) {
                    }
                    if (z2) {
                        j2 = this.f16a.getLong("t2", 0L);
                        j3 = this.f18a.getLong("t2", 0L);
                        int i4 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i4 < 0 && j2 > 0) {
                            a(this.f16a, this.f18a);
                            this.f18a = this.f19a.a(str2, 0);
                        } else if (i4 <= 0 || j3 <= 0) {
                            int i5 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                            if (i5 == 0 && j3 > 0) {
                                a(this.f18a, this.f16a);
                                this.f16a = context.getSharedPreferences(str2, 0);
                            } else if (j3 == 0 && i5 > 0) {
                                a(this.f16a, this.f18a);
                                this.f18a = this.f19a.a(str2, 0);
                            } else if (i4 == 0) {
                                a(this.f16a, this.f18a);
                                this.f18a = this.f19a.a(str2, 0);
                            }
                        } else {
                            a(this.f18a, this.f16a);
                            this.f16a = context.getSharedPreferences(str2, 0);
                        }
                    } else {
                        int i6 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i6 > 0) {
                            a(this.f16a, this.f18a);
                            this.f18a = this.f19a.a(str2, 0);
                        } else if (i6 >= 0) {
                            if (i6 == 0) {
                                a(this.f16a, this.f18a);
                                this.f18a = this.f19a.a(str2, 0);
                            }
                            if (j2 == j3 || (j2 == 0 && j3 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z3 = this.f60372i;
                                if (z3 || (z3 && j2 == 0 && j3 == 0)) {
                                    sharedPreferences = this.f16a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    if (this.f18a != null) {
                                        b.a a3 = this.f18a.a();
                                        a3.a("t2", currentTimeMillis);
                                        a3.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            a(this.f18a, this.f16a);
                            this.f16a = context.getSharedPreferences(str2, 0);
                        }
                    }
                    if (j2 == j3) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    z3 = this.f60372i;
                    if (z3) {
                    }
                    sharedPreferences = this.f16a;
                    if (sharedPreferences != null) {
                    }
                    if (this.f18a != null) {
                    }
                }
            }
            if (this.f18a != null) {
            }
        } catch (Exception unused2) {
            return;
        }
        j3 = 0;
        if (j2 == j3) {
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        z3 = this.f60372i;
        if (z3) {
        }
        sharedPreferences = this.f16a;
        if (sharedPreferences != null) {
        }
    }

    private d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            File m125a = m125a(str);
            if (m125a != null) {
                d dVar = new d(m125a.getAbsolutePath());
                this.f19a = dVar;
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.a == null && (sharedPreferences = this.f16a) != null) {
                this.a = sharedPreferences.edit();
            }
            if (this.f60371h && this.f17a == null && (bVar = this.f18a) != null) {
                this.f17a = bVar.a();
            }
            c();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b bVar = this.f18a;
            if (bVar != null) {
                boolean b2 = bVar.b();
                if (!b2) {
                    commit();
                }
                return b2;
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
        if (r6.f17a.commit() == false) goto L39;
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
                if (!this.f60372i && this.f16a != null) {
                    editor.putLong("t", currentTimeMillis);
                }
                if (!this.a.commit()) {
                    z = false;
                    if (this.f16a != null && (context = this.mContext) != null) {
                        this.f16a = context.getSharedPreferences(this.f60367b, 0);
                    }
                    str = null;
                    str = Environment.getExternalStorageState();
                    if (!g.m124a(str)) {
                        if (str.equals("mounted")) {
                            if (this.f18a == null) {
                                d a = a(this.f60368c);
                                if (a != null) {
                                    b a2 = a.a(this.f60367b, 0);
                                    this.f18a = a2;
                                    if (!this.f60372i) {
                                        a(this.f16a, a2);
                                    } else {
                                        a(a2, this.f16a);
                                    }
                                    this.f17a = this.f18a.a();
                                }
                            } else {
                                try {
                                    if (this.f17a != null) {
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                        if (!str.equals("mounted") || (str.equals("mounted_ro") && this.f18a != null)) {
                            try {
                                if (this.f19a != null) {
                                    this.f18a = this.f19a.a(this.f60367b, 0);
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    return z;
                }
            }
            z = true;
            if (this.f16a != null) {
                this.f16a = context.getSharedPreferences(this.f60367b, 0);
            }
            str = null;
            str = Environment.getExternalStorageState();
            if (!g.m124a(str)) {
            }
            return z;
        }
        return invokeV.booleanValue;
        z = false;
        if (!str.equals("mounted")) {
        }
        if (this.f19a != null) {
        }
        return z;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c();
            SharedPreferences sharedPreferences = this.f16a;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(str, "");
                if (!g.m124a(string)) {
                    return string;
                }
            }
            b bVar = this.f18a;
            return bVar != null ? bVar.getString(str, "") : "";
        }
        return (String) invokeL.objValue;
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || g.m124a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f17a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || g.m124a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f17a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m125a(String str) {
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
        if (!(interceptable == null || interceptable.invokeLL(65539, this, sharedPreferences, bVar) == null) || sharedPreferences == null || bVar == null || (a = bVar.a()) == null) {
            return;
        }
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

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, sharedPreferences) == null) || bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
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
