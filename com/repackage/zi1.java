package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
public class zi1 implements hl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: com.repackage.zi1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0569a implements cf3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            /* renamed from: com.repackage.zi1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0570a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ File a;
                public final /* synthetic */ C0569a b;

                public RunnableC0570a(C0569a c0569a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0569a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0569a;
                    this.a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        vd3.a(this.b.c.a, this.a);
                    }
                }
            }

            public C0569a(a aVar, File file, String str) {
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
            @Override // com.repackage.cf3
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    try {
                        File file = new File(this.a, "report");
                        ng4.l(file);
                        zi1.e(file, this.b, str);
                        zi1.d(file);
                        File file2 = new File(this.a, "report.zip");
                        ng4.j(file2);
                        ng4.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        ng4.L(file);
                        de3.a0(new RunnableC0570a(this, file2));
                    } catch (Exception e) {
                        jx1.b("DefaultSwanAppLogManager", Log.getStackTraceString(e));
                        b03.g(AppRuntime.getAppContext(), this.c.a.getString(R.string.obfuscated_res_0x7f0f123b)).G();
                    }
                }
            }
        }

        public a(zi1 zi1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi1Var, context};
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
                File W2 = uz1.W2();
                if (W2 == null) {
                    jx1.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!W2.exists() && !W2.mkdirs()) {
                    jx1.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + W2.getAbsolutePath());
                } else {
                    cd3.i(this.a, new C0569a(this, W2, cd3.l(this.a) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public zi1() {
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
            ng4.e(qj2.p0().a(), file2);
            for (File file3 : ng4.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : ng4.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            ng4.L(file4);
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
            String g = xc3.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            String g2 = xc3.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g2 + "\n" + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override // com.repackage.hl1
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        dd3.k(new a(this, context), "log上报");
    }
}
