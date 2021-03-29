package d.b.i0.i0.h;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import d.b.b.e.m.g;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55565a;

    /* renamed from: b  reason: collision with root package name */
    public View f55566b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f55567c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f55568d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public Runnable f55569e = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f55567c != null) {
                g.c(e.this.f55567c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55572f;

        public b(int i, int i2) {
            this.f55571e = i;
            this.f55572f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f55571e, this.f55572f);
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
        this.f55565a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i) {
        if (linkedList != null && linkedList.size() >= 1) {
            int d2 = d(linkedList);
            if (d2 < 0) {
                d.b.h0.r.d0.b.i().s("key_enter_forum_ufan_recent_visit_tip_show", true);
                return;
            } else if (d.b.h0.r.d0.b.i().g("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                return;
            } else {
                this.f55568d.postDelayed(new b(i, d2), 100L);
                return;
            }
        }
        d.b.h0.r.d0.b.i().s("key_enter_forum_ufan_recent_visit_tip_show", true);
    }

    public final int d(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.B()) {
                return i;
            }
        }
        return -1;
    }

    public void e() {
        PopupWindow popupWindow = this.f55567c;
        if (popupWindow != null) {
            g.c(popupWindow);
        }
    }

    public void f() {
        this.f55568d.removeCallbacksAndMessages(null);
    }

    public final void g(int i, int i2) {
        d.b.h0.r.d0.b.i().s("key_enter_forum_ufan_recent_visit_tip_show", true);
        PopupWindow popupWindow = this.f55567c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (this.f55566b == null) {
                View inflate = LayoutInflater.from(this.f55565a.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.f55566b = inflate;
                inflate.setOnClickListener(new c());
            }
            if (this.f55567c == null) {
                PopupWindow popupWindow2 = new PopupWindow(this.f55566b, -2, -2);
                this.f55567c = popupWindow2;
                popupWindow2.setOutsideTouchable(true);
            }
            g.m(this.f55567c, this.f55565a.getPageActivity().findViewById(16908290), 51, this.f55565a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i2 * this.f55565a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i);
            this.f55568d.postDelayed(this.f55569e, 5000L);
        }
    }
}
