package com.repackage;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public int a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public List<en0> d;
    @JvmField
    public xm0 e;
    @JvmField
    public an0 f;
    @JvmField
    public String g;
    @JvmField
    public qn0 h;
    @JvmField
    public String i;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final bn0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("convert");
                    if (optJSONObject == null) {
                        optJSONObject = yx0.c(jSONObject.optString("convert"));
                    }
                    if (optJSONObject != null) {
                        bn0 bn0Var = new bn0();
                        bn0Var.b = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                        bn0Var.c = optJSONObject.optString("button_icon");
                        optJSONObject.optString("textColor");
                        optJSONObject.optInt("buttonShineType");
                        bn0Var.g = optJSONObject.optString("background_color");
                        bn0Var.i = optJSONObject.optString("button_scheme");
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                en0 a = en0.d.a(optJSONArray.optJSONObject(i));
                                if (a != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        bn0Var.d = arrayList;
                        return bn0Var;
                    }
                    return null;
                }
                return null;
            }
            return (bn0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821363, "Lcom/repackage/bn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821363, "Lcom/repackage/bn0;");
                return;
            }
        }
        j = new a(null);
    }

    public bn0() {
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
        this.a = 1;
    }

    @JvmStatic
    public static final bn0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? j.a(jSONObject) : (bn0) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a == 2 && this.e == null) ? false : true : invokeV.booleanValue;
    }
}
