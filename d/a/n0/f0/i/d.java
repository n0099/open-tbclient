package d.a.n0.f0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.c.e.m.f;
import d.a.m0.z0.n;
import d.a.n0.f0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f54311f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f54312a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f54313b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.n0.f0.i.a> f54314c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.f0.i.a f54315d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54316e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f54318e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f54318e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f54318e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.a.n0.f0.i.a a2 = d.a.n0.f0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f54296e, a2);
                        }
                    }
                }
                synchronized (d.this.f54313b) {
                    if (d.this.f54314c == null) {
                        d.this.f54314c = new ConcurrentHashMap();
                    }
                    d.this.f54314c.clear();
                    d.this.f54314c.putAll(hashMap);
                }
                d.this.f54316e = true;
                d.this.s();
                ArrayList<d.a.n0.f0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f54314c.entrySet()) {
                    if (d.this.f54315d != entry.getValue() && System.currentTimeMillis() - ((d.a.n0.f0.i.a) entry.getValue()).f54294c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.a.n0.f0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.a.n0.f0.i.a aVar : arrayList) {
                    d.this.f54314c.remove(aVar.f54296e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54321f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f54322g;

        public c(String str, boolean z, boolean z2) {
            this.f54320e = str;
            this.f54321f = z;
            this.f54322g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54315d != null) {
                d.a.n0.f0.i.b bVar = d.this.f54315d.f54292a.get(this.f54320e);
                if (bVar == null) {
                    bVar = new d.a.n0.f0.i.b();
                    bVar.f54297a = this.f54320e;
                    d.this.f54315d.f54292a.put(this.f54320e, bVar);
                }
                bVar.a(this.f54321f ? 1 : 0);
                synchronized (d.this.f54313b) {
                    hashMap = new HashMap(d.this.f54314c);
                }
                d.a.n0.f0.i.c.h().j(hashMap);
            }
            if (this.f54322g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54320e);
                intent.putExtra("result", this.f54321f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.a.n0.f0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1306d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54325f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54326g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f54327h;

        public RunnableC1306d(String str, boolean z, int i2, boolean z2) {
            this.f54324e = str;
            this.f54325f = z;
            this.f54326g = i2;
            this.f54327h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54315d == null) {
                String b2 = d.a.n0.f0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.a.n0.f0.i.a aVar = new d.a.n0.f0.i.a();
                    aVar.f54296e = b2;
                    d.this.f54315d = aVar;
                    d.this.f54314c.put(b2, aVar);
                }
            }
            if (d.this.f54315d != null) {
                d.a.n0.f0.i.b bVar = d.this.f54315d.f54292a.get(this.f54324e);
                if (bVar == null) {
                    bVar = new d.a.n0.f0.i.b();
                    bVar.f54297a = this.f54324e;
                    d.this.f54315d.f54292a.put(this.f54324e, bVar);
                }
                bVar.a(this.f54325f ? 1 : 0);
                if (this.f54325f) {
                    d.a.n0.f0.i.b bVar2 = d.this.f54315d.f54293b.get(this.f54324e);
                    if (bVar2 == null) {
                        bVar2 = new d.a.n0.f0.i.b();
                        bVar2.f54297a = this.f54324e;
                        d.this.f54315d.f54293b.put(this.f54324e, bVar2);
                    }
                    bVar2.a(this.f54326g);
                }
                synchronized (d.this.f54313b) {
                    hashMap = new HashMap(d.this.f54314c);
                }
                d.a.n0.f0.i.c.h().j(hashMap);
            }
            if (this.f54327h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54324e);
                intent.putExtra("result", this.f54325f);
                intent.putExtra("speed", this.f54326g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f54311f == null) {
            synchronized (d.class) {
                if (f54311f == null) {
                    f54311f = new d();
                }
            }
        }
        return f54311f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f54312a);
    }

    public float k(String str, String str2) {
        d.a.n0.f0.i.a aVar;
        d.a.n0.f0.i.b bVar;
        if (!this.f54316e || (aVar = this.f54315d) == null || (bVar = aVar.f54292a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f54299c;
    }

    public float l(String str, String str2) {
        d.a.n0.f0.i.a aVar;
        d.a.n0.f0.i.b bVar;
        if (!this.f54316e || (aVar = this.f54315d) == null || (bVar = aVar.f54293b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f54299c;
    }

    public void n(String str, int i2, boolean z) {
        o(str, i2, z, true);
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        if (this.f54316e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1306d(str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f54316e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f54316e) {
            String b2 = d.a.n0.f0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f54314c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.n0.f0.i.a aVar = this.f54314c.get(b2);
            this.f54315d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.n0.f0.i.a aVar2 = this.f54315d;
            if (currentTimeMillis - aVar2.f54295d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f54294c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54312a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54312a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54312a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54312a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f54316e) {
            return;
        }
        d.a.n0.f0.i.c.h().i(new b());
    }
}
