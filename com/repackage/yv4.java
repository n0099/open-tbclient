package com.repackage;

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
public class yv4 implements bw4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public AudioRecord c;
    public RandomAccessFile d;
    public File e;
    public int f;
    public int g;
    public int h;
    public int i;
    public short j;
    public short k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;

        public a(yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755128358, "Lcom/repackage/yv4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755128358, "Lcom/repackage/yv4;");
        }
    }

    public yv4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = false;
        this.c = null;
        this.e = null;
    }

    @Override // com.repackage.bw4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = false;
        }
    }

    @Override // com.repackage.bw4
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.booleanValue;
    }

    @Override // com.repackage.bw4
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // com.repackage.bw4
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new a(this));
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

    public boolean g(int i, int i2, int i3, int i4, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str})) == null) {
            this.a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            AudioRecord audioRecord = this.c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.c = new AudioRecord(i, this.g, this.h, this.i, this.a);
            this.j = (short) (this.h == 12 ? 2 : 1);
            this.k = (short) (this.i == 2 ? 16 : 8);
            File file = new File(str);
            this.e = file;
            if (file.exists()) {
                this.e.delete();
            }
            try {
                this.e.createNewFile();
                RandomAccessFile randomAccessFile = this.d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.d = new RandomAccessFile(this.e, "rw");
                    i();
                    f(this.e.getParent());
                    return true;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.c) == null || this.e == null) {
            return;
        }
        try {
            this.b = true;
            int i = this.a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.b) {
                this.c.read(bArr, 0, i);
                this.d.write(bArr);
                this.f += i;
            }
            this.d.seek(4L);
            this.d.writeInt(Integer.reverseBytes(this.f + 36));
            this.d.seek(40L);
            this.d.writeInt(Integer.reverseBytes(this.f));
            this.d.close();
            this.c.stop();
            this.c.release();
            this.b = false;
        } catch (Throwable unused) {
            if (this.e.exists()) {
                this.e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.d.setLength(0L);
                this.d.writeBytes("RIFF");
                this.d.writeInt(0);
                this.d.writeBytes("WAVE");
                this.d.writeBytes("fmt ");
                this.d.writeInt(Integer.reverseBytes(16));
                this.d.writeShort(Short.reverseBytes((short) 1));
                this.d.writeShort(Short.reverseBytes(this.j));
                this.d.writeInt(Integer.reverseBytes(this.g));
                this.d.writeInt(Integer.reverseBytes(((this.g * this.j) * this.k) / 8));
                this.d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
                this.d.writeShort(Short.reverseBytes(this.k));
                this.d.writeBytes("data");
                this.d.writeInt(0);
            } catch (IOException e) {
                if (this.e.exists()) {
                    this.e.delete();
                }
                e.printStackTrace();
            }
        }
    }
}
