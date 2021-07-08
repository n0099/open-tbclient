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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71116a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71117b;

    /* renamed from: c  reason: collision with root package name */
    public final String f71118c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f71119d;

    /* renamed from: e  reason: collision with root package name */
    public final long f71120e;

    /* renamed from: f  reason: collision with root package name */
    public final String f71121f;

    /* renamed from: g  reason: collision with root package name */
    public final long f71122g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f71123h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f71124i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f71125a;

        /* renamed from: b  reason: collision with root package name */
        public String f71126b;

        /* renamed from: c  reason: collision with root package name */
        public String f71127c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71128d;

        /* renamed from: e  reason: collision with root package name */
        public long f71129e;

        /* renamed from: f  reason: collision with root package name */
        public String f71130f;

        /* renamed from: g  reason: collision with root package name */
        public long f71131g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f71132h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f71133i;
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
            this.f71128d = false;
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
                this.f71129e = j;
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
                this.f71126b = str;
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
                this.f71132h = jSONObject;
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
                if (TextUtils.isEmpty(this.f71125a)) {
                    this.f71125a = AppLog.UMENG_CATEGORY;
                }
                JSONObject jSONObject = new JSONObject();
                if (this.f71132h == null) {
                    this.f71132h = new JSONObject();
                }
                try {
                    if (this.j != null && !this.j.isEmpty()) {
                        for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                            if (!this.f71132h.has(entry.getKey())) {
                                this.f71132h.putOpt(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (this.o) {
                        this.p = this.f71127c;
                        JSONObject jSONObject2 = new JSONObject();
                        this.q = jSONObject2;
                        if (this.f71128d) {
                            jSONObject2.put("ad_extra_data", this.f71132h.toString());
                        } else {
                            Iterator<String> keys = this.f71132h.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.q.put(next, this.f71132h.get(next));
                            }
                        }
                        this.q.put("category", this.f71125a);
                        this.q.put("tag", this.f71126b);
                        this.q.put("value", this.f71129e);
                        this.q.put("ext_value", this.f71131g);
                        if (!TextUtils.isEmpty(this.n)) {
                            this.q.put(TiebaStatic.Params.REFER, this.n);
                        }
                        if (this.f71133i != null) {
                            this.q = d.l.a.a.a.g.b.e(this.f71133i, this.q);
                        }
                        if (this.f71128d) {
                            if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f71130f)) {
                                this.q.put("log_extra", this.f71130f);
                            }
                            this.q.put("is_ad_event", "1");
                        }
                    }
                    if (this.f71128d) {
                        jSONObject.put("ad_extra_data", this.f71132h.toString());
                        if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f71130f)) {
                            jSONObject.put("log_extra", this.f71130f);
                        }
                        jSONObject.put("is_ad_event", "1");
                    } else {
                        jSONObject.put("extra", this.f71132h);
                    }
                    if (!TextUtils.isEmpty(this.n)) {
                        jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f71133i != null) {
                        jSONObject = d.l.a.a.a.g.b.e(this.f71133i, jSONObject);
                    }
                    this.f71132h = jSONObject;
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
                this.f71131g = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f71127c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.f71133i = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f71128d = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f71130f = str;
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
        this.f71116a = aVar.f71125a;
        this.f71117b = aVar.f71126b;
        this.f71118c = aVar.f71127c;
        this.f71119d = aVar.f71128d;
        this.f71120e = aVar.f71129e;
        this.f71121f = aVar.f71130f;
        this.f71122g = aVar.f71131g;
        this.f71123h = aVar.f71132h;
        this.f71124i = aVar.f71133i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71117b : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71118c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71119d : invokeV.booleanValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71123h : (JSONObject) invokeV.objValue;
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
            sb.append(this.f71116a);
            sb.append("\ttag: ");
            sb.append(this.f71117b);
            sb.append("\tlabel: ");
            sb.append(this.f71118c);
            sb.append("\nisAd: ");
            sb.append(this.f71119d);
            sb.append("\tadId: ");
            sb.append(this.f71120e);
            sb.append("\tlogExtra: ");
            sb.append(this.f71121f);
            sb.append("\textValue: ");
            sb.append(this.f71122g);
            sb.append("\nextJson: ");
            sb.append(this.f71123h);
            sb.append("\nparamsJson: ");
            sb.append(this.f71124i);
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
