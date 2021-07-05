package d.l.a.a.a.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import d.l.a.d.b.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f74064a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74065b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74066c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f74067d;

    /* renamed from: e  reason: collision with root package name */
    public final long f74068e;

    /* renamed from: f  reason: collision with root package name */
    public final String f74069f;

    /* renamed from: g  reason: collision with root package name */
    public final long f74070g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f74071h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f74072i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f74073a;

        /* renamed from: b  reason: collision with root package name */
        public String f74074b;

        /* renamed from: c  reason: collision with root package name */
        public String f74075c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f74076d;

        /* renamed from: e  reason: collision with root package name */
        public long f74077e;

        /* renamed from: f  reason: collision with root package name */
        public String f74078f;

        /* renamed from: g  reason: collision with root package name */
        public long f74079g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f74080h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f74081i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public boolean o;
        public String p;
        public JSONObject q;

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
                    return;
                }
            }
            this.f74076d = false;
            this.o = false;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.l = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f74077e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                this.m = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f74074b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
                this.k = list;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.f74080h = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public d h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (TextUtils.isEmpty(this.f74073a)) {
                    this.f74073a = AppLog.UMENG_CATEGORY;
                }
                JSONObject jSONObject = new JSONObject();
                if (this.f74080h == null) {
                    this.f74080h = new JSONObject();
                }
                try {
                    if (this.j != null && !this.j.isEmpty()) {
                        for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                            if (!this.f74080h.has(entry.getKey())) {
                                this.f74080h.putOpt(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (this.o) {
                        this.p = this.f74075c;
                        JSONObject jSONObject2 = new JSONObject();
                        this.q = jSONObject2;
                        if (this.f74076d) {
                            jSONObject2.put("ad_extra_data", this.f74080h.toString());
                        } else {
                            Iterator<String> keys = this.f74080h.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.q.put(next, this.f74080h.get(next));
                            }
                        }
                        this.q.put("category", this.f74073a);
                        this.q.put("tag", this.f74074b);
                        this.q.put("value", this.f74077e);
                        this.q.put("ext_value", this.f74079g);
                        if (!TextUtils.isEmpty(this.n)) {
                            this.q.put(TiebaStatic.Params.REFER, this.n);
                        }
                        if (this.f74081i != null) {
                            this.q = d.l.a.a.a.g.b.e(this.f74081i, this.q);
                        }
                        if (this.f74076d) {
                            if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f74078f)) {
                                this.q.put("log_extra", this.f74078f);
                            }
                            this.q.put("is_ad_event", "1");
                        }
                    }
                    if (this.f74076d) {
                        jSONObject.put("ad_extra_data", this.f74080h.toString());
                        if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f74078f)) {
                            jSONObject.put("log_extra", this.f74078f);
                        }
                        jSONObject.put("is_ad_event", "1");
                    } else {
                        jSONObject.put("extra", this.f74080h);
                    }
                    if (!TextUtils.isEmpty(this.n)) {
                        jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f74081i != null) {
                        jSONObject = d.l.a.a.a.g.b.e(this.f74081i, jSONObject);
                    }
                    this.f74080h = jSONObject;
                } catch (Exception e2) {
                    l.F().a(e2, "DownloadEventModel build");
                }
                return new d(this);
            }
            return (d) invokeV.objValue;
        }

        public a j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.f74079g = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f74075c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.f74081i = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f74076d = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f74078f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74064a = aVar.f74073a;
        this.f74065b = aVar.f74074b;
        this.f74066c = aVar.f74075c;
        this.f74067d = aVar.f74076d;
        this.f74068e = aVar.f74077e;
        this.f74069f = aVar.f74078f;
        this.f74070g = aVar.f74079g;
        this.f74071h = aVar.f74080h;
        this.f74072i = aVar.f74081i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74065b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f74066c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f74067d : invokeV.booleanValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74071h : (JSONObject) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("category: ");
            sb.append(this.f74064a);
            sb.append("\ttag: ");
            sb.append(this.f74065b);
            sb.append("\tlabel: ");
            sb.append(this.f74066c);
            sb.append("\nisAd: ");
            sb.append(this.f74067d);
            sb.append("\tadId: ");
            sb.append(this.f74068e);
            sb.append("\tlogExtra: ");
            sb.append(this.f74069f);
            sb.append("\textValue: ");
            sb.append(this.f74070g);
            sb.append("\nextJson: ");
            sb.append(this.f74071h);
            sb.append("\nparamsJson: ");
            sb.append(this.f74072i);
            sb.append("\nclickTrackUrl: ");
            List<String> list = this.j;
            sb.append(list != null ? list.toString() : "");
            sb.append("\teventSource: ");
            sb.append(this.k);
            sb.append("\textraObject: ");
            Object obj = this.l;
            sb.append(obj != null ? obj.toString() : "");
            sb.append("\nisV3: ");
            sb.append(this.m);
            sb.append("\tV3EventName: ");
            sb.append(this.n);
            sb.append("\tV3EventParams: ");
            JSONObject jSONObject = this.o;
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
