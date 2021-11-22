package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f68627g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f68628h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public OpenId f68629a;

    /* renamed from: b  reason: collision with root package name */
    public OpenId f68630b;

    /* renamed from: c  reason: collision with root package name */
    public OpenId f68631c;

    /* renamed from: d  reason: collision with root package name */
    public OpenId f68632d;

    /* renamed from: e  reason: collision with root package name */
    public SupportInfo f68633e;

    /* renamed from: f  reason: collision with root package name */
    public BroadcastReceiver f68634f;

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
                return;
            }
        }
        this.f68629a = new OpenId("udid");
        this.f68630b = new OpenId("oaid");
        this.f68632d = new OpenId("vaid");
        this.f68631c = new OpenId("aaid");
        this.f68633e = new SupportInfo();
    }

    public static ValueData a(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cursor)) == null) {
            ValueData valueData = new ValueData(null, 0);
            if (cursor == null) {
                str = "parseValue fail, cursor is null.";
            } else if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.value = cursor.getString(columnIndex);
                } else {
                    b("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.code = cursor.getInt(columnIndex2);
                } else {
                    b("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.expired = cursor.getLong(columnIndex3);
                } else {
                    b("parseExpired fail, index < 0.");
                }
                return valueData;
            } else {
                str = "parseValue fail, cursor is closed.";
            }
            b(str);
            return valueData;
        }
        return (ValueData) invokeL.objValue;
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68627g == null) {
                synchronized (b.class) {
                    if (f68627g == null) {
                        f68627g = new b();
                    }
                }
            }
            return f68627g;
        }
        return (b) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            boolean z = f68628h;
        }
    }

    public OpenId a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("oaid".equals(str)) {
                return this.f68630b;
            }
            if ("vaid".equals(str)) {
                return this.f68632d;
            }
            if ("aaid".equals(str)) {
                return this.f68631c;
            }
            if ("udid".equals(str)) {
                return this.f68629a;
            }
            return null;
        }
        return (OpenId) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00c2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, OpenId openId) {
        InterceptResult invokeLL;
        String str;
        Cursor cursor;
        boolean a2;
        StringBuilder sb;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, openId)) == null) {
            Cursor cursor2 = 0;
            r0 = null;
            r0 = null;
            String str4 = null;
            Cursor cursor3 = null;
            if (openId == null) {
                str3 = "getId, openId = null.";
            } else if (openId.isValid()) {
                return openId.value;
            } else {
                if (a(context, true)) {
                    b("queryId : " + openId.type);
                    try {
                        try {
                            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{openId.type}, null);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    }
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        str = str4;
                        cursor3 = cursor;
                        b("queryId, Exception : " + e.getMessage());
                        if (cursor3 == null) {
                            cursor2 = str;
                            return cursor2;
                        }
                        cursor = cursor3;
                        str4 = str;
                        cursor.close();
                        return str4;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != 0) {
                            cursor2.close();
                        }
                        throw th;
                    }
                    if (cursor == null) {
                        if (a(context, false)) {
                            a2 = a(context, true);
                            sb = new StringBuilder();
                            str2 = "forceQuery isSupported : ";
                            sb.append(str2);
                            sb.append(a2);
                            b(sb.toString());
                        }
                        if (cursor == null) {
                        }
                        cursor.close();
                        return str4;
                    }
                    ValueData a3 = a(cursor);
                    str4 = a3.value;
                    openId.updateValue(str4);
                    openId.updateExpiredTime(a3.expired);
                    openId.updateCode(a3.code);
                    b(openId.type + " errorCode : " + openId.code);
                    if (a3.code != 1000) {
                        b(context);
                        if (!a(context, false)) {
                            a2 = a(context, true);
                            sb = new StringBuilder();
                            str2 = "not support, forceQuery isSupported: ";
                            sb.append(str2);
                            sb.append(a2);
                            b(sb.toString());
                        }
                    }
                    if (cursor == null) {
                        return str4;
                    }
                    cursor.close();
                    return str4;
                }
                str3 = "getId, isSupported = false.";
            }
            b(str3);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            f68628h = z;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        if ("0".equals(r9.value) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r7 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, context)) != null) {
            return invokeL.booleanValue;
        }
        b("querySupport version : 1.0.4");
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor != null) {
                    ValueData a2 = a(cursor);
                    if (1000 == a2.code) {
                    }
                    z = true;
                    cursor.close();
                    return z;
                }
            } catch (Exception e2) {
                b("querySupport, Exception : " + e2.getMessage());
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        String str;
        ProviderInfo resolveContentProvider;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048580, this, context, z)) != null) {
            return invokeLZ.booleanValue;
        }
        if (this.f68633e.isCached() && !z) {
            return this.f68633e.isSupport();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            packageInfo = packageManager.getPackageInfo("com.meizu.safe", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            b("getAppVersion, Exception : " + e2.getMessage());
        }
        if (packageInfo != null) {
            str = packageInfo.versionName;
            if (!this.f68633e.isCached() && this.f68633e.isSameVersion(str)) {
                b("use same version cache, safeVersion : " + str);
                return this.f68633e.isSupport();
            }
            this.f68633e.setVersionName(str);
            resolveContentProvider = packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0);
            boolean z2 = true;
            if ((resolveContentProvider == null && (resolveContentProvider.applicationInfo.flags & 1) != 0 && TextUtils.equals("com.meizu.safe", resolveContentProvider.packageName)) ? false : false) {
                b("is not Supported, for isLegalProvider : false");
                this.f68633e.setSupport(false);
                return false;
            }
            boolean a2 = a(context);
            b("query support, result : " + a2);
            this.f68633e.setSupport(a2);
            return a2;
        }
        str = null;
        if (!this.f68633e.isCached()) {
        }
        this.f68633e.setVersionName(str);
        resolveContentProvider = packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0);
        boolean z22 = true;
        if ((resolveContentProvider == null && (resolveContentProvider.applicationInfo.flags & 1) != 0 && TextUtils.equals("com.meizu.safe", resolveContentProvider.packageName)) ? false : false) {
        }
    }

    public final synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (this.f68634f != null) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                a aVar = new a();
                this.f68634f = aVar;
                context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        }
    }
}
