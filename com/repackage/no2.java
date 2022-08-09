package com.repackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class no2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to2 a;
        public final /* synthetic */ File b;

        public a(to2 to2Var, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to2Var, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to2Var;
            this.b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            to2 to2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                if (i != -1 || (to2Var = this.a) == null) {
                    return true;
                }
                to2Var.a(this.b);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to2 a;
        public final /* synthetic */ File b;

        public b(to2 to2Var, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to2Var, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to2Var;
            this.b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            to2 to2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                if (i != -1 || (to2Var = this.a) == null) {
                    return true;
                }
                to2Var.a(this.b);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755462848, "Lcom/repackage/no2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755462848, "Lcom/repackage/no2;");
                return;
            }
        }
        a = jh1.a;
    }

    public static File a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String x = h83.x(str);
            File file = new File(x + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg");
            bh4.h(file);
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String x = h83.x(str);
            File file = new File(x + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
            bh4.h(file);
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static VideoModel c(File file) {
        InterceptResult invokeL;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            String absolutePath = file.getAbsolutePath();
            VideoModel videoModel = new VideoModel(absolutePath);
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                mediaMetadataRetriever.setDataSource(absolutePath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                videoModel.setWidth(Integer.parseInt(extractMetadata));
                videoModel.setHeight(Integer.parseInt(extractMetadata2));
                videoModel.setDuration(Long.parseLong(extractMetadata3));
                videoModel.setSize(file.length());
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (oo2.a) {
                    e.printStackTrace();
                }
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                return videoModel;
            } catch (Throwable th2) {
                th = th2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                throw th;
            }
            return videoModel;
        }
        return (VideoModel) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (1 == cameraInfo.facing) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
    public static void e(Activity activity, String str, int i, boolean z, to2 to2Var) {
        ActivityResultDispatcher resultDispatcher;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{activity, str, Integer.valueOf(i), Boolean.valueOf(z), to2Var}) == null) || (resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher()) == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        File b2 = b(str);
        if (gd3.i()) {
            fromFile = we3.a(activity, b2);
            intent.setFlags(3);
        } else {
            fromFile = Uri.fromFile(b2);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.durationLimit", i);
        ?? r6 = 1;
        intent.putExtra("android.intent.extra.videoQuality", 1);
        r6 = (z && d()) ? 0 : 0;
        if (gd3.g()) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r6);
            intent.putExtra("android.intent.extras.LENS_FACING_FRONT", (int) r6);
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", (boolean) r6);
        } else {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r6);
        }
        resultDispatcher.addConsumer(new b(to2Var, b2));
        try {
            resultDispatcher.startActivityForResult(intent);
        } catch (ActivityNotFoundException e) {
            if (a) {
                Log.e("SwanAppAlbumCameraHelper", "startRecordActivity: ", e);
            }
        }
    }

    public static void f(Activity activity, String str, to2 to2Var) {
        ActivityResultDispatcher resultDispatcher;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, activity, str, to2Var) == null) || (resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher()) == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            File a2 = a(str);
            if (a2 == null || !a2.exists()) {
                if (to2Var != null) {
                    to2Var.b("error create file");
                    return;
                }
                return;
            }
            if (gd3.i()) {
                fromFile = we3.a(activity, a2);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(a2);
            }
            intent.putExtra("output", fromFile);
            resultDispatcher.addConsumer(new a(to2Var, a2));
            try {
                resultDispatcher.startActivityForResult(intent);
            } catch (ActivityNotFoundException e) {
                if (a) {
                    Log.e("SwanAppAlbumCameraHelper", "startTakePhotoActivity: ", e);
                }
            }
        }
    }
}
