package d.a.o0.r.g0.c;

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
    public int f52450a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52451b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f52452c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f52453d;

    /* renamed from: e  reason: collision with root package name */
    public File f52454e;

    /* renamed from: f  reason: collision with root package name */
    public int f52455f;

    /* renamed from: g  reason: collision with root package name */
    public int f52456g;

    /* renamed from: h  reason: collision with root package name */
    public int f52457h;

    /* renamed from: i  reason: collision with root package name */
    public int f52458i;
    public short j;
    public short k;

    /* renamed from: d.a.o0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1207a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52459e;

        public RunnableC1207a(a aVar) {
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
            this.f52459e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52459e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1102325882, "Ld/a/o0/r/g0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1102325882, "Ld/a/o0/r/g0/c/a;");
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
        this.f52450a = 0;
        this.f52451b = false;
        this.f52452c = null;
        this.f52454e = null;
    }

    @Override // d.a.o0.r.g0.c.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52451b = false;
        }
    }

    @Override // d.a.o0.r.g0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52451b : invokeV.booleanValue;
    }

    @Override // d.a.o0.r.g0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // d.a.o0.r.g0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC1207a(this));
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
            this.f52450a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
            this.f52456g = i3;
            this.f52457h = i4;
            this.f52458i = i5;
            AudioRecord audioRecord = this.f52452c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f52452c = new AudioRecord(i2, this.f52456g, this.f52457h, this.f52458i, this.f52450a);
            this.j = (short) (this.f52457h == 12 ? 2 : 1);
            this.k = (short) (this.f52458i == 2 ? 16 : 8);
            File file = new File(str);
            this.f52454e = file;
            if (file.exists()) {
                this.f52454e.delete();
            }
            try {
                this.f52454e.createNewFile();
                RandomAccessFile randomAccessFile = this.f52453d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f52453d = new RandomAccessFile(this.f52454e, "rw");
                    i();
                    f(this.f52454e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f52454e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f52452c) == null || this.f52454e == null) {
            return;
        }
        try {
            this.f52451b = true;
            int i2 = this.f52450a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f52451b) {
                this.f52452c.read(bArr, 0, i2);
                this.f52453d.write(bArr);
                this.f52455f += i2;
            }
            this.f52453d.seek(4L);
            this.f52453d.writeInt(Integer.reverseBytes(this.f52455f + 36));
            this.f52453d.seek(40L);
            this.f52453d.writeInt(Integer.reverseBytes(this.f52455f));
            this.f52453d.close();
            this.f52452c.stop();
            this.f52452c.release();
            this.f52451b = false;
        } catch (Throwable unused) {
            if (this.f52454e.exists()) {
                this.f52454e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f52453d.setLength(0L);
                this.f52453d.writeBytes(com.baidu.wallet.base.audio.b.f23950e);
                this.f52453d.writeInt(0);
                this.f52453d.writeBytes(com.baidu.wallet.base.audio.b.f23951f);
                this.f52453d.writeBytes(com.baidu.wallet.base.audio.b.f23952g);
                this.f52453d.writeInt(Integer.reverseBytes(16));
                this.f52453d.writeShort(Short.reverseBytes((short) 1));
                this.f52453d.writeShort(Short.reverseBytes(this.j));
                this.f52453d.writeInt(Integer.reverseBytes(this.f52456g));
                this.f52453d.writeInt(Integer.reverseBytes(((this.f52456g * this.j) * this.k) / 8));
                this.f52453d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
                this.f52453d.writeShort(Short.reverseBytes(this.k));
                this.f52453d.writeBytes("data");
                this.f52453d.writeInt(0);
            } catch (IOException e2) {
                if (this.f52454e.exists()) {
                    this.f52454e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
