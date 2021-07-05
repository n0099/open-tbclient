package d.a.s0.u0.g2;

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
import d.a.s0.h3.a0;
import d.a.s0.h3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class c implements b, d.a.s0.u0.g2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66037a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66038b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66039c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66040d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f66041e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f66042f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66043g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f66044h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f66045i;
    public View.OnClickListener j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66046e;

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
            this.f66046e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TextUtils.equals(this.f66046e.f66037a.getResources().getString(R.string.hot_user_rank), this.f66046e.f66042f.f61156b) || this.f66046e.f66045i == null || this.f66046e.f66045i.getForum() == null || TextUtils.isEmpty(this.f66046e.f66045i.getForum().getId())) {
                    if (this.f66046e.f66042f != null && this.f66046e.f66042f.f61160f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f66046e.f66042f.f61161g).param("obj_source", "frs_card").param("obj_id", this.f66046e.f66042f.f61160f.f61165b).param("obj_name", this.f66046e.f66042f.f61160f.f61164a).param("obj_param1", this.f66046e.f66042f.f61160f.f61167d.intValue()));
                    }
                    d.a(view.getContext(), this.f66046e.f66042f);
                    d.b(this.f66046e.f66042f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(this.f66046e.f66045i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.f66046e.f66045i.getForum().getId());
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
        this.f66037a = inflate;
        this.f66038b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f66039c = (TextView) this.f66037a.findViewById(R.id.frs_service_category);
        this.f66040d = (TextView) this.f66037a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f66037a.findViewById(R.id.frs_service_icon);
        this.f66041e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f66041e.setIsRound(true);
        this.f66041e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f66037a.findViewById(R.id.image_group);
        this.f66044h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f66044h.setStrokeStyle(1);
        this.f66044h.setLoadImageType(12);
        this.f66037a.setOnClickListener(this.j);
        this.f66043g = (ImageView) this.f66037a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.s0.u0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, a0Var, frsViewData) == null) || a0Var == null || ListUtils.isEmpty(a0Var.f61154b)) {
            return;
        }
        this.f66045i = frsViewData;
        b0 b0Var = a0Var.f61154b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f66042f = b0Var;
        if (!TextUtils.equals(this.f66037a.getResources().getString(R.string.hot_user_rank), this.f66042f.f61156b)) {
            this.f66039c.setText(this.f66037a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f66039c.setText(this.f66037a.getContext().getString(R.string.frs_service_special));
            this.f66038b.setText(this.f66037a.getContext().getString(R.string.hot_person));
        }
        this.f66040d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f61157c, 20));
        if (TextUtils.equals(this.f66037a.getResources().getString(R.string.hot_user_rank), b0Var.f61156b)) {
            this.f66044h.setVisibility(0);
            this.f66041e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f66041e.M(b0Var.f61156b, 10, false);
            this.f66041e.setVisibility(0);
            this.f66044h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.s0.u0.g2.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f66038b);
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
            this.f66044h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.u0.g2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66037a : (View) invokeV.objValue;
    }

    @Override // d.a.s0.u0.g2.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f66039c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66040d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66038b, R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f66043g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f66044h.d();
        }
    }
}
