package d.a.k0.i0.h;

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
    public TbPageContext<?> f55745a;

    /* renamed from: b  reason: collision with root package name */
    public View f55746b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f55747c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f55748d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public Runnable f55749e = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f55747c != null) {
                g.c(e.this.f55747c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55751e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55752f;

        public b(int i2, int i3) {
            this.f55751e = i2;
            this.f55752f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f55751e, this.f55752f);
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
        this.f55745a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i2) {
        if (linkedList != null && linkedList.size() >= 1) {
            int d2 = d(linkedList);
            if (d2 < 0) {
                d.a.j0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
                return;
            } else if (d.a.j0.r.d0.b.j().g("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                return;
            } else {
                this.f55748d.postDelayed(new b(i2, d2), 100L);
                return;
            }
        }
        d.a.j0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
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
        PopupWindow popupWindow = this.f55747c;
        if (popupWindow != null) {
            g.c(popupWindow);
        }
    }

    public void f() {
        this.f55748d.removeCallbacksAndMessages(null);
    }

    public final void g(int i2, int i3) {
        d.a.j0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
        PopupWindow popupWindow = this.f55747c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (this.f55746b == null) {
                View inflate = LayoutInflater.from(this.f55745a.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.f55746b = inflate;
                inflate.setOnClickListener(new c());
            }
            if (this.f55747c == null) {
                PopupWindow popupWindow2 = new PopupWindow(this.f55746b, -2, -2);
                this.f55747c = popupWindow2;
                popupWindow2.setOutsideTouchable(true);
            }
            g.m(this.f55747c, this.f55745a.getPageActivity().findViewById(16908290), 51, this.f55745a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i3 * this.f55745a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i2);
            this.f55748d.postDelayed(this.f55749e, 5000L);
        }
    }
}
