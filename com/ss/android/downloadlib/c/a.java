package com.ss.android.downloadlib.c;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes2.dex */
public class a implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    private boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, downloadInfo)) == null) {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            File file = new File(str);
            String a2 = com.ss.android.socialbase.appdownloader.f.a.e.a(j.getContext(), com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file), str);
            boolean z = false;
            if (!TextUtils.isEmpty(a2)) {
                String str2 = a2 + ".apk";
                if (str2.equals(downloadInfo.getName())) {
                    return true;
                }
                try {
                    z = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                    if (z) {
                        downloadInfo.setName(str2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) throws BaseException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) && downloadInfo != null && c(downloadInfo)) {
            a(j.getContext(), downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
            if (downloadInfo != null) {
                return com.ss.android.downloadlib.g.e.b(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(Context context, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, downloadInfo) == null) {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
            if (query != null && query.moveToFirst()) {
                downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), query.getInt(query.getColumnIndex("_id"))).toString());
            } else {
                MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener(this, downloadInfo) { // from class: com.ss.android.downloadlib.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DownloadInfo f68737a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f68738b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, downloadInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68738b = this;
                        this.f68737a = downloadInfo;
                    }

                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public void onScanCompleted(String str2, Uri uri) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str2, uri) == null) || uri == null) {
                            return;
                        }
                        this.f68737a.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.c.x().a(this.f68737a);
                    }
                });
            }
            com.ss.android.socialbase.downloader.i.f.a(query);
        }
    }
}
