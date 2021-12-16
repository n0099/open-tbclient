package com.ss.android.socialbase.appdownloader.f.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d f62122b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62123c;

    /* renamed from: d  reason: collision with root package name */
    public f f62124d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f62125e;

    /* renamed from: f  reason: collision with root package name */
    public C2172a f62126f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62127g;

    /* renamed from: h  reason: collision with root package name */
    public int f62128h;

    /* renamed from: i  reason: collision with root package name */
    public int f62129i;

    /* renamed from: j  reason: collision with root package name */
    public int f62130j;

    /* renamed from: k  reason: collision with root package name */
    public int f62131k;
    public int[] l;
    public int m;
    public int n;
    public int o;

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
        this.f62123c = false;
        this.f62126f = new C2172a();
        g();
    }

    private final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f62128h = -1;
            this.f62129i = -1;
            this.f62130j = -1;
            this.f62131k = -1;
            this.l = null;
            this.m = -1;
            this.n = -1;
            this.o = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0192, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h() throws IOException {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.f62124d == null) {
                b.a(this.f62122b, 524291);
                this.f62122b.c();
                this.f62124d = f.a(this.f62122b);
                this.f62126f.e();
                this.f62123c = true;
            }
            int i2 = this.f62128h;
            if (i2 != 1) {
                g();
                while (true) {
                    if (this.f62127g) {
                        this.f62127g = false;
                        this.f62126f.f();
                    }
                    int i3 = 3;
                    if (i2 == 3 && this.f62126f.d() == 1 && this.f62126f.b() == 0) {
                        this.f62128h = 1;
                        return;
                    }
                    int b3 = i2 == 0 ? 1048834 : this.f62122b.b();
                    if (b3 == 524672) {
                        b2 = this.f62122b.b();
                        if (b2 < 8 || b2 % 4 != 0) {
                            break;
                        }
                        this.f62125e = this.f62122b.b((b2 / 4) - 2);
                    } else if (b3 < 1048832 || b3 > 1048836) {
                        break;
                    } else if (b3 == 1048834 && i2 == -1) {
                        this.f62128h = 0;
                        return;
                    } else {
                        this.f62122b.c();
                        int b4 = this.f62122b.b();
                        this.f62122b.c();
                        if (b3 != 1048832 && b3 != 1048833) {
                            this.f62129i = b4;
                            if (b3 == 1048834) {
                                this.f62131k = this.f62122b.b();
                                this.f62130j = this.f62122b.b();
                                this.f62122b.c();
                                int b5 = this.f62122b.b();
                                this.m = (b5 >>> 16) - 1;
                                int b6 = this.f62122b.b();
                                this.n = b6;
                                this.o = (b6 >>> 16) - 1;
                                this.n = (65535 & b6) - 1;
                                this.l = this.f62122b.b((b5 & 65535) * 5);
                                while (true) {
                                    int[] iArr = this.l;
                                    if (i3 < iArr.length) {
                                        iArr[i3] = iArr[i3] >>> 24;
                                        i3 += 5;
                                    } else {
                                        this.f62126f.e();
                                        this.f62128h = 2;
                                        return;
                                    }
                                }
                            } else if (b3 == 1048835) {
                                this.f62131k = this.f62122b.b();
                                this.f62130j = this.f62122b.b();
                                this.f62128h = 3;
                                this.f62127g = true;
                                return;
                            } else if (b3 == 1048836) {
                                this.f62130j = this.f62122b.b();
                                this.f62122b.c();
                                this.f62122b.c();
                                this.f62128h = 4;
                                return;
                            }
                        } else if (b3 == 1048832) {
                            this.f62126f.a(this.f62122b.b(), this.f62122b.b());
                        } else {
                            this.f62122b.c();
                            this.f62122b.c();
                            this.f62126f.c();
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + b2 + ").");
            }
        }
    }

    public void a(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            a();
            if (inputStream != null) {
                this.f62122b = new d(inputStream, false);
            }
        }
    }

    public int b() throws h, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f62122b != null) {
                try {
                    h();
                    return this.f62128h;
                } catch (IOException e2) {
                    a();
                    throw e2;
                }
            }
            throw new h("Parser is not opened.", this, null);
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62129i : invokeV.intValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "XML line #" + c();
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f62128h != 2) {
                return -1;
            }
            return this.l.length / 5;
        }
        return invokeV.intValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C2172a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f62132b;

        /* renamed from: c  reason: collision with root package name */
        public int f62133c;

        public C2172a() {
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
            this.a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62132b = 0;
                this.f62133c = 0;
            }
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f62132b;
                if (i2 == 0) {
                    return 0;
                }
                return this.a[i2 - 1];
            }
            return invokeV.intValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            int i2;
            int[] iArr;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i4 = this.f62132b;
                if (i4 == 0 || (i3 = (iArr = this.a)[i4 - 1]) == 0) {
                    return false;
                }
                int i5 = i3 - 1;
                int i6 = i2 - 2;
                iArr[i6] = i5;
                iArr[i6 - ((i5 * 2) + 1)] = i5;
                this.f62132b = i4 - 2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62133c : invokeV.intValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                a(2);
                int i2 = this.f62132b;
                int[] iArr = this.a;
                iArr[i2] = 0;
                iArr[i2 + 1] = 0;
                this.f62132b = i2 + 2;
                this.f62133c++;
            }
        }

        public final void f() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (i2 = this.f62132b) == 0) {
                return;
            }
            int i3 = i2 - 1;
            int i4 = this.a[i3] * 2;
            if ((i3 - 1) - i4 != 0) {
                this.f62132b = i2 - (i4 + 2);
                this.f62133c--;
            }
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (this.f62133c == 0) {
                    e();
                }
                a(2);
                int i4 = this.f62132b;
                int i5 = i4 - 1;
                int[] iArr = this.a;
                int i6 = iArr[i5];
                int i7 = i6 + 1;
                iArr[(i5 - 1) - (i6 * 2)] = i7;
                iArr[i5] = i2;
                iArr[i5 + 1] = i3;
                iArr[i5 + 2] = i7;
                this.f62132b = i4 + 2;
            }
        }

        private void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
                int[] iArr = this.a;
                int length = iArr.length;
                int i3 = this.f62132b;
                int i4 = length - i3;
                if (i4 <= i2) {
                    int[] iArr2 = new int[(iArr.length + i4) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i3);
                    this.a = iArr2;
                }
            }
        }
    }

    private final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (this.f62128h == 2) {
                int i3 = i2 * 5;
                if (i3 < this.l.length) {
                    return i3;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        return invokeI.intValue;
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.l[e(i2) + 4] : invokeI.intValue;
    }

    public String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int e2 = e(i2);
            int[] iArr = this.l;
            if (iArr[e2 + 3] == 3) {
                return this.f62124d.a(iArr[e2 + 2]);
            }
            int i3 = iArr[e2 + 4];
            return "";
        }
        return (String) invokeI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f62123c) {
            this.f62123c = false;
            this.f62122b.a();
            this.f62122b = null;
            this.f62124d = null;
            this.f62125e = null;
            this.f62126f.a();
            g();
        }
    }

    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.l[e(i2) + 3] : invokeI.intValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.l[e(i2) + 1];
            return i3 == -1 ? "" : this.f62124d.a(i3);
        }
        return (String) invokeI.objValue;
    }
}
