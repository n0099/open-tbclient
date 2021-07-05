package d.a.s0.h3.o0.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f61379a;

    /* renamed from: b  reason: collision with root package name */
    public String f61380b;

    /* renamed from: c  reason: collision with root package name */
    public String f61381c;

    /* renamed from: d  reason: collision with root package name */
    public String f61382d;

    /* renamed from: e  reason: collision with root package name */
    public int f61383e;

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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("chunk_nolist");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.f61379a = new ArrayList<>();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f61379a.add(Integer.valueOf(optJSONArray.getInt(i2)));
                    }
                }
                this.f61380b = optJSONObject.optString("upload_id");
                this.f61381c = optJSONObject.optString("video_url");
            }
        } catch (JSONException unused) {
        }
    }
}
