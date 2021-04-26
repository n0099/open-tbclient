package d.a.j0.s2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.j0.s2.x;
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f60344g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60345h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60346i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.s2.e0.b.e f60347e;

        public a(d.a.j0.s2.e0.b.e eVar) {
            this.f60347e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = c.this.f60353b.getContext();
            String str = this.f60347e.f60233d;
            AdvertAppInfo advertAppInfo = c.this.f60355d;
            x.d(context, str, null, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.a.j0.s2.h0.c cVar = c.this.f60354c;
            if (cVar != null) {
                cVar.j(302);
                d.a.j0.s2.h0.e.b().d(c.this.f60354c);
            }
            d.a.j0.j1.o.h.b bVar = c.this.f60356e;
            if (bVar != null) {
                d.a.j0.j1.o.h.c.h(bVar);
            }
            c.this.a(false);
        }
    }

    public c(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.j0.s2.j0.e
    public void a(boolean z) {
        this.k = z;
        CountDownTextView countDownTextView = this.j;
        if (countDownTextView != null) {
            countDownTextView.setEnableTimeoutListener(z);
        }
    }

    @Override // d.a.j0.s2.j0.e
    public void c() {
        SkinManager.setViewTextColor(this.f60345h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f60346i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f60346i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.s2.j0.e
    public void d(d.a.j0.s2.e0.b.e eVar) {
        super.d(eVar);
        this.f60344g.V(eVar.f60232c, 10, false);
        this.f60345h.setText(eVar.f60231b);
        this.f60346i.setText(eVar.f60234e);
        this.f60353b.setOnClickListener(new a(eVar));
        this.j.f(eVar.f60237h);
        c();
    }

    @Override // d.a.j0.s2.j0.e
    public void e() {
        super.e();
        this.j.e();
    }

    @Override // d.a.j0.s2.j0.e
    public void l(CountDownTextView.c cVar) {
        super.l(cVar);
        this.j.setTimeoutListener(cVar);
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f60344g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f60344g.setDefaultBgResource(R.color.CAM_X0205);
        this.f60344g.setIsRound(true);
        this.f60345h = (TextView) b(R.id.user_name);
        this.j = (CountDownTextView) b(R.id.count_down_text);
        this.f60346i = (TextView) b(R.id.action);
    }
}
