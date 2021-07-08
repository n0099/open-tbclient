package d.a.o0.s.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f53093f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53094a;

    /* renamed from: b  reason: collision with root package name */
    public int f53095b;

    /* renamed from: c  reason: collision with root package name */
    public String f53096c;

    /* renamed from: d  reason: collision with root package name */
    public int f53097d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f53098e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-699437120, "Ld/a/o0/s/c/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-699437120, "Ld/a/o0/s/c/f0;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f53093f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f53093f.put(ShareDialogConfig.From.Concern, 2);
        f53093f.put(ShareDialogConfig.From.PB, 3);
        f53093f.put(ShareDialogConfig.From.FRS, 4);
        f53093f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f53093f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f53093f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f53093f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f53093f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public f0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53097d : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53096c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() / 1000 >= ((long) this.f53094a) && System.currentTimeMillis() / 1000 <= ((long) this.f53095b) : invokeV.booleanValue;
    }

    public boolean d(ShareDialogConfig.From from) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, from)) == null) ? (this.f53098e == null || (num = f53093f.get(from)) == null || !this.f53098e.contains(num)) ? false : true : invokeL.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f53094a = jSONObject.optInt("begin_time");
        this.f53095b = jSONObject.optInt(ResultTB.ENDTIME);
        this.f53096c = jSONObject.optString("text");
        this.f53097d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || d.a.c.e.p.k.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int d2 = d.a.c.e.m.b.d(str2, -1);
            if (d2 != -1) {
                if (this.f53098e == null) {
                    this.f53098e = new ArrayList();
                }
                this.f53098e.add(Integer.valueOf(d2));
            }
        }
    }
}
