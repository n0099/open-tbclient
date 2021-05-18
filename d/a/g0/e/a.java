package d.a.g0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.a.g0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.g0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0538a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40033f;

        public RunnableC0538a(a.InterfaceC0536a interfaceC0536a, String str) {
            this.f40032e = interfaceC0536a;
            this.f40033f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40032e.onFinish(this.f40033f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40034e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40035f;

        public b(a.InterfaceC0536a interfaceC0536a, String str) {
            this.f40034e = interfaceC0536a;
            this.f40035f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40034e.onFinish(this.f40035f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40037f;

        public c(a.InterfaceC0536a interfaceC0536a, String str) {
            this.f40036e = interfaceC0536a;
            this.f40037f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40036e.onFinish(this.f40037f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0536a f40038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40039f;

        public d(a.InterfaceC0536a interfaceC0536a, String str) {
            this.f40038e = interfaceC0536a;
            this.f40039f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40038e.onFinish(this.f40039f);
        }
    }

    public static int a(int i2) {
        if (i2 == 1) {
            return 2010;
        }
        if (i2 == 2) {
            return IMConstants.IM_MSG_TYPE_SHIELD;
        }
        if (i2 == 3) {
            return IMConstants.IM_MSG_TYPE_SHIELD_ME;
        }
        if (i2 == 4) {
            return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME;
        }
        if (i2 == 5) {
            return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL;
        }
        if (i2 == 6) {
            return 2015;
        }
        return UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE;
    }

    public static synchronized void b(a.InterfaceC0536a interfaceC0536a, h hVar, int i2, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f40114a);
                    jSONObject.put("1", hVar.f40115b);
                    jSONObject.put("2", String.valueOf(hVar.f40116c));
                    jSONObject.put("3", hVar.f40117d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0536a != null) {
                        if (i2 == 1) {
                            if (z) {
                                d.a.g0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0538a(interfaceC0536a, jSONObject2)).start();
                        } else if (i2 == 2) {
                            if (z) {
                                d.a.g0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0536a, jSONObject2)).start();
                        } else if (i2 == 3) {
                            if (z) {
                                d.a.g0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0536a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.a.g0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0536a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.a.g0.l.c.d(th);
                }
            }
        }
    }
}
