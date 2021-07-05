package d.a.s0.a4.k;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a extends d.a.c.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f57437a;

    /* renamed from: b  reason: collision with root package name */
    public String f57438b;

    /* renamed from: c  reason: collision with root package name */
    public e f57439c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f57440d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f57441e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f57442f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f57443g;

    /* renamed from: d.a.s0.a4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1312a implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f57444a;

        public C1312a(a aVar, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57444a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57444a.k(false);
                this.f57444a.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57437a = "tag_image";
        this.f57438b = "tag_b_image";
        this.f57439c = eVar;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f57443g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.S0();
        }
        return (View) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.Z0();
        }
        return (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f57443g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.T0();
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.a1();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.b1();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f57440d[i2];
        }
        return (Fragment) invokeI.objValue;
    }

    public String l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f57441e[i2];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57442f : (ImageListFragment) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.d1();
        }
        return (View) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f57443g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.U0();
        }
        return (View) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048586, this, i2) != null) {
            return;
        }
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f57440d;
            if (i3 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i3] != null && (fragmentArr[i3] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i3]).onChangeSkinType(i2);
            }
            i3++;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f57440d = new Fragment[2];
            this.f57441e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f57442f = imageListFragment;
            imageListFragment.j1(this.f57439c);
            this.f57440d[0] = this.f57442f;
            this.f57441e[0] = this.f57437a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.f57443g = albumImageBrowseFragment;
            albumImageBrowseFragment.Z0(this.f57439c);
            this.f57440d[1] = this.f57443g;
            this.f57441e[1] = this.f57438b;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbCameraView i2 = i();
            if (i2 != null) {
                i2.setOnOpenCameraFailedListener(new C1312a(this, i2));
                i2.k(false);
                i2.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment == null || imageListFragment.c1() == null) {
                return;
            }
            this.f57442f.c1().n();
        }
    }

    public void s() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (imageListFragment = this.f57442f) == null) {
            return;
        }
        imageListFragment.e1();
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f57443g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.Y0(z);
            }
            ImageListFragment imageListFragment = this.f57442f;
            if (imageListFragment != null) {
                imageListFragment.i1(z);
            }
        }
    }

    public void u(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.f57442f.k1(navigationBar);
        }
    }

    public void v(j jVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) || (imageListFragment = this.f57442f) == null) {
            return;
        }
        imageListFragment.l1(jVar);
    }

    public void w() {
        TbCameraView i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (i2 = i()) == null) {
            return;
        }
        i2.m();
        i2.setVisibility(4);
    }
}
