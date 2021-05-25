package d.a.m0.o0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import d.a.c.e.d.l;
import d.a.c.e.p.f;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class d implements d.a.c.h.j.f.b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f49617c = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.h.j.f.a f49618a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49619b;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public File f49620a;

        public a(d dVar, File file) {
            this.f49620a = null;
            this.f49620a = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            File file = this.f49620a;
            if (file == null || !file.exists()) {
                return null;
            }
            Util.a(this.f49620a);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f49621a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.c.h.j.f.c f49622b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f49623c;

        public b(d.a.c.h.j.f.c cVar, boolean z) {
            this.f49623c = false;
            this.f49622b = cVar;
            this.f49623c = z;
        }

        public final String b(l<String> lVar, String str) {
            return lVar.get(str);
        }

        public final String c(l<String> lVar, String str) {
            boolean checkNewUser = TbadkCoreApplication.getInst().checkNewUser();
            if (TbadkCoreApplication.getInst().checkInterrupt() && checkNewUser) {
                return null;
            }
            NetWork netWork = new NetWork(d.f49617c);
            this.f49621a = netWork;
            netWork.addPostData("plugin_upload_config", str);
            return this.f49621a.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.this.f49619b = false;
            this.f49621a.cancelNetConnect();
            this.f49621a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            d.this.f49619b = false;
            boolean z = pluginNetConfigInfosArr[0] != null;
            String str = null;
            NetWork netWork = this.f49621a;
            if (netWork != null && !netWork.isNetSuccess()) {
                str = this.f49621a.getNetException();
                if (this.f49621a.getServerErrorCode() != 0) {
                    str = str + "-" + this.f49621a.getErrorString();
                }
            }
            d.this.f49618a.a(z, this.f49622b, pluginNetConfigInfosArr[0], str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001224));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            d.a.c.h.j.f.c cVar = this.f49622b;
            if (cVar == null) {
                publishProgress(null);
                return null;
            }
            if (cVar.a() == null || this.f49622b.a().size() <= 0) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder(50);
                int size = this.f49622b.a().size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    BasicNameValuePair basicNameValuePair = this.f49622b.a().get(i2);
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
            if (!this.f49623c && str3 != null) {
                long f2 = d.a.c.e.m.b.f(str3, -1L);
                if (f2 != -1 && System.currentTimeMillis() - f2 < 86400000) {
                    z = false;
                    PluginSettings l = d.a.c.h.j.g.d.k().l();
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
            PluginSettings l2 = d.a.c.h.j.g.d.k().l();
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
    }

    @Override // d.a.c.h.j.f.b
    public void a(boolean z, d.a.c.h.j.f.c cVar, d.a.c.h.j.f.a aVar) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null, null);
                return;
            }
            return;
        }
        this.f49618a = aVar;
        if (!this.f49619b) {
            this.f49619b = true;
            new b(cVar, z).execute(new Void[0]);
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
