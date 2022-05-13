package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes7.dex */
public abstract class rd8 implements xd8 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public static String g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public Context b;
    public String c;
    public String d;
    public ShareEntity e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755354069, "Lcom/repackage/rd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755354069, "Lcom/repackage/rd8;");
                return;
            }
        }
        f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";
        g = "temp_video_thumb.png";
        h = "_temp_share_pic.png";
    }

    public rd8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public void b(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            ShareEvent shareEvent = new ShareEvent();
            shareEvent.status = i;
            shareEvent.tid = this.c;
            shareEvent.channel = i2;
            shareEvent.extLiveInfo = this.d;
            shareEvent.from = i3;
            e65.i(shareEvent);
        }
    }

    public final void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                b(i, i2, 0);
            } else if (!StringUtils.isNull(this.d)) {
                b(i, i2, 0);
            } else {
                ShareEntity shareEntity = this.e;
                if (shareEntity == null || !shareEntity.isFromDuXiaoMan()) {
                    return;
                }
                b(i, i2, 1);
            }
        }
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getContext() : (Context) invokeV.objValue;
    }

    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BitmapHelper.getCashBitmap(R.drawable.obfuscated_res_0x7f081833) : (Bitmap) invokeV.objValue;
    }

    public Bitmap f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? BitmapHelper.getCashBitmap(i) : (Bitmap) invokeI.objValue;
    }

    public Bitmap g(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) ? BitmapHelper.loadBitmap(uri.getPath()) : (Bitmap) invokeL.objValue;
    }

    public Bitmap h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? BitmapHelper.loadBitmap(str) : (Bitmap) invokeL.objValue;
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        e9 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.a;
            return (bdUniqueId == null && (c = f9.c(this.b)) != null) ? c.getUniqueId() : bdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Bitmap j(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap, i)) == null) ? BitmapHelper.resizeBitmap(bitmap, i, i, false) : (Bitmap) invokeLI.objValue;
    }

    public Bitmap k(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, bitmap, i, i2)) == null) ? BitmapHelper.resizeBitmap(bitmap, i, i2, false) : (Bitmap) invokeLII.objValue;
    }

    public String l(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, objArr)) == null) ? d().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
        }
    }

    public boolean n(Uri uri) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                file = new File(new URI(uri.toString()));
            } catch (IllegalArgumentException | URISyntaxException unused) {
            }
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public co p(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, shareEntity)) == null) {
            if (shareEntity == null || (bundle = shareEntity.diskPicOperate) == null) {
                return null;
            }
            String string = bundle.getString("path");
            String string2 = bundle.getString("name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            boolean z = bundle.getBoolean("isSubDir", true);
            boolean z2 = bundle.getBoolean("isSdcard", false);
            boolean z3 = bundle.getBoolean("isSavedCache", true);
            boolean z4 = bundle.getBoolean("formatData", true);
            vb vbVar = new vb(string, string2, DiskFileOperate.Action.READ);
            vbVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            vbVar.setSubFolder(z);
            vbVar.setIsFormatData(z4);
            vbVar.setSdCard(z2);
            vbVar.setSavedCache(z3);
            if (rb.f().call(vbVar) && vbVar.isSuccess()) {
                vbVar.formatData(vbVar.getData());
                Bitmap bitmap = vbVar.getBitmap();
                if (bitmap != null) {
                    return new co(bitmap, vbVar.isGif());
                }
                return null;
            }
            return null;
        }
        return (co) invokeL.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            y(i, null, i2);
            c(i, i2);
        }
    }

    public Bitmap t(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048594, this, bitmap, shareEntity, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap j = j(bitmap, (mi.f(this.b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
            Bitmap createBitmap = Bitmap.createBitmap(j.getWidth(), j.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(j, 0.0f, 0.0f, (Paint) null);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, j.getHeight(), this.b.getResources().getColor(R.color.CAM_X0601), this.b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, j.getWidth(), j.getHeight(), paint);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080626, R.color.CAM_X0101, null, false);
            if (pureDrawable != null) {
                int min = (int) (Math.min(j.getWidth(), j.getHeight()) * 0.3f);
                int width = (j.getWidth() - min) / 2;
                int height = (j.getHeight() - min) / 2;
                pureDrawable.setBounds(width, height, width + min, min + height);
                pureDrawable.draw(canvas);
            }
            if (z) {
                String saveFileAsPNG = FileHelper.saveFileAsPNG(f, g, createBitmap, 100);
                if (!StringUtils.isNull(saveFileAsPNG)) {
                    shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.d = str;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.c = str;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            z(str, R.drawable.obfuscated_res_0x7f080a83);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            z(str, R.drawable.obfuscated_res_0x7f080a84);
        }
    }

    public void y(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (i == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f115c, new Object[0]);
                }
                x(str);
            } else if (i == 3) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f112d, new Object[0]);
                }
                w(str);
            } else if (i == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f1135, new Object[0]);
                }
                w(str);
            }
        }
    }

    public void z(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i) == null) {
            BdToast.i(d(), str, i, false).q();
        }
    }
}
