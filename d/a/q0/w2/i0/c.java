package d.a.q0.w2.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f66681a;

    /* renamed from: b  reason: collision with root package name */
    public String f66682b;

    /* renamed from: c  reason: collision with root package name */
    public int f66683c;

    /* renamed from: d  reason: collision with root package name */
    public int f66684d;

    /* renamed from: e  reason: collision with root package name */
    public int f66685e;

    /* renamed from: f  reason: collision with root package name */
    public String f66686f;

    /* renamed from: g  reason: collision with root package name */
    public long f66687g;

    /* renamed from: h  reason: collision with root package name */
    public String f66688h;

    /* renamed from: i  reason: collision with root package name */
    public int f66689i;
    public String j;
    public int k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public DownloadStaticsData q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66683c = -1;
        this.f66684d = -1;
        this.f66685e = -1;
        this.f66687g = System.currentTimeMillis() / 1000;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.f66681a == null) {
                this.f66681a = new JSONObject();
            }
            try {
                this.f66681a.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f66684d != -1) {
                    jSONObject.put("da_locate", this.f66684d);
                }
                if (this.f66683c != -1) {
                    jSONObject.put("da_type", this.f66683c);
                }
                jSONObject.put("extra_param", this.f66682b);
                jSONObject.put("origin_time", this.f66687g);
                if (this.f66685e != -1) {
                    jSONObject.put("da_page_num", this.f66685e);
                }
                jSONObject.put("da_price", this.f66688h);
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
                jSONObject.put("ext1", this.f66689i);
                jSONObject.put("ext3", this.k);
                jSONObject.put("ext2", this.j);
                jSONObject.put("da_ext1", this.l);
                jSONObject.put("da_ext2", this.m);
                jSONObject.put("da_ext3", this.n);
                jSONObject.put("da_ext4", this.o);
                jSONObject.put("da_ext5", this.p);
                jSONObject.put("da_menu1", this.s);
                jSONObject.put("da_menu2", this.t);
                jSONObject.put("da_menu3", this.u);
                jSONObject.put("da_page", this.v);
                jSONObject.put("place_id", this.f66686f);
                jSONObject.put("lego_extra", this.r);
                if (this.q != null) {
                    jSONObject.put("da_range", this.q.getDa_range());
                    jSONObject.put("da_range_nt", this.q.getDa_range_nt());
                    jSONObject.put("da_page", this.q.getDa_page());
                    jSONObject.put("da_menu3", this.q.getFid());
                    jSONObject.put("apk_name", this.q.getApk_name());
                }
                jSONObject.put("da_area", this.w);
            } catch (JSONException unused) {
            }
            JSONObject jSONObject2 = this.f66681a;
            if (jSONObject2 != null) {
                try {
                    jSONObject.put("ext", jSONObject2);
                } catch (Exception unused2) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.w = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f66684d = i2;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.s = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.t = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.v = str;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f66683c = i2;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.l = String.valueOf(i2);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.m = String.valueOf(i2);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.n = String.valueOf(i2);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.o = String.valueOf(i2);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.o = str;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.p = String.valueOf(i2);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.p = str;
        }
    }

    public void r(DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadStaticsData) == null) {
            this.q = downloadStaticsData;
            if (downloadStaticsData != null) {
                this.f66684d = d.a.d.e.m.b.d(downloadStaticsData.getAdPosition(), 0);
                this.f66682b = downloadStaticsData.getExtensionInfo();
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f66682b = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.r = str;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f66685e = i2;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f66686f = str;
        }
    }
}
