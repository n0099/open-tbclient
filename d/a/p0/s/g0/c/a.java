package d.a.p0.s.g0.c;

import android.media.AudioRecord;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53114a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53115b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f53116c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f53117d;

    /* renamed from: e  reason: collision with root package name */
    public File f53118e;

    /* renamed from: f  reason: collision with root package name */
    public int f53119f;

    /* renamed from: g  reason: collision with root package name */
    public int f53120g;

    /* renamed from: h  reason: collision with root package name */
    public int f53121h;

    /* renamed from: i  reason: collision with root package name */
    public int f53122i;
    public short j;
    public short k;

    /* renamed from: d.a.p0.s.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1217a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53123e;

        public RunnableC1217a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53123e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53123e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1514269670, "Ld/a/p0/s/g0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1514269670, "Ld/a/p0/s/g0/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53114a = 0;
        this.f53115b = false;
        this.f53116c = null;
        this.f53118e = null;
    }

    @Override // d.a.p0.s.g0.c.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f53115b = false;
        }
    }

    @Override // d.a.p0.s.g0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53115b : invokeV.booleanValue;
    }

    @Override // d.a.p0.s.g0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // d.a.p0.s.g0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC1217a(this));
            thread.setPriority(10);
            thread.setDaemon(true);
            thread.start();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str})) == null) {
            this.f53114a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
            this.f53120g = i3;
            this.f53121h = i4;
            this.f53122i = i5;
            AudioRecord audioRecord = this.f53116c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f53116c = new AudioRecord(i2, this.f53120g, this.f53121h, this.f53122i, this.f53114a);
            this.j = (short) (this.f53121h == 12 ? 2 : 1);
            this.k = (short) (this.f53122i == 2 ? 16 : 8);
            File file = new File(str);
            this.f53118e = file;
            if (file.exists()) {
                this.f53118e.delete();
            }
            try {
                this.f53118e.createNewFile();
                RandomAccessFile randomAccessFile = this.f53117d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f53117d = new RandomAccessFile(this.f53118e, "rw");
                    i();
                    f(this.f53118e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f53118e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f53116c) == null || this.f53118e == null) {
            return;
        }
        try {
            this.f53115b = true;
            int i2 = this.f53114a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f53115b) {
                this.f53116c.read(bArr, 0, i2);
                this.f53117d.write(bArr);
                this.f53119f += i2;
            }
            this.f53117d.seek(4L);
            this.f53117d.writeInt(Integer.reverseBytes(this.f53119f + 36));
            this.f53117d.seek(40L);
            this.f53117d.writeInt(Integer.reverseBytes(this.f53119f));
            this.f53117d.close();
            this.f53116c.stop();
            this.f53116c.release();
            this.f53115b = false;
        } catch (Throwable unused) {
            if (this.f53118e.exists()) {
                this.f53118e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f53117d.setLength(0L);
                this.f53117d.writeBytes(com.baidu.wallet.base.audio.b.f24108e);
                this.f53117d.writeInt(0);
                this.f53117d.writeBytes(com.baidu.wallet.base.audio.b.f24109f);
                this.f53117d.writeBytes(com.baidu.wallet.base.audio.b.f24110g);
                this.f53117d.writeInt(Integer.reverseBytes(16));
                this.f53117d.writeShort(Short.reverseBytes((short) 1));
                this.f53117d.writeShort(Short.reverseBytes(this.j));
                this.f53117d.writeInt(Integer.reverseBytes(this.f53120g));
                this.f53117d.writeInt(Integer.reverseBytes(((this.f53120g * this.j) * this.k) / 8));
                this.f53117d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
                this.f53117d.writeShort(Short.reverseBytes(this.k));
                this.f53117d.writeBytes("data");
                this.f53117d.writeInt(0);
            } catch (IOException e2) {
                if (this.f53118e.exists()) {
                    this.f53118e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
