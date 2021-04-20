package d.b.i0.i0.h;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import d.b.c.e.m.g;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56688a;

    /* renamed from: b  reason: collision with root package name */
    public View f56689b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f56690c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f56691d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public Runnable f56692e = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f56690c != null) {
                g.c(e.this.f56690c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56695f;

        public b(int i, int i2) {
            this.f56694e = i;
            this.f56695f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g(this.f56694e, this.f56695f);
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
        this.f56688a = tbPageContext;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i) {
        if (linkedList != null && linkedList.size() >= 1) {
            int d2 = d(linkedList);
            if (d2 < 0) {
                d.b.h0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
                return;
            } else if (d.b.h0.r.d0.b.j().g("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                return;
            } else {
                this.f56691d.postDelayed(new b(i, d2), 100L);
                return;
            }
        }
        d.b.h0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
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
        PopupWindow popupWindow = this.f56690c;
        if (popupWindow != null) {
            g.c(popupWindow);
        }
    }

    public void f() {
        this.f56691d.removeCallbacksAndMessages(null);
    }

    public final void g(int i, int i2) {
        d.b.h0.r.d0.b.j().t("key_enter_forum_ufan_recent_visit_tip_show", true);
        PopupWindow popupWindow = this.f56690c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (this.f56689b == null) {
                View inflate = LayoutInflater.from(this.f56688a.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.f56689b = inflate;
                inflate.setOnClickListener(new c());
            }
            if (this.f56690c == null) {
                PopupWindow popupWindow2 = new PopupWindow(this.f56689b, -2, -2);
                this.f56690c = popupWindow2;
                popupWindow2.setOutsideTouchable(true);
            }
            g.m(this.f56690c, this.f56688a.getPageActivity().findViewById(16908290), 51, this.f56688a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i2 * this.f56688a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i);
            this.f56691d.postDelayed(this.f56692e, 5000L);
        }
    }
}
