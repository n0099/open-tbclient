package d.a.p0.g1.a;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes8.dex */
public class c extends d.a.c.k.e.a<d.a.p0.g1.c.c, HotRankListNormaItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext n;
    public String o;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.c f56305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f56306f;

        public a(c cVar, d.a.p0.g1.c.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56306f = cVar;
            this.f56305e = cVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56306f.n != null) {
                    String h2 = this.f56305e.h();
                    if (!StringUtils.isNull(h2)) {
                        UrlManager.getInstance().dealOneLink(this.f56306f.n, new String[]{h2});
                    }
                }
                TiebaStatic.log("c10820");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.g1.c.c f56307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f56308f;

        public b(c cVar, d.a.p0.g1.c.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56308f = cVar;
            this.f56307e = cVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f56307e.c()), this.f56307e.e(), "5")));
                TiebaStatic.log(new StatisticItem("c11237").param("obj_id", String.valueOf(this.f56307e.c())).param("obj_locate", this.f56308f.o));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = hotRanklistActivity.getPageContext();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.p0.g1.c.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        k0(i2, view, viewGroup, cVar, hotRankListNormaItemHolder);
        return view;
    }

    public final void h0(int i2, HotRankListNormaItemHolder hotRankListNormaItemHolder, d.a.p0.g1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, hotRankListNormaItemHolder, cVar) == null) || hotRankListNormaItemHolder == null || cVar == null) {
            return;
        }
        hotRankListNormaItemHolder.f17111h.setVisibility(8);
        if (cVar.l() == 1) {
            hotRankListNormaItemHolder.f17105b.setText("");
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17105b, R.drawable.icon_grade_shaitu1);
            hotRankListNormaItemHolder.f17111h.setVisibility(0);
            hotRankListNormaItemHolder.f17112i.setText(l0(StringUtils.isNull(cVar.d()) ? this.f41837e.getResources().getString(R.string.hot_topic_hot_list) : cVar.d(), StringUtils.isNull(cVar.j()) ? this.f41837e.getResources().getString(R.string.hot_topic_update_time) : cVar.j()));
            hotRankListNormaItemHolder.f17108e.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.l, R.drawable.hot_topic_ranklist_bg);
            hotRankListNormaItemHolder.l.setOnClickListener(new a(this, cVar));
        } else if (cVar.l() == 2) {
            hotRankListNormaItemHolder.f17105b.setText("");
            hotRankListNormaItemHolder.f17108e.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17105b, R.drawable.icon_grade_shaitu2);
        } else if (cVar.l() == 3) {
            hotRankListNormaItemHolder.f17105b.setText("");
            hotRankListNormaItemHolder.f17108e.setVisibility(8);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17105b, R.drawable.icon_grade_shaitu3);
        } else {
            String str = "" + cVar.l();
            if (cVar.l() < 10) {
                str = "0" + str;
            }
            hotRankListNormaItemHolder.f17105b.setText(str);
            hotRankListNormaItemHolder.f17108e.setVisibility(8);
            hotRankListNormaItemHolder.f17105b.setBackgroundDrawable(null);
        }
        if (cVar.i() == 1) {
            hotRankListNormaItemHolder.f17110g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17110g, R.drawable.icon_topic_ranklist_new);
        } else if (cVar.i() == 2) {
            hotRankListNormaItemHolder.f17110g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17110g, R.drawable.icon_topic_ranklist_hot);
        } else if (cVar.i() == 3) {
            hotRankListNormaItemHolder.f17110g.setVisibility(0);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.f17110g, R.drawable.icon_topic_ranklist_tuijian);
        } else {
            hotRankListNormaItemHolder.f17110g.setVisibility(8);
        }
        String numFormat9999W = StringHelper.numFormat9999W(cVar.b());
        hotRankListNormaItemHolder.f17106c.setText(TextUtils.isEmpty(cVar.e()) ? "" : UtilHelper.getFixedText(cVar.e(), 10));
        hotRankListNormaItemHolder.f17107d.setText(numFormat9999W);
        hotRankListNormaItemHolder.k.setOnClickListener(new b(this, cVar));
    }

    public final void i0(HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hotRankListNormaItemHolder) == null) || hotRankListNormaItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListNormaItemHolder.f17104a != skinType) {
            hotRankListNormaItemHolder.f17104a = skinType;
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f17105b, R.color.CAM_X0110, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f17106c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f17107d, R.color.CAM_X0110, 1);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.f17108e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListNormaItemHolder.f17109f, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListNormaItemHolder.k, R.drawable.hot_topic_ranklist_bg);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.j, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(hotRankListNormaItemHolder.f17112i, R.color.CAM_X0109, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public HotRankListNormaItemHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotRankListNormaItemHolder(LayoutInflater.from(this.f41837e).inflate(R.layout.hot_topic_ranklist_normal_item, viewGroup, false)) : (HotRankListNormaItemHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, d.a.p0.g1.c.c cVar, HotRankListNormaItemHolder hotRankListNormaItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, hotRankListNormaItemHolder})) == null) {
            if (cVar != null) {
                i0(hotRankListNormaItemHolder);
                h0(i2, hotRankListNormaItemHolder, cVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final SpannableString l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            int length = !StringUtils.isNull(str) ? str.length() : 0;
            int length2 = !StringUtils.isNull(str2) ? str2.length() : 0;
            SpannableString spannableString = new SpannableString("" + str + str2);
            if (length > 0 && length2 > 0) {
                spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), R.style.hot_ranklist_module_name_stysle), 0, length, 33);
                spannableString.setSpan(new TextAppearanceSpan(this.n.getPageActivity(), R.style.hot_ranklist_module_tip_stysle), length, spannableString.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.o = str;
        }
    }
}
