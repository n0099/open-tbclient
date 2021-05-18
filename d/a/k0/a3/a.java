package d.a.k0.a3;

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
    public final TbPageContext f51908a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f51909b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f51910c;

    /* renamed from: d  reason: collision with root package name */
    public b f51911d;

    /* renamed from: e  reason: collision with root package name */
    public c f51912e;

    /* renamed from: f  reason: collision with root package name */
    public String f51913f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f51908a = tbPageContext;
        this.f51909b = context;
        this.f51910c = new ForumSquareModel(context, this);
        this.f51911d = new b(context, this.f51908a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.a.k0.a3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f51910c == null || this.f51911d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f51913f)) {
            String e2 = this.f51911d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f51913f = str;
            this.f51911d.J();
            this.f51911d.r(str, list, z);
            this.f51911d.t(list2, this.f51910c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f51913f = str;
        this.f51911d.J();
        this.f51911d.r(str, list, z);
        this.f51911d.t(list2, this.f51910c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.a.k0.a3.d
    public void b(ErrorData errorData) {
        b bVar = this.f51911d;
        if (bVar != null) {
            bVar.I();
        }
    }

    @Override // d.a.k0.a3.d
    public void c(String str, ErrorData errorData) {
        b bVar = this.f51911d;
        if (bVar == null || this.f51910c == null) {
            return;
        }
        bVar.J();
        d.a.k0.a3.f.c E = this.f51910c.E(str);
        if (E != null && (!E.f51954d || !ListUtils.isEmpty(E.a()))) {
            this.f51911d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f51911d.f();
        this.f51911d.u();
    }

    public final void d(String str, List<n> list) {
        if (this.f51911d == null || this.f51910c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f51911d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f51911d.n();
        } else {
            this.f51911d.E(this.f51910c.F(str));
        }
    }

    public void e() {
        this.f51911d.b();
    }

    public String f() {
        return this.f51913f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f51910c;
        if (forumSquareModel == null || this.f51911d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f51911d.E(this.f51910c.F(f2));
        if (G || !E) {
            return;
        }
        this.f51910c.H(f2);
    }

    public void h() {
        b bVar = this.f51911d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f51910c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f51913f);
        this.f51913f = str;
        ForumSquareModel forumSquareModel = this.f51910c;
        if (forumSquareModel == null || this.f51911d == null) {
            return;
        }
        d.a.k0.a3.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f51954d || !ListUtils.isEmpty(E.a()))) {
            this.f51911d.J();
            d(str, E.a());
            this.f51911d.s(E.a());
            this.f51911d.q(E.f51956f, E.f51957g);
            return;
        }
        this.f51911d.D();
        d(str, null);
        this.f51910c.H(str);
        this.f51911d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f51913f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f51913f = uri.getQueryParameter("tab_name");
            }
            this.f51911d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.a.k0.a3.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f51911d == null || this.f51910c == null || TextUtils.isEmpty(str) || (E = this.f51910c.E(str)) == null || (c2 = this.f51911d.c()) == null) {
            return;
        }
        E.f51956f = ((Integer) c2.first).intValue();
        E.f51957g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f51911d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f51909b, this, this.f51911d);
        this.f51912e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f51911d.F();
        this.f51910c.H(this.f51913f);
    }
}
