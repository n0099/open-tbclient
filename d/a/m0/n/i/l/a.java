package d.a.m0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.n.h.f;
import d.a.m0.n.h.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1137a> f51862a;

    /* renamed from: d.a.m0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1137a {

        /* renamed from: a  reason: collision with root package name */
        public int f51863a;

        /* renamed from: b  reason: collision with root package name */
        public String f51864b;

        /* renamed from: c  reason: collision with root package name */
        public int f51865c;

        /* renamed from: d  reason: collision with root package name */
        public f f51866d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f51867e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f51868f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f51869g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f51866d) == null || !(obj instanceof C1137a)) {
                return false;
            }
            return fVar.equals(((C1137a) obj).f51866d);
        }

        public int hashCode() {
            f fVar = this.f51866d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f51864b);
            if (this.f51866d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f51866d);
            }
            if (this.f51868f != null) {
                sb.append(",appInfo=");
                sb.append(this.f51868f);
            }
            return sb.toString();
        }
    }
}
