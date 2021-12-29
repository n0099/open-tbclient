package rx.exceptions;

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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes4.dex */
public final class CompositeException extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3026362227162912146L;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable cause;
    public final List<Throwable> exceptions;
    public final String message;

    /* loaded from: classes4.dex */
    public static final class CompositeExceptionCausalChain extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        public static final long serialVersionUID = 3875212506787802066L;
        public transient /* synthetic */ FieldHolder $fh;

        public CompositeExceptionCausalChain() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Chain of Causes for CompositeException In Order Received =>" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public abstract Object a();

        public abstract void b(Object obj);
    }

    /* loaded from: classes4.dex */
    public static final class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PrintStream a;

        public b(PrintStream printStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = printStream;
        }

        @Override // rx.exceptions.CompositeException.a
        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.objValue;
        }

        @Override // rx.exceptions.CompositeException.a
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.a.println(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PrintWriter a;

        public c(PrintWriter printWriter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {printWriter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = printWriter;
        }

        @Override // rx.exceptions.CompositeException.a
        public Object a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.objValue;
        }

        @Override // rx.exceptions.CompositeException.a
        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.a.println(obj);
            }
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, collection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, sb, th, str) == null) {
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

    private List<Throwable> getListOfCauses(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, th)) == null) {
            ArrayList arrayList = new ArrayList();
            Throwable cause = th.getCause();
            if (cause != null && cause != th) {
                while (true) {
                    arrayList.add(cause);
                    Throwable cause2 = cause.getCause();
                    if (cause2 == null || cause2 == cause) {
                        break;
                    }
                    cause = cause.getCause();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private Throwable getRootCause(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, th)) == null) {
            Throwable cause = th.getCause();
            if (cause == null || cause == th) {
                return th;
            }
            while (true) {
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause.getCause();
            }
            return cause;
        }
        return (Throwable) invokeL.objValue;
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
                    Iterator<Throwable> it = this.exceptions.iterator();
                    CompositeExceptionCausalChain compositeExceptionCausalChain2 = compositeExceptionCausalChain;
                    while (it.hasNext()) {
                        Throwable next = it.next();
                        if (!hashSet.contains(next)) {
                            hashSet.add(next);
                            for (Throwable th2 : getListOfCauses(next)) {
                                if (hashSet.contains(th2)) {
                                    next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                                } else {
                                    hashSet.add(th2);
                                }
                            }
                            try {
                                compositeExceptionCausalChain2.initCause(next);
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

    public List<Throwable> getExceptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.exceptions : (List) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            printStackTrace(System.err);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, printStream) == null) {
            printStackTrace(new b(printStream));
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, printWriter) == null) {
            printStackTrace(new c(printWriter));
        }
    }

    private void printStackTrace(a aVar) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(this);
            sb.append('\n');
            for (StackTraceElement stackTraceElement : getStackTrace()) {
                sb.append("\tat ");
                sb.append(stackTraceElement);
                sb.append('\n');
            }
            int i2 = 1;
            for (Throwable th : this.exceptions) {
                sb.append("  ComposedException ");
                sb.append(i2);
                sb.append(" :\n");
                appendStackTrace(sb, th, "\t");
                i2++;
            }
            synchronized (aVar.a()) {
                aVar.b(sb.toString());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Collection) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public CompositeException(Throwable... thArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }
}
