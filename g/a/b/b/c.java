package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes8.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f71542a;

    /* renamed from: b  reason: collision with root package name */
    public Object f71543b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f71544c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1962a f71545d;

    /* loaded from: classes8.dex */
    public static class a implements a.InterfaceC1962a {

        /* renamed from: a  reason: collision with root package name */
        public String f71546a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f71547b;

        public a(int i2, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f71546a = str;
            this.f71547b = bVar;
        }

        public String a() {
            return this.f71546a;
        }

        public g.a.a.b b() {
            return this.f71547b;
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
            return c(h.f71560h);
        }
    }

    public c(a.InterfaceC1962a interfaceC1962a, Object obj, Object obj2, Object[] objArr) {
        this.f71545d = interfaceC1962a;
        this.f71542a = obj;
        this.f71543b = obj2;
        this.f71544c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f71543b;
    }

    public final String toString() {
        return this.f71545d.toString();
    }
}
