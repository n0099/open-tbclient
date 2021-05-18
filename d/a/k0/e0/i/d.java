package d.a.k0.e0.i;

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
import d.a.j0.z0.n;
import d.a.k0.e0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f54121f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f54122a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f54123b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.k0.e0.i.a> f54124c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.e0.i.a f54125d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54126e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f54128e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f54128e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f54128e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.a.k0.e0.i.a a2 = d.a.k0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f54106e, a2);
                        }
                    }
                }
                synchronized (d.this.f54123b) {
                    if (d.this.f54124c == null) {
                        d.this.f54124c = new ConcurrentHashMap();
                    }
                    d.this.f54124c.clear();
                    d.this.f54124c.putAll(hashMap);
                }
                d.this.f54126e = true;
                d.this.s();
                ArrayList<d.a.k0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f54124c.entrySet()) {
                    if (d.this.f54125d != entry.getValue() && System.currentTimeMillis() - ((d.a.k0.e0.i.a) entry.getValue()).f54104c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.a.k0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.a.k0.e0.i.a aVar : arrayList) {
                    d.this.f54124c.remove(aVar.f54106e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54131f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f54132g;

        public c(String str, boolean z, boolean z2) {
            this.f54130e = str;
            this.f54131f = z;
            this.f54132g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54125d != null) {
                d.a.k0.e0.i.b bVar = d.this.f54125d.f54102a.get(this.f54130e);
                if (bVar == null) {
                    bVar = new d.a.k0.e0.i.b();
                    bVar.f54107a = this.f54130e;
                    d.this.f54125d.f54102a.put(this.f54130e, bVar);
                }
                bVar.a(this.f54131f ? 1 : 0);
                synchronized (d.this.f54123b) {
                    hashMap = new HashMap(d.this.f54124c);
                }
                d.a.k0.e0.i.c.h().j(hashMap);
            }
            if (this.f54132g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54130e);
                intent.putExtra("result", this.f54131f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.a.k0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1288d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54136g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f54137h;

        public RunnableC1288d(String str, boolean z, int i2, boolean z2) {
            this.f54134e = str;
            this.f54135f = z;
            this.f54136g = i2;
            this.f54137h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54125d == null) {
                String b2 = d.a.k0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.a.k0.e0.i.a aVar = new d.a.k0.e0.i.a();
                    aVar.f54106e = b2;
                    d.this.f54125d = aVar;
                    d.this.f54124c.put(b2, aVar);
                }
            }
            if (d.this.f54125d != null) {
                d.a.k0.e0.i.b bVar = d.this.f54125d.f54102a.get(this.f54134e);
                if (bVar == null) {
                    bVar = new d.a.k0.e0.i.b();
                    bVar.f54107a = this.f54134e;
                    d.this.f54125d.f54102a.put(this.f54134e, bVar);
                }
                bVar.a(this.f54135f ? 1 : 0);
                if (this.f54135f) {
                    d.a.k0.e0.i.b bVar2 = d.this.f54125d.f54103b.get(this.f54134e);
                    if (bVar2 == null) {
                        bVar2 = new d.a.k0.e0.i.b();
                        bVar2.f54107a = this.f54134e;
                        d.this.f54125d.f54103b.put(this.f54134e, bVar2);
                    }
                    bVar2.a(this.f54136g);
                }
                synchronized (d.this.f54123b) {
                    hashMap = new HashMap(d.this.f54124c);
                }
                d.a.k0.e0.i.c.h().j(hashMap);
            }
            if (this.f54137h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54134e);
                intent.putExtra("result", this.f54135f);
                intent.putExtra("speed", this.f54136g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f54121f == null) {
            synchronized (d.class) {
                if (f54121f == null) {
                    f54121f = new d();
                }
            }
        }
        return f54121f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f54122a);
    }

    public float k(String str, String str2) {
        d.a.k0.e0.i.a aVar;
        d.a.k0.e0.i.b bVar;
        if (!this.f54126e || (aVar = this.f54125d) == null || (bVar = aVar.f54102a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f54109c;
    }

    public float l(String str, String str2) {
        d.a.k0.e0.i.a aVar;
        d.a.k0.e0.i.b bVar;
        if (!this.f54126e || (aVar = this.f54125d) == null || (bVar = aVar.f54103b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f54109c;
    }

    public void n(String str, int i2, boolean z) {
        o(str, i2, z, true);
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        if (this.f54126e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1288d(str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f54126e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f54126e) {
            String b2 = d.a.k0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f54124c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.k0.e0.i.a aVar = this.f54124c.get(b2);
            this.f54125d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.k0.e0.i.a aVar2 = this.f54125d;
            if (currentTimeMillis - aVar2.f54105d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f54104c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54122a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54122a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54122a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54122a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f54126e) {
            return;
        }
        d.a.k0.e0.i.c.h().i(new b());
    }
}
