package d.a.p0.a4.k;

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
/* loaded from: classes7.dex */
public class a extends d.a.c.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54182a;

    /* renamed from: b  reason: collision with root package name */
    public String f54183b;

    /* renamed from: c  reason: collision with root package name */
    public e f54184c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment[] f54185d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f54186e;

    /* renamed from: f  reason: collision with root package name */
    public ImageListFragment f54187f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumImageBrowseFragment f54188g;

    /* renamed from: d.a.p0.a4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1266a implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f54189a;

        public C1266a(a aVar, TbCameraView tbCameraView) {
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
            this.f54189a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54189a.o();
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
        this.f54182a = "tag_image";
        this.f54183b = "tag_b_image";
        this.f54184c = eVar;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f54188g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.T0();
        }
        return (View) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.a1();
        }
        return (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f54188g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.U0();
        }
        return (View) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.b1();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.c1();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f54185d[i2];
        }
        return (Fragment) invokeI.objValue;
    }

    public String k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < 0 || i2 > 1) {
                return null;
            }
            return this.f54186e[i2];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54187f : (ImageListFragment) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.e1();
        }
        return (View) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f54188g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.V0();
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54185d = new Fragment[2];
            this.f54186e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f54187f = imageListFragment;
            imageListFragment.k1(this.f54184c);
            this.f54185d[0] = this.f54187f;
            this.f54186e[0] = this.f54182a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.f54188g = albumImageBrowseFragment;
            albumImageBrowseFragment.a1(this.f54184c);
            this.f54185d[1] = this.f54188g;
            this.f54186e[1] = this.f54183b;
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048587, this, i2) != null) {
            return;
        }
        int i3 = 0;
        while (true) {
            Fragment[] fragmentArr = this.f54185d;
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbCameraView h2 = h();
            if (h2 != null) {
                h2.setOnOpenCameraFailedListener(new C1266a(this, h2));
                h2.m(false);
                h2.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment == null || imageListFragment.d1() == null) {
                return;
            }
            this.f54187f.d1().n();
        }
    }

    public void r() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (imageListFragment = this.f54187f) == null) {
            return;
        }
        imageListFragment.f1();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.f54188g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.Z0(z);
            }
            ImageListFragment imageListFragment = this.f54187f;
            if (imageListFragment != null) {
                imageListFragment.j1(z);
            }
        }
    }

    public void t(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.f54187f.l1(navigationBar);
        }
    }

    public void u(j jVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) || (imageListFragment = this.f54187f) == null) {
            return;
        }
        imageListFragment.m1(jVar);
    }

    public void v() {
        TbCameraView h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (h2 = h()) == null) {
            return;
        }
        h2.o();
        h2.setVisibility(4);
    }
}
