package com.repackage;

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
/* loaded from: classes6.dex */
public class ky8 extends z8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public oy8 c;
    public Fragment[] d;
    public String[] e;
    public ImageListFragment f;
    public AlbumImageBrowseFragment g;

    /* loaded from: classes6.dex */
    public class a implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(ky8 ky8Var, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky8Var, tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ky8(TbPageContext tbPageContext, oy8 oy8Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, oy8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.b = "tag_b_image";
        this.c = oy8Var;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.O0();
        }
        return (View) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.U0();
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.P0();
        }
        return (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.V0();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.W0();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.d[i];
        }
        return (Fragment) invokeI.objValue;
    }

    public String l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.e[i];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : (ImageListFragment) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.Y0();
        }
        return (View) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.Q0();
        }
        return (View) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048586, this, i) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.d;
            if (i2 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i2] != null && (fragmentArr[i2] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i2]).onChangeSkinType(i);
            }
            i2++;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = new Fragment[2];
            this.e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f = imageListFragment;
            imageListFragment.e1(this.c);
            this.d[0] = this.f;
            this.e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.g = albumImageBrowseFragment;
            albumImageBrowseFragment.V0(this.c);
            this.d[1] = this.g;
            this.e[1] = this.b;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbCameraView j = j();
            if (j != null) {
                j.setOnOpenCameraFailedListener(new a(this, j));
                j.m(false);
                j.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null || imageListFragment.X0() == null) {
                return;
            }
            this.f.X0().n();
        }
    }

    public void t() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (imageListFragment = this.f) == null) {
            return;
        }
        imageListFragment.Z0();
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.U0(z);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null) {
                imageListFragment.d1(z);
            }
        }
    }

    public void v(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, navigationBar) == null) {
            this.f.f1(navigationBar);
        }
    }

    public void w(ty8 ty8Var) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, ty8Var) == null) || (imageListFragment = this.f) == null) {
            return;
        }
        imageListFragment.g1(ty8Var);
    }

    public void x() {
        TbCameraView j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (j = j()) == null) {
            return;
        }
        j.o();
        j.setVisibility(4);
    }
}
