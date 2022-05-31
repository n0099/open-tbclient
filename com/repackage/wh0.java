package com.repackage;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wh0 implements zh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy0 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ wh0 b;

        public a(wh0 wh0Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh0Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wh0Var;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.a.entrySet()) {
                        ei0 ei0Var = (ei0) entry.getValue();
                        if (ei0Var != null) {
                            px0 a = xh0.a(ei0Var);
                            if (!TextUtils.isEmpty(a.c())) {
                                this.b.a.a(a, new by0[0]);
                            }
                        }
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px0 a;
        public final /* synthetic */ wh0 b;

        public b(wh0 wh0Var, px0 px0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh0Var, px0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wh0Var;
            this.a = px0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.a(this.a, new by0[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px0 a;
        public final /* synthetic */ wh0 b;

        public c(wh0 wh0Var, px0 px0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh0Var, px0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wh0Var;
            this.a = px0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.update(this.a, new by0[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public d(wh0 wh0Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wh0Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    if (!oe0.a) {
                        Log.d("AdDownloadDBHelper", "wrapExecutor", th);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static zh0 a;
        public static final zh0 b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements zh0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            public a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = th;
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("v", "5.2.0.21");
                    hashMap.put("e", this.a.toString());
                    rx0.c(new ClogBuilder().w(ClogBuilder.LogType.CHECK).i("12").j("4000").k(new JSONObject(hashMap).toString()));
                }
            }

            @Override // com.repackage.zh0
            public void a(HashMap<String, ei0> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                }
            }

            @Override // com.repackage.zh0
            public void b(px0 px0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, px0Var) == null) {
                }
            }

            public void update(px0 px0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, px0Var) == null) {
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(100795313, "Lcom/repackage/wh0$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(100795313, "Lcom/repackage/wh0$e;");
                    return;
                }
            }
            try {
                if (g01.b()) {
                    a = new wh0(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            b = a;
        }

        public static zh0 b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? new a(th) : (zh0) invokeL.objValue;
        }
    }

    public /* synthetic */ wh0(vh0 vh0Var) {
        this();
    }

    public static zh0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e.b : (zh0) invokeV.objValue;
    }

    @Override // com.repackage.zh0
    public void a(HashMap<String, ei0> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || ix0.c(hashMap)) {
            return;
        }
        e(new a(this, hashMap), "update_apk_data", 3);
    }

    @Override // com.repackage.zh0
    public void b(px0 px0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, px0Var) == null) || TextUtils.isEmpty(px0Var.c())) {
            return;
        }
        e(new b(this, px0Var), "update_apk_data", 3);
    }

    public final void e(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, runnable, str, i) == null) {
            py0.c(new d(this, runnable), str, i);
        }
    }

    public void update(px0 px0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, px0Var) == null) || TextUtils.isEmpty(px0Var.c())) {
            return;
        }
        e(new c(this, px0Var), "update_apk_data", 3);
    }

    public wh0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        yh0 yh0Var = new yh0();
        yh0Var.getReadableDatabase();
        yh0Var.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(xg0.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new ai0(openDatabase);
    }
}
