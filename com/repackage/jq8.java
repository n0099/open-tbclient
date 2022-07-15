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
import com.repackage.kq8;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public rq8 b;
    public kq8 c;
    public kq8.c d;

    public jq8(Context context) {
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

    public static void a(List<rq8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new rq8(str, i, str2));
    }

    public static List<rq8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080559, context.getString(R.string.obfuscated_res_0x7f0f061c), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055d, context.getString(R.string.obfuscated_res_0x7f0f0619), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080560, context.getString(R.string.obfuscated_res_0x7f0f061d), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055c, context.getString(R.string.obfuscated_res_0x7f0f0617), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080557, context.getString(R.string.obfuscated_res_0x7f0f0614), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080564, context.getString(R.string.obfuscated_res_0x7f0f0621), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080556, context.getString(R.string.obfuscated_res_0x7f0f0613), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055e, context.getString(R.string.obfuscated_res_0x7f0f061a), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080558, context.getString(R.string.obfuscated_res_0x7f0f0618), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080553, context.getString(R.string.obfuscated_res_0x7f0f0610), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055a, context.getString(R.string.obfuscated_res_0x7f0f0615), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080562, context.getString(R.string.obfuscated_res_0x7f0f061f), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080563, context.getString(R.string.obfuscated_res_0x7f0f0620), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080555, context.getString(R.string.obfuscated_res_0x7f0f0612), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055f, context.getString(R.string.obfuscated_res_0x7f0f061b), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055b, context.getString(R.string.obfuscated_res_0x7f0f0616), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080561, context.getString(R.string.obfuscated_res_0x7f0f061e), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080554, context.getString(R.string.obfuscated_res_0x7f0f0611), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return yp8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rq8 rq8Var = this.b;
            return (rq8Var == null || "normal".equalsIgnoreCase(rq8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        kq8 kq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kq8Var = this.c) == null) {
            return;
        }
        kq8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kq8 kq8Var = this.c;
            if (kq8Var != null) {
                return kq8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            kq8 kq8Var = this.c;
            if ((kq8Var == null || !kq8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                kq8 kq8Var2 = new kq8(this.a, str, d(), str2);
                this.c = kq8Var2;
                kq8.c cVar = this.d;
                if (cVar != null) {
                    kq8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(rq8 rq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rq8Var) == null) {
            this.b = rq8Var;
        }
    }

    public void i(kq8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            kq8 kq8Var = this.c;
            if (kq8Var != null) {
                kq8Var.h(cVar);
            }
        }
    }
}
