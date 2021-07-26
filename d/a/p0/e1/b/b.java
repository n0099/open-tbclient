package d.a.p0.e1.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f52525a;

    /* renamed from: b  reason: collision with root package name */
    public String f52526b;

    /* renamed from: c  reason: collision with root package name */
    public String f52527c;

    public b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52526b = str;
        this.f52527c = str2;
        this.f52525a = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && b(this.f52526b, this.f52527c)) {
            String str = this.f52526b + '_' + this.f52527c + "_youngster_tip_times";
            String str2 = this.f52526b + '_' + this.f52527c + "_youngster_tip_time";
            int i2 = this.f52525a.getInt(str, 0);
            SharedPreferences.Editor edit = this.f52525a.edit();
            int i3 = i2 + 1;
            if (i3 <= 10) {
                i2 = i3;
            }
            edit.putInt(str, i2);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true : invokeLL.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (b(this.f52526b, this.f52527c)) {
                return this.f52525a.getLong(this.f52526b + '_' + this.f52527c + "_youngster_tip_time", 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (b(this.f52526b, this.f52527c)) {
                return this.f52525a.getInt(this.f52526b + '_' + this.f52527c + "_youngster_tip_times", 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
