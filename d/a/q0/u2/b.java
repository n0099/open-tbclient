package d.a.q0.u2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.m;
import d.a.d.e.p.q;
import d.a.p0.s.y.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f64780f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f64781g;

    /* renamed from: h  reason: collision with root package name */
    public static int f64782h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64783a;

    /* renamed from: b  reason: collision with root package name */
    public String f64784b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f64785c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f64786d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.c.g.a f64787e;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64788a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64788a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.f64788a.f64783a) {
                return;
            }
            this.f64788a.f64783a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    f fVar = new f(this.f64788a);
                    fVar.setPriority(4);
                    fVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c(this.f64788a, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* renamed from: d.a.q0.u2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1749b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1749b(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                if (header != null && header.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= header.size()) {
                            break;
                        }
                        if (!TextUtils.isEmpty(header.get(i2)) && header.get(i2).contains("BAIDUID=")) {
                            d.a.p0.m.a.i(header.get(i2));
                            break;
                        }
                        i2++;
                    }
                }
                Map<String, d.a.q0.u2.e.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        b.o(str, moduleInfos.get(str));
                    }
                    return;
                }
                d.a.q0.u2.c.a().e(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, d.a.q0.u2.e.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        b.o(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                d.a.q0.u2.c.a().e(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f64789a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f64790b;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64790b = bVar;
            this.f64789a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            e A;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (TextUtils.isEmpty(modName) || (A = this.f64790b.A(modName)) == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.f64789a = netWork;
                netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.f64789a.addPostData("mod_name", modName);
                this.f64789a.addPostData("status", A.f64798a ? "1" : "2");
                this.f64789a.addPostData("fail_reason", A.f64798a ? "" : A.f64799b);
                this.f64789a.postNetData();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                f fVar = new f(this.f64790b);
                fVar.setPriority(4);
                fVar.execute(new Void[0]);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends BdAsyncTask<Void, Void, h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f64791a;

        /* renamed from: b  reason: collision with root package name */
        public final d.a.q0.u2.e.a f64792b;

        /* renamed from: c  reason: collision with root package name */
        public final String f64793c;

        /* renamed from: d  reason: collision with root package name */
        public final String f64794d;

        /* renamed from: e  reason: collision with root package name */
        public final String f64795e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f64796f;

        /* renamed from: g  reason: collision with root package name */
        public NetWork f64797g;

        public d(String str, d.a.q0.u2.e.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64791a = str;
            this.f64792b = aVar;
            this.f64794d = aVar.c();
            this.f64793c = this.f64792b.a();
            this.f64795e = this.f64792b.b();
            this.f64796f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01b6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            h r;
            HashMap<String, d.a.q0.u2.d.a> hashMap;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b.m(this.f64791a);
                b.q().k(this.f64791a);
                if (this.f64796f) {
                    if (!TextUtils.isEmpty(b.q().s(this.f64791a))) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f64791a).param("obj_id", this.f64794d));
                    }
                    return null;
                }
                NetWork netWork = new NetWork();
                this.f64797g = netWork;
                netWork.setUrl(this.f64793c);
                new File(b.f64781g + "bdtbWCacheTemp/" + this.f64791a + "/").mkdirs();
                String str2 = b.f64781g + "bdtbWCacheTemp/" + this.f64791a + "/bdtbNWCache.zip";
                if (this.f64797g.downloadFile(str2, null, 0, 3, 0, true)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                    try {
                        fileInputStream2 = new FileInputStream(str2);
                        try {
                            try {
                                String b2 = q.b(fileInputStream2);
                                if (StringUtils.isNull(b2) || !b2.toLowerCase().equals(this.f64795e.toLowerCase())) {
                                    b.f64782h = 2;
                                    d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "md5 error");
                                    b.m(this.f64791a);
                                    m.e(fileInputStream2);
                                    return null;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                m.e(fileInputStream2);
                                str = b.f64781g + "bdtbWCacheTemp/" + this.f64791a + "/" + this.f64794d + "/";
                                new File(str).mkdirs();
                                if (!r.b(str2, str)) {
                                }
                                b.m(this.f64791a);
                                r = b.r(this.f64791a, this.f64794d);
                                if (r == null) {
                                }
                                b.f64782h = 5;
                                d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "bundle incomplete");
                                b.q().k(this.f64791a);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            m.e(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        m.e(fileInputStream);
                        throw th;
                    }
                    m.e(fileInputStream2);
                    str = b.f64781g + "bdtbWCacheTemp/" + this.f64791a + "/" + this.f64794d + "/";
                    new File(str).mkdirs();
                    if (!r.b(str2, str)) {
                        String str3 = b.f64781g + "bdtbNWCache/" + this.f64791a + "/" + this.f64794d + "/";
                        new File(str3).mkdirs();
                        if (!FileHelper.CopyDir(str, str3, true)) {
                            b.f64782h = 4;
                            d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "write error");
                        }
                    } else {
                        b.f64782h = 3;
                        d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "unzip error");
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                    b.f64782h = 1;
                    d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "download error");
                }
                b.m(this.f64791a);
                r = b.r(this.f64791a, this.f64794d);
                if (r == null && !TextUtils.isEmpty(r.f64803a) && (hashMap = r.f64804b) != null && hashMap.size() != 0) {
                    b.l(r.f64805c, this.f64791a);
                    return r;
                }
                b.f64782h = 5;
                d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f64791a, "hybridResult", "bundle incomplete");
                b.q().k(this.f64791a);
                return null;
            }
            return (h) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                super.onPostExecute(hVar);
                if (hVar != null) {
                    b.q().z(this.f64791a, hVar.f64805c);
                    b.q().y();
                    d.a.q0.u2.c.a().h(this.f64791a, hVar.f64804b);
                    d.a.q0.u2.c.a().f(true, this.f64791a);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f64791a).param("obj_id", hVar.f64805c));
                    return;
                }
                b.q().j(this.f64791a);
                b.q().y();
                d.a.q0.u2.c.a().d(this.f64791a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64798a;

        /* renamed from: b  reason: collision with root package name */
        public String f64799b;

        public e() {
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
    }

    /* loaded from: classes8.dex */
    public class f extends BdAsyncTask<Void, Void, g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64800a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64800a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            HashMap<String, d.a.q0.u2.d.a> hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                g gVar = new g(null);
                for (String str : b.q().t()) {
                    h r = b.r(str, b.q().s(str));
                    if (r != null && !TextUtils.isEmpty(r.f64803a) && (hashMap = r.f64804b) != null && hashMap.size() != 0) {
                        if (gVar.f64801a == null) {
                            gVar.f64801a = new HashMap();
                        }
                        gVar.f64801a.put(str, r);
                        if (gVar.f64802b == null) {
                            gVar.f64802b = new HashMap<>();
                        }
                        gVar.f64802b.putAll(r.f64804b);
                        b.l(r.f64805c, str);
                    } else {
                        b.f64782h = 5;
                        d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", str, "hybridResult", "bundle incomplete");
                        this.f64800a.k(str);
                    }
                }
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                if (gVar == null) {
                    d.a.p0.s.z.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
                } else {
                    d.a.q0.u2.c.a().g(gVar.f64802b);
                }
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, h> f64801a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.a.q0.u2.d.a> f64802b;

        public g() {
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

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f64803a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.a.q0.u2.d.a> f64804b;

        /* renamed from: c  reason: collision with root package name */
        public String f64805c;

        public h() {
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

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183991200, "Ld/a/q0/u2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(183991200, "Ld/a/q0/u2/b;");
                return;
            }
        }
        r0 = b.class.getSimpleName() + " TestActivity";
        f64781g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        f64782h = 0;
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
                return;
            }
        }
        this.f64783a = false;
        this.f64786d = new a(this, 2001371);
        this.f64787e = new C1749b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public static void l(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = f64781g + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length == 0) {
            return;
        }
        for (String str4 : list) {
            if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
            }
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f64781g + "bdtbWCacheTemp/" + str));
    }

    public static void o(String str, d.a.q0.u2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, aVar) == null) {
            if (aVar != null && !StringUtils.isNull(aVar.c()) && !StringUtils.isNull(aVar.b()) && !StringUtils.isNull(aVar.a())) {
                String s = q().s(str);
                String c2 = aVar.c();
                String a2 = aVar.a();
                boolean d2 = aVar.d();
                if (StringUtils.isNull(s)) {
                    s = "0.0.0.0";
                }
                if (d2 && c2.equals(s)) {
                    d.a.q0.u2.c.a().f(true, str);
                    return;
                }
                d.a.p0.s.z.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", s, "type", "start", "hybridModule", str, "hybridResult", "success");
                new d(str, aVar, true ^ d2).execute(new Void[0]);
                return;
            }
            d.a.q0.u2.c.a().f(true, str);
        }
    }

    public static b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f64780f == null) {
                synchronized (b.class) {
                    if (f64780f == null) {
                        f64780f = new b();
                    }
                }
            }
            return f64780f;
        }
        return (b) invokeV.objValue;
    }

    public static h r(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65550, null, str, str2)) != null) {
            return (h) invokeLL.objValue;
        }
        File file = new File(f64781g + "bdtbNWCache");
        FileInputStream fileInputStream2 = null;
        if (!file.exists() || TextUtils.isEmpty(str2)) {
            return null;
        }
        h hVar = new h(null);
        File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
        hVar.f64803a = file.getAbsolutePath();
        hVar.f64805c = str2;
        File file3 = new File(file2, "router.json");
        try {
            if (file3.exists()) {
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                    hVar.f64804b = x(fileInputStream);
                    m.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    m.e(fileInputStream2);
                    return hVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    m.e(fileInputStream2);
                    throw th;
                }
                return hVar;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static HashMap<String, d.a.q0.u2.d.a> x(InputStream inputStream) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        HashMap<String, d.a.q0.u2.d.a> hashMap;
        StringBuffer stringBuffer;
        InputStreamReader inputStreamReader;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Iterator<String> keys;
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65551, null, inputStream)) != null) {
            return (HashMap) invokeL.objValue;
        }
        InputStreamReader inputStreamReader2 = null;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    hashMap = new HashMap<>();
                    try {
                        stringBuffer = new StringBuffer();
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = null;
                        } catch (JSONException e3) {
                            e = e3;
                            bufferedReader = null;
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (JSONException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Exception e7) {
                        e = e7;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (IOException e8) {
                e = e8;
                hashMap = null;
                bufferedReader = null;
            } catch (JSONException e9) {
                e = e9;
                hashMap = null;
                bufferedReader = null;
            } catch (Exception e10) {
                e = e10;
                hashMap = null;
                bufferedReader = null;
            }
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                jSONObject = new JSONObject(stringBuffer.toString());
            } catch (IOException e11) {
                e = e11;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (JSONException e12) {
                e = e12;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (Exception e13) {
                e = e13;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader2 = inputStreamReader;
                m.g(inputStreamReader2);
                m.g(bufferedReader);
                throw th;
            }
            if (jSONObject.has("config") && (optJSONObject = jSONObject.optJSONObject("config")) != null && (keys = optJSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = optJSONObject.getJSONObject(next);
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (jSONObject3.has("data_urls") && (optJSONArray2 = jSONObject3.optJSONArray("data_urls")) != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            arrayList.add(optJSONArray2.optString(i2));
                        }
                    }
                    String optString = jSONObject3.has("module") ? jSONObject3.optString("module") : "";
                    String optString2 = jSONObject3.has("path") ? jSONObject3.optString("path") : "";
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    if (!jSONObject3.has("source") || (optJSONArray = jSONObject3.optJSONArray("source")) == null) {
                        jSONObject2 = optJSONObject;
                    } else {
                        jSONObject2 = optJSONObject;
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            arrayList2.add(optJSONArray.optString(i3));
                        }
                    }
                    d.a.q0.u2.d.a aVar = new d.a.q0.u2.d.a();
                    aVar.f64808a = arrayList;
                    aVar.f64809b = optString;
                    aVar.f64810c = optString2;
                    aVar.f64811d = arrayList2;
                    hashMap.put(next, aVar);
                    optJSONObject = jSONObject2;
                }
                m.g(inputStreamReader);
                m.g(bufferedReader);
                return hashMap;
            }
            m.g(inputStreamReader);
            m.g(bufferedReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final e A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            e eVar = new e();
            if (TextUtils.isEmpty(str)) {
                eVar.f64799b = "module not exit";
                return eVar;
            }
            File file = new File(f64781g + "bdtbNWCache", str);
            String s = q().s(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                eVar.f64798a = false;
                if (!file.exists()) {
                    eVar.f64799b = "bundle not exist";
                    return eVar;
                } else if (TextUtils.isEmpty(s)) {
                    eVar.f64799b = "the local has no valid version name";
                    return eVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + s + "/";
                    if (!new File(str2).exists()) {
                        eVar.f64799b = "bundle not exist";
                        return eVar;
                    }
                    String str3 = file.getAbsolutePath() + "/" + s + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (r.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", s);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        v(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
                        if (!eVar.f64798a) {
                            return eVar;
                        }
                    } else {
                        eVar.f64799b = "zip bundle error";
                        return eVar;
                    }
                }
            } else {
                eVar.f64798a = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                k(str);
                if (!TextUtils.isEmpty(s)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", s));
                }
                if (!file.exists() || StringUtils.isNull(s) || !new File(file.getAbsolutePath(), s).exists()) {
                    return eVar;
                }
                eVar.f64799b = "delete fail";
                eVar.f64798a = false;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public JSONObject B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.f64785c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f64785c);
        }
        return (JSONObject) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map<String, String> map = this.f64785c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            return new JSONObject(this.f64785c).toString();
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            d.a.p0.s.d0.b.j().x("pref_key_quick_webview_versions", "");
            String str = f64781g + "bdtbNWCache";
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length == 0) {
                return;
            }
            for (String str2 : list) {
                if (!StringUtils.isNull(str2)) {
                    FileHelper.deleteFileOrDir(new File(str + "/" + str2));
                }
            }
        }
    }

    public void j(String str) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (map = this.f64785c) == null) {
            return;
        }
        map.remove(str);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        j(str);
        d.a.p0.s.d0.b.j().x("pref_key_quick_webview_versions", C());
        File file = new File(f64781g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f64785c == null) {
                this.f64785c = new ConcurrentHashMap();
            }
            this.f64785c.clear();
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64784b : (String) invokeV.objValue;
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.f64785c == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f64785c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f64785c == null) {
                this.f64785c = new ConcurrentHashMap();
            }
            return this.f64785c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            System.currentTimeMillis();
            MessageManager.getInstance().registerListener(this.f64787e);
            MessageManager.getInstance().registerListener(this.f64786d);
            this.f64784b = new File(f64781g + "bdtbNWCache").getAbsolutePath();
            w(d.a.p0.s.d0.b.j().p("pref_key_quick_webview_versions", ""));
        }
    }

    public final e v(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            if (StringUtils.isNull(str)) {
                eVar.f64799b = "serve return is null";
                return eVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.f64798a = jSONObject.optInt("error_code") == 0;
                eVar.f64799b = jSONObject.optString("error_msg");
            } catch (JSONException e2) {
                eVar.f64799b = "parse json exception";
                BdLog.e(e2);
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    if (this.f64785c == null) {
                        this.f64785c = new ConcurrentHashMap();
                    }
                    this.f64785c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String C = C();
            if (TextUtils.isEmpty(C)) {
                return;
            }
            d.a.p0.s.d0.b.j().x("pref_key_quick_webview_versions", C);
        }
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f64785c == null) {
            this.f64785c = new ConcurrentHashMap();
        }
        this.f64785c.put(str, str2);
    }
}
