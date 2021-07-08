package d.a.p0.k1;

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
import d.a.p0.v0.a;
/* loaded from: classes8.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59228a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59229b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f59230c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f59231d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f59232e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f59233f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59234g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59235h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59236i;
    public String j;
    public String k;
    public final a.h l;

    /* loaded from: classes8.dex */
    public class a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f59237a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f59238b;

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
            this.f59238b = bVar;
            this.f59237a = i2;
        }

        @Override // d.a.p0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                this.f59238b.f59236i = false;
                this.f59238b.f59235h = true;
                if (d.a.p0.v0.a.h().k(str)) {
                    this.f59238b.u(1);
                    this.f59238b.w(this.f59237a);
                    this.f59238b.k(0);
                    return;
                }
                this.f59238b.u(0);
                this.f59238b.k(1);
            }
        }

        @Override // d.a.p0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f59238b.f59236i = false;
                this.f59238b.u(0);
                this.f59238b.k(1);
            }
        }
    }

    /* renamed from: d.a.p0.k1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1505b extends a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59239a;

        public C1505b(b bVar) {
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
            this.f59239a = bVar;
        }

        @Override // d.a.p0.v0.a.g
        public void onAdClicked(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f59239a.j();
            }
        }

        @Override // d.a.p0.v0.a.g
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f59239a.f59231d == null) {
                return;
            }
            this.f59239a.f59231d.finish();
        }

        @Override // d.a.p0.v0.a.g
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f59239a.u(0);
                this.f59239a.l(1);
            }
        }

        @Override // d.a.p0.v0.a.g
        public void onAdShow(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f59239a.f59234g = true;
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
        this.f59228a = 0;
        this.f59234g = false;
        this.f59235h = false;
        this.f59236i = false;
        this.l = new C1505b(this);
        this.f59231d = imageViewerActivity;
        this.f59230c = imageViewerActivity.getPageContext();
        this.f59229b = z;
        this.f59232e = new RelativeLayout(this.f59231d);
        ViewGroup g2 = d.a.p0.v0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f59233f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f59231d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f59232e.addView(this.f59233f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View b(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (this.f59230c != null && this.f59233f != null && this.f59229b && m(i2) && o()) {
                if (this.f59232e.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f59232e.getParent()).removeView(this.f59232e);
                }
                viewGroup.addView(this.f59232e);
                return this.f59232e;
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

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
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

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i2).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.j, this.k, null, null, null, null, null);
        }
    }

    public final boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int i3 = this.f59228a;
            return i3 != 0 && i2 == i3;
        }
        return invokeI.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59229b && this.f59233f != null && this.f59235h : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59235h : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59234g : invokeV.booleanValue;
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
            d.a.p0.v0.a.h().c("6051001643-679358748");
        }
    }

    public void t(int i2, int i3, int i4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2}) == null) || !this.f59229b || this.f59233f == null || this.f59236i || this.f59235h || !q(i2, i3, i4)) {
            return;
        }
        this.f59236i = true;
        this.j = str;
        this.k = str2;
        FunAdRecordHttpMessage.uploadRequestRecord("a008", null, str, str2, null);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.p0.v0.a.h().l(this.f59231d, "6051001643-679358748", new a(this, i4), d.a.p0.v0.a.a("pic", d.a.o0.b.d.N() ? "1" : "0"));
    }

    public void u(int i2) {
        ImageViewerActivity imageViewerActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (imageViewerActivity = this.f59231d) == null) {
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
            if (this.f59230c == null || this.f59233f == null || !this.f59229b || this.f59234g || !m(i2) || !o()) {
                return false;
            }
            d.a.p0.v0.a.h().o(this.f59230c.getPageActivity(), "6051001643-679358748", this.f59233f, this.l, d.a.p0.v0.a.a("pic", d.a.o0.b.d.N() ? "1" : "0"));
            SkinManager.setBackgroundColor(this.f59233f, R.color.CAM_X0101, 0);
            l(0);
            return true;
        }
        return invokeI.booleanValue;
    }

    public void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            this.f59228a = i2;
        }
    }
}
