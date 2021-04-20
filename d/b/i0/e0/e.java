package d.b.i0.e0;

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
import d.b.c.e.p.l;
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
    public HashSet<String> f55105a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f55106b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f55107c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f55108d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f55109e = new c();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55110f = new d(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f55111g = new C1251e(2001011);

    /* renamed from: h  reason: collision with root package name */
    public Handler f55112h = null;
    public HandlerThread i = new HandlerThread(e.class.getName());
    public Runnable j = new g();
    public long k = 0;
    public d.b.i0.e0.c l = null;

    /* loaded from: classes4.dex */
    public class a implements Comparator<DnsProxyResponseData.DnsProxyIpData> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55113e;

        public a(e eVar, String str) {
            this.f55113e = str;
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
                    return d.b.i0.e0.i.d.m().l(this.f55113e, dnsProxyIpData.getIp()) - d.b.i0.e0.i.d.m().l(this.f55113e, dnsProxyIpData2.getIp()) >= 0.0f ? 1 : -1;
                }
                return -1;
            }
            return 1;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Comparator<DnsProxyResponseData.DnsProxyIpData> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55114e;

        public b(e eVar, String str) {
            this.f55114e = str;
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
                    return d.b.i0.e0.i.d.m().k(this.f55114e, dnsProxyIpData.getIp()) - d.b.i0.e0.i.d.m().k(this.f55114e, dnsProxyIpData2.getIp()) >= 0.0f ? -1 : 1;
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
                        for (int i = 0; i < length; i++) {
                            DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = (DnsProxyResponseData.DnsProxyIpData) OrmObject.objectWithJson(jSONArray.getJSONObject(i), DnsProxyResponseData.DnsProxyIpData.class);
                            if (dnsProxyIpData != null) {
                                arrayList.add(dnsProxyIpData);
                            }
                        }
                        concurrentHashMap.put(str, arrayList);
                    }
                    if (concurrentHashMap.size() > 0) {
                        e.this.f55107c.clear();
                        e.this.f55107c.putAll(concurrentHashMap);
                        e.this.l(true);
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.b.i0.e0.d.c().a("dpm_broadcast", th.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.b.c.e.p.j.z()) {
                d.b.i0.e0.i.d.m().r();
                e.this.k();
            }
        }
    }

    /* renamed from: d.b.i0.e0.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1251e extends CustomMessageListener {
        public C1251e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.b.c.e.m.e.a().removeCallbacks(e.this.j);
                    DnsProxyStatic.h();
                    DnsProxyStatic.g();
                    d.b.i0.e0.i.c.h().k();
                    return;
                }
                e.this.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f55117e;

        public f(Runnable runnable) {
            this.f55117e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f55117e);
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
    public class h extends d.b.i0.e0.g {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            super.onPostExecute(hashMap);
            e.this.f55108d.clear();
            if (hashMap != null) {
                e.this.f55108d.putAll(hashMap);
                e.this.l(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f55121e;

        public i(boolean z) {
            this.f55121e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f55121e);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.b.i0.e0.c {
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
                } else if (this.f55103a) {
                    e.this.l = null;
                    e.this.g(false);
                }
            } else if (this.f55103a) {
                e.this.l = null;
                e.this.g(false);
            }
        }

        public final void e(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            e.this.f55107c.clear();
            if (hashMap != null) {
                e.this.f55107c.putAll(hashMap);
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
                    d.b.c.e.m.f.b(TbadkCoreApplication.getInst().getContext(), intent);
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
        this.i.start();
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
        this.f55105a.clear();
        d.b.i0.e0.i.d.m().j();
        d.b.c.e.m.e.a().removeCallbacks(this.j);
        MessageManager.getInstance().unRegisterListener(this.f55110f);
        MessageManager.getInstance().unRegisterListener(this.f55111g);
        TbadkCoreApplication.getInst().unregisterReceiver(this.f55109e);
    }

    public void g(boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.B()) {
                d.b.c.e.m.e.a().post(new i(z));
            } else if (this.l == null && System.currentTimeMillis() - this.k >= 5000) {
                if (!z) {
                    this.k = System.currentTimeMillis();
                }
                j jVar = new j(z);
                this.l = jVar;
                jVar.execute(new HashSet(this.f55105a));
            }
        }
    }

    public String h(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f55105a.contains(str)) {
            String m2 = m(str, this.f55106b, z);
            return !TextUtils.isEmpty(m2) ? m2 : m(str, this.f55107c, z);
        }
        return null;
    }

    public final void j() {
        new h().execute(new HashSet(this.f55105a));
    }

    public void k() {
        j();
        d.b.c.e.m.e.a().removeCallbacks(this.j);
        d.b.c.e.m.e.a().postDelayed(this.j, 300000L);
    }

    public final void l(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            map = this.f55107c;
            map2 = this.f55108d;
        } else {
            map = this.f55108d;
            map2 = this.f55107c;
        }
        for (String str : map.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map2.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && d.b.i0.e0.h.a(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && d.b.i0.e0.h.a(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
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
            this.f55106b.put(str, arrayList);
        }
    }

    public final String m(String str, Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map, boolean z) {
        List<DnsProxyResponseData.DnsProxyIpData> list;
        if (!TextUtils.isEmpty(str) && map != null && (list = map.get(str)) != null && list.size() > 0) {
            if (list.size() == 1) {
                String ip = list.get(0).getIp();
                if (n.nextFloat() < d.b.i0.e0.i.d.m().k("c.tieba.baidu.com", ip)) {
                    return ip;
                }
            } else {
                if (z) {
                    Collections.sort(list, new a(this, str));
                } else {
                    Collections.sort(list, new b(this, str));
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && d.b.i0.e0.h.a(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (n.nextFloat() < d.b.i0.e0.i.d.m().k("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void n() {
        this.f55105a.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.f55110f);
            MessageManager.getInstance().registerListener(this.f55110f);
        }
        MessageManager.getInstance().unRegisterListener(this.f55111g);
        MessageManager.getInstance().registerListener(this.f55111g);
        d.b.i0.e0.i.d.m().t();
        d.b.c.e.m.e.a().post(new k());
        g(true);
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            return;
        }
        TbadkCoreApplication.getInst().unregisterReceiver(this.f55109e);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
        TbadkCoreApplication.getInst().registerReceiver(this.f55109e, intentFilter);
    }

    public void o(Runnable runnable) {
        if (runnable != null) {
            Handler handler = this.f55112h;
            if (handler == null) {
                if (this.i.getLooper() != null) {
                    Handler handler2 = new Handler(this.i.getLooper());
                    this.f55112h = handler2;
                    handler2.post(runnable);
                }
                d.b.c.e.m.e.a().postDelayed(new f(runnable), 100L);
                return;
            }
            handler.post(runnable);
        }
    }
}
