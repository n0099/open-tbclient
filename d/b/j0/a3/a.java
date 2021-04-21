package d.b.j0.a3;

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
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext f53479a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f53480b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f53481c;

    /* renamed from: d  reason: collision with root package name */
    public b f53482d;

    /* renamed from: e  reason: collision with root package name */
    public c f53483e;

    /* renamed from: f  reason: collision with root package name */
    public String f53484f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f53479a = tbPageContext;
        this.f53480b = context;
        this.f53481c = new ForumSquareModel(context, this);
        this.f53482d = new b(context, this.f53479a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.b.j0.a3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f53481c == null || this.f53482d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f53484f)) {
            String e2 = this.f53482d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f53484f = str;
            this.f53482d.J();
            this.f53482d.r(str, list, z);
            this.f53482d.t(list2, this.f53481c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f53484f = str;
        this.f53482d.J();
        this.f53482d.r(str, list, z);
        this.f53482d.t(list2, this.f53481c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.b.j0.a3.d
    public void b(String str, ErrorData errorData) {
        b bVar = this.f53482d;
        if (bVar == null || this.f53481c == null) {
            return;
        }
        bVar.J();
        d.b.j0.a3.f.c E = this.f53481c.E(str);
        if (E != null && (!E.f53522d || !ListUtils.isEmpty(E.a()))) {
            this.f53482d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f53482d.f();
        this.f53482d.u();
    }

    @Override // d.b.j0.a3.d
    public void c(ErrorData errorData) {
        b bVar = this.f53482d;
        if (bVar != null) {
            bVar.I();
        }
    }

    public final void d(String str, List<n> list) {
        if (this.f53482d == null || this.f53481c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f53482d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f53482d.n();
        } else {
            this.f53482d.E(this.f53481c.F(str));
        }
    }

    public void e() {
        this.f53482d.b();
    }

    public String f() {
        return this.f53484f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f53481c;
        if (forumSquareModel == null || this.f53482d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f53482d.E(this.f53481c.F(f2));
        if (G || !E) {
            return;
        }
        this.f53481c.H(f2);
    }

    public void h() {
        b bVar = this.f53482d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f53481c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f53484f);
        this.f53484f = str;
        ForumSquareModel forumSquareModel = this.f53481c;
        if (forumSquareModel == null || this.f53482d == null) {
            return;
        }
        d.b.j0.a3.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f53522d || !ListUtils.isEmpty(E.a()))) {
            this.f53482d.J();
            d(str, E.a());
            this.f53482d.s(E.a());
            this.f53482d.q(E.f53524f, E.f53525g);
            return;
        }
        this.f53482d.D();
        d(str, null);
        this.f53481c.H(str);
        this.f53482d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f53484f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f53484f = uri.getQueryParameter("tab_name");
            }
            this.f53482d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.b.j0.a3.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f53482d == null || this.f53481c == null || TextUtils.isEmpty(str) || (E = this.f53481c.E(str)) == null || (c2 = this.f53482d.c()) == null) {
            return;
        }
        E.f53524f = ((Integer) c2.first).intValue();
        E.f53525g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f53482d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f53480b, this, this.f53482d);
        this.f53483e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f53482d.F();
        this.f53481c.H(this.f53484f);
    }
}
