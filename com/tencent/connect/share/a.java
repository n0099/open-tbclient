package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean b(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i2, i3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e2);
            }
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            if (options.mCancel || i4 == -1 || i5 == -1) {
                return false;
            }
            int i6 = i4 > i5 ? i4 : i5;
            if (i4 >= i5) {
                i4 = i5;
            }
            SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return i6 > i3 || i4 > i2;
        }
        return invokeLII.booleanValue;
    }

    public static final void a(Context context, String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, dVar) == null) {
            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
            if (TextUtils.isEmpty(str)) {
                dVar.a(1, (String) null);
            } else if (!l.a()) {
                dVar.a(2, (String) null);
            } else {
                new Thread(new Runnable(str, new Handler(context.getMainLooper(), dVar) { // from class: com.tencent.connect.share.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, dVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = dVar;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            int i2 = message.what;
                            if (i2 == 101) {
                                this.a.a(0, (ArrayList) message.obj);
                            } else if (i2 != 102) {
                                super.handleMessage(message);
                            } else {
                                this.a.a(message.arg1, (String) null);
                            }
                        }
                    }
                }, context) { // from class: com.tencent.connect.share.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Handler f62823b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f62824c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, r7, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = str;
                        this.f62823b = r7;
                        this.f62824c = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        File a;
                        String str2;
                        String str3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                Bitmap a2 = a.a(this.a, 840);
                                if (a2 != null) {
                                    String str4 = null;
                                    if (f.a("Images") != null) {
                                        str3 = a.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR + File.separator;
                                        str2 = null;
                                    } else {
                                        File d2 = f.d();
                                        if (d2 == null) {
                                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                            Message obtainMessage = this.f62823b.obtainMessage();
                                            obtainMessage.arg1 = 102;
                                            this.f62823b.sendMessage(obtainMessage);
                                            return;
                                        }
                                        String absolutePath = d2.getAbsolutePath();
                                        String str5 = absolutePath + File.separator + Constants.QQ_SHARE_TEMP_DIR + File.separator;
                                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + str5);
                                        str2 = absolutePath;
                                        str3 = str5;
                                    }
                                    String str6 = "share2qq_temp" + l.f(this.a) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                                    String str7 = this.a;
                                    if (!a.b(this.a, 840, 840)) {
                                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                                    } else {
                                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                        String a3 = a.a(a2, str3, str6);
                                        if (!TextUtils.isEmpty(a3)) {
                                            str7 = a3;
                                        }
                                    }
                                    boolean n = l.n(str7);
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + n);
                                    ArrayList arrayList = new ArrayList(2);
                                    if (n) {
                                        str4 = str7;
                                    } else if (TextUtils.isEmpty(str2)) {
                                        String str8 = str3 + str6;
                                        boolean a4 = l.a(this.f62824c, str7, str8);
                                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + a4);
                                        if (a4) {
                                            str4 = str8;
                                        }
                                    }
                                    arrayList.add(str7);
                                    arrayList.add(str4);
                                    if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + PreferencesUtil.RIGHT_MOUNT);
                                        Message obtainMessage2 = this.f62823b.obtainMessage(101);
                                        obtainMessage2.obj = arrayList;
                                        this.f62823b.sendMessage(obtainMessage2);
                                        return;
                                    }
                                }
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e2);
                            }
                            SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                            Message obtainMessage3 = this.f62823b.obtainMessage(102);
                            obtainMessage3.arg1 = 3;
                            this.f62823b.sendMessage(obtainMessage3);
                        }
                    }
                }).start();
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bitmap, i2)) == null) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= height) {
                width = height;
            }
            float f2 = i2 / width;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, options, i2, i3)) == null) {
            double d2 = options.outWidth;
            double d3 = options.outHeight;
            int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
            if (i2 == -1) {
                min = 128;
            } else {
                double d4 = i2;
                min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
            }
            if (min < ceil) {
                return ceil;
            }
            if (i3 == -1 && i2 == -1) {
                return 1;
            }
            return i2 == -1 ? ceil : min;
        }
        return invokeLII.intValue;
    }

    public static final String a(Bitmap bitmap, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bitmap, str, str2)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuffer stringBuffer = new StringBuffer(str);
            stringBuffer.append(str2);
            String stringBuffer2 = stringBuffer.toString();
            File file2 = new File(stringBuffer2);
            if (file2.exists()) {
                file2.delete();
            }
            if (bitmap != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bitmap.recycle();
                    return stringBuffer2;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap a(String str, int i2) {
        InterceptResult invokeLI;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e2);
            }
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (options.mCancel || i3 == -1 || i4 == -1) {
                return null;
            }
            if (i3 <= i4) {
                i3 = i4;
            }
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            if (i3 > i2) {
                options.inSampleSize = a(options, -1, i2 * i2);
            }
            options.inJustDecodeBounds = false;
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (Exception e3) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e3);
                bitmap = null;
                if (bitmap == null) {
                }
            } catch (OutOfMemoryError e4) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e4);
                bitmap = null;
                if (bitmap == null) {
                }
            }
            if (bitmap == null) {
                SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
                return null;
            }
            int i5 = options.outWidth;
            int i6 = options.outHeight;
            if (i5 <= i6) {
                i5 = i6;
            }
            return i5 > i2 ? a(bitmap, i2) : bitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static final int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, options, i2, i3)) == null) {
            int b2 = b(options, i2, i3);
            if (b2 <= 8) {
                int i4 = 1;
                while (i4 < b2) {
                    i4 <<= 1;
                }
                return i4;
            }
            return ((b2 + 7) / 8) * 8;
        }
        return invokeLII.intValue;
    }
}
