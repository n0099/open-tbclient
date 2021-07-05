package d.a.d0.g.a;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45260b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f45261a;

    /* renamed from: d.a.d0.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0613a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f45262b;

        public C0613a(a aVar, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45262b = contentValues;
        }

        @Override // d.a.d0.g.a.d
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                BundleInfo bundleInfo = BundleInfo.toBundleInfo(this.f45262b);
                if (bundleInfo == null) {
                    return false;
                }
                Cursor query = sQLiteDatabase.query("bundleinfo", null, "pkg_name =? ", new String[]{bundleInfo.getPackageName()}, null, null, null);
                List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
                try {
                    query.close();
                } catch (Exception unused) {
                }
                if (bundleInfoList.isEmpty()) {
                    sQLiteDatabase.insert("bundleinfo", null, this.f45262b);
                    return true;
                }
                HashMap hashMap = new HashMap();
                for (BundleInfo bundleInfo2 : bundleInfoList) {
                    if (bundleInfo2 != null) {
                        hashMap.put(Integer.valueOf(bundleInfo2.getType()), bundleInfo2);
                    }
                }
                BundleInfo bundleInfo3 = (BundleInfo) hashMap.get(3);
                BundleInfo bundleInfo4 = (BundleInfo) hashMap.get(2);
                BundleInfo bundleInfo5 = (BundleInfo) hashMap.get(1);
                if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() > bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo3);
                }
                if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() > bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo4);
                }
                if (bundleInfo5 != null && bundleInfo5.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo5.getUpdateV() > bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo4);
                }
                int type = bundleInfo.getType();
                if (type != 1) {
                    if (type != 2) {
                        if (type == 3) {
                            if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                                hashMap.put(3, bundleInfo);
                            }
                            if (bundleInfo4 != null && bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                                hashMap.remove(2);
                            }
                            if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                                hashMap.remove(1);
                            }
                        }
                    } else if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                        if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                            BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                        } else {
                            if (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                                hashMap.put(2, bundleInfo);
                            }
                            if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                                hashMap.remove(1);
                            }
                        }
                    }
                } else if ((bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) && (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode())) {
                    if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                        BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                    } else if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() <= bundleInfo.getUpdateV()) {
                        BundleInfo.updateBundleInfoConfig(bundleInfo4, bundleInfo);
                    } else if (bundleInfo5 == null || bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                        hashMap.put(1, bundleInfo);
                    }
                }
                sQLiteDatabase.delete("bundleinfo", "pkg_name =? ", new String[]{this.f45262b.getAsString(EmotionResourceInfo.JSON_KEY_PKG_NAME)});
                for (BundleInfo bundleInfo6 : hashMap.values()) {
                    sQLiteDatabase.insert("bundleinfo", null, BundleInfo.toContentValues(bundleInfo6));
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1266272754, "Ld/a/d0/g/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1266272754, "Ld/a/d0/g/a/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45261a = null;
        this.f45261a = new c(context);
    }

    public static a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f45260b == null) {
                synchronized (a.class) {
                    if (f45260b == null) {
                        Application applicationContext = ContextHolder.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        f45260b = new a(context);
                    }
                }
            }
            return f45260b;
        }
        return (a) invokeL.objValue;
    }

    public int a(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f45261a.getWritableDatabase().delete("bundleinfo", "abi <>? AND abi <> 3", new String[]{String.valueOf(f.a())});
            return 0;
        }
        return invokeV.intValue;
    }

    public Cursor d(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) ? this.f45261a.getReadableDatabase().query("bundleinfo", null, str, strArr2, null, null, null) : (Cursor) invokeLLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (d.a.d0.i.b.a() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (d.a.d0.i.b.a() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<BundleInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Cursor query = this.f45261a.getReadableDatabase().query("bundleinfo", null, "", null, null, null, null);
            List<BundleInfo> arrayList = new ArrayList<>();
            try {
                try {
                    arrayList = BundleInfo.toBundleInfoList(query);
                    try {
                        query.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    if (d.a.d0.i.b.a()) {
                        e3.printStackTrace();
                    }
                    try {
                        query.close();
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception e5) {
                    if (d.a.d0.i.b.a()) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public Cursor f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? d(null, null, "pkg_name =? AND type = ? AND broken = ? ", new String[]{str, String.valueOf(i2), "0"}, null) : (Cursor) invokeLI.objValue;
    }

    public Cursor g(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, str, i2, i3)) == null) ? d(null, null, "pkg_name =? AND type = ? AND version_code >= ? AND broken = ? ", new String[]{str, String.valueOf(i3), String.valueOf(i2), "0"}, null) : (Cursor) invokeLII.objValue;
    }

    public final boolean h(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
            dVar.c(this.f45261a.getWritableDatabase());
            return dVar.a();
        }
        return invokeL.booleanValue;
    }

    public int i(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            h(new C0613a(this, contentValues));
            return 1;
        }
        return invokeLLLL.intValue;
    }
}
