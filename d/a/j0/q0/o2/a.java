package d.a.j0.q0.o2;

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
    public boolean f58315f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f58316g;

    /* renamed from: h  reason: collision with root package name */
    public View f58317h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f58318i;

    /* renamed from: e  reason: collision with root package name */
    public int f58314e = R.string.attention_post_update_tip;
    public Handler j = new Handler();
    public Runnable k = new RunnableC1439a();

    /* renamed from: d.a.j0.q0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1439a implements Runnable {

        /* renamed from: d.a.j0.q0.o2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1440a implements Runnable {
            public RunnableC1440a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f58318i != null) {
                    a.this.j();
                }
            }
        }

        public RunnableC1439a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f58316g == null || a.this.f58317h == null) {
                return;
            }
            Activity pageActivity = a.this.f58316g.getPageActivity();
            int g2 = d.a.c.e.p.l.g(pageActivity, R.dimen.ds64);
            a aVar = a.this;
            View h2 = aVar.h(pageActivity, aVar.f58314e);
            int[] iArr = new int[2];
            a.this.f58317h.getLocationInWindow(iArr);
            int g3 = d.a.c.e.p.l.g(pageActivity, R.dimen.ds32);
            int g4 = (iArr[1] - g2) + d.a.c.e.p.l.g(pageActivity, R.dimen.ds16);
            a.this.f58318i = new PopupWindow(h2, -2, g2);
            a.this.f58318i.showAtLocation(a.this.f58317h, 53, g3, g4);
            a.this.j.postDelayed(new RunnableC1440a(), 3000L);
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        this.f58316g = tbPageContext;
        this.f58315f = z;
    }

    public final View h(Activity activity, int i2) {
        TextView textView = new TextView(activity);
        int g2 = d.a.c.e.p.l.g(activity, R.dimen.ds20);
        textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g2, 0);
        textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
        textView.setGravity(17);
        textView.setTextSize(0, d.a.c.e.p.l.g(activity, R.dimen.fontsize28));
        textView.setText(i2);
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
        PopupWindow popupWindow = this.f58318i;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f58318i = null;
        }
    }

    public void k(View view) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.f58316g == null || view == null || StringUtils.isNull(currentAccount)) {
            return;
        }
        this.f58317h = view;
        if (this.f58315f) {
            this.f58314e = R.string.attention_post_update_tip;
            String str = currentAccount + "frs_god_new_post_tip_count";
            int k = d.a.i0.r.d0.b.j().k(str, 0);
            if (k >= 3) {
                this.f58315f = false;
                return;
            }
            d.a.i0.r.d0.b.j().v(str, k + 1);
            this.f58315f = false;
            this.j.postDelayed(this.k, 500L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j();
    }
}
