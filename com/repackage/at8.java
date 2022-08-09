package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.bt8;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class at8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public it8 b;
    public bt8 c;
    public bt8.c d;

    public at8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(List<it8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new it8(str, i, str2));
    }

    public static List<it8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08055b, context.getString(R.string.obfuscated_res_0x7f0f0626), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055f, context.getString(R.string.obfuscated_res_0x7f0f0623), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080562, context.getString(R.string.obfuscated_res_0x7f0f0627), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055e, context.getString(R.string.obfuscated_res_0x7f0f0621), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080559, context.getString(R.string.obfuscated_res_0x7f0f061e), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080566, context.getString(R.string.obfuscated_res_0x7f0f062b), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080558, context.getString(R.string.obfuscated_res_0x7f0f061d), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080560, context.getString(R.string.obfuscated_res_0x7f0f0624), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055a, context.getString(R.string.obfuscated_res_0x7f0f0622), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080555, context.getString(R.string.obfuscated_res_0x7f0f061a), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055c, context.getString(R.string.obfuscated_res_0x7f0f061f), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080564, context.getString(R.string.obfuscated_res_0x7f0f0629), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080565, context.getString(R.string.obfuscated_res_0x7f0f062a), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080557, context.getString(R.string.obfuscated_res_0x7f0f061c), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080561, context.getString(R.string.obfuscated_res_0x7f0f0625), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055d, context.getString(R.string.obfuscated_res_0x7f0f0620), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080563, context.getString(R.string.obfuscated_res_0x7f0f0628), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080556, context.getString(R.string.obfuscated_res_0x7f0f061b), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ps8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            it8 it8Var = this.b;
            return (it8Var == null || "normal".equalsIgnoreCase(it8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        bt8 bt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bt8Var = this.c) == null) {
            return;
        }
        bt8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bt8 bt8Var = this.c;
            if (bt8Var != null) {
                return bt8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            bt8 bt8Var = this.c;
            if ((bt8Var == null || !bt8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                bt8 bt8Var2 = new bt8(this.a, str, d(), str2);
                this.c = bt8Var2;
                bt8.c cVar = this.d;
                if (cVar != null) {
                    bt8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(it8 it8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, it8Var) == null) {
            this.b = it8Var;
        }
    }

    public void i(bt8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            bt8 bt8Var = this.c;
            if (bt8Var != null) {
                bt8Var.h(cVar);
            }
        }
    }
}
