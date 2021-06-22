package d.a.o0.r0.i2;

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
    public TbPageContext f62551a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f62552b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f62553c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f62554d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62555e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f62556f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62557g;

    /* renamed from: h  reason: collision with root package name */
    public String f62558h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62559i;
    public final View.OnClickListener j = new View$OnClickListenerC1559a();

    /* renamed from: d.a.o0.r0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1559a implements View.OnClickListener {
        public View$OnClickListenerC1559a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f62552b) {
                if (k.isEmpty(a.this.f62558h) || a.this.f62556f == null || a.this.f62556f.getForum() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(a.this.f62551a, new String[]{a.this.f62558h}, true);
                TiebaStatic.log(new StatisticItem("c13415").param("fid", a.this.f62556f.getForum().getId()).param("obj_type", a.this.f62559i ? 2 : 1));
            } else if ((view != a.this.f62554d && view != a.this.f62555e) || a.this.f62556f == null || a.this.f62556f.getForum() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.f62551a.getPageActivity(), a.this.f62556f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new StatisticItem("c13416").param("fid", a.this.f62556f.getForum().getId()));
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f62551a = frsSportsRecommendFragment.getPageContext();
        this.f62552b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f62553c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f62554d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f62555e = (TextView) view.findViewById(R.id.forum_name);
        this.f62552b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f62554d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f62554d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62554d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f62554d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f62554d.setShowOval(true);
    }

    public void h() {
        i();
        SkinManager.setViewTextColor(this.f62555e, R.color.CAM_X0101);
        BarImageView barImageView = this.f62554d;
        if (barImageView != null) {
            barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.f62554d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f62554d.setStrokeColorResId(R.color.CAM_X0201);
            this.f62554d.invalidate();
        }
    }

    public final void i() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        FrsViewData frsViewData = this.f62556f;
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
        if (this.f62557g) {
            return;
        }
        LinearGradientView linearGradientView = this.f62553c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f62553c.a(skinType);
        }
        TbImageView tbImageView = this.f62552b;
        if (tbImageView != null) {
            tbImageView.U(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f62556f = frsViewData;
        this.f62557g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f62555e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f62554d.U(this.f62556f.getForum().getImage_url(), 10, false);
        i();
        this.f62554d.setOnClickListener(this.j);
        this.f62555e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        this.f62554d.refresh();
        if (k.isEmpty(str)) {
            this.f62557g = false;
            i();
            return;
        }
        this.f62557g = true;
        this.f62558h = str2;
        this.f62559i = z;
        this.f62552b.U(str, 10, false);
        this.f62552b.setOnClickListener(this.j);
    }
}
