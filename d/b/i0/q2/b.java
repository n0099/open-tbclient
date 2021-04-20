package d.b.i0.q2;

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
import d.b.c.e.p.m;
import d.b.c.e.p.q;
import d.b.h0.r.y.r;
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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f60502f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f60503g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";

    /* renamed from: h  reason: collision with root package name */
    public static int f60504h = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f60506b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f60507c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60505a = false;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f60508d = new a(2001371);

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f60509e = new C1517b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || b.this.f60505a) {
                return;
            }
            b.this.f60505a = true;
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

    /* renamed from: d.b.i0.q2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1517b extends d.b.c.c.g.a {
        public C1517b(b bVar, int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                if (header != null && header.size() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= header.size()) {
                            break;
                        }
                        if (!TextUtils.isEmpty(header.get(i)) && header.get(i).contains("BAIDUID=")) {
                            d.b.h0.l.a.i(header.get(i));
                            break;
                        }
                        i++;
                    }
                }
                Map<String, d.b.i0.q2.e.a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        b.m(str, moduleInfos.get(str));
                    }
                    return;
                }
                d.b.i0.q2.c.a().e(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, d.b.i0.q2.e.a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        b.m(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                d.b.i0.q2.c.a().e(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f60511a;

        public c() {
            this.f60511a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            e y;
            String modName = TbSingleton.getInstance().getModName();
            if (TextUtils.isEmpty(modName) || (y = b.this.y(modName)) == null) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
            this.f60511a = netWork;
            netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
            this.f60511a.addPostData("mod_name", modName);
            this.f60511a.addPostData("status", y.f60520a ? "1" : "2");
            this.f60511a.addPostData("fail_reason", y.f60520a ? "" : y.f60521b);
            this.f60511a.postNetData();
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

    /* loaded from: classes3.dex */
    public static class d extends BdAsyncTask<Void, Void, h> {

        /* renamed from: a  reason: collision with root package name */
        public final String f60513a;

        /* renamed from: b  reason: collision with root package name */
        public final d.b.i0.q2.e.a f60514b;

        /* renamed from: c  reason: collision with root package name */
        public final String f60515c;

        /* renamed from: d  reason: collision with root package name */
        public final String f60516d;

        /* renamed from: e  reason: collision with root package name */
        public final String f60517e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f60518f;

        /* renamed from: g  reason: collision with root package name */
        public NetWork f60519g;

        public d(String str, d.b.i0.q2.e.a aVar, boolean z) {
            this.f60513a = str;
            this.f60514b = aVar;
            this.f60516d = aVar.c();
            this.f60515c = this.f60514b.a();
            this.f60517e = this.f60514b.b();
            this.f60518f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x01a1  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            h p;
            HashMap<String, d.b.i0.q2.d.a> hashMap;
            FileInputStream fileInputStream;
            String str;
            b.l(this.f60513a);
            b.o().j(this.f60513a);
            FileInputStream fileInputStream2 = null;
            if (this.f60518f) {
                if (!TextUtils.isEmpty(b.o().q(this.f60513a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f60513a).param("obj_id", this.f60516d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.f60519g = netWork;
            netWork.setUrl(this.f60515c);
            new File(b.f60503g + "bdtbWCacheTemp/" + this.f60513a + "/").mkdirs();
            String str2 = b.f60503g + "bdtbWCacheTemp/" + this.f60513a + "/bdtbNWCache.zip";
            if (this.f60519g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    fileInputStream = new FileInputStream(str2);
                    try {
                        try {
                            String b2 = q.b(fileInputStream);
                            if (StringUtils.isNull(b2) || !b2.toLowerCase().equals(this.f60517e.toLowerCase())) {
                                b.f60504h = 2;
                                d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "md5 error", "module", this.f60513a);
                                b.l(this.f60513a);
                                m.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            m.e(fileInputStream);
                            str = b.f60503g + "bdtbWCacheTemp/" + this.f60513a + "/" + this.f60516d + "/";
                            new File(str).mkdirs();
                            if (!r.b(str2, str)) {
                            }
                            b.l(this.f60513a);
                            p = b.p(this.f60513a, this.f60516d);
                            if (p == null) {
                            }
                            b.f60504h = 5;
                            d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", "module", this.f60513a);
                            b.o().j(this.f60513a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        m.e(fileInputStream2);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    m.e(fileInputStream2);
                    throw th;
                }
                m.e(fileInputStream);
                str = b.f60503g + "bdtbWCacheTemp/" + this.f60513a + "/" + this.f60516d + "/";
                new File(str).mkdirs();
                if (!r.b(str2, str)) {
                    String str3 = b.f60503g + "bdtbNWCache/" + this.f60513a + "/" + this.f60516d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        b.f60504h = 4;
                        d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "write error", "module", this.f60513a);
                    }
                } else {
                    b.f60504h = 3;
                    d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "unzip error", "module", this.f60513a);
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                b.f60504h = 1;
                d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "download error", "module", this.f60513a);
            }
            b.l(this.f60513a);
            p = b.p(this.f60513a, this.f60516d);
            if (p == null && !TextUtils.isEmpty(p.f60525a) && (hashMap = p.f60526b) != null && hashMap.size() != 0) {
                b.k(p.f60527c, this.f60513a);
                return p;
            }
            b.f60504h = 5;
            d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", "module", this.f60513a);
            b.o().j(this.f60513a);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (hVar != null) {
                b.o().x(this.f60513a, hVar.f60527c);
                b.o().w();
                d.b.i0.q2.c.a().h(this.f60513a, hVar.f60526b);
                d.b.i0.q2.c.a().f(true, this.f60513a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.f60513a).param("obj_id", hVar.f60527c));
                return;
            }
            b.o().i(this.f60513a);
            b.o().w();
            d.b.i0.q2.c.a().d(this.f60513a);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60520a;

        /* renamed from: b  reason: collision with root package name */
        public String f60521b;
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Void, Void, g> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            HashMap<String, d.b.i0.q2.d.a> hashMap;
            g gVar = new g(null);
            for (String str : b.o().r()) {
                h p = b.p(str, b.o().q(str));
                if (p != null && !TextUtils.isEmpty(p.f60525a) && (hashMap = p.f60526b) != null && hashMap.size() != 0) {
                    if (gVar.f60523a == null) {
                        gVar.f60523a = new HashMap();
                    }
                    gVar.f60523a.put(str, p);
                    if (gVar.f60524b == null) {
                        gVar.f60524b = new HashMap<>();
                    }
                    gVar.f60524b.putAll(p.f60526b);
                    b.k(p.f60527c, str);
                } else {
                    b.f60504h = 5;
                    d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "downloadCache", -1, "bundle incomplete", "module", str);
                    b.this.j(str);
                }
            }
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            if (gVar == null) {
                d.b.h0.r.z.a.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                d.b.i0.q2.c.a().g(gVar.f60524b);
            }
            MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, h> f60523a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.b.i0.q2.d.a> f60524b;

        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f60525a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, d.b.i0.q2.d.a> f60526b;

        /* renamed from: c  reason: collision with root package name */
        public String f60527c;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        r0 = b.class.getSimpleName() + " TestActivity";
    }

    public static void k(String str, String str2) {
        String[] list;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = f60503g + "bdtbNWCache/" + str2;
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

    public static void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f60503g + "bdtbWCacheTemp/" + str));
    }

    public static void m(String str, d.b.i0.q2.e.a aVar) {
        if (aVar != null && !StringUtils.isNull(aVar.c()) && !StringUtils.isNull(aVar.b()) && !StringUtils.isNull(aVar.a())) {
            String q = o().q(str);
            String c2 = aVar.c();
            String a2 = aVar.a();
            boolean d2 = aVar.d();
            if (StringUtils.isNull(q)) {
                q = "0.0.0.0";
            }
            if (d2 && c2.equals(q)) {
                d.b.i0.q2.c.a().f(true, str);
                return;
            }
            d.b.h0.r.z.a.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "intallVersion", c2, "lastVersion", q, "type", IntentConfig.START, "module", str);
            new d(str, aVar, true ^ d2).execute(new Void[0]);
            return;
        }
        d.b.i0.q2.c.a().f(true, str);
    }

    public static b o() {
        if (f60502f == null) {
            synchronized (b.class) {
                if (f60502f == null) {
                    f60502f = new b();
                }
            }
        }
        return f60502f;
    }

    public static h p(String str, String str2) {
        FileInputStream fileInputStream;
        File file = new File(f60503g + "bdtbNWCache");
        FileInputStream fileInputStream2 = null;
        if (file.exists() && !TextUtils.isEmpty(str2)) {
            h hVar = new h(null);
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            hVar.f60525a = file.getAbsolutePath();
            hVar.f60527c = str2;
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
                    hVar.f60526b = v(fileInputStream);
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

    public static HashMap<String, d.b.i0.q2.d.a> v(InputStream inputStream) {
        BufferedReader bufferedReader;
        HashMap<String, d.b.i0.q2.d.a> hashMap;
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
                        for (int i = 0; i < optJSONArray2.length(); i++) {
                            arrayList.add(optJSONArray2.optString(i));
                        }
                    }
                    String optString = jSONObject3.has("module") ? jSONObject3.optString("module") : "";
                    String optString2 = jSONObject3.has("path") ? jSONObject3.optString("path") : "";
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    if (!jSONObject3.has("source") || (optJSONArray = jSONObject3.optJSONArray("source")) == null) {
                        jSONObject2 = optJSONObject;
                    } else {
                        jSONObject2 = optJSONObject;
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList2.add(optJSONArray.optString(i2));
                        }
                    }
                    d.b.i0.q2.d.a aVar = new d.b.i0.q2.d.a();
                    aVar.f60530a = arrayList;
                    aVar.f60531b = optString;
                    aVar.f60532c = optString2;
                    aVar.f60533d = arrayList2;
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

    public void i(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f60507c) == null) {
            return;
        }
        map.remove(str);
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i(str);
        d.b.h0.r.d0.b.j().x("pref_key_quick_webview_versions", z());
        File file = new File(f60503g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public String n() {
        return this.f60506b;
    }

    public String q(String str) {
        if (this.f60507c == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f60507c.get(str);
    }

    public Set<String> r() {
        if (this.f60507c == null) {
            this.f60507c = new ConcurrentHashMap();
        }
        return this.f60507c.keySet();
    }

    public void s() {
        System.currentTimeMillis();
        MessageManager.getInstance().registerListener(this.f60509e);
        MessageManager.getInstance().registerListener(this.f60508d);
        this.f60506b = new File(f60503g + "bdtbNWCache").getAbsolutePath();
        u(d.b.h0.r.d0.b.j().p("pref_key_quick_webview_versions", ""));
    }

    public final e t(String str, e eVar) {
        if (StringUtils.isNull(str)) {
            eVar.f60521b = "serve return is null";
            return eVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.f60520a = jSONObject.optInt("error_code") == 0;
            eVar.f60521b = jSONObject.optString("error_msg");
        } catch (JSONException e2) {
            eVar.f60521b = "parse json exception";
            BdLog.e(e2);
        }
        return eVar;
    }

    public void u(String str) {
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
                    if (this.f60507c == null) {
                        this.f60507c = new ConcurrentHashMap();
                    }
                    this.f60507c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void w() {
        String z = z();
        if (TextUtils.isEmpty(z)) {
            return;
        }
        d.b.h0.r.d0.b.j().x("pref_key_quick_webview_versions", z);
    }

    public void x(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f60507c == null) {
            this.f60507c = new ConcurrentHashMap();
        }
        this.f60507c.put(str, str2);
    }

    public final e y(String str) {
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            eVar.f60521b = "module not exit";
            return eVar;
        }
        File file = new File(f60503g + "bdtbNWCache", str);
        String q = o().q(str);
        if (TbSingleton.getInstance().isUploadOffPack()) {
            eVar.f60520a = false;
            if (!file.exists()) {
                eVar.f60521b = "bundle not exist";
                return eVar;
            } else if (TextUtils.isEmpty(q)) {
                eVar.f60521b = "the local has no valid version name";
                return eVar;
            } else {
                String str2 = file.getAbsolutePath() + "/" + q + "/";
                if (!new File(str2).exists()) {
                    eVar.f60521b = "bundle not exist";
                    return eVar;
                }
                String str3 = file.getAbsolutePath() + "/" + q + ".zip";
                File file2 = new File(str3);
                if (file2.exists()) {
                    FileHelper.deleteFileOrDir(file2);
                }
                if (r.d(str2, str3)) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                    netWork.addPostData("offline_pack_version", q);
                    netWork.addPostData("mod_name", str);
                    netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    t(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
                    if (!eVar.f60520a) {
                        return eVar;
                    }
                } else {
                    eVar.f60521b = "zip bundle error";
                    return eVar;
                }
            }
        } else {
            eVar.f60520a = true;
        }
        if (TbSingleton.getInstance().isClearOffPack()) {
            j(str);
            if (!TextUtils.isEmpty(q)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", q));
            }
            if (!file.exists() || StringUtils.isNull(q) || !new File(file.getAbsolutePath(), q).exists()) {
                return eVar;
            }
            eVar.f60521b = "delete fail";
            eVar.f60520a = false;
        }
        return eVar;
    }

    public String z() {
        Map<String, String> map = this.f60507c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(this.f60507c).toString();
    }
}
