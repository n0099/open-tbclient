package d.a.p0.u0.g2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.h3.a0;
import d.a.p0.h3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes8.dex */
public class c implements b, d.a.p0.u0.g2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f62818a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62819b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62820c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62821d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f62822e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f62823f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62824g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f62825h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f62826i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62827e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62827e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TextUtils.equals(this.f62827e.f62818a.getResources().getString(R.string.hot_user_rank), this.f62827e.f62823f.f57912b) || this.f62827e.f62826i == null || this.f62827e.f62826i.getForum() == null || TextUtils.isEmpty(this.f62827e.f62826i.getForum().getId())) {
                    if (this.f62827e.f62823f != null && this.f62827e.f62823f.f57916f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f62827e.f62823f.f57917g).param("obj_source", "frs_card").param("obj_id", this.f62827e.f62823f.f57916f.f57921b).param("obj_name", this.f62827e.f62823f.f57916f.f57920a).param("obj_param1", this.f62827e.f62823f.f57916f.f57923d.intValue()));
                    }
                    d.a(view.getContext(), this.f62827e.f62823f);
                    d.b(this.f62827e.f62823f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(this.f62827e.f62826i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f62827e.f62826i.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f62818a = inflate;
        this.f62819b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f62820c = (TextView) this.f62818a.findViewById(R.id.frs_service_category);
        this.f62821d = (TextView) this.f62818a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f62818a.findViewById(R.id.frs_service_icon);
        this.f62822e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f62822e.setIsRound(true);
        this.f62822e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f62818a.findViewById(R.id.image_group);
        this.f62825h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f62825h.setStrokeStyle(1);
        this.f62825h.setLoadImageType(12);
        this.f62818a.setOnClickListener(this.j);
        this.f62824g = (ImageView) this.f62818a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.p0.u0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f57910b)) {
            return;
        }
        this.f62826i = frsViewData;
        b0 b0Var = a0Var.f57910b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f62823f = b0Var;
        if (!TextUtils.equals(this.f62818a.getResources().getString(R.string.hot_user_rank), this.f62823f.f57912b)) {
            this.f62820c.setText(this.f62818a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f62820c.setText(this.f62818a.getContext().getString(R.string.frs_service_special));
            this.f62819b.setText(this.f62818a.getContext().getString(R.string.hot_person));
        }
        this.f62821d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f57913c, 20));
        if (TextUtils.equals(this.f62818a.getResources().getString(R.string.hot_user_rank), b0Var.f57912b)) {
            this.f62825h.setVisibility(0);
            this.f62822e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f62822e.M(b0Var.f57912b, 10, false);
            this.f62822e.setVisibility(0);
            this.f62825h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.p0.u0.g2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f62819b);
        }
    }

    public final boolean f(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData)) == null) {
            if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.f62825h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.u0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62818a : (View) invokeV.objValue;
    }

    @Override // d.a.p0.u0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f62820c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62821d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62819b, R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f62824g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f62825h.d();
        }
    }
}
