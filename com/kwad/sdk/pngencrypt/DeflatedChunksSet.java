package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes10.dex */
public class DeflatedChunksSet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f73077a;

    /* renamed from: b  reason: collision with root package name */
    public State f73078b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f73079c;

    /* renamed from: d  reason: collision with root package name */
    public int f73080d;

    /* renamed from: e  reason: collision with root package name */
    public int f73081e;

    /* renamed from: f  reason: collision with root package name */
    public final String f73082f;

    /* renamed from: g  reason: collision with root package name */
    public int f73083g;

    /* renamed from: h  reason: collision with root package name */
    public int f73084h;

    /* renamed from: i  reason: collision with root package name */
    public int f73085i;

    /* renamed from: j  reason: collision with root package name */
    public Inflater f73086j;
    public final boolean k;
    public d l;
    public long m;
    public long n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State CLOSED;
        public static final State DONE;
        public static final State ROW_READY;
        public static final State WAITING_FOR_INPUT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1281842589, "Lcom/kwad/sdk/pngencrypt/DeflatedChunksSet$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1281842589, "Lcom/kwad/sdk/pngencrypt/DeflatedChunksSet$State;");
                    return;
                }
            }
            WAITING_FOR_INPUT = new State("WAITING_FOR_INPUT", 0);
            ROW_READY = new State("ROW_READY", 1);
            DONE = new State(AdDownloadApkUtils.DL_STATUS_DONE, 2);
            State state = new State("CLOSED", 3);
            CLOSED = state;
            $VALUES = new State[]{WAITING_FOR_INPUT, ROW_READY, DONE, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }

        public boolean isClosed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this == CLOSED : invokeV.booleanValue;
        }

        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == DONE || this == CLOSED : invokeV.booleanValue;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i2, int i3, Inflater inflater, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), inflater, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73078b = State.WAITING_FOR_INPUT;
        this.m = 0L;
        this.n = 0L;
        this.f73080d = -1;
        this.f73081e = -1;
        this.f73082f = str;
        this.f73079c = z;
        this.f73084h = i2;
        boolean z2 = true;
        if (i2 < 1 || i3 < i2) {
            throw new PngjException("bad inital row len " + i2);
        }
        if (inflater != null) {
            this.f73086j = inflater;
            z2 = false;
        } else {
            this.f73086j = new Inflater();
        }
        this.k = z2;
        this.f73077a = (bArr == null || bArr.length < i2) ? new byte[i3] : bArr;
        this.f73085i = -1;
        this.f73078b = State.WAITING_FOR_INPUT;
        try {
            a(i2);
        } catch (RuntimeException e2) {
            f();
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: RuntimeException -> 0x008b, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x008b, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0014, B:10:0x001e, B:12:0x0022, B:15:0x002f, B:17:0x0035, B:19:0x003d, B:23:0x0059, B:22:0x004e, B:24:0x0064, B:26:0x006a, B:34:0x007f, B:36:0x0085, B:27:0x006d, B:29:0x0075, B:30:0x0078, B:33:0x007d, B:14:0x0029), top: B:49:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        State state;
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, this)) != null) {
            return invokeV.booleanValue;
        }
        try {
            if (this.f73078b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("invalid state"));
            }
            if (this.f73078b.isDone()) {
                return false;
            }
            if (this.f73077a == null || this.f73077a.length < this.f73084h) {
                this.f73077a = new byte[this.f73084h];
            }
            if (this.f73083g < this.f73084h && !this.f73086j.finished()) {
                try {
                    i2 = this.f73086j.inflate(this.f73077a, this.f73083g, this.f73084h - this.f73083g);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.d.a.a(new PngjException("error decompressing zlib stream ", e2));
                    i2 = 0;
                }
                this.f73083g += i2;
                this.n += i2;
            }
            if (this.f73083g != this.f73084h) {
                if (!this.f73086j.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.f73083g <= 0) {
                    state = State.DONE;
                }
                this.f73078b = state;
                if (state != State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.f73078b = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e3) {
            f();
            throw e3;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f73083g = 0;
            this.f73085i++;
            if (i2 < 1 || this.f73086j.finished()) {
                this.f73084h = 0;
                g();
                return;
            }
            this.f73078b = State.WAITING_FOR_INPUT;
            this.f73084h = i2;
            if (this.f73079c) {
                return;
            }
            i();
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            if (!this.f73082f.equals(dVar.a().f73142c)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().f73142c + ", expected:" + this.f73082f));
            }
            this.l = dVar;
            int i2 = this.f73080d + 1;
            this.f73080d = i2;
            int i3 = this.f73081e;
            if (i3 >= 0) {
                dVar.a(i2 + i3);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
            this.m += i3;
            if (i3 < 1 || this.f73078b.isDone()) {
                return;
            }
            if (this.f73078b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("this should only be called if waitingForMoreInput"));
            }
            if (this.f73086j.needsDictionary() || !this.f73086j.needsInput()) {
                throw new RuntimeException("should not happen");
            }
            this.f73086j.setInput(bArr, i2, i3);
            if (!this.f73079c) {
                i();
                return;
            }
            while (i()) {
                a(b());
                if (d()) {
                    c();
                }
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.f73078b.isClosed()) {
                return false;
            }
            if (str.equals(this.f73082f) || b(str)) {
                return true;
            }
            if (this.f73078b.isDone()) {
                if (!this.f73078b.isClosed()) {
                    f();
                }
                return false;
            }
            throw new PngjException("Unexpected chunk " + str + " while " + this.f73082f + " set is not done");
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new PngjException("not implemented");
        }
        return invokeV.intValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f73078b.isDone() : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f73078b.isClosed() : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                if (!this.f73078b.isClosed()) {
                    this.f73078b = State.CLOSED;
                }
                if (!this.k || this.f73086j == null) {
                    return;
                }
                this.f73086j.end();
                this.f73086j = null;
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || d()) {
            return;
        }
        this.f73078b = State.DONE;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f73085i : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new StringBuilder("idatSet : " + this.l.a().f73142c + " state=" + this.f73078b + " rows=" + this.f73085i + " bytes=" + this.m + "/" + this.n).toString();
        }
        return (String) invokeV.objValue;
    }
}
