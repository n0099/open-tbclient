package d.a.n0.r0.i2;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58735a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f58736b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f58737c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f58738d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58739e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f58740f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58741g;

    /* renamed from: h  reason: collision with root package name */
    public String f58742h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58743i;
    public final View.OnClickListener j = new View$OnClickListenerC1499a();

    /* renamed from: d.a.n0.r0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1499a implements View.OnClickListener {
        public View$OnClickListenerC1499a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f58736b) {
                if (k.isEmpty(a.this.f58742h) || a.this.f58740f == null || a.this.f58740f.getForum() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(a.this.f58735a, new String[]{a.this.f58742h}, true);
                TiebaStatic.log(new StatisticItem("c13415").param("fid", a.this.f58740f.getForum().getId()).param("obj_type", a.this.f58743i ? 2 : 1));
            } else if ((view != a.this.f58738d && view != a.this.f58739e) || a.this.f58740f == null || a.this.f58740f.getForum() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.f58735a.getPageActivity(), a.this.f58740f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new StatisticItem("c13416").param("fid", a.this.f58740f.getForum().getId()));
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f58735a = frsSportsRecommendFragment.getPageContext();
        this.f58736b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f58737c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f58738d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f58739e = (TextView) view.findViewById(R.id.forum_name);
        this.f58736b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f58738d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f58738d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f58738d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f58738d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f58738d.setShowOval(true);
    }

    public void h() {
        i();
        SkinManager.setViewTextColor(this.f58739e, R.color.CAM_X0101);
        BarImageView barImageView = this.f58738d;
        if (barImageView != null) {
            barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.f58738d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f58738d.setStrokeColorResId(R.color.CAM_X0201);
            this.f58738d.invalidate();
        }
    }

    public final void i() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        FrsViewData frsViewData = this.f58740f;
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
        if (this.f58741g) {
            return;
        }
        LinearGradientView linearGradientView = this.f58737c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f58737c.a(skinType);
        }
        TbImageView tbImageView = this.f58736b;
        if (tbImageView != null) {
            tbImageView.V(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f58740f = frsViewData;
        this.f58741g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f58739e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f58738d.V(this.f58740f.getForum().getImage_url(), 10, false);
        i();
        this.f58738d.setOnClickListener(this.j);
        this.f58739e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        this.f58738d.refresh();
        if (k.isEmpty(str)) {
            this.f58741g = false;
            i();
            return;
        }
        this.f58741g = true;
        this.f58742h = str2;
        this.f58743i = z;
        this.f58736b.V(str, 10, false);
        this.f58736b.setOnClickListener(this.j);
    }
}
