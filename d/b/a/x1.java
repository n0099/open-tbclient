package d.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x1 extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f69332e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f69333f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(Context context, y1 y1Var) {
        super(false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y1Var};
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
        this.f69332e = context;
        this.f69333f = y1Var;
    }

    @Override // d.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 336);
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.8.0-rc.2-embed");
            jSONObject.put("channel", this.f69333f.L());
            z1.g(jSONObject, "aid", this.f69333f.K());
            z1.g(jSONObject, "release_build", this.f69333f.b0());
            z1.g(jSONObject, "app_region", this.f69333f.O());
            z1.g(jSONObject, "app_language", this.f69333f.N());
            z1.g(jSONObject, com.alipay.sdk.cons.b.f1875b, this.f69333f.a());
            z1.g(jSONObject, "ab_sdk_version", this.f69333f.Q());
            z1.g(jSONObject, "ab_version", this.f69333f.U());
            z1.g(jSONObject, "aliyun_uuid", this.f69333f.q());
            String M = this.f69333f.M();
            if (TextUtils.isEmpty(M)) {
                M = c0.a(this.f69332e, this.f69333f);
            }
            if (!TextUtils.isEmpty(M)) {
                z1.g(jSONObject, "google_aid", M);
            }
            String a0 = this.f69333f.a0();
            if (!TextUtils.isEmpty(a0)) {
                try {
                    jSONObject.put("app_track", new JSONObject(a0));
                } catch (Throwable th) {
                    h0.b(th);
                }
            }
            String P = this.f69333f.P();
            if (P != null && P.length() > 0) {
                jSONObject.put(SchedulerSupport.CUSTOM, new JSONObject(P));
            }
            z1.g(jSONObject, "user_unique_id", this.f69333f.R());
            return true;
        }
        return invokeL.booleanValue;
    }
}
