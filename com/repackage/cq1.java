package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cq1 extends cp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public int g;
    public ViewTreeObserver.OnGlobalLayoutListener h;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq1 a;

        public a(cq1 cq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq1Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.f.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.a.g == height) {
                    return;
                }
                if (this.a.g - height <= 180) {
                    if (height - this.a.g > 180) {
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("height", 0);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        hashMap.put("data", jSONObject.toString());
                        mm2.U().u(new ab2("keyboardHeightChange", hashMap));
                        this.a.g = height;
                        return;
                    }
                    return;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", qe3.O(this.a.g - height));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                mm2.U().u(new ab2("keyboardHeightChange", hashMap2));
                this.a.g = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = mm2.U().getActivity();
            if (activity == null) {
                zx1.c("SoftKeyboardApi", "activity is null");
                return;
            }
            this.f = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f.getWindowVisibleDisplayFrame(rect);
            this.g = rect.height();
            if (this.h == null) {
                this.h = new a(this);
                this.f.getViewTreeObserver().addOnGlobalLayoutListener(this.h);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.h != null) {
                this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this.h);
            }
            this.h = null;
            this.g = 0;
        }
    }

    public zs1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#startKeyboardHeightChange", false);
            if (z03.b0() == null) {
                return new zs1(1001, "swan app is null");
            }
            A();
            return zs1.f();
        }
        return (zs1) invokeV.objValue;
    }

    public zs1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            q("#stopKeyboardHeightChange", false);
            if (z03.b0() == null) {
                return new zs1(1001, "swan app is null");
            }
            B();
            return zs1.f();
        }
        return (zs1) invokeV.objValue;
    }

    @Override // com.repackage.cp1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Keyboard" : (String) invokeV.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SoftKeyboardApi" : (String) invokeV.objValue;
    }
}
