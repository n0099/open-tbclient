package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes7.dex */
public class xi1 implements fl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: com.repackage.xi1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0772a implements af3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            /* renamed from: com.repackage.xi1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0773a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ File a;
                public final /* synthetic */ C0772a b;

                public RunnableC0773a(C0772a c0772a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0772a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0772a;
                    this.a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        td3.a(this.b.c.a, this.a);
                    }
                }
            }

            public C0772a(a aVar, File file, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, file, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = file;
                this.b = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    try {
                        File file = new File(this.a, "report");
                        jg4.l(file);
                        xi1.e(file, this.b, str);
                        xi1.d(file);
                        File file2 = new File(this.a, "report.zip");
                        jg4.j(file2);
                        jg4.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        jg4.L(file);
                        be3.a0(new RunnableC0773a(this, file2));
                    } catch (Exception e) {
                        hx1.b("DefaultSwanAppLogManager", Log.getStackTraceString(e));
                        zz2.g(AppRuntime.getAppContext(), this.c.a.getString(R.string.obfuscated_res_0x7f0f1273)).G();
                    }
                }
            }
        }

        public a(xi1 xi1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File X2 = sz1.X2();
                if (X2 == null) {
                    hx1.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!X2.exists() && !X2.mkdirs()) {
                    hx1.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + X2.getAbsolutePath());
                } else {
                    ad3.i(this.a, new C0772a(this, X2, ad3.l(this.a) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public xi1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d(File file) {
        File[] C;
        File[] C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            File file2 = new File(file, "swan");
            jg4.e(oj2.p0().a(), file2);
            for (File file3 : jg4.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : jg4.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            jg4.L(file4);
                        }
                    }
                }
            }
        }
    }

    public static void e(File file, String str, String str2) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str, str2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = vc3.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            String g2 = vc3.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g2 + "\n" + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override // com.repackage.fl1
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        bd3.k(new a(this, context), "log上报");
    }
}
