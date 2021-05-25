package d.a.l0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.n.h.f;
import d.a.l0.n.h.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1078a> f48080a;

    /* renamed from: d.a.l0.n.i.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1078a {

        /* renamed from: a  reason: collision with root package name */
        public int f48081a;

        /* renamed from: b  reason: collision with root package name */
        public String f48082b;

        /* renamed from: c  reason: collision with root package name */
        public int f48083c;

        /* renamed from: d  reason: collision with root package name */
        public f f48084d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f48085e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f48086f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48087g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f48084d) == null || !(obj instanceof C1078a)) {
                return false;
            }
            return fVar.equals(((C1078a) obj).f48084d);
        }

        public int hashCode() {
            f fVar = this.f48084d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f48082b);
            if (this.f48084d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f48084d);
            }
            if (this.f48086f != null) {
                sb.append(",appInfo=");
                sb.append(this.f48086f);
            }
            return sb.toString();
        }
    }
}
