package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean b(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
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
            f.b("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return i6 > i3 || i4 > i2;
        }
        return invokeLII.booleanValue;
    }

    public static final void a(Context context, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, context, str, cVar) == null) {
            f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
            if (TextUtils.isEmpty(str)) {
                cVar.a(1, (String) null);
            } else if (!j.b()) {
                cVar.a(2, (String) null);
            } else {
                new Thread(new Runnable(str, new Handler(context.getMainLooper(), cVar) { // from class: com.tencent.connect.share.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f41812a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, cVar};
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
                        this.f41812a = cVar;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            int i2 = message.what;
                            if (i2 == 101) {
                                this.f41812a.a(0, (String) message.obj);
                            } else if (i2 != 102) {
                                super.handleMessage(message);
                            } else {
                                this.f41812a.a(message.arg1, (String) null);
                            }
                        }
                    }
                }) { // from class: com.tencent.connect.share.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f41813a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Handler f41814b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41813a = str;
                        this.f41814b = r7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String a2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Bitmap a3 = a.a(this.f41813a, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE);
                            if (a3 != null) {
                                String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                                String str3 = "share2qq_temp" + j.f(this.f41813a) + ".jpg";
                                if (!a.b(this.f41813a, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE)) {
                                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                                    a2 = this.f41813a;
                                } else {
                                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                                    a2 = a.a(a3, str2, str3);
                                }
                                f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + a2);
                                if (a2 != null) {
                                    Message obtainMessage = this.f41814b.obtainMessage(101);
                                    obtainMessage.obj = a2;
                                    this.f41814b.sendMessage(obtainMessage);
                                    return;
                                }
                            }
                            Message obtainMessage2 = this.f41814b.obtainMessage(102);
                            obtainMessage2.arg1 = 3;
                            this.f41814b.sendMessage(obtainMessage2);
                        }
                    }
                }).start();
            }
        }
    }

    public static final void a(Context context, ArrayList<String> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, arrayList, cVar) == null) {
            f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
            if (arrayList == null) {
                cVar.a(1, (String) null);
            } else {
                new Thread(new Runnable(arrayList, new Handler(context.getMainLooper(), cVar) { // from class: com.tencent.connect.share.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f41815a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, cVar};
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
                        this.f41815a = cVar;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            if (message.what != 101) {
                                super.handleMessage(message);
                                return;
                            }
                            this.f41815a.a(0, message.getData().getStringArrayList("images"));
                        }
                    }
                }) { // from class: com.tencent.connect.share.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ArrayList f41816a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Handler f41817b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {arrayList, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f41816a = arrayList;
                        this.f41817b = r7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap a2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (int i2 = 0; i2 < this.f41816a.size(); i2++) {
                                String str = (String) this.f41816a.get(i2);
                                if (!j.g(str) && j.h(str) && (a2 = a.a(str, 10000)) != null) {
                                    String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                                    String str3 = "share2qzone_temp" + j.f(str) + ".jpg";
                                    if (!a.b(str, 640, 10000)) {
                                        f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                                    } else {
                                        f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                                        str = a.a(a2, str2, str3);
                                    }
                                    if (str != null) {
                                        this.f41816a.set(i2, str);
                                    }
                                }
                            }
                            Message obtainMessage = this.f41817b.obtainMessage(101);
                            Bundle bundle = new Bundle();
                            bundle.putStringArrayList("images", this.f41816a);
                            obtainMessage.setData(bundle);
                            this.f41817b.sendMessage(obtainMessage);
                        }
                    }
                }).start();
            }
        }
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, options, i2, i3)) == null) {
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
                e2.printStackTrace();
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
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
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
