package d.b.i0.z2;

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
import d.b.b.j.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext f63439a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f63440b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f63441c;

    /* renamed from: d  reason: collision with root package name */
    public b f63442d;

    /* renamed from: e  reason: collision with root package name */
    public c f63443e;

    /* renamed from: f  reason: collision with root package name */
    public String f63444f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f63439a = tbPageContext;
        this.f63440b = context;
        this.f63441c = new ForumSquareModel(context, this);
        this.f63442d = new b(context, this.f63439a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.b.i0.z2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f63441c == null || this.f63442d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f63444f)) {
            String e2 = this.f63442d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f63444f = str;
            this.f63442d.J();
            this.f63442d.r(str, list, z);
            this.f63442d.t(list2, this.f63441c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f63444f = str;
        this.f63442d.J();
        this.f63442d.r(str, list, z);
        this.f63442d.t(list2, this.f63441c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.b.i0.z2.d
    public void b(String str, ErrorData errorData) {
        b bVar = this.f63442d;
        if (bVar == null || this.f63441c == null) {
            return;
        }
        bVar.J();
        d.b.i0.z2.f.c E = this.f63441c.E(str);
        if (E != null && (!E.f63482d || !ListUtils.isEmpty(E.a()))) {
            this.f63442d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f63442d.f();
        this.f63442d.u();
    }

    @Override // d.b.i0.z2.d
    public void c(ErrorData errorData) {
        b bVar = this.f63442d;
        if (bVar != null) {
            bVar.I();
        }
    }

    public final void d(String str, List<n> list) {
        if (this.f63442d == null || this.f63441c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f63442d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f63442d.n();
        } else {
            this.f63442d.E(this.f63441c.F(str));
        }
    }

    public void e() {
        this.f63442d.b();
    }

    public String f() {
        return this.f63444f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f63441c;
        if (forumSquareModel == null || this.f63442d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f63442d.E(this.f63441c.F(f2));
        if (G || !E) {
            return;
        }
        this.f63441c.H(f2);
    }

    public void h() {
        b bVar = this.f63442d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f63441c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f63444f);
        this.f63444f = str;
        ForumSquareModel forumSquareModel = this.f63441c;
        if (forumSquareModel == null || this.f63442d == null) {
            return;
        }
        d.b.i0.z2.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f63482d || !ListUtils.isEmpty(E.a()))) {
            this.f63442d.J();
            d(str, E.a());
            this.f63442d.s(E.a());
            this.f63442d.q(E.f63484f, E.f63485g);
            return;
        }
        this.f63442d.D();
        d(str, null);
        this.f63441c.H(str);
        this.f63442d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f63444f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f63444f = uri.getQueryParameter("tab_name");
            }
            this.f63442d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.b.i0.z2.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f63442d == null || this.f63441c == null || TextUtils.isEmpty(str) || (E = this.f63441c.E(str)) == null || (c2 = this.f63442d.c()) == null) {
            return;
        }
        E.f63484f = ((Integer) c2.first).intValue();
        E.f63485g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f63442d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f63440b, this, this.f63442d);
        this.f63443e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f63442d.F();
        this.f63441c.H(this.f63444f);
    }
}
