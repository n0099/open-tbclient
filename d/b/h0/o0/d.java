package d.b.h0.o0;

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
import d.b.b.e.d.l;
import d.b.b.e.p.f;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class d implements d.b.b.h.j.f.b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f50396c = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.h.j.f.a f50397a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50398b;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public File f50399a;

        public a(d dVar, File file) {
            this.f50399a = null;
            this.f50399a = file;
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
            File file = this.f50399a;
            if (file == null || !file.exists()) {
                return null;
            }
            Util.a(this.f50399a);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f50400a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.b.h.j.f.c f50401b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50402c;

        public b(d.b.b.h.j.f.c cVar, boolean z) {
            this.f50402c = false;
            this.f50401b = cVar;
            this.f50402c = z;
        }

        public final String b(l<String> lVar, String str) {
            return lVar.get(str);
        }

        public final String c(l<String> lVar, String str) {
            boolean checkNewUser = TbadkCoreApplication.getInst().checkNewUser();
            if (TbadkCoreApplication.getInst().checkInterrupt() && checkNewUser) {
                return null;
            }
            NetWork netWork = new NetWork(d.f50396c);
            this.f50400a = netWork;
            netWork.addPostData("plugin_upload_config", str);
            return this.f50400a.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.this.f50398b = false;
            this.f50400a.cancelNetConnect();
            this.f50400a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            d.this.f50398b = false;
            boolean z = pluginNetConfigInfosArr[0] != null;
            String str = null;
            NetWork netWork = this.f50400a;
            if (netWork != null && !netWork.isNetSuccess()) {
                str = this.f50400a.getNetException();
                if (this.f50400a.getServerErrorCode() != 0) {
                    str = str + "-" + this.f50400a.getErrorString();
                }
            }
            d.this.f50397a.a(z, this.f50401b, pluginNetConfigInfosArr[0], str);
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
            d.b.b.h.j.f.c cVar = this.f50401b;
            if (cVar == null) {
                publishProgress(null);
                return null;
            }
            if (cVar.a() == null || this.f50401b.a().size() <= 0) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder(50);
                int size = this.f50401b.a().size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    BasicNameValuePair basicNameValuePair = this.f50401b.a().get(i);
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
            if (!this.f50402c && str3 != null) {
                long f2 = d.b.b.e.m.b.f(str3, -1L);
                if (f2 != -1 && System.currentTimeMillis() - f2 < 86400000) {
                    z = false;
                    PluginSettings l = d.b.b.h.j.g.d.k().l();
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
            PluginSettings l2 = d.b.b.h.j.g.d.k().l();
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

    @Override // d.b.b.h.j.f.b
    public void a(boolean z, d.b.b.h.j.f.c cVar, d.b.b.h.j.f.a aVar) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null, null);
                return;
            }
            return;
        }
        this.f50397a = aVar;
        if (!this.f50398b) {
            this.f50398b = true;
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
