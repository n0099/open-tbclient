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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f74082a;

    /* renamed from: b  reason: collision with root package name */
    public int f74083b;

    /* renamed from: c  reason: collision with root package name */
    public long f74084c;

    /* renamed from: d  reason: collision with root package name */
    public long f74085d;

    /* renamed from: e  reason: collision with root package name */
    public String f74086e;

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
        this.f74082a = -1L;
        this.f74083b = -1;
        this.f74084c = -1L;
        this.f74085d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f74082a = downloadInfo.getId();
        this.f74083b = downloadInfo.getStatus();
        this.f74085d = downloadInfo.getCurBytes();
        this.f74084c = downloadInfo.getTotalBytes();
        this.f74086e = downloadInfo.getTargetFilePath();
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
                return ((this.f74082a > eVar.f74082a ? 1 : (this.f74082a == eVar.f74082a ? 0 : -1)) == 0) && (this.f74083b == eVar.f74083b) && ((this.f74084c > eVar.f74084c ? 1 : (this.f74084c == eVar.f74084c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f74086e) && TextUtils.isEmpty(eVar.f74086e)) || (!TextUtils.isEmpty(this.f74086e) && !TextUtils.isEmpty(eVar.f74086e) && this.f74086e.equals(eVar.f74086e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f74082a), Integer.valueOf(this.f74083b), Long.valueOf(this.f74084c), this.f74086e}) : invokeV.intValue;
    }
}
