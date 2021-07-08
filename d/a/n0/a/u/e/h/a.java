package d.a.n0.a.u.e.h;

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
import d.a.n0.a.a2.e;
import d.a.n0.a.g1.f;
import d.a.n0.a.o0.d.b;
import d.a.n0.a.u.c.d;
import d.a.n0.a.v2.n0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public View f47640d;

    /* renamed from: e  reason: collision with root package name */
    public int f47641e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47642f;

    /* renamed from: d.a.n0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0918a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47643e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0918a(a aVar) {
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
            this.f47643e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f47643e.f47640d.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f47643e.f47641e == height) {
                    return;
                }
                if (this.f47643e.f47641e - height <= 180) {
                    if (height - this.f47643e.f47641e > 180) {
                        if (d.f47438c) {
                            Log.d("Api-GetKeyboardHeight", "onKeyBoardHide: mRootViewVisibleHeight " + this.f47643e.f47641e + " visibleHeight " + height);
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
                        this.f47643e.f47641e = height;
                        return;
                    }
                    return;
                }
                if (d.f47438c) {
                    Log.d("Api-GetKeyboardHeight", "onKeyBoardShow: mRootViewVisibleHeight " + this.f47643e.f47641e + " visibleHeight " + height);
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("height", n0.K(this.f47643e.f47641e - height));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                hashMap2.put("data", jSONObject2.toString());
                f.V().v(new b("keyboardHeightChange", hashMap2));
                this.f47643e.f47641e = height;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
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
                d.a.n0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
                return;
            }
            this.f47640d = activity.getWindow().getDecorView();
            Rect rect = new Rect();
            this.f47640d.getWindowVisibleDisplayFrame(rect);
            this.f47641e = rect.height();
            if (this.f47642f == null) {
                this.f47642f = new ViewTreeObserver$OnGlobalLayoutListenerC0918a(this);
                this.f47640d.getViewTreeObserver().addOnGlobalLayoutListener(this.f47642f);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f47642f != null) {
                this.f47640d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47642f);
            }
            this.f47642f = null;
            this.f47641e = 0;
        }
    }

    public d.a.n0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d.f47438c) {
                Log.d("Api-GetKeyboardHeight", "handle: ");
            }
            if (e.Q() == null) {
                return new d.a.n0.a.u.h.b(1001, "SwanApp is null");
            }
            u();
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    public d.a.n0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (d.f47438c) {
                Log.d("Api-GetKeyboardHeight", "handle");
            }
            if (e.Q() == null) {
                return new d.a.n0.a.u.h.b(1001, "SwanApp is null");
            }
            v();
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }
}
