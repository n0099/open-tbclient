package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d86 extends c86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d86(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = z;
    }

    public static int h(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 > i2 || i4 > i) {
                int round = Math.round(i3 / i2);
                int round2 = Math.round(i4 / i);
                if (round >= round2) {
                    round = round2;
                }
                if (round >= 3) {
                    if (round < 6.5d) {
                        return 4;
                    }
                    if (round < 8) {
                        return 8;
                    }
                }
                return round;
            }
            return 1;
        }
        return invokeLII.intValue;
    }

    public static Bitmap i(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = h(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeLII.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:39:0x005f). Please submit an issue!!! */
    @Override // com.repackage.c86
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i86 i86Var = this.a;
            if (i86Var.e) {
                this.b.onError(i86Var.f, "is cartoon style !!");
                return;
            }
            MultiMediaData multiMediaData = i86Var.c;
            if (multiMediaData != null && !TextUtils.isEmpty(multiMediaData.path)) {
                String str = multiMediaData.path;
                if (multiMediaData.type == 1) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(multiMediaData.start * 1000);
                            if (this.a.d != 0.0f) {
                                g(new h86(), c(frameAtTime, this.a.d, multiMediaData));
                            } else {
                                g(new h86(), frameAtTime);
                            }
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (Exception unused) {
                        }
                        return;
                    } finally {
                        mediaMetadataRetriever.release();
                    }
                }
                Bitmap k = k(str);
                if (k != null) {
                    g(new h86(), k);
                    return;
                }
                return;
            }
            this.b.onError(this.a.f, "multiMediaData is null !!");
        }
    }

    public final int j(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException unused) {
                exifInterface = null;
            }
            if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) != -1) {
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return 270;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public Bitmap k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            i86 i86Var = this.a;
            Bitmap i = i(str, i86Var.a, i86Var.b);
            if (i == null) {
                return null;
            }
            int j = j(str);
            Matrix matrix = new Matrix();
            matrix.setRotate(j);
            return Bitmap.createBitmap(i, 0, 0, i.getWidth(), i.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }
}
