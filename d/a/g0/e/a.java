package d.a.g0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.a.g0.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.g0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0551a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40788f;

        public RunnableC0551a(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40787e = interfaceC0549a;
            this.f40788f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40787e.onFinish(this.f40788f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40790f;

        public b(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40789e = interfaceC0549a;
            this.f40790f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40789e.onFinish(this.f40790f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40792f;

        public c(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40791e = interfaceC0549a;
            this.f40792f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40791e.onFinish(this.f40792f);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0549a f40793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40794f;

        public d(a.InterfaceC0549a interfaceC0549a, String str) {
            this.f40793e = interfaceC0549a;
            this.f40794f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40793e.onFinish(this.f40794f);
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
                    jSONObject.put("0", hVar.f40869a);
                    jSONObject.put("1", hVar.f40870b);
                    jSONObject.put("2", String.valueOf(hVar.f40871c));
                    jSONObject.put("3", hVar.f40872d);
                    String jSONObject2 = jSONObject.toString();
                    if (interfaceC0549a != null) {
                        if (i2 == 1) {
                            if (z) {
                                d.a.g0.c.a.c().f(false);
                            }
                            new Thread(new RunnableC0551a(interfaceC0549a, jSONObject2)).start();
                        } else if (i2 == 2) {
                            if (z) {
                                d.a.g0.c.a.c().d(false);
                            }
                            new Thread(new b(interfaceC0549a, jSONObject2)).start();
                        } else if (i2 == 3) {
                            if (z) {
                                d.a.g0.c.a.c().j(false);
                            }
                            new Thread(new c(interfaceC0549a, jSONObject2)).start();
                        } else {
                            if (z) {
                                d.a.g0.c.a.c().m(false);
                            }
                            new Thread(new d(interfaceC0549a, jSONObject2)).start();
                        }
                    }
                } catch (Throwable th) {
                    d.a.g0.l.c.d(th);
                }
            }
        }
    }
}
