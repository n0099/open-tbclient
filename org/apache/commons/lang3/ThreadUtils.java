package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes3.dex */
public class ThreadUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.apache.commons.lang3.ThreadUtils$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ AlwaysTruePredicate(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thread)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadGroup)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public AlwaysTruePredicate() {
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
    }

    /* loaded from: classes3.dex */
    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;

        public NamePredicate(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (str != null) {
                this.name = str;
                return;
            }
            throw new IllegalArgumentException("The name must not be null");
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadGroup)) == null) ? threadGroup != null && threadGroup.getName().equals(this.name) : invokeL.booleanValue;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thread)) == null) ? thread != null && thread.getName().equals(this.name) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface ThreadGroupPredicate {
        boolean test(ThreadGroup threadGroup);
    }

    /* loaded from: classes3.dex */
    public static class ThreadIdPredicate implements ThreadPredicate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long threadId;

        public ThreadIdPredicate(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (j > 0) {
                this.threadId = j;
                return;
            }
            throw new IllegalArgumentException("The thread id must be greater than zero");
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thread)) == null) ? thread != null && thread.getId() == this.threadId : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface ThreadPredicate {
        boolean test(Thread thread);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1232606191, "Lorg/apache/commons/lang3/ThreadUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1232606191, "Lorg/apache/commons/lang3/ThreadUtils;");
                return;
            }
        }
        ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate(null);
    }

    public ThreadUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Thread findThreadById(long j, ThreadGroup threadGroup) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, threadGroup)) == null) {
            if (threadGroup != null) {
                Thread findThreadById = findThreadById(j);
                if (findThreadById == null || !threadGroup.equals(findThreadById.getThreadGroup())) {
                    return null;
                }
                return findThreadById;
            }
            throw new IllegalArgumentException("The thread group must not be null");
        }
        return (Thread) invokeJL.objValue;
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, threadGroupPredicate)) == null) ? findThreadGroups(getSystemThreadGroup(), true, threadGroupPredicate) : (Collection) invokeL.objValue;
    }

    public static Collection<ThreadGroup> findThreadGroupsByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? findThreadGroups(new NamePredicate(str)) : (Collection) invokeL.objValue;
    }

    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadPredicate)) == null) ? findThreads(getSystemThreadGroup(), true, threadPredicate) : (Collection) invokeL.objValue;
    }

    public static Collection<Thread> findThreadsByName(String str, ThreadGroup threadGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, threadGroup)) == null) ? findThreads(threadGroup, false, new NamePredicate(str)) : (Collection) invokeLL.objValue;
    }

    public static Collection<ThreadGroup> getAllThreadGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? findThreadGroups(ALWAYS_TRUE_PREDICATE) : (Collection) invokeV.objValue;
    }

    public static Collection<Thread> getAllThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? findThreads(ALWAYS_TRUE_PREDICATE) : (Collection) invokeV.objValue;
    }

    public static ThreadGroup getSystemThreadGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup;
        }
        return (ThreadGroup) invokeV.objValue;
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, ThreadGroupPredicate threadGroupPredicate) {
        InterceptResult invokeCommon;
        ThreadGroup[] threadGroupArr;
        int enumerate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{threadGroup, Boolean.valueOf(z), threadGroupPredicate})) == null) {
            if (threadGroup != null) {
                if (threadGroupPredicate != null) {
                    int activeGroupCount = threadGroup.activeGroupCount();
                    while (true) {
                        int i2 = activeGroupCount + (activeGroupCount / 2) + 1;
                        threadGroupArr = new ThreadGroup[i2];
                        enumerate = threadGroup.enumerate(threadGroupArr, z);
                        if (enumerate < i2) {
                            break;
                        }
                        activeGroupCount = enumerate;
                    }
                    ArrayList arrayList = new ArrayList(enumerate);
                    for (int i3 = 0; i3 < enumerate; i3++) {
                        if (threadGroupPredicate.test(threadGroupArr[i3])) {
                            arrayList.add(threadGroupArr[i3]);
                        }
                    }
                    return Collections.unmodifiableCollection(arrayList);
                }
                throw new IllegalArgumentException("The predicate must not be null");
            }
            throw new IllegalArgumentException("The group must not be null");
        }
        return (Collection) invokeCommon.objValue;
    }

    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, ThreadPredicate threadPredicate) {
        InterceptResult invokeCommon;
        Thread[] threadArr;
        int enumerate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{threadGroup, Boolean.valueOf(z), threadPredicate})) == null) {
            if (threadGroup != null) {
                if (threadPredicate != null) {
                    int activeCount = threadGroup.activeCount();
                    while (true) {
                        int i2 = activeCount + (activeCount / 2) + 1;
                        threadArr = new Thread[i2];
                        enumerate = threadGroup.enumerate(threadArr, z);
                        if (enumerate < i2) {
                            break;
                        }
                        activeCount = enumerate;
                    }
                    ArrayList arrayList = new ArrayList(enumerate);
                    for (int i3 = 0; i3 < enumerate; i3++) {
                        if (threadPredicate.test(threadArr[i3])) {
                            arrayList.add(threadArr[i3]);
                        }
                    }
                    return Collections.unmodifiableCollection(arrayList);
                }
                throw new IllegalArgumentException("The predicate must not be null");
            }
            throw new IllegalArgumentException("The group must not be null");
        }
        return (Collection) invokeCommon.objValue;
    }

    public static Collection<Thread> findThreadsByName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            if (str != null) {
                if (str2 != null) {
                    Collection<ThreadGroup> findThreadGroups = findThreadGroups(new NamePredicate(str2));
                    if (findThreadGroups.isEmpty()) {
                        return Collections.emptyList();
                    }
                    ArrayList arrayList = new ArrayList();
                    NamePredicate namePredicate = new NamePredicate(str);
                    for (ThreadGroup threadGroup : findThreadGroups) {
                        arrayList.addAll(findThreads(threadGroup, false, namePredicate));
                    }
                    return Collections.unmodifiableCollection(arrayList);
                }
                throw new IllegalArgumentException("The thread group name must not be null");
            }
            throw new IllegalArgumentException("The thread name must not be null");
        }
        return (Collection) invokeLL.objValue;
    }

    public static Thread findThreadById(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, str)) == null) {
            if (str != null) {
                Thread findThreadById = findThreadById(j);
                if (findThreadById == null || findThreadById.getThreadGroup() == null || !findThreadById.getThreadGroup().getName().equals(str)) {
                    return null;
                }
                return findThreadById;
            }
            throw new IllegalArgumentException("The thread group name must not be null");
        }
        return (Thread) invokeJL.objValue;
    }

    public static Thread findThreadById(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            Collection<Thread> findThreads = findThreads(new ThreadIdPredicate(j));
            if (findThreads.isEmpty()) {
                return null;
            }
            return findThreads.iterator().next();
        }
        return (Thread) invokeJ.objValue;
    }

    public static Collection<Thread> findThreadsByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? findThreads(new NamePredicate(str)) : (Collection) invokeL.objValue;
    }
}
