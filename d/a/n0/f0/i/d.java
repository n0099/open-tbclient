package d.a.n0.f0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
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
    public static d f58000f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f58001a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f58002b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.n0.f0.i.a> f58003c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.f0.i.a f58004d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58005e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f58007e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f58007e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f58007e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.a.n0.f0.i.a a2 = d.a.n0.f0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f57985e, a2);
                        }
                    }
                }
                synchronized (d.this.f58002b) {
                    if (d.this.f58003c == null) {
                        d.this.f58003c = new ConcurrentHashMap();
                    }
                    d.this.f58003c.clear();
                    d.this.f58003c.putAll(hashMap);
                }
                d.this.f58005e = true;
                d.this.s();
                ArrayList<d.a.n0.f0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f58003c.entrySet()) {
                    if (d.this.f58004d != entry.getValue() && System.currentTimeMillis() - ((d.a.n0.f0.i.a) entry.getValue()).f57983c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.a.n0.f0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.a.n0.f0.i.a aVar : arrayList) {
                    d.this.f58003c.remove(aVar.f57985e);
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
        public final /* synthetic */ String f58009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f58011g;

        public c(String str, boolean z, boolean z2) {
            this.f58009e = str;
            this.f58010f = z;
            this.f58011g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f58004d != null) {
                d.a.n0.f0.i.b bVar = d.this.f58004d.f57981a.get(this.f58009e);
                if (bVar == null) {
                    bVar = new d.a.n0.f0.i.b();
                    bVar.f57986a = this.f58009e;
                    d.this.f58004d.f57981a.put(this.f58009e, bVar);
                }
                bVar.a(this.f58010f ? 1 : 0);
                synchronized (d.this.f58002b) {
                    hashMap = new HashMap(d.this.f58003c);
                }
                d.a.n0.f0.i.c.h().j(hashMap);
            }
            if (this.f58011g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f58009e);
                intent.putExtra("result", this.f58010f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.a.n0.f0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1362d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58013e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58014f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58015g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f58016h;

        public RunnableC1362d(String str, boolean z, int i2, boolean z2) {
            this.f58013e = str;
            this.f58014f = z;
            this.f58015g = i2;
            this.f58016h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f58004d == null) {
                String b2 = d.a.n0.f0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.a.n0.f0.i.a aVar = new d.a.n0.f0.i.a();
                    aVar.f57985e = b2;
                    d.this.f58004d = aVar;
                    d.this.f58003c.put(b2, aVar);
                }
            }
            if (d.this.f58004d != null) {
                d.a.n0.f0.i.b bVar = d.this.f58004d.f57981a.get(this.f58013e);
                if (bVar == null) {
                    bVar = new d.a.n0.f0.i.b();
                    bVar.f57986a = this.f58013e;
                    d.this.f58004d.f57981a.put(this.f58013e, bVar);
                }
                bVar.a(this.f58014f ? 1 : 0);
                if (this.f58014f) {
                    d.a.n0.f0.i.b bVar2 = d.this.f58004d.f57982b.get(this.f58013e);
                    if (bVar2 == null) {
                        bVar2 = new d.a.n0.f0.i.b();
                        bVar2.f57986a = this.f58013e;
                        d.this.f58004d.f57982b.put(this.f58013e, bVar2);
                    }
                    bVar2.a(this.f58015g);
                }
                synchronized (d.this.f58002b) {
                    hashMap = new HashMap(d.this.f58003c);
                }
                d.a.n0.f0.i.c.h().j(hashMap);
            }
            if (this.f58016h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f58013e);
                intent.putExtra("result", this.f58014f);
                intent.putExtra("speed", this.f58015g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f58000f == null) {
            synchronized (d.class) {
                if (f58000f == null) {
                    f58000f = new d();
                }
            }
        }
        return f58000f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f58001a);
    }

    public float k(String str, String str2) {
        d.a.n0.f0.i.a aVar;
        d.a.n0.f0.i.b bVar;
        if (!this.f58005e || (aVar = this.f58004d) == null || (bVar = aVar.f57981a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f57988c;
    }

    public float l(String str, String str2) {
        d.a.n0.f0.i.a aVar;
        d.a.n0.f0.i.b bVar;
        if (!this.f58005e || (aVar = this.f58004d) == null || (bVar = aVar.f57982b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f57988c;
    }

    public void n(String str, int i2, boolean z) {
        o(str, i2, z, true);
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        if (this.f58005e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1362d(str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f58005e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f58005e) {
            String b2 = d.a.n0.f0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f58003c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.n0.f0.i.a aVar = this.f58003c.get(b2);
            this.f58004d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.n0.f0.i.a aVar2 = this.f58004d;
            if (currentTimeMillis - aVar2.f57984d <= 3600000 || currentTimeMillis - aVar2.f57983c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f58001a);
            TbadkCoreApplication.getInst().registerReceiver(this.f58001a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f58001a);
            TbadkCoreApplication.getInst().registerReceiver(this.f58001a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f58005e) {
            return;
        }
        d.a.n0.f0.i.c.h().i(new b());
    }
}
