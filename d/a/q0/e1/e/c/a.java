package d.a.q0.e1.e.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.p;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes8.dex */
public class a extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55858a;

    /* renamed from: b  reason: collision with root package name */
    public String f55859b;

    /* renamed from: c  reason: collision with root package name */
    public String f55860c;

    /* renamed from: d  reason: collision with root package name */
    public int f55861d;

    public a() {
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

    public void a(SubClassItem subClassItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, subClassItem) == null) || subClassItem == null) {
            return;
        }
        this.f55858a = subClassItem.sub_class_id.intValue();
        this.f55859b = subClassItem.sub_class_name;
        this.f55860c = subClassItem.sub_class_icon;
        this.f55861d = subClassItem.enable.intValue();
    }

    @Override // d.a.p0.s.q.p
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f55858a = jSONObject.optInt("sub_class_id");
        this.f55859b = jSONObject.optString("sub_class_name");
        this.f55860c = jSONObject.optString("sub_class_icon");
        this.f55861d = jSONObject.optInt(c.l);
    }
}
