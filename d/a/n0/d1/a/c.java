package d.a.n0.d1.a;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListNormaItemHolder;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.n0.d1.c.c, HotRankListNormaItemHolder> {
    public int m;
    public TbPageContext n;
    public String o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.c f52462e;

        public a(d.a.n0.d1.c.c cVar) {
            this.f52462e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.n != null) {
                String i2 = this.f52462e.i();
                if (!StringUtils.isNull(i2)) {
                    UrlManager.getInstance().dealOneLink(c.this.n, new String[]{i2});
                }
            }
            TiebaStatic.log("c10820");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.d1.c.c f52464e;

        public b(d.a.n0.d1.c.c cVar) {
            this.f52464e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f52464e.e()), this.f52464e.h(), "5")));
            TiebaStatic.log(new StatisticItem("c11237").param("obj_id", String.valueOf(this.f52464e.e())).param("obj_locate", c.this.o));
        }
    }

    public c(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.n = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        j0(i2, view, viewGroup, cVar, hotRankListNormaItemHolder);
        return view;
    }

    public final void g0(int i2, HotRankListNormaItemHolder hotRankListNormaItemHolder, d.a.n0.d1.c.c cVar) {
        if (hotRankListNormaItemHolder == null || cVar == null) {
            return;
        }
        hotRankListNormaItemHolder.f16788h.setVisibility(8);
        if (cVar.m() == 1) {
            hotRankListNormaItemHolder.f16782b.setText("");
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16782b, R.drawable.icon_grade_shaitu1);
            hotRankListNormaItemHolder.f16788h.setVisibility(0);
            hotRankListNormaItemHolder.f16789i.setText(m0(StringUtils.isNull(cVar.f()) ? this.f39228e.getResources().getString(R.string.hot_topic_hot_list) : cVar.f(), StringUtils.isNull(cVar.l()) ? this.f39228e.getResources().getString(R.string.hot_topic_update_time) : cVar.l()));
            hotRankListNormaItemHolder.f16785e.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.l, R.drawable.hot_topic_ranklist_bg);
            hotRankListNormaItemHolder.l.setOnClickListener(new a(cVar));
        } else if (cVar.m() == 2) {
            hotRankListNormaItemHolder.f16782b.setText("");
            hotRankListNormaItemHolder.f16785e.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16782b, R.drawable.icon_grade_shaitu2);
        } else if (cVar.m() == 3) {
            hotRankListNormaItemHolder.f16782b.setText("");
            hotRankListNormaItemHolder.f16785e.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16782b, R.drawable.icon_grade_shaitu3);
        } else {
            String str = "" + cVar.m();
            if (cVar.m() < 10) {
                str = "0" + str;
            }
            hotRankListNormaItemHolder.f16782b.setText(str);
            hotRankListNormaItemHolder.f16785e.setVisibility(8);
            hotRankListNormaItemHolder.f16782b.setBackgroundDrawable(null);
        }
        if (cVar.k() == 1) {
            hotRankListNormaItemHolder.f16787g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16787g, R.drawable.icon_topic_ranklist_new);
        } else if (cVar.k() == 2) {
            hotRankListNormaItemHolder.f16787g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16787g, R.drawable.icon_topic_ranklist_hot);
        } else if (cVar.k() == 3) {
            hotRankListNormaItemHolder.f16787g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f16787g, R.drawable.icon_topic_ranklist_tuijian);
        } else {
            hotRankListNormaItemHolder.f16787g.setVisibility(8);
        }
        String numFormat9999W = StringHelper.numFormat9999W(cVar.c());
        hotRankListNormaItemHolder.f16783c.setText(TextUtils.isEmpty(cVar.h()) ? "" : UtilHelper.getFixedText(cVar.h(), 10));
        hotRankListNormaItemHolder.f16784d.setText(numFormat9999W);
        hotRankListNormaItemHolder.k.setOnClickListener(new b(cVar));
    }

    public final void h0(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (hotRankListNormaItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListNormaItemHolder.f16781a != skinType) {
            hotRankListNormaItemHolder.f16781a = skinType;
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f16782b, R.color.CAM_X0110, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f16783c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f16784d, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.f16785e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.f16786f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.k, R.drawable.hot_topic_ranklist_bg);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.j, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f16789i, R.color.CAM_X0109, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public HotRankListNormaItemHolder P(ViewGroup viewGroup) {
        return new HotRankListNormaItemHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.hot_topic_ranklist_normal_item, viewGroup, false));
    }

    public View j0(int i2, View view, ViewGroup viewGroup, d.a.n0.d1.c.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        if (cVar != null) {
            h0(hotRankListNormaItemHolder);
            g0(i2, hotRankListNormaItemHolder, cVar);
        }
        return view;
    }

    public final SpannableString m0(String str, String str2) {
        int length = !StringUtils.isNull(str) ? str.length() : 0;
        int length2 = !StringUtils.isNull(str2) ? str2.length() : 0;
        SpannableString spannableString = new SpannableString("" + str + str2);
        if (length > 0 && length2 > 0) {
            spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), R.style.hot_ranklist_module_name_stysle), 0, length, 33);
            spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), R.style.hot_ranklist_module_tip_stysle), length, spannableString.length(), 33);
        }
        return spannableString;
    }

    public void n0(String str) {
        this.o = str;
    }
}
