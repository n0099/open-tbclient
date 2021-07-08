package d.a.y.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.media.extractor.DuMediaExtractor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes8.dex */
public class a extends ExtractorProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DuMediaExtractor f68482a;

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
        try {
            this.f68482a = new DuMediaExtractor();
            b();
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    public static ExtractorProvider a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (CyberPlayerManager.isCoreLoaded(CyberPlayerManager.getInstallType())) {
                return new a();
            }
            return null;
        }
        return (ExtractorProvider) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOption(1, CyberExtractor.OPT_KEY_PREPARE_TIME_OUT, 5000L);
            setOption(1, "proxytcp-enable", 0L);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DuMediaExtractor duMediaExtractor = this.f68482a;
            if (duMediaExtractor != null) {
                try {
                    return duMediaExtractor.h();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        DuMediaExtractor duMediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (duMediaExtractor = this.f68482a) == null) {
            return;
        }
        try {
            try {
                duMediaExtractor.b();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.f68482a = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        DuMediaExtractor duMediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, uri) == null) || (duMediaExtractor = this.f68482a) == null) {
            return;
        }
        try {
            duMediaExtractor.e(context, uri, null);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        DuMediaExtractor duMediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, context, uri, map) == null) || (duMediaExtractor = this.f68482a) == null) {
            return;
        }
        try {
            duMediaExtractor.e(context, uri, map);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fileDescriptor) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        DuMediaExtractor duMediaExtractor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (duMediaExtractor = this.f68482a) == null) {
            return;
        }
        try {
            duMediaExtractor.f(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            CyberLog.i("CyberExtractorImpl", "setOption: " + str + "," + j);
            DuMediaExtractor duMediaExtractor = this.f68482a;
            if (duMediaExtractor != null) {
                try {
                    duMediaExtractor.c(i2, str, j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
