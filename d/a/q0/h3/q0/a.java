package d.a.q0.h3.q0;

import androidx.annotation.NonNull;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58754a;

    /* renamed from: b  reason: collision with root package name */
    public long f58755b;

    /* renamed from: c  reason: collision with root package name */
    public int f58756c;

    /* renamed from: d  reason: collision with root package name */
    public String f58757d;

    /* renamed from: e  reason: collision with root package name */
    public String f58758e;

    /* renamed from: f  reason: collision with root package name */
    public String f58759f;

    /* renamed from: g  reason: collision with root package name */
    public long f58760g;

    /* renamed from: h  reason: collision with root package name */
    public int f58761h;

    /* renamed from: i  reason: collision with root package name */
    public int f58762i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public boolean n;
    public String o;
    public String p;
    public int q;
    public int r;
    public long s;

    public a(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageFileInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        imageFileInfo.startUploadTime = currentTimeMillis;
        this.f58754a = currentTimeMillis;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", String.valueOf(this.f58754a));
            jSONObject.put("endTime", String.valueOf(this.f58755b));
            jSONObject.put("errorCode", String.valueOf(this.f58756c));
            jSONObject.put("errorMessage", this.f58757d);
            jSONObject.put("picId", this.f58758e);
            jSONObject.put("originPath", this.f58759f);
            jSONObject.put("originSize", String.valueOf(this.f58760g));
            jSONObject.put("originWidth", String.valueOf(this.f58761h));
            jSONObject.put("originHeight", String.valueOf(this.f58762i));
            jSONObject.put("isLongImage", String.valueOf(this.j));
            jSONObject.put("isHeifImage", String.valueOf(this.k));
            jSONObject.put("startCompressTime", String.valueOf(this.l));
            jSONObject.put("endCompressTime", String.valueOf(this.m));
            jSONObject.put("hasActionsWithoutResize", String.valueOf(this.n));
            jSONObject.put("uploadImageType", this.o);
            jSONObject.put("compressTempPath", this.p);
            jSONObject.put("compressWidth", String.valueOf(this.q));
            jSONObject.put("compressHeight", String.valueOf(this.r));
            jSONObject.put("compressSize", String.valueOf(this.s));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58754a = System.currentTimeMillis();
        this.f58759f = str;
    }
}
