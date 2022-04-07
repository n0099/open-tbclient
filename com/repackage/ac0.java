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
/* loaded from: classes5.dex */
public class ac0 extends bc0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755861725, "Lcom/repackage/ac0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755861725, "Lcom/repackage/ac0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public ac0() {
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
        b.put("color_1F1F1F", new String[]{"#1F1F1F", "#666666", "", "#858585"});
        b.put("color_white1", new String[]{"#FFFFFF", "#191919", "", "#161823"});
        b.put("color_white2", new String[]{"#FFFFFF", "#222222", "", "#1F2337"});
        b.put("color_white3", new String[]{"#FFFFFF", "#4DFFFFFF", "", "#FFFFFF"});
        b.put("color_F5F5F51", new String[]{"#F5F5F5", "#191919", "", "#161823"});
        b.put("color_F5F5F52", new String[]{"#F5F5F5", "#121212", "", "#161823"});
        b.put("color_F5F5F53", new String[]{"#F5F5F5", "#121212", "", "#1AFFFFFF"});
        b.put("color_FF33551", new String[]{"#FF3355", "#80192A", "", "#FF3355"});
        b.put("color_FF33552", new String[]{"#1AFF3355", "#1A80192A", "", "#26FF3355"});
        b.put("color_858585", new String[]{"#858585", "#444444", "", "#858585"});
        b.put("color_525252", new String[]{"#525252", "#555555", "", "#858585"});
        b.put("color_FF3333", new String[]{"#FF3333", "#7F1919", "", "#FF3333"});
        b.put("color_768CAE", new String[]{"#768CAE", "#3A4556", "", "#768CAE"});
        b.put("color_4E6EF2", new String[]{"#4E6EF2", "#263678", "", "#4E6EF2"});
        b.put("color_8585852", new String[]{"#858585", "#444444", "", "#858585"});
        b.put("color_5252522", new String[]{"#525252", "#555555", "", "#99FFFFFF"});
        b.put("color_btn_stroke", new String[]{"#B8B8B8", "#00000000", "#00000000", ""});
        b.put("color_btn_fill", new String[]{"#00000000", "#303030", "", "#66666666"});
        b.put("color_E0E0E0", new String[]{"#E0E0E0", "#33ffffff", "", ""});
        b.put("color_EEEEEE", new String[]{"#eeeeee", "#121212", "", ""});
        b.put("color_search_guide", new String[]{"#ffffff", "#80ffffff", "", ""});
    }

    @Override // com.repackage.bc0
    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (b.containsKey(str)) {
                String str2 = b.get(str)[0];
                if (z) {
                    str2 = b.get(str)[3];
                } else if (SkinManager.SKIN_TYPE_STR_NIGHT == this.a) {
                    str2 = b.get(str)[1];
                }
                if (ub0.a(str2)) {
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
