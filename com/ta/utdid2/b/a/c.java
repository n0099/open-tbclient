package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f38847a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f10a;

    /* renamed from: a  reason: collision with other field name */
    public b.a f11a;

    /* renamed from: a  reason: collision with other field name */
    public b f12a;

    /* renamed from: a  reason: collision with other field name */
    public d f13a;

    /* renamed from: a  reason: collision with other field name */
    public String f14a;

    /* renamed from: b  reason: collision with root package name */
    public String f38848b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38849c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38850d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38851e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38852f;
    public Context mContext;

    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017b A[Catch: Exception -> 0x0187, TRY_LEAVE, TryCatch #2 {Exception -> 0x0187, blocks: (B:80:0x0177, B:82:0x017b), top: B:96:0x0177 }] */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14a = "";
        this.f38848b = "";
        this.f38849c = false;
        this.f38850d = false;
        this.f38851e = false;
        String str3 = null;
        this.f10a = null;
        this.f12a = null;
        this.f38847a = null;
        this.f11a = null;
        this.mContext = null;
        this.f13a = null;
        this.f38852f = false;
        this.f38849c = z;
        this.f38852f = z2;
        this.f14a = str2;
        this.f38848b = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f10a = sharedPreferences2;
            j = sharedPreferences2.getLong("t", 0L);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (f.isEmpty(str3)) {
            this.f38851e = false;
            this.f38850d = false;
        } else if (str3.equals("mounted")) {
            this.f38851e = true;
            this.f38850d = true;
        } else if (str3.equals("mounted_ro")) {
            this.f38850d = true;
            this.f38851e = false;
        } else {
            this.f38851e = false;
            this.f38850d = false;
        }
        try {
            if ((this.f38850d || this.f38851e) && context != null && !f.isEmpty(str)) {
                d a2 = a(str);
                this.f13a = a2;
                if (a2 != null) {
                    try {
                        b a3 = a2.a(str2, 0);
                        this.f12a = a3;
                        j2 = a3.getLong("t", 0L);
                    } catch (Exception unused) {
                    }
                    if (z2) {
                        long j3 = this.f10a.getLong("t2", 0L);
                        try {
                            j2 = this.f12a.getLong("t2", 0L);
                            int i4 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                            if (i4 < 0 && j3 > 0) {
                                a(this.f10a, this.f12a);
                                this.f12a = this.f13a.a(str2, 0);
                            } else if (i4 <= 0 || j2 <= 0) {
                                int i5 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
                                if (i5 == 0 && j2 > 0) {
                                    a(this.f12a, this.f10a);
                                    this.f10a = context.getSharedPreferences(str2, 0);
                                } else if (j2 == 0 && i5 > 0) {
                                    a(this.f10a, this.f12a);
                                    this.f12a = this.f13a.a(str2, 0);
                                } else if (i4 == 0) {
                                    a(this.f10a, this.f12a);
                                    this.f12a = this.f13a.a(str2, 0);
                                }
                            } else {
                                a(this.f12a, this.f10a);
                                this.f10a = context.getSharedPreferences(str2, 0);
                            }
                        } catch (Exception unused2) {
                        }
                        j = j3;
                    } else {
                        int i6 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i6 > 0) {
                            a(this.f10a, this.f12a);
                            this.f12a = this.f13a.a(str2, 0);
                        } else if (i6 >= 0) {
                            if (i6 == 0) {
                                a(this.f10a, this.f12a);
                                this.f12a = this.f13a.a(str2, 0);
                            }
                            if (j == j2 || (j == 0 && j2 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z3 = this.f38852f;
                                if (z3 || (z3 && j == 0 && j2 == 0)) {
                                    sharedPreferences = this.f10a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    if (this.f12a != null) {
                                        b.a a4 = this.f12a.a();
                                        a4.a("t2", currentTimeMillis);
                                        a4.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            a(this.f12a, this.f10a);
                            this.f10a = context.getSharedPreferences(str2, 0);
                        }
                    }
                    if (j == j2) {
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    z3 = this.f38852f;
                    if (z3) {
                    }
                    sharedPreferences = this.f10a;
                    if (sharedPreferences != null) {
                    }
                    if (this.f12a != null) {
                    }
                }
            }
            if (this.f12a != null) {
            }
        } catch (Exception unused3) {
            return;
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis22 = System.currentTimeMillis();
        z3 = this.f38852f;
        if (z3) {
        }
        sharedPreferences = this.f10a;
        if (sharedPreferences != null) {
        }
    }

    private d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            File m59a = m59a(str);
            if (m59a != null) {
                d dVar = new d(m59a.getAbsolutePath());
                this.f13a = dVar;
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m60b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            b bVar = this.f12a;
            if (bVar != null) {
                boolean m58a = bVar.m58a();
                if (!m58a) {
                    commit();
                }
                return m58a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|(4:5|(1:9)|10|(9:12|13|(1:17)|18|19|20|21|(4:23|(2:25|(2:27|(3:29|(1:31)(1:33)|32))(2:34|(1:38)))|39|(3:45|46|(1:48)))|51))|56|13|(2:15|17)|18|19|20|21|(0)|51) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
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
            SharedPreferences.Editor editor = this.f38847a;
            if (editor != null) {
                if (!this.f38852f && this.f10a != null) {
                    editor.putLong("t", currentTimeMillis);
                }
                if (!this.f38847a.commit()) {
                    z = false;
                    if (this.f10a != null && (context = this.mContext) != null) {
                        this.f10a = context.getSharedPreferences(this.f14a, 0);
                    }
                    str = null;
                    str = Environment.getExternalStorageState();
                    if (!f.isEmpty(str)) {
                        if (str.equals("mounted")) {
                            if (this.f12a == null) {
                                d a2 = a(this.f38848b);
                                if (a2 != null) {
                                    b a3 = a2.a(this.f14a, 0);
                                    this.f12a = a3;
                                    if (!this.f38852f) {
                                        a(this.f10a, a3);
                                    } else {
                                        a(a3, this.f10a);
                                    }
                                    this.f11a = this.f12a.a();
                                }
                            } else {
                                b.a aVar = this.f11a;
                                if (aVar != null && !aVar.commit()) {
                                    z = false;
                                }
                            }
                        }
                        if (str.equals("mounted") || (str.equals("mounted_ro") && this.f12a != null)) {
                            try {
                                if (this.f13a != null) {
                                    this.f12a = this.f13a.a(this.f14a, 0);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    return z;
                }
            }
            z = true;
            if (this.f10a != null) {
                this.f10a = context.getSharedPreferences(this.f14a, 0);
            }
            str = null;
            str = Environment.getExternalStorageState();
            if (!f.isEmpty(str)) {
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            m60b();
            SharedPreferences sharedPreferences = this.f10a;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(str, "");
                if (!f.isEmpty(string)) {
                    return string;
                }
            }
            b bVar = this.f12a;
            return bVar != null ? bVar.getString(str, "") : "";
        }
        return (String) invokeL.objValue;
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || f.isEmpty(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f38847a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f11a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || f.isEmpty(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f38847a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f11a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m59a(String str) {
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

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (this.f38847a == null && (sharedPreferences = this.f10a) != null) {
                this.f38847a = sharedPreferences.edit();
            }
            if (this.f38851e && this.f11a == null && (bVar = this.f12a) != null) {
                this.f11a = bVar.a();
            }
            m60b();
        }
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, sharedPreferences, bVar) == null) || sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        a2.commit();
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
