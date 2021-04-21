package d.b.j0.v3.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.d.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.j0.v3.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1700a extends f0<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f63809a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63810b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f63811c;

        public C1700a(int i, String str, String str2) {
            this.f63809a = i;
            this.f63810b = str;
            this.f63811c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Integer doInBackground() {
            int i = this.f63809a;
            d.b.i0.r.r.a f2 = d.b.i0.r.r.a.f();
            l<String> g2 = f2.g("tb.write_privacy_state_space" + this.f63810b);
            if (g2 != null) {
                i = d.b.c.e.m.b.d(g2.get(this.f63811c), this.f63809a);
            }
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f63812a;

        public b(c cVar) {
            this.f63812a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar = this.f63812a;
            if (cVar != null) {
                cVar.a(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i);
    }

    public static void a(String str, int i, c cVar) {
        if (StringUtils.isNull(str) || cVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        h0.b(new C1700a(i, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        d.b.i0.r.r.a f2 = d.b.i0.r.r.a.f();
        l<String> g2 = f2.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i));
        }
    }
}
