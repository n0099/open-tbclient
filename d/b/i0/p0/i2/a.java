package d.b.i0.p0.i2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57662a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f57663b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f57664c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f57665d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57666e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f57667f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57668g;

    /* renamed from: h  reason: collision with root package name */
    public String f57669h;
    public boolean i;
    public final View.OnClickListener j = new View$OnClickListenerC1387a();

    /* renamed from: d.b.i0.p0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1387a implements View.OnClickListener {
        public View$OnClickListenerC1387a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f57663b) {
                if (k.isEmpty(a.this.f57669h) || a.this.f57667f == null || a.this.f57667f.getForum() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(a.this.f57662a, new String[]{a.this.f57669h}, true);
                TiebaStatic.log(new StatisticItem("c13415").param("fid", a.this.f57667f.getForum().getId()).param("obj_type", a.this.i ? 2 : 1));
            } else if ((view != a.this.f57665d && view != a.this.f57666e) || a.this.f57667f == null || a.this.f57667f.getForum() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.f57662a.getPageActivity(), a.this.f57667f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new StatisticItem("c13416").param("fid", a.this.f57667f.getForum().getId()));
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f57662a = frsSportsRecommendFragment.getPageContext();
        this.f57663b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f57664c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f57665d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f57666e = (TextView) view.findViewById(R.id.forum_name);
        this.f57663b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f57665d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f57665d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f57665d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f57665d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f57665d.setShowOval(true);
    }

    public void h() {
        i();
        SkinManager.setViewTextColor(this.f57666e, R.color.CAM_X0101);
        BarImageView barImageView = this.f57665d;
        if (barImageView != null) {
            barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.f57665d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f57665d.setStrokeColorResId(R.color.CAM_X0201);
            this.f57665d.invalidate();
        }
    }

    public final void i() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        FrsViewData frsViewData = this.f57667f;
        if (frsViewData == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        if (this.f57668g) {
            return;
        }
        LinearGradientView linearGradientView = this.f57664c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f57664c.a(skinType);
        }
        TbImageView tbImageView = this.f57663b;
        if (tbImageView != null) {
            tbImageView.W(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f57667f = frsViewData;
        this.f57668g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f57666e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f57665d.W(this.f57667f.getForum().getImage_url(), 10, false);
        i();
        this.f57665d.setOnClickListener(this.j);
        this.f57666e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        this.f57665d.refresh();
        if (k.isEmpty(str)) {
            this.f57668g = false;
            i();
            return;
        }
        this.f57668g = true;
        this.f57669h = str2;
        this.i = z;
        this.f57663b.W(str, 10, false);
        this.f57663b.setOnClickListener(this.j);
    }
}
