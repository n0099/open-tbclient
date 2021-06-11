package d.a.n0.f0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import com.baidu.tieba.dnsproxy.DnsProxyStatic;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class e {
    public static e m;
    public static final Random n = new Random();

    /* renamed from: a  reason: collision with root package name */
    public HashSet<String> f57959a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f57960b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f57961c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f57962d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f57963e = new c();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f57964f = new d(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f57965g = new C1359e(2001011);

    /* renamed from: h  reason: collision with root package name */
    public Handler f57966h = null;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f57967i = new HandlerThread(e.class.getName());
    public Runnable j = new g();
    public long k = 0;
    public d.a.n0.f0.c l = null;

    /* loaded from: classes4.dex */
    public class a implements Comparator<DnsProxyResponseData.DnsProxyIpData> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57968e;

        public a(e eVar, String str) {
            this.f57968e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
            if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                return 0;
            }
            if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                    return d.a.n0.f0.i.d.m().l(this.f57968e, dnsProxyIpData.getIp()) - d.a.n0.f0.i.d.m().l(this.f57968e, dnsProxyIpData2.getIp()) >= 0.0f ? 1 : -1;
                }
                return -1;
            }
            return 1;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Comparator<DnsProxyResponseData.DnsProxyIpData> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57969e;

        public b(e eVar, String str) {
            this.f57969e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
            if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                return 0;
            }
            if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                    return d.a.n0.f0.i.d.m().k(this.f57969e, dnsProxyIpData.getIp()) - d.a.n0.f0.i.d.m().k(this.f57969e, dnsProxyIpData2.getIp()) >= 0.0f ? -1 : 1;
                }
                return 1;
            }
            return -1;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.baidu.tieba.dnsproxy.dnsproxydata".equals(intent.getAction())) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        return;
                    }
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (String str : extras.keySet()) {
                        JSONArray jSONArray = new JSONArray(extras.getString(str));
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = (DnsProxyResponseData.DnsProxyIpData) OrmObject.objectWithJson(jSONArray.getJSONObject(i2), DnsProxyResponseData.DnsProxyIpData.class);
                            if (dnsProxyIpData != null) {
                                arrayList.add(dnsProxyIpData);
                            }
                        }
                        concurrentHashMap.put(str, arrayList);
                    }
                    if (concurrentHashMap.size() > 0) {
                        e.this.f57961c.clear();
                        e.this.f57961c.putAll(concurrentHashMap);
                        e.this.l(true);
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.a.n0.f0.d.c().a("dpm_broadcast", th.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.j.z()) {
                d.a.n0.f0.i.d.m().r();
                e.this.k();
            }
        }
    }

    /* renamed from: d.a.n0.f0.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1359e extends CustomMessageListener {
        public C1359e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.a.c.e.m.e.a().removeCallbacks(e.this.j);
                    DnsProxyStatic.h();
                    DnsProxyStatic.g();
                    d.a.n0.f0.i.c.h().k();
                    return;
                }
                e.this.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f57972e;

        public f(Runnable runnable) {
            this.f57972e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f57972e);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.k();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.a.n0.f0.g {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            super.onPostExecute(hashMap);
            e.this.f57962d.clear();
            if (hashMap != null) {
                e.this.f57962d.putAll(hashMap);
                e.this.l(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f57976e;

        public i(boolean z) {
            this.f57976e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f57976e);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.a.n0.f0.c {
        public j(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            super.onPostExecute(hashMap);
            e.this.l = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>... hashMapArr) {
            super.onProgressUpdate(hashMapArr);
            if (hashMapArr != null && hashMapArr.length > 0) {
                if (hashMapArr[0] != null) {
                    e(hashMapArr[0]);
                } else if (this.f57957a) {
                    e.this.l = null;
                    e.this.g(false);
                }
            } else if (this.f57957a) {
                e.this.l = null;
                e.this.g(false);
            }
        }

        public final void e(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            e.this.f57961c.clear();
            if (hashMap != null) {
                e.this.f57961c.putAll(hashMap);
                e.this.l(true);
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    Intent intent = new Intent();
                    intent.setAction("com.baidu.tieba.dnsproxy.dnsproxydata");
                    for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry : hashMap.entrySet()) {
                        JSONArray jSONArray = new JSONArray();
                        for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : entry.getValue()) {
                            try {
                                jSONArray.put(OrmObject.jsonWithObject(dnsProxyIpData));
                            } catch (Throwable th) {
                                BdLog.detailException(th);
                            }
                        }
                        intent.putExtra(entry.getKey(), jSONArray.toString());
                    }
                    intent.setPackage(TbadkCoreApplication.getInst().getContext().getPackageName());
                    d.a.c.e.m.f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.k();
        }
    }

    public e() {
        this.f57967i.start();
    }

    public static final e i() {
        if (m == null) {
            synchronized (e.class) {
                if (m == null) {
                    m = new e();
                }
            }
        }
        return m;
    }

    public void f() {
        this.f57959a.clear();
        d.a.n0.f0.i.d.m().j();
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        MessageManager.getInstance().unRegisterListener(this.f57964f);
        MessageManager.getInstance().unRegisterListener(this.f57965g);
        TbadkCoreApplication.getInst().unregisterReceiver(this.f57963e);
    }

    public void g(boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.C()) {
                d.a.c.e.m.e.a().post(new i(z));
            } else if (this.l == null && System.currentTimeMillis() - this.k >= 5000) {
                if (!z) {
                    this.k = System.currentTimeMillis();
                }
                j jVar = new j(z);
                this.l = jVar;
                jVar.execute(new HashSet(this.f57959a));
            }
        }
    }

    public String h(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f57959a.contains(str)) {
            String m2 = m(str, this.f57960b, z);
            return !TextUtils.isEmpty(m2) ? m2 : m(str, this.f57961c, z);
        }
        return null;
    }

    public final void j() {
        new h().execute(new HashSet(this.f57959a));
    }

    public void k() {
        j();
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        d.a.c.e.m.e.a().postDelayed(this.j, 300000L);
    }

    public final void l(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            map = this.f57961c;
            map2 = this.f57962d;
        } else {
            map = this.f57962d;
            map2 = this.f57961c;
        }
        for (String str : map.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map2.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && d.a.n0.f0.h.a(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && d.a.n0.f0.h.a(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
                        hashSet.add(dnsProxyIpData2.getIp());
                    }
                }
            }
            ArrayList arrayList = new ArrayList(hashSet.size());
            for (String str2 : hashSet) {
                DnsProxyResponseData.DnsProxyIpData dnsProxyIpData3 = new DnsProxyResponseData.DnsProxyIpData();
                dnsProxyIpData3.setIp(str2);
                arrayList.add(dnsProxyIpData3);
            }
            this.f57960b.put(str, arrayList);
        }
    }

    public final String m(String str, Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map, boolean z) {
        List<DnsProxyResponseData.DnsProxyIpData> list;
        if (!TextUtils.isEmpty(str) && map != null && (list = map.get(str)) != null && list.size() > 0) {
            if (list.size() == 1) {
                String ip = list.get(0).getIp();
                if (n.nextFloat() < d.a.n0.f0.i.d.m().k("c.tieba.baidu.com", ip)) {
                    return ip;
                }
            } else {
                if (z) {
                    Collections.sort(list, new a(this, str));
                } else {
                    Collections.sort(list, new b(this, str));
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && d.a.n0.f0.h.a(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (n.nextFloat() < d.a.n0.f0.i.d.m().k("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void n() {
        this.f57959a.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.f57964f);
            MessageManager.getInstance().registerListener(this.f57964f);
        }
        MessageManager.getInstance().unRegisterListener(this.f57965g);
        MessageManager.getInstance().registerListener(this.f57965g);
        d.a.n0.f0.i.d.m().t();
        d.a.c.e.m.e.a().post(new k());
        g(true);
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            return;
        }
        TbadkCoreApplication.getInst().unregisterReceiver(this.f57963e);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
        TbadkCoreApplication.getInst().registerReceiver(this.f57963e, intentFilter);
    }

    public void o(Runnable runnable) {
        if (runnable != null) {
            Handler handler = this.f57966h;
            if (handler == null) {
                if (this.f57967i.getLooper() != null) {
                    Handler handler2 = new Handler(this.f57967i.getLooper());
                    this.f57966h = handler2;
                    handler2.post(runnable);
                }
                d.a.c.e.m.e.a().postDelayed(new f(runnable), 100L);
                return;
            }
            handler.post(runnable);
        }
    }
}
