package d.b.f0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.b.f0.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0580a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42853f;

        public RunnableC0580a(a.InterfaceC0578a interfaceC0578a, String str) {
            this.f42852e = interfaceC0578a;
            this.f42853f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42852e.onFinish(this.f42853f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42855f;

        public b(a.InterfaceC0578a interfaceC0578a, String str) {
            this.f42854e = interfaceC0578a;
            this.f42855f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42854e.onFinish(this.f42855f);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42857f;

        public c(a.InterfaceC0578a interfaceC0578a, String str) {
            this.f42856e = interfaceC0578a;
            this.f42857f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42856e.onFinish(this.f42857f);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0578a f42858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42859f;

        public d(a.InterfaceC0578a interfaceC0578a, String str) {
            this.f42858e = interfaceC0578a;
            this.f42859f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42858e.onFinish(this.f42859f);
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

    public static synchronized void b(a.InterfaceC0578a interfaceC0578a, h hVar, int i, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f42929a);
                    jSONObject.put("1", hVar.f42930b);
                    jSONObject.put("2", String.valueOf(hVar.f42931c));
                    jSONObject.put("3", hVar.f42932d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0578a != null) {
                        if (i == 1) {
                            if (z) {
                                d.b.f0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0580a(interfaceC0578a, jSONObject2)).start();
                        } else if (i == 2) {
                            if (z) {
                                d.b.f0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0578a, jSONObject2)).start();
                        } else if (i == 3) {
                            if (z) {
                                d.b.f0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0578a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.b.f0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0578a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.b.f0.l.c.d(th);
                }
            }
        }
    }
}
