package d.b.i0.p0.n2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public boolean f58114f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f58115g;

    /* renamed from: h  reason: collision with root package name */
    public View f58116h;
    public PopupWindow i;

    /* renamed from: e  reason: collision with root package name */
    public int f58113e = R.string.attention_post_update_tip;
    public Handler j = new Handler();
    public Runnable k = new RunnableC1411a();

    /* renamed from: d.b.i0.p0.n2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1411a implements Runnable {

        /* renamed from: d.b.i0.p0.n2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1412a implements Runnable {
            public RunnableC1412a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.i != null) {
                    a.this.j();
                }
            }
        }

        public RunnableC1411a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f58115g == null || a.this.f58116h == null) {
                return;
            }
            Activity pageActivity = a.this.f58115g.getPageActivity();
            int g2 = d.b.b.e.p.l.g(pageActivity, R.dimen.ds64);
            a aVar = a.this;
            View h2 = aVar.h(pageActivity, aVar.f58113e);
            int[] iArr = new int[2];
            a.this.f58116h.getLocationInWindow(iArr);
            int g3 = d.b.b.e.p.l.g(pageActivity, R.dimen.ds32);
            int g4 = (iArr[1] - g2) + d.b.b.e.p.l.g(pageActivity, R.dimen.ds16);
            a.this.i = new PopupWindow(h2, -2, g2);
            a.this.i.showAtLocation(a.this.f58116h, 53, g3, g4);
            a.this.j.postDelayed(new RunnableC1412a(), 3000L);
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f58115g = tbPageContext;
        this.f58114f = z;
    }

    public final View h(Activity activity, int i) {
        TextView textView = new TextView(activity);
        int g2 = d.b.b.e.p.l.g(activity, R.dimen.ds20);
        textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g2, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, d.b.b.e.p.l.g(activity, R.dimen.fontsize28));
        textView.setText(i);
        textView.setOnClickListener(this);
        SkinManager.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        textView.setOnClickListener(this);
        return textView;
    }

    public void i() {
        this.j.removeCallbacksAndMessages(null);
        j();
    }

    public void j() {
        PopupWindow popupWindow = this.i;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.i = null;
        }
    }

    public void k(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.f58115g == null || view == null || StringUtils.isNull(currentAccount)) {
            return;
        }
        this.f58116h = view;
        if (this.f58114f) {
            this.f58113e = R.string.attention_post_update_tip;
            String str = currentAccount + "frs_god_new_post_tip_count";
            int j = d.b.h0.r.d0.b.i().j(str, 0);
            if (j >= 3) {
                this.f58114f = false;
                return;
            }
            d.b.h0.r.d0.b.i().u(str, j + 1);
            this.f58114f = false;
            this.j.postDelayed(this.k, 500L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j();
    }
}
