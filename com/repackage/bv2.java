package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bv2 extends cv2 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final uz2<bv2> k;
    public static final vz2<bv2> l;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public long h;
    public long i;
    public int j;

    /* loaded from: classes5.dex */
    public static class a extends uz2<bv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.uz2
        /* renamed from: b */
        public bv2 a(@NonNull mi2 mi2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mi2Var)) == null) {
                bv2 bv2Var = new bv2();
                bv2Var.a = mi2Var.g();
                bv2Var.b = mi2Var.g();
                bv2Var.c = mi2Var.readLong();
                bv2Var.d = mi2Var.readInt();
                bv2Var.e = mi2Var.g();
                bv2Var.f = mi2Var.g();
                bv2Var.g = mi2Var.readBoolean();
                bv2Var.h = mi2Var.readLong();
                bv2Var.i = mi2Var.readLong();
                bv2Var.j = mi2Var.readInt();
                return bv2Var;
            }
            return (bv2) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends vz2<bv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vz2
        /* renamed from: b */
        public void a(@NonNull bv2 bv2Var, @NonNull ni2 ni2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bv2Var, ni2Var) == null) {
                ni2Var.f(bv2Var.a);
                ni2Var.f(bv2Var.b);
                ni2Var.writeLong(bv2Var.c);
                ni2Var.writeInt(bv2Var.d);
                ni2Var.f(bv2Var.e);
                ni2Var.f(bv2Var.f);
                ni2Var.writeBoolean(bv2Var.g);
                ni2Var.writeLong(bv2Var.h);
                ni2Var.writeLong(bv2Var.i);
                ni2Var.writeInt(bv2Var.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813613, "Lcom/repackage/bv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813613, "Lcom/repackage/bv2;");
                return;
            }
        }
        k = new a();
        l = new b();
    }

    public bv2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanDependentModel{inline=" + this.g + ", minVersionCode=" + this.h + ", maxVersionCode=" + this.i + ", requireType=" + this.j + ", libName='" + this.a + "', versionName='" + this.b + "', versionCode=" + this.c + ", category=" + this.d + ", libPath='" + this.e + "', libConfig='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }

    public bv2(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
        if (jSONObject == null) {
            return;
        }
        this.a = str;
        this.d = 6;
        this.b = jSONObject.optString("version");
        this.c = jSONObject.optLong("version_code", -1L);
        this.e = jSONObject.optString("path");
        this.g = jSONObject.optBoolean(TKBase.DISPLAY_INLINE, false);
        this.h = jSONObject.optLong("min_version_code");
        this.i = jSONObject.optLong("max_version_code");
        this.f = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.j = jSONObject.optInt("require_type");
    }
}
