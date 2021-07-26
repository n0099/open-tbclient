package d.a.q0.h3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes8.dex */
public class k implements d.a.p0.s.w.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f58559a;

    /* renamed from: b  reason: collision with root package name */
    public String f58560b;

    /* renamed from: c  reason: collision with root package name */
    public int f58561c;

    /* renamed from: d  reason: collision with root package name */
    public int f58562d;

    public k(Timgs timgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timgs};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58559a = null;
        this.f58560b = null;
        this.f58561c = 1;
        this.f58562d = 1;
        if (timgs == null) {
            return;
        }
        this.f58559a = timgs.img_url;
        timgs.flag.intValue();
        this.f58560b = timgs.url;
        String str = timgs.big_cdn_url;
        String str2 = timgs.des_main;
        String str3 = timgs.des_sub;
        String str4 = timgs.bsize;
        if (str4 != null) {
            try {
                String[] split = str4.split(",");
                this.f58561c = d.a.d.e.m.b.d(split[0], 1);
                this.f58562d = d.a.d.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f58561c <= 0) {
            this.f58561c = 1;
        }
        if (this.f58562d <= 0) {
            this.f58562d = 1;
        }
    }

    @Override // d.a.p0.s.w.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58559a : (String) invokeV.objValue;
    }

    @Override // d.a.p0.s.w.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58560b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58559a : (String) invokeV.objValue;
    }

    public k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58559a = null;
        this.f58560b = null;
        this.f58561c = 1;
        this.f58562d = 1;
        if (jSONObject == null) {
            return;
        }
        try {
            this.f58559a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optInt("flag");
            this.f58560b = jSONObject.optString("url");
            jSONObject.optString("big_cdn_url");
            jSONObject.optString("des_main");
            jSONObject.optString("des_sub");
            String optString = jSONObject.optString("bsize");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f58561c = Integer.valueOf(split[0]).intValue();
                    this.f58562d = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f58561c <= 0) {
                this.f58561c = 1;
            }
            if (this.f58562d <= 0) {
                this.f58562d = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
