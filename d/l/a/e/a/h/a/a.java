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
/* loaded from: classes10.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f74595a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f74596b;

    /* renamed from: c  reason: collision with root package name */
    public e f74597c;

    /* renamed from: d  reason: collision with root package name */
    public C2071a f74598d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74599e;

    /* renamed from: f  reason: collision with root package name */
    public int f74600f;

    /* renamed from: g  reason: collision with root package name */
    public int f74601g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f74602h;

    /* renamed from: i  reason: collision with root package name */
    public int f74603i;

    /* renamed from: d.l.a.e.a.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2071a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int[] f74604a;

        /* renamed from: b  reason: collision with root package name */
        public int f74605b;

        /* renamed from: c  reason: collision with root package name */
        public int f74606c;

        public C2071a() {
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
            this.f74604a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74605b = 0;
                this.f74606c = 0;
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int[] iArr = this.f74604a;
                int length = iArr.length;
                int i3 = this.f74605b;
                int i4 = length - i3;
                if (i4 <= i2) {
                    int[] iArr2 = new int[(iArr.length + i4) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i3);
                    this.f74604a = iArr2;
                }
            }
        }

        public final void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                if (this.f74606c == 0) {
                    g();
                }
                b(2);
                int i4 = this.f74605b;
                int i5 = i4 - 1;
                int[] iArr = this.f74604a;
                int i6 = iArr[i5];
                int i7 = i6 + 1;
                iArr[(i5 - 1) - (i6 * 2)] = i7;
                iArr[i5] = i2;
                iArr[i5 + 1] = i3;
                iArr[i5 + 2] = i7;
                this.f74605b = i4 + 2;
            }
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f74605b;
                if (i2 == 0) {
                    return 0;
                }
                return this.f74604a[i2 - 1];
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
                int i4 = this.f74605b;
                if (i4 == 0 || (i3 = (iArr = this.f74604a)[i4 - 1]) == 0) {
                    return false;
                }
                int i5 = i3 - 1;
                int i6 = i2 - 2;
                iArr[i6] = i5;
                iArr[i6 - ((i5 * 2) + 1)] = i5;
                this.f74605b = i4 - 2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f74606c : invokeV.intValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                b(2);
                int i2 = this.f74605b;
                int[] iArr = this.f74604a;
                iArr[i2] = 0;
                iArr[i2 + 1] = 0;
                this.f74605b = i2 + 2;
                this.f74606c++;
            }
        }

        public final void h() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i2 = this.f74605b) == 0) {
                return;
            }
            int i3 = i2 - 1;
            int i4 = this.f74604a[i3] * 2;
            if ((i3 - 1) - i4 != 0) {
                this.f74605b = i2 - (i4 + 2);
                this.f74606c--;
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
        this.f74596b = false;
        this.f74598d = new C2071a();
        k();
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f74602h[j(i2) + 1];
            return i3 == -1 ? "" : this.f74597c.c(i3);
        }
        return (String) invokeI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f74596b) {
            this.f74596b = false;
            this.f74595a.b();
            this.f74595a = null;
            this.f74597c = null;
            this.f74598d.a();
            k();
        }
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, inputStream) == null) {
            b();
            if (inputStream != null) {
                this.f74595a = new c(inputStream, false);
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
            if (this.f74595a != null) {
                try {
                    l();
                    return this.f74600f;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f74602h[j(i2) + 3] : invokeI.intValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f74602h[j(i2) + 4] : invokeI.intValue;
    }

    public String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int j = j(i2);
            int[] iArr = this.f74602h;
            if (iArr[j + 3] == 3) {
                return this.f74597c.c(iArr[j + 2]);
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
            if (this.f74600f != 2) {
                return -1;
            }
            return this.f74602h.length / 5;
        }
        return invokeV.intValue;
    }

    public final int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (this.f74600f == 2) {
                int i3 = i2 * 5;
                if (i3 < this.f74602h.length) {
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
            this.f74600f = -1;
            this.f74601g = -1;
            this.f74602h = null;
            this.f74603i = -1;
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
            if (this.f74597c == null) {
                b.a(this.f74595a, 524291);
                this.f74595a.g();
                this.f74597c = e.b(this.f74595a);
                this.f74598d.g();
                this.f74596b = true;
            }
            int i2 = this.f74600f;
            if (i2 != 1) {
                k();
                while (true) {
                    if (this.f74599e) {
                        this.f74599e = false;
                        this.f74598d.h();
                    }
                    int i3 = 3;
                    if (i2 == 3 && this.f74598d.f() == 1 && this.f74598d.d() == 0) {
                        this.f74600f = 1;
                        return;
                    }
                    int e3 = i2 == 0 ? 1048834 : this.f74595a.e();
                    if (e3 == 524672) {
                        e2 = this.f74595a.e();
                        if (e2 < 8 || e2 % 4 != 0) {
                            break;
                        }
                        this.f74595a.f((e2 / 4) - 2);
                    } else if (e3 < 1048832 || e3 > 1048836) {
                        break;
                    } else if (e3 == 1048834 && i2 == -1) {
                        this.f74600f = 0;
                        return;
                    } else {
                        this.f74595a.g();
                        int e4 = this.f74595a.e();
                        this.f74595a.g();
                        if (e3 != 1048832 && e3 != 1048833) {
                            this.f74601g = e4;
                            if (e3 == 1048834) {
                                this.f74595a.e();
                                this.f74595a.e();
                                this.f74595a.g();
                                int e5 = this.f74595a.e();
                                this.f74603i = e5;
                                this.f74603i = (65535 & e5) - 1;
                                this.f74602h = this.f74595a.f((this.f74595a.e() & 65535) * 5);
                                while (true) {
                                    int[] iArr = this.f74602h;
                                    if (i3 < iArr.length) {
                                        iArr[i3] = iArr[i3] >>> 24;
                                        i3 += 5;
                                    } else {
                                        this.f74598d.g();
                                        this.f74600f = 2;
                                        return;
                                    }
                                }
                            } else if (e3 == 1048835) {
                                this.f74595a.e();
                                this.f74595a.e();
                                this.f74600f = 3;
                                this.f74599e = true;
                                return;
                            } else if (e3 == 1048836) {
                                this.f74595a.e();
                                this.f74595a.g();
                                this.f74595a.g();
                                this.f74600f = 4;
                                return;
                            }
                        } else if (e3 == 1048832) {
                            this.f74598d.c(this.f74595a.e(), this.f74595a.e());
                        } else {
                            this.f74595a.g();
                            this.f74595a.g();
                            this.f74598d.e();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f74601g : invokeV.intValue;
    }
}
