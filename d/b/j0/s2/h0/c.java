package d.b.j0.s2.h0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.b.j0.s2.w;
/* loaded from: classes4.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f62144g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62145h;
    public TextView i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.s2.c0.b.e f62146e;

        public a(d.b.j0.s2.c0.b.e eVar) {
            this.f62146e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f62152b.getContext();
            String str = this.f62146e.f62020d;
            AdvertAppInfo advertAppInfo = c.this.f62154d;
            w.d(context, str, null, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.j0.s2.f0.c cVar = c.this.f62153c;
            if (cVar != null) {
                cVar.j(302);
                d.b.j0.s2.f0.e.b().d(c.this.f62153c);
            }
            d.b.j0.j1.o.h.b bVar = c.this.f62155e;
            if (bVar != null) {
                d.b.j0.j1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.j0.s2.h0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.b.j0.s2.h0.e
    public void c() {
        SkinManager.setViewTextColor(this.f62145h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.s2.h0.e
    public void d(d.b.j0.s2.c0.b.e eVar) {
        super.d(eVar);
        this.f62144g.W(eVar.f62019c, 10, false);
        this.f62145h.setText(eVar.f62018b);
        this.i.setText(eVar.f62021e);
        this.f62152b.setOnClickListener(new a(eVar));
        this.j.f(eVar.f62024h);
        c();
    }

    @Override // d.b.j0.s2.h0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.b.j0.s2.h0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f62144g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f62144g.setDefaultBgResource(R.color.CAM_X0205);
        this.f62144g.setIsRound(true);
        this.f62145h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.i = (TextView) b(R.id.action);
    }
}
