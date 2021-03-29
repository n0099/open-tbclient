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
/* loaded from: classes2.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static volatile c f42865f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42867b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f42868c;

    /* renamed from: d  reason: collision with root package name */
    public Context f42869d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f42866a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f42870e = -1;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0579a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f42871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f42872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f42873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f42874d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42875e;

        public a(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0579a interfaceC0579a) {
            this.f42871a = iVar;
            this.f42872b = context;
            this.f42873c = i;
            this.f42874d = j;
            this.f42875e = interfaceC0579a;
        }

        @Override // d.b.f0.a.InterfaceC0579a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f42871a.h(this.f42872b, this.f42873c, this.f42874d);
                    return;
                }
                if (this.f42875e != null) {
                    this.f42875e.onFinish(str);
                }
                d.b.f0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0579a interfaceC0579a = this.f42875e;
                if (interfaceC0579a != null) {
                    interfaceC0579a.onFinish(str);
                }
                d.b.f0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0579a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f42876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f42877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f42878c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f42879d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42880e;

        public b(c cVar, i iVar, Context context, int i, long j, a.InterfaceC0579a interfaceC0579a) {
            this.f42876a = iVar;
            this.f42877b = context;
            this.f42878c = i;
            this.f42879d = j;
            this.f42880e = interfaceC0579a;
        }

        @Override // d.b.f0.a.InterfaceC0579a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f42876a.o(this.f42877b, this.f42878c, this.f42879d);
                    return;
                }
                if (this.f42880e != null) {
                    this.f42880e.onFinish(str);
                }
                d.b.f0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0579a interfaceC0579a = this.f42880e;
                if (interfaceC0579a != null) {
                    interfaceC0579a.onFinish(str);
                }
                d.b.f0.c.a.c().m(false);
            }
        }
    }

    public static c i() {
        if (f42865f == null) {
            synchronized (c.class) {
                if (f42865f == null) {
                    f42865f = new c();
                }
            }
        }
        return f42865f;
    }

    public int a() {
        return this.f42870e;
    }

    public final int b(int i, int i2) {
        if (this.f42866a.size() == 1) {
            return Integer.valueOf(this.f42866a.get(this.f42866a.keySet().iterator().next()).f42936c).intValue();
        }
        return (this.f42866a.size() != 2 || i2 >= 4 || i2 <= 0) ? i : i2;
    }

    public void c(int i, int i2, int i3, int i4, String str, d.b.f0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0579a> b2 = d.b.f0.c.a.c().b(i);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i);
            d.b.f0.e.a.b((a.InterfaceC0579a) b2.second, new h(i2, i3, i4, str), bVar.f42861a, z);
            if (i2 == 1) {
                bVar.f42862b = 1;
            }
            if (z) {
                int i5 = bVar.f42861a;
                if (i5 == 1) {
                    d.b.f0.h.d.e(this.f42869d, i4, bVar.f42862b, i3, str);
                } else if (i5 == 3) {
                    d.b.f0.h.d.c(this.f42869d, i4, bVar.f42862b, i3, str);
                } else if (i5 == 2) {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.f0.b.a.g(this.f42869d).y(System.currentTimeMillis());
                        d.b.f0.b.a.g(this.f42869d).j(i3);
                    }
                    d.b.f0.h.d.b(this.f42869d, i4, i2, i3, bVar.f42863c, bVar.f42864d);
                } else {
                    if (i2 == 3 && i3 == 2019) {
                        d.b.f0.b.a.g(this.f42869d).I(System.currentTimeMillis());
                        d.b.f0.b.a.g(this.f42869d).p(i3);
                    }
                    d.b.f0.h.d.d(this.f42869d, i4, i2, i3, bVar.f42863c, bVar.f42864d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f42867b) {
                return;
            }
            this.f42869d = context.getApplicationContext();
            d.b.f0.m.a.b().a(this.f42869d, null);
            boolean z = false;
            if (!d.b.f0.b.c.b(this.f42869d).f() && d.b.f0.l.c.k(this.f42869d) == 0) {
                z = true;
            }
            g(this.f42869d, z);
            d.b.f0.l.c.m(this.f42869d);
            this.f42866a.put(1, new e(this.f42869d));
            this.f42866a.put(3, new f(this.f42869d));
            this.f42866a.put(2, new g(this.f42869d));
            this.f42867b = true;
        }
    }

    public void e(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0579a interfaceC0579a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0579a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f42870e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 1)) {
                int b2 = b(intValue2, i);
                this.f42870e = b2;
                if (!d.b.f0.c.a.c().i(false, true)) {
                    d.b.f0.e.b bVar = new d.b.f0.e.b();
                    bVar.f42861a = 1;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                    bVar2.f42861a = 1;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.f0.b.c.b(this.f42869d).d();
                    i iVar = this.f42866a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                        bVar3.f42861a = 1;
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
            bVar4.f42861a = 1;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void f(Context context, long j, a.InterfaceC0579a interfaceC0579a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0579a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.f0.e.b bVar = new d.b.f0.e.b();
                bVar.f42861a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f42866a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                bVar2.f42861a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.f0.c.a.c().e(false, true)) {
                d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                bVar3.f42861a = 2;
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
                                bVar4.f42861a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.f0.e.b bVar5 = new d.b.f0.e.b();
                            bVar5.f42861a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, b2, j, new a(this, iVar, context, a2, j, interfaceC0579a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            l(context);
            this.f42868c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f42868c, intentFilter);
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public final boolean h(int i, int i2, int i3, int i4) {
        d.b.f0.e.b bVar = new d.b.f0.e.b();
        bVar.f42861a = i4;
        if (!this.f42867b) {
            c(i, 3, 2001, i2, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.b.f0.a.f42809b) && TextUtils.isEmpty(d.b.f0.a.f42810c)) {
            c(i, 3, 2007, i2, "has no key.", bVar, false);
            return false;
        } else if (this.f42866a.isEmpty()) {
            c(i, 3, 2002, i2, "has no sdk.", bVar, false);
            return false;
        } else if (i3 == 0) {
            c(i, 3, 2003, i2, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void j(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0579a interfaceC0579a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0579a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f42870e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.b(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (h(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i);
                this.f42870e = b2;
                if (!d.b.f0.c.a.c().l(false, true)) {
                    d.b.f0.e.b bVar = new d.b.f0.e.b();
                    bVar.f42861a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                    bVar2.f42861a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.b.f0.b.c.b(this.f42869d).d();
                    i iVar = this.f42866a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                        bVar3.f42861a = 3;
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
            bVar4.f42861a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void k(Context context, long j, a.InterfaceC0579a interfaceC0579a) {
        int a2 = d.b.f0.c.a.c().a(interfaceC0579a);
        Pair<Integer, Integer> b2 = k.b(context);
        int intValue = ((Integer) b2.first).intValue();
        int intValue2 = ((Integer) b2.second).intValue();
        if (h(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.b.f0.e.b bVar = new d.b.f0.e.b();
                bVar.f42861a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f42866a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.b.f0.e.b bVar2 = new d.b.f0.e.b();
                bVar2.f42861a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.b.f0.c.a.c().n(false, true)) {
                d.b.f0.e.b bVar3 = new d.b.f0.e.b();
                bVar3.f42861a = 4;
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
                                bVar4.f42861a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.b.f0.e.b bVar5 = new d.b.f0.e.b();
                            bVar5.f42861a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    j(context, 0, b2, j, new b(this, iVar, context, a2, j, interfaceC0579a));
                }
            }
        }
    }

    public final void l(Context context) {
        try {
            if (this.f42868c != null) {
                context.unregisterReceiver(this.f42868c);
            }
            this.f42868c = null;
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }
}
