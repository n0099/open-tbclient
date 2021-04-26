package d.a.j0.a3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.square.model.ForumSquareModel;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext f51209a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f51210b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f51211c;

    /* renamed from: d  reason: collision with root package name */
    public b f51212d;

    /* renamed from: e  reason: collision with root package name */
    public c f51213e;

    /* renamed from: f  reason: collision with root package name */
    public String f51214f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f51209a = tbPageContext;
        this.f51210b = context;
        this.f51211c = new ForumSquareModel(context, this);
        this.f51212d = new b(context, this.f51209a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.a.j0.a3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f51211c == null || this.f51212d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f51214f)) {
            String e2 = this.f51212d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f51214f = str;
            this.f51212d.J();
            this.f51212d.r(str, list, z);
            this.f51212d.t(list2, this.f51211c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f51214f = str;
        this.f51212d.J();
        this.f51212d.r(str, list, z);
        this.f51212d.t(list2, this.f51211c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.a.j0.a3.d
    public void b(ErrorData errorData) {
        b bVar = this.f51212d;
        if (bVar != null) {
            bVar.I();
        }
    }

    @Override // d.a.j0.a3.d
    public void c(String str, ErrorData errorData) {
        b bVar = this.f51212d;
        if (bVar == null || this.f51211c == null) {
            return;
        }
        bVar.J();
        d.a.j0.a3.f.c E = this.f51211c.E(str);
        if (E != null && (!E.f51255d || !ListUtils.isEmpty(E.a()))) {
            this.f51212d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f51212d.f();
        this.f51212d.u();
    }

    public final void d(String str, List<n> list) {
        if (this.f51212d == null || this.f51211c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f51212d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f51212d.n();
        } else {
            this.f51212d.E(this.f51211c.F(str));
        }
    }

    public void e() {
        this.f51212d.b();
    }

    public String f() {
        return this.f51214f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f51211c;
        if (forumSquareModel == null || this.f51212d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f51212d.E(this.f51211c.F(f2));
        if (G || !E) {
            return;
        }
        this.f51211c.H(f2);
    }

    public void h() {
        b bVar = this.f51212d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f51211c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f51214f);
        this.f51214f = str;
        ForumSquareModel forumSquareModel = this.f51211c;
        if (forumSquareModel == null || this.f51212d == null) {
            return;
        }
        d.a.j0.a3.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f51255d || !ListUtils.isEmpty(E.a()))) {
            this.f51212d.J();
            d(str, E.a());
            this.f51212d.s(E.a());
            this.f51212d.q(E.f51257f, E.f51258g);
            return;
        }
        this.f51212d.D();
        d(str, null);
        this.f51211c.H(str);
        this.f51212d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f51214f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f51214f = uri.getQueryParameter("tab_name");
            }
            this.f51212d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.a.j0.a3.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f51212d == null || this.f51211c == null || TextUtils.isEmpty(str) || (E = this.f51211c.E(str)) == null || (c2 = this.f51212d.c()) == null) {
            return;
        }
        E.f51257f = ((Integer) c2.first).intValue();
        E.f51258g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f51212d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f51210b, this, this.f51212d);
        this.f51213e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f51212d.F();
        this.f51211c.H(this.f51214f);
    }
}
