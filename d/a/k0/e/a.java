package d.a.k0.e;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import d.a.k0.a;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.k0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0611a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0609a f44113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f44116h;

        /* renamed from: d.a.k0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0612a extends d.a.k0.k.c {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0609a f44117f;

            public C0612a(a.InterfaceC0609a interfaceC0609a) {
                this.f44117f = interfaceC0609a;
            }

            @Override // d.a.k0.k.c
            public void b() {
                this.f44117f.onFinish(RunnableC0611a.this.f44114f);
            }
        }

        public RunnableC0611a(a.InterfaceC0609a interfaceC0609a, String str, int i2, ArrayList arrayList) {
            this.f44113e = interfaceC0609a;
            this.f44114f = str;
            this.f44115g = i2;
            this.f44116h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44113e.onFinish(this.f44114f);
            if (this.f44115g != 1 || this.f44116h == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f44116h.size(); i2++) {
                a.InterfaceC0609a interfaceC0609a = (a.InterfaceC0609a) this.f44116h.get(i2);
                if (interfaceC0609a != null) {
                    d.a.k0.k.e.c().b(new C0612a(interfaceC0609a));
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

    public static void b(a.InterfaceC0609a interfaceC0609a, h hVar, int i2, ArrayList<a.InterfaceC0609a> arrayList, boolean z) {
        if (hVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", hVar.f44194a);
                jSONObject.put("1", hVar.f44195b);
                jSONObject.put("2", String.valueOf(hVar.f44196c));
                jSONObject.put("3", hVar.f44197d);
                String jSONObject2 = jSONObject.toString();
                if (interfaceC0609a != null) {
                    if (i2 == 1) {
                        if (z) {
                            d.a.k0.c.a.c().f(false);
                        }
                    } else if (i2 == 2) {
                        if (z) {
                            d.a.k0.c.a.c().d(false);
                        }
                    } else if (i2 == 3) {
                        if (z) {
                            d.a.k0.c.a.c().j(false);
                        }
                    } else if (z) {
                        d.a.k0.c.a.c().m(false);
                    }
                    new Thread(new RunnableC0611a(interfaceC0609a, jSONObject2, i2, arrayList)).start();
                }
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }
}
