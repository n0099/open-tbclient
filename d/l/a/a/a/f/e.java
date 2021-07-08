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
    public long f71134a;

    /* renamed from: b  reason: collision with root package name */
    public int f71135b;

    /* renamed from: c  reason: collision with root package name */
    public long f71136c;

    /* renamed from: d  reason: collision with root package name */
    public long f71137d;

    /* renamed from: e  reason: collision with root package name */
    public String f71138e;

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
        this.f71134a = -1L;
        this.f71135b = -1;
        this.f71136c = -1L;
        this.f71137d = -1L;
    }

    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f71134a = downloadInfo.getId();
        this.f71135b = downloadInfo.getStatus();
        this.f71137d = downloadInfo.getCurBytes();
        this.f71136c = downloadInfo.getTotalBytes();
        this.f71138e = downloadInfo.getTargetFilePath();
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
                return ((this.f71134a > eVar.f71134a ? 1 : (this.f71134a == eVar.f71134a ? 0 : -1)) == 0) && (this.f71135b == eVar.f71135b) && ((this.f71136c > eVar.f71136c ? 1 : (this.f71136c == eVar.f71136c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f71138e) && TextUtils.isEmpty(eVar.f71138e)) || (!TextUtils.isEmpty(this.f71138e) && !TextUtils.isEmpty(eVar.f71138e) && this.f71138e.equals(eVar.f71138e)));
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Arrays.hashCode(new Object[]{Long.valueOf(this.f71134a), Integer.valueOf(this.f71135b), Long.valueOf(this.f71136c), this.f71138e}) : invokeV.intValue;
    }
}
