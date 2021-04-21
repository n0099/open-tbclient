package d.b.g0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.b.g0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.g0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0612a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43542e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43543f;

        public RunnableC0612a(a.InterfaceC0610a interfaceC0610a, String str) {
            this.f43542e = interfaceC0610a;
            this.f43543f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43542e.onFinish(this.f43543f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43545f;

        public b(a.InterfaceC0610a interfaceC0610a, String str) {
            this.f43544e = interfaceC0610a;
            this.f43545f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43544e.onFinish(this.f43545f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43547f;

        public c(a.InterfaceC0610a interfaceC0610a, String str) {
            this.f43546e = interfaceC0610a;
            this.f43547f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43546e.onFinish(this.f43547f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0610a f43548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43549f;

        public d(a.InterfaceC0610a interfaceC0610a, String str) {
            this.f43548e = interfaceC0610a;
            this.f43549f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43548e.onFinish(this.f43549f);
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

    public static synchronized void b(a.InterfaceC0610a interfaceC0610a, h hVar, int i, boolean z) {
        synchronized (a.class) {
            if (hVar != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", hVar.f43619a);
                    jSONObject.put("1", hVar.f43620b);
                    jSONObject.put("2", String.valueOf(hVar.f43621c));
                    jSONObject.put("3", hVar.f43622d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0610a != null) {
                        if (i == 1) {
                            if (z) {
                                d.b.g0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0612a(interfaceC0610a, jSONObject2)).start();
                        } else if (i == 2) {
                            if (z) {
                                d.b.g0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0610a, jSONObject2)).start();
                        } else if (i == 3) {
                            if (z) {
                                d.b.g0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0610a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.b.g0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0610a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.b.g0.l.c.d(th);
                }
            }
        }
    }
}
