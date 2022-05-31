package com.repackage;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.IOException;
/* loaded from: classes5.dex */
public class f49 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int g = 2;
    public static int h = 4;
    public static int i = 8;
    public static int j = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public long e;
    public String f;

    /* loaded from: classes5.dex */
    public class a implements z49 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ f49 b;

        public a(f49 f49Var, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f49Var, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f49Var;
            this.a = zArr;
        }

        @Override // com.repackage.z49
        public void a(MediaFormat mediaFormat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaFormat) == null) {
                this.a[0] = true;
                this.b.l(mediaFormat);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755757658, "Lcom/repackage/f49;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755757658, "Lcom/repackage/f49;");
        }
    }

    public f49(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        j(str);
    }

    public static f49 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            f49 f49Var = new f49("");
            f49Var.c = 2;
            f49Var.f = "audio/mp4a-latm";
            f49Var.b = 44100;
            f49Var.d = 16;
            return f49Var;
        }
        return (f49) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e / 1000 : invokeV.longValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof f49) && k((f49) obj) == 0 : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.d + this.b + this.c;
            String str = this.f;
            return i2 + (str != null ? str.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f) || this.b == 0 || this.c == 0 || this.d == 0 || this.e == 0) ? false : true : invokeV.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (m(str)) {
                    boolean[] zArr = {false};
                    y49 y49Var = new y49(str);
                    y49Var.k(new a(this, zArr));
                    while (!zArr[0]) {
                        if (y49Var.c()) {
                            zArr[0] = true;
                        }
                    }
                    y49Var.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int k(f49 f49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, f49Var)) == null) {
            if (f49Var == null) {
                return 0;
            }
            int i2 = f49Var.d != this.d ? 0 | g : 0;
            if (f49Var.b != this.b) {
                i2 |= h;
            }
            if (f49Var.c != this.c) {
                i2 |= i;
            }
            return !TextUtils.equals(f49Var.f, this.f) ? i2 | j : i2;
        }
        return invokeL.intValue;
    }

    public final boolean l(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mediaFormat)) == null) {
            try {
                this.b = mediaFormat.getInteger("sample-rate");
                this.c = mediaFormat.getInteger("channel-count");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            boolean z = false;
            if (FileUtils.isExists(str)) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(str);
                    MediaFormat mediaFormat = null;
                    for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                        if (trackFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor.selectTrack(i2);
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    try {
                        if (mediaFormat == null) {
                            return false;
                        }
                        this.f = mediaFormat.getString("mime");
                        this.b = mediaFormat.getInteger("sample-rate");
                        this.c = mediaFormat.getInteger("channel-count");
                        this.e = mediaFormat.getLong("durationUs");
                        if (mediaFormat.containsKey("bit-width")) {
                            this.d = mediaFormat.getInteger("bit-width");
                        } else {
                            this.d = 16;
                        }
                        if (mediaFormat.containsKey("aac-profile")) {
                            if (mediaFormat.getInteger("aac-profile") != 2) {
                                z = true;
                            }
                        }
                        return z;
                    } catch (Exception e) {
                        p79.e("VideoMuxer", "initAudioProperty error:" + e.getMessage());
                        return false;
                    } finally {
                        mediaExtractor.release();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
