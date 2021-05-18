package d.a.g0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mapapi.UIMsg;
import d.a.g0.a;
import d.a.g0.l.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f40044f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40046b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f40047c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40048d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f40045a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f40049e = -1;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0536a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f40050a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f40051b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40052c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f40053d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40054e;

        public a(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0536a interfaceC0536a) {
            this.f40050a = iVar;
            this.f40051b = context;
            this.f40052c = i2;
            this.f40053d = j;
            this.f40054e = interfaceC0536a;
        }

        @Override // d.a.g0.a.InterfaceC0536a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f40050a.h(this.f40051b, this.f40052c, this.f40053d);
                    return;
                }
                if (this.f40054e != null) {
                    this.f40054e.onFinish(str);
                }
                d.a.g0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0536a interfaceC0536a = this.f40054e;
                if (interfaceC0536a != null) {
                    interfaceC0536a.onFinish(str);
                }
                d.a.g0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0536a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f40055a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f40056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40057c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f40058d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40059e;

        public b(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0536a interfaceC0536a) {
            this.f40055a = iVar;
            this.f40056b = context;
            this.f40057c = i2;
            this.f40058d = j;
            this.f40059e = interfaceC0536a;
        }

        @Override // d.a.g0.a.InterfaceC0536a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f40055a.o(this.f40056b, this.f40057c, this.f40058d);
                    return;
                }
                if (this.f40059e != null) {
                    this.f40059e.onFinish(str);
                }
                d.a.g0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0536a interfaceC0536a = this.f40059e;
                if (interfaceC0536a != null) {
                    interfaceC0536a.onFinish(str);
                }
                d.a.g0.c.a.c().m(false);
            }
        }
    }

    public static c i() {
        if (f40044f == null) {
            synchronized (c.class) {
                if (f40044f == null) {
                    f40044f = new c();
                }
            }
        }
        return f40044f;
    }

    public int a() {
        return this.f40049e;
    }

    public final int b(int i2, int i3) {
        if (this.f40045a.size() == 1) {
            return Integer.valueOf(this.f40045a.get(this.f40045a.keySet().iterator().next()).f40120c).intValue();
        }
        return (this.f40045a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
    }

    public void c(int i2, int i3, int i4, int i5, String str, d.a.g0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0536a> b2 = d.a.g0.c.a.c().b(i2);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i2);
            d.a.g0.e.a.b((a.InterfaceC0536a) b2.second, new h(i3, i4, i5, str), bVar.f40040a, z);
            if (i3 == 1) {
                bVar.f40041b = 1;
            }
            if (z) {
                int i6 = bVar.f40040a;
                if (i6 == 1) {
                    d.a.g0.h.d.e(this.f40048d, i5, bVar.f40041b, i4, str);
                } else if (i6 == 3) {
                    d.a.g0.h.d.c(this.f40048d, i5, bVar.f40041b, i4, str);
                } else if (i6 == 2) {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.g0.b.a.g(this.f40048d).y(System.currentTimeMillis());
                        d.a.g0.b.a.g(this.f40048d).j(i4);
                    }
                    d.a.g0.h.d.b(this.f40048d, i5, i3, i4, bVar.f40042c, bVar.f40043d);
                } else {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.g0.b.a.g(this.f40048d).I(System.currentTimeMillis());
                        d.a.g0.b.a.g(this.f40048d).p(i4);
                    }
                    d.a.g0.h.d.d(this.f40048d, i5, i3, i4, bVar.f40042c, bVar.f40043d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f40046b) {
                return;
            }
            this.f40048d = context.getApplicationContext();
            d.a.g0.m.a.b().a(this.f40048d, null);
            boolean z = false;
            if (!d.a.g0.b.c.b(this.f40048d).f() && d.a.g0.l.c.k(this.f40048d) == 0) {
                z = true;
            }
            g(this.f40048d, z);
            d.a.g0.l.c.m(this.f40048d);
            this.f40045a.put(1, new e(this.f40048d));
            this.f40045a.put(3, new f(this.f40048d));
            this.f40045a.put(2, new g(this.f40048d));
            this.f40046b = true;
        }
    }

    public void e(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0536a interfaceC0536a) {
        int a2 = d.a.g0.c.a.c().a(interfaceC0536a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f40049e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 1)) {
                int b2 = b(intValue2, i2);
                this.f40049e = b2;
                if (!d.a.g0.c.a.c().i(false, true)) {
                    d.a.g0.e.b bVar = new d.a.g0.e.b();
                    bVar.f40040a = 1;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.a.g0.e.b bVar2 = new d.a.g0.e.b();
                    bVar2.f40040a = 1;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.a.g0.b.c.b(this.f40048d).d();
                    i iVar = this.f40045a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.a.g0.e.b bVar3 = new d.a.g0.e.b();
                        bVar3.f40040a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.g(context, a2);
                    d.a.g0.h.d.a(context, intValue3, 1, i.q);
                }
            }
        } catch (Throwable unused) {
            d.a.g0.e.b bVar4 = new d.a.g0.e.b();
            bVar4.f40040a = 1;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void f(Context context, long j, a.InterfaceC0536a interfaceC0536a) {
        int a2 = d.a.g0.c.a.c().a(interfaceC0536a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.g0.e.b bVar = new d.a.g0.e.b();
                bVar.f40040a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f40045a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.g0.e.b bVar2 = new d.a.g0.e.b();
                bVar2.f40040a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.g0.c.a.c().e(false, true)) {
                d.a.g0.e.b bVar3 = new d.a.g0.e.b();
                bVar3.f40040a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
            } else {
                d.a.g0.h.d.a(context, intValue2, 2, i.q);
                if (!iVar.j()) {
                    iVar.h(context, a2, j);
                } else if (d.a.g0.c.a.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.g0.c.a.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.j()) {
                                    iVar.h(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.g0.l.c.d(th);
                                d.a.g0.e.b bVar4 = new d.a.g0.e.b();
                                bVar4.f40040a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.g0.e.b bVar5 = new d.a.g0.e.b();
                            bVar5.f40040a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, b2, j, new a(this, iVar, context, a2, j, interfaceC0536a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            l(context);
            this.f40047c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f40047c, intentFilter);
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public final boolean h(int i2, int i3, int i4, int i5) {
        d.a.g0.e.b bVar = new d.a.g0.e.b();
        bVar.f40040a = i5;
        if (!this.f40046b) {
            c(i2, 3, 2001, i3, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.a.g0.a.f39988b) && TextUtils.isEmpty(d.a.g0.a.f39989c)) {
            c(i2, 3, 2007, i3, "has no key.", bVar, false);
            return false;
        } else if (this.f40045a.isEmpty()) {
            c(i2, 3, 2002, i3, "has no sdk.", bVar, false);
            return false;
        } else if (i4 == 0) {
            c(i2, 3, 2003, i3, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void j(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0536a interfaceC0536a) {
        int a2 = d.a.g0.c.a.c().a(interfaceC0536a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f40049e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i2);
                this.f40049e = b2;
                if (!d.a.g0.c.a.c().l(false, true)) {
                    d.a.g0.e.b bVar = new d.a.g0.e.b();
                    bVar.f40040a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.a.g0.e.b bVar2 = new d.a.g0.e.b();
                    bVar2.f40040a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.a.g0.b.c.b(this.f40048d).d();
                    i iVar = this.f40045a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.a.g0.e.b bVar3 = new d.a.g0.e.b();
                        bVar3.f40040a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.n(context, a2);
                    d.a.g0.h.d.a(context, intValue3, 3, i.r);
                }
            }
        } catch (Throwable unused) {
            d.a.g0.e.b bVar4 = new d.a.g0.e.b();
            bVar4.f40040a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void k(Context context, long j, a.InterfaceC0536a interfaceC0536a) {
        int a2 = d.a.g0.c.a.c().a(interfaceC0536a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.g0.e.b bVar = new d.a.g0.e.b();
                bVar.f40040a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f40045a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.g0.e.b bVar2 = new d.a.g0.e.b();
                bVar2.f40040a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.g0.c.a.c().n(false, true)) {
                d.a.g0.e.b bVar3 = new d.a.g0.e.b();
                bVar3.f40040a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
            } else {
                d.a.g0.h.d.a(context, intValue2, 4, i.r);
                if (!iVar.p()) {
                    iVar.o(context, a2, j);
                } else if (d.a.g0.c.a.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.g0.c.a.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.p()) {
                                    iVar.o(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.g0.l.c.d(th);
                                d.a.g0.e.b bVar4 = new d.a.g0.e.b();
                                bVar4.f40040a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.g0.e.b bVar5 = new d.a.g0.e.b();
                            bVar5.f40040a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    j(context, 0, b2, j, new b(this, iVar, context, a2, j, interfaceC0536a));
                }
            }
        }
    }

    public final void l(Context context) {
        try {
            if (this.f40047c != null) {
                context.unregisterReceiver(this.f40047c);
            }
            this.f40047c = null;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }
}
