package d.a.j0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.a.j0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.j0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0551a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40294f;

        public RunnableC0551a(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40293e = interfaceC0549a;
            this.f40294f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40293e.onFinish(this.f40294f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40296f;

        public b(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40295e = interfaceC0549a;
            this.f40296f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40295e.onFinish(this.f40296f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40298f;

        public c(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40297e = interfaceC0549a;
            this.f40298f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40297e.onFinish(this.f40298f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40299e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40300f;

        public d(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40299e = interfaceC0549a;
            this.f40300f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40299e.onFinish(this.f40300f);
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

    public static synchronized void b(a.InterfaceC0549a interfaceC0549a, h hVar, int i2, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f40375a);
                    jSONObject.put("1", hVar.f40376b);
                    jSONObject.put("2", String.valueOf(hVar.f40377c));
                    jSONObject.put("3", hVar.f40378d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0549a != null) {
                        if (i2 == 1) {
                            if (z) {
                                d.a.j0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0551a(interfaceC0549a, jSONObject2)).start();
                        } else if (i2 == 2) {
                            if (z) {
                                d.a.j0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0549a, jSONObject2)).start();
                        } else if (i2 == 3) {
                            if (z) {
                                d.a.j0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0549a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.a.j0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0549a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.a.j0.l.c.d(th);
                }
            }
        }
    }
}
