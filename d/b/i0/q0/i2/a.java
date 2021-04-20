package d.b.i0.q0.i2;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59362a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f59363b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f59364c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f59365d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59366e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f59367f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59368g;

    /* renamed from: h  reason: collision with root package name */
    public String f59369h;
    public boolean i;
    public final View.OnClickListener j = new View$OnClickListenerC1450a();

    /* renamed from: d.b.i0.q0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1450a implements View.OnClickListener {
        public View$OnClickListenerC1450a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f59363b) {
                if (k.isEmpty(a.this.f59369h) || a.this.f59367f == null || a.this.f59367f.getForum() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(a.this.f59362a, new String[]{a.this.f59369h}, true);
                TiebaStatic.log(new StatisticItem("c13415").param("fid", a.this.f59367f.getForum().getId()).param("obj_type", a.this.i ? 2 : 1));
            } else if ((view != a.this.f59365d && view != a.this.f59366e) || a.this.f59367f == null || a.this.f59367f.getForum() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.f59362a.getPageActivity(), a.this.f59367f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new StatisticItem("c13416").param("fid", a.this.f59367f.getForum().getId()));
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f59362a = frsSportsRecommendFragment.getPageContext();
        this.f59363b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f59364c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f59365d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f59366e = (TextView) view.findViewById(R.id.forum_name);
        this.f59363b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f59365d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f59365d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f59365d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f59365d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f59365d.setShowOval(true);
    }

    public void h() {
        i();
        SkinManager.setViewTextColor(this.f59366e, R.color.CAM_X0101);
        BarImageView barImageView = this.f59365d;
        if (barImageView != null) {
            barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.f59365d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f59365d.setStrokeColorResId(R.color.CAM_X0201);
            this.f59365d.invalidate();
        }
    }

    public final void i() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        FrsViewData frsViewData = this.f59367f;
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
        if (this.f59368g) {
            return;
        }
        LinearGradientView linearGradientView = this.f59364c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f59364c.a(skinType);
        }
        TbImageView tbImageView = this.f59363b;
        if (tbImageView != null) {
            tbImageView.W(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f59367f = frsViewData;
        this.f59368g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f59366e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f59365d.W(this.f59367f.getForum().getImage_url(), 10, false);
        i();
        this.f59365d.setOnClickListener(this.j);
        this.f59366e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        this.f59365d.refresh();
        if (k.isEmpty(str)) {
            this.f59368g = false;
            i();
            return;
        }
        this.f59368g = true;
        this.f59369h = str2;
        this.i = z;
        this.f59363b.W(str, 10, false);
        this.f59363b.setOnClickListener(this.j);
    }
}
