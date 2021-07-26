package d.a.o0.a.p.c;

import android.content.Context;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes7.dex */
public class t implements d.a.o0.a.p.d.l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f47104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f47105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47106g;

        /* renamed from: d.a.o0.a.p.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0864a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f47107e;

            /* renamed from: d.a.o0.a.p.c.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0865a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0864a f47108e;

                public RunnableC0865a(RunnableC0864a runnableC0864a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0864a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f47108e = runnableC0864a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f47108e.f47107e;
                        d.a.o0.a.v2.i0.a(aVar.f47106g, aVar.f47105f);
                    }
                }
            }

            public RunnableC0864a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47107e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        PrintWriter printWriter = new PrintWriter(this.f47107e.f47105f);
                        printWriter.println(d.a.o0.a.v2.k.g(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                        printWriter.println(this.f47107e.f47104e.toString());
                        printWriter.flush();
                        printWriter.close();
                        q0.X(new RunnableC0865a(this));
                    } catch (FileNotFoundException e2) {
                        d.a.o0.a.e0.d.a("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f47107e.f47106g.getString(d.a.o0.a.h.swan_app_system_error)).F();
                    }
                }
            }
        }

        public a(t tVar, StringBuilder sb, File file, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, sb, file, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47104e = sb;
            this.f47105f = file;
            this.f47106g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f47104e.append(str);
                d.a.o0.a.v2.q.j(new RunnableC0864a(this), "");
            }
        }
    }

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.o0.a.p.d.l0
    public void a(Context context) {
        File K2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null || (K2 = d.a.o0.a.h0.g.i.K2()) == null) {
            return;
        }
        if (K2.exists() || K2.mkdirs()) {
            File file = new File(K2, "runninginfo_" + d.a.o0.a.v2.k.g(System.currentTimeMillis(), "yyyyMMdd") + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.o0.a.v2.p.h(context));
            sb.append("===== 启动信息 =====");
            sb.append("\n");
            d.a.o0.a.v2.p.g(context, new a(this, sb, file, context));
        }
    }
}
