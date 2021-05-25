package d.a.n0.t2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.n0.t2.f0.b.f;
import d.a.n0.t2.y;
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61181g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61182h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61183i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f61184e;

        public a(f fVar) {
            this.f61184e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f61190b.getContext();
            String str = this.f61184e.f61080d;
            AdvertAppInfo advertAppInfo = c.this.f61192d;
            y.d(context, str, null, advertAppInfo != null ? advertAppInfo.N3 : "");
            d.a.n0.t2.i0.c cVar = c.this.f61191c;
            if (cVar != null) {
                cVar.i(302);
                d.a.n0.t2.i0.e.b().d(c.this.f61191c);
            }
            d.a.n0.k1.o.h.b bVar = c.this.f61193e;
            if (bVar != null) {
                d.a.n0.k1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.n0.t2.j0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.a.n0.t2.j0.e
    public void c() {
        SkinManager.setViewTextColor(this.f61182h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f61183i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f61183i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.t2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f61181g.V(fVar.f61079c, 10, false);
        this.f61182h.setText(fVar.f61078b);
        this.f61183i.setText(fVar.f61081e);
        this.f61190b.setOnClickListener(new a(fVar));
        this.j.f(fVar.f61084h);
        c();
    }

    @Override // d.a.n0.t2.j0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.a.n0.t2.j0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f61181g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61181g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61181g.setIsRound(true);
        this.f61182h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.f61183i = (TextView) b(R.id.action);
    }
}
