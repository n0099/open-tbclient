package d.b.i0.v3.n;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.d.l;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: d.b.i0.v3.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1677a extends f0<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f63388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63389b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f63390c;

        public C1677a(int i, String str, String str2) {
            this.f63388a = i;
            this.f63389b = str;
            this.f63390c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.h0.z0.f0
        public Integer doInBackground() {
            int i = this.f63388a;
            d.b.h0.r.r.a f2 = d.b.h0.r.r.a.f();
            l<String> g2 = f2.g("tb.write_privacy_state_space" + this.f63389b);
            if (g2 != null) {
                i = d.b.c.e.m.b.d(g2.get(this.f63390c), this.f63388a);
            }
            return Integer.valueOf(i);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements n<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f63391a;

        public b(c cVar) {
            this.f63391a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar = this.f63391a;
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
        h0.b(new C1677a(i, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        d.b.h0.r.r.a f2 = d.b.h0.r.r.a.f();
        l<String> g2 = f2.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i));
        }
    }
}
