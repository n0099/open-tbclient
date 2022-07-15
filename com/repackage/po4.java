package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsPage.CoverImageColor;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes6.dex */
public class po4 implements zr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public CoverImageColor c;
    public List<VideoImageColor> d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public String m;
    public float n;
    public List<String> o;
    public ph8 p;

    /* loaded from: classes6.dex */
    public class a implements Comparator<VideoImageColor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(po4 po4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(VideoImageColor videoImageColor, VideoImageColor videoImageColor2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, videoImageColor, videoImageColor2)) == null) ? videoImageColor.time.intValue() - videoImageColor2.time.intValue() : invokeLL.intValue;
        }
    }

    public po4(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = str;
        this.f = str2;
        this.i = str3;
    }

    @Override // com.repackage.zr4
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.zr4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public po4 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            po4 po4Var = new po4();
            po4Var.a = this.a;
            po4Var.b = this.b;
            po4Var.c = this.c;
            po4Var.d = this.d;
            po4Var.e = this.e;
            po4Var.f = this.f;
            po4Var.g = this.g;
            po4Var.i = this.i;
            po4Var.j = this.j;
            po4Var.k = this.k;
            po4Var.m = this.m;
            po4Var.n = this.n;
            po4Var.o = this.o;
            po4Var.h = this.h;
            return po4Var;
        }
        return (po4) invokeV.objValue;
    }

    public CoverImageColor d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (CoverImageColor) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public ph8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : (ph8) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.floatValue;
    }

    public List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (List) invokeV.objValue;
    }

    public List<VideoImageColor> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void q(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, headImgs) == null) || headImgs == null) {
            return;
        }
        this.a = headImgs.cover_url;
        this.b = headImgs.play_url;
        this.c = headImgs.cover_image_color;
        u(headImgs.video_image_color);
        this.e = headImgs.img_url;
        this.f = headImgs.pc_url;
        this.g = headImgs.schema;
        this.m = headImgs.tag_name_url;
        this.h = headImgs.package_name;
        String str = headImgs.tag_name_wh;
        if (str != null) {
            try {
                String[] split = str.split(",");
                int e = ng.e(split[0], 1);
                int e2 = ng.e(split[1], 1);
                if (e2 != 0) {
                    this.n = e / e2;
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
        String str2 = headImgs.title;
        if (str2 != null) {
            this.i = str2.trim();
        }
        String str3 = headImgs.subtitle;
        if (str3 != null) {
            this.j = str3.trim();
        }
        String str4 = headImgs.btn_text;
        if (str4 != null) {
            this.k = str4.trim();
        }
        this.o = headImgs.third_statistics_url;
        ph8 ph8Var = new ph8();
        this.p = ph8Var;
        ph8Var.d(headImgs);
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.e = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f = str;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.l = z;
        }
    }

    public void u(List<VideoImageColor> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a(this));
        this.d = arrayList;
    }

    public po4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
