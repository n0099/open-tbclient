package d.a.d.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class c extends DiskFileOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f41522a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f41523b;

    /* renamed from: c  reason: collision with root package name */
    public a f41524c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41525d;

    /* renamed from: e  reason: collision with root package name */
    public long f41526e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: d  reason: collision with root package name */
        public static byte f41527d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f41528e = Byte.MIN_VALUE;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f41529a;

        /* renamed from: b  reason: collision with root package name */
        public long f41530b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41531c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1575145844, "Ld/a/d/e/a/f/c$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575145844, "Ld/a/d/e/a/f/c$a;");
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
            this.f41529a = false;
            this.f41530b = 0L;
            this.f41531c = true;
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 14;
            }
            return invokeV.intValue;
        }

        public boolean b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null || bArr.length < a()) {
                    return false;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
                if (wrap.getInt() != 1786600511) {
                    return false;
                }
                if ((wrap.get() & f41527d) != 0) {
                    this.f41529a = true;
                }
                this.f41530b = wrap.getLong();
                if ((wrap.get() & f41528e) != 0) {
                    this.f41531c = false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public byte[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ByteBuffer allocate = ByteBuffer.allocate(a());
                allocate.putInt(1786600511);
                allocate.put(this.f41529a ? (byte) (f41527d | 0) : (byte) 0);
                allocate.putLong(this.f41530b);
                allocate.put(this.f41531c ? (byte) 0 : (byte) (f41528e | 0));
                allocate.flip();
                return allocate.array();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41522a = null;
        this.f41523b = null;
        this.f41524c = null;
        this.f41525d = true;
        this.f41524c = new a();
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public boolean b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (bArr != null && this.f41524c.b(bArr)) {
                long j = this.f41524c.f41530b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    int a2 = a.a();
                    try {
                        if (this.f41523b == null) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            this.f41523b = options;
                            options.inPreferredConfig = Bitmap.Config.RGB_565;
                        }
                        this.f41523b.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f41523b);
                    } catch (Error e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (!this.f41523b.mCancel && this.f41523b.outWidth != -1 && this.f41523b.outHeight != -1) {
                        this.f41523b.inSampleSize = a(this.f41523b, i2, i3);
                        this.f41523b.inJustDecodeBounds = false;
                        this.f41522a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f41523b);
                        return this.f41522a != null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mData == null || !this.f41525d) {
                return null;
            }
            return this.f41524c.c();
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int a2 = a.a();
            int length = this.mData.length - a2;
            byte[] bArr = new byte[length];
            System.arraycopy(this.mData, a2, bArr, 0, length);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41524c.f41531c : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f41524c.f41531c = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.d.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f41526e);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f41525d = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (bArr != null && this.f41524c.b(bArr)) {
                long j = this.f41524c.f41530b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    if (this.f41523b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.f41523b = options;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    int a2 = a.a();
                    try {
                        this.f41522a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f41523b);
                    } catch (Error e2) {
                        BdLog.e(e2.getMessage());
                    }
                    return this.f41522a != null;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41522a : (Bitmap) invokeV.objValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f41524c.f41529a : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bArr) == null) {
            super.setData(bArr);
            if (isGif() || !l.B(bArr)) {
                return;
            }
            setGif(true);
        }
    }

    public void setGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f41524c.f41529a = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f41526e = System.currentTimeMillis();
        }
    }
}
