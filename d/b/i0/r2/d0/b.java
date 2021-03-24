package d.b.i0.r2.d0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.b.i0.r2.t;
/* loaded from: classes5.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f59817g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59818h;
    public TextView i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard.g f59819e;

        public a(AdCard.g gVar) {
            this.f59819e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f59829b.getContext();
            AdCard.g gVar = this.f59819e;
            String str = gVar.f20720d;
            String str2 = gVar.f20722f;
            AdvertAppInfo advertAppInfo = b.this.f59831d;
            t.d(context, str, str2, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.i0.r2.b0.c cVar = b.this.f59830c;
            if (cVar != null) {
                cVar.j(302);
                d.b.i0.r2.b0.e.b().d(b.this.f59830c);
            }
            d.b.i0.i1.o.h.b bVar = b.this.f59832e;
            if (bVar != null) {
                d.b.i0.i1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.b.i0.r2.d0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f59818h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.r2.d0.e
    public void d(AdCard.g gVar) {
        super.d(gVar);
        this.f59817g.W(gVar.f20719c, 10, false);
        this.f59818h.setText(gVar.f20718b);
        this.i.setText(gVar.f20721e);
        this.f59829b.setOnClickListener(new a(gVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f59817g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f59817g.setDefaultBgResource(R.color.CAM_X0205);
        this.f59817g.setIsRound(true);
        this.f59818h = (TextView) b(R.id.user_name);
        this.i = (TextView) b(R.id.action);
    }
}
