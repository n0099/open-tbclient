package d.l.a.a.a.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f71588a;

    /* renamed from: b  reason: collision with root package name */
    public int f71589b;

    /* renamed from: c  reason: collision with root package name */
    public long f71590c;

    /* renamed from: d  reason: collision with root package name */
    public long f71591d;

    /* renamed from: e  reason: collision with root package name */
    public String f71592e;

    public e() {
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
        this.f71588a = -1L;
        this.f71589b = -1;
        this.f71590c = -1L;
        this.f71591d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f71588a = downloadInfo.getId();
        this.f71589b = downloadInfo.getStatus();
        this.f71591d = downloadInfo.getCurBytes();
        this.f71590c = downloadInfo.getTotalBytes();
        this.f71592e = downloadInfo.getTargetFilePath();
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            failedException.getErrorCode();
        }
        downloadInfo.isOnlyWifi();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if ((obj instanceof e) && obj != null) {
                e eVar = (e) obj;
                return ((this.f71588a > eVar.f71588a ? 1 : (this.f71588a == eVar.f71588a ? 0 : -1)) == 0) && (this.f71589b == eVar.f71589b) && ((this.f71590c > eVar.f71590c ? 1 : (this.f71590c == eVar.f71590c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f71592e) && TextUtils.isEmpty(eVar.f71592e)) || (!TextUtils.isEmpty(this.f71592e) && !TextUtils.isEmpty(eVar.f71592e) && this.f71592e.equals(eVar.f71592e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f71588a), Integer.valueOf(this.f71589b), Long.valueOf(this.f71590c), this.f71592e}) : invokeV.intValue;
    }
}
