package d.a.s0.l0.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.z0.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f62884a;

    /* renamed from: b  reason: collision with root package name */
    public final long f62885b;

    /* renamed from: c  reason: collision with root package name */
    public int f62886c;

    /* renamed from: d  reason: collision with root package name */
    public View f62887d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62888e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62889f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62890g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62891h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f62892i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public IrregularImageView m;
    public TextView n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public ImageOverlayView r;
    public ImageView s;
    public ImageView t;
    public String u;
    public View v;
    public d.a.s0.l0.i.c.a w;
    public View.OnClickListener x;

    /* renamed from: d.a.s0.l0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1566a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62893e;

        public View$OnClickListenerC1566a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62893e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f62893e.f62885b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13671");
                    statisticItem.param("fid", this.f62893e.f62885b);
                    TiebaStatic.log(statisticItem);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f62893e.f62887d.getContext());
                hotUserRankActivityConfig.setCategory(this.f62893e.u);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62894e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62894e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getId() != this.f62894e.v.getId() || this.f62894e.w == null || this.f62894e.w.f62906c == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f62894e.f62887d.getContext(), this.f62894e.w.f62906c.getUserId(), this.f62894e.w.f62906c.getName_show())));
            if (!TextUtils.isEmpty(this.f62894e.f62884a)) {
                StatisticItem statisticItem = new StatisticItem("c13659");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f62894e.w.f62904a);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.f62894e.w.f62906c.rankNum);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13683");
            statisticItem2.param("uid", this.f62894e.w.f62906c.getUserId());
            statisticItem2.param("fid", this.f62894e.f62885b);
            TiebaStatic.log(statisticItem2);
        }
    }

    public a(View view, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62886c = 3;
        this.x = new b(this);
        this.f62887d = view;
        this.f62884a = str;
        this.f62885b = j;
        View findViewById = view.findViewById(R.id.top_container);
        this.v = findViewById;
        findViewById.setOnClickListener(this.x);
        TextView textView = (TextView) view.findViewById(R.id.rank_name);
        this.f62888e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f62889f = (TextView) view.findViewById(R.id.top_user_name);
        this.f62890g = (TextView) view.findViewById(R.id.rank_data);
        this.f62891h = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.f62892i = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.j = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.k = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.l = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        IrregularImageView irregularImageView = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.pic_list_avatar);
        this.f62891h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.f62892i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_line, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_line2, 1, false));
        TextView textView2 = (TextView) view.findViewById(R.id.text_compute_method);
        this.n = textView2;
        textView2.setText(this.f62887d.getResources().getString(R.string.hot_user_rank_influence_desc));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new View$OnClickListenerC1566a(this));
        this.p = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.q = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.t = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.r = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            int count = ListUtils.getCount(list);
            if (count == 0) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
            if (count < 3) {
                int i2 = 3 - count;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.rightMargin = dimensionPixelOffset - (i2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
                this.t.setLayoutParams(layoutParams);
            }
        }
    }

    public BdUniqueId h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext().getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public final List<String> i(List<User> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (User user : list) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f62886c == i2) {
            return;
        }
        this.f62886c = i2;
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.p, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.t, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        this.r.d();
    }

    public void k(d.a.s0.l0.i.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, aVar, z) == null) {
            this.w = aVar;
            if (aVar == null) {
                return;
            }
            this.f62888e.setText(aVar.f62904a);
            if (aVar.f62906c != null) {
                String str = aVar.f62905b;
                if (j0.d(str) > 10) {
                    str = j0.m(aVar.f62905b, 10) + StringHelper.STRING_MORE;
                }
                this.f62889f.setText(String.format(this.f62887d.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.f62907d == 0) {
                this.f62890g.setVisibility(8);
            } else {
                this.f62890g.setVisibility(0);
                this.f62890g.setText(String.format(this.f62887d.getContext().getString(R.string.hot_user_rank_data), StringHelper.getDateStringMdChinease(aVar.f62907d * 1000)));
            }
            this.m.setImage(aVar.f62908e, h(this.f62887d.getContext()), R.drawable.mask_list_avatar);
            TiebaFieldsInfo tiebaFieldsInfo = aVar.f62909f;
            if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
                this.o.setVisibility(0);
                this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.f62909f.tieba_name));
                List<String> i2 = i(aVar.f62909f.user_rank);
                this.r.setData(i2);
                g(i2);
                this.u = aVar.f62909f.tieba_name;
                if (this.f62885b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13670");
                    statisticItem.param("fid", this.f62885b);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
