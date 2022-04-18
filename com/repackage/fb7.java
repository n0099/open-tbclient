package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class fb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public long b;
    public String c;
    public int d;
    public int e;
    public int f;

    public fb7() {
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
        this.b = 0L;
        this.a = new HashMap<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : invokeV.intValue;
    }

    public void c(List<String> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, list, i, i2) == null) {
            synchronized (this.a) {
                if (System.nanoTime() - this.b > AbsMsgImageActivity.INV_TIME && list != null && i < list.size()) {
                    this.a.put(list.get(i), Boolean.TRUE);
                }
                this.b = System.nanoTime();
                if (list != null && i2 < list.size() && this.a.get(list.get(i2)) == null) {
                    this.a.put(list.get(i2), Boolean.FALSE);
                }
            }
            if (this.a.size() >= 100) {
                g();
            }
        }
    }

    public void d(Bundle bundle, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, intent) == null) {
            if (bundle != null) {
                this.c = bundle.getString(ImageViewerConfig.PV_TYPE);
            } else if (intent != null) {
                this.c = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                int intExtra = intent.getIntExtra("index", -1);
                this.d = intExtra;
                this.e = intExtra;
                this.f = intExtra;
            }
        }
    }

    public void e(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && i == 1 && System.nanoTime() - this.b > AbsMsgImageActivity.INV_TIME) {
            this.a.put(str, Boolean.TRUE);
        }
    }

    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString(ImageViewerConfig.PV_TYPE, this.c);
    }

    public void g() {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hashMap = this.a) == null) {
            return;
        }
        synchronized (hashMap) {
            if (this.a.size() <= 0) {
                return;
            }
            int i = 0;
            for (Map.Entry<String, Boolean> entry : this.a.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    i++;
                }
            }
            TbadkCoreApplication.getInst().sendImagePv(i, this.a.size(), this.c, this.d + 1, this.e + 1);
            this.a.clear();
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.e = i;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f = i;
        }
    }

    public void j(int i, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, str5}) == null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i2 = this.f;
            if (i2 != this.e) {
                while (true) {
                    int i3 = this.e;
                    if (i2 > i3) {
                        break;
                    }
                    if (i2 == i3) {
                        sb.append(i2 + 1);
                        if (this.e == i - 1) {
                            sb2.append(1);
                        } else {
                            sb2.append(0);
                        }
                    } else {
                        sb.append(i2 + 1);
                        sb.append("|");
                        sb2.append(0);
                        sb2.append("|");
                    }
                    i2++;
                }
            } else {
                sb.append(i2 + 1);
                if (this.e == i - 1) {
                    sb2.append(1);
                } else {
                    sb2.append(0);
                }
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a008");
            if (!ni.isEmpty(str2)) {
                statisticItem.param("fid", str2);
            }
            if (!ni.isEmpty(str3)) {
                statisticItem.param("tid", str3);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().n);
            }
            statisticItem.param("pic_count", i);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR_MERGE, sb.toString());
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD_MERGE, sb2.toString());
            int i4 = this.e;
            int i5 = (i4 - this.f) + 1;
            if (i5 == 1) {
                if (i4 == i - 1) {
                    statisticItem.param("obj_id", str);
                } else {
                    statisticItem.param("obj_id", "");
                }
            }
            if (i5 > 1) {
                StringBuilder sb3 = new StringBuilder();
                for (int i6 = 0; i6 < i5 - 1; i6++) {
                    sb3.append("|");
                }
                if (this.e == i - 1) {
                    sb3.append(str);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_ID_MERGE, str);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, str4);
            }
            if (!StringUtils.isNull(str5)) {
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, str5);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
