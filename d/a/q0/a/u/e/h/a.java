package d.a.q0.a.u.e.h;

import android.graphics.Rect;
import android.util.Log;
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
import d.a.q0.a.a2.e;
import d.a.q0.a.g1.f;
import d.a.q0.a.o0.d.b;
import d.a.q0.a.u.c.d;
import d.a.q0.a.v2.n0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public View f50942d;

    /* renamed from: e  reason: collision with root package name */
    public int f50943e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f50944f;

    /* renamed from: d.a.q0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0969a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50945e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0969a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50945e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f50945e.f50942d.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f50945e.f50943e == height) {
                    return;
                }
                if (this.f50945e.f50943e - height <= 180) {
                    if (height - this.f50945e.f50943e > 180) {
                        if (d.f50740c) {
                            Log.d("Api-GetKeyboardHeight", "onKeyBoardHide: mRootViewVisibleHeight " + this.f50945e.f50943e + " visibleHeight " + height);
                        }
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("height", 0);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        hashMap.put("data", jSONObject.toString());
                        f.V().v(new b("keyboardHeightChange", hashMap));
                        this.f50945e.f50943e = height;
                        return;
                    }
                    return;
                }
                if (d.f50740c) {
                    Log.d("Api-GetKeyboardHeight", "onKeyBoardShow: mRootViewVisibleHeight " + this.f50945e.f50943e + " visibleHeight " + height);
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", n0.K(this.f50945e.f50943e - height));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                f.V().v(new b("keyboardHeightChange", hashMap2));
                this.f50945e.f50943e = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                d.a.q0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
                return;
            }
            this.f50942d = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f50942d.getWindowVisibleDisplayFrame(rect);
            this.f50943e = rect.height();
            if (this.f50944f == null) {
                this.f50944f = new ViewTreeObserver$OnGlobalLayoutListenerC0969a(this);
                this.f50942d.getViewTreeObserver().addOnGlobalLayoutListener(this.f50944f);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f50944f != null) {
                this.f50942d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f50944f);
            }
            this.f50944f = null;
            this.f50943e = 0;
        }
    }

    public d.a.q0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d.f50740c) {
                Log.d("Api-GetKeyboardHeight", "handle: ");
            }
            if (e.Q() == null) {
                return new d.a.q0.a.u.h.b(1001, "SwanApp is null");
            }
            u();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public d.a.q0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (d.f50740c) {
                Log.d("Api-GetKeyboardHeight", "handle");
            }
            if (e.Q() == null) {
                return new d.a.q0.a.u.h.b(1001, "SwanApp is null");
            }
            v();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }
}
