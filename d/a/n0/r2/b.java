package d.a.n0.r2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import d.a.c.e.p.m;
import d.a.c.e.p.q;
import d.a.m0.r.y.r;
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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f59939f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f59940g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";

    /* renamed from: h  reason: collision with root package name */
    public static int f59941h = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f59943b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f59944c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59942a = false;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f59945d = new a(2001371);

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f59946e = new C1566b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || b.this.f59942a) {
                return;
            }
            b.this.f59942a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    f fVar = new f();
                    fVar.setPriority(4);
                    fVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c(b.this, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* renamed from: d.a.n0.r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1566b extends d.a.c.c.g.a {
        public C1566b(b bVar, int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
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
                            d.a.m0.l.a.i(header.get(i2));
                            break;
                        }
                        i2++;
                    }
                }
                Map<String, d.a.n0.r2.e.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        b.o(str, moduleInfos.get(str));
                    }
                    return;
                }
                d.a.n0.r2.c.a().e(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, d.a.n0.r2.e.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        b.o(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                d.a.n0.r2.c.a().e(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f59948a;

        public c() {
            this.f59948a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            e A;
            String modName = TbSingleton.getInstance().getModName();
            if (TextUtils.isEmpty(modName) || (A = b.this.A(modName)) == null) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
            this.f59948a = netWork;
            netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
            this.f59948a.addPostData("mod_name", modName);
            this.f59948a.addPostData("status", A.f59957a ? "1" : "2");
            this.f59948a.addPostData("fail_reason", A.f59957a ? "" : A.f59958b);
            this.f59948a.postNetData();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            f fVar = new f();
            fVar.setPriority(4);
            fVar.execute(new Void[0]);
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BdAsyncTask<Void, Void, h> {

        /* renamed from: a  reason: collision with root package name */
        public final String f59950a;

        /* renamed from: b  reason: collision with root package name */
        public final d.a.n0.r2.e.a f59951b;

        /* renamed from: c  reason: collision with root package name */
        public final String f59952c;

        /* renamed from: d  reason: collision with root package name */
        public final String f59953d;

        /* renamed from: e  reason: collision with root package name */
        public final String f59954e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f59955f;

        /* renamed from: g  reason: collision with root package name */
        public NetWork f59956g;

        public d(String str, d.a.n0.r2.e.a aVar, boolean z) {
            this.f59950a = str;
            this.f59951b = aVar;
            this.f59953d = aVar.c();
            this.f59952c = this.f59951b.a();
            this.f59954e = this.f59951b.b();
            this.f59955f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:29:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01b2  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            h r;
            HashMap<String, d.a.n0.r2.d.a> hashMap;
            InputStream inputStream;
            FileInputStream fileInputStream;
            String str;
            b.m(this.f59950a);
            b.q().k(this.f59950a);
            if (this.f59955f) {
                if (!TextUtils.isEmpty(b.q().s(this.f59950a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f59950a).param("obj_id", this.f59953d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.f59956g = netWork;
            netWork.setUrl(this.f59952c);
            new File(b.f59940g + "bdtbWCacheTemp/" + this.f59950a + "/").mkdirs();
            String str2 = b.f59940g + "bdtbWCacheTemp/" + this.f59950a + "/bdtbNWCache.zip";
            if (this.f59956g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            String b2 = q.b(fileInputStream);
                            if (StringUtils.isNull(b2) || !b2.toLowerCase().equals(this.f59954e.toLowerCase())) {
                                b.f59941h = 2;
                                d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "md5 error");
                                b.m(this.f59950a);
                                m.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            m.e(fileInputStream);
                            str = b.f59940g + "bdtbWCacheTemp/" + this.f59950a + "/" + this.f59953d + "/";
                            new File(str).mkdirs();
                            if (!r.b(str2, str)) {
                            }
                            b.m(this.f59950a);
                            r = b.r(this.f59950a, this.f59953d);
                            if (r == null) {
                            }
                            b.f59941h = 5;
                            d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "bundle incomplete");
                            b.q().k(this.f59950a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = "obj_type";
                        m.e(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    m.e(inputStream);
                    throw th;
                }
                m.e(fileInputStream);
                str = b.f59940g + "bdtbWCacheTemp/" + this.f59950a + "/" + this.f59953d + "/";
                new File(str).mkdirs();
                if (!r.b(str2, str)) {
                    String str3 = b.f59940g + "bdtbNWCache/" + this.f59950a + "/" + this.f59953d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        b.f59941h = 4;
                        d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "write error");
                    }
                } else {
                    b.f59941h = 3;
                    d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "unzip error");
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                b.f59941h = 1;
                d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "download error");
            }
            b.m(this.f59950a);
            r = b.r(this.f59950a, this.f59953d);
            if (r == null && !TextUtils.isEmpty(r.f59962a) && (hashMap = r.f59963b) != null && hashMap.size() != 0) {
                b.l(r.f59964c, this.f59950a);
                return r;
            }
            b.f59941h = 5;
            d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", this.f59950a, "hybridResult", "bundle incomplete");
            b.q().k(this.f59950a);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (hVar != null) {
                b.q().z(this.f59950a, hVar.f59964c);
                b.q().y();
                d.a.n0.r2.c.a().h(this.f59950a, hVar.f59963b);
                d.a.n0.r2.c.a().f(true, this.f59950a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f59950a).param("obj_id", hVar.f59964c));
                return;
            }
            b.q().j(this.f59950a);
            b.q().y();
            d.a.n0.r2.c.a().d(this.f59950a);
        }
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59957a;

        /* renamed from: b  reason: collision with root package name */
        public String f59958b;
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Void, Void, g> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            HashMap<String, d.a.n0.r2.d.a> hashMap;
            g gVar = new g(null);
            for (String str : b.q().t()) {
                h r = b.r(str, b.q().s(str));
                if (r != null && !TextUtils.isEmpty(r.f59962a) && (hashMap = r.f59963b) != null && hashMap.size() != 0) {
                    if (gVar.f59960a == null) {
                        gVar.f59960a = new HashMap();
                    }
                    gVar.f59960a.put(str, r);
                    if (gVar.f59961b == null) {
                        gVar.f59961b = new HashMap<>();
                    }
                    gVar.f59961b.putAll(r.f59963b);
                    b.l(r.f59964c, str);
                } else {
                    b.f59941h = 5;
                    d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridModule", str, "hybridResult", "bundle incomplete");
                    b.this.k(str);
                }
            }
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            if (gVar == null) {
                d.a.m0.r.z.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                d.a.n0.r2.c.a().g(gVar.f59961b);
            }
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
        }
    }

    /* loaded from: classes5.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, h> f59960a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.a.n0.r2.d.a> f59961b;

        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f59962a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.a.n0.r2.d.a> f59963b;

        /* renamed from: c  reason: collision with root package name */
        public String f59964c;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        r0 = b.class.getSimpleName() + " TestActivity";
    }

    public static void l(String str, String str2) {
        String[] list;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = f59940g + "bdtbNWCache/" + str2;
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
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f59940g + "bdtbWCacheTemp/" + str));
    }

    public static void o(String str, d.a.n0.r2.e.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.c()) && !StringUtils.isNull(aVar.b()) && !StringUtils.isNull(aVar.a())) {
            String s = q().s(str);
            String c2 = aVar.c();
            String a2 = aVar.a();
            boolean d2 = aVar.d();
            if (StringUtils.isNull(s)) {
                s = "0.0.0.0";
            }
            if (d2 && c2.equals(s)) {
                d.a.n0.r2.c.a().f(true, str);
                return;
            }
            d.a.m0.r.z.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", s, "type", IntentConfig.START, "hybridModule", str, "hybridResult", "success");
            new d(str, aVar, true ^ d2).execute(new Void[0]);
            return;
        }
        d.a.n0.r2.c.a().f(true, str);
    }

    public static b q() {
        if (f59939f == null) {
            synchronized (b.class) {
                if (f59939f == null) {
                    f59939f = new b();
                }
            }
        }
        return f59939f;
    }

    public static h r(String str, String str2) {
        FileInputStream fileInputStream;
        File file = new File(f59940g + "bdtbNWCache");
        FileInputStream fileInputStream2 = null;
        if (file.exists() && !TextUtils.isEmpty(str2)) {
            h hVar = new h(null);
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            hVar.f59962a = file.getAbsolutePath();
            hVar.f59964c = str2;
            File file3 = new File(file2, "router.json");
            if (file3.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(file3);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    hVar.f59963b = x(fileInputStream);
                    m.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    m.e(fileInputStream2);
                    return hVar;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    m.e(fileInputStream2);
                    throw th;
                }
                return hVar;
            }
            return null;
        }
        return null;
    }

    public static HashMap<String, d.a.n0.r2.d.a> x(InputStream inputStream) {
        BufferedReader bufferedReader;
        HashMap<String, d.a.n0.r2.d.a> hashMap;
        InputStreamReader inputStreamReader;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Iterator<String> keys;
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        InputStreamReader inputStreamReader2 = null;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    hashMap = new HashMap<>();
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                    stringBuffer.append(readLine);
                                }
                                bufferedReader.close();
                                jSONObject = new JSONObject(stringBuffer.toString());
                            } catch (IOException e2) {
                                e = e2;
                                inputStreamReader2 = inputStreamReader;
                                e.printStackTrace();
                                m.g(inputStreamReader2);
                                m.g(bufferedReader);
                                return hashMap;
                            } catch (JSONException e3) {
                                e = e3;
                                inputStreamReader2 = inputStreamReader;
                                e.printStackTrace();
                                m.g(inputStreamReader2);
                                m.g(bufferedReader);
                                return hashMap;
                            } catch (Exception e4) {
                                e = e4;
                                inputStreamReader2 = inputStreamReader;
                                e.printStackTrace();
                                m.g(inputStreamReader2);
                                m.g(bufferedReader);
                                return hashMap;
                            } catch (Throwable th) {
                                th = th;
                                inputStreamReader2 = inputStreamReader;
                                m.g(inputStreamReader2);
                                m.g(bufferedReader);
                                throw th;
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
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader = null;
                    } catch (JSONException e9) {
                        e = e9;
                        bufferedReader = null;
                    } catch (Exception e10) {
                        e = e10;
                        bufferedReader = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (IOException e11) {
                e = e11;
                hashMap = null;
                bufferedReader = null;
            } catch (JSONException e12) {
                e = e12;
                hashMap = null;
                bufferedReader = null;
            } catch (Exception e13) {
                e = e13;
                hashMap = null;
                bufferedReader = null;
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
                    d.a.n0.r2.d.a aVar = new d.a.n0.r2.d.a();
                    aVar.f59967a = arrayList;
                    aVar.f59968b = optString;
                    aVar.f59969c = optString2;
                    aVar.f59970d = arrayList2;
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
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            eVar.f59958b = "module not exit";
            return eVar;
        }
        File file = new File(f59940g + "bdtbNWCache", str);
        String s = q().s(str);
        if (TbSingleton.getInstance().isUploadOffPack()) {
            eVar.f59957a = false;
            if (!file.exists()) {
                eVar.f59958b = "bundle not exist";
                return eVar;
            } else if (TextUtils.isEmpty(s)) {
                eVar.f59958b = "the local has no valid version name";
                return eVar;
            } else {
                String str2 = file.getAbsolutePath() + "/" + s + "/";
                if (!new File(str2).exists()) {
                    eVar.f59958b = "bundle not exist";
                    return eVar;
                }
                String str3 = file.getAbsolutePath() + "/" + s + ".zip";
                File file2 = new File(str3);
                if (file2.exists()) {
                    FileHelper.deleteFileOrDir(file2);
                }
                if (r.d(str2, str3)) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                    netWork.addPostData("offline_pack_version", s);
                    netWork.addPostData("mod_name", str);
                    netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    v(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
                    if (!eVar.f59957a) {
                        return eVar;
                    }
                } else {
                    eVar.f59958b = "zip bundle error";
                    return eVar;
                }
            }
        } else {
            eVar.f59957a = true;
        }
        if (TbSingleton.getInstance().isClearOffPack()) {
            k(str);
            if (!TextUtils.isEmpty(s)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", s));
            }
            if (!file.exists() || StringUtils.isNull(s) || !new File(file.getAbsolutePath(), s).exists()) {
                return eVar;
            }
            eVar.f59958b = "delete fail";
            eVar.f59957a = false;
        }
        return eVar;
    }

    public JSONObject B() {
        Map<String, String> map = this.f59944c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(this.f59944c);
    }

    public String C() {
        Map<String, String> map = this.f59944c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(this.f59944c).toString();
    }

    public void i() {
        String[] list;
        n();
        d.a.m0.r.d0.b.j().x("pref_key_quick_webview_versions", "");
        String str = f59940g + "bdtbNWCache";
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

    public void j(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f59944c) == null) {
            return;
        }
        map.remove(str);
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j(str);
        d.a.m0.r.d0.b.j().x("pref_key_quick_webview_versions", C());
        File file = new File(f59940g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void n() {
        if (this.f59944c == null) {
            this.f59944c = new ConcurrentHashMap();
        }
        this.f59944c.clear();
    }

    public String p() {
        return this.f59943b;
    }

    public String s(String str) {
        if (this.f59944c == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f59944c.get(str);
    }

    public Set<String> t() {
        if (this.f59944c == null) {
            this.f59944c = new ConcurrentHashMap();
        }
        return this.f59944c.keySet();
    }

    public void u() {
        System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.f59946e);
        MessageManager.getInstance().registerListener(this.f59945d);
        this.f59943b = new File(f59940g + "bdtbNWCache").getAbsolutePath();
        w(d.a.m0.r.d0.b.j().p("pref_key_quick_webview_versions", ""));
    }

    public final e v(String str, e eVar) {
        if (StringUtils.isNull(str)) {
            eVar.f59958b = "serve return is null";
            return eVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.f59957a = jSONObject.optInt("error_code") == 0;
            eVar.f59958b = jSONObject.optString("error_msg");
        } catch (JSONException e2) {
            eVar.f59958b = "parse json exception";
            BdLog.e(e2);
        }
        return eVar;
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
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
                    if (this.f59944c == null) {
                        this.f59944c = new ConcurrentHashMap();
                    }
                    this.f59944c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void y() {
        String C = C();
        if (TextUtils.isEmpty(C)) {
            return;
        }
        d.a.m0.r.d0.b.j().x("pref_key_quick_webview_versions", C);
    }

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f59944c == null) {
            this.f59944c = new ConcurrentHashMap();
        }
        this.f59944c.put(str, str2);
    }
}
