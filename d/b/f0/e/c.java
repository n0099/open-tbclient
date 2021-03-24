package d.b.f0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mapapi.UIMsg;
import d.b.f0.a;
import d.b.f0.l.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f42864f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42866b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f42867c;

    /* renamed from: d  reason: collision with root package name */
    public Context f42868d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f42865a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f42869e = -1;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0578a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f42870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f42871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f42872c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f42873d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42874e;

        public a(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0578a interfaceC0578a) {
            this.f42870a = iVar;
            this.f42871b = context;
            this.f42872c = i;
            this.f42873d = j;
            this.f42874e = interfaceC0578a;
        }

        @Override // d.b.f0.a.InterfaceC0578a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f42870a.h(this.f42871b, this.f42872c, this.f42873d);
                    return;
                }
                if (this.f42874e != null) {
                    this.f42874e.onFinish(str);
                }
                d.b.f0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0578a interfaceC0578a = this.f42874e;
                if (interfaceC0578a != null) {
                    interfaceC0578a.onFinish(str);
                }
                d.b.f0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0578a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f42875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f42876b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f42877c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f42878d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42879e;

        public b(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0578a interfaceC0578a) {
            this.f42875a = iVar;
            this.f42876b = context;
            this.f42877c = i;
            this.f42878d = j;
            this.f42879e = interfaceC0578a;
        }

        @Override // d.b.f0.a.InterfaceC0578a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f42875a.o(this.f42876b, this.f42877c, this.f42878d);
                    return;
                }
                if (this.f42879e != null) {
                    this.f42879e.onFinish(str);
                }
                d.b.f0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0578a interfaceC0578a = this.f42879e;
                if (interfaceC0578a != null) {
                    interfaceC0578a.onFinish(str);
                }
                d.b.f0.c.a.c().m(false);
            }
        }
    }

    public static c i() {
        if (f42864f == null) {
            synchronized (c.class) {
                if (f42864f == null) {
                    f42864f = new c();
                }
            }
        }
        return f42864f;
    }

    public int a() {
        return this.f42869e;
    }

    public final int b(int i, int i2) {
        if (this.f42865a.size() == 1) {
            return Integer.valueOf(this.f42865a.get(this.f42865a.keySet().iterator().next()).f42935c).intValue();
        }
        return (this.f42865a.size() != 2 || i2 >= 4 || i2 <= 0) ? i : i2;
    }

    public void c(int i, int i2, int i3, int i4, String str, d.b.f0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0578a> b2 = d.b.f0.c.a.c().b(i);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i);
            d.b.f0.e.a.b((a.InterfaceC0578a) b2.second, new h(i2, i3, i4, str), bVar.f42860a, z);
            if (i2 == 1) {
                bVar.f42861b = 1;
            }
            if (z) {
                int i5 = bVar.f42860a;
                if (i5 == 1) {
                    d.b.f0.h.d.e(this.f42868d, i4, bVar.f42861b, i3, str);
                } else if (i5 == 3) {
                    d.b.f0.h.d.c(this.f42868d, i4, bVar.f42861b, i3, str);
                } else if (i5 == 2) {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.f0.b.a.g(this.f42868d).y(System.currentTimeMillis());
                        d.b.f0.b.a.g(this.f42868d).j(i3);
                    }
                    d.b.f0.h.d.b(this.f42868d, i4, i2, i3, bVar.f42862c, bVar.f42863d);
                } else {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.f0.b.a.g(this.f42868d).I(System.currentTimeMillis());
                        d.b.f0.b.a.g(this.f42868d).p(i3);
                    }
                    d.b.f0.h.d.d(this.f42868d, i4, i2, i3, bVar.f42862c, bVar.f42863d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f42866b) {
                return;
            }
            this.f42868d = context.getApplicationContext();
            d.b.f0.m.a.b().a(this.f42868d, null);
            boolean z = false;
            if (!d.b.f0.b.c.b(this.f42868d).f() && d.b.f0.l.c.k(this.f42868d) == 0) {
                z = true;
            }
            g(this.f42868d, z);
            d.b.f0.l.c.m(this.f42868d);
            this.f42865a.put(1, new e(this.f42868d));
            this.f42865a.put(3, new f(this.f42868d));
            this.f42865a.put(2, new g(this.f42868d));
            this.f42866b = true;
        }
    }

    public void e(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0578a interfaceC0578a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0578a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f42869e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 1)) {
                int b2 = b(intValue2, i);
                this.f42869e = b2;
                if (!d.b.f0.c.a.c().i(false, true)) {
                    d.b.f0.e.b bVar = new d.b.f0.e.b();
                    bVar.f42860a = 1;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                    bVar2.f42860a = 1;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.f0.b.c.b(this.f42868d).d();
                    i iVar = this.f42865a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                        bVar3.f42860a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.g(context, a2);
                    d.b.f0.h.d.a(context, intValue3, 1, i.q);
                }
            }
        } catch (Throwable unused) {
            d.b.f0.e.b bVar4 = new d.b.f0.e.b();
            bVar4.f42860a = 1;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void f(Context context, long j, a.InterfaceC0578a interfaceC0578a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0578a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.f0.e.b bVar = new d.b.f0.e.b();
                bVar.f42860a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f42865a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                bVar2.f42860a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.f0.c.a.c().e(false, true)) {
                d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                bVar3.f42860a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
            } else {
                d.b.f0.h.d.a(context, intValue2, 2, i.q);
                if (!iVar.j()) {
                    iVar.h(context, a2, j);
                } else if (d.b.f0.c.a.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.b.f0.c.a.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.j()) {
                                    iVar.h(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.b.f0.l.c.d(th);
                                d.b.f0.e.b bVar4 = new d.b.f0.e.b();
                                bVar4.f42860a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.f0.e.b bVar5 = new d.b.f0.e.b();
                            bVar5.f42860a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, b2, j, new a(this, iVar, context, a2, j, interfaceC0578a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            l(context);
            this.f42867c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f42867c, intentFilter);
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public final boolean h(int i, int i2, int i3, int i4) {
        d.b.f0.e.b bVar = new d.b.f0.e.b();
        bVar.f42860a = i4;
        if (!this.f42866b) {
            c(i, 3, 2001, i2, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.b.f0.a.f42808b) && TextUtils.isEmpty(d.b.f0.a.f42809c)) {
            c(i, 3, 2007, i2, "has no key.", bVar, false);
            return false;
        } else if (this.f42865a.isEmpty()) {
            c(i, 3, 2002, i2, "has no sdk.", bVar, false);
            return false;
        } else if (i3 == 0) {
            c(i, 3, 2003, i2, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void j(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0578a interfaceC0578a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0578a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f42869e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i);
                this.f42869e = b2;
                if (!d.b.f0.c.a.c().l(false, true)) {
                    d.b.f0.e.b bVar = new d.b.f0.e.b();
                    bVar.f42860a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                    bVar2.f42860a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.f0.b.c.b(this.f42868d).d();
                    i iVar = this.f42865a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                        bVar3.f42860a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.k(intValue3);
                    iVar.n(context, a2);
                    d.b.f0.h.d.a(context, intValue3, 3, i.r);
                }
            }
        } catch (Throwable unused) {
            d.b.f0.e.b bVar4 = new d.b.f0.e.b();
            bVar4.f42860a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void k(Context context, long j, a.InterfaceC0578a interfaceC0578a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0578a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.f0.e.b bVar = new d.b.f0.e.b();
                bVar.f42860a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f42865a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                bVar2.f42860a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.f0.c.a.c().n(false, true)) {
                d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                bVar3.f42860a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
            } else {
                d.b.f0.h.d.a(context, intValue2, 4, i.r);
                if (!iVar.p()) {
                    iVar.o(context, a2, j);
                } else if (d.b.f0.c.a.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.b.f0.c.a.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.p()) {
                                    iVar.o(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.b.f0.l.c.d(th);
                                d.b.f0.e.b bVar4 = new d.b.f0.e.b();
                                bVar4.f42860a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.f0.e.b bVar5 = new d.b.f0.e.b();
                            bVar5.f42860a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    j(context, 0, b2, j, new b(this, iVar, context, a2, j, interfaceC0578a));
                }
            }
        }
    }

    public final void l(Context context) {
        try {
            if (this.f42867c != null) {
                context.unregisterReceiver(this.f42867c);
            }
            this.f42867c = null;
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }
}
