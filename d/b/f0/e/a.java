package d.b.f0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.b.f0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0593a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0591a f43245e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43246f;

        public RunnableC0593a(a.InterfaceC0591a interfaceC0591a, String str) {
            this.f43245e = interfaceC0591a;
            this.f43246f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43245e.onFinish(this.f43246f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0591a f43247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43248f;

        public b(a.InterfaceC0591a interfaceC0591a, String str) {
            this.f43247e = interfaceC0591a;
            this.f43248f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43247e.onFinish(this.f43248f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0591a f43249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43250f;

        public c(a.InterfaceC0591a interfaceC0591a, String str) {
            this.f43249e = interfaceC0591a;
            this.f43250f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43249e.onFinish(this.f43250f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0591a f43251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43252f;

        public d(a.InterfaceC0591a interfaceC0591a, String str) {
            this.f43251e = interfaceC0591a;
            this.f43252f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43251e.onFinish(this.f43252f);
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return 2010;
        }
        if (i == 2) {
            return IMConstants.IM_MSG_TYPE_SHIELD;
        }
        if (i == 3) {
            return IMConstants.IM_MSG_TYPE_SHIELD_ME;
        }
        if (i == 4) {
            return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME;
        }
        if (i == 5) {
            return IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL;
        }
        if (i == 6) {
            return 2015;
        }
        return UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE;
    }

    public static synchronized void b(a.InterfaceC0591a interfaceC0591a, h hVar, int i, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f43322a);
                    jSONObject.put("1", hVar.f43323b);
                    jSONObject.put("2", String.valueOf(hVar.f43324c));
                    jSONObject.put("3", hVar.f43325d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0591a != null) {
                        if (i == 1) {
                            if (z) {
                                d.b.f0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0593a(interfaceC0591a, jSONObject2)).start();
                        } else if (i == 2) {
                            if (z) {
                                d.b.f0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0591a, jSONObject2)).start();
                        } else if (i == 3) {
                            if (z) {
                                d.b.f0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0591a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.b.f0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0591a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.b.f0.l.c.d(th);
                }
            }
        }
    }
}
