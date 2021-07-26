package d.a.o0.a.c0.c.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends d.a.o0.a.c0.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String O;
    public int P;
    public String Q;
    public String R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public int Y;
    public boolean Z;
    public boolean a0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("textArea", "inputId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.O = "";
        this.Q = "";
        this.R = "";
    }

    private void k() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (jSONObject = this.n) == null) {
            return;
        }
        int g2 = n0.g(e(jSONObject, "minHeight", 0.0f));
        if (g2 < 0) {
            g2 = 0;
        }
        this.X = g2;
        int g3 = n0.g(e(this.n, "maxHeight", 2.1474836E9f));
        if (g3 < 0) {
            g3 = Integer.MAX_VALUE;
        }
        this.Y = g3;
    }

    @Override // d.a.o0.a.c0.a.a.b, d.a.o0.a.c0.a.c.c, d.a.o0.a.c0.a.d.b, d.a.o0.a.c0.b.b, d.a.o0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        d.a.o0.a.l1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("value");
        this.O = jSONObject.optString("placeholder");
        q(jSONObject);
        this.S = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        boolean optBoolean = jSONObject.optBoolean("autoHeight", false);
        this.T = optBoolean;
        if (optBoolean && (aVar = this.l) != null) {
            aVar.m(-2);
            this.l.n(true);
        }
        boolean optBoolean2 = jSONObject.optBoolean("fixed");
        this.U = optBoolean2;
        d.a.o0.a.l1.e.a.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.l(optBoolean2);
        }
        this.V = jSONObject.optBoolean("showConfirmBar", true);
        this.W = jSONObject.optBoolean("adjustPosition", true);
        this.Z = jSONObject.optBoolean("disabled", false);
        this.a0 = jSONObject.optInt("confirmHold") == 1;
        k();
    }

    @Override // d.a.o0.a.c0.a.a.b, d.a.o0.a.c0.a.c.c, d.a.o0.a.c0.a.d.b, d.a.o0.a.c0.b.b
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.i(jSONObject);
            this.Z = jSONObject.optBoolean("disabled", this.Z);
            this.O = jSONObject.optString("placeholder", this.O);
            this.x = jSONObject.optString("value", this.x);
            this.S = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.S);
            this.V = jSONObject.optBoolean("showConfirmBar", this.V);
            this.W = jSONObject.optBoolean("adjustPosition", this.W);
            p(jSONObject);
            r(jSONObject);
            q(jSONObject);
            k();
        }
    }

    public final void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("autoHeight", this.T);
            this.T = optBoolean;
            d.a.o0.a.l1.e.a.a aVar = this.l;
            if (aVar != null) {
                if (optBoolean) {
                    aVar.m(-2);
                    this.l.n(true);
                    return;
                }
                int f2 = aVar.f();
                int i2 = this.N;
                if (i2 > 0) {
                    f2 = i2;
                }
                this.l.m(f2);
                this.l.n(false);
            }
        }
    }

    public final void q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("placeholderStyle")) == null) {
            return;
        }
        this.P = optJSONObject.optInt("fontSize");
        this.Q = optJSONObject.optString("fontWeight");
        this.R = optJSONObject.optString("color");
    }

    public final void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            boolean optBoolean = jSONObject.optBoolean("fixed", this.U);
            this.U = optBoolean;
            d.a.o0.a.l1.e.a.a aVar = this.l;
            if (aVar != null) {
                aVar.l(optBoolean);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.S = z;
        }
    }
}
