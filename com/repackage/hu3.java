package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hu3 extends t92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu3(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static t92 t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? new hu3("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2) : (t92) invokeLL.objValue;
    }

    public static t92 u(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            return new hu3("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
        }
        return (t92) invokeZ.objValue;
    }

    public static t92 v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? new hu3("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2) : (t92) invokeLL.objValue;
    }

    @Override // com.repackage.s92
    public String o(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.d;
            int hashCode = str2.hashCode();
            if (hashCode == -2011830027) {
                if (str2.equals("%s.message = { type:'act',act:'%s' };")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode != -774049378) {
                if (hashCode == 2080164540 && str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s] };")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                return c != 1 ? c != 2 ? "" : String.format("%s.message = { type:'act',act:'%s' };", str, this.f) : String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.e, JSONObject.quote(this.f));
            }
            return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.e, JSONObject.quote(gc3.b(gc3.a(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.f));
        }
        return (String) invokeL.objValue;
    }
}
