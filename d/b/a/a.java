package d.b.a;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.google.ar.core.InstallActivity;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f71644e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(true, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71644e = context;
    }

    @Override // d.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            DisplayMetrics displayMetrics = this.f71644e.getResources().getDisplayMetrics();
            int i2 = displayMetrics.densityDpi;
            switch (i2) {
                case 120:
                    str = "ldpi";
                    break;
                case 240:
                    str = "hdpi";
                    break;
                case 260:
                case InstallActivity.BOX_SIZE_DP /* 280 */:
                case 300:
                case MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP /* 320 */:
                    str = "xhdpi";
                    break;
                case 340:
                case 360:
                case 400:
                case HttpStatus.SC_METHOD_FAILURE /* 420 */:
                case 440:
                case 480:
                    str = "xxhdpi";
                    break;
                case PayBeanFactory.BEAN_ID_PAY_SORT_SAVE /* 560 */:
                case 640:
                    str = "xxxhdpi";
                    break;
                default:
                    str = "mdpi";
                    break;
            }
            jSONObject.put("density_dpi", i2);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
            return true;
        }
        return invokeL.booleanValue;
    }
}
