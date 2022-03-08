package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public final class DefaultDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_ASSET = "asset";
    public static final String SCHEME_CONTENT = "content";
    public static final String SCHEME_RTMP = "rtmp";
    public static final String TAG = "DefaultDataSource";
    public transient /* synthetic */ FieldHolder $fh;
    public DataSource assetDataSource;
    public final DataSource baseDataSource;
    public DataSource contentDataSource;
    public final Context context;
    public DataSource dataSchemeDataSource;
    public DataSource dataSource;
    public DataSource fileDataSource;
    public final TransferListener<? super DataSource> listener;
    public DataSource rtmpDataSource;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, String str, boolean z) {
        this(context, transferListener, str, 8000, 8000, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transferListener, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (TransferListener) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private DataSource getAssetDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.assetDataSource == null) {
                this.assetDataSource = new AssetDataSource(this.context, this.listener);
            }
            return this.assetDataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    private DataSource getContentDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.contentDataSource == null) {
                this.contentDataSource = new ContentDataSource(this.context, this.listener);
            }
            return this.contentDataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    private DataSource getDataSchemeDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.dataSchemeDataSource == null) {
                this.dataSchemeDataSource = new DataSchemeDataSource();
            }
            return this.dataSchemeDataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    private DataSource getFileDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.fileDataSource == null) {
                this.fileDataSource = new FileDataSource(this.listener);
            }
            return this.fileDataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    private DataSource getRtmpDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.rtmpDataSource == null) {
                try {
                    this.rtmpDataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.rtmpDataSource == null) {
                    this.rtmpDataSource = this.baseDataSource;
                }
            }
            return this.rtmpDataSource;
        }
        return (DataSource) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        DataSource dataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dataSource = this.dataSource) == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.dataSource = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DataSource dataSource = this.dataSource;
            if (dataSource == null) {
                return null;
            }
            return dataSource.getUri();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            Assertions.checkState(this.dataSource == null);
            String scheme = dataSpec.uri.getScheme();
            if (Util.isLocalFileUri(dataSpec.uri)) {
                if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                    this.dataSource = getAssetDataSource();
                } else {
                    this.dataSource = getFileDataSource();
                }
            } else if ("asset".equals(scheme)) {
                this.dataSource = getAssetDataSource();
            } else if ("content".equals(scheme)) {
                this.dataSource = getContentDataSource();
            } else if (SCHEME_RTMP.equals(scheme)) {
                this.dataSource = getRtmpDataSource();
            } else if ("data".equals(scheme)) {
                this.dataSource = getDataSchemeDataSource();
            } else {
                this.dataSource = this.baseDataSource;
            }
            return this.dataSource.open(dataSpec);
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) ? this.dataSource.read(bArr, i2, i3) : invokeLII.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, String str, int i2, int i3, boolean z) {
        this(context, transferListener, new DefaultHttpDataSource(str, null, transferListener, i2, i3, z, null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transferListener, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (TransferListener) objArr2[1], (DataSource) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transferListener, dataSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource);
    }
}
