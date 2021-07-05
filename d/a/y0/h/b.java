package d.a.y0.h;

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
import com.kwai.video.player.misc.IMediaFormat;
import d.a.y0.i.i;
import d.a.y0.i.j;
import java.io.IOException;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f71036g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static int f71037h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static int f71038i = 8;
    public static int j = 16;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71039a;

    /* renamed from: b  reason: collision with root package name */
    public int f71040b;

    /* renamed from: c  reason: collision with root package name */
    public int f71041c;

    /* renamed from: d  reason: collision with root package name */
    public int f71042d;

    /* renamed from: e  reason: collision with root package name */
    public long f71043e;

    /* renamed from: f  reason: collision with root package name */
    public String f71044f;

    /* loaded from: classes9.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f71045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f71046f;

        public a(b bVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71046f = bVar;
            this.f71045e = zArr;
        }

        @Override // d.a.y0.i.j
        public void a(MediaFormat mediaFormat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaFormat) == null) {
                this.f71045e[0] = true;
                this.f71046f.l(mediaFormat);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-514527245, "Ld/a/y0/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-514527245, "Ld/a/y0/h/b;");
        }
    }

    public b(String str) {
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
        this.f71039a = str;
        j(str);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b bVar = new b("");
            bVar.f71041c = 2;
            bVar.f71044f = "audio/mp4a-latm";
            bVar.f71040b = 44100;
            bVar.f71042d = 16;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71042d : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71041c : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71043e / 1000 : invokeV.longValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof b) && k((b) obj) == 0 : invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71044f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71040b : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71039a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.f71042d + this.f71040b + this.f71041c;
            String str = this.f71044f;
            return i2 + (str != null ? str.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f71044f) || this.f71040b == 0 || this.f71041c == 0 || this.f71042d == 0 || this.f71043e == 0) ? false : true : invokeV.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                if (m(str)) {
                    boolean[] zArr = {false};
                    i iVar = new i(str);
                    iVar.k(new a(this, zArr));
                    while (!zArr[0]) {
                        if (iVar.c()) {
                            zArr[0] = true;
                        }
                    }
                    iVar.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int k(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            if (bVar == null) {
                return 0;
            }
            int i2 = bVar.f71042d != this.f71042d ? 0 | f71036g : 0;
            if (bVar.f71040b != this.f71040b) {
                i2 |= f71037h;
            }
            if (bVar.f71041c != this.f71041c) {
                i2 |= f71038i;
            }
            return !TextUtils.equals(bVar.f71044f, this.f71044f) ? i2 | j : i2;
        }
        return invokeL.intValue;
    }

    public final boolean l(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mediaFormat)) == null) {
            try {
                this.f71040b = mediaFormat.getInteger("sample-rate");
                this.f71041c = mediaFormat.getInteger("channel-count");
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
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
                        if (trackFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                            mediaExtractor.selectTrack(i2);
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    try {
                        if (mediaFormat == null) {
                            return false;
                        }
                        this.f71044f = mediaFormat.getString(IMediaFormat.KEY_MIME);
                        this.f71040b = mediaFormat.getInteger("sample-rate");
                        this.f71041c = mediaFormat.getInteger("channel-count");
                        this.f71043e = mediaFormat.getLong("durationUs");
                        if (mediaFormat.containsKey("bit-width")) {
                            this.f71042d = mediaFormat.getInteger("bit-width");
                        } else {
                            this.f71042d = 16;
                        }
                        if (mediaFormat.containsKey("aac-profile")) {
                            if (mediaFormat.getInteger("aac-profile") != 2) {
                                z = true;
                            }
                        }
                        return z;
                    } catch (Exception e2) {
                        d.a.y0.t.c.e("VideoMuxer", "initAudioProperty error:" + e2.getMessage());
                        return false;
                    } finally {
                        mediaExtractor.release();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
