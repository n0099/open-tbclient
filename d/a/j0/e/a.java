package d.a.j0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.a.j0.a;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.j0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0607a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0605a f43973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43974f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43975g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f43976h;

        /* renamed from: d.a.j0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0608a extends d.a.j0.k.c {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0605a f43977f;

            public C0608a(a.InterfaceC0605a interfaceC0605a) {
                this.f43977f = interfaceC0605a;
            }

            @Override // d.a.j0.k.c
            public void b() {
                this.f43977f.onFinish(RunnableC0607a.this.f43974f);
            }
        }

        public RunnableC0607a(a.InterfaceC0605a interfaceC0605a, String str, int i2, ArrayList arrayList) {
            this.f43973e = interfaceC0605a;
            this.f43974f = str;
            this.f43975g = i2;
            this.f43976h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43973e.onFinish(this.f43974f);
            if (this.f43975g != 1 || this.f43976h == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f43976h.size(); i2++) {
                a.InterfaceC0605a interfaceC0605a = (a.InterfaceC0605a) this.f43976h.get(i2);
                if (interfaceC0605a != null) {
                    d.a.j0.k.e.c().b(new C0608a(interfaceC0605a));
                }
            }
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

    public static void b(a.InterfaceC0605a interfaceC0605a, h hVar, int i2, ArrayList<a.InterfaceC0605a> arrayList, boolean z) {
        if (hVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", hVar.f44054a);
                jSONObject.put("1", hVar.f44055b);
                jSONObject.put("2", String.valueOf(hVar.f44056c));
                jSONObject.put("3", hVar.f44057d);
                String jSONObject2 = jSONObject.toString();
                if (interfaceC0605a != null) {
                    if (i2 == 1) {
                        if (z) {
                            d.a.j0.c.a.c().f(false);
                        }
                    } else if (i2 == 2) {
                        if (z) {
                            d.a.j0.c.a.c().d(false);
                        }
                    } else if (i2 == 3) {
                        if (z) {
                            d.a.j0.c.a.c().j(false);
                        }
                    } else if (z) {
                        d.a.j0.c.a.c().m(false);
                    }
                    new Thread(new RunnableC0607a(interfaceC0605a, jSONObject2, i2, arrayList)).start();
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }
}
