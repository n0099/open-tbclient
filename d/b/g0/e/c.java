package d.b.g0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mapapi.UIMsg;
import d.b.g0.a;
import d.b.g0.l.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f43554f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43556b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f43557c;

    /* renamed from: d  reason: collision with root package name */
    public Context f43558d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f43555a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f43559e = -1;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0610a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f43560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f43561b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f43562c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f43563d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43564e;

        public a(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0610a interfaceC0610a) {
            this.f43560a = iVar;
            this.f43561b = context;
            this.f43562c = i;
            this.f43563d = j;
            this.f43564e = interfaceC0610a;
        }

        @Override // d.b.g0.a.InterfaceC0610a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f43560a.h(this.f43561b, this.f43562c, this.f43563d);
                    return;
                }
                if (this.f43564e != null) {
                    this.f43564e.onFinish(str);
                }
                d.b.g0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0610a interfaceC0610a = this.f43564e;
                if (interfaceC0610a != null) {
                    interfaceC0610a.onFinish(str);
                }
                d.b.g0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0610a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f43565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f43566b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f43567c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f43568d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43569e;

        public b(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0610a interfaceC0610a) {
            this.f43565a = iVar;
            this.f43566b = context;
            this.f43567c = i;
            this.f43568d = j;
            this.f43569e = interfaceC0610a;
        }

        @Override // d.b.g0.a.InterfaceC0610a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f43565a.o(this.f43566b, this.f43567c, this.f43568d);
                    return;
                }
                if (this.f43569e != null) {
                    this.f43569e.onFinish(str);
                }
                d.b.g0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0610a interfaceC0610a = this.f43569e;
                if (interfaceC0610a != null) {
                    interfaceC0610a.onFinish(str);
                }
                d.b.g0.c.a.c().m(false);
            }
        }
    }

    public static c i() {
        if (f43554f == null) {
            synchronized (c.class) {
                if (f43554f == null) {
                    f43554f = new c();
                }
            }
        }
        return f43554f;
    }

    public int a() {
        return this.f43559e;
    }

    public final int b(int i, int i2) {
        if (this.f43555a.size() == 1) {
            return Integer.valueOf(this.f43555a.get(this.f43555a.keySet().iterator().next()).f43625c).intValue();
        }
        return (this.f43555a.size() != 2 || i2 >= 4 || i2 <= 0) ? i : i2;
    }

    public void c(int i, int i2, int i3, int i4, String str, d.b.g0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0610a> b2 = d.b.g0.c.a.c().b(i);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i);
            d.b.g0.e.a.b((a.InterfaceC0610a) b2.second, new h(i2, i3, i4, str), bVar.f43550a, z);
            if (i2 == 1) {
                bVar.f43551b = 1;
            }
            if (z) {
                int i5 = bVar.f43550a;
                if (i5 == 1) {
                    d.b.g0.h.d.e(this.f43558d, i4, bVar.f43551b, i3, str);
                } else if (i5 == 3) {
                    d.b.g0.h.d.c(this.f43558d, i4, bVar.f43551b, i3, str);
                } else if (i5 == 2) {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.g0.b.a.g(this.f43558d).y(System.currentTimeMillis());
                        d.b.g0.b.a.g(this.f43558d).j(i3);
                    }
                    d.b.g0.h.d.b(this.f43558d, i4, i2, i3, bVar.f43552c, bVar.f43553d);
                } else {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.g0.b.a.g(this.f43558d).I(System.currentTimeMillis());
                        d.b.g0.b.a.g(this.f43558d).p(i3);
                    }
                    d.b.g0.h.d.d(this.f43558d, i4, i2, i3, bVar.f43552c, bVar.f43553d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f43556b) {
                return;
            }
            this.f43558d = context.getApplicationContext();
            d.b.g0.m.a.b().a(this.f43558d, null);
            boolean z = false;
            if (!d.b.g0.b.c.b(this.f43558d).f() && d.b.g0.l.c.k(this.f43558d) == 0) {
                z = true;
            }
            g(this.f43558d, z);
            d.b.g0.l.c.m(this.f43558d);
            this.f43555a.put(1, new e(this.f43558d));
            this.f43555a.put(3, new f(this.f43558d));
            this.f43555a.put(2, new g(this.f43558d));
            this.f43556b = true;
        }
    }

    public void e(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0610a interfaceC0610a) {
        int a2 = d.b.g0.c.a.c().a(interfaceC0610a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f43559e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 1)) {
                int b2 = b(intValue2, i);
                this.f43559e = b2;
                if (!d.b.g0.c.a.c().i(false, true)) {
                    d.b.g0.e.b bVar = new d.b.g0.e.b();
                    bVar.f43550a = 1;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.g0.e.b bVar2 = new d.b.g0.e.b();
                    bVar2.f43550a = 1;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.g0.b.c.b(this.f43558d).d();
                    i iVar = this.f43555a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.g0.e.b bVar3 = new d.b.g0.e.b();
                        bVar3.f43550a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.g(context, a2);
                    d.b.g0.h.d.a(context, intValue3, 1, i.q);
                }
            }
        } catch (Throwable unused) {
            d.b.g0.e.b bVar4 = new d.b.g0.e.b();
            bVar4.f43550a = 1;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void f(Context context, long j, a.InterfaceC0610a interfaceC0610a) {
        int a2 = d.b.g0.c.a.c().a(interfaceC0610a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.g0.e.b bVar = new d.b.g0.e.b();
                bVar.f43550a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f43555a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.g0.e.b bVar2 = new d.b.g0.e.b();
                bVar2.f43550a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.g0.c.a.c().e(false, true)) {
                d.b.g0.e.b bVar3 = new d.b.g0.e.b();
                bVar3.f43550a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
            } else {
                d.b.g0.h.d.a(context, intValue2, 2, i.q);
                if (!iVar.j()) {
                    iVar.h(context, a2, j);
                } else if (d.b.g0.c.a.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.b.g0.c.a.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.j()) {
                                    iVar.h(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.b.g0.l.c.d(th);
                                d.b.g0.e.b bVar4 = new d.b.g0.e.b();
                                bVar4.f43550a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.g0.e.b bVar5 = new d.b.g0.e.b();
                            bVar5.f43550a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, b2, j, new a(this, iVar, context, a2, j, interfaceC0610a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            l(context);
            this.f43557c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f43557c, intentFilter);
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public final boolean h(int i, int i2, int i3, int i4) {
        d.b.g0.e.b bVar = new d.b.g0.e.b();
        bVar.f43550a = i4;
        if (!this.f43556b) {
            c(i, 3, 2001, i2, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.b.g0.a.f43498b) && TextUtils.isEmpty(d.b.g0.a.f43499c)) {
            c(i, 3, 2007, i2, "has no key.", bVar, false);
            return false;
        } else if (this.f43555a.isEmpty()) {
            c(i, 3, 2002, i2, "has no sdk.", bVar, false);
            return false;
        } else if (i3 == 0) {
            c(i, 3, 2003, i2, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void j(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0610a interfaceC0610a) {
        int a2 = d.b.g0.c.a.c().a(interfaceC0610a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f43559e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i);
                this.f43559e = b2;
                if (!d.b.g0.c.a.c().l(false, true)) {
                    d.b.g0.e.b bVar = new d.b.g0.e.b();
                    bVar.f43550a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.g0.e.b bVar2 = new d.b.g0.e.b();
                    bVar2.f43550a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.g0.b.c.b(this.f43558d).d();
                    i iVar = this.f43555a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.g0.e.b bVar3 = new d.b.g0.e.b();
                        bVar3.f43550a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.n(context, a2);
                    d.b.g0.h.d.a(context, intValue3, 3, i.r);
                }
            }
        } catch (Throwable unused) {
            d.b.g0.e.b bVar4 = new d.b.g0.e.b();
            bVar4.f43550a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void k(Context context, long j, a.InterfaceC0610a interfaceC0610a) {
        int a2 = d.b.g0.c.a.c().a(interfaceC0610a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.g0.e.b bVar = new d.b.g0.e.b();
                bVar.f43550a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f43555a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.g0.e.b bVar2 = new d.b.g0.e.b();
                bVar2.f43550a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.g0.c.a.c().n(false, true)) {
                d.b.g0.e.b bVar3 = new d.b.g0.e.b();
                bVar3.f43550a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
            } else {
                d.b.g0.h.d.a(context, intValue2, 4, i.r);
                if (!iVar.p()) {
                    iVar.o(context, a2, j);
                } else if (d.b.g0.c.a.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.b.g0.c.a.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.p()) {
                                    iVar.o(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.b.g0.l.c.d(th);
                                d.b.g0.e.b bVar4 = new d.b.g0.e.b();
                                bVar4.f43550a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.g0.e.b bVar5 = new d.b.g0.e.b();
                            bVar5.f43550a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    j(context, 0, b2, j, new b(this, iVar, context, a2, j, interfaceC0610a));
                }
            }
        }
    }

    public final void l(Context context) {
        try {
            if (this.f43557c != null) {
                context.unregisterReceiver(this.f43557c);
            }
            this.f43557c = null;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }
}
