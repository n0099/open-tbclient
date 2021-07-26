package d.l.a.e.a.h.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.f.a.h;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f72101a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f72102b;

    /* renamed from: c  reason: collision with root package name */
    public e f72103c;

    /* renamed from: d  reason: collision with root package name */
    public C2038a f72104d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72105e;

    /* renamed from: f  reason: collision with root package name */
    public int f72106f;

    /* renamed from: g  reason: collision with root package name */
    public int f72107g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f72108h;

    /* renamed from: i  reason: collision with root package name */
    public int f72109i;

    /* renamed from: d.l.a.e.a.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C2038a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int[] f72110a;

        /* renamed from: b  reason: collision with root package name */
        public int f72111b;

        /* renamed from: c  reason: collision with root package name */
        public int f72112c;

        public C2038a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72110a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72111b = 0;
                this.f72112c = 0;
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int[] iArr = this.f72110a;
                int length = iArr.length;
                int i3 = this.f72111b;
                int i4 = length - i3;
                if (i4 <= i2) {
                    int[] iArr2 = new int[(iArr.length + i4) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i3);
                    this.f72110a = iArr2;
                }
            }
        }

        public final void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                if (this.f72112c == 0) {
                    g();
                }
                b(2);
                int i4 = this.f72111b;
                int i5 = i4 - 1;
                int[] iArr = this.f72110a;
                int i6 = iArr[i5];
                int i7 = i6 + 1;
                iArr[(i5 - 1) - (i6 * 2)] = i7;
                iArr[i5] = i2;
                iArr[i5 + 1] = i3;
                iArr[i5 + 2] = i7;
                this.f72111b = i4 + 2;
            }
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f72111b;
                if (i2 == 0) {
                    return 0;
                }
                return this.f72110a[i2 - 1];
            }
            return invokeV.intValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            int i2;
            int[] iArr;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i4 = this.f72111b;
                if (i4 == 0 || (i3 = (iArr = this.f72110a)[i4 - 1]) == 0) {
                    return false;
                }
                int i5 = i3 - 1;
                int i6 = i2 - 2;
                iArr[i6] = i5;
                iArr[i6 - ((i5 * 2) + 1)] = i5;
                this.f72111b = i4 - 2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72112c : invokeV.intValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                b(2);
                int i2 = this.f72111b;
                int[] iArr = this.f72110a;
                iArr[i2] = 0;
                iArr[i2 + 1] = 0;
                this.f72111b = i2 + 2;
                this.f72112c++;
            }
        }

        public final void h() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i2 = this.f72111b) == 0) {
                return;
            }
            int i3 = i2 - 1;
            int i4 = this.f72110a[i3] * 2;
            if ((i3 - 1) - i4 != 0) {
                this.f72111b = i2 - (i4 + 2);
                this.f72112c--;
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72102b = false;
        this.f72104d = new C2038a();
        k();
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f72108h[j(i2) + 1];
            return i3 == -1 ? "" : this.f72103c.c(i3);
        }
        return (String) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f72102b) {
            this.f72102b = false;
            this.f72101a.b();
            this.f72101a = null;
            this.f72103c = null;
            this.f72104d.a();
            k();
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, inputStream) == null) {
            b();
            if (inputStream != null) {
                this.f72101a = new c(inputStream, false);
            }
        }
    }

    @Override // d.l.a.e.a.h.a.f
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "XML line #" + c();
        }
        return (String) invokeV.objValue;
    }

    public int e() throws h, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f72101a != null) {
                try {
                    l();
                    return this.f72106f;
                } catch (IOException e2) {
                    b();
                    throw e2;
                }
            }
            throw new h("Parser is not opened.", this, null);
        }
        return invokeV.intValue;
    }

    @Override // d.l.a.e.a.h.a.f
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f72108h[j(i2) + 3] : invokeI.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f72108h[j(i2) + 4] : invokeI.intValue;
    }

    public String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int j = j(i2);
            int[] iArr = this.f72108h;
            if (iArr[j + 3] == 3) {
                return this.f72103c.c(iArr[j + 2]);
            }
            int i3 = iArr[j + 4];
            return "";
        }
        return (String) invokeI.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f72106f != 2) {
                return -1;
            }
            return this.f72108h.length / 5;
        }
        return invokeV.intValue;
    }

    public final int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.f72106f == 2) {
                int i3 = i2 * 5;
                if (i3 < this.f72108h.length) {
                    return i3;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        return invokeI.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f72106f = -1;
            this.f72107g = -1;
            this.f72108h = null;
            this.f72109i = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() throws IOException {
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f72103c == null) {
                b.a(this.f72101a, 524291);
                this.f72101a.g();
                this.f72103c = e.b(this.f72101a);
                this.f72104d.g();
                this.f72102b = true;
            }
            int i2 = this.f72106f;
            if (i2 != 1) {
                k();
                while (true) {
                    if (this.f72105e) {
                        this.f72105e = false;
                        this.f72104d.h();
                    }
                    int i3 = 3;
                    if (i2 == 3 && this.f72104d.f() == 1 && this.f72104d.d() == 0) {
                        this.f72106f = 1;
                        return;
                    }
                    int e3 = i2 == 0 ? 1048834 : this.f72101a.e();
                    if (e3 == 524672) {
                        e2 = this.f72101a.e();
                        if (e2 < 8 || e2 % 4 != 0) {
                            break;
                        }
                        this.f72101a.f((e2 / 4) - 2);
                    } else if (e3 < 1048832 || e3 > 1048836) {
                        break;
                    } else if (e3 == 1048834 && i2 == -1) {
                        this.f72106f = 0;
                        return;
                    } else {
                        this.f72101a.g();
                        int e4 = this.f72101a.e();
                        this.f72101a.g();
                        if (e3 != 1048832 && e3 != 1048833) {
                            this.f72107g = e4;
                            if (e3 == 1048834) {
                                this.f72101a.e();
                                this.f72101a.e();
                                this.f72101a.g();
                                int e5 = this.f72101a.e();
                                this.f72109i = e5;
                                this.f72109i = (65535 & e5) - 1;
                                this.f72108h = this.f72101a.f((this.f72101a.e() & 65535) * 5);
                                while (true) {
                                    int[] iArr = this.f72108h;
                                    if (i3 < iArr.length) {
                                        iArr[i3] = iArr[i3] >>> 24;
                                        i3 += 5;
                                    } else {
                                        this.f72104d.g();
                                        this.f72106f = 2;
                                        return;
                                    }
                                }
                            } else if (e3 == 1048835) {
                                this.f72101a.e();
                                this.f72101a.e();
                                this.f72106f = 3;
                                this.f72105e = true;
                                return;
                            } else if (e3 == 1048836) {
                                this.f72101a.e();
                                this.f72101a.g();
                                this.f72101a.g();
                                this.f72106f = 4;
                                return;
                            }
                        } else if (e3 == 1048832) {
                            this.f72104d.c(this.f72101a.e(), this.f72101a.e());
                        } else {
                            this.f72101a.g();
                            this.f72101a.g();
                            this.f72104d.e();
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + e2 + ").");
            }
        }
    }

    @Override // d.l.a.e.a.h.a.f
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72107g : invokeV.intValue;
    }
}
