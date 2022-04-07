package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public dd8(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = context;
        this.c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if ("apk_download".equals(str)) {
                return "apk_download".equals(str2);
            }
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
                return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public ed8 b(gc8 gc8Var, ed8 ed8Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gc8Var, ed8Var)) == null) {
            if (gc8Var == null || (str = gc8Var.a) == null) {
                return ed8Var;
            }
            if (ed8Var == null || !a(str, ed8Var.a)) {
                ViewGroup viewGroup = this.c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(gc8Var.a)) {
                    int i = this.a;
                    if (i == 1) {
                        return new cd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0888, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    if (i == 2) {
                        return new bd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0873, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new zc8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0801, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(gc8Var.a)) {
                    if (this.a == 2) {
                        return new ad8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0872, this.c, true), "apk_download");
                    }
                    return new yc8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0800, this.c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return ed8Var;
        }
        return (ed8) invokeLL.objValue;
    }
}
