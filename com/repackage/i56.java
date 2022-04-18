package com.repackage;

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
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class i56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final long b;
    public int c;
    public View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
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
    public k56 w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public a(i56 i56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13671");
                    statisticItem.param("fid", this.a.b);
                    TiebaStatic.log(statisticItem);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.d.getContext());
                hotUserRankActivityConfig.setCategory(this.a.u);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public b(i56 i56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2.getId() != this.a.v.getId() || this.a.w == null || this.a.w.c == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.d.getContext(), this.a.w.c.getUserId(), this.a.w.c.getName_show())));
            if (!TextUtils.isEmpty(this.a.a)) {
                StatisticItem statisticItem = new StatisticItem("c13659");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.w.a);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.w.c.rankNum);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13683");
            statisticItem2.param("uid", this.a.w.c.getUserId());
            statisticItem2.param("fid", this.a.b);
            TiebaStatic.log(statisticItem2);
        }
    }

    public i56(View view2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.x = new b(this);
        this.d = view2;
        this.a = str;
        this.b = j;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092093);
        this.v = findViewById;
        findViewById.setOnClickListener(this.x);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919a8);
        this.e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920b6);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919a2);
        this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eb8);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eb7);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ea2);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ece);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ecd);
        IrregularImageView irregularImageView = (IrregularImageView) view2.findViewById(R.id.obfuscated_res_0x7f090edc);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.obfuscated_res_0x7f080f2b);
        this.h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810f4, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810f0, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810f2, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810f1, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f0810f3, 1, false));
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f1b);
        this.n = textView2;
        textView2.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0889));
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090dc3);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new a(this));
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc5);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc6);
        this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc7);
        this.r = (ImageOverlayView) view2.findViewById(R.id.obfuscated_res_0x7f090dc8);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc4);
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
                int i = 3 - count;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.rightMargin = dimensionPixelOffset - (i * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
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

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.c == i) {
            return;
        }
        this.c = i;
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.p, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.t, R.drawable.obfuscated_res_0x7f0810eb, SvgManager.SvgResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
        this.r.d();
    }

    public void k(k56 k56Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, k56Var, z) == null) {
            this.w = k56Var;
            if (k56Var == null) {
                return;
            }
            this.e.setText(k56Var.a);
            if (k56Var.c != null) {
                String str = k56Var.b;
                if (fd5.d(str) > 10) {
                    str = fd5.n(k56Var.b, 10) + StringHelper.STRING_MORE;
                }
                this.f.setText(String.format(this.d.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f088c), str));
            }
            if (k56Var.d == 0) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(String.format(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0888), StringHelper.getDateStringMdChinease(k56Var.d * 1000)));
            }
            this.m.setImage(k56Var.e, h(this.d.getContext()), R.drawable.obfuscated_res_0x7f080d42);
            TiebaFieldsInfo tiebaFieldsInfo = k56Var.f;
            if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
                this.o.setVisibility(0);
                this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0386), k56Var.f.tieba_name));
                List<String> i = i(k56Var.f.user_rank);
                this.r.setData(i);
                g(i);
                this.u = k56Var.f.tieba_name;
                if (this.b > 0) {
                    StatisticItem statisticItem = new StatisticItem("c13670");
                    statisticItem.param("fid", this.b);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
