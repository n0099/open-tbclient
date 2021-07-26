package d.a.q0.k1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.v0.a;
/* loaded from: classes8.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59842a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59843b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f59844c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f59845d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f59846e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f59847f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59848g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59849h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59850i;
    public String j;
    public String k;
    public final a.j l;

    /* loaded from: classes8.dex */
    public class a implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f59851a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f59852b;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59852b = bVar;
            this.f59851a = i2;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f59852b.f59850i = false;
                this.f59852b.f59849h = true;
                if (d.a.q0.v0.a.i().m(str)) {
                    this.f59852b.u(1);
                    this.f59852b.w(this.f59851a);
                    this.f59852b.k(0);
                    return;
                }
                this.f59852b.u(0);
                this.f59852b.k(1);
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f59852b.f59850i = false;
                this.f59852b.u(0);
                this.f59852b.k(1);
            }
        }
    }

    /* renamed from: d.a.q0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1510b extends a.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59853a;

        public C1510b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59853a = bVar;
        }

        @Override // d.a.q0.v0.a.h
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                this.f59853a.j(str2, str3);
            }
        }

        @Override // d.a.q0.v0.a.h
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f59853a.f59845d == null) {
                return;
            }
            this.f59853a.f59845d.finish();
        }

        @Override // d.a.q0.v0.a.h
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f59853a.u(0);
                this.f59853a.l(1, null, null);
            }
        }

        @Override // d.a.q0.v0.a.h
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f59853a.f59848g = true;
                this.f59853a.l(0, str2, str3);
            }
        }
    }

    public b(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59842a = 0;
        this.f59848g = false;
        this.f59849h = false;
        this.f59850i = false;
        this.l = new C1510b(this);
        this.f59845d = imageViewerActivity;
        this.f59844c = imageViewerActivity.getPageContext();
        this.f59843b = z;
        this.f59846e = new RelativeLayout(this.f59845d);
        ViewGroup h2 = d.a.q0.v0.a.i().h(imageViewerActivity, "6051001643-679358748");
        this.f59847f = h2;
        if (h2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f59845d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f59846e.addView(this.f59847f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View b(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (this.f59844c != null && this.f59847f != null && this.f59843b && m(i2) && o()) {
                if (this.f59846e.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f59846e.getParent()).removeView(this.f59846e);
                }
                viewGroup.addView(this.f59846e);
                return this.f59846e;
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2) == null) {
        }
    }

    public final void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").param(TiebaStatic.Params.OBJ_TO, str).param(TiebaStatic.Params.OBJ_PARAM2, str2).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.j, this.k, null, null, null, null, null);
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i2);
            if (i2 == 1) {
                param.param(TiebaStatic.Params.RESOURCE_ID, 0);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.j, this.k, "0");
            } else {
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.j, this.k, null);
            }
            TiebaStatic.log(param);
        }
    }

    public final void l(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i2);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.j, this.k, null, null, null, null, null);
        }
    }

    public final boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int i3 = this.f59842a;
            return i3 != 0 && i2 == i3;
        }
        return invokeI.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59843b && this.f59847f != null && this.f59849h : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59849h : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59848g : invokeV.booleanValue;
    }

    public boolean q(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i2, i3, i4)) == null) ? i2 == 1 : invokeIII.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.q0.v0.a.i().d("6051001643-679358748");
        }
    }

    public void t(int i2, int i3, int i4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) || !this.f59843b || this.f59847f == null || this.f59850i || this.f59849h || !q(i2, i3, i4)) {
            return;
        }
        this.f59850i = true;
        this.j = str;
        this.k = str2;
        FunAdRecordHttpMessage.uploadRequestRecord("a008", null, str, str2, null);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.q0.v0.a.i().n(this.f59845d, "6051001643-679358748", new a(this, i4), d.a.q0.v0.a.b("pic", d.a.p0.b.d.S() ? "1" : "0"));
    }

    public void u(int i2) {
        ImageViewerActivity imageViewerActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (imageViewerActivity = this.f59845d) == null) {
            return;
        }
        imageViewerActivity.setAddSize(i2);
    }

    public void v(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
        }
    }

    public boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.f59844c == null || this.f59847f == null || !this.f59843b || this.f59848g || !m(i2) || !o()) {
                return false;
            }
            d.a.q0.v0.a.i().u(this.f59844c.getPageActivity(), "6051001643-679358748", this.f59847f, this.l, d.a.q0.v0.a.b("pic", d.a.p0.b.d.S() ? "1" : "0"));
            SkinManager.setBackgroundColor(this.f59847f, R.color.CAM_X0101, 0);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            this.f59842a = i2;
        }
    }
}
