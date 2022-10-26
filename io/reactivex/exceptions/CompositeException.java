package io.reactivex.exceptions;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes8.dex */
public final class CompositeException extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3026362227162912146L;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable cause;
    public final List exceptions;
    public final String message;

    /* loaded from: classes8.dex */
    public final class CompositeExceptionCausalChain extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        public static final long serialVersionUID = 3875212506787802066L;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.lang.Throwable
        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Chain of Causes for CompositeException In Order Received =>" : (String) invokeV.objValue;
        }

        public CompositeExceptionCausalChain() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class PrintStreamOrWriter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void println(Object obj);

        public PrintStreamOrWriter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class WrappedPrintStream extends PrintStreamOrWriter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PrintStream printStream;

        public WrappedPrintStream(PrintStream printStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.printStream = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        public void println(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.printStream.println(obj);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class WrappedPrintWriter extends PrintStreamOrWriter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PrintWriter printWriter;

        public WrappedPrintWriter(PrintWriter printWriter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printWriter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.printWriter = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        public void println(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.printWriter.println(obj);
            }
        }
    }

    public CompositeException(Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            this.message = this.exceptions.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CompositeException(Throwable... thArr) {
        this(r7);
        List asList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Iterable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (thArr == null) {
            asList = Collections.singletonList(new NullPointerException("exceptions was null"));
        } else {
            asList = Arrays.asList(thArr);
        }
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, sb, th, str) == null) {
            sb.append(str);
            sb.append(th);
            sb.append('\n');
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append("\t\tat ");
                sb.append(stackTraceElement);
                sb.append('\n');
            }
            if (th.getCause() != null) {
                sb.append("\tCaused by: ");
                appendStackTrace(sb, th.getCause(), "");
            }
        }
    }

    private List getListOfCauses(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, th)) == null) {
            ArrayList arrayList = new ArrayList();
            Throwable cause = th.getCause();
            if (cause != null && cause != th) {
                while (true) {
                    arrayList.add(cause);
                    Throwable cause2 = cause.getCause();
                    if (cause2 == null || cause2 == cause) {
                        break;
                    }
                    cause = cause2;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public Throwable getRootCause(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) {
            Throwable cause = th.getCause();
            if (cause != null && this.cause != cause) {
                while (true) {
                    Throwable cause2 = cause.getCause();
                    if (cause2 == null || cause2 == cause) {
                        break;
                    }
                    cause = cause2;
                }
                return cause;
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, printStream) == null) {
            printStackTrace(new WrappedPrintStream(printStream));
        }
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, printStreamOrWriter) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(this);
            sb.append('\n');
            for (StackTraceElement stackTraceElement : getStackTrace()) {
                sb.append("\tat ");
                sb.append(stackTraceElement);
                sb.append('\n');
            }
            int i = 1;
            for (Throwable th : this.exceptions) {
                sb.append("  ComposedException ");
                sb.append(i);
                sb.append(" :\n");
                appendStackTrace(sb, th, "\t");
                i++;
            }
            printStreamOrWriter.println(sb.toString());
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        InterceptResult invokeV;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.cause == null) {
                    CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
                    HashSet hashSet = new HashSet();
                    CompositeExceptionCausalChain compositeExceptionCausalChain2 = compositeExceptionCausalChain;
                    for (Throwable th2 : this.exceptions) {
                        if (!hashSet.contains(th2)) {
                            hashSet.add(th2);
                            for (Throwable th3 : getListOfCauses(th2)) {
                                if (hashSet.contains(th3)) {
                                    th2 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                                } else {
                                    hashSet.add(th3);
                                }
                            }
                            try {
                                compositeExceptionCausalChain2.initCause(th2);
                            } catch (Throwable unused) {
                            }
                            compositeExceptionCausalChain2 = getRootCause(compositeExceptionCausalChain2);
                        }
                    }
                    this.cause = compositeExceptionCausalChain;
                }
                th = this.cause;
            }
            return th;
        }
        return (Throwable) invokeV.objValue;
    }

    public List getExceptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.exceptions;
        }
        return (List) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.message;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            printStackTrace(System.err);
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.exceptions.size();
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, printWriter) == null) {
            printStackTrace(new WrappedPrintWriter(printWriter));
        }
    }
}
