package d.a.p0.h0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f56686a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.p0.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1396b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f56687d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Process f56688a;

        /* renamed from: b  reason: collision with root package name */
        public String f56689b;

        /* renamed from: c  reason: collision with root package name */
        public long f56690c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2086493000, "Ld/a/p0/h0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2086493000, "Ld/a/p0/h0/b$b;");
                    return;
                }
            }
            f56687d = BdUniqueId.gen();
        }

        public /* synthetic */ C1396b(String str, a aVar) {
            this(str);
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int I = j.I();
                return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                Process process = this.f56688a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                d.a.p0.h0.i.d.m().n(this.f56689b, (int) this.f56690c, false);
            }
        }

        public C1396b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f56688a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f56687d));
            this.f56689b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Process exec = runtime.exec(b() + this.f56689b);
                            this.f56688a = exec;
                            r1 = exec.waitFor() == 0;
                            this.f56690c = System.currentTimeMillis() - currentTimeMillis;
                        } catch (InterruptedException e2) {
                            BdLog.detailException(e2);
                            d.c().a("test_speed", e2.getMessage());
                        }
                    } catch (IOException e3) {
                        BdLog.detailException(e3);
                        d.c().a("test_speed", e3.getMessage());
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                        d.c().a("test_speed", th.getMessage());
                    }
                    this.f56688a.destroy();
                    return Boolean.valueOf(r1);
                } catch (Throwable th2) {
                    this.f56688a.destroy();
                    throw th2;
                }
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bool) == null) {
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                d.a.p0.h0.i.d.m().n(this.f56689b, (int) this.f56690c, booleanValue);
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_testspeed");
                statsItem.c("issuc", Boolean.valueOf(booleanValue));
                statsItem.b("ip", this.f56689b);
                statsItem.c("speed", Integer.valueOf((int) this.f56690c));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1570884490, "Ld/a/p0/h0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1570884490, "Ld/a/p0/h0/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f56686a == null) {
                synchronized (b.class) {
                    if (f56686a == null) {
                        f56686a = new b();
                    }
                }
            }
            return f56686a;
        }
        return (b) invokeV.objValue;
    }

    public void b(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, set) == null) {
            for (String str : set) {
                new C1396b(str, null).execute(new String[0]);
            }
        }
    }
}
