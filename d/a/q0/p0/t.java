package d.a.q0.p0;

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
/* loaded from: classes8.dex */
public class t extends d.a.p0.x.p.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f61885e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f61886f;

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61885e = new ArrayList<>();
        this.f61886f = new HashSet();
        v();
    }

    @Override // d.a.p0.x.p.c
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= this.f61885e.size()) {
                return null;
            }
            return this.f61885e.get(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // d.a.p0.x.p.c
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> arrayList = this.f61885e;
            if (arrayList == null || arrayList.size() == 0) {
                return 1;
            }
            return this.f61885e.size();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.x.p.c
    public d.a.d.k.d.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.d() : (d.a.d.k.d.a) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.p0.b0.d.a() : (String) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户收藏表情" : (String) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.c
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EmotionGroupType.USER_COLLECT : (EmotionGroupType) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.c
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.x.p.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.x.p.c
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.x.p.c
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.f61886f.contains(str) : invokeL.booleanValue;
    }

    @Override // d.a.p0.x.p.c
    public d.a.d.k.d.a n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048586, this, str)) != null) {
            return (d.a.d.k.d.a) invokeL.objValue;
        }
        File file = new File(t(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
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
                            d.a.d.k.d.a aVar = new d.a.d.k.d.a(NSGif.f(byteArray, 0, byteArray.length));
                            d.a.d.e.m.a.c(fileInputStream);
                            d.a.d.e.m.a.d(byteArrayOutputStream);
                            return aVar;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    d.a.d.e.m.a.c(fileInputStream);
                    d.a.d.e.m.a.d(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                d.a.d.e.m.a.c(fileInputStream);
                d.a.d.e.m.a.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            d.a.d.e.m.a.c(fileInputStream);
            d.a.d.e.m.a.d(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // d.a.p0.x.p.c
    public d.a.d.k.d.a o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (d.a.p0.b0.d.f52028d.equals(str)) {
                return new d.a.d.k.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
            }
            Bitmap image = FileHelper.getImage(t(str).getAbsolutePath());
            if (image == null) {
                return null;
            }
            return new d.a.d.k.d.a(image, false, str);
        }
        return (d.a.d.k.d.a) invokeL.objValue;
    }

    public File t(String str) {
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
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.p0.b0.d.b() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (this.f61885e != null && !TextUtils.isEmpty(str)) {
                Iterator<String> it = this.f61885e.iterator();
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

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            s(2);
            p(4);
            d.a.d.k.d.a aVar = new d.a.d.k.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
            super.r(aVar);
            super.q(aVar);
            w();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.f61885e.clear();
            this.f61886f.clear();
            for (CollectEmotionData collectEmotionData : n) {
                this.f61885e.add(collectEmotionData.sharpText);
                this.f61886f.add(collectEmotionData.sharpText);
            }
        }
    }
}
