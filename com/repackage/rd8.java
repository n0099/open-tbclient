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
/* loaded from: classes7.dex */
public class rd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final ViewGroup c;

    public rd8(Context context, ViewGroup viewGroup) {
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

    public sd8 b(cd8 cd8Var, sd8 sd8Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd8Var, sd8Var)) == null) {
            if (cd8Var == null || (str = cd8Var.a) == null) {
                return sd8Var;
            }
            if (sd8Var == null || !a(str, sd8Var.a)) {
                ViewGroup viewGroup = this.c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(cd8Var.a)) {
                    if (this.a == 2) {
                        return new qd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08af, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new od8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d083e, this.c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(cd8Var.a)) {
                    if (this.a == 2) {
                        return new pd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08ae, this.c, true), "apk_download");
                    }
                    return new nd8(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d083d, this.c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return sd8Var;
        }
        return (sd8) invokeLL.objValue;
    }
}
