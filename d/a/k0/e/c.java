package d.a.k0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mapapi.UIMsg;
import d.a.k0.a;
import d.a.k0.l.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f44123g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44125b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f44126c;

    /* renamed from: d  reason: collision with root package name */
    public Context f44127d;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f44124a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f44128e = -1;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0609a> f44129f = new ArrayList<>();

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0609a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f44130a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f44131b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f44132c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f44133d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0609a f44134e;

        public a(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0609a interfaceC0609a) {
            this.f44130a = iVar;
            this.f44131b = context;
            this.f44132c = i2;
            this.f44133d = j;
            this.f44134e = interfaceC0609a;
        }

        @Override // d.a.k0.a.InterfaceC0609a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f44130a.i(this.f44131b, this.f44132c, this.f44133d);
                    return;
                }
                if (this.f44134e != null) {
                    this.f44134e.onFinish(str);
                }
                d.a.k0.c.a.c().d(false);
            } catch (Throwable unused) {
                a.InterfaceC0609a interfaceC0609a = this.f44134e;
                if (interfaceC0609a != null) {
                    interfaceC0609a.onFinish(str);
                }
                d.a.k0.c.a.c().d(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0609a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f44135a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f44136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f44137c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f44138d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0609a f44139e;

        public b(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0609a interfaceC0609a) {
            this.f44135a = iVar;
            this.f44136b = context;
            this.f44137c = i2;
            this.f44138d = j;
            this.f44139e = interfaceC0609a;
        }

        @Override // d.a.k0.a.InterfaceC0609a
        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.f44135a.p(this.f44136b, this.f44137c, this.f44138d);
                    return;
                }
                if (this.f44139e != null) {
                    this.f44139e.onFinish(str);
                }
                d.a.k0.c.a.c().m(false);
            } catch (Throwable unused) {
                a.InterfaceC0609a interfaceC0609a = this.f44139e;
                if (interfaceC0609a != null) {
                    interfaceC0609a.onFinish(str);
                }
                d.a.k0.c.a.c().m(false);
            }
        }
    }

    public static c j() {
        if (f44123g == null) {
            synchronized (c.class) {
                if (f44123g == null) {
                    f44123g = new c();
                }
            }
        }
        return f44123g;
    }

    public int a() {
        return this.f44128e;
    }

    public final int b(int i2, int i3) {
        if (this.f44124a.size() == 1) {
            return Integer.valueOf(this.f44124a.get(this.f44124a.keySet().iterator().next()).f44200c).intValue();
        }
        return (this.f44124a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, d.a.k0.e.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        Pair<Boolean, a.InterfaceC0609a> b2 = d.a.k0.c.a.c().b(i2);
        if (((Boolean) b2.first).booleanValue()) {
            d.a().b(i2);
            h((a.InterfaceC0609a) b2.second, new h(i3, i4, i5, str), bVar.f44119a, z);
            if (i3 == 1) {
                bVar.f44120b = 1;
            }
            if (z) {
                int i6 = bVar.f44119a;
                if (i6 == 1) {
                    d.a.k0.h.d.e(this.f44127d, i5, bVar.f44120b, i4, str);
                } else if (i6 == 3) {
                    d.a.k0.h.d.b(this.f44127d, i5, bVar.f44120b, i4, str);
                } else if (i6 == 2) {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.k0.b.a.h(this.f44127d).A(System.currentTimeMillis());
                        d.a.k0.b.a.h(this.f44127d).k(i4);
                    }
                    d.a.k0.h.d.a(this.f44127d, i5, i3, i4, bVar.f44121c, bVar.f44122d);
                } else {
                    if (i3 == 3 && i4 == 2019) {
                        d.a.k0.b.a.h(this.f44127d).K(System.currentTimeMillis());
                        d.a.k0.b.a.h(this.f44127d).q(i4);
                    }
                    d.a.k0.h.d.d(this.f44127d, i5, i3, i4, bVar.f44121c, bVar.f44122d);
                }
            }
        }
    }

    public synchronized void d(Context context) {
        try {
            if (this.f44125b) {
                return;
            }
            this.f44127d = context.getApplicationContext();
            d.a.k0.m.a.b().a(this.f44127d, null);
            boolean z = false;
            if (!d.a.k0.b.c.b(this.f44127d).f() && d.a.k0.l.c.k(this.f44127d) == 0) {
                z = true;
            }
            g(this.f44127d, z);
            d.a.k0.l.c.m(this.f44127d);
            this.f44124a.put(1, new e(this.f44127d));
            this.f44124a.put(3, new f(this.f44127d));
            this.f44124a.put(2, new g(this.f44127d));
            this.f44125b = true;
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0609a interfaceC0609a) {
        int intValue;
        int intValue2;
        int intValue3;
        int i3 = -1;
        if (d.a.k0.c.a.c().g()) {
            this.f44129f.add(interfaceC0609a);
            return;
        }
        this.f44129f.clear();
        int a2 = d.a.k0.c.a.c().a(interfaceC0609a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 1;
            this.f44128e = -1;
            d.a().c(message, j);
            Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
            intValue = ((Integer) d2.first).intValue();
            intValue2 = ((Integer) d2.second).intValue();
            intValue3 = ((Integer) d2.second).intValue();
        } catch (Throwable unused) {
            i3 = a2;
            d.a.k0.e.b bVar = new d.a.k0.e.b();
            bVar.f44119a = 1;
            c(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar, true);
        }
        if (i(a2, intValue2, intValue, 1)) {
            int b2 = b(intValue2, i2);
            this.f44128e = b2;
            d.a.k0.c.a.c().i(false, true);
            if (b2 != 1 && b2 != 2 && b2 != 3) {
                d.a.k0.e.b bVar2 = new d.a.k0.e.b();
                bVar2.f44119a = 1;
                c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                return;
            }
            d.a.k0.b.c.b(this.f44127d).d();
            i iVar = this.f44124a.get(Integer.valueOf(b2));
            if (iVar == null) {
                d.a.k0.e.b bVar3 = new d.a.k0.e.b();
                bVar3.f44119a = 1;
                c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
            } else {
                iVar.l(intValue3);
                iVar.h(context, a2);
                d.a.k0.h.d.c(context, intValue3, 1, i.q);
            }
        }
    }

    public void f(Context context, long j, a.InterfaceC0609a interfaceC0609a) {
        int a2 = d.a.k0.c.a.c().a(interfaceC0609a);
        Pair<Integer, Integer> d2 = k.d(context);
        int intValue = ((Integer) d2.first).intValue();
        int intValue2 = ((Integer) d2.second).intValue();
        if (i(a2, intValue2, intValue, 2)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.k0.e.b bVar = new d.a.k0.e.b();
                bVar.f44119a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f44124a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.k0.e.b bVar2 = new d.a.k0.e.b();
                bVar2.f44119a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.k0.c.a.c().e(false, true)) {
                d.a.k0.e.b bVar3 = new d.a.k0.e.b();
                bVar3.f44119a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
            } else {
                d.a.k0.h.d.c(context, intValue2, 2, i.q);
                if (!iVar.k()) {
                    iVar.i(context, a2, j);
                } else if (d.a.k0.c.a.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.k0.c.a.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.k()) {
                                    iVar.i(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.k0.l.c.d(th);
                                d.a.k0.e.b bVar4 = new d.a.k0.e.b();
                                bVar4.f44119a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.k0.e.b bVar5 = new d.a.k0.e.b();
                            bVar5.f44119a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, d2, j, new a(this, iVar, context, a2, j, interfaceC0609a));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        try {
            m(context);
            this.f44126c = new com.baidu.sso.g.h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            context.registerReceiver(this.f44126c, intentFilter);
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public final void h(a.InterfaceC0609a interfaceC0609a, h hVar, int i2, boolean z) {
        if (i2 == 1) {
            this.f44129f.clear();
            d.a.k0.e.a.b(interfaceC0609a, hVar, i2, (ArrayList) this.f44129f.clone(), z);
            return;
        }
        d.a.k0.e.a.b(interfaceC0609a, hVar, i2, null, z);
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        d.a.k0.e.b bVar = new d.a.k0.e.b();
        bVar.f44119a = i5;
        if (!this.f44125b) {
            c(i2, 3, 2001, i3, "has no init.", bVar, false);
            return false;
        } else if (TextUtils.isEmpty(d.a.k0.a.f44070b) && TextUtils.isEmpty(d.a.k0.a.f44071c)) {
            c(i2, 3, 2007, i3, "has no key.", bVar, false);
            return false;
        } else if (this.f44124a.isEmpty()) {
            c(i2, 3, 2002, i3, "has no sdk.", bVar, false);
            return false;
        } else if (i4 == 0) {
            c(i2, 3, 2003, i3, "has no net.", bVar, false);
            return false;
        } else {
            return true;
        }
    }

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0609a interfaceC0609a) {
        int a2 = d.a.k0.c.a.c().a(interfaceC0609a);
        try {
            Message message = new Message();
            message.what = a2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f44128e = -1;
            d.a().c(message, j);
            if (pair == null) {
                pair = k.d(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (i(a2, intValue2, intValue, 3)) {
                int b2 = b(intValue2, i2);
                this.f44128e = b2;
                if (!d.a.k0.c.a.c().l(false, true)) {
                    d.a.k0.e.b bVar = new d.a.k0.e.b();
                    bVar.f44119a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    d.a.k0.e.b bVar2 = new d.a.k0.e.b();
                    bVar2.f44119a = 3;
                    c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                } else {
                    d.a.k0.b.c.b(this.f44127d).d();
                    i iVar = this.f44124a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        d.a.k0.e.b bVar3 = new d.a.k0.e.b();
                        bVar3.f44119a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                        return;
                    }
                    iVar.l(intValue3);
                    iVar.o(context, a2);
                    d.a.k0.h.d.c(context, intValue3, 3, i.r);
                }
            }
        } catch (Throwable unused) {
            d.a.k0.e.b bVar4 = new d.a.k0.e.b();
            bVar4.f44119a = 3;
            c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", bVar4, true);
        }
    }

    public void l(Context context, long j, a.InterfaceC0609a interfaceC0609a) {
        int a2 = d.a.k0.c.a.c().a(interfaceC0609a);
        Pair<Integer, Integer> d2 = k.d(context);
        int intValue = ((Integer) d2.first).intValue();
        int intValue2 = ((Integer) d2.second).intValue();
        if (i(a2, intValue2, intValue, 4)) {
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                d.a.k0.e.b bVar = new d.a.k0.e.b();
                bVar.f44119a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                return;
            }
            i iVar = this.f44124a.get(Integer.valueOf(intValue2));
            if (iVar == null) {
                d.a.k0.e.b bVar2 = new d.a.k0.e.b();
                bVar2.f44119a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
            } else if (!d.a.k0.c.a.c().n(false, true)) {
                d.a.k0.e.b bVar3 = new d.a.k0.e.b();
                bVar3.f44119a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
            } else {
                d.a.k0.h.d.c(context, intValue2, 4, i.r);
                if (!iVar.q()) {
                    iVar.p(context, a2, j);
                } else if (d.a.k0.c.a.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (d.a.k0.c.a.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!iVar.q()) {
                                    iVar.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                d.a.k0.l.c.d(th);
                                d.a.k0.e.b bVar4 = new d.a.k0.e.b();
                                bVar4.f44119a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                return;
                            }
                        } else {
                            d.a.k0.e.b bVar5 = new d.a.k0.e.b();
                            bVar5.f44119a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, d2, j, new b(this, iVar, context, a2, j, interfaceC0609a));
                }
            }
        }
    }

    public final void m(Context context) {
        try {
            if (this.f44126c != null) {
                context.unregisterReceiver(this.f44126c);
            }
            this.f44126c = null;
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }
}
