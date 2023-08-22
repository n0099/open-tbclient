package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder a;
    public String b;
    public String c;
    public int d;
    public long e;
    public long f;
    public String g;
    public int h;
    public int i;
    public int j;

    public c(int i, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new StringBuilder();
        this.b = null;
        this.c = "HMS";
        this.d = 0;
        this.e = 0L;
        this.f = 0L;
        this.j = 0;
        this.j = i;
        this.b = str;
        this.d = i2;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            return String.valueOf(i);
                        }
                        return ExifInterface.LONGITUDE_EAST;
                    }
                    return ExifInterface.LONGITUDE_WEST;
                }
                return "I";
            }
            return "D";
        }
        return (String) invokeI.objValue;
    }

    public <T> c a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            this.a.append(t);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
            a((c) '\n').a((c) Log.getStackTraceString(th));
            return this;
        }
        return (c) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            b(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            b(sb);
            a(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final StringBuilder a(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sb)) == null) {
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(this.a.toString());
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public final c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.e = System.currentTimeMillis();
            Thread currentThread = Thread.currentThread();
            this.f = currentThread.getId();
            this.h = Process.myPid();
            StackTraceElement[] stackTrace = currentThread.getStackTrace();
            int length = stackTrace.length;
            int i = this.j;
            if (length > i) {
                StackTraceElement stackTraceElement = stackTrace[i];
                this.g = stackTraceElement.getFileName();
                this.i = stackTraceElement.getLineNumber();
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public final StringBuilder b(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sb)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            sb.append('[');
            sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
            String a = a(this.d);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(a);
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(this.c);
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(this.b);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(this.h);
            sb.append(':');
            sb.append(this.f);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(this.g);
            sb.append(':');
            sb.append(this.i);
            sb.append(']');
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }
}
