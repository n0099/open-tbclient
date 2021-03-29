package d.b.g0.l.l.j;

import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.l.k.f;
import d.b.g0.l.k.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1020a> f48976a;

    /* renamed from: d.b.g0.l.l.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1020a {

        /* renamed from: a  reason: collision with root package name */
        public int f48977a;

        /* renamed from: b  reason: collision with root package name */
        public String f48978b;

        /* renamed from: c  reason: collision with root package name */
        public int f48979c;

        /* renamed from: d  reason: collision with root package name */
        public f f48980d;

        /* renamed from: e  reason: collision with root package name */
        public List<g> f48981e;

        /* renamed from: f  reason: collision with root package name */
        public PMSAppInfo f48982f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48983g;

        public boolean equals(Object obj) {
            f fVar;
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || (fVar = this.f48980d) == null || !(obj instanceof C1020a)) {
                return false;
            }
            return fVar.equals(((C1020a) obj).f48980d);
        }

        public int hashCode() {
            f fVar = this.f48980d;
            if (fVar == null) {
                return super.hashCode();
            }
            return fVar.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ");
            sb.append(this.f48978b);
            if (this.f48980d != null) {
                sb.append(",pkgMain=");
                sb.append(this.f48980d);
            }
            if (this.f48982f != null) {
                sb.append(",appInfo=");
                sb.append(this.f48982f);
            }
            return sb.toString();
        }
    }
}
