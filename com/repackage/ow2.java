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
/* loaded from: classes6.dex */
public class ow2 extends pw2 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final h13<ow2> k;
    public static final i13<ow2> l;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public long h;
    public long i;
    public int j;

    /* loaded from: classes6.dex */
    public static class a extends h13<ow2> {
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
        @Override // com.repackage.h13
        /* renamed from: b */
        public ow2 a(@NonNull zj2 zj2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj2Var)) == null) {
                ow2 ow2Var = new ow2();
                ow2Var.a = zj2Var.g();
                ow2Var.b = zj2Var.g();
                ow2Var.c = zj2Var.readLong();
                ow2Var.d = zj2Var.readInt();
                ow2Var.e = zj2Var.g();
                ow2Var.f = zj2Var.g();
                ow2Var.g = zj2Var.readBoolean();
                ow2Var.h = zj2Var.readLong();
                ow2Var.i = zj2Var.readLong();
                ow2Var.j = zj2Var.readInt();
                return ow2Var;
            }
            return (ow2) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends i13<ow2> {
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
        @Override // com.repackage.i13
        /* renamed from: b */
        public void a(@NonNull ow2 ow2Var, @NonNull ak2 ak2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ow2Var, ak2Var) == null) {
                ak2Var.f(ow2Var.a);
                ak2Var.f(ow2Var.b);
                ak2Var.writeLong(ow2Var.c);
                ak2Var.writeInt(ow2Var.d);
                ak2Var.f(ow2Var.e);
                ak2Var.f(ow2Var.f);
                ak2Var.writeBoolean(ow2Var.g);
                ak2Var.writeLong(ow2Var.h);
                ak2Var.writeLong(ow2Var.i);
                ak2Var.writeInt(ow2Var.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755425369, "Lcom/repackage/ow2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755425369, "Lcom/repackage/ow2;");
                return;
            }
        }
        k = new a();
        l = new b();
    }

    public ow2() {
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

    public ow2(JSONObject jSONObject, String str) {
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
