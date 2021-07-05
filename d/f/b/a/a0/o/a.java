package d.f.b.a.a0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes10.dex */
public final class a implements d.f.b.a.a0.o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f72149a;

    /* renamed from: b  reason: collision with root package name */
    public final Stack<b> f72150b;

    /* renamed from: c  reason: collision with root package name */
    public final f f72151c;

    /* renamed from: d  reason: collision with root package name */
    public c f72152d;

    /* renamed from: e  reason: collision with root package name */
    public int f72153e;

    /* renamed from: f  reason: collision with root package name */
    public int f72154f;

    /* renamed from: g  reason: collision with root package name */
    public long f72155g;

    /* renamed from: d.f.b.a.a0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C2002a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f72156a;

        /* renamed from: b  reason: collision with root package name */
        public final long f72157b;

        public /* synthetic */ b(int i2, long j, C2002a c2002a) {
            this(i2, j);
        }

        public b(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72156a = i2;
            this.f72157b = j;
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
        this.f72149a = new byte[8];
        this.f72150b = new Stack<>();
        this.f72151c = new f();
    }

    @Override // d.f.b.a.a0.o.b
    public boolean a(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        d.f.b.a.i0.a.f(this.f72152d != null);
        while (true) {
            if (!this.f72150b.isEmpty() && fVar.getPosition() >= this.f72150b.peek().f72157b) {
                this.f72152d.a(this.f72150b.pop().f72156a);
                return true;
            }
            if (this.f72153e == 0) {
                long d2 = this.f72151c.d(fVar, true, false, 4);
                if (d2 == -2) {
                    d2 = c(fVar);
                }
                if (d2 == -1) {
                    return false;
                }
                this.f72154f = (int) d2;
                this.f72153e = 1;
            }
            if (this.f72153e == 1) {
                this.f72155g = this.f72151c.d(fVar, false, true, 8);
                this.f72153e = 2;
            }
            int g2 = this.f72152d.g(this.f72154f);
            if (g2 != 0) {
                if (g2 == 1) {
                    long position = fVar.getPosition();
                    this.f72150b.add(new b(this.f72154f, this.f72155g + position, null));
                    this.f72152d.f(this.f72154f, position, this.f72155g);
                    this.f72153e = 0;
                    return true;
                } else if (g2 == 2) {
                    long j = this.f72155g;
                    if (j <= 8) {
                        this.f72152d.c(this.f72154f, e(fVar, (int) j));
                        this.f72153e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f72155g);
                } else if (g2 == 3) {
                    long j2 = this.f72155g;
                    if (j2 <= 2147483647L) {
                        this.f72152d.e(this.f72154f, f(fVar, (int) j2));
                        this.f72153e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f72155g);
                } else if (g2 == 4) {
                    this.f72152d.d(this.f72154f, (int) this.f72155g, fVar);
                    this.f72153e = 0;
                    return true;
                } else if (g2 == 5) {
                    long j3 = this.f72155g;
                    if (j3 != 4 && j3 != 8) {
                        throw new ParserException("Invalid float size: " + this.f72155g);
                    }
                    this.f72152d.b(this.f72154f, d(fVar, (int) this.f72155g));
                    this.f72153e = 0;
                    return true;
                } else {
                    throw new ParserException("Invalid element type " + g2);
                }
            }
            fVar.h((int) this.f72155g);
            this.f72153e = 0;
        }
    }

    @Override // d.f.b.a.a0.o.b
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f72152d = cVar;
        }
    }

    public final long c(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) != null) {
            return invokeL.longValue;
        }
        fVar.e();
        while (true) {
            fVar.c(this.f72149a, 0, 4);
            int c2 = f.c(this.f72149a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) f.a(this.f72149a, c2, false);
                if (this.f72152d.h(a2)) {
                    fVar.h(c2);
                    return a2;
                }
            }
            fVar.h(1);
        }
    }

    public final double d(d.f.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, fVar, i2)) == null) {
            long e2 = e(fVar, i2);
            if (i2 == 4) {
                return Float.intBitsToFloat((int) e2);
            }
            return Double.longBitsToDouble(e2);
        }
        return invokeLI.doubleValue;
    }

    public final long e(d.f.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fVar, i2)) == null) {
            fVar.readFully(this.f72149a, 0, i2);
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j = (j << 8) | (this.f72149a[i3] & 255);
            }
            return j;
        }
        return invokeLI.longValue;
    }

    public final String f(d.f.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, fVar, i2)) == null) {
            if (i2 == 0) {
                return "";
            }
            byte[] bArr = new byte[i2];
            fVar.readFully(bArr, 0, i2);
            return new String(bArr);
        }
        return (String) invokeLI.objValue;
    }

    @Override // d.f.b.a.a0.o.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f72153e = 0;
            this.f72150b.clear();
            this.f72151c.e();
        }
    }
}
