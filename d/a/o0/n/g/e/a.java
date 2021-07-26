package d.a.o0.n.g.e;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.g.d.c;
import d.a.o0.n.g.d.e;
import d.a.o0.n.h.d;
import d.a.o0.n.h.f;
import d.a.o0.n.h.g;
import d.a.o0.n.h.h;
import d.a.o0.n.h.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f51118b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f51119c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, d.a.o0.n.g.d.a> f51120a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-217344234, "Ld/a/o0/n/g/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-217344234, "Ld/a/o0/n/g/e/a;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this("ai_apps_pms.db", f51119c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f51118b == null) {
                synchronized (a.class) {
                    if (f51118b == null) {
                        f51118b = new a();
                    }
                }
            }
            return f51118b;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConcurrentHashMap<Class<?>, d.a.o0.n.g.d.a> concurrentHashMap = new ConcurrentHashMap<>();
            this.f51120a = concurrentHashMap;
            concurrentHashMap.put(f.class, new e());
            this.f51120a.put(g.class, new d.a.o0.n.g.d.f());
            this.f51120a.put(PMSAppInfo.class, new d.a.o0.n.g.d.b());
            this.f51120a.put(d.class, new d.a.o0.n.g.d.d());
            this.f51120a.put(d.a.o0.n.h.b.class, new c());
            this.f51120a.put(h.class, new d.a.o0.n.g.d.g());
            this.f51120a.put(i.class, new d.a.o0.n.g.d.h());
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f51118b = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            for (d.a.o0.n.g.d.a aVar : this.f51120a.values()) {
                aVar.a(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
            for (d.a.o0.n.g.d.a aVar : this.f51120a.values()) {
                aVar.onUpgrade(sQLiteDatabase, i2, i3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, int i2) {
        super(AppRuntime.getAppContext(), str, null, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
