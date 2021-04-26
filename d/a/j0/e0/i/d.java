package d.a.j0.e0.i;

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
import d.a.i0.z0.n;
import d.a.j0.e0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f53414f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f53415a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f53416b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.j0.e0.i.a> f53417c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.e0.i.a f53418d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53419e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f53421e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f53421e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f53421e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.a.j0.e0.i.a a2 = d.a.j0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f53399e, a2);
                        }
                    }
                }
                synchronized (d.this.f53416b) {
                    if (d.this.f53417c == null) {
                        d.this.f53417c = new ConcurrentHashMap();
                    }
                    d.this.f53417c.clear();
                    d.this.f53417c.putAll(hashMap);
                }
                d.this.f53419e = true;
                d.this.s();
                ArrayList<d.a.j0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f53417c.entrySet()) {
                    if (d.this.f53418d != entry.getValue() && System.currentTimeMillis() - ((d.a.j0.e0.i.a) entry.getValue()).f53397c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.a.j0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.a.j0.e0.i.a aVar : arrayList) {
                    d.this.f53417c.remove(aVar.f53399e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f53424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f53425g;

        public c(String str, boolean z, boolean z2) {
            this.f53423e = str;
            this.f53424f = z;
            this.f53425g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f53418d != null) {
                d.a.j0.e0.i.b bVar = d.this.f53418d.f53395a.get(this.f53423e);
                if (bVar == null) {
                    bVar = new d.a.j0.e0.i.b();
                    bVar.f53400a = this.f53423e;
                    d.this.f53418d.f53395a.put(this.f53423e, bVar);
                }
                bVar.a(this.f53424f ? 1 : 0);
                synchronized (d.this.f53416b) {
                    hashMap = new HashMap(d.this.f53417c);
                }
                d.a.j0.e0.i.c.h().j(hashMap);
            }
            if (this.f53425g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f53423e);
                intent.putExtra("result", this.f53424f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.a.j0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1216d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f53428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53429g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f53430h;

        public RunnableC1216d(String str, boolean z, int i2, boolean z2) {
            this.f53427e = str;
            this.f53428f = z;
            this.f53429g = i2;
            this.f53430h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f53418d == null) {
                String b2 = d.a.j0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.a.j0.e0.i.a aVar = new d.a.j0.e0.i.a();
                    aVar.f53399e = b2;
                    d.this.f53418d = aVar;
                    d.this.f53417c.put(b2, aVar);
                }
            }
            if (d.this.f53418d != null) {
                d.a.j0.e0.i.b bVar = d.this.f53418d.f53395a.get(this.f53427e);
                if (bVar == null) {
                    bVar = new d.a.j0.e0.i.b();
                    bVar.f53400a = this.f53427e;
                    d.this.f53418d.f53395a.put(this.f53427e, bVar);
                }
                bVar.a(this.f53428f ? 1 : 0);
                if (this.f53428f) {
                    d.a.j0.e0.i.b bVar2 = d.this.f53418d.f53396b.get(this.f53427e);
                    if (bVar2 == null) {
                        bVar2 = new d.a.j0.e0.i.b();
                        bVar2.f53400a = this.f53427e;
                        d.this.f53418d.f53396b.put(this.f53427e, bVar2);
                    }
                    bVar2.a(this.f53429g);
                }
                synchronized (d.this.f53416b) {
                    hashMap = new HashMap(d.this.f53417c);
                }
                d.a.j0.e0.i.c.h().j(hashMap);
            }
            if (this.f53430h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f53427e);
                intent.putExtra("result", this.f53428f);
                intent.putExtra("speed", this.f53429g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f53414f == null) {
            synchronized (d.class) {
                if (f53414f == null) {
                    f53414f = new d();
                }
            }
        }
        return f53414f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f53415a);
    }

    public float k(String str, String str2) {
        d.a.j0.e0.i.a aVar;
        d.a.j0.e0.i.b bVar;
        if (!this.f53419e || (aVar = this.f53418d) == null || (bVar = aVar.f53395a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f53402c;
    }

    public float l(String str, String str2) {
        d.a.j0.e0.i.a aVar;
        d.a.j0.e0.i.b bVar;
        if (!this.f53419e || (aVar = this.f53418d) == null || (bVar = aVar.f53396b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f53402c;
    }

    public void n(String str, int i2, boolean z) {
        o(str, i2, z, true);
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        if (this.f53419e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1216d(str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f53419e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f53419e) {
            String b2 = d.a.j0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f53417c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.a.j0.e0.i.a aVar = this.f53417c.get(b2);
            this.f53418d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.a.j0.e0.i.a aVar2 = this.f53418d;
            if (currentTimeMillis - aVar2.f53398d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f53397c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f53415a);
            TbadkCoreApplication.getInst().registerReceiver(this.f53415a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f53415a);
            TbadkCoreApplication.getInst().registerReceiver(this.f53415a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f53419e) {
            return;
        }
        d.a.j0.e0.i.c.h().i(new b());
    }
}
