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
import d.b.b.e.m.f;
import d.b.h0.z0.n;
import d.b.i0.e0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f54262f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f54263a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f54264b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.b.i0.e0.i.a> f54265c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e0.i.a f54266d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54267e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f54269e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f54269e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f54269e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.b.i0.e0.i.a a2 = d.b.i0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f54247e, a2);
                        }
                    }
                }
                synchronized (d.this.f54264b) {
                    if (d.this.f54265c == null) {
                        d.this.f54265c = new ConcurrentHashMap();
                    }
                    d.this.f54265c.clear();
                    d.this.f54265c.putAll(hashMap);
                }
                d.this.f54267e = true;
                d.this.s();
                ArrayList<d.b.i0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f54265c.entrySet()) {
                    if (d.this.f54266d != entry.getValue() && System.currentTimeMillis() - ((d.b.i0.e0.i.a) entry.getValue()).f54245c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.b.i0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.b.i0.e0.i.a aVar : arrayList) {
                    d.this.f54265c.remove(aVar.f54247e);
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
        public final /* synthetic */ String f54271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f54273g;

        public c(String str, boolean z, boolean z2) {
            this.f54271e = str;
            this.f54272f = z;
            this.f54273g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54266d != null) {
                d.b.i0.e0.i.b bVar = d.this.f54266d.f54243a.get(this.f54271e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f54248a = this.f54271e;
                    d.this.f54266d.f54243a.put(this.f54271e, bVar);
                }
                bVar.a(this.f54272f ? 1 : 0);
                synchronized (d.this.f54264b) {
                    hashMap = new HashMap(d.this.f54265c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f54273g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54271e);
                intent.putExtra("result", this.f54272f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.b.i0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1229d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54277g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f54278h;

        public RunnableC1229d(String str, boolean z, int i, boolean z2) {
            this.f54275e = str;
            this.f54276f = z;
            this.f54277g = i;
            this.f54278h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54266d == null) {
                String b2 = d.b.i0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.b.i0.e0.i.a aVar = new d.b.i0.e0.i.a();
                    aVar.f54247e = b2;
                    d.this.f54266d = aVar;
                    d.this.f54265c.put(b2, aVar);
                }
            }
            if (d.this.f54266d != null) {
                d.b.i0.e0.i.b bVar = d.this.f54266d.f54243a.get(this.f54275e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f54248a = this.f54275e;
                    d.this.f54266d.f54243a.put(this.f54275e, bVar);
                }
                bVar.a(this.f54276f ? 1 : 0);
                if (this.f54276f) {
                    d.b.i0.e0.i.b bVar2 = d.this.f54266d.f54244b.get(this.f54275e);
                    if (bVar2 == null) {
                        bVar2 = new d.b.i0.e0.i.b();
                        bVar2.f54248a = this.f54275e;
                        d.this.f54266d.f54244b.put(this.f54275e, bVar2);
                    }
                    bVar2.a(this.f54277g);
                }
                synchronized (d.this.f54264b) {
                    hashMap = new HashMap(d.this.f54265c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f54278h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54275e);
                intent.putExtra("result", this.f54276f);
                intent.putExtra("speed", this.f54277g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f54262f == null) {
            synchronized (d.class) {
                if (f54262f == null) {
                    f54262f = new d();
                }
            }
        }
        return f54262f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f54263a);
    }

    public float k(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f54267e || (aVar = this.f54266d) == null || (bVar = aVar.f54243a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f54250c;
    }

    public float l(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f54267e || (aVar = this.f54266d) == null || (bVar = aVar.f54244b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f54250c;
    }

    public void n(String str, int i, boolean z) {
        o(str, i, z, true);
    }

    public final void o(String str, int i, boolean z, boolean z2) {
        if (this.f54267e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1229d(str, z, i, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f54267e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f54267e) {
            String b2 = d.b.i0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f54265c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.b.i0.e0.i.a aVar = this.f54265c.get(b2);
            this.f54266d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.b.i0.e0.i.a aVar2 = this.f54266d;
            if (currentTimeMillis - aVar2.f54246d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f54245c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54263a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54263a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54263a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54263a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f54267e) {
            return;
        }
        d.b.i0.e0.i.c.h().i(new b());
    }
}
