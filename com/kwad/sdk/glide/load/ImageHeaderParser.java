package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public interface ImageHeaderParser {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ImageType {
        public static final /* synthetic */ ImageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImageType GIF;
        public static final ImageType JPEG;
        public static final ImageType PNG;
        public static final ImageType PNG_A;
        public static final ImageType RAW;
        public static final ImageType UNKNOWN;
        public static final ImageType WEBP;
        public static final ImageType WEBP_A;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean hasAlpha;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1120925689, "Lcom/kwad/sdk/glide/load/ImageHeaderParser$ImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1120925689, "Lcom/kwad/sdk/glide/load/ImageHeaderParser$ImageType;");
                    return;
                }
            }
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            RAW = new ImageType("RAW", 2, false);
            PNG_A = new ImageType("PNG_A", 3, true);
            PNG = new ImageType("PNG", 4, false);
            WEBP_A = new ImageType("WEBP_A", 5, true);
            WEBP = new ImageType("WEBP", 6, false);
            ImageType imageType = new ImageType(RomUtils.UNKNOWN, 7, false);
            UNKNOWN = imageType;
            $VALUES = new ImageType[]{GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, imageType};
        }

        public ImageType(String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.hasAlpha = z;
        }

        public static ImageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImageType) Enum.valueOf(ImageType.class, str) : (ImageType) invokeL.objValue;
        }

        public static ImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImageType[]) $VALUES.clone() : (ImageType[]) invokeV.objValue;
        }

        public boolean hasAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hasAlpha : invokeV.booleanValue;
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar);

    @NonNull
    ImageType a(@NonNull InputStream inputStream);

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer);
}
