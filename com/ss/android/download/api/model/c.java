package com.ss.android.download.api.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68358a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68359b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68360c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f68361d;

    /* renamed from: e  reason: collision with root package name */
    public final long f68362e;

    /* renamed from: f  reason: collision with root package name */
    public final String f68363f;

    /* renamed from: g  reason: collision with root package name */
    public final long f68364g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f68365h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f68366i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f68367a;

        /* renamed from: b  reason: collision with root package name */
        public String f68368b;

        /* renamed from: c  reason: collision with root package name */
        public String f68369c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f68370d;

        /* renamed from: e  reason: collision with root package name */
        public long f68371e;

        /* renamed from: f  reason: collision with root package name */
        public String f68372f;

        /* renamed from: g  reason: collision with root package name */
        public long f68373g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f68374h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f68375i;
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
            this.f68370d = false;
            this.o = false;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f68369c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.f68372f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f68368b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.f68373g = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f68371e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f68370d = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.f68374h = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.f68375i = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
                this.k = list;
                return this;
            }
            return (a) invokeL.objValue;
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

        public a a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                this.m = obj;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (TextUtils.isEmpty(this.f68367a)) {
                    this.f68367a = BaseConstants.CATEGORY_UMENG;
                }
                JSONObject jSONObject = new JSONObject();
                if (this.f68374h == null) {
                    this.f68374h = new JSONObject();
                }
                try {
                    if (this.j != null && !this.j.isEmpty()) {
                        for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                            if (!this.f68374h.has(entry.getKey())) {
                                this.f68374h.putOpt(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (this.o) {
                        this.p = this.f68369c;
                        JSONObject jSONObject2 = new JSONObject();
                        this.q = jSONObject2;
                        if (this.f68370d) {
                            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f68374h.toString());
                        } else {
                            Iterator<String> keys = this.f68374h.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                this.q.put(next, this.f68374h.get(next));
                            }
                        }
                        this.q.put("category", this.f68367a);
                        this.q.put("tag", this.f68368b);
                        this.q.put("value", this.f68371e);
                        this.q.put("ext_value", this.f68373g);
                        if (!TextUtils.isEmpty(this.n)) {
                            this.q.put(TiebaStatic.Params.REFER, this.n);
                        }
                        if (this.f68375i != null) {
                            this.q = com.ss.android.download.api.c.b.a(this.f68375i, this.q);
                        }
                        if (this.f68370d) {
                            if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f68372f)) {
                                this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f68372f);
                            }
                            this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                        }
                    }
                    if (this.f68370d) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f68374h.toString());
                        if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f68372f)) {
                            jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f68372f);
                        }
                        jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    } else {
                        jSONObject.put("extra", this.f68374h);
                    }
                    if (!TextUtils.isEmpty(this.n)) {
                        jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f68375i != null) {
                        jSONObject = com.ss.android.download.api.c.b.a(this.f68375i, jSONObject);
                    }
                    this.f68374h = jSONObject;
                } catch (Exception e2) {
                    j.s().a(e2, "DownloadEventModel build");
                }
                return new c(this);
            }
            return (c) invokeV.objValue;
        }
    }

    public c(a aVar) {
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
        this.f68358a = aVar.f68367a;
        this.f68359b = aVar.f68368b;
        this.f68360c = aVar.f68369c;
        this.f68361d = aVar.f68370d;
        this.f68362e = aVar.f68371e;
        this.f68363f = aVar.f68372f;
        this.f68364g = aVar.f68373g;
        this.f68365h = aVar.f68374h;
        this.f68366i = aVar.f68375i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68358a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68359b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68360c : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68361d : invokeV.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68362e : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68363f : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68364g : invokeV.longValue;
    }

    public JSONObject h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f68365h : (JSONObject) invokeV.objValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68366i : (JSONObject) invokeV.objValue;
    }

    public List<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }

    public Object l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p : (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("category: ");
            sb.append(this.f68358a);
            sb.append("\ttag: ");
            sb.append(this.f68359b);
            sb.append("\tlabel: ");
            sb.append(this.f68360c);
            sb.append("\nisAd: ");
            sb.append(this.f68361d);
            sb.append("\tadId: ");
            sb.append(this.f68362e);
            sb.append("\tlogExtra: ");
            sb.append(this.f68363f);
            sb.append("\textValue: ");
            sb.append(this.f68364g);
            sb.append("\nextJson: ");
            sb.append(this.f68365h);
            sb.append("\nparamsJson: ");
            sb.append(this.f68366i);
            sb.append("\nclickTrackUrl: ");
            List<String> list = this.j;
            sb.append(list != null ? list.toString() : "");
            sb.append("\teventSource: ");
            sb.append(this.k);
            sb.append("\textraObject: ");
            Object obj = this.l;
            sb.append(obj != null ? obj.toString() : "");
            sb.append("\nisV3: ");
            sb.append(this.n);
            sb.append("\tV3EventName: ");
            sb.append(this.o);
            sb.append("\tV3EventParams: ");
            JSONObject jSONObject = this.p;
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
