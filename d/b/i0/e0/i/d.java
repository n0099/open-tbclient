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
    public static d f54261f;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f54262a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Object f54263b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.b.i0.e0.i.a> f54264c = null;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e0.i.a f54265d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54266e = false;

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
            public final /* synthetic */ WriteHistroyDataReqIdl f54268e;

            public a(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                this.f54268e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f54268e;
                if (writeHistroyDataReqIdl != null) {
                    for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                        d.b.i0.e0.i.a a2 = d.b.i0.e0.i.a.a(connectPointData);
                        if (a2 != null) {
                            hashMap.put(a2.f54246e, a2);
                        }
                    }
                }
                synchronized (d.this.f54263b) {
                    if (d.this.f54264c == null) {
                        d.this.f54264c = new ConcurrentHashMap();
                    }
                    d.this.f54264c.clear();
                    d.this.f54264c.putAll(hashMap);
                }
                d.this.f54266e = true;
                d.this.s();
                ArrayList<d.b.i0.e0.i.a> arrayList = new ArrayList();
                for (Map.Entry entry : d.this.f54264c.entrySet()) {
                    if (d.this.f54265d != entry.getValue() && System.currentTimeMillis() - ((d.b.i0.e0.i.a) entry.getValue()).f54244c > 604800000) {
                        arrayList.add(entry.getValue());
                        d.b.i0.e0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                    }
                }
                for (d.b.i0.e0.i.a aVar : arrayList) {
                    d.this.f54264c.remove(aVar.f54246e);
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
        public final /* synthetic */ String f54270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54271f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f54272g;

        public c(String str, boolean z, boolean z2) {
            this.f54270e = str;
            this.f54271f = z;
            this.f54272g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54265d != null) {
                d.b.i0.e0.i.b bVar = d.this.f54265d.f54242a.get(this.f54270e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f54247a = this.f54270e;
                    d.this.f54265d.f54242a.put(this.f54270e, bVar);
                }
                bVar.a(this.f54271f ? 1 : 0);
                synchronized (d.this.f54263b) {
                    hashMap = new HashMap(d.this.f54264c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f54272g) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54270e);
                intent.putExtra("result", this.f54271f);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    /* renamed from: d.b.i0.e0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1228d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54275f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54276g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f54277h;

        public RunnableC1228d(String str, boolean z, int i, boolean z2) {
            this.f54274e = str;
            this.f54275f = z;
            this.f54276g = i;
            this.f54277h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            if (d.this.f54265d == null) {
                String b2 = d.b.i0.e0.i.a.b();
                if (!TextUtils.isEmpty(b2)) {
                    d.b.i0.e0.i.a aVar = new d.b.i0.e0.i.a();
                    aVar.f54246e = b2;
                    d.this.f54265d = aVar;
                    d.this.f54264c.put(b2, aVar);
                }
            }
            if (d.this.f54265d != null) {
                d.b.i0.e0.i.b bVar = d.this.f54265d.f54242a.get(this.f54274e);
                if (bVar == null) {
                    bVar = new d.b.i0.e0.i.b();
                    bVar.f54247a = this.f54274e;
                    d.this.f54265d.f54242a.put(this.f54274e, bVar);
                }
                bVar.a(this.f54275f ? 1 : 0);
                if (this.f54275f) {
                    d.b.i0.e0.i.b bVar2 = d.this.f54265d.f54243b.get(this.f54274e);
                    if (bVar2 == null) {
                        bVar2 = new d.b.i0.e0.i.b();
                        bVar2.f54247a = this.f54274e;
                        d.this.f54265d.f54243b.put(this.f54274e, bVar2);
                    }
                    bVar2.a(this.f54276g);
                }
                synchronized (d.this.f54263b) {
                    hashMap = new HashMap(d.this.f54264c);
                }
                d.b.i0.e0.i.c.h().j(hashMap);
            }
            if (this.f54277h) {
                Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                intent.putExtra("ip", this.f54274e);
                intent.putExtra("result", this.f54275f);
                intent.putExtra("speed", this.f54276g);
                f.b(TbadkCoreApplication.getInst().getContext(), intent);
            }
        }
    }

    public static final d m() {
        if (f54261f == null) {
            synchronized (d.class) {
                if (f54261f == null) {
                    f54261f = new d();
                }
            }
        }
        return f54261f;
    }

    public void j() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.f54262a);
    }

    public float k(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f54266e || (aVar = this.f54265d) == null || (bVar = aVar.f54242a.get(str2)) == null) {
            return 0.0f;
        }
        return bVar.f54249c;
    }

    public float l(String str, String str2) {
        d.b.i0.e0.i.a aVar;
        d.b.i0.e0.i.b bVar;
        if (!this.f54266e || (aVar = this.f54265d) == null || (bVar = aVar.f54243b.get(str2)) == null) {
            return 10000.0f;
        }
        return bVar.f54249c;
    }

    public void n(String str, int i, boolean z) {
        o(str, i, z, true);
    }

    public final void o(String str, int i, boolean z, boolean z2) {
        if (this.f54266e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1228d(str, z, i, z2));
        }
    }

    public void p(String str, boolean z) {
        q(str, z, true);
    }

    public final void q(String str, boolean z, boolean z2) {
        if (this.f54266e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(str, z, z2));
        }
    }

    public void r() {
        s();
    }

    public final void s() {
        if (this.f54266e) {
            String b2 = d.b.i0.e0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f54264c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            d.b.i0.e0.i.a aVar = this.f54264c.get(b2);
            this.f54265d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            d.b.i0.e0.i.a aVar2 = this.f54265d;
            if (currentTimeMillis - aVar2.f54245d <= VideoCloudSetting.HOUR_MILLISECOND || currentTimeMillis - aVar2.f54244c >= VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54262a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54262a, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f54262a);
            TbadkCoreApplication.getInst().registerReceiver(this.f54262a, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (this.f54266e) {
            return;
        }
        d.b.i0.e0.i.c.h().i(new b());
    }
}
