package d.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint.Join f46530a;

    public c0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Join join;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (join = this.f46530a) == null) {
            return;
        }
        bVar.f46522g.setStrokeJoin(join);
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 0) {
            return;
        }
        String optString = jSONArray.optString(0);
        if (TextUtils.equals(optString, "bevel")) {
            this.f46530a = Paint.Join.BEVEL;
        } else if (TextUtils.equals(optString, "round")) {
            this.f46530a = Paint.Join.ROUND;
        } else if (TextUtils.equals(optString, "miter")) {
            this.f46530a = Paint.Join.MITER;
        }
    }
}
