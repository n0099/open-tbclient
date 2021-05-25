package d.a.n0.j0.h;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import d.a.c.e.m.g;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55929a;

    /* renamed from: b  reason: collision with root package name */
    public View f55930b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f55931c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f55932d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public Runnable f55933e = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f55931c != null) {
                g.c(e.this.f55931c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55936f;

        public b(int i2, int i3) {
            this.f55935e = i2;
            this.f55936f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f55935e, this.f55936f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.e();
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f55929a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i2) {
        if (linkedList != null && linkedList.size() >= 1) {
            int d2 = d(linkedList);
            if (d2 < 0) {
                d.a.m0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
                return;
            } else if (d.a.m0.r.d0.b.j().g("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                return;
            } else {
                this.f55932d.postDelayed(new b(i2, d2), 100L);
                return;
            }
        }
        d.a.m0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
    }

    public final int d(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i2 = 0; i2 < 3 && i2 < size; i2++) {
            VisitedForumData visitedForumData = linkedList.get(i2);
            if (visitedForumData != null && visitedForumData.B()) {
                return i2;
            }
        }
        return -1;
    }

    public void e() {
        PopupWindow popupWindow = this.f55931c;
        if (popupWindow != null) {
            g.c(popupWindow);
        }
    }

    public void f() {
        this.f55932d.removeCallbacksAndMessages(null);
    }

    public final void g(int i2, int i3) {
        d.a.m0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
        PopupWindow popupWindow = this.f55931c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (this.f55930b == null) {
                View inflate = LayoutInflater.from(this.f55929a.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.f55930b = inflate;
                inflate.setOnClickListener(new c());
            }
            if (this.f55931c == null) {
                PopupWindow popupWindow2 = new PopupWindow(this.f55930b, -2, -2);
                this.f55931c = popupWindow2;
                popupWindow2.setOutsideTouchable(true);
            }
            g.m(this.f55931c, this.f55929a.getPageActivity().findViewById(16908290), 51, this.f55929a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i3 * this.f55929a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i2);
            this.f55932d.postDelayed(this.f55933e, 5000L);
        }
    }
}
