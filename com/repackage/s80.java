package com.repackage;

import android.content.Context;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class s80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        String string;
        Float valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i)) == null) {
            if (i < 0) {
                return "";
            }
            long j = i;
            if (j < 10000) {
                return i + context.getString(R.string.obfuscated_res_0x7f0f0a0e);
            }
            if (j < 100000000) {
                string = context.getString(R.string.obfuscated_res_0x7f0f0a0c);
                valueOf = Float.valueOf(i / 10000.0f);
            } else {
                string = context.getString(R.string.obfuscated_res_0x7f0f0a06);
                valueOf = Float.valueOf(i / 1.0E8f);
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.#");
            return decimalFormat.format(valueOf) + string;
        }
        return (String) invokeLI.objValue;
    }
}
