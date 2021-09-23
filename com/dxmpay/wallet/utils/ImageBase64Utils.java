package com.dxmpay.wallet.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.imagemanager.ImageProcessor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes9.dex */
public class ImageBase64Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static int JPEG_QUALITY = 70;
    public static final String TAG = "ImageBase64Utils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.dxmpay.wallet.utils.ImageBase64Utils$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mFixedWidth;
        public String mImagePath;
        public Uri mImageUri;
        public ImageBase64Listener mListener;
        public ParcelFileDescriptor mParcelFileDescriptor;
        public boolean mPrecise;
        public int mQuality;
        public final /* synthetic */ ImageBase64Utils this$0;

        public ImageBase64AsyncTask(ImageBase64Utils imageBase64Utils, ImageBase64Listener imageBase64Listener, String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageBase64Utils, imageBase64Listener, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = imageBase64Utils;
            this.mPrecise = false;
            this.mListener = imageBase64Listener;
            this.mImagePath = str;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mParcelFileDescriptor = initFileDescriptorFromPath();
        }

        private ParcelFileDescriptor initFileDescriptonFromUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                Context context = this.mContext;
                if (context != null && this.mImageUri != null) {
                    try {
                        return context.getContentResolver().openFileDescriptor(this.mImageUri, r.f42342a);
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
            return (ParcelFileDescriptor) invokeV.objValue;
        }

        private ParcelFileDescriptor initFileDescriptorFromPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (!TextUtils.isEmpty(this.mImagePath)) {
                    try {
                        return ParcelFileDescriptor.open(new File(this.mImagePath), 268435456);
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
            return (ParcelFileDescriptor) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                int i2 = this.mFixedWidth;
                return i2 <= 0 ? ImageBase64Utils.getOriginImageBase64(this.mParcelFileDescriptor, this.mQuality) : ImageBase64Utils.getImageBase64(this.mParcelFileDescriptor, i2, this.mQuality);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((ImageBase64AsyncTask) str);
                ImageBase64Listener imageBase64Listener = this.mListener;
                if (imageBase64Listener != null) {
                    imageBase64Listener.onBase64Result(str);
                }
            }
        }

        public ImageBase64AsyncTask(ImageBase64Utils imageBase64Utils, ImageBase64Listener imageBase64Listener, Context context, Uri uri, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageBase64Utils, imageBase64Listener, context, uri, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imageBase64Utils;
            this.mPrecise = false;
            this.mListener = imageBase64Listener;
            this.mImageUri = uri;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mContext = context;
            this.mParcelFileDescriptor = initFileDescriptonFromUri();
        }
    }

    /* loaded from: classes9.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    /* loaded from: classes9.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static ImageBase64Utils sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1872776147, "Lcom/dxmpay/wallet/utils/ImageBase64Utils$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1872776147, "Lcom/dxmpay/wallet/utils/ImageBase64Utils$SingletonHolder;");
                    return;
                }
            }
            sInstance = new ImageBase64Utils(null);
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(915820614, "Lcom/dxmpay/wallet/utils/ImageBase64Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(915820614, "Lcom/dxmpay/wallet/utils/ImageBase64Utils;");
        }
    }

    public /* synthetic */ ImageBase64Utils(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static ImageBase64Utils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? SingletonHolder.sInstance : (ImageBase64Utils) invokeV.objValue;
    }

    public static String getOriginImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, parcelFileDescriptor, i2)) == null) {
            if (parcelFileDescriptor != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    if (decodeFileDescriptor != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String str = "compress size:\t" + byteArray.length + "\t\twidth" + decodeFileDescriptor.getWidth();
                        decodeFileDescriptor.recycle();
                        byteArrayOutputStream.close();
                        String str2 = "base64 size:\t" + (byteArray.length / 1024);
                        String str3 = new String(Base64.encode(byteArray, 0, byteArray.length, 2));
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return str3;
                    }
                    parcelFileDescriptor.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public void getImageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, imageBase64Listener) == null) {
            new ImageBase64AsyncTask(this, imageBase64Listener, str, i2, JPEG_QUALITY).execute("");
        }
    }

    public ImageBase64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void getImageBase64(Context context, Uri uri, int i2, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uri, i2, imageBase64Listener) == null) {
            new ImageBase64AsyncTask(this, imageBase64Listener, context, uri, i2, JPEG_QUALITY).execute("");
        }
    }

    public void getImageBase64(String str, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), imageBase64Listener}) == null) {
            new ImageBase64AsyncTask(this, imageBase64Listener, str, i2, i3).execute("");
        }
    }

    public void getImageBase64(Context context, Uri uri, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), imageBase64Listener}) == null) {
            new ImageBase64AsyncTask(this, imageBase64Listener, context, uri, i2, i3).execute("");
        }
    }

    public static String getImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, parcelFileDescriptor, i2, i3)) == null) {
            if (parcelFileDescriptor != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    int a2 = ImageProcessor.a(options, i2, -1);
                    options.inSampleSize = a2;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    if (decodeFileDescriptor != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String str = "compress size:\t" + byteArray.length + "\tsampleSize" + a2 + "\twidth" + decodeFileDescriptor.getWidth();
                        decodeFileDescriptor.recycle();
                        byteArrayOutputStream.close();
                        String str2 = "base64 size:\t" + (byteArray.length / 1024);
                        String str3 = new String(Base64.encode(byteArray, 0, byteArray.length, 2));
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return str3;
                    }
                    parcelFileDescriptor.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLII.objValue;
    }
}
