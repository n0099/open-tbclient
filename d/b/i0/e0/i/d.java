package d.b.i0.e0.i;

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
import d.b.h0.z0.n;
import d.b.i0.e0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f55145f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f55146a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f55147b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.b.i0.e0.i.a> f55148c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e0.i.a f55149d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55150e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f55152e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f55152e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f55152e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.b.i0.e0.i.a a2 = d.b.i0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f55130e, a2);
                        }
                    }
                }
                synchronized (d.this.f55147b) {
                    if (d.this.f55148c == null) {
                        d.this.f55148c = new ConcurrentHashMap();
                    }
                    d.this.f55148c.clear();
                    d.this.f55148c.putAll(hashMap);
                }
                d.this.f55150e = true;
                d.this.s();
                ArrayList<d.b.i0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f55148c.entrySet()) {
                    if (d.this.f55149d != entry.getValue() && System.currentTimeMillis() - ((d.b.i0.e0.i.a) entry.getValue()).f55128c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.b.i0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.b.i0.e0.i.a aVar : arrayList) {
                    d.this.f55148c.remove(aVar.f55130e);
                }
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            e.i().o(new a(writeHistroyDataReqIdl));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55155f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f55156g;

        public c(String str, boolean z, boolean z2) {
            this.f55154e = str;
            this.f55155f = z;
            this.f55156g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f55149d != null) {
                d.b.i0.e0.i.b bVar = d.this.f55149d.f55126a.get(this.f55154e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f55131a = this.f55154e;
                    d.this.f55149d.f55126a.put(this.f55154e, bVar);
                }
                bVar.a(this.f55155f ? 1 : 0);
                synchronized (d.this.f55147b) {
                    hashMap = new HashMap(d.this.f55148c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f55156g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f55154e);
                intent.putExtra("result", this.f55155f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.b.i0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1254d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f55159f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55160g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f55161h;

        public RunnableC1254d(String str, boolean z, int i, boolean z2) {
            this.f55158e = str;
            this.f55159f = z;
            this.f55160g = i;
            this.f55161h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f55149d == null) {
                String b2 = d.b.i0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.b.i0.e0.i.a aVar = new d.b.i0.e0.i.a();
                    aVar.f55130e = b2;
                    d.this.f55149d = aVar;
                    d.this.f55148c.put(b2, aVar);
                }
            }
            if (d.this.f55149d != null) {
                d.b.i0.e0.i.b bVar = d.this.f55149d.f55126a.get(this.f55158e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f55131a = this.f55158e;
                    d.this.f55149d.f55126a.put(this.f55158e, bVar);
                }
                bVar.a(this.f55159f ? 1 : 0);
                if (this.f55159f) {
                    d.b.i0.e0.i.b bVar2 = d.this.f55149d.f55127b.get(this.f55158e);
                    if (bVar2 == null) {
                        bVar2 = new d.b.i0.e0.i.b();
                        bVar2.f55131a = this.f55158e;
                        d.this.f55149d.f55127b.put(this.f55158e, bVar2);
                    }
                    bVar2.a(this.f55160g);
                }
                synchronized (d.this.f55147b) {
                    hashMap = new HashMap(d.this.f55148c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f55161h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f55158e);
                intent.putExtra("result", this.f55159f);
                intent.putExtra("speed", this.f55160g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f55145f == null) {
            synchronized (d.class) {
                if (f55145f == null) {
                    f55145f = new d();
                }
            }
        }
        return f55145f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f55146a);
    }

    public float k(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f55150e || (aVar = this.f55149d) == null || (bVar = aVar.f55126a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f55133c;
    }

    public float l(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f55150e || (aVar = this.f55149d) == null || (bVar = aVar.f55127b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f55133c;
    }

    public void n(String str, int i, boolean z) {
        o(str, i, z, true);
    }

    public final void o(String str, int i, boolean z, boolean z2) {
        if (this.f55150e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1254d(str, z, i, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f55150e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f55150e) {
            String b2 = d.b.i0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f55148c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.b.i0.e0.i.a aVar = this.f55148c.get(b2);
            this.f55149d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.b.i0.e0.i.a aVar2 = this.f55149d;
            if (currentTimeMillis - aVar2.f55129d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f55128c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f55146a);
            TbadkCoreApplication.getInst().registerReceiver(this.f55146a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f55146a);
            TbadkCoreApplication.getInst().registerReceiver(this.f55146a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f55150e) {
            return;
        }
        d.b.i0.e0.i.c.h().i(new b());
    }
}
