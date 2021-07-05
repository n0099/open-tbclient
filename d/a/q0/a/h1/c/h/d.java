package d.a.q0.a.h1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes8.dex */
public class d implements d.a.q0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f48609e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.h1.c.h.c f48610f;

    /* renamed from: g  reason: collision with root package name */
    public String f48611g;

    /* renamed from: h  reason: collision with root package name */
    public String f48612h;

    /* renamed from: i  reason: collision with root package name */
    public double f48613i;
    public double j;
    public int k;
    public int l;
    public b m;
    public c n;
    public a o;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
    public static class a implements d.a.q0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f48614e;

        /* renamed from: f  reason: collision with root package name */
        public double f48615f;

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
            this.f48614e = 0.5d;
            this.f48615f = 1.0d;
        }

        @Override // d.a.q0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f48614e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f48615f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f48614e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f48614e = d3;
            double d4 = this.f48615f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f48615f = d2;
        }

        @Override // d.a.q0.a.l1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
    public static class b extends C0821d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
        public String k;
        public int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // d.a.q0.a.h1.c.h.d.C0821d, d.a.q0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = d.a.q0.a.h1.c.d.a(jSONObject.optString("bgColor"), -1);
            d.a.q0.a.h1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes8.dex */
    public static class c extends C0821d implements d.a.q0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar) {
            super(dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // d.a.q0.a.h1.c.h.d.C0821d, d.a.q0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = d.a.q0.a.h1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = d.a.q0.a.h1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.j == 0.0f && b2 == 0.0f) {
                this.j = d.a.q0.a.h1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = d.a.q0.a.h1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = d.a.q0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: d.a.q0.a.h1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0821d implements d.a.q0.a.l1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f48616e;

        /* renamed from: f  reason: collision with root package name */
        public int f48617f;

        /* renamed from: g  reason: collision with root package name */
        public float f48618g;

        /* renamed from: h  reason: collision with root package name */
        public int f48619h;

        /* renamed from: i  reason: collision with root package name */
        public float f48620i;

        public C0821d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48616e = "";
            this.f48617f = -16777216;
            this.f48618g = d.a.q0.a.h1.c.d.b(10.0d);
            this.f48619h = 0;
            this.f48620i = 0.0f;
        }

        @Override // d.a.q0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.f48616e = jSONObject.optString("content");
                this.f48617f = d.a.q0.a.h1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(d.a.q0.a.h1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = d.a.q0.a.h1.c.d.b(10.0d);
                }
                this.f48618g = b2;
                this.f48619h = d.a.q0.a.h1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f48620i = d.a.q0.a.h1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // d.a.q0.a.l1.a
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f48616e) : invokeV.booleanValue;
        }
    }

    public d() {
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
        this.f48609e = "";
        this.f48611g = "";
        this.f48612h = "";
        this.f48613i = 0.0d;
        this.j = 1.0d;
        this.k = -1;
        this.l = -1;
    }

    @Override // d.a.q0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        d.a.q0.a.h1.c.h.c cVar = new d.a.q0.a.h1.c.h.c();
        this.f48610f = cVar;
        cVar.a(jSONObject);
        if (this.f48610f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f48609e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f48609e = jSONObject.optString("id");
            }
            this.f48611g = jSONObject.optString("title");
            this.f48612h = jSONObject.optString("iconPath");
            this.f48613i = jSONObject.optDouble("rotate", 0.0d);
            this.j = Math.abs(jSONObject.optDouble("alpha", 1.0d));
            this.k = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.l = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.m = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar2 = new c(this);
            this.n = cVar2;
            cVar2.a(jSONObject.optJSONObject(NotificationCompatJellybean.KEY_LABEL));
            a aVar = new a();
            this.o = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // d.a.q0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.a.h1.c.h.c cVar = this.f48610f;
            return cVar != null && cVar.isValid();
        }
        return invokeV.booleanValue;
    }
}
