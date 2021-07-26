package d.a.p0.q0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
import d.a.d.e.p.f;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class d implements d.a.d.h.j.f.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f52897c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.h.j.f.a f52898a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52899b;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f52900a;

        public a(d dVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52900a = null;
            this.f52900a = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voidArr)) == null) {
                File file = this.f52900a;
                if (file == null || !file.exists()) {
                    return null;
                }
                Util.a(this.f52900a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f52901a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.d.h.j.f.c f52902b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52903c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f52904d;

        public b(d dVar, d.a.d.h.j.f.c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52904d = dVar;
            this.f52903c = false;
            this.f52902b = cVar;
            this.f52903c = z;
        }

        public final String b(l<String> lVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lVar, str)) == null) ? lVar.get(str) : (String) invokeLL.objValue;
        }

        public final String c(l<String> lVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, str)) == null) {
                boolean checkNewUser = TbadkCoreApplication.getInst().checkNewUser();
                if (TbadkCoreApplication.getInst().checkInterrupt() && checkNewUser) {
                    return null;
                }
                NetWork netWork = new NetWork(d.f52897c);
                this.f52901a = netWork;
                netWork.addPostData("plugin_upload_config", str);
                return this.f52901a.postNetData();
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                this.f52904d.f52899b = false;
                this.f52901a.cancelNetConnect();
                this.f52901a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pluginNetConfigInfosArr) == null) {
                super.onProgressUpdate(pluginNetConfigInfosArr);
                this.f52904d.f52899b = false;
                boolean z = pluginNetConfigInfosArr[0] != null;
                String str = null;
                NetWork netWork = this.f52901a;
                if (netWork != null && !netWork.isNetSuccess()) {
                    str = this.f52901a.getNetException();
                    if (this.f52901a.getServerErrorCode() != 0) {
                        str = str + "-" + this.f52901a.getErrorString();
                    }
                }
                this.f52904d.f52898a.a(z, this.f52902b, pluginNetConfigInfosArr[0], str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001224));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            String str;
            boolean z;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voidArr)) == null) {
                d.a.d.h.j.f.c cVar = this.f52902b;
                if (cVar == null) {
                    publishProgress(null);
                    return null;
                }
                if (cVar.a() == null || this.f52902b.a().size() <= 0) {
                    str = "";
                } else {
                    StringBuilder sb = new StringBuilder(50);
                    int size = this.f52902b.a().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != 0) {
                            sb.append(",");
                        }
                        BasicNameValuePair basicNameValuePair = this.f52902b.a().get(i2);
                        if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                            sb.append(basicNameValuePair.getName());
                            sb.append(":");
                            sb.append(basicNameValuePair.getValue());
                        }
                    }
                    str = sb.toString();
                }
                BdCacheService j = BdCacheService.j("baidu_plugin.db");
                l<String> c2 = j.c("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                String str3 = c2.get("time");
                if (!this.f52903c && str3 != null) {
                    long f2 = d.a.d.e.m.b.f(str3, -1L);
                    if (f2 != -1 && System.currentTimeMillis() - f2 < 86400000) {
                        z = false;
                        PluginSettings l = d.a.d.h.j.g.d.k().l();
                        String str4 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + (l == null ? l.getContainerVersion() : null) + "_" + str;
                        if (!z) {
                            str2 = c(c2, str);
                            pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                        } else {
                            String b2 = b(c2, str4);
                            PluginNetConfigInfos parse = PluginNetConfigInfos.parse(b2);
                            if (parse == null) {
                                str2 = c(c2, str);
                                pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                                z = true;
                            } else {
                                str2 = b2;
                                pluginNetConfigInfos = parse;
                            }
                        }
                        publishProgress(pluginNetConfigInfos);
                        if (z) {
                            j.k(c2);
                            l<String> c3 = j.c("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                            c3.e("time", String.valueOf(System.currentTimeMillis()), 172800000L);
                            c3.e(str4, str2, 172800000L);
                        }
                        return null;
                    }
                }
                z = true;
                PluginSettings l2 = d.a.d.h.j.g.d.k().l();
                if (l2 == null) {
                }
                String str42 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + (l2 == null ? l2.getContainerVersion() : null) + "_" + str;
                if (!z) {
                }
                publishProgress(pluginNetConfigInfos);
                if (z) {
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1562572739, "Ld/a/p0/q0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1562572739, "Ld/a/p0/q0/d;");
                return;
            }
        }
        f52897c = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    }

    public d() {
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

    @Override // d.a.d.h.j.f.b
    public void a(boolean z, d.a.d.h.j.f.c cVar, d.a.d.h.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), cVar, aVar}) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                if (aVar != null) {
                    aVar.a(false, cVar, null, null);
                    return;
                }
                return;
            }
            this.f52898a = aVar;
            if (!this.f52899b) {
                this.f52899b = true;
                new b(this, cVar, z).execute(new Void[0]);
            }
            try {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                File filesDir = inst.getFilesDir();
                if (filesDir == null) {
                    filesDir = new File("/data/data/" + inst.getPackageName() + "/files/");
                    try {
                        if (!filesDir.exists()) {
                            f.q(filesDir);
                        }
                    } catch (IOException unused) {
                    }
                }
                File file = new File(filesDir, "pluginsEX");
                if (file.exists()) {
                    new a(this, file).execute(new Void[0]);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
