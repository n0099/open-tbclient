package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class k76 extends l05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> e;
    public Set<String> f;

    public k76() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList<>();
        this.f = new HashSet();
        w();
    }

    @Override // com.repackage.l05
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= this.e.size()) {
                return null;
            }
            return this.e.get(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.repackage.l05
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> arrayList = this.e;
            if (arrayList == null || arrayList.size() == 0) {
                return 1;
            }
            return this.e.size();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.l05
    public um e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.d() : (um) invokeV.objValue;
    }

    @Override // com.repackage.l05
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? v25.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.l05
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户收藏表情" : (String) invokeV.objValue;
    }

    @Override // com.repackage.l05
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EmotionGroupType.USER_COLLECT : (EmotionGroupType) invokeV.objValue;
    }

    @Override // com.repackage.l05
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.l05
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.l05
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.l05
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.f.contains(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.l05
    public um n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048586, this, str)) != null) {
            return (um) invokeL.objValue;
        }
        File file = new File(u(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            um umVar = new um(NSGif.f(byteArray, 0, byteArray.length));
                            ig.c(fileInputStream);
                            ig.d(byteArrayOutputStream);
                            return umVar;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    ig.c(fileInputStream);
                    ig.d(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                ig.c(fileInputStream);
                ig.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            ig.c(fileInputStream);
            ig.d(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.repackage.l05
    public um o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (v25.f.equals(str)) {
                return new um(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
            }
            Bitmap image = FileHelper.getImage(u(str).getAbsolutePath());
            if (image == null) {
                return null;
            }
            return new um(image, false, str);
        }
        return (um) invokeL.objValue;
    }

    public File u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String replace2 = replace.substring(0, replace.indexOf(",")).replace("collect_", "");
            if (replace2.contains("_")) {
                replace2 = replace2.substring(replace2.indexOf("_") + 1);
            }
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + v25.d() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (this.e != null && !TextUtils.isEmpty(str)) {
                Iterator<String> it = this.e.iterator();
                while (it.hasNext()) {
                    if (it.next().contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            t(2);
            q(4);
            um umVar = new um(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
            super.s(umVar);
            super.r(umVar);
            x();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            List<CollectEmotionData> q = b76.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (CollectEmotionData collectEmotionData : q) {
                this.e.add(collectEmotionData.getSharpText());
                this.f.add(collectEmotionData.getSharpText());
            }
        }
    }
}
