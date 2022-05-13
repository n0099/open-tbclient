package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes6.dex */
public class on2 implements tq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public nn2 b;
    public String c;
    public String d;
    public double e;
    public double f;
    public int g;
    public int h;
    public b i;
    public c j;
    public a k;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes6.dex */
    public static class a implements tq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public double b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0.5d;
            this.b = 1.0d;
        }

        @Override // com.repackage.tq2
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d = 1.0d;
            this.b = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d2 = this.a;
            if (d2 < 0.0d) {
                d2 = 0.0d;
            } else if (d2 > 1.0d) {
                d2 = 1.0d;
            }
            this.a = d2;
            double d3 = this.b;
            if (d3 < 0.0d) {
                d = 0.0d;
            } else if (d3 <= 1.0d) {
                d = d3;
            }
            this.b = d;
        }

        @Override // com.repackage.tq2
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
    /* loaded from: classes6.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float f;
        public String g;
        public int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(on2 on2Var) {
            super(on2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((on2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = 0.0f;
            this.g = "BYCLICK";
            this.h = -1;
        }

        @Override // com.repackage.on2.d, com.repackage.tq2
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.g = jSONObject.has(CriusAttrConstants.DISPLAY) ? jSONObject.optString(CriusAttrConstants.DISPLAY) : "BYCLICK";
            this.h = hn2.a(jSONObject.optString("bgColor"), -1);
            hn2.a(jSONObject.optString("borderColor"), this.h);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes6.dex */
    public static class c extends d implements tq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float f;
        public float g;
        public float h;
        public int i;
        public float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(on2 on2Var) {
            super(on2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((on2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.i = 0;
            this.j = 0.0f;
        }

        @Override // com.repackage.on2.d, com.repackage.tq2
        public void a(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.f = hn2.b(jSONObject.optDouble("x", 0.0d));
            float b = hn2.b(jSONObject.optDouble("y", 0.0d));
            this.g = b;
            if (this.f == 0.0f && b == 0.0f) {
                this.f = hn2.b(jSONObject.optDouble("anchorX", 0.0d));
                this.g = hn2.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.h = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.i = hn2.a(jSONObject.optString("borderColor"), 0);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes6.dex */
    public static class d implements tq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public float c;
        public int d;
        public float e;

        public d(on2 on2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = -16777216;
            this.c = hn2.b(10.0d);
            this.d = 0;
            this.e = 0.0f;
        }

        @Override // com.repackage.tq2
        public void a(JSONObject jSONObject) throws JSONException {
            float b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("content")) {
                this.a = jSONObject.optString("content");
                this.b = hn2.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                    b = Math.abs(hn2.b(jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 10.0d)));
                } else {
                    b = hn2.b(10.0d);
                }
                this.c = b;
                this.d = hn2.a(jSONObject.optString("bgColor"), 0);
                this.e = hn2.b(jSONObject.optDouble(CriusAttrConstants.PADDING, 0.0d));
                if (jSONObject.has(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN);
                }
            }
        }

        @Override // com.repackage.tq2
        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
        }
    }

    public on2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.c = "";
        this.d = "";
        this.e = 0.0d;
        this.f = 1.0d;
        this.g = -1;
        this.h = -1;
    }

    @Override // com.repackage.tq2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        nn2 nn2Var = new nn2();
        this.b = nn2Var;
        nn2Var.a(jSONObject);
        if (this.b.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.a = optString;
            if (TextUtils.isEmpty(optString)) {
                this.a = jSONObject.optString("id");
            }
            this.c = jSONObject.optString("title");
            this.d = jSONObject.optString("iconPath");
            this.e = jSONObject.optDouble(AnimationProperty.ROTATE, 0.0d);
            this.f = Math.abs(jSONObject.optDouble(AnimationProperty.OPACITY, 1.0d));
            this.g = jSONObject.has("width") ? Math.abs(le3.g(jSONObject.optInt("width"))) : -1;
            this.h = jSONObject.has("height") ? Math.abs(le3.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.i = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar = new c(this);
            this.j = cVar;
            cVar.a(jSONObject.optJSONObject("label"));
            a aVar = new a();
            this.k = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // com.repackage.tq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            nn2 nn2Var = this.b;
            return nn2Var != null && nn2Var.isValid();
        }
        return invokeV.booleanValue;
    }
}
