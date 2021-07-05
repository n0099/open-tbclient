package com.kwai.video.hodor;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class HlsPreloadPriorityTask extends AbstractHodorPreloadTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public String mCacheKey;
    public String mHeaders;
    public String mManifestJson;
    public int mPreferBandwidth;
    public long mPreloadBytes;

    public HlsPreloadPriorityTask(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i2;
        this.mHeaders = "";
        this.mAwesomeCacheCallback = null;
    }

    public HlsPreloadPriorityTask(String str, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i2;
        this.mHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mAwesomeCacheCallback = null;
    }

    private native void _cancel();

    private native void _submit(String str, int i2, long j, String str2, AwesomeCacheCallback awesomeCacheCallback);

    public native void _pause();

    public native void _resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            _cancel();
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            _pause();
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            _resume();
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(@NonNull AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, awesomeCacheCallback) == null) {
            this.mAwesomeCacheCallback = awesomeCacheCallback;
        }
    }

    public void setPreloadBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mPreloadBytes = j;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            _submit(this.mManifestJson, this.mPreferBandwidth, this.mPreloadBytes, this.mHeaders, this.mAwesomeCacheCallback);
        }
    }
}
