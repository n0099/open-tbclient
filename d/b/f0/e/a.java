package d.b.f0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.b.f0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0581a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42854f;

        public RunnableC0581a(a.InterfaceC0579a interfaceC0579a, String str) {
            this.f42853e = interfaceC0579a;
            this.f42854f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42853e.onFinish(this.f42854f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42856f;

        public b(a.InterfaceC0579a interfaceC0579a, String str) {
            this.f42855e = interfaceC0579a;
            this.f42856f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42855e.onFinish(this.f42856f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42858f;

        public c(a.InterfaceC0579a interfaceC0579a, String str) {
            this.f42857e = interfaceC0579a;
            this.f42858f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42857e.onFinish(this.f42858f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0579a f42859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42860f;

        public d(a.InterfaceC0579a interfaceC0579a, String str) {
            this.f42859e = interfaceC0579a;
            this.f42860f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42859e.onFinish(this.f42860f);
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

    public static synchronized void b(a.InterfaceC0579a interfaceC0579a, h hVar, int i, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f42930a);
                    jSONObject.put("1", hVar.f42931b);
                    jSONObject.put("2", String.valueOf(hVar.f42932c));
                    jSONObject.put("3", hVar.f42933d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0579a != null) {
                        if (i == 1) {
                            if (z) {
                                d.b.f0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0581a(interfaceC0579a, jSONObject2)).start();
                        } else if (i == 2) {
                            if (z) {
                                d.b.f0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0579a, jSONObject2)).start();
                        } else if (i == 3) {
                            if (z) {
                                d.b.f0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0579a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.b.f0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0579a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.b.f0.l.c.d(th);
                }
            }
        }
    }
}
