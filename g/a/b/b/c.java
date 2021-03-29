package g.a.b.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.a.a.a;
/* loaded from: classes7.dex */
public class c implements g.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Object f67548a;

    /* renamed from: b  reason: collision with root package name */
    public Object f67549b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f67550c;

    /* renamed from: d  reason: collision with root package name */
    public a.InterfaceC1859a f67551d;

    /* loaded from: classes7.dex */
    public static class a implements a.InterfaceC1859a {

        /* renamed from: a  reason: collision with root package name */
        public String f67552a;

        /* renamed from: b  reason: collision with root package name */
        public g.a.a.b f67553b;

        public a(int i, String str, g.a.a.b bVar, g.a.a.c.b bVar2) {
            this.f67552a = str;
            this.f67553b = bVar;
        }

        public String a() {
            return this.f67552a;
        }

        public g.a.a.b b() {
            return this.f67553b;
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
            return c(h.f67566h);
        }
    }

    public c(a.InterfaceC1859a interfaceC1859a, Object obj, Object obj2, Object[] objArr) {
        this.f67551d = interfaceC1859a;
        this.f67548a = obj;
        this.f67549b = obj2;
        this.f67550c = objArr;
    }

    @Override // g.a.a.a
    public Object getTarget() {
        return this.f67549b;
    }

    public final String toString() {
        return this.f67551d.toString();
    }
}
