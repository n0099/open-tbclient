package com.repackage;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r62 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final Uri c;
    public transient /* synthetic */ FieldHolder $fh;
    public UriMatcher a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398461, "Lcom/repackage/r62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398461, "Lcom/repackage/r62;");
                return;
            }
        }
        b = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
        c = Uri.parse("content://" + b);
    }

    public r62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.a = uriMatcher;
        uriMatcher.addURI(b, "favorite", 0);
        this.a.addURI(b, "favorite_and_aps", 1);
        this.a.addURI(b, "history", 2);
        this.a.addURI(b, "history_with_app", 3);
        this.a.addURI(b, "favorite_with_aps_pms", 4);
        this.a.addURI(b, "history_with_aps_pms", 5);
        this.a.addURI(b, "user_behavior", 6);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            AppRuntime.getAppContext().getContentResolver().notifyChange(u62.b(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(u62.c(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(u62.a(), (ContentObserver) null, false);
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i != 6) {
                if (cg1.a) {
                    throw new NullPointerException("tableName must not Null");
                }
                return "";
            }
            return "user_behavior";
        }
        return (String) invokeI.objValue;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        SQLiteDatabase e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            int match = this.a.match(uri);
            if (match != 0) {
                if (match != 2) {
                    if (match == 6 && (e = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                        return e.delete(a(match), str, strArr);
                    }
                    return 0;
                }
                int c2 = SwanAppDbControl.f(AppRuntime.getAppContext()).c(str, strArr);
                if (c2 > 0) {
                    b();
                }
                return c2;
            }
            return SwanAppDbControl.f(AppRuntime.getAppContext()).b(str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        SQLiteDatabase e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            int match = this.a.match(uri);
            if (match == 0) {
                long i = SwanAppDbControl.f(AppRuntime.getAppContext()).i(contentValues);
                if (i < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(c.buildUpon().build(), i);
            } else if (match != 2) {
                if (match == 6 && (e = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                    e.insertWithOnConflict(a(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            } else {
                long j = SwanAppDbControl.f(AppRuntime.getAppContext()).j(contentValues);
                if (j < 0) {
                    return null;
                }
                b();
                return ContentUris.withAppendedId(c.buildUpon().build(), j);
            }
        }
        return (Uri) invokeLL.objValue;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            int match = this.a.match(uri);
            switch (match) {
                case 0:
                    Cursor l = SwanAppDbControl.f(AppRuntime.getAppContext()).l(strArr, str, strArr2, str2);
                    l.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return l;
                case 1:
                    Cursor k = SwanAppDbControl.f(AppRuntime.getAppContext()).k(strArr, str, strArr2, str2);
                    k.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return k;
                case 2:
                    Cursor n = SwanAppDbControl.f(AppRuntime.getAppContext()).n(strArr, str, strArr2, str2);
                    n.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return n;
                case 3:
                    Cursor m = SwanAppDbControl.f(AppRuntime.getAppContext()).m(strArr, str, strArr2, str2);
                    m.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return m;
                case 4:
                    Cursor s = q62.s();
                    s.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return s;
                case 5:
                    int i = -1;
                    try {
                        i = Integer.valueOf(uri.getQueryParameter("query_limit")).intValue();
                    } catch (Exception e) {
                        if (cg1.a) {
                            e.printStackTrace();
                        }
                    }
                    String queryParameter = uri.getQueryParameter("query_word");
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Cursor o = v62.o(queryParameter, i);
                    o.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                    return o;
                case 6:
                    SQLiteDatabase e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e();
                    if (e2 != null) {
                        return e2.query(a(match), strArr, str, strArr2, null, null, str2);
                    }
                    return null;
                default:
                    return null;
            }
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        SQLiteDatabase e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            int match = this.a.match(uri);
            if (match != 0) {
                if (match != 2) {
                    if (match == 6 && (e = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                        return e.update(a(match), contentValues, str, strArr);
                    }
                    return 0;
                }
                int r = SwanAppDbControl.f(AppRuntime.getAppContext()).r(contentValues, str, strArr);
                if (r > 0) {
                    b();
                }
                return r;
            }
            return SwanAppDbControl.f(AppRuntime.getAppContext()).q(contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
