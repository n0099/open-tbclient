package d.a.o0.f0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import d.a.c.e.m.f;
import d.a.n0.z0.n;
import d.a.o0.f0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f58125f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f58126a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f58127b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.o0.f0.i.a> f58128c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.f0.i.a f58129d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58130e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f58132e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f58132e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f58132e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.a.o0.f0.i.a a2 = d.a.o0.f0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f58110e, a2);
                        }
                    }
                }
                synchronized (d.this.f58127b) {
                    if (d.this.f58128c == null) {
                        d.this.f58128c = new ConcurrentHashMap();
                    }
                    d.this.f58128c.clear();
                    d.this.f58128c.putAll(hashMap);
                }
                d.this.f58130e = true;
                d.this.s();
                ArrayList<d.a.o0.f0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f58128c.entrySet()) {
                    if (d.this.f58129d != entry.getValue() && System.currentTimeMillis() - ((d.a.o0.f0.i.a) entry.getValue()).f58108c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.a.o0.f0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.a.o0.f0.i.a aVar : arrayList) {
                    d.this.f58128c.remove(aVar.f58110e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f58136g;

        public c(String str, boolean z, boolean z2) {
            this.f58134e = str;
            this.f58135f = z;
            this.f58136g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f58129d != null) {
                d.a.o0.f0.i.b bVar = d.this.f58129d.f58106a.get(this.f58134e);
                if (bVar == null) {
                    bVar = new d.a.o0.f0.i.b();
                    bVar.f58111a = this.f58134e;
                    d.this.f58129d.f58106a.put(this.f58134e, bVar);
                }
                bVar.a(this.f58135f ? 1 : 0);
                synchronized (d.this.f58127b) {
                    hashMap = new HashMap(d.this.f58128c);
                }
                d.a.o0.f0.i.c.h().j(hashMap);
            }
            if (this.f58136g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f58134e);
                intent.putExtra("result", this.f58135f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.a.o0.f0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1366d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58139f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58140g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f58141h;

        public RunnableC1366d(String str, boolean z, int i2, boolean z2) {
            this.f58138e = str;
            this.f58139f = z;
            this.f58140g = i2;
            this.f58141h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f58129d == null) {
                String b2 = d.a.o0.f0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.a.o0.f0.i.a aVar = new d.a.o0.f0.i.a();
                    aVar.f58110e = b2;
                    d.this.f58129d = aVar;
                    d.this.f58128c.put(b2, aVar);
                }
            }
            if (d.this.f58129d != null) {
                d.a.o0.f0.i.b bVar = d.this.f58129d.f58106a.get(this.f58138e);
                if (bVar == null) {
                    bVar = new d.a.o0.f0.i.b();
                    bVar.f58111a = this.f58138e;
                    d.this.f58129d.f58106a.put(this.f58138e, bVar);
                }
                bVar.a(this.f58139f ? 1 : 0);
                if (this.f58139f) {
                    d.a.o0.f0.i.b bVar2 = d.this.f58129d.f58107b.get(this.f58138e);
                    if (bVar2 == null) {
                        bVar2 = new d.a.o0.f0.i.b();
                        bVar2.f58111a = this.f58138e;
                        d.this.f58129d.f58107b.put(this.f58138e, bVar2);
                    }
                    bVar2.a(this.f58140g);
                }
                synchronized (d.this.f58127b) {
                    hashMap = new HashMap(d.this.f58128c);
                }
                d.a.o0.f0.i.c.h().j(hashMap);
            }
            if (this.f58141h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f58138e);
                intent.putExtra("result", this.f58139f);
                intent.putExtra("speed", this.f58140g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f58125f == null) {
            synchronized (d.class) {
                if (f58125f == null) {
                    f58125f = new d();
                }
            }
        }
        return f58125f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f58126a);
    }

    public float k(String str, String str2) {
        d.a.o0.f0.i.a aVar;
        d.a.o0.f0.i.b bVar;
        if (!this.f58130e || (aVar = this.f58129d) == null || (bVar = aVar.f58106a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f58113c;
    }

    public float l(String str, String str2) {
        d.a.o0.f0.i.a aVar;
        d.a.o0.f0.i.b bVar;
        if (!this.f58130e || (aVar = this.f58129d) == null || (bVar = aVar.f58107b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f58113c;
    }

    public void n(String str, int i2, boolean z) {
        o(str, i2, z, true);
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        if (this.f58130e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1366d(str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f58130e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f58130e) {
            String b2 = d.a.o0.f0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f58128c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.o0.f0.i.a aVar = this.f58128c.get(b2);
            this.f58129d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.o0.f0.i.a aVar2 = this.f58129d;
            if (currentTimeMillis - aVar2.f58109d <= 3600000 || currentTimeMillis - aVar2.f58108c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f58126a);
            TbadkCoreApplication.getInst().registerReceiver(this.f58126a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f58126a);
            TbadkCoreApplication.getInst().registerReceiver(this.f58126a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f58130e) {
            return;
        }
        d.a.o0.f0.i.c.h().i(new b());
    }
}
