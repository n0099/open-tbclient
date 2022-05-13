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
import com.repackage.es8;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ds8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ls8 b;
    public es8 c;
    public es8.c d;

    public ds8(Context context) {
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

    public static void a(List<ls8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new ls8(str, i, str2));
    }

    public static List<ls8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08055c, context.getString(R.string.obfuscated_res_0x7f0f0617), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080560, context.getString(R.string.obfuscated_res_0x7f0f0614), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080563, context.getString(R.string.obfuscated_res_0x7f0f0618), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055f, context.getString(R.string.obfuscated_res_0x7f0f0612), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055a, context.getString(R.string.obfuscated_res_0x7f0f060f), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080567, context.getString(R.string.obfuscated_res_0x7f0f061c), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080559, context.getString(R.string.obfuscated_res_0x7f0f060e), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080561, context.getString(R.string.obfuscated_res_0x7f0f0615), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055b, context.getString(R.string.obfuscated_res_0x7f0f0613), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080556, context.getString(R.string.obfuscated_res_0x7f0f060b), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055d, context.getString(R.string.obfuscated_res_0x7f0f0610), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080565, context.getString(R.string.obfuscated_res_0x7f0f061a), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080566, context.getString(R.string.obfuscated_res_0x7f0f061b), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080558, context.getString(R.string.obfuscated_res_0x7f0f060d), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080562, context.getString(R.string.obfuscated_res_0x7f0f0616), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055e, context.getString(R.string.obfuscated_res_0x7f0f0611), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080564, context.getString(R.string.obfuscated_res_0x7f0f0619), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080557, context.getString(R.string.obfuscated_res_0x7f0f060c), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sr8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ls8 ls8Var = this.b;
            return (ls8Var == null || "normal".equalsIgnoreCase(ls8Var.c)) ? "" : this.b.c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        es8 es8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (es8Var = this.c) == null) {
            return;
        }
        es8Var.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            es8 es8Var = this.c;
            if (es8Var != null) {
                return es8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            es8 es8Var = this.c;
            if ((es8Var == null || !es8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                es8 es8Var2 = new es8(this.a, str, d(), str2);
                this.c = es8Var2;
                es8.c cVar = this.d;
                if (cVar != null) {
                    es8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }

    public void h(ls8 ls8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ls8Var) == null) {
            this.b = ls8Var;
        }
    }

    public void i(es8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            es8 es8Var = this.c;
            if (es8Var != null) {
                es8Var.h(cVar);
            }
        }
    }
}
