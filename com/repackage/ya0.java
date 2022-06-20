package com.repackage;

import android.content.Context;
import android.graphics.Color;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ya0 extends va0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755148663, "Lcom/repackage/ya0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755148663, "Lcom/repackage/ya0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public ya0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.put("color_1F1F1F", new String[]{"#141414", "#BFFFFFFF", "#E6FFFFFF", ""});
        b.put("color_white1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        b.put("color_white2", new String[]{"#F5F5F5", "#272729", "#141414", ""});
        b.put("color_white3", new String[]{"#FFFFFF", "#D9FFFFFF", "#FFFFFF", ""});
        b.put("color_F5F5F51", new String[]{"#F2F2F5", "#141414", "#000000", ""});
        b.put("color_F5F5F52", new String[]{"#F7F7FA", "#1E1D1F", "#1AFFFFFF", ""});
        b.put("color_F5F5F53", new String[]{"#0D000000", "#0DFFFFFF", "#1AFFFFFF", ""});
        b.put("color_FF33551", new String[]{"#FF3355", "#D42A46", "#FF3355", ""});
        b.put("color_FF33552", new String[]{"#1AFF3355", "#1AD42A46", "#1AFF3355", ""});
        b.put("color_858585", new String[]{"#858585", "#59FFFFFF", "#80FFFFFF", ""});
        b.put("color_525252", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        b.put("color_FF3333", new String[]{"#FF3333", "#FF3333", "#FF3333", ""});
        b.put("color_768CAE", new String[]{"#768CAE", "#768CAE", "#768CAE", ""});
        b.put("color_4E6EF2", new String[]{"#4E6EF2", "#4E6EF2", "#4E6EF2", ""});
        b.put("color_8585852", new String[]{"#858585", "#444444", "#80FFFFFF", ""});
        b.put("color_5252522", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        b.put("color_btn_stroke", new String[]{"#00000000", "#00000000", "#00000000", ""});
        b.put("color_btn_fill", new String[]{"#F7F7FA", "#1E1D1F", "#000000", ""});
    }

    @Override // com.repackage.va0
    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (b.containsKey(str)) {
                String str2 = b.get(str)[0];
                if (z) {
                    str2 = b.get(str)[3];
                } else {
                    String str3 = this.a;
                    if (SkinManager.SKIN_TYPE_STR_NIGHT == str3) {
                        str2 = b.get(str)[1];
                    } else if ("dark" == str3) {
                        str2 = b.get(str)[2];
                    }
                }
                if (oa0.a(str2)) {
                    return -16777216;
                }
                try {
                    return Color.parseColor(str2);
                } catch (Exception e) {
                    e.printStackTrace();
                    return -16777216;
                }
            }
            return -16777216;
        }
        return invokeCommon.intValue;
    }
}
