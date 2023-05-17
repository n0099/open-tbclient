package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.q;
import com.vivo.push.util.u;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HashMap<String, String> b;

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
        this.b = new HashMap<>();
        this.a = context;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x003b */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: android.database.Cursor */
    /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: android.database.Cursor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b() {
        InterceptResult invokeV;
        ContentProviderClient contentProviderClient;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.a == null) {
                return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
            }
            if (this.b.size() > 0) {
                return 0;
            }
            Cursor cursor = 0;
            cursor = 0;
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient = this.a.getContentResolver().acquireUnstableContentProviderClient(q.a);
                        if (contentProviderClient != null) {
                            try {
                                cursor = contentProviderClient.query(q.a, null, null, null, null);
                            } catch (Exception e) {
                                e = e;
                                u.a("CoreConfigManager", "provider exception", e);
                                if (0 != 0) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        u.a("CoreConfigManager", "close err ", e2);
                                        return 8005;
                                    }
                                }
                                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                    contentProviderClient.close();
                                    return 8005;
                                }
                                return 8005;
                            }
                        }
                    } else {
                        contentProviderClient = null;
                    }
                    if (cursor == 0) {
                        cursor = this.a.getContentResolver().query(q.a, null, null, null, null);
                    }
                    if (cursor == 0) {
                        u.a("CoreConfigManager", "cursor is null");
                        if (cursor != 0) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                u.a("CoreConfigManager", "close err ", e3);
                                return 8008;
                            }
                        }
                        if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient.close();
                            return 8008;
                        }
                        return 8008;
                    }
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("name"));
                        String string2 = cursor.getString(cursor.getColumnIndex("value"));
                        if (!TextUtils.isEmpty(string)) {
                            this.b.put(string, string2);
                        }
                    }
                    if (cursor != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            u.a("CoreConfigManager", "close err ", e4);
                        }
                    }
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                            u.a("CoreConfigManager", "close err ", e5);
                            throw th;
                        }
                    }
                    if (0 != 0 && Build.VERSION.SDK_INT >= 24) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                contentProviderClient = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            return invokeV.intValue;
        }
    }

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int b = b();
            if (b != 0) {
                return b;
            }
            HashMap<String, String> hashMap = this.b;
            if (hashMap != null && hashMap.size() != 0) {
                String str = this.b.get("pushSupport");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if ((Integer.parseInt(str) & 1) <= 0) {
                            return 1;
                        }
                        return 0;
                    } catch (Exception unused) {
                        return 8007;
                    }
                }
                return 2;
            }
            return 8006;
        }
        return invokeV.intValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int c = c();
            u.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(c)));
            return c;
        }
        return invokeV.intValue;
    }
}
