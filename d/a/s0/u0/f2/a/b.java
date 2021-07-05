package d.a.s0.u0.f2.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.r0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes9.dex */
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65977e;

    /* renamed from: f  reason: collision with root package name */
    public int f65978f;

    /* renamed from: g  reason: collision with root package name */
    public String f65979g;

    /* renamed from: h  reason: collision with root package name */
    public int f65980h;

    /* renamed from: i  reason: collision with root package name */
    public String f65981i;

    public b() {
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

    @Override // d.a.r0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // d.a.r0.g0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && (message instanceof ZoneRightResIdl)) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f65978f = error.errorno.intValue();
                this.f65979g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f65977e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f65980h = toast.type.intValue();
                    this.f65981i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
