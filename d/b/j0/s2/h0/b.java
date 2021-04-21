package d.b.j0.s2.h0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.j0.s2.w;
/* loaded from: classes4.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f62140g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62141h;
    public TextView i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.s2.c0.b.e f62142e;

        public a(d.b.j0.s2.c0.b.e eVar) {
            this.f62142e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f62152b.getContext();
            d.b.j0.s2.c0.b.e eVar = this.f62142e;
            String str = eVar.f62020d;
            String str2 = eVar.f62022f;
            AdvertAppInfo advertAppInfo = b.this.f62154d;
            w.d(context, str, str2, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.j0.s2.f0.c cVar = b.this.f62153c;
            if (cVar != null) {
                cVar.j(302);
                d.b.j0.s2.f0.e.b().d(b.this.f62153c);
            }
            d.b.j0.j1.o.h.b bVar = b.this.f62155e;
            if (bVar != null) {
                d.b.j0.j1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.j0.s2.h0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f62141h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.s2.h0.e
    public void d(d.b.j0.s2.c0.b.e eVar) {
        super.d(eVar);
        this.f62140g.W(eVar.f62019c, 10, false);
        this.f62141h.setText(eVar.f62018b);
        this.i.setText(eVar.f62021e);
        this.f62152b.setOnClickListener(new a(eVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f62140g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f62140g.setDefaultBgResource(R.color.CAM_X0205);
        this.f62140g.setIsRound(true);
        this.f62141h = (TextView) b(R.id.user_name);
        this.i = (TextView) b(R.id.action);
    }
}
