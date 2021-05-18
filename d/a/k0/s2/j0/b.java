package d.a.k0.s2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.k0.s2.f0.b.f;
import d.a.k0.s2.y;
/* loaded from: classes5.dex */
public class b extends e {

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f61074g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61075h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61076i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f61077e;

        public a(f fVar) {
            this.f61077e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = b.this.f61088b.getContext();
            f fVar = this.f61077e;
            String str = fVar.f60978d;
            String str2 = fVar.f60980f;
            AdvertAppInfo advertAppInfo = b.this.f61090d;
            y.d(context, str, str2, advertAppInfo != null ? advertAppInfo.M3 : "");
            d.a.k0.s2.i0.c cVar = b.this.f61089c;
            if (cVar != null) {
                cVar.i(302);
                d.a.k0.s2.i0.e.b().d(b.this.f61089c);
            }
            d.a.k0.j1.o.h.b bVar = b.this.f61091e;
            if (bVar != null) {
                d.a.k0.j1.o.h.c.h(bVar);
            }
        }
    }

    public b(View view, String str) {
        super(view, str);
        m();
    }

    @Override // d.a.k0.s2.j0.e
    public void c() {
        super.c();
        SkinManager.setViewTextColor(this.f61075h, R.color.CAM_X0620, 1);
        SkinManager.setViewTextColor(this.f61076i, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.f61076i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.s2.j0.e
    public void d(f fVar) {
        super.d(fVar);
        this.f61074g.V(fVar.f60977c, 10, false);
        this.f61075h.setText(fVar.f60976b);
        this.f61076i.setText(fVar.f60979e);
        this.f61088b.setOnClickListener(new a(fVar));
        c();
    }

    public final void m() {
        HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
        this.f61074g = headImageView;
        headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
        this.f61074g.setDefaultBgResource(R.color.CAM_X0205);
        this.f61074g.setIsRound(true);
        this.f61075h = (TextView) b(R.id.user_name);
        this.f61076i = (TextView) b(R.id.action);
    }
}
