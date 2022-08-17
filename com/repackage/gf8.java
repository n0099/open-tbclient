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
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.BdToastHelper;
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
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class gf8 implements mf8 {
    public static /* synthetic */ Interceptable $ic;
    public static String g;
    public static String h;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public Context b;
    public String c;
    public String d;
    public ShareEntity e;
    public String f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755679848, "Lcom/repackage/gf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755679848, "Lcom/repackage/gf8;");
                return;
            }
        }
        g = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";
        h = "temp_video_thumb.png";
        i = "_temp_share_pic.png";
    }

    public gf8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            C(str, BdToast.ToastIcon.SUCCESS);
        }
    }

    public void B(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f115a, new Object[0]);
                }
                String m = m();
                if (m != null) {
                    D(l(R.string.obfuscated_res_0x7f0f115b, new Object[0]), m);
                    v();
                    ru4.k().u("key_person_growth_share_switch", true);
                    return;
                }
                A(str);
            } else if (i2 == 3) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f112a, new Object[0]);
                }
                z(str);
            } else if (i2 == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = l(R.string.obfuscated_res_0x7f0f1132, new Object[0]);
                }
                z(str);
            }
        }
    }

    public void C(String str, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, toastIcon) == null) {
            BdToast b = BdToast.b(d(), str);
            b.f(toastIcon);
            b.i();
        }
    }

    public void D(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            BdToastData bdToastData = new BdToastData();
            bdToastData.setIconType(4);
            ArrayList arrayList = new ArrayList(1);
            BdToastData.a aVar = new BdToastData.a();
            aVar.d(str);
            arrayList.add(aVar);
            if (str2 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX).append((CharSequence) str2);
                BdToastData.a aVar2 = new BdToastData.a();
                aVar2.c(1);
                aVar2.d(spannableStringBuilder.toString());
                arrayList.add(aVar2);
            }
            bdToastData.setContent(arrayList);
            BdToastHelper.toast(bdToastData);
        }
    }

    public void b(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            ShareEvent shareEvent = new ShareEvent();
            shareEvent.status = i2;
            shareEvent.tid = this.c;
            shareEvent.channel = i3;
            shareEvent.extLiveInfo = this.d;
            shareEvent.from = i4;
            o75.i(shareEvent);
        }
    }

    public final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                b(i2, i3, 0);
            } else if (!StringUtils.isNull(this.d)) {
                b(i2, i3, 0);
            } else {
                ShareEntity shareEntity = this.e;
                if (shareEntity == null || !shareEntity.isFromDuXiaoMan()) {
                    return;
                }
                b(i2, i3, 1);
            }
        }
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TbadkCoreApplication.getInst().getContext() : (Context) invokeV.objValue;
    }

    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? BitmapHelper.getCashBitmap(R.drawable.obfuscated_res_0x7f081833) : (Bitmap) invokeV.objValue;
    }

    public Bitmap f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? BitmapHelper.getCashBitmap(i2) : (Bitmap) invokeI.objValue;
    }

    public Bitmap g(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uri)) == null) ? BitmapHelper.loadBitmap(uri.getPath()) : (Bitmap) invokeL.objValue;
    }

    public Bitmap h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? BitmapHelper.loadBitmap(str) : (Bitmap) invokeL.objValue;
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        g9 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdUniqueId bdUniqueId = this.a;
            return (bdUniqueId == null && (c = h9.c(this.b)) != null) ? c.getUniqueId() : bdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Bitmap j(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, bitmap, i2)) == null) ? BitmapHelper.resizeBitmap(bitmap, i2, i2, false) : (Bitmap) invokeLI.objValue;
    }

    public Bitmap k(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048589, this, bitmap, i2, i3)) == null) ? BitmapHelper.resizeBitmap(bitmap, i2, i3, false) : (Bitmap) invokeLII.objValue;
    }

    public String l(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, objArr)) == null) ? d().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
        }
    }

    public boolean o(Uri uri) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uri)) == null) {
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

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public zm q(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, shareEntity)) == null) {
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
            zb zbVar = new zb(string, string2, DiskFileOperate.Action.READ);
            zbVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            zbVar.setSubFolder(z);
            zbVar.setIsFormatData(z4);
            zbVar.setSdCard(z2);
            zbVar.setSavedCache(z3);
            if (vb.f().call(zbVar) && zbVar.isSuccess()) {
                zbVar.formatData(zbVar.getData());
                Bitmap bitmap = zbVar.getBitmap();
                if (bitmap != null) {
                    return new zm(bitmap, zbVar.isGif());
                }
                return null;
            }
            return null;
        }
        return (zm) invokeL.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            B(i2, null, i3);
            c(i2, i3);
        }
    }

    public Bitmap u(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, bitmap, shareEntity, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap j = j(bitmap, (qi.f(this.b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
            Bitmap createBitmap = Bitmap.createBitmap(j.getWidth(), j.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(j, 0.0f, 0.0f, (Paint) null);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, j.getHeight(), this.b.getResources().getColor(R.color.CAM_X0601), this.b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, j.getWidth(), j.getHeight(), paint);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080627, R.color.CAM_X0101, null, false);
            if (pureDrawable != null) {
                int min = (int) (Math.min(j.getWidth(), j.getHeight()) * 0.3f);
                int width = (j.getWidth() - min) / 2;
                int height = (j.getHeight() - min) / 2;
                pureDrawable.setBounds(width, height, width + min, min + height);
                pureDrawable.draw(canvas);
            }
            if (z) {
                String saveFileAsPNG = FileHelper.saveFileAsPNG(g, h, createBitmap, 100);
                if (!StringUtils.isNull(saveFileAsPNG)) {
                    shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.d = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.c = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f = str;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            C(str, BdToast.ToastIcon.FAILURE);
        }
    }
}
