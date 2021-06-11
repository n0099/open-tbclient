package d.a.j0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mapapi.UIMsg;
import d.a.j0.a;
import d.a.j0.l.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f43983g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43985b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f43986c;

    /* renamed from: d  reason: collision with root package name */
    public Context f43987d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f43984a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f43988e = -1;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0605a> f43989f = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0605a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f43990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f43991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f43992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f43993d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0605a f43994e;

        public a(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0605a interfaceC0605a) {
            this.f43990a = iVar;
            this.f43991b = context;
            this.f43992c = i2;
            this.f43993d = j;
            this.f43994e = interfaceC0605a;
        }

        @Override // d.a.j0.a.InterfaceC0605a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f43990a.i(this.f43991b, this.f43992c, this.f43993d);
                    return;
                }
                if (this.f43994e != null) {
                    this.f43994e.onFinish(str);
                }
                d.a.j0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0605a interfaceC0605a = this.f43994e;
                if (interfaceC0605a != null) {
                    interfaceC0605a.onFinish(str);
                }
                d.a.j0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0605a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f43995a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f43996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f43997c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f43998d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0605a f43999e;

        public b(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0605a interfaceC0605a) {
            this.f43995a = iVar;
            this.f43996b = context;
            this.f43997c = i2;
            this.f43998d = j;
            this.f43999e = interfaceC0605a;
        }

        @Override // d.a.j0.a.InterfaceC0605a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f43995a.p(this.f43996b, this.f43997c, this.f43998d);
                    return;
                }
                if (this.f43999e != null) {
                    this.f43999e.onFinish(str);
                }
                d.a.j0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0605a interfaceC0605a = this.f43999e;
                if (interfaceC0605a != null) {
                    interfaceC0605a.onFinish(str);
                }
                d.a.j0.c.a.c().m(false);
            }
        }
    }

    public static c j() {
        if (f43983g == null) {
            synchronized (c.class) {
                if (f43983g == null) {
                    f43983g = new c();
                }
            }
        }
        return f43983g;
    }

    public int a() {
        return this.f43988e;
    }

    public final int b(int i2, int i3) {
        if (this.f43984a.size() == 1) {
            return Integer.valueOf(this.f43984a.get(this.f43984a.keySet().iterator().next()).f44060c).intValue();
        }
        return (this.f43984a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, d.a.j0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0605a> b2 = d.a.j0.c.a.c().b(i2);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i2);
            h((a.InterfaceC0605a) b2.second, new h(i3, i4, i5, str), bVar.f43979a, z);
            if (i3 == 1) {
                bVar.f43980b = 1;
            }
            if (z) {
                int i6 = bVar.f43979a;
                if (i6 == 1) {
                    d.a.j0.h.d.e(this.f43987d, i5, bVar.f43980b, i4, str);
                } else if (i6 == 3) {
                    d.a.j0.h.d.b(this.f43987d, i5, bVar.f43980b, i4, str);
                } else if (i6 == 2) {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.j0.b.a.h(this.f43987d).A(System.currentTimeMillis());
                        d.a.j0.b.a.h(this.f43987d).k(i4);
                    }
                    d.a.j0.h.d.a(this.f43987d, i5, i3, i4, bVar.f43981c, bVar.f43982d);
                } else {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.j0.b.a.h(this.f43987d).K(System.currentTimeMillis());
                        d.a.j0.b.a.h(this.f43987d).q(i4);
                    }
                    d.a.j0.h.d.d(this.f43987d, i5, i3, i4, bVar.f43981c, bVar.f43982d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f43985b) {
                return;
            }
            this.f43987d = context.getApplicationContext();
            d.a.j0.m.a.b().a(this.f43987d, null);
            boolean z = false;
            if (!d.a.j0.b.c.b(this.f43987d).f() && d.a.j0.l.c.k(this.f43987d) == 0) {
                z = true;
            }
            g(this.f43987d, z);
            d.a.j0.l.c.m(this.f43987d);
            this.f43984a.put(1, new e(this.f43987d));
            this.f43984a.put(3, new f(this.f43987d));
            this.f43984a.put(2, new g(this.f43987d));
            this.f43985b = true;
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0605a interfaceC0605a) {
        int intValue;
        int intValue2;
        int intValue3;
        int i3 = -1;
        if (d.a.j0.c.a.c().g()) {
            this.f43989f.add(interfaceC0605a);
            return;
        }
        this.f43989f.clear();
        int a2 = d.a.j0.c.a.c().a(interfaceC0605a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f43988e = -1;
            d.a().c(message, j);
            Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
            intValue = ((Integer) d2.first).intValue();
            intValue2 = ((Integer) d2.second).intValue();
            intValue3 = ((Integer) d2.second).intValue();
        } catch (Throwable unused) {
            i3 = a2;
            d.a.j0.e.b bVar = new d.a.j0.e.b();
            bVar.f43979a = 1;
            c(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar, true);
        }
        if (i(a2, intValue2, intValue, 1)) {
            int b2 = b(intValue2, i2);
            this.f43988e = b2;
            d.a.j0.c.a.c().i(false, true);
            if (b2 != 1 && b2 != 2 && b2 != 3) {
                d.a.j0.e.b bVar2 = new d.a.j0.e.b();
                bVar2.f43979a = 1;
                c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                return;
            }
            d.a.j0.b.c.b(this.f43987d).d();
            i iVar = this.f43984a.get(Integer.valueOf(b2));
            if (iVar == null) {
                d.a.j0.e.b bVar3 = new d.a.j0.e.b();
                bVar3.f43979a = 1;
                c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
            } else {
                iVar.l(intValue3);
                iVar.h(context, a2);
                d.a.j0.h.d.c(context, intValue3, 1, i.q);
            }
        }
    }

    public void f(Context context, long j, a.InterfaceC0605a interfaceC0605a) {
        int a2 = d.a.j0.c.a.c().a(interfaceC0605a);
        Pair<Integer, Integer> d2 = k.d(context);
        int intValue = ((Integer) d2.first).intValue();
        int intValue2 = ((Integer) d2.second).intValue();
        if (i(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.j0.e.b bVar = new d.a.j0.e.b();
                bVar.f43979a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f43984a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.j0.e.b bVar2 = new d.a.j0.e.b();
                bVar2.f43979a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.j0.c.a.c().e(false, true)) {
                d.a.j0.e.b bVar3 = new d.a.j0.e.b();
                bVar3.f43979a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
            } else {
                d.a.j0.h.d.c(context, intValue2, 2, i.q);
                if (!iVar.k()) {
                    iVar.i(context, a2, j);
                } else if (d.a.j0.c.a.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.j0.c.a.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.k()) {
                                    iVar.i(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.j0.l.c.d(th);
                                d.a.j0.e.b bVar4 = new d.a.j0.e.b();
                                bVar4.f43979a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.j0.e.b bVar5 = new d.a.j0.e.b();
                            bVar5.f43979a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, d2, j, new a(this, iVar, context, a2, j, interfaceC0605a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            m(context);
            this.f43986c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f43986c, intentFilter);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public final void h(a.InterfaceC0605a interfaceC0605a, h hVar, int i2, boolean z) {
        if (i2 == 1) {
            this.f43989f.clear();
            d.a.j0.e.a.b(interfaceC0605a, hVar, i2, (ArrayList) this.f43989f.clone(), z);
            return;
        }
        d.a.j0.e.a.b(interfaceC0605a, hVar, i2, null, z);
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        d.a.j0.e.b bVar = new d.a.j0.e.b();
        bVar.f43979a = i5;
        if (!this.f43985b) {
            c(i2, 3, 2001, i3, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.a.j0.a.f43930b) && TextUtils.isEmpty(d.a.j0.a.f43931c)) {
            c(i2, 3, 2007, i3, "has no key.", bVar, false);
            return false;
        } else if (this.f43984a.isEmpty()) {
            c(i2, 3, 2002, i3, "has no sdk.", bVar, false);
            return false;
        } else if (i4 == 0) {
            c(i2, 3, 2003, i3, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0605a interfaceC0605a) {
        int a2 = d.a.j0.c.a.c().a(interfaceC0605a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f43988e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.d(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (i(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i2);
                this.f43988e = b2;
                if (!d.a.j0.c.a.c().l(false, true)) {
                    d.a.j0.e.b bVar = new d.a.j0.e.b();
                    bVar.f43979a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.a.j0.e.b bVar2 = new d.a.j0.e.b();
                    bVar2.f43979a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.a.j0.b.c.b(this.f43987d).d();
                    i iVar = this.f43984a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.a.j0.e.b bVar3 = new d.a.j0.e.b();
                        bVar3.f43979a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.l(intValue3);
                    iVar.o(context, a2);
                    d.a.j0.h.d.c(context, intValue3, 3, i.r);
                }
            }
        } catch (Throwable unused) {
            d.a.j0.e.b bVar4 = new d.a.j0.e.b();
            bVar4.f43979a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void l(Context context, long j, a.InterfaceC0605a interfaceC0605a) {
        int a2 = d.a.j0.c.a.c().a(interfaceC0605a);
        Pair<Integer, Integer> d2 = k.d(context);
        int intValue = ((Integer) d2.first).intValue();
        int intValue2 = ((Integer) d2.second).intValue();
        if (i(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.j0.e.b bVar = new d.a.j0.e.b();
                bVar.f43979a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f43984a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.j0.e.b bVar2 = new d.a.j0.e.b();
                bVar2.f43979a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.j0.c.a.c().n(false, true)) {
                d.a.j0.e.b bVar3 = new d.a.j0.e.b();
                bVar3.f43979a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
            } else {
                d.a.j0.h.d.c(context, intValue2, 4, i.r);
                if (!iVar.q()) {
                    iVar.p(context, a2, j);
                } else if (d.a.j0.c.a.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.j0.c.a.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.q()) {
                                    iVar.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.j0.l.c.d(th);
                                d.a.j0.e.b bVar4 = new d.a.j0.e.b();
                                bVar4.f43979a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.j0.e.b bVar5 = new d.a.j0.e.b();
                            bVar5.f43979a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, d2, j, new b(this, iVar, context, a2, j, interfaceC0605a));
                }
            }
        }
    }

    public final void m(Context context) {
        try {
            if (this.f43986c != null) {
                context.unregisterReceiver(this.f43986c);
            }
            this.f43986c = null;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }
}
