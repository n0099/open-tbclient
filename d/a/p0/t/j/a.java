package d.a.p0.t.j;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54030a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f54031b;

    /* renamed from: c  reason: collision with root package name */
    public c f54032c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54033d;

    /* renamed from: d.a.p0.t.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1240a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f54034a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f54035b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f54036c;

        /* renamed from: d.a.p0.t.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1241a implements Comparator<Map.Entry<String, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1241a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? (int) (d.a.d.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.a.d.e.m.b.d(String.valueOf(entry2.getValue()), 0)) : invokeLL.intValue;
            }
        }

        public c(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54036c = aVar;
            this.f54034a = null;
            this.f54035b = null;
            this.f54034a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.f54035b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                    String postNetData = this.f54035b.postNetData();
                    if (!this.f54035b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        this.f54036c.f54031b = this.f54036c.j(optString);
                        if (this.f54036c.f54031b == null || this.f54036c.f54031b.size() <= 0) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        int i2 = 0;
                        for (int i3 = 0; i3 < this.f54036c.f54031b.size(); i3++) {
                            String str = (String) this.f54036c.f54031b.get(i3);
                            f fVar = new f();
                            fVar.a(str);
                            if (fVar.d()) {
                                hashMap.put(str, Integer.valueOf(fVar.b()));
                            }
                        }
                        if (hashMap.size() > 0) {
                            this.f54036c.f54031b = new ArrayList();
                            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                            Collections.sort(arrayList, new C1241a(this));
                            StringBuilder sb = new StringBuilder(50);
                            for (Map.Entry entry : arrayList) {
                                this.f54036c.f54031b.add(entry.getKey());
                                if (i2 != 0) {
                                    sb.append(",");
                                }
                                i2++;
                                sb.append((String) entry.getKey());
                            }
                            optString = sb.toString();
                        }
                        d.a.p0.s.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                        d.a.p0.s.d0.b.j().x("KeyOfSharedPrefIpList", optString);
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onCancelled(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.f54036c.f54032c = null;
                b bVar = this.f54034a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f54035b != null) {
                    this.f54035b.cancelNetConnect();
                    this.f54035b = null;
                }
                this.f54036c.f54032c = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.f54036c.f54032c = null;
                b bVar = this.f54034a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f54036c.f54032c = null;
                b bVar = this.f54034a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f54037a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-61610364, "Ld/a/p0/t/j/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-61610364, "Ld/a/p0/t/j/a$d;");
                    return;
                }
            }
            f54037a = new a(null);
        }
    }

    public /* synthetic */ a(C1240a c1240a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f54037a : (a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.p0.s.d0.b.j().k("KeyOfSharedPrefImCount", 0) : invokeV.intValue;
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f54031b == null) {
                if (System.currentTimeMillis() - d.a.p0.s.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                    d.a.p0.s.d0.b.j().x("KeyOfSharedPrefIpList", "");
                    return null;
                }
                this.f54031b = j(d.a.p0.s.d0.b.j().p("KeyOfSharedPrefIpList", null));
            }
            return this.f54031b;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int e2 = e();
            if (e2 >= 10) {
                d.a.p0.s.d0.b.j().v("KeyOfSharedPrefImCount", 0);
                d.a.p0.s.d0.b.j().x("KeyOfSharedPrefValidIp", "");
                this.f54030a = null;
                return null;
            }
            if (this.f54030a == null) {
                this.f54030a = d.a.p0.s.d0.b.j().p("KeyOfSharedPrefValidIp", null);
            }
            if (!k.isEmpty(this.f54030a)) {
                d.a.p0.s.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
            } else {
                this.f54030a = null;
            }
            return this.f54030a;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54033d : invokeV.booleanValue;
    }

    public final List<String> j(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null || str.length() <= 0 || (split = str.split(",")) == null || split.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f54033d = false;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f54030a = str;
        d.a.p0.s.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.f54032c == null) {
            this.f54033d = true;
            c cVar = new c(this, bVar);
            this.f54032c = cVar;
            cVar.setSelfExecute(true);
            this.f54032c.execute(new Object[0]);
        }
    }

    public a() {
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
        this.f54030a = null;
        this.f54031b = null;
        this.f54032c = null;
        this.f54033d = false;
        this.f54033d = false;
        this.f54031b = null;
    }
}
