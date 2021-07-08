package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ImageSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSET_SCHEME = "file:///android_asset/";
    public static final String FILE_SCHEME = "file:///";
    public transient /* synthetic */ FieldHolder $fh;
    public final Bitmap bitmap;
    public final Integer resource;
    public int sHeight;
    public Rect sRegion;
    public int sWidth;
    public boolean tile;
    public final Uri uri;

    public ImageSource(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
    }

    public static ImageSource asset(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                return uri("file:///android_asset/" + str);
            }
            throw new NullPointerException("Asset name must not be null");
        }
        return (ImageSource) invokeL.objValue;
    }

    public static ImageSource bitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) {
            if (bitmap != null) {
                return new ImageSource(bitmap);
            }
            throw new NullPointerException("Bitmap must not be null");
        }
        return (ImageSource) invokeL.objValue;
    }

    public static ImageSource resource(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? new ImageSource(i2) : (ImageSource) invokeI.objValue;
    }

    private void setInvariants() {
        Rect rect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (rect = this.sRegion) == null) {
            return;
        }
        this.tile = true;
        this.sWidth = rect.width();
        this.sHeight = this.sRegion.height();
    }

    public static ImageSource uri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str != null) {
                if (!str.contains("://")) {
                    if (str.startsWith("/")) {
                        str = str.substring(1);
                    }
                    str = FILE_SCHEME + str;
                }
                return new ImageSource(Uri.parse(str));
            }
            throw new NullPointerException("Uri must not be null");
        }
        return (ImageSource) invokeL.objValue;
    }

    public ImageSource dimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            if (this.bitmap == null) {
                this.sWidth = i2;
                this.sHeight = i3;
            }
            setInvariants();
            return this;
        }
        return (ImageSource) invokeII.objValue;
    }

    public final Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bitmap : (Bitmap) invokeV.objValue;
    }

    public final Integer getResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resource : (Integer) invokeV.objValue;
    }

    public final int getSHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sHeight : invokeV.intValue;
    }

    public final Rect getSRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sRegion : (Rect) invokeV.objValue;
    }

    public final int getSWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sWidth : invokeV.intValue;
    }

    public final boolean getTile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.tile : invokeV.booleanValue;
    }

    public final Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.uri : (Uri) invokeV.objValue;
    }

    public ImageSource region(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect)) == null) {
            this.sRegion = rect;
            setInvariants();
            return this;
        }
        return (ImageSource) invokeL.objValue;
    }

    public ImageSource tiling(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.tile = z;
            return this;
        }
        return (ImageSource) invokeZ.objValue;
    }

    public ImageSource tilingDisabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? tiling(false) : (ImageSource) invokeV.objValue;
    }

    public ImageSource tilingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? tiling(true) : (ImageSource) invokeV.objValue;
    }

    public static ImageSource uri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uri)) == null) {
            if (uri != null) {
                return new ImageSource(uri);
            }
            throw new NullPointerException("Uri must not be null");
        }
        return (ImageSource) invokeL.objValue;
    }

    public ImageSource(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    public ImageSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i2);
        this.tile = true;
    }
}
