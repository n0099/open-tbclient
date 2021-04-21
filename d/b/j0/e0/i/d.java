package d.b.j0.e0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.c.e.m.f;
import d.b.i0.z0.n;
import d.b.j0.e0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f55566f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f55567a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f55568b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.b.j0.e0.i.a> f55569c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.e0.i.a f55570d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55571e = false;

    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (intExtra == -1) {
                    d.this.q(stringExtra, booleanExtra, false);
                } else {
                    d.this.o(stringExtra, intExtra, booleanExtra, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<WriteHistroyDataReqIdl> {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f55573e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f55573e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f55573e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.b.j0.e0.i.a a2 = d.b.j0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f55551e, a2);
                        }
                    }
                }
                synchronized (d.this.f55568b) {
                    if (d.this.f55569c == null) {
                        d.this.f55569c = new ConcurrentHashMap();
                    }
                    d.this.f55569c.clear();
                    d.this.f55569c.putAll(hashMap);
                }
                d.this.f55571e = true;
                d.this.s();
                ArrayList<d.b.j0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f55569c.entrySet()) {
                    if (d.this.f55570d != entry.getValue() && System.currentTimeMillis() - ((d.b.j0.e0.i.a) entry.getValue()).f55549c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.b.j0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.b.j0.e0.i.a aVar : arrayList) {
                    d.this.f55569c.remove(aVar.f55551e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55575e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55576f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f55577g;

        public c(String str, boolean z, boolean z2) {
            this.f55575e = str;
            this.f55576f = z;
            this.f55577g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f55570d != null) {
                d.b.j0.e0.i.b bVar = d.this.f55570d.f55547a.get(this.f55575e);
                if (bVar == null) {
                    bVar = new d.b.j0.e0.i.b();
                    bVar.f55552a = this.f55575e;
                    d.this.f55570d.f55547a.put(this.f55575e, bVar);
                }
                bVar.a(this.f55576f ? 1 : 0);
                synchronized (d.this.f55568b) {
                    hashMap = new HashMap(d.this.f55569c);
                }
                d.b.j0.e0.i.c.h().j(hashMap);
            }
            if (this.f55577g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f55575e);
                intent.putExtra("result", this.f55576f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.b.j0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1277d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55579e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55580f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55581g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f55582h;

        public RunnableC1277d(String str, boolean z, int i, boolean z2) {
            this.f55579e = str;
            this.f55580f = z;
            this.f55581g = i;
            this.f55582h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f55570d == null) {
                String b2 = d.b.j0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.b.j0.e0.i.a aVar = new d.b.j0.e0.i.a();
                    aVar.f55551e = b2;
                    d.this.f55570d = aVar;
                    d.this.f55569c.put(b2, aVar);
                }
            }
            if (d.this.f55570d != null) {
                d.b.j0.e0.i.b bVar = d.this.f55570d.f55547a.get(this.f55579e);
                if (bVar == null) {
                    bVar = new d.b.j0.e0.i.b();
                    bVar.f55552a = this.f55579e;
                    d.this.f55570d.f55547a.put(this.f55579e, bVar);
                }
                bVar.a(this.f55580f ? 1 : 0);
                if (this.f55580f) {
                    d.b.j0.e0.i.b bVar2 = d.this.f55570d.f55548b.get(this.f55579e);
                    if (bVar2 == null) {
                        bVar2 = new d.b.j0.e0.i.b();
                        bVar2.f55552a = this.f55579e;
                        d.this.f55570d.f55548b.put(this.f55579e, bVar2);
                    }
                    bVar2.a(this.f55581g);
                }
                synchronized (d.this.f55568b) {
                    hashMap = new HashMap(d.this.f55569c);
                }
                d.b.j0.e0.i.c.h().j(hashMap);
            }
            if (this.f55582h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f55579e);
                intent.putExtra("result", this.f55580f);
                intent.putExtra("speed", this.f55581g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f55566f == null) {
            synchronized (d.class) {
                if (f55566f == null) {
                    f55566f = new d();
                }
            }
        }
        return f55566f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f55567a);
    }

    public float k(String str, String str2) {
        d.b.j0.e0.i.a aVar;
        d.b.j0.e0.i.b bVar;
        if (!this.f55571e || (aVar = this.f55570d) == null || (bVar = aVar.f55547a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f55554c;
    }

    public float l(String str, String str2) {
        d.b.j0.e0.i.a aVar;
        d.b.j0.e0.i.b bVar;
        if (!this.f55571e || (aVar = this.f55570d) == null || (bVar = aVar.f55548b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f55554c;
    }

    public void n(String str, int i, boolean z) {
        o(str, i, z, true);
    }

    public final void o(String str, int i, boolean z, boolean z2) {
        if (this.f55571e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1277d(str, z, i, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f55571e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f55571e) {
            String b2 = d.b.j0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f55569c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.b.j0.e0.i.a aVar = this.f55569c.get(b2);
            this.f55570d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.b.j0.e0.i.a aVar2 = this.f55570d;
            if (currentTimeMillis - aVar2.f55550d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f55549c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f55567a);
            TbadkCoreApplication.getInst().registerReceiver(this.f55567a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f55567a);
            TbadkCoreApplication.getInst().registerReceiver(this.f55567a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f55571e) {
            return;
        }
        d.b.j0.e0.i.c.h().i(new b());
    }
}
