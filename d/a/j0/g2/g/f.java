package d.a.j0.g2.g;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.g2.e.g;
/* loaded from: classes4.dex */
public class f extends d.a.j0.x.b<d.a.j0.g2.e.g> {
    public View m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public d.a.j0.g2.e.g q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f54615e;

        public a(g.a aVar) {
            this.f54615e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.u(this.f54615e);
        }
    }

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.m = l.findViewById(R.id.create_center_container);
        this.n = (TextView) l.findViewById(R.id.text_create_center);
        ImageView imageView = (ImageView) l.findViewById(R.id.img_arrow);
        this.o = imageView;
        imageView.setOnClickListener(this);
        this.p = (LinearLayout) l.findViewById(R.id.func_entrance);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.person_create_center;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        for (int i3 = 0; i3 < this.p.getChildCount(); i3++) {
            SkinManager.setViewTextColor((TextView) this.p.getChildAt(i3).findViewById(R.id.create_center_item_text), R.color.CAM_X0105);
        }
        TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(l.g(this.f62438g, R.dimen.tbds21)).setBgColor(R.color.CAM_X0201).setShadowColor(R.color.CAM_X0806).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f62438g, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.g(this.f62438g, R.dimen.tbds5)).into(this.m);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.o.getId()) {
            w(R.string.create_center, TbConfig.URL_CREATE_CENTER);
            TiebaStatic.log("c13842");
        }
    }

    public final View t(Context context, g.a aVar) {
        if (aVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setId(R.id.create_center_item_img);
        tbImageView.setImageResource(aVar.f54573b);
        int g2 = l.g(context, R.dimen.tbds126);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(g2, g2));
        TextView textView = new TextView(context);
        textView.setId(R.id.create_center_item_text);
        textView.setText(aVar.f54574c);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, l.g(this.f62438g, R.dimen.tbfontsize32));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(context, R.dimen.tbds32);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new a(aVar));
        return linearLayout;
    }

    public final void u(g.a aVar) {
        d.a.j0.g2.e.g gVar;
        if (aVar == null || (gVar = this.q) == null || gVar.f54571f == null) {
            return;
        }
        int i2 = aVar.f54572a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f62437f.getPageActivity(), this.q.f54571f.getUserId(), this.q.f54571f.getSex(), this.q.f54571f.getPortrait())));
            TiebaStatic.log("c13843");
        } else if (i2 == 2) {
            w(R.string.god_authentication, TbConfig.URL_GOD_AUTH);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 1));
        } else if (i2 == 5) {
            w(R.string.god_examination, TbConfig.URL_GOD_EXAMINE);
            TiebaStatic.log(new StatisticItem("c13844").param("obj_type", 2));
        } else if (i2 == 3) {
            w(R.string.create_college, TbConfig.URL_CREATE_COLLEGE);
            TiebaStatic.log("c13845");
        } else if (i2 == 4) {
            w(R.string.hot_activities, TbConfig.URL_HOT_ACTIVITIES);
            TiebaStatic.log("c13846");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: v */
    public void m(d.a.j0.g2.e.g gVar) {
        if (gVar == null || ListUtils.isEmpty(gVar.f54570e)) {
            return;
        }
        if (gVar != this.q) {
            this.p.removeAllViews();
            int k = (l.k(this.f62438g) - (l.g(this.f62438g, R.dimen.tbds44) * 2)) / gVar.f54570e.size();
            for (g.a aVar : gVar.f54570e) {
                if (aVar != null) {
                    this.p.addView(t(this.f62438g, aVar), new LinearLayout.LayoutParams(k, -2));
                }
            }
            this.q = gVar;
        }
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void w(int i2, String str) {
        this.f62437f.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f62437f.getPageActivity(), this.f62437f.getString(i2), str, true)));
    }
}
