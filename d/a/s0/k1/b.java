package d.a.s0.k1;

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
import d.a.c.e.p.l;
import d.a.s0.v0.a;
/* loaded from: classes9.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f62463a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62464b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f62465c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f62466d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f62467e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f62468f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62469g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62470h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62471i;
    public String j;
    public String k;
    public final a.h l;

    /* loaded from: classes9.dex */
    public class a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f62472a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f62473b;

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
            this.f62473b = bVar;
            this.f62472a = i2;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f62473b.f62471i = false;
                this.f62473b.f62470h = true;
                if (d.a.s0.v0.a.h().k(str)) {
                    this.f62473b.t(1);
                    this.f62473b.v(this.f62472a);
                    this.f62473b.j(0);
                    return;
                }
                this.f62473b.t(0);
                this.f62473b.j(1);
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f62473b.f62471i = false;
                this.f62473b.t(0);
                this.f62473b.j(1);
            }
        }
    }

    /* renamed from: d.a.s0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1549b extends a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62474a;

        public C1549b(b bVar) {
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
            this.f62474a = bVar;
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f62474a.i();
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f62474a.f62466d == null) {
                return;
            }
            this.f62474a.f62466d.finish();
        }

        @Override // d.a.s0.v0.a.g
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f62474a.t(0);
                this.f62474a.k(1);
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onAdShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f62474a.f62469g = true;
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
        this.f62463a = 0;
        this.f62469g = false;
        this.f62470h = false;
        this.f62471i = false;
        this.l = new C1549b(this);
        this.f62466d = imageViewerActivity;
        this.f62465c = imageViewerActivity.getPageContext();
        this.f62464b = z;
        this.f62467e = new RelativeLayout(this.f62466d);
        ViewGroup g2 = d.a.s0.v0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f62468f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f62466d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f62467e.addView(this.f62468f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (this.f62465c != null && this.f62468f != null && this.f62464b && l(i2) && n()) {
                if (this.f62467e.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f62467e.getParent()).removeView(this.f62467e);
                }
                viewGroup.addView(this.f62467e);
                return this.f62467e;
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.j, this.k, null, null, null, null, null);
        }
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
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

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i2).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.j, this.k, null, null, null, null, null);
        }
    }

    public final boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = this.f62463a;
            return i3 != 0 && i2 == i3;
        }
        return invokeI.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62464b && this.f62468f != null && this.f62470h : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62470h : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f62469g : invokeV.booleanValue;
    }

    public boolean p(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) ? i2 == 1 : invokeIII.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.s0.v0.a.h().c("6051001643-679358748");
        }
    }

    public void s(int i2, int i3, int i4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) || !this.f62464b || this.f62468f == null || this.f62471i || this.f62470h || !p(i2, i3, i4)) {
            return;
        }
        this.f62471i = true;
        this.j = str;
        this.k = str2;
        FunAdRecordHttpMessage.uploadRequestRecord("a008", null, str, str2, null);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.s0.v0.a.h().l(this.f62466d, "6051001643-679358748", new a(this, i4), d.a.s0.v0.a.a("pic", d.a.r0.b.d.D() ? "1" : "0"));
    }

    public void t(int i2) {
        ImageViewerActivity imageViewerActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (imageViewerActivity = this.f62466d) == null) {
            return;
        }
        imageViewerActivity.setAddSize(i2);
    }

    public void u(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hVar) == null) {
        }
    }

    public boolean v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.f62465c == null || this.f62468f == null || !this.f62464b || this.f62469g || !l(i2) || !n()) {
                return false;
            }
            d.a.s0.v0.a.h().o(this.f62465c.getPageActivity(), "6051001643-679358748", this.f62468f, this.l, d.a.s0.v0.a.a("pic", d.a.r0.b.d.D() ? "1" : "0"));
            SkinManager.setBackgroundColor(this.f62468f, R.color.CAM_X0101, 0);
            k(0);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            this.f62463a = i2;
        }
    }
}
