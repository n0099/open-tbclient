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
    public HeadImageView f59818g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59819h;
    public TextView i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard.g f59820e;

        public a(AdCard.g gVar) {
            this.f59820e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f59830b.getContext();
            AdCard.g gVar = this.f59820e;
            String str = gVar.f20721d;
            String str2 = gVar.f20723f;
            AdvertAppInfo advertAppInfo = b.this.f59832d;
            t.d(context, str, str2, advertAppInfo != null ? advertAppInfo.T3 : "");
            d.b.i0.r2.b0.c cVar = b.this.f59831c;
            if (cVar != null) {
                cVar.j(302);
                d.b.i0.r2.b0.e.b().d(b.this.f59831c);
            }
            d.b.i0.i1.o.h.b bVar = b.this.f59833e;
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
        SkinManager.setViewTextColor(this.f59819h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.r2.d0.e
    public void d(AdCard.g gVar) {
        super.d(gVar);
        this.f59818g.W(gVar.f20720c, 10, false);
        this.f59819h.setText(gVar.f20719b);
        this.i.setText(gVar.f20722e);
        this.f59830b.setOnClickListener(new a(gVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f59818g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f59818g.setDefaultBgResource(R.color.CAM_X0205);
        this.f59818g.setIsRound(true);
        this.f59819h = (TextView) b(R.id.user_name);
        this.i = (TextView) b(R.id.action);
    }
}
