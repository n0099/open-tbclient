package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f68701a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68702b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68703c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1898a f68704d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1898a {

        /* renamed from: a  reason: collision with root package name */
        public String f68705a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f68706b;

        public a(int i, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f68705a = str;
            this.f68706b = bVar;
        }

        public String a() {
            return this.f68705a;
        }

        public g.a.a.b b() {
            return this.f68706b;
        }

        public String c(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.d(a()));
            stringBuffer.append("(");
            stringBuffer.append(((f) b()).k(hVar));
            stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
            return stringBuffer.toString();
        }

        public final String toString() {
            return c(h.f68719h);
        }
    }

    public c(a.InterfaceC1898a interfaceC1898a, Object obj, Object obj2, Object[] objArr) {
        this.f68704d = interfaceC1898a;
        this.f68701a = obj;
        this.f68702b = obj2;
        this.f68703c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f68702b;
    }

    public final String toString() {
        return this.f68704d.toString();
    }
}
