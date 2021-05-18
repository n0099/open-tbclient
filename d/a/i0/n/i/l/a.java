package d.a.i0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.n.h.f;
import d.a.i0.n.h.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1067a> f47904a;

    /* renamed from: d.a.i0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1067a {

        /* renamed from: a  reason: collision with root package name */
        public int f47905a;

        /* renamed from: b  reason: collision with root package name */
        public String f47906b;

        /* renamed from: c  reason: collision with root package name */
        public int f47907c;

        /* renamed from: d  reason: collision with root package name */
        public f f47908d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f47909e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f47910f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f47911g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f47908d) == null || !(obj instanceof C1067a)) {
                return false;
            }
            return fVar.equals(((C1067a) obj).f47908d);
        }

        public int hashCode() {
            f fVar = this.f47908d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f47906b);
            if (this.f47908d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f47908d);
            }
            if (this.f47910f != null) {
                sb.append(",appInfo=");
                sb.append(this.f47910f);
            }
            return sb.toString();
        }
    }
}
