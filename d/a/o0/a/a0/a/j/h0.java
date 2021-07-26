package d.a.o0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class h0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint.Align f43747a;

    public h0() {
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

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Align align;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (align = this.f43747a) == null) {
            return;
        }
        bVar.f43726i.setTextAlign(align);
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    String optString = jSONArray.optString(0);
                    if (TextUtils.equals(optString, CustomDialogData.POS_LEFT)) {
                        this.f43747a = Paint.Align.LEFT;
                    } else if (TextUtils.equals(optString, "center")) {
                        this.f43747a = Paint.Align.CENTER;
                    } else if (TextUtils.equals(optString, "right")) {
                        this.f43747a = Paint.Align.RIGHT;
                    }
                }
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
