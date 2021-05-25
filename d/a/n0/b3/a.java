package d.a.n0.b3;

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
    public final TbPageContext f52075a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f52076b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f52077c;

    /* renamed from: d  reason: collision with root package name */
    public b f52078d;

    /* renamed from: e  reason: collision with root package name */
    public c f52079e;

    /* renamed from: f  reason: collision with root package name */
    public String f52080f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f52075a = tbPageContext;
        this.f52076b = context;
        this.f52077c = new ForumSquareModel(context, this);
        this.f52078d = new b(context, this.f52075a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.a.n0.b3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f52077c == null || this.f52078d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f52080f)) {
            String e2 = this.f52078d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f52080f = str;
            this.f52078d.J();
            this.f52078d.r(str, list, z);
            this.f52078d.t(list2, this.f52077c.K(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f52080f = str;
        this.f52078d.J();
        this.f52078d.r(str, list, z);
        this.f52078d.t(list2, this.f52077c.K(list2, 300));
        d(str, list2);
    }

    @Override // d.a.n0.b3.d
    public void b(ErrorData errorData) {
        b bVar = this.f52078d;
        if (bVar != null) {
            bVar.I();
        }
    }

    @Override // d.a.n0.b3.d
    public void c(String str, ErrorData errorData) {
        b bVar = this.f52078d;
        if (bVar == null || this.f52077c == null) {
            return;
        }
        bVar.J();
        d.a.n0.b3.f.c E = this.f52077c.E(str);
        if (E != null && (!E.f52121d || !ListUtils.isEmpty(E.a()))) {
            this.f52078d.s(E.a());
            d(str, E.a());
            return;
        }
        this.f52078d.f();
        this.f52078d.u();
    }

    public final void d(String str, List<n> list) {
        if (this.f52078d == null || this.f52077c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f52078d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f52078d.n();
        } else {
            this.f52078d.E(this.f52077c.F(str));
        }
    }

    public void e() {
        this.f52078d.b();
    }

    public String f() {
        return this.f52080f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f52077c;
        if (forumSquareModel == null || this.f52078d == null) {
            return;
        }
        boolean G = forumSquareModel.G();
        boolean E = this.f52078d.E(this.f52077c.F(f2));
        if (G || !E) {
            return;
        }
        this.f52077c.H(f2);
    }

    public void h() {
        b bVar = this.f52078d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f52077c;
        if (forumSquareModel != null) {
            forumSquareModel.H(f());
        }
    }

    public void i(String str) {
        k(this.f52080f);
        this.f52080f = str;
        ForumSquareModel forumSquareModel = this.f52077c;
        if (forumSquareModel == null || this.f52078d == null) {
            return;
        }
        d.a.n0.b3.f.c E = forumSquareModel.E(str);
        if (E != null && (!E.f52121d || !ListUtils.isEmpty(E.a()))) {
            this.f52078d.J();
            d(str, E.a());
            this.f52078d.s(E.a());
            this.f52078d.q(E.f52123f, E.f52124g);
            return;
        }
        this.f52078d.D();
        d(str, null);
        this.f52077c.H(str);
        this.f52078d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f52080f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f52080f = uri.getQueryParameter("tab_name");
            }
            this.f52078d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.a.n0.b3.f.c E;
        Pair<Integer, Integer> c2;
        if (this.f52078d == null || this.f52077c == null || TextUtils.isEmpty(str) || (E = this.f52077c.E(str)) == null || (c2 = this.f52078d.c()) == null) {
            return;
        }
        E.f52123f = ((Integer) c2.first).intValue();
        E.f52124g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f52078d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f52076b, this, this.f52078d);
        this.f52079e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f52078d.F();
        this.f52077c.H(this.f52080f);
    }
}
