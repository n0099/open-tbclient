package d.a.r0.s.j;

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
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f56636a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f56637b;

    /* renamed from: c  reason: collision with root package name */
    public c f56638c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56639d;

    /* renamed from: d.a.r0.s.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1279a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f56640a;

        /* renamed from: b  reason: collision with root package name */
        public volatile NetWork f56641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f56642c;

        /* renamed from: d.a.r0.s.j.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1280a implements Comparator<Map.Entry<String, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1280a(c cVar) {
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
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) ? (int) (d.a.c.e.m.b.d(String.valueOf(entry.getValue()), 0) - d.a.c.e.m.b.d(String.valueOf(entry2.getValue()), 0)) : invokeLL.intValue;
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
            this.f56642c = aVar;
            this.f56640a = null;
            this.f56641b = null;
            this.f56640a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    this.f56641b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_IP_LIST);
                    String postNetData = this.f56641b.postNetData();
                    if (!this.f56641b.getNetContext().getResponse().isRequestSuccess() || postNetData == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(postNetData);
                    if (jSONObject.optInt("error_code") == 0) {
                        String optString = jSONObject.optString("urls");
                        this.f56642c.f56637b = this.f56642c.j(optString);
                        if (this.f56642c.f56637b == null || this.f56642c.f56637b.size() <= 0) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        int i2 = 0;
                        for (int i3 = 0; i3 < this.f56642c.f56637b.size(); i3++) {
                            String str = (String) this.f56642c.f56637b.get(i3);
                            f fVar = new f();
                            fVar.a(str);
                            if (fVar.d()) {
                                hashMap.put(str, Integer.valueOf(fVar.b()));
                            }
                        }
                        if (hashMap.size() > 0) {
                            this.f56642c.f56637b = new ArrayList();
                            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
                            Collections.sort(arrayList, new C1280a(this));
                            StringBuilder sb = new StringBuilder(50);
                            for (Map.Entry entry : arrayList) {
                                this.f56642c.f56637b.add(entry.getKey());
                                if (i2 != 0) {
                                    sb.append(",");
                                }
                                i2++;
                                sb.append((String) entry.getKey());
                            }
                            optString = sb.toString();
                        }
                        d.a.r0.r.d0.b.j().w("KeyOfSharedPrefListGetTime", System.currentTimeMillis());
                        d.a.r0.r.d0.b.j().x("KeyOfSharedPrefIpList", optString);
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
                this.f56642c.f56638c = null;
                b bVar = this.f56640a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f56641b != null) {
                    this.f56641b.cancelNetConnect();
                    this.f56641b = null;
                }
                this.f56642c.f56638c = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.f56642c.f56638c = null;
                b bVar = this.f56640a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f56642c.f56638c = null;
                b bVar = this.f56640a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f56643a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1103356121, "Ld/a/r0/s/j/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1103356121, "Ld/a/r0/s/j/a$d;");
                    return;
                }
            }
            f56643a = new a(null);
        }
    }

    public /* synthetic */ a(C1279a c1279a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.f56643a : (a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.r0.r.d0.b.j().k("KeyOfSharedPrefImCount", 0) : invokeV.intValue;
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f56637b == null) {
                if (System.currentTimeMillis() - d.a.r0.r.d0.b.j().l("KeyOfSharedPrefListGetTime", 0L) > 86400000) {
                    d.a.r0.r.d0.b.j().x("KeyOfSharedPrefIpList", "");
                    return null;
                }
                this.f56637b = j(d.a.r0.r.d0.b.j().p("KeyOfSharedPrefIpList", null));
            }
            return this.f56637b;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int e2 = e();
            if (e2 >= 10) {
                d.a.r0.r.d0.b.j().v("KeyOfSharedPrefImCount", 0);
                d.a.r0.r.d0.b.j().x("KeyOfSharedPrefValidIp", "");
                this.f56636a = null;
                return null;
            }
            if (this.f56636a == null) {
                this.f56636a = d.a.r0.r.d0.b.j().p("KeyOfSharedPrefValidIp", null);
            }
            if (!k.isEmpty(this.f56636a)) {
                d.a.r0.r.d0.b.j().v("KeyOfSharedPrefImCount", e2 + 1);
            } else {
                this.f56636a = null;
            }
            return this.f56636a;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56639d : invokeV.booleanValue;
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
            this.f56639d = false;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TiebaIMConfig.defaultUrl.equals(str)) {
            return;
        }
        this.f56636a = str;
        d.a.r0.r.d0.b.j().x("KeyOfSharedPrefValidIp", str);
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.f56638c == null) {
            this.f56639d = true;
            c cVar = new c(this, bVar);
            this.f56638c = cVar;
            cVar.setSelfExecute(true);
            this.f56638c.execute(new Object[0]);
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
        this.f56636a = null;
        this.f56637b = null;
        this.f56638c = null;
        this.f56639d = false;
        this.f56639d = false;
        this.f56637b = null;
    }
}
