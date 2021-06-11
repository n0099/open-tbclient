package d.a.l0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.h.f;
import d.a.l0.n.h.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1134a> f51754a;

    /* renamed from: d.a.l0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1134a {

        /* renamed from: a  reason: collision with root package name */
        public int f51755a;

        /* renamed from: b  reason: collision with root package name */
        public String f51756b;

        /* renamed from: c  reason: collision with root package name */
        public int f51757c;

        /* renamed from: d  reason: collision with root package name */
        public f f51758d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f51759e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f51760f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f51761g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f51758d) == null || !(obj instanceof C1134a)) {
                return false;
            }
            return fVar.equals(((C1134a) obj).f51758d);
        }

        public int hashCode() {
            f fVar = this.f51758d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f51756b);
            if (this.f51758d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f51758d);
            }
            if (this.f51760f != null) {
                sb.append(",appInfo=");
                sb.append(this.f51760f);
            }
            return sb.toString();
        }
    }
}
