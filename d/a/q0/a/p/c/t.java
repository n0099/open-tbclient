package d.a.q0.a.p.c;

import android.content.Context;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes8.dex */
public class t implements d.a.q0.a.p.d.l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f49902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f49903f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49904g;

        /* renamed from: d.a.q0.a.p.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0906a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f49905e;

            /* renamed from: d.a.q0.a.p.c.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0907a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0906a f49906e;

                public RunnableC0907a(RunnableC0906a runnableC0906a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0906a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49906e = runnableC0906a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f49906e.f49905e;
                        d.a.q0.a.v2.i0.a(aVar.f49904g, aVar.f49903f);
                    }
                }
            }

            public RunnableC0906a(a aVar) {
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
                this.f49905e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        PrintWriter printWriter = new PrintWriter(this.f49905e.f49903f);
                        printWriter.println(d.a.q0.a.v2.k.g(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                        printWriter.println(this.f49905e.f49902e.toString());
                        printWriter.flush();
                        printWriter.close();
                        q0.X(new RunnableC0907a(this));
                    } catch (FileNotFoundException e2) {
                        d.a.q0.a.e0.d.a("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        d.a.q0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f49905e.f49904g.getString(d.a.q0.a.h.swan_app_system_error)).F();
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
            this.f49902e = sb;
            this.f49903f = file;
            this.f49904g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49902e.append(str);
                d.a.q0.a.v2.q.j(new RunnableC0906a(this), "");
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

    @Override // d.a.q0.a.p.d.l0
    public void a(Context context) {
        File K2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null || (K2 = d.a.q0.a.h0.g.i.K2()) == null) {
            return;
        }
        if (K2.exists() || K2.mkdirs()) {
            File file = new File(K2, "runninginfo_" + d.a.q0.a.v2.k.g(System.currentTimeMillis(), "yyyyMMdd") + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.q0.a.v2.p.h(context));
            sb.append("===== 启动信息 =====");
            sb.append("\n");
            d.a.q0.a.v2.p.g(context, new a(this, sb, file, context));
        }
    }
}
