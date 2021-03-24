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
    public final TbPageContext f63438a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f63439b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f63440c;

    /* renamed from: d  reason: collision with root package name */
    public b f63441d;

    /* renamed from: e  reason: collision with root package name */
    public c f63442e;

    /* renamed from: f  reason: collision with root package name */
    public String f63443f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f63438a = tbPageContext;
        this.f63439b = context;
        this.f63440c = new ForumSquareModel(context, this);
        this.f63441d = new b(context, this.f63438a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.b.i0.z2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f63440c == null || this.f63441d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f63443f)) {
            String e2 = this.f63441d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f63443f = str;
            this.f63441d.J();
            this.f63441d.r(str, list, z);
            this.f63441d.t(list2, this.f63440c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f63443f = str;
        this.f63441d.J();
        this.f63441d.r(str, list, z);
        this.f63441d.t(list2, this.f63440c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.b.i0.z2.d
    public void b(String str, ErrorData errorData) {
        b bVar = this.f63441d;
        if (bVar == null || this.f63440c == null) {
            return;
        }
        bVar.J();
        d.b.i0.z2.f.c E = this.f63440c.E(str);
        if (E != null && (!E.f63481d || !ListUtils.isEmpty(E.a()))) {
            this.f63441d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f63441d.f();
        this.f63441d.u();
    }

    @Override // d.b.i0.z2.d
    public void c(ErrorData errorData) {
        b bVar = this.f63441d;
        if (bVar != null) {
            bVar.I();
        }
    }

    public final void d(String str, List<n> list) {
        if (this.f63441d == null || this.f63440c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f63441d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f63441d.n();
        } else {
            this.f63441d.E(this.f63440c.F(str));
        }
    }

    public void e() {
        this.f63441d.b();
    }

    public String f() {
        return this.f63443f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f63440c;
        if (forumSquareModel == null || this.f63441d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f63441d.E(this.f63440c.F(f2));
        if (G || !E) {
            return;
        }
        this.f63440c.H(f2);
    }

    public void h() {
        b bVar = this.f63441d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f63440c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f63443f);
        this.f63443f = str;
        ForumSquareModel forumSquareModel = this.f63440c;
        if (forumSquareModel == null || this.f63441d == null) {
            return;
        }
        d.b.i0.z2.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f63481d || !ListUtils.isEmpty(E.a()))) {
            this.f63441d.J();
            d(str, E.a());
            this.f63441d.s(E.a());
            this.f63441d.q(E.f63483f, E.f63484g);
            return;
        }
        this.f63441d.D();
        d(str, null);
        this.f63440c.H(str);
        this.f63441d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f63443f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f63443f = uri.getQueryParameter("tab_name");
            }
            this.f63441d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.b.i0.z2.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f63441d == null || this.f63440c == null || TextUtils.isEmpty(str) || (E = this.f63440c.E(str)) == null || (c2 = this.f63441d.c()) == null) {
            return;
        }
        E.f63483f = ((Integer) c2.first).intValue();
        E.f63484g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f63441d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f63439b, this, this.f63441d);
        this.f63442e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f63441d.F();
        this.f63440c.H(this.f63443f);
    }
}
