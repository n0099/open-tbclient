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
import com.repackage.ht8;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ot8 b;
    public ht8 c;
    public ht8.c d;

    public gt8(Context context) {
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

    public static void a(List<ot8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new ot8(str, i, str2));
    }

    public static List<ot8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080561, context.getString(R.string.obfuscated_res_0x7f0f0611), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080565, context.getString(R.string.obfuscated_res_0x7f0f060e), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080568, context.getString(R.string.obfuscated_res_0x7f0f0612), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080564, context.getString(R.string.obfuscated_res_0x7f0f060c), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055f, context.getString(R.string.obfuscated_res_0x7f0f0609), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056c, context.getString(R.string.obfuscated_res_0x7f0f0616), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055e, context.getString(R.string.obfuscated_res_0x7f0f0608), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080566, context.getString(R.string.obfuscated_res_0x7f0f060f), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080560, context.getString(R.string.obfuscated_res_0x7f0f060d), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055b, context.getString(R.string.obfuscated_res_0x7f0f0605), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080562, context.getString(R.string.obfuscated_res_0x7f0f060a), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056a, context.getString(R.string.obfuscated_res_0x7f0f0614), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056b, context.getString(R.string.obfuscated_res_0x7f0f0615), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055d, context.getString(R.string.obfuscated_res_0x7f0f0607), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080567, context.getString(R.string.obfuscated_res_0x7f0f0610), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080563, context.getString(R.string.obfuscated_res_0x7f0f060b), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080569, context.getString(R.string.obfuscated_res_0x7f0f0613), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055c, context.getString(R.string.obfuscated_res_0x7f0f0606), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return vs8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ot8 ot8Var = this.b;
            return (ot8Var == null || "normal".equalsIgnoreCase(ot8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ht8Var = this.c) == null) {
            return;
        }
        ht8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ht8 ht8Var = this.c;
            if (ht8Var != null) {
                return ht8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            ht8 ht8Var = this.c;
            if ((ht8Var == null || !ht8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                ht8 ht8Var2 = new ht8(this.a, str, d(), str2);
                this.c = ht8Var2;
                ht8.c cVar = this.d;
                if (cVar != null) {
                    ht8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(ot8 ot8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ot8Var) == null) {
            this.b = ot8Var;
        }
    }

    public void i(ht8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            ht8 ht8Var = this.c;
            if (ht8Var != null) {
                ht8Var.h(cVar);
            }
        }
    }
}
