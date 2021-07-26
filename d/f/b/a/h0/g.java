package d.f.b.a.h0;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f70837a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f70838b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70839c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70840d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70841e;

    /* renamed from: f  reason: collision with root package name */
    public final String f70842f;

    /* renamed from: g  reason: collision with root package name */
    public final int f70843g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, int i2) {
        this(uri, 0L, -1L, null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), (String) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (this.f70843g & i2) == i2 : invokeI.booleanValue;
    }

    public g b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long j2 = this.f70841e;
            return c(j, j2 != -1 ? j2 - j : -1L);
        }
        return (g) invokeJ.objValue;
    }

    public g c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? (j == 0 && this.f70841e == j2) ? this : new g(this.f70837a, this.f70838b, this.f70839c + j, this.f70840d + j, j2, this.f70842f, this.f70843g) : (g) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "DataSpec[" + this.f70837a + StringUtil.ARRAY_ELEMENT_SEPARATOR + Arrays.toString(this.f70838b) + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f70839c + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f70840d + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f70841e + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f70842f + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f70843g + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Long.valueOf(j), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j, long j2, String str, int i2) {
        this(uri, j, j, j2, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4], ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Uri uri, long j, long j2, long j3, String str, int i2) {
        this(uri, null, j, j2, j3, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {uri, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (byte[]) objArr2[1], ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, bArr, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        boolean z = true;
        d.f.b.a.i0.a.a(j >= 0);
        d.f.b.a.i0.a.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        d.f.b.a.i0.a.a(z);
        this.f70837a = uri;
        this.f70838b = bArr;
        this.f70839c = j;
        this.f70840d = j2;
        this.f70841e = j3;
        this.f70842f = str;
        this.f70843g = i2;
    }
}
