package d.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class q1 extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f69301e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f69302f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(Context context, y1 y1Var) {
        super(true, false);
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
        this.f69301e = context;
        this.f69302f = y1Var;
    }

    @Override // d.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (!TextUtils.isEmpty(this.f69302f.i())) {
                jSONObject.put("ab_client", this.f69302f.i());
            }
            if (!TextUtils.isEmpty(this.f69302f.U())) {
                if (h0.f69234b) {
                    h0.a("init config has abversion:" + this.f69302f.U(), null);
                }
                jSONObject.put("ab_version", this.f69302f.U());
            }
            if (!TextUtils.isEmpty(this.f69302f.j())) {
                jSONObject.put("ab_group", this.f69302f.j());
            }
            if (TextUtils.isEmpty(this.f69302f.k())) {
                return true;
            }
            jSONObject.put("ab_feature", this.f69302f.k());
            return true;
        }
        return invokeL.booleanValue;
    }
}
