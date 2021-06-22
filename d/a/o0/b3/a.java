package d.a.o0.b3;

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
import d.a.c.k.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext f55889a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f55890b;

    /* renamed from: c  reason: collision with root package name */
    public ForumSquareModel f55891c;

    /* renamed from: d  reason: collision with root package name */
    public b f55892d;

    /* renamed from: e  reason: collision with root package name */
    public c f55893e;

    /* renamed from: f  reason: collision with root package name */
    public String f55894f = "";

    public a(Context context, TbPageContext tbPageContext) {
        this.f55889a = tbPageContext;
        this.f55890b = context;
        this.f55891c = new ForumSquareModel(context, this);
        this.f55892d = new b(context, this.f55889a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r5.equals(r1) == false) goto L9;
     */
    @Override // d.a.o0.b3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, List<String> list, List<n> list2) {
        if (this.f55891c == null || this.f55892d == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.f55894f)) {
            String e2 = this.f55892d.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.f55894f = str;
            this.f55892d.J();
            this.f55892d.r(str, list, z);
            this.f55892d.t(list2, this.f55891c.O(list2, 300));
            d(str, list2);
        }
        z = true;
        this.f55894f = str;
        this.f55892d.J();
        this.f55892d.r(str, list, z);
        this.f55892d.t(list2, this.f55891c.O(list2, 300));
        d(str, list2);
    }

    @Override // d.a.o0.b3.d
    public void b(ErrorData errorData) {
        b bVar = this.f55892d;
        if (bVar != null) {
            bVar.I();
        }
    }

    @Override // d.a.o0.b3.d
    public void c(String str, ErrorData errorData) {
        b bVar = this.f55892d;
        if (bVar == null || this.f55891c == null) {
            return;
        }
        bVar.J();
        d.a.o0.b3.f.c I = this.f55891c.I(str);
        if (I != null && (!I.f55935d || !ListUtils.isEmpty(I.a()))) {
            this.f55892d.s(I.a());
            d(str, I.a());
            return;
        }
        this.f55892d.f();
        this.f55892d.u();
    }

    public final void d(String str, List<n> list) {
        if (this.f55892d == null || this.f55891c == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.f55892d.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.f55892d.n();
        } else {
            this.f55892d.E(this.f55891c.J(str));
        }
    }

    public void e() {
        this.f55892d.b();
    }

    public String f() {
        return this.f55894f;
    }

    public void g() {
        String f2 = f();
        ForumSquareModel forumSquareModel = this.f55891c;
        if (forumSquareModel == null || this.f55892d == null) {
            return;
        }
        boolean K = forumSquareModel.K();
        boolean E = this.f55892d.E(this.f55891c.J(f2));
        if (K || !E) {
            return;
        }
        this.f55891c.L(f2);
    }

    public void h() {
        b bVar = this.f55892d;
        if (bVar != null) {
            bVar.F();
        }
        ForumSquareModel forumSquareModel = this.f55891c;
        if (forumSquareModel != null) {
            forumSquareModel.L(f());
        }
    }

    public void i(String str) {
        k(this.f55894f);
        this.f55894f = str;
        ForumSquareModel forumSquareModel = this.f55891c;
        if (forumSquareModel == null || this.f55892d == null) {
            return;
        }
        d.a.o0.b3.f.c I = forumSquareModel.I(str);
        if (I != null && (!I.f55935d || !ListUtils.isEmpty(I.a()))) {
            this.f55892d.J();
            d(str, I.a());
            this.f55892d.s(I.a());
            this.f55892d.q(I.f55937f, I.f55938g);
            return;
        }
        this.f55892d.D();
        d(str, null);
        this.f55891c.L(str);
        this.f55892d.q(0, 0);
    }

    public void j(Intent intent) {
        Uri uri;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.f55894f = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.f55894f = uri.getQueryParameter("tab_name");
            }
            this.f55892d.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
        }
    }

    public void k(String str) {
        d.a.o0.b3.f.c I;
        Pair<Integer, Integer> c2;
        if (this.f55892d == null || this.f55891c == null || TextUtils.isEmpty(str) || (I = this.f55891c.I(str)) == null || (c2 = this.f55892d.c()) == null) {
            return;
        }
        I.f55937f = ((Integer) c2.first).intValue();
        I.f55938g = ((Integer) c2.second).intValue();
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f55892d.B(str);
        i(str);
    }

    public void m() {
        c cVar = new c(this.f55890b, this, this.f55892d);
        this.f55893e = cVar;
        cVar.e();
        n();
    }

    public final void n() {
        this.f55892d.F();
        this.f55891c.L(this.f55894f);
    }
}
